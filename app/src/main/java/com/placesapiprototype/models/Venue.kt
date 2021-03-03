import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String,
	@SerializedName("location") val location : Location,
	@SerializedName("categories") val categories : List<Categories>,
	@SerializedName("popularityByGeo") val popularityByGeo : Double,
	@SerializedName("venuePage") val venuePage : VenuePage
) : Parcelable