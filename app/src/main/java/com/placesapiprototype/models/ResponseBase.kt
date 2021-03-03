import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseBase (

	@SerializedName("meta") val meta : Meta,
	@SerializedName("response") val response : Response
) : Parcelable