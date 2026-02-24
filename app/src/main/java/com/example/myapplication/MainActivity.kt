package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.* // Imports all M3 components
import androidx.compose.runtime.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
//import androidx.compose.foundation.layout.weight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var checked by remember { mutableStateOf(true) }
    var switchChecked by remember { mutableStateOf(true) }
    Column(            modifier = Modifier
        .fillMaxSize()
    ) {
        TopAppBar(title = {Text("Settings")})
        ListItem(modifier = Modifier.fillMaxWidth().heightIn(min = 72.dp).padding(4.dp).border(width = 1.dp, color = Color.Blue),
            headlineContent = { Text("Settings 1")},
            trailingContent = {Switch(checked = switchChecked,
                onCheckedChange = {switchChecked = it})})

        HorizontalDivider()
        ListItem(modifier = Modifier.fillMaxWidth().heightIn(min = 72.dp).padding(4.dp).border(width = 1.dp, color = Color.Blue),
            headlineContent = { Text("Settings 2")},
            trailingContent = {Checkbox(checked = checked,
                onCheckedChange = {checked = it})})

        HorizontalDivider()

        ListItem(modifier = Modifier.fillMaxWidth().heightIn(min = 72.dp).padding(4.dp).border(width = 1.dp, color = Color.Blue),
            headlineContent = { Text("Settings 3")},
            trailingContent = {Button(onClick = {}) {
                Text("Press me!")
            }})
        }
        HorizontalDivider()
//        Text(modifier = Modifier.border())
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "",
        modifier = modifier
    )
    SettingsScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SettingsScreen()
}