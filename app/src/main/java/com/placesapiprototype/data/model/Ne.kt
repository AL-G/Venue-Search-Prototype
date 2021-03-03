import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ne (

	@SerializedName("lat") val lat : Double,
	@SerializedName("lng") val lng : Double
) : Parcelable