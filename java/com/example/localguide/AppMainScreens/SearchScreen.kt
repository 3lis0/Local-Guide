package com.example.localguide.AppMainScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
fun SearchScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar("Search", navController)},
        topBar = {
            Column(Modifier.padding(20.dp)) {
                SearchBar(
                    query = "",
                    onQueryChange ={},
                    onSearch ={},
                    active = false,
                    onActiveChange = {},
                    placeholder = {
                        Text(
                            text = "Type your destination..",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF4D4A4A),
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = "search",
                            modifier = Modifier
                                .padding(1.dp)
                                .width(21.dp)
                                .height(21.dp)
                        )
                    },
                    shape = RoundedCornerShape(
                        25.dp
                    ),
                    colors = SearchBarDefaults.colors(Color(0xFFEEEEEE)),
                    modifier = Modifier.fillMaxWidth()
                ){}
            }
        }
    ) {
        Column(Modifier.fillMaxSize()){
            Spacer(modifier = Modifier.weight(1.0f))
            Column(Modifier.weight(1.0f)){
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                    .border(width = 1.dp, color = Color(0xFFCCCCCC))
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = Color(0xFFF8F8F8))
                ){
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription ="",
                        modifier = Modifier
                            .width(21.66667.dp)
                            .height(20.00009.dp),
                        tint = Color(0xFF555555)
                    )

                    Text(
                        text = "Favorite",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                            textAlign = TextAlign.Center,
                        )
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription ="",
                        modifier = Modifier
                            .width(21.66667.dp)
                            .height(20.00009.dp),
                        tint = Color(0xFF555555)
                    )


                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier =
                    Modifier.fillMaxSize()){
                    Text(
                        text = "Add your favorite\nguides to this list",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFAEA7A7),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

            }

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun  SearchBarPreview() {
//    LocalGuideTheme {
//        SearchScreen()
//    }
//}
