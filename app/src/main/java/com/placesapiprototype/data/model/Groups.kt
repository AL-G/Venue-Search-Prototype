import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Groups (

	@SerializedName("type") val type : String,
	@SerializedName("name") val name : String,
	@SerializedName("items") val items : List<Items>
) : Parcelable