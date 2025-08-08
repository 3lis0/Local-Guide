package com.example.localguide.Registration.sign_up


import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localguide.InformationScreen
import com.example.localguide.LoginScreen
import com.example.localguide.NotificationScreen
import com.example.localguide.R
import com.example.localguide.TouristQScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninScreen(navController: NavHostController){

    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()

        ) {
            Text(
                modifier = Modifier
                    .width(206.dp)
                    .height(121.dp),
                text = "Create new\naccount".uppercase(),
                style = TextStyle(
                    fontSize = 32.sp,
                    lineHeight = 38.04.sp,
                    fontFamily = FontFamily(Font(R.font.moul)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF190482),
                    letterSpacing = 1.6.sp,
                )
            )
        }

        var email by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
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
        var CreatePassword by remember { mutableStateOf(TextFieldValue("")) }
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
            value = CreatePassword,
            onValueChange = { CreatePassword = it },
            label = { Text(text = "Create Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        //UserInputPassword()
        var RewritePassword by remember { mutableStateOf(TextFieldValue("")) }
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
            value = RewritePassword,
            onValueChange = { RewritePassword = it },
            label = { Text(text = "Rewrite Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
                navController.navigate(com.example.localguide.TouristQScreen.route)
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
                text = "Sign up",
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

            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 1 * density
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        Color.LightGray,
                        Offset(0f, y),
                        Offset(size.width, y),
                        strokeWidth
                    )
                }
        ) {


        }
        Button(
            onClick = {
                navController.navigate(LoginScreen.route)
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
                    color = Color(0, 0, 0),
                    shape = RoundedCornerShape(size = 10.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                Color(0,0,0)
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
    }

}

//@Preview(showBackground = true)
//@Composable
//fun SigninPreview() {
//    LocalGuideTheme {
//        SigninScreen()
//    }
//}