package com.example.localguide.uiComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.localguide.ui.theme.LocalGuideTheme

@Composable
fun ArrowButton() {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription ="",
            tint = Color(0,0,0),
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clickable {  }
        )

}

@Preview(showBackground = true)
@Composable
fun ArrowButtonPreview() {
    LocalGuideTheme {
        ArrowButton()
    }
}
