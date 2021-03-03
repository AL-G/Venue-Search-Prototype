package com.placesapiprototype.data.remote

import ResponseBase
import com.placesapiprototype.data.RequestResult
import com.placesapiprototype.data.RequestResult.Companion.error
import java.io.IOException
import java.lang.Exception

class RemoteDataSource(private val foursquarePlacesApiService: FoursquarePlacesApiService) {

    suspend fun getLocalCoffeeOutlets(): RequestResult<ResponseBase> {
        return try {
            val response = foursquarePlacesApiService.searchLocalCoffeeOutlets("40.7,-74")
            RequestResult.success(response)
        } catch (ex: Exception) {
            RequestResult.error<Exception>(Exception())
        }
    }
}
