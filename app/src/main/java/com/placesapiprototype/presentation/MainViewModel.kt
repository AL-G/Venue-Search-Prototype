package com.placesapiprototype.presentation

import ResponseBase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.placesapiprototype.data.RepositoryImpl
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.ResultType
import com.placesapiprototype.data.remote.FoursquarePlacesApiService
import com.placesapiprototype.data.remote.RemoteDataSource
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel (
    private val searchCoffeeOutletsUseCase: GetCoffeeOutletsUseCase
) : ViewModel() {

    var coffeeOutlets: MutableLiveData<RequestResult<ResponseBase>>? = MutableLiveData()

    init {
        refreshLocalCoffeeOutlets()
    }

    fun refreshLocalCoffeeOutlets() {

        //isLoadingLiveData(true)
        viewModelScope.launch {
            val coffeeOutletResult: RequestResult<ResponseBase> = searchCoffeeOutletsUseCase.execute()
            if (coffeeOutletResult.resultType == ResultType.SUCCESS) {
                coffeeOutlets?.value = coffeeOutletResult
                //isLoadingLiveData(false)
            } else {
                coffeeOutlets?.value = coffeeOutletResult
                //isLoadingLiveData(false)
            }
        }

    }

}