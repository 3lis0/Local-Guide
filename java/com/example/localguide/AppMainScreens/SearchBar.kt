package com.example.localguide.AppMainScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchBarPage(navController: NavHostController, viewModel: MainViewModel) {


    //Collecting states from ViewModel
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val countriesList by viewModel.countriesList.collectAsState()

    Scaffold (
        topBar = {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription ="",
                    tint = Color(0,0,0),
                    modifier = Modifier
                        .padding(start = 20.dp, top=30.dp)
                        .width(30.dp)
                        .height(30.dp)
                        .clickable { navController.popBackStack() }
                )
             
            Column(Modifier.padding(top = 80.dp, start = 20.dp,end =20.dp)) {
                SearchBar(
                    query = searchText,
                    onQueryChange =
                    viewModel::onSearchTextChange,
                    onSearch =
                    viewModel::onSearchTextChange,
                    active = isSearching,
                    onActiveChange = {
                        viewModel.onToogleSearch()
                    },
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
                    trailingIcon = {
                        if (isSearching) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "close",
                                modifier = Modifier.clickable {
                                    viewModel.setSearchText("")
                                    viewModel.setIsSearching(false)
                                }
                            )
                        }
                    },
                    shape = RoundedCornerShape(
                       25.dp
                    ),
                    colors = SearchBarDefaults.colors(Color(0xFFEEEEEE)),
                    modifier = Modifier.fillMaxWidth()


                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding =
                        PaddingValues(
                            start = 20.dp,
                            top = 30.dp,
                            end = 20.dp,
                            bottom = 20.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val list = countriesList
                        items(count = list.size) {
                            Text(
                                text = list[it],
                                modifier = Modifier
                                    .clickable {
                                        viewModel.setSearchText(list[it])
                                        viewModel.setIsSearching(false)
                                    }
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                            )
                        }
                    }
                }
            }
        }
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 200.dp,
                    start = 30.dp,
                    end = 30.dp
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.filters_icon),
                    contentDescription ="",
                    tint = Color(50,50,50),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(28.dp)
                        .height(28.dp),
                )

                Text(
                    text = "Filters",
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(500),
                        color = Color(50,50,50),
                    )
                )
            }
            FlowRow(
                maxItemsInEachRow = 2
            ) {
                filterDrobMenu("Language")
                filterDrobMenu("Age")
                filterDrobMenu("Gender")
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(top=50.dp)
            ) {
                Button(
                    onClick = { navController.popBackStack()  },
                    colors = ButtonDefaults.buttonColors(Color(0xFF190482)),
                    modifier = Modifier.height(50.dp)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,

                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color(255, 255, 255),
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .width(30.dp)
                                .height(30.dp)

                        )
                        Text(
                            text = "Find Your Guide",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(400),
                                color = Color(255, 255, 255),
                            )
                        )
                    }
                }
            }


        }
    }

}

@Composable
fun filterDrobMenu(text: String){
    OutlinedTextField  (
        modifier = Modifier
            .padding(top = 10.dp)
            .border(width = 0.dp, color = Color(0xFFFFFFFF))
            .fillMaxWidth()
            .height(55.dp),
        readOnly = true,
        value = text,
        onValueChange = { },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.Black, // Customize the icon color
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFECECEC),
            unfocusedContainerColor = Color(0xFFECECEC),
            focusedTextColor = Color(0xFF000000)
        ),
        singleLine = false,
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBaarPreview() {
    LocalGuideTheme {
        //SearchBarPage()
    }
}
