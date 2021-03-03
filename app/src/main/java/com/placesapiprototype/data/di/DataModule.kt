package com.placesapiprototype.data.di

import com.placesapiprototype.data.Repository
import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.remote.FoursquarePlacesApiService
import com.placesapiprototype.data.remote.RemoteDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL_BASE = "https://api.punkapi.com/v2/"

//val retrofitModule = module {
//    single { provideRetrofitInstance() }
//}
//
//private fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
//    .baseUrl(URL_BASE)
//    .addConverterFactory(GsonConverterFactory.create())
//    .addCallAdapterFactory(CoroutineCallAdapterFactory())
//    .build()
//
//val placesApiModule = module {
//    factory { providePlacesApiService(retrofit = get()) }
//    factory { RemoteDataSource(foursquarePlacesApiService = get()) }
//    single {
//        RepositoryImpl(
//            remoteDataSource = get()
//        ) as Repository
//    }
//}
//
//private fun providePlacesApiService(retrofit: Retrofit): FoursquarePlacesApiService =
//    retrofit.create(FoursquarePlacesApiService::class.java)
//
//private fun provideGson(): Gson = GsonBuilder().setPrettyPrinting().create()

