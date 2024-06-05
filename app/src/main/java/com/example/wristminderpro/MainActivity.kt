package com.example.wristminderpro

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.GestureDetectorCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            val navController = rememberNavController()

            NavHost(navController, startDestination = "splash") {
                composable("splash") {
                    SplashScreen(onTimeout = { navController.navigate("onboarding") })
                }
                composable("onboarding") {
                    OnboardingScreen(onNavigateToLogin = { navController.navigate("login") },
                        context = context)
                }
                composable("login") {
                    LoginPage(
                        onNavigateToHome = { navController.navigate("home") },
                        onNavigateToSignup = { navController.navigate("signup") },
                        onNavigateToForget = {navController.navigate("forget")}
                    )
                }
                composable("signup") {
                    SignupScreen(
                        onNavigateToLogin = { navController.navigate("login") },
                        onNavigateToHome = { navController.navigate("home") }
                    )
                }
                composable("home") {
                   Homescreen(navController)
                }
                composable("scanxray"){
                    ScanScreen()
                }
                composable("uploadscreen"){
                    UploadScreen(navController = navController)
                }
                composable("activityscreen"){
                    ActivityScreenContent(navController = navController)
                }
                composable("more"){
                    MoreScreen(navController = navController)
                }
                composable("invite"){
                    InviteScreen(navController = navController)
                }
                composable("help"){
                    HelpScreen(navController = navController)
                }
                composable("about"){
                    AboutUsScreen(navController = navController)
                }
                composable("setting"){
                    SettingScreen(navController = navController)
                }
                composable("forget"){
                    ForgotPasswordScreen(onUpdatePassword = { newPassword, confirmPassword ->
                    },
                        onDismiss = {},
                        navController = navController)
                }
            }
        }
    }
}
@Composable
fun OnboardingScreen(
    context: Context,
    onNavigateToLogin: () -> Unit
) {
    var currentPage by remember { mutableStateOf(0) }
    val imageResources = listOf(
        R.drawable.step1,
        R.drawable.step2,
        R.drawable.step3,
        R.drawable.step4,
        R.drawable.step5
    )

    val animateTargetPage by animateIntAsState(targetValue = currentPage)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val gestureDetector = remember {
            GestureDetectorCompat(
                context,
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onDown(e: MotionEvent): Boolean {
                        return true
                    }

                    override fun onScroll(
                        e1: MotionEvent?,
                        e2: MotionEvent,
                        distanceX: Float,
                        distanceY: Float
                    ): Boolean {
                        if (distanceX > 0 && currentPage > 0) {
                            currentPage--
                        } else if (distanceX < 0 && currentPage < imageResources.size - 1) {
                            currentPage++
                        }
                        return true
                    }
                }
            )
        }
        val touchEvent = Modifier.pointerInput(Unit) {
            detectDragGestures(
                onDrag = { change, dragAmount ->
                    if (dragAmount.x.absoluteValue > 80) {
                        if (dragAmount.x > 0 && currentPage > 0) {
                            currentPage--
                        } else if (dragAmount.x < 0 && currentPage < imageResources.size - 1) {
                            currentPage++
                        }
                        change.consumeAllChanges()
                    }
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(touchEvent)
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color(0xFFD2C7FF),
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BackButton(onBack = {
                        if (currentPage > 0) {
                            currentPage--
                        }
                    })
                    Spacer(modifier = Modifier.weight(1f))
                    SkipButton(onSkip = {
                        onNavigateToLogin()
                    })
                }
                // Bottom content: dots
                DotsIndicator(
                    currentIndex = currentPage,
                    numberOfDots = imageResources.size
                )
            }
            Image(
                painter = painterResource(id = imageResources[animateTargetPage]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
            )
        }



    }
}


@Composable
fun SkipButton(onSkip: () -> Unit) {
    Button(
        onClick = onSkip,
        modifier = Modifier.sizeIn(minHeight = 48.dp)
    ) {
        Text(text = "Skip")
    }
}

@Composable
fun BackButton(onBack: () -> Unit) {
    IconButton(
        onClick = onBack,
        modifier = Modifier.size(48.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back"
        )
    }
}

@Composable
fun DotsIndicator(
    currentIndex: Int,
    numberOfDots: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFD2C7FF)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(numberOfDots) { index ->
                Dot(currentIndex == index)
            }
        }
    }
}

@Composable
fun Dot(isSelected: Boolean) {
    val color = if (isSelected) Color.Black else Color.Gray
    Box(
        modifier = Modifier
            .size(12.dp)
            .background(color, shape = CircleShape)
    )
}

