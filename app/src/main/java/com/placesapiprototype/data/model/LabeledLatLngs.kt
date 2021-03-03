package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LabeledLatLngs (

	@SerializedName("label") val label : String,
	@SerializedName("lat") val lat : Double,
	@SerializedName("lng") val lng : Double
) : Parcelable