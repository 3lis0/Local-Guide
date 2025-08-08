package com.example.localguide.AppMainScreens

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
fun  ProfileScreen(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = { BottomBar("Profile", navController) },
    ) {
        var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = {
                selectedImageUri = it
            }
        )

        Column(modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color(255,255,255))) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF190482))
                    .padding(20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icons8_settings_1),
                        contentDescription = "",
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clickable {

                                Toast.makeText(context, "Under working!!", Toast.LENGTH_LONG).show()
                            },
                        tint = Color(255, 255, 255)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 80.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile01),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(150.dp)
                                .height(150.dp)
                                .clip(CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_14),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.width(150.dp)
                        )
                        Text(
                            text = "Edit \nyour image",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(400),
                                color = Color(0xC9EDEDED),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .width(63.dp)
                                .height(32.dp)
                                .clickable {
                                    launcher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                }
                        )
                    }


                    /*AsyncImage(
                    model = selectedImageUri,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp).offset(y=70.dp),
                )*/

                }
            }
            Spacer(modifier = Modifier.size(60.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp).fillMaxSize()
            ) {

//                    .drawBehind {
//                        val strokeWidth = 1 * density
//                        val y = size.height - strokeWidth / 2
//                        drawLine(
//                            Color.LightGray,
//                            Offset(0f, y),
//                            Offset(size.width, y),
//                            strokeWidth
//                        )
//                    }

                var name by remember { mutableStateOf("") }
                var edite by remember { mutableStateOf(true) }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Name:",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF4F4F4F),
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clickable {
                                edite = false
                            }
                    )
                }
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        edite = true
                                    },
                    readOnly = edite,
                    placeholder = {
                        Text(
                        text = "Ali Salama",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(255,255,255),
                        unfocusedIndicatorColor = Color(180,180,180)
                    )

                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(top=20.dp)
                ) {
                    Text(
                        text = "Age:",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF4F4F4F),
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clickable {
                                edite = false
                            }
                    )
                }
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        edite = true
                    },
                    readOnly = edite,
                    placeholder = {
                        Text(
                            text = "22",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(255,255,255),
                        unfocusedIndicatorColor = Color(180,180,180)
                    )

                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(top=20.dp)
                ) {
                    Text(
                        text = "Country:",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF4F4F4F),
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clickable {
                                edite = false
                            }
                    )
                }
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        edite = true
                    },
                    readOnly = edite,
                    placeholder = {
                        Text(
                            text = "Egypt",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(255,255,255),
                        unfocusedIndicatorColor = Color(180,180,180)
                    )

                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(top=20.dp)
                ) {
                    Text(
                        text = "Bio:",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF4F4F4F),
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clickable {
                                edite = false
                            }
                    )
                }
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        edite = true
                    },
                    readOnly = edite,
                    placeholder = {
                        Text(
                            text = "write your bio..",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(255,255,255),
                        unfocusedIndicatorColor = Color(180,180,180)
                    )

                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(top=20.dp)
                ) {
                    Text(
                        text = "Language:",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.lato)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF4F4F4F),
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp)
                            .clickable {
                                edite = false
                            }
                    )
                }
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        edite = true
                    },
                    readOnly = edite,
                    placeholder = {
                        Text(
                            text = "Arabic, English",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(255,255,255),
                        unfocusedIndicatorColor = Color(180,180,180)
                    )

                )

            }

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun  ProfileScreenPreview() {
//    LocalGuideTheme {
//        ProfileScreen()
//    }
//}
