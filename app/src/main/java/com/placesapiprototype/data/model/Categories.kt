package com.placesapiprototype.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("pluralName") val pluralName : String,
	@SerializedName("shortName") val shortName : String,
	@SerializedName("icon") val icon : Icon,
	@SerializedName("primary") val primary : Boolean
) : Parcelable