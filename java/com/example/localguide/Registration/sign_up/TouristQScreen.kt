package com.example.localguide.Registration.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.GuideQScreen
import com.example.localguide.InformationScreen
import com.example.localguide.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TouristQScreen(navController: NavHostController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF190482)
    ) {
        Scaffold(
            bottomBar = {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vectortouristq),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillWidth
                    )
                    Column (
                        modifier = Modifier.width(300.dp)
                    ){
                        Button(
                            onClick = {
                                navController.navigate(InformationScreen.route)
                            },
                            Modifier
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFF000000),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(
                                    Color(0xFF190482),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(Color(0xFF190482))
                        ){
                            Text(
                                text = "Tourist",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.lato)),
                                    fontWeight = FontWeight(900),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 2.sp,
                                )
                            )
                        }

                        Button(
                            onClick = {
                                navController.navigate(GuideQScreen.route)
                            },
                            Modifier
                                .padding(top = 20.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFF000000),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(
                                    Color(0xFF000000),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(Color(0xFF000000))
                        ){
                            Text(
                                text = "Guide",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.lato)),
                                    fontWeight = FontWeight(900),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 2.sp,
                                )
                            )
                        }
                    }

                }
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF190482))
            ) {
                Text(
                    text = "Are you a tourist\n or a guide?",
                    style = TextStyle(
                        fontSize = 32.sp,
                        lineHeight = 38.4.sp,
                        fontFamily = FontFamily(Font(R.font.moul)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 150.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.tourist_guide),
                    contentDescription = "",
                    modifier = Modifier
                        .width(350.dp)
                        .padding(top = 80.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TouristQScreenPreview() {
//    LocalGuideTheme {
//        TouristQScreen()
//    }
//}