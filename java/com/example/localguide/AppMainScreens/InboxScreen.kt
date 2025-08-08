package com.example.localguide.AppMainScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.localguide.uiComponent.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar("Inbox", navController)},
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                Modifier.padding(20.dp).fillMaxWidth().height(100.dp)
            ) {

                Text(
                    text = "Inbox",
                    style = TextStyle(
                        fontSize = 32.sp,
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
                       painter = painterResource(id = R.drawable.high_priority_message),
                        contentDescription ="",
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                    )
                    Text(
                        text = "No any messages yet",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Text(
                        text = "Connect with your guides and friends to see your messages here!",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF808080),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .width(280.dp)
                            .height(38.dp)
                    )
            }

    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun  InboxScreenPreview() {
//    LocalGuideTheme {
//        //InboxScreen()
//    }
//}
