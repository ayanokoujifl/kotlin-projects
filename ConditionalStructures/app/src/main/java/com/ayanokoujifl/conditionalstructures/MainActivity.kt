package com.ayanokoujifl.conditionalstructures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ayanokoujifl.conditionalstructures.ui.theme.ConditionalStructuresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        main()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConditionalStructuresTheme {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConditionalStructuresTheme {
        Greeting("Android")
    }
}

fun main() {
    println("Hello World")
    val trafficLightColor = "red"
    if (trafficLightColor == "red") {
        println("STOP!")
    } else if (trafficLightColor == "yellow") {
        println("SLOW...")
    }else{
        println("GO!")
    }
}