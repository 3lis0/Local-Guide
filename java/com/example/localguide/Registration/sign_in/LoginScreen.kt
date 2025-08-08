package com.example.localguide.Registration.sign_in

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.Home
import com.example.localguide.R
import com.example.localguide.SigninScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){

    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()

        ) {
            Text(
                text = "Welcome Back!",
                modifier = Modifier
                    .width(251.dp)
                    .height(100.dp),
                style = TextStyle(
                    fontSize = 40.sp,
                    lineHeight = 38.04.sp,
                    fontFamily = FontFamily(Font(R.font.moul)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF190482),
                    textAlign = TextAlign.Center ,
                    letterSpacing = 1.6.sp,
                )
            )
        }

        var email by remember { mutableStateOf(TextFieldValue("")) }
        //UserInputEmail(email)
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
                focusedTextColor = Color(0xFF000000),
                containerColor = Color(0xFFF6F6F6),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFFF6F6F6),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        //UserInputPassword()
        var password by remember { mutableStateOf(TextFieldValue("")) }
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
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .clickable {
                    Toast.makeText(context, "Forgot password", Toast.LENGTH_SHORT)
                        .show()
                },
                text = "Forgot password?",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 19.21.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF444444),
                    textDecoration = TextDecoration.Underline,
                )
            )
        }

        Button(
            onClick = { if(email.text == "Ali" && password.text == "123"){
                Toast.makeText(context, "Welcome to Local Guide!", Toast.LENGTH_LONG).show()
                navController.navigate(Home.route)
            } else {
                Toast.makeText(context,
                    "Invalid credentials." + "Please try again.", Toast.LENGTH_LONG)
                    .show()
                }
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
                text = "Login",
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
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Don't have registration yet?",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "Register now",
                Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        navController.navigate(SigninScreen.route)
                    },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF190482),
                )
            )
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginPreview() {
//    LocalGuideTheme {
//        LoginScreen()
//    }
//}