import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta (

	@SerializedName("code") val code : Int,
	@SerializedName("requestId") val requestId : String
) : Parcelable