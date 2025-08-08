package com.example.localguide.Registration.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Home
import com.example.localguide.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserInterests(navController: NavHostController){
    val listOfInterest by remember {
        mutableStateOf(
            listOf(
            "activities","art", "automobiles", "beauty",
            "books", "business", "cars", "causes", "cooking", "crafts",
            "dining", "education", "entrepreneurship", "family",
            "fashion", "finance", "fitness", "food", "gaming", "gardening",
            "health", "history", "investments", "learning", "movies", "music",
            "nature", "outdoor", "parenting", "pets", "photography",
            "politics", "science", "social", "sports", "technology", "travel"
            )
        )
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(255,255,255)
    ) {
        Scaffold(
            topBar = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth().padding(30.dp)
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription ="",
                        tint = Color(0,0,0),
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clickable {  navController.popBackStack() }
                    )
                }

            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Share Your Interests!",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontFamily = FontFamily(Font(R.font.moul)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF190482),
                        )
                    )
                    Text(
                        text = "by sharing your interests that led us to make\nyour experience more exciting.",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        ),
                        modifier = Modifier.width(300.dp)
                    )
                }


                FlowRow(
                    modifier = Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    maxItemsInEachRow = 4
                ) {
                    listOfInterest.forEach { item ->
                        NewFilterChip(item)
                    }
                }

                Button(
                    onClick = {
                        navController.navigate(Home.route)
                    },
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            color = Color(0xFF190482),
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF190482)
                    )
                ) {
                    Text(
                        text = "Finish!",
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
}

@Composable
fun NewFilterChip(text: String){
    var selected by remember { mutableStateOf(false)}
    FilterChip(
        //modifier = Modifier.padding(5.dp),
        onClick = {
            selected = !selected // Update selection state in map
        },
        label = { Text(text = text) },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "done",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color(0xFFFFFFFF)

                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF190482),
            selectedLabelColor = Color(0xFFFFFFFF)
        ),
    )
}
//
//@Preview(showBackground = true)
//@Composable
//fun  UserInterestsPreview() {
//    LocalGuideTheme {
//        UserInterests()
//    }
//}
