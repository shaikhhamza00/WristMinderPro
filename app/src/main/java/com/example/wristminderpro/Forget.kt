package com.example.wristminderpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wristminderpro.ui.theme.WristMinderProTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    onUpdatePassword: (String, String) -> Unit,
    onDismiss: () -> Unit,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var bottomSheetVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2C7FF))
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Forgot Password",
            color = Color(0xFF455A64),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Column {
            Text(
                text = "Enter Email",
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

        Button(
            onClick = {
                bottomSheetVisible = true
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEAE5FF),
                contentColor = Color(0xFF455A64)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update")
        }

    }

    if (bottomSheetVisible) {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFFD2C7FF),
            tonalElevation = 16.dp,
        ) {
            BottomSheetScaffold(
                sheetContainerColor = Color.White,
                sheetContent = {
                    ForgotPasswordContent(
                        onUpdatePassword = onUpdatePassword,
                        newPassword = newPassword,
                        confirmPassword = confirmPassword,
                        onDismissBottomSheet = { bottomSheetVisible = false },
                        onConfirmPasswordChange = { newValue ->
                            confirmPassword = newValue
                        }
                    )
                },
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                sheetPeekHeight = 350.dp,
                modifier = Modifier.fillMaxSize(),
                scaffoldState = rememberBottomSheetScaffoldState(),
                content = {

                    ForgotPasswordScreen(
                        onUpdatePassword = onUpdatePassword,
                        onDismiss = onDismiss,
                        navController = navController
                    )
                }
            )
        }
    }
}

@Composable
fun ForgotPasswordContent(
    onUpdatePassword: (String, String) -> Unit,
    newPassword: String,
    confirmPassword: String,
    onDismissBottomSheet: () -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            text = "New Password",
            color = Color(0xFF455A64),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        VerticalCenteredTextField(
            text = newPassword,
            onTextChanged = { onUpdatePassword(it, confirmPassword) },
            true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 20.dp)
                .height(48.dp)
                .background(Color(0xFFEAE5FF)),
            cursorBrush = SolidColor(Color.Black)
        )
        Text(
            text = "Confirm Password",
            color = Color(0xFF455A64),
            modifier = Modifier.padding(bottom = 12.dp)
        )
        VerticalCenteredTextField(
            text = confirmPassword,
            onTextChanged = { onConfirmPasswordChange(it) },
            true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 20.dp)
                .height(48.dp)
                .background(Color(0xFFEAE5FF)),
            cursorBrush = SolidColor(Color.Black)
        )
        Button(
            onClick = {
                onUpdatePassword(newPassword, confirmPassword)
                onDismissBottomSheet()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEAE5FF),
                contentColor = Color(0xFF455A64)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm")
        }
    }
}


