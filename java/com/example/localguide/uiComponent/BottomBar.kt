package com.example.localguide.uiComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.localguide.Home
import com.example.localguide.InboxScreen
import com.example.localguide.R
import com.example.localguide.SearchScreen
import com.example.localguide.ui.theme.LocalGuideTheme

@Composable
fun BottomBar(activity: String, navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .border(width = 1.dp, color = Color(0xFFE2E2E2))
            .fillMaxWidth()
            .height(77.dp)
            .background(color = Color(0xFFFFFFFF))
            .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
    ) {

        //home icon
            Column (
                verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(32.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(Home.route)
                    }
            ) {
                Image(
                    painter = if (activity == "Home")
                        painterResource(id = R.drawable.home)
                    else painterResource(id = R.drawable.home2),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                )
                Text(
                    text = "Home",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = if (activity == "Home")
                            Color(0xFF190482)
                        else Color(0xFF454545),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        //search icon

            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(33.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(SearchScreen.route)
                    }
            ) {
                Image(

                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    colorFilter = if (activity == "Search")
                        ColorFilter.tint(Color(0xFF190482))
                    else ColorFilter.tint(Color(0xFF454545))
                )
                Text(
                    text = "Search",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = if (activity == "Search")
                            Color(0xFF190482)
                        else Color(0xFF454545),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        //inbox icon

            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(33.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(InboxScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.inbox_icon),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    colorFilter = if (activity == "Inbox")
                        ColorFilter.tint(Color(0xFF190482))
                    else ColorFilter.tint(Color(0xFF454545))
                )
                Text(
                    text = "Inbox",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = if (activity == "Inbox")
                            Color(0xFF190482)
                        else Color(0xFF454545),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        //profile icon

            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(33.dp)
                    .height(40.dp)
                    .clickable {
                        navController.navigate(com.example.localguide.ProfileScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.proile_icon),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    colorFilter = if (activity == "Profile")
                        ColorFilter.tint(Color(0xFF190482))
                    else ColorFilter.tint(Color(0xFF454545))
                )
                Text(
                    text = "Profile",
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = if (activity == "Profile")
                            Color(0xFF190482)
                        else Color(0xFF454545),
                        textAlign = TextAlign.Center,
                    )
                )
            }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    LocalGuideTheme {
        //BottomBar("Home")
    }
}