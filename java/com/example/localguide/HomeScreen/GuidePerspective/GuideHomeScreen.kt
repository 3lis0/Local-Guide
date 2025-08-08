package com.example.localguide.HomeScreen.GuidePerspective

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.localguide.Data.formatDateForDisplay
import com.example.localguide.NewTourInput
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme
import com.example.localguide.uiComponent.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuideHomeScreen(navController: NavHostController, viewModel: TourViewModel) {

    //val list = toursListTest
    val list = viewModel.guideToursList
    //val searchTextOut by viewModel.searchTextOut.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NewTourInput.route)
                },
                modifier = Modifier.padding(20.dp),
                containerColor = Color(0xFF190482),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Filled.Add,
                    "Floating action button.",
                    tint = Color(255,255,255)
                )
            }
        },
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
                    horizontalArrangement = Arrangement.Start
                ){
                    Column {
                        Text(
                            text = "Locals",
                            style = TextStyle(
                                fontSize = 36.sp,
                                fontFamily = FontFamily(Font(R.font.moul)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF190482),
                            )
                        )
                        Text(
                            text = "Guide",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.moul)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            ),
                            modifier = Modifier.offset(y = (-20).dp)
                        )
                    }
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
                        //modifier = Modifier.height(20.dp).width(20.dp),
                        painter = painterResource(id = R.drawable.notification_icon01),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                }

            }

            Spacer(modifier = Modifier.size(130.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    //modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = R.drawable.my_tours),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                LazyColumn {
                    items(list.size) {
                        GuidTourListTest(list[it], viewModel, it)
                        /*Text(text = "Name: ${list[it].tourName}")
                        Text(text = "Name: ${list[it].tourPrice}")
                        Text(text = "Name: ${list[it].tourDescription}")
                        Text(text = "Name: ${list[it].tourLocation}")
                        Text(text = "Name: ${list[it].tourDate}")
                        Text(text = "Name: ${list[it].tourGuideName}")
                        Text(text = "Name: ${list[it].tourCountry}")*/
                    }
                }
            }


        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GuidTourListTest(tour: GuideTourData,viewModel: TourViewModel, num: Int ){
    var showMenu by remember { mutableStateOf(false) }
    val menuItems = listOf("Edit", "Delete")

    Box() {
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            menuItems.forEach { menuItem ->
                DropdownMenuItem(
                    onClick = {
                        showMenu = false
                        // Handle menu item click
                        when (menuItem) {
                            "Edit" -> {
                                // Handle edit action
                            }

                            "Delete" -> {
                                viewModel.removeTour(num)
                            }
                        }
                    },
                    text = {
                        Text(text = menuItem)
                    }
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF),
            ),
            shape = RoundedCornerShape(size = 10.dp),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(120.dp)
                .border(1.dp, Color(0xFFF2F2F2), shape = RoundedCornerShape(size = 10.dp))
                .combinedClickable(
                    onClick = {},
                    onLongClick = {
                        showMenu = true
                    }
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    val imageModifier = Modifier
                        .size(100.dp)
                        .background(
                            color = Color(0xFFD9D9D9),
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .clip(RoundedCornerShape(5.dp))
                    AsyncImage( // Use Image composable for displaying images
                        model = tour.selectedImageUri, // Access image property
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = imageModifier
                    )
                }
                Column(modifier = Modifier.fillMaxHeight()) {
                    Text(
                        text = tour.tourName,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        ),
                        modifier = Modifier
                            .width(160.dp)
                            .height(18.dp)
                    )
                    Text(
                        text = "Location:${tour.tourLocation},${tour.tourCountry}",
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF7E7E7E),
                        ),
                        modifier = Modifier
                            .padding(top = 3.dp)
                    )
                    Text(
                        text = tour.tourDescription,
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
                            .padding(top = 6.dp)
                    )
                    Text(
                        text = "Guide: ${tour.tourGuideName}",
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
                        text = formatDateForDisplay(tour.tourDate),
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),

                            )
                    )
                    Text(
                        text = "${tour.tourPrice}$",
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
}



@Preview(showBackground = true)
@Composable
fun GuideHomeScreenPreview() {
    LocalGuideTheme {
        //GuideHomeScreen()
    }
}