package com.example.wristminderpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wristminderpro.ui.theme.WristMinderProTheme

@Composable
fun LoginPage(
    onNavigateToHome: () -> Unit,
    onNavigateToSignup: () -> Unit,
    onNavigateToForget: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2C7FF))
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Login",
            color = Color(0xFF455A64),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Column {
            Text(
                text = "Email/Username",
                color = Color(0xFF455A64),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            VerticalCenteredTextField(
                text = email,
                onTextChanged = { email = it },
                false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 20.dp, top = 12.dp)
                    .height(48.dp)
                    .background(Color(0xFFEAE5FF)),
                cursorBrush = SolidColor(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Text(
                text = "Password",
                color = Color(0xFF455A64),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            VerticalCenteredTextField(
                text = password,
                onTextChanged = { password = it },
                true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 20.dp)
                    .height(48.dp)
                    .background(Color(0xFFEAE5FF)),
                cursorBrush = SolidColor(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNavigateToHome,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEAE5FF),
                contentColor = Color(0xFF455A64)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = onNavigateToForget,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Forgot your Password?",
                color = Color(0xFF455A64),)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("New here?",
                color = Color(0xFF455A64),)
            TextButton(
                onClick = onNavigateToSignup,
            ) {
                Text("Sign Up",
                    color = Color(0xFF455A64),)
            }
        }
        Spacer(modifier = Modifier.weight(7f))
    }
}