
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.localguide.Model.MainViewModel
import com.example.localguide.ui.theme.LocalGuideTheme
import com.google.gson.Gson

data class Guides(
    val userID: String,
    val name: String,
    val gender: String,
    val interests: List<String>,
    val country: String,
    val language: List<String>,
    val age: String,
    val rate: String,
    val price: String
)

@Composable
fun ParsingData(viewModel: MainViewModel): MutableList<Guides> {
    val searchTextOut by viewModel.searchTextOut.collectAsState()
    val context = LocalContext.current
    val jsonString = context.assets.open("Guides_subset.json").bufferedReader().use { it.readText() }
    val guidesMap = Gson().fromJson(jsonString, Map::class.java)
    val guidesList = mutableListOf<Guides>()
    var count = 0

    for (key in guidesMap.keys) {
        if (count >= 10) break
        val userMap = guidesMap[key] as? Map<*, *>?
        userMap?.let {
            val guide = Guides(
                userID = it["UserID"].toString(),
                name = it["Name"].toString(),
                gender = it["Gender"].toString(),
                interests = it["Interests"].toString().split(", "),
                country = it["Country"].toString(),
                language = it["language"].toString().split(", "),
                age = it["age"].toString(),
                rate = it["rate"].toString(),
                price = it["price/h"].toString()
            )
            if (guide.country == searchTextOut){
                guidesList.add(guide)
                count++
            }
        }
    }
    return guidesList
}


@Preview(showBackground = true)
@Composable
fun  ParsingDataPreview() {
    LocalGuideTheme {
        //ParsingData()
    }
}
