package com.example.wristminderpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wristminderpro.ui.theme.WristMinderProTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SettingScreen(navController: NavController) {
    var newUsername by remember { mutableStateOf("") }
    var oldPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2C7FF)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0XFFEAE5FF)
            )
        ) {
            Row(
                modifier = Modifier.background(Color(0XFFEAE5FF)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.weight(1f))
                Text("Setting", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1.2f))
            }
            Column(modifier = Modifier
                .background(Color(0XFFEAE5FF))
                .padding(16.dp)){
                Spacer(modifier = Modifier.height(16.dp))
                Text("New Username", color = Color(0xFF455A64), fontWeight = FontWeight.Bold)
                VerticalCenteredTextField(
                    text = newUsername,
                    onTextChanged = { newUsername = it },
                    isPassword = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 20.dp, top = 12.dp)
                        .height(48.dp)
                        .background(Color(0xFFFBFAFF)),
                    cursorBrush = SolidColor(Color.Black)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Old Password",color = Color(0xFF455A64), fontWeight = FontWeight.Bold)
                VerticalCenteredTextField(
                    text = oldPassword,
                    onTextChanged = { oldPassword = it },
                    isPassword = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 20.dp, top = 12.dp)
                        .height(48.dp)
                        .background(Color(0xFFFBFAFF)),
                    cursorBrush = SolidColor(Color.Black)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Confirm Password", color = Color(0xFF455A64), fontWeight = FontWeight.Bold)
                VerticalCenteredTextField(
                    text = confirmPassword,
                    onTextChanged = { confirmPassword = it },
                    isPassword = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 20.dp, top = 12.dp)
                        .height(48.dp)
                        .background(Color(0xFFFBFAFF)),
                    cursorBrush = SolidColor(Color.Black)
                )

                Button(
                    onClick = {  }, // Navigate to HomeScreen
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFBFAFF),
                        contentColor = Color(0xFF455A64)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Update")
                }

            }
        }

    }
}

