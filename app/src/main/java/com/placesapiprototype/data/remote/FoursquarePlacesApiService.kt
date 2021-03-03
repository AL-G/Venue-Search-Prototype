package com.placesapiprototype.data.remote

import ResponseBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoursquarePlacesApiService {

    //https://api.foursquare.com/v2/venues/explore?ll=40.7,-74&v=20210301&client_id=BQQV2LZUS1EFCY4L4CTPFTTBUSELBH3BWCMWBL4ZXCMSGBF5&client_secret=C0QLU5VRPBAKITYOHJIVS1VQYD0NWAJMGOHDZ5CYDZM0VMZN
    @GET("v2/venues/explore?client_id=$client_id&client_secret=$client_secret")
    fun searchLocalCoffeeOutlets(@Query("ll") ll: String,): ResponseBase

    companion object{
        const val client_id = "BQQV2LZUS1EFCY4L4CTPFTTBUSELBH3BWCMWBL4ZXCMSGBF5"
        const val client_secret = "C0QLU5VRPBAKITYOHJIVS1VQYD0NWAJMGOHDZ5CYDZM0VMZN"
    }
}

