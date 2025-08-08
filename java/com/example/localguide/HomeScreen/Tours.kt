package com.example.localguide.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Data.ToursData
import com.example.localguide.Data.formatDateForDisplay
import com.example.localguide.Data.toursList
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme


@Composable
fun ToursTab(navController: NavHostController){
    Column {
        ToursList(toursList, navController)
    }
}

@Composable
fun ToursList(tours: List<ToursData>, navController: NavHostController) {
    LazyColumn {
        items(tours.size) {
            TourListItem(tours[it], navController, it)
        }
    }
}



@Composable
fun TourListItem(tour: ToursData, navController: NavHostController, tourNum: Int) {

    //val navController = LocalContext.current as Activity
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF),
        )
        ,
        shape = RoundedCornerShape(size = 10.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(120.dp)
            .border(1.dp, Color(0xFFF2F2F2),shape = RoundedCornerShape(size = 10.dp))
            .clickable {

                navController.navigate(com.example.localguide.TourDetails.route + "/${tourNum}")
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp).fillMaxWidth()
        ){
            Column{
                val imageModifier = Modifier
                    .size(100.dp)
                    .background(
                        color = Color(0xFFD9D9D9),
                        shape = RoundedCornerShape(size = 5.dp)
                    )
                    .clip(RoundedCornerShape(5.dp))
                Image( // Use Image composable for displaying images
                    painter = painterResource(id = tour.image), // Access image property
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = imageModifier
                )
            }

            Column (modifier = Modifier.fillMaxHeight()) {
                Text(
                    text = tour.name,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                        ),
                    modifier = Modifier.width(160.dp).height(18.dp)
                )
                Text(
                    text = "Location: ${tour.location}, ${tour.country}",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF7E7E7E),
                        ),
                    modifier = Modifier
                        .padding(top=3.dp)
                )
                Text(
                    text = tour.description,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        ),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(160.dp)
                        .height(50.dp)
                        .padding(top=6.dp)
                )
                Text(
                    text = "Guide: ${tour.guideName}",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF190482),
                        )
                )
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text =formatDateForDisplay(tour.date),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),

                        )
                )
                val priceText = tour.price.subSequence(0..3).toString()
                Text(
                    text = priceText,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        )
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToursTabPreview() {
    LocalGuideTheme {
        //ToursTab()
    }
}