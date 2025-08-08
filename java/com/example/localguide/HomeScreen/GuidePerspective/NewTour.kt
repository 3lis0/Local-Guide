package com.example.localguide.HomeScreen.GuidePerspective

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.localguide.R
import com.example.localguide.ui.theme.LocalGuideTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTourInput(navController: NavHostController, viewModel: TourViewModel) {

    //var tourName by remember { mutableStateOf("") }
    var tourName = viewModel.tourName
    var tourDescription = viewModel.tourDescription
    var tourPrice = viewModel.tourPrice
    var tourDate = viewModel.tourDate
    var tourLocation = viewModel.tourLocation
    var tourCountry = viewModel.tourCountry
    var tourGuideName = viewModel.tourGuideName

    var selectedImageUriTest = viewModel.selectedImageUri


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {newValue ->
            viewModel.selectedImageUri = newValue
        }
    )

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
       Box(
          contentAlignment = Alignment.Center,
           modifier = Modifier
               .background(color = Color(0xFFEEEBFF))
               .fillMaxWidth()
               .clickable {
                   launcher.launch(
                       PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                   )
               }
       ){
           Text(text = "Chose the header Image")
           AsyncImage(
               model = selectedImageUriTest,
               contentDescription = null,
               contentScale = ContentScale.FillWidth,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(100.dp),
           )
       }

        OutlinedTextField(
            value = tourName,
            onValueChange = { newValue ->
                viewModel.tourName = newValue
            },
            label = { Text("Tour Name") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFF190482),
                focusedIndicatorColor = Color(0xFF190482),
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        OutlinedTextField(
            value = tourDescription,
            onValueChange = {newValue ->
                viewModel.tourDescription = newValue
            },
            label = { Text("Description") } ,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFF190482),
                focusedIndicatorColor = Color(0xFF190482),
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        OutlinedTextField(
            value = tourDate,
            onValueChange = {  newValue ->
                viewModel.tourDate = newValue
            },
            label = { Text("Date (Ex: 2024-10-25)") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFF190482),
                focusedIndicatorColor = Color(0xFF190482),
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        OutlinedTextField(
            value = tourLocation,
            onValueChange = {newValue ->
                viewModel.tourLocation = newValue
            },
            label = { Text("Location") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFF190482),
                focusedIndicatorColor = Color(0xFF190482),
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        OutlinedTextField(
            value = tourPrice,
            onValueChange = {newValue ->
                viewModel.tourPrice = newValue
            },
            label = { Text("Price") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFF190482),
                focusedIndicatorColor = Color(0xFF190482),
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        OutlinedTextField(
            value = "Egypt",
            onValueChange = {
                tourCountry = it
            },
            readOnly = true,
            label = { Text("Country") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedTextColor = Color.Gray,
                disabledLabelColor =Color.Gray,
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        OutlinedTextField(
            value = "Ali Salama",
            onValueChange = {
                tourGuideName = it
            },
            readOnly = true,
            label = { Text("Guide") } ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedTextColor = Color.Gray,
                disabledLabelColor =Color.Gray,
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Button(
           onClick = {
                // Create a ToursData object using the input values
                val newTour = GuideTourData(
                    tourName = tourName,
                    tourDescription = tourDescription,
                    tourPrice = tourPrice,
                    tourDate = tourDate,
                    tourLocation = tourLocation,
                    tourCountry = "Egypt",
                    tourGuideName = "Ali Salama",
                    selectedImageUri = selectedImageUriTest
                )

                // Call onAddNewTour with the new ToursData object
               viewModel.addTour(newTour)

               viewModel.tourName = ""
               viewModel.tourDescription = ""
               viewModel.tourPrice = ""
               viewModel.tourDate = ""
               viewModel.tourLocation = ""
               viewModel.tourCountry = ""
               viewModel.tourGuideName = ""
               viewModel.selectedImageUri = null
               navController.popBackStack()
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
                text = "Add New Tour",
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
        Button(
            onClick = {
                //navController.navigate(GuideHomeScreen.route)
                navController.popBackStack()
            },
            Modifier
                .padding(top = 10.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = Color(0, 0, 0),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                Color(0,0,0)
            )
        ) {
            Text(
                text = "Cancel",
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


@Preview(showBackground = true)
@Composable
fun NewTourInputPreview() {
    LocalGuideTheme {
        //NewTourInput()
    }
}