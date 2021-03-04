package com.placesapiprototype.data.remote

import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.model.ResponseBase

class RemoteDataSource(private val foursquarePlacesApiService: FoursquarePlacesApiService) {

    lateinit var response: ResponseBase

    suspend fun getLocalCoffeeOutlets(latLong: String): RequestResult<ResponseBase> {

        return try {
            response = foursquarePlacesApiService.searchLocalCoffeeOutlets(latLong)
            RequestResult.success(response)
        } catch (ex: Exception) {
            RequestResult.error<Exception>(Exception())
        }
    }

}


