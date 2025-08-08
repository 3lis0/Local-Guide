package com.example.localguide.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Model.MainViewModel
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme

@Composable
fun TabsRow(navController: NavHostController, viewModel: MainViewModel){

    val tabItems = listOf("Guides", "Tours")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White
    ) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {
                    selectedTabIndex = index
                },

                text = {
                    Text(
                        text = item
                    )
                }
            )
        }
    }
    Column(modifier = Modifier
        .background(Color(255, 255, 255))
        .fillMaxSize()
    ) {
        Text(
            text = "Recommended For You",
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.lato)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            ),
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
        )
        when (selectedTabIndex) {
            0 -> GuidesTab(viewModel, navController)
            1 -> ToursTab(navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TabsRowPreview() {
    LocalGuideTheme {
        //TabsRow()
    }
}