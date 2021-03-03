import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Warning (

	@SerializedName("text") val text : String
) : Parcelable