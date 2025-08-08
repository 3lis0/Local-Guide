package com.example.localguide.AppMainScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun NotificationScreen(navController: NavHostController){
    Scaffold(

        topBar = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                Modifier.padding(20.dp).fillMaxWidth().height(100.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription ="",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .width(35.dp)
                        .height(35.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    tint = Color(0xFF190482)
                )
                Text(
                    text = "Notification",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF190482),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier =
            Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.alarm),
                contentDescription ="",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
            )
            Text(
                text = "No any notifications yet",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "We will notify you if there is any news like \"your guide accepted your request\"",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF808080),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .width(280.dp)
                    .height(45.dp)
            )
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun  TestScreenPreview() {
//    LocalGuideTheme {
//        //NotificationScreen()
//    }
//}