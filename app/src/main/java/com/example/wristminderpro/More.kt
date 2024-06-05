package com.example.wristminderpro

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wristminderpro.ui.theme.WristMinderProTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController) {
    val buttonHeight = 58.dp
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Menu",
                        color = Color(0XFF455A64),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(0XFFD2C7FF)
                )
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0XFFD2C7FF))
                    .padding(top = 60.dp, bottom = 76.dp) // Adjust bottom padding to accommodate bottom bar
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0XFFEAE5FF)
                        ),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painter = rememberVectorPainter(Icons.Default.AccountCircle),
                                contentDescription = "Profile Icon",
                                modifier = Modifier.size(100.dp)
                            )
                            Text("Hi, User", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0XFF455A64)))
                            Text("User3018He56",color = Color(0XFF455A64))
                        }
                    }
                }
                item {
                    val buttonHeight = 56.dp
                    Button(
                        onClick = { navController.navigate("invite") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .height(buttonHeight),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0XFFEAE5FF),
                            contentColor = Color(0XFF455A64)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Share,
                                contentDescription = "Invite Icon",
                                modifier = Modifier.size(26.dp))
                            Text("Invite Friend")
                        }
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("setting") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .height(buttonHeight),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0XFFEAE5FF),
                            contentColor = Color(0XFF455A64)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Settings,
                                contentDescription = "Setting",
                                modifier = Modifier.size(26.dp))
                            Text("Setting         ")
                        }
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("help") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .height(buttonHeight),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0XFFEAE5FF),
                            contentColor = Color(0XFF455A64)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Call,
                                contentDescription = "Help",
                                modifier = Modifier.size(26.dp))
                            Text("Help            ")
                        }
                    }
                }
                item {
                    Button(
                        onClick = { navController.navigate("help") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .height(buttonHeight),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0XFFEAE5FF),
                            contentColor = Color(0XFF455A64)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Info,
                                contentDescription = "About us",
                                modifier = Modifier.size(26.dp))
                            Text("About us   ")
                        }
                    }
                }
                item {
                    Column(modifier = Modifier.fillMaxWidth().padding(top = 18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(
                            onClick = { navController.navigate("login") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0XFFEAE5FF),
                                contentColor = Color(0XFF455A64)
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text("Logout")
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFEAE5FF),
                contentColor = Color.Black,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomBarItem(
                        icon = Icons.Default.Home,
                        text = "Home",
                        isActive = false,
                        onClick = { navController.navigate("home") }
                    )
                    BottomBarItem(
                        icon = Icons.Default.List,
                        text = "Activity",
                        isActive = false,
                        onClick = { navController.navigate("activityscreen") }
                    )
                    BottomBarItem(
                        icon = Icons.Default.MoreVert,
                        text = "More",
                        isActive = true,
                        onClick = { /* Handle More click */ }
                    )
                }
            }
        }
    )
}


@Preview(showSystemUi = true)
@Composable
fun MoreScreenPreview() {
    WristMinderProTheme {
        val navController = rememberNavController()
        MoreScreen(navController = navController)
    }
}