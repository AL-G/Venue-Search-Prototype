package com.placesapiprototype.data

import com.placesapiprototype.data.model.ResponseBase


interface Repository {

    suspend fun getLocalCoffeeOutlete(latLong: String): RequestResult<ResponseBase>?

}