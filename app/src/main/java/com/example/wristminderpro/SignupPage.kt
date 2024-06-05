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
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
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

class SignupPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WristMinderProTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun SignupScreen(onNavigateToLogin: () -> Unit, onNavigateToHome: () -> Unit) {
    val buttonColor = Color(0xFFDAD7F3) // Define button color

    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
            text = "Signup",
            color = Color(0xFF455A64),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Column {
            Text(
                text = "Email",
                color = Color(0xFF455A64),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            VerticalCenteredTextField(
                text = email,
                onTextChanged = { email = it },
                false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 20.dp)
                    .height(48.dp)
                    .background(Color(0xFFEAE5FF)),
                cursorBrush = SolidColor(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Text(
                text = "Username",
                color = Color(0xFF455A64),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            VerticalCenteredTextField(
                text = username,
                onTextChanged = { username = it },
                false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 20.dp)
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
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Text(
                text = "Confirm Password",
                color = Color(0xFF455A64),
                modifier = Modifier.padding(bottom = 12.dp)
            )
            VerticalCenteredTextField(
                text = confirmPassword,
                onTextChanged = { confirmPassword = it },
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
            onClick = onNavigateToHome, // Navigate to HomeScreen
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEAE5FF),
                contentColor = Color(0xFF455A64)
            ), // Set button color
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Signup")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Already have an account? ",
                color = Color(0xFF455A64),)
            TextButton(
                onClick = onNavigateToLogin // Navigate to LoginScreen
            ) {
                Text("Login",
                    color = Color(0xFF455A64),)
            }
        }
        Spacer(modifier = Modifier.weight(7f))
    }
}
