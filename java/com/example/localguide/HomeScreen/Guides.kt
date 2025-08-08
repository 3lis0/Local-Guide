package com.example.localguide.HomeScreen

import Guides
import ParsingData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Model.MainViewModel
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme
import kotlinx.coroutines.delay

@Composable
fun GuidesTab(viewModel: MainViewModel, navController: NavHostController){
    val guidesList: MutableList<Guides> = ParsingData(viewModel)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {

            var isLoading by remember { mutableStateOf(true) } // Track loading state
            LaunchedEffect(Unit) {
                delay(2000) // Simulate loading for 500 milliseconds
                isLoading = false

            }
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(80.dp),
                    color = Color(200, 200, 200)
                ) // Display the spinner while loading
            } else {
                LazyColumn {
                    items(guidesList.size) { guide ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFFFF),
                            ),
                            shape = RoundedCornerShape(size = 10.dp),
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .height(120.dp)
                                .border(
                                    1.dp,
                                    Color(0xFFF2F2F2),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .clickable {
                                    navController.navigate(com.example.localguide.GuidesDetails.route + "/${guide}")
                                }
                        ) {

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Column {
                                        val imageModifier = Modifier
                                            .padding(end = 20.dp)
                                            .size(100.dp)

                                            .background(
                                                color = Color(0xFFD9D9D9),
                                                shape = RoundedCornerShape(size = 5.dp)
                                            )
                                            .clip(RoundedCornerShape(5.dp))
                                        Image( // Use Image composable for displaying images
                                            painter = if (guidesList[guide].gender == "Male")
                                                painterResource(id = R.drawable.profile01)
                                            else painterResource(id = R.drawable.profile02), // Access image property
                                            contentDescription = "",
                                            contentScale = ContentScale.FillBounds,
                                            modifier = imageModifier
                                        )
                                    }
                                    Column(
                                        horizontalAlignment = Alignment.Start,
                                        //modifier = Modifier.fillMaxHeight()
                                    ) {
                                        Text(
                                            text = guidesList[guide].name,
                                            style = TextStyle(
                                                fontSize = 20.sp,
                                                fontFamily = FontFamily(Font(R.font.lato)),
                                                fontWeight = FontWeight(400),
                                                color = Color(0xFF000000),
                                            ),
                                            modifier = Modifier.width(130.dp)
                                        )
                                        Row(
                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(top = 5.dp)
                                        ) {

                                            Icon(
                                                painter = painterResource(id = R.drawable.star_1),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .width(18.dp)
                                                    .height(18.dp)
                                                    .padding(end = 5.dp),
                                                tint = Color(0xFFFFB30B)
                                            )

                                            Text(
                                                text = "${guidesList[guide].rate}/5",
                                                style = TextStyle(
                                                    fontSize = 18.sp,
                                                    fontFamily = FontFamily(Font(R.font.lato)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFC2C2C2),
                                                )
                                            )
                                        }

                                    }
                                }
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp)
                                    )

                                    Text(
                                        text = "${guidesList[guide].price} $/h",
                                        style = TextStyle(
                                            fontSize = 20.sp,
                                            fontFamily = FontFamily(Font(R.font.lato)),
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF000000),
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }


                                // Add other user information here
                            }
                        }
                    }
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun  GuidesTabPreview() {
    LocalGuideTheme {
        //GuidesTab()
    }
}
