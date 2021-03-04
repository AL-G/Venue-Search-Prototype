package com.placesapiprototype.data

import com.placesapiprototype.data.model.ResponseBase


interface Repository {

    suspend fun getLocalCoffeeOutlets(latLong: String): RequestResult<ResponseBase>?

}