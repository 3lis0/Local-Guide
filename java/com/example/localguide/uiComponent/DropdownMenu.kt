package com.example.localguide

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.localguide.ui.theme.LocalGuideTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(options: List<String>) {
    //val options = listOf("Guides", "Locals")
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedOptionText by rememberSaveable { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField  (
            modifier = Modifier
                .menuAnchor()
                .border(width = 0.dp, color = Color(0xFFFFFFFF))
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
            shape = RoundedCornerShape(bottomEnd = 20.dp, topEnd = 20.dp, topStart = 0.dp, bottomStart = 0.dp)
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
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DropdownMenuPreview() {
    LocalGuideTheme {
        MyExposedDropdownMenu(listOf("Guides", "Locals"))
    }
}