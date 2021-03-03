package com.placesapiprototype.data

import ResponseBase

interface Repository {

    suspend fun getLocalCoffeeOutlete(): RequestResult<ResponseBase>?

}