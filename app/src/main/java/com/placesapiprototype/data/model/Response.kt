package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response (

	@SerializedName("warning") val warning : Warning,
	@SerializedName("suggestedRadius") val suggestedRadius : Int,
	@SerializedName("headerLocation") val headerLocation : String,
	@SerializedName("headerFullLocation") val headerFullLocation : String,
	@SerializedName("headerLocationGranularity") val headerLocationGranularity : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("suggestedBounds") val suggestedBounds : SuggestedBounds,
	@SerializedName("groups") val groups : List<Groups>
) : Parcelable