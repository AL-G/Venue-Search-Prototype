package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuggestedBounds (

	@SerializedName("ne") val ne : Ne,
	@SerializedName("sw") val sw : Sw
) : Parcelable