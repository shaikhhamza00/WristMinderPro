package com.example.wristminderpro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wristminderpro.ui.theme.WristMinderProTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun UploadScreen(navController: NavController) {
    val ageList = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    val selectedText = remember {
        mutableStateOf(ageList[0])
    }
    val expended = remember {
        mutableStateOf(false)
    }

    val gender = arrayOf("Male","Female")
    val selectedGender = remember {
        mutableStateOf(gender[0])
    }
    val expandedGender = remember {
        mutableStateOf(false)
    }
    val buttonHeight = 60.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2C7FF))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Upload your Image",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF455A64)),
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Black
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Button(
            onClick = { /* Handle Upload button click */ },
            modifier = Modifier.fillMaxWidth().height(buttonHeight),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFFEAE5FF),
                contentColor = Color(0XFF455A64)
            )
        ) {
            Text("File Picker")
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        ExposedDropdownMenuBox(
            expanded = expandedGender.value,
            onExpandedChange = {
                expandedGender.value = !expandedGender.value
            }) {
            TextField(
                value = selectedGender.value,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expended.value)
                },
                placeholder = { Text("Gender") },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .height(buttonHeight))
            ExposedDropdownMenu(
                expanded = expandedGender.value,
                onDismissRequest = { expandedGender.value = false }) {
                gender.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it) },
                        onClick = {
                            selectedGender.value = it
                            expandedGender.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        ExposedDropdownMenuBox(
            expanded = expended.value,
            onExpandedChange = {
                expended.value = !expended.value
            }) {
            TextField(
                value = selectedText.value.toString(),
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expended.value)
                },
                placeholder = { Text("Age") },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .height(buttonHeight))
            ExposedDropdownMenu(
                expanded = expended.value,
                onDismissRequest = { expended.value = false }) {
                ageList.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it.toString()) },
                        onClick = {
                            selectedText.value = it
                            expended.value = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Button(
            onClick = { /* Handle Upload button click */ },
            modifier = Modifier.fillMaxWidth().height(buttonHeight),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFFEAE5FF),
                contentColor = Color(0XFF455A64)
            )
        ) {
            Text("Generate Report")
        }
    }
}

