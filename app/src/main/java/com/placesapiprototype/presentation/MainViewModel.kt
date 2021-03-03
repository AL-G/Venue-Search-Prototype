package com.placesapiprototype.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.ResultType
import com.placesapiprototype.data.model.Items
import com.placesapiprototype.data.model.ResponseBase
import com.placesapiprototype.domain.usecase.GetCoffeeOutletsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchCoffeeOutletsUseCase: GetCoffeeOutletsUseCase
) : ViewModel() {

    var isLoading: MutableLiveData<Boolean>? = MutableLiveData<Boolean>()
    var coffeeOutlets: MutableLiveData<List<Items>>? = MutableLiveData()
    private var errorMessages: MutableLiveData<String>? = MutableLiveData<String>()

    var lat: Double = 0.0
    var long: Double = 0.0

    init {
        isLoading?.value = true
        getLatitudeAndLongitude()
        refreshLocalCoffeeOutlets()
    }

    private fun refreshLocalCoffeeOutlets() {

        isLoading?.value = true
        viewModelScope.launch {
            val coffeeOutletResult: RequestResult<ResponseBase> =
                searchCoffeeOutletsUseCase.execute()
            if (coffeeOutletResult.resultType == ResultType.SUCCESS) {

                val venueList =
                    coffeeOutletResult.data?.response?.groups?.get(0)?.items as MutableList<Items>

                // reorder venues into ascending order by distance
                fun selector(i: Items): Int = i.venue.location.distance
                venueList.sortBy { selector(it) }
                coffeeOutlets?.value = venueList
                isLoading?.value = false
            } else {
                errorMessages?.value = coffeeOutletResult.error?.localizedMessage
                isLoading?.value = false
            }
        }
    }

    fun getLatitudeAndLongitude() {

    }

}