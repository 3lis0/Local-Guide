package com.example.localguide.Registration.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.localguide.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GuideQScreen(navController: NavHostController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF000000)
    ) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier.padding(40.dp)
                ){
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
                }

            },
            bottomBar = {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 120.dp)

                    ){
                        Column (
                            Modifier.width(300.dp)
                        ) {


                            Button(
                                onClick = {
                                    navController.navigate(com.example.localguide.InformationScreen.route)
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
                                        Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(size = 10.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF))
                            ) {
                                Text(
                                    text = "Local Guide",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight(900),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center,
                                        letterSpacing = 1.sp,
                                    )
                                )
                            }

                            Button(
                                onClick = {
                                    navController.navigate(com.example.localguide.InformationScreen.route)
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
                                        Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(size = 10.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF))
                            ) {
                                Text(
                                    text = "Professional Guide",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight(900),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center,
                                        letterSpacing = 1.sp,
                                    )
                                )
                            }
                        }
                    }
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF000000))
            ) {
                Column(
                    modifier = Modifier.padding(top = 130.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.guide_sign),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillWidth
                        )

                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth().padding(
                                top = 180.dp,
                                end = 48.dp
                            )
                        ) {
                            Text(
                                text = "What kind of Guides Are you?",
                                style = TextStyle(
                                    fontSize = 32.sp,
                                    lineHeight = 50.sp,
                                    fontFamily = FontFamily(Font(R.font.moul)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Right,
                                    letterSpacing = 1.6.sp,
                                ),
                                modifier = Modifier
                                    .width(183.dp)
                                    .height(232.dp)
                            )
                        }
                    }
                }
            }

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun GuideQScreenPreview() {
//    LocalGuideTheme {
//        GuideQScreen()
//    }
//}