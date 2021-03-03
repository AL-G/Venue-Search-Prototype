package com.placesapiprototype.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items (

	@SerializedName("reasons") val reasons : Reasons,
	@SerializedName("venue") val venue : Venue
) : Parcelable