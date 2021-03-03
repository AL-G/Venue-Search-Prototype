package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Icon (

	@SerializedName("prefix") val prefix : String,
	@SerializedName("suffix") val suffix : String
) : Parcelable