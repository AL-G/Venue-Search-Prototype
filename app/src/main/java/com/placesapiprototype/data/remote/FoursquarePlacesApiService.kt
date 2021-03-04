package com.placesapiprototype.data.remote

import com.placesapiprototype.BuildConfig
import com.placesapiprototype.data.model.ResponseBase
import retrofit2.http.GET
import retrofit2.http.Query

interface FoursquarePlacesApiService {

    @GET("venues/explore?v=${BuildConfig.API_VERSION}&client_id=${BuildConfig.CLIENT_ID}&client_secret=${BuildConfig.CLIENT_SECRET}")
    suspend fun searchLocalCoffeeOutlets(@Query("ll") ll: String): ResponseBase

}

