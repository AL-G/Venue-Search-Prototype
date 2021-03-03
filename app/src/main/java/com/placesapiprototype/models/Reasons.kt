import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reasons (

	@SerializedName("count") val count : Int,
	@SerializedName("items") val items : List<Items>
) : Parcelable