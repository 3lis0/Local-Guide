package com.example.localguide.Registration.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.R
import com.example.localguide.UserInterests

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationScreen(navController: NavHostController) {

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
                .padding(30.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Complete your\nInformation!",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 30.sp,
                    fontFamily = FontFamily(Font(R.font.moul)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF190482),
                    textAlign = TextAlign.Center,
                )
            )

            var name by remember { mutableStateOf("") }

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF707070),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedTextColor = Color(0xFF000000),
                    containerColor = Color(0xFFF6F6F6),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF6F6F6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = name,
                onValueChange = { name = it },
                label = { Text("name") }
            )

            //UserInputPassword()
            var age by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF707070),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    //textColor = Color(0xFF000000),
                    containerColor = Color(0xFFF6F6F6),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF6F6F6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = age,
                onValueChange = { age = it },
                label = { Text(text = "Age") },
            )

            //UserInputPassword()
            var Country by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF707070),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    //textColor = Color(0xFF000000),
                    containerColor = Color(0xFFF6F6F6),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF6F6F6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = Country,
                onValueChange = { Country = it },
                label = { Text(text = "Country") },
            )


            var Language by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color(0xFF707070),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    //textColor = Color(0xFF000000),
                    containerColor = Color(0xFFF6F6F6),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF6F6F6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = Language,
                onValueChange = { Language = it },
                label = { Text(text = "Language") },
            )

            val options = listOf("Male", "Female")
            var expanded by rememberSaveable { mutableStateOf(false) }
            var selectedOptionText by rememberSaveable { mutableStateOf(options[0]) }

            ExposedDropdownMenuBox(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                OutlinedTextField  (
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .border(
                            width = 0.5.dp,
                            color = Color(0xFF707070),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .height(60.dp),

                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { },
                    trailingIcon = {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Color.Black, // Customize the icon color
                            modifier = Modifier.pointerInput(Unit) {
                                detectTapGestures {
                                    // Handle click on the trailing icon
                                    expanded = !expanded
                                }
                            }
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFF8F8F8),
                        focusedBorderColor = Color(0xFFF8F8F8),
                        focusedContainerColor = Color(0xFFF8F8F8),
                        unfocusedContainerColor = Color(0xFFF8F8F8),
                        focusedTextColor = Color(0xFF000000)
                    ),
                    singleLine = false,
                    shape = RoundedCornerShape(size = 10.dp),
                    )
                ExposedDropdownMenu(
                    modifier = Modifier.background(color = Color(0xFFFCFCFC)),
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem (
                            text = { Text(
                                text = selectionOption,
                            ) },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }

            Button(
                onClick = {
                    navController.navigate(UserInterests.route)
                },
                Modifier
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
                    text = "Next",
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

//@Preview(showBackground = true)
//@Composable
//fun InformationScreenPreview() {
//    LocalGuideTheme {
//        InformationScreen()
//    }
//}