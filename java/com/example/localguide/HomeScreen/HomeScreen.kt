package com.example.localguide.HomeScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Model.MainViewModel
import com.example.localguide.MyExposedDropdownMenu
import com.example.localguide.NotificationScreen
import com.example.localguide.R
import com.example.localguide.SearchBarPage
import com.example.localguide.uiComponent.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController ,viewModel: MainViewModel) {

    val searchTextOut by viewModel.searchTextOut.collectAsState()
    Scaffold(
        topBar = {},
        bottomBar = {
            BottomBar("Home", navController)
        }
    ) {
        Column(modifier = Modifier
            .background(Color(255, 255, 255))
            .padding(20.dp)
            .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier
                        .weight(2.0f)
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Start){
                    Text(
                        text = "Locals",
                        style = TextStyle(
                            fontSize = 36.sp,
                            lineHeight = 32.sp,
                            fontFamily = FontFamily(Font(R.font.moul)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF190482),
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .weight(1.0f)
                        .padding(top = 10.dp)
                        .height(60.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.clickable {
                            navController.navigate(NotificationScreen.route)
                        },
                        painter = painterResource(id = R.drawable.notification_icon01),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                }

            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(80.dp)
            ){
                Column(modifier = Modifier.weight(2f)) {
                    Button(
                        onClick = { navController.navigate(SearchBarPage.route) },  // Add your desired action
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),

                        // Add padding for content
                        contentPadding = PaddingValues(start = 15.dp, top = 15.dp, bottom = 15.dp), // Remove default content padding
                        shape = RoundedCornerShape(bottomEnd = 0.dp, topEnd = 0.dp, topStart = 25.dp, bottomStart = 25.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFEEEEEE) )
                    ) {
                        Row( // Arrange icon and text horizontally
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.Black,  // Customize the icon color
                            )
                            Spacer(modifier = Modifier.width(8.dp))  // Add spacing between icon and text
                            Text(
                                text = searchTextOut,  // Display search text
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.lato)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF4D4A4A),
                                ),
                                modifier = Modifier.fillMaxWidth()  // Make text fill available width
                            )
                        }
                    }

                }

                Column(modifier = Modifier.weight(1.1f)) {
                    MyExposedDropdownMenu(listOf("Guides", "Locals"))
                }

            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TabsRow(navController, viewModel)
            }

        }

    }
}

/*

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LocalGuideTheme {
        HomeScreen(navController)
    }
}
*/