package com.example.localguide.HomeScreen

import Guides
import ParsingData
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.localguide.Model.MainViewModel
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GuidesDetails(viewModel: MainViewModel, orderNo: Int?, navController: NavHostController) {
    val context = LocalContext.current
    val guidesList: MutableList<Guides> = ParsingData(viewModel)

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
                        if (selected) {
                            Toast.makeText(context, "Request send successfully", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    Modifier
                        .padding(top = 30.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 25.dp)
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = if (!selected) {
                                Color(0xFF190482)
                            } else {
                                Color(0xFF32CD32)
                            },
                            shape = RoundedCornerShape(size = 25.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        if (!selected) {
                            Color(0xFF190482)
                        } else {
                            Color(0xFF32CD32)
                        }
                    )
                ) {
                    Text(
                        text =
                        if (!selected) {
                            "Hire me!"
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

            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF190482))
                        .padding(30.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
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
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "",
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)
                                .clickable {

                                    Toast
                                        .makeText(context, "Under working!!", Toast.LENGTH_LONG)
                                        .show()
                                },
                            tint = Color(255, 255, 255)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 100.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter =
                                painterResource(id = R.drawable.ellipse_8),
                                contentDescription = "image description",
                                modifier = Modifier
                                    .width(160.dp)
                                    .height(160.dp)
                            )
                            Image(
                                painter =
                                if(guidesList[orderNo!!].gender == "Male"){
                                    painterResource(id = R.drawable.profile01)
                                } else {
                                    painterResource(id = R.drawable.profile02)
                                       }
                                ,
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                                    .clip(CircleShape)
                            )

                        }
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 25.dp,
                        end = 25.dp
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.send_mesg),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Under working!!", Toast.LENGTH_LONG)
                                .show()
                        },
                    tint = Color(0xFF190482)
                )
                Icon(
                    painter = painterResource(id = R.drawable.outline_heart),
                    contentDescription = "",
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Add to favorite list", Toast.LENGTH_LONG)
                                .show()
                        },
                    tint = Color(243,0,0)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 30.dp,
                        end = 30.dp
                    )
            ) {


                Text(
                    text = guidesList[orderNo!!].name,
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    ),
                    modifier = Modifier.padding(top=15.dp)
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
                            .width(24.dp)
                            .height(24.dp)
                            .padding(end = 5.dp),
                        tint = Color(0xFFFFB30B)
                    )

                    Text(
                        text = "${guidesList[orderNo!!].rate}/5",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFC2C2C2),
                        )
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = Color(0xFFF3F1FF),
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                            .width(25.dp)
                            .height(20.dp),
                        tint = Color(165, 165, 165)
                    )
                    Text(
                        text = guidesList[orderNo!!].country,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = Color(0xFFF3F1FF),
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.phone_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                            .width(25.dp)
                            .height(20.dp),
                        tint = Color(165, 165, 165)
                    )
                    Text(
                        text = "+20 1021269829",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF3F1FF),
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                ) {
                    Column (
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            text = "Bio:",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF4F4F4F),
                            )
                        )

                        Text(
                            text = "History whispers on every corner. Let me be your guide to hidden gems, forgotten stories, and the magic that makes travel special.",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF3F1FF),
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                ) {
                    Column (
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            text = "Language:",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF4F4F4F),
                            )
                        )

                        Row() {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(top = 10.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFF000000),
                                        shape = RoundedCornerShape(size = 20.dp)
                                    )
                                    .width(90.dp)
                                    .height(30.dp)
                                    .background(
                                        color = Color(0x00FFFFFF),
                                        shape = RoundedCornerShape(size = 20.dp)
                                    )
                                ) {}

                                Text(
                                    text = "Arabic",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            }

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .border(
                                            width = 1.dp,
                                            color = Color(0xFF000000),
                                            shape = RoundedCornerShape(size = 20.dp)
                                        )
                                        .width(90.dp)
                                        .height(30.dp)
                                        .background(
                                            color = Color(0x00FFFFFF),
                                            shape = RoundedCornerShape(size = 20.dp)
                                        )
                                ) {}

                                Text(
                                    text = "English",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            }
                        }
                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuidesDetailsPreview() {
    LocalGuideTheme {
        //GuidesDetails()
    }
}