package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sw (

	@SerializedName("lat") val lat : Double,
	@SerializedName("lng") val lng : Double
) : Parcelable