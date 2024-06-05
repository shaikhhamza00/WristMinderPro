package com.example.wristminderpro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wristminderpro.ui.theme.WristMinderProTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Activity",
                        color = Color(0XFF455A64),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(0XFFD2C7FF)
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0XFFD2C7FF)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Activity",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp)
                )
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 76.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(
                        count = 6,
                        itemContent = { index ->
                            ActivityCard(
                                reportNumber = "Report No: XYZ",
                                date = "Date: XX/XX/XXXX",
                                downloadedText = "Downloaded"
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    )
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
                        isActive = true,
                        onClick = {  }
                    )
                    BottomBarItem(
                        icon = Icons.Default.MoreVert,
                        text = "More",
                        isActive = false,
                        onClick = { navController.navigate("more") }
                    )
                }
            }
        }
    )
}

@Composable
fun ActivityCard(
    reportNumber: String,
    date: String,
    downloadedText: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            Color(0xFFE4E4E4)
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = downloadedText,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold,color = Color(0XFF455A64))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.dowload_icon),
                    contentDescription = "Download Icon",
                    modifier = Modifier.size(50.dp).weight(1f))
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(2f)) {
                    Text(
                        text = reportNumber,
                        style = TextStyle(fontSize = 14.sp, color = Color(0XFF455A64),)
                    )
                    Text(
                        text = date,
                        style = TextStyle(fontSize = 14.sp, color = Color(0XFF455A64),)
                    )
                }
            }
        }
    }
}

