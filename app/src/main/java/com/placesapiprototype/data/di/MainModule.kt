package com.placesapiprototype.data.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.remote.FoursquarePlacesApiService
import com.placesapiprototype.data.remote.RemoteDataSource
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import com.placesapiprototype.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    single { provideRetrofitInstance() }

    single {
        RemoteDataSource(foursquarePlacesApiService = providePlacesApiService(retrofit = provideRetrofitInstance()))
    }
    single {
        RepositoryImpl(remoteDataSource = get())
    }
    factory { GetCoffeeOutletsUseCase(placesRepository = get()) }
    viewModel {
        MainViewModel(searchCoffeeOutletsUseCase = get())
    }
}

private fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
    .baseUrl("https://api.foursquare.com/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

private fun providePlacesApiService(retrofit: Retrofit): FoursquarePlacesApiService =
    retrofit.create(FoursquarePlacesApiService::class.java)