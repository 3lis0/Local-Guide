package com.example.localguide.HomeScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
import com.example.localguide.Data.ToursData
import com.example.localguide.Data.formatDateForDisplay
import com.example.localguide.Data.toursList
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TourDetails(orderNo: Int?, navController: NavHostController){
    val context = LocalContext.current
    val toursObj: List<ToursData> = toursList
    var selected by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(30.dp)
            ) {
                Button(
                    onClick = {
                        selected = !selected
                        if (selected){
                            Toast.makeText(context, "Request send successfully", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    Modifier
                        .padding(top = 30.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = if (!selected){
                                Color(0xFF190482)
                            } else {
                                Color(0xFF32CD32)
                            },
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        if (!selected){
                        Color(0xFF190482)
                        } else {
                            Color(0xFF32CD32)
                        }
                    )
                ) {
                    Text(
                        text =
                        if (!selected){
                            "Request"
                        } else {
                            "Done"
                        },
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.moul)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    ) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(255, 255, 255))
    ) {
        Column(
            modifier = Modifier.height(300.dp)
        ) {
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp.dp
            Box(
                modifier =
                Modifier.width(screenWidth)

            ) {
                val imageModifier = Modifier
                    .height(300.dp)
                    .width(screenWidth)
                Image( // Use Image composable for displaying images
                    painter = painterResource(id = toursObj[orderNo!!].image), // Access image property
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = imageModifier
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color(0, 0, 0), Color(0xFF190482)),
                            ),
                            alpha = 0.5f
                        ),
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier =
                    Modifier
                        .padding(
                            top = 50.dp,
                            start = 30.dp,
                            end = 30.dp,
                        )
                        .fillMaxWidth()
                        .height(220.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color(255, 255, 255),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable {
                                    navController.popBackStack()
                                }
                        )
                        Text(
                            text = formatDateForDisplay(toursObj[orderNo].date),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = toursObj[orderNo!!].name,
                            style = TextStyle(
                                fontSize = 36.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Text(
                text = "Tour guide: ${toursObj[orderNo!!].guideName}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF454545),
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = toursObj[orderNo].description,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "About tour",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "Our adventure begins with a convenient pick-up from your Cairo hotel.\nAs we travel to Giza, our expert guide will share fascinating facts about Egyptian history and the significance of the pyramids.\nUpon arrival at the Giza plateau, prepare to be awestruck by the Great Pyramid of Khufu (Cheops), the largest pyramid ever built.\nLearn about the ingenious engineering feats and the mysteries surrounding its construction.",
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 18.12.sp,
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
fun TourDetailsPreview() {
    LocalGuideTheme {
        //TourDetails()
    }
}