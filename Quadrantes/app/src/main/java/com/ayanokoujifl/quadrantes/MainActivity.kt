package com.ayanokoujifl.quadrantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ayanokoujifl.quadrantes.ui.theme.QuadrantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Quadrante(
                title = "Text composable",
                desc = "Displays text and follows the recommended Material Design " +
                        "guidelines.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFEADDFF)
            )
            Quadrante(
                title = "Image composable",
                desc = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFD0BCFF)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrante(
                title = "Row composable",
                desc = "A layout composable that places its children in a horizontal sequence",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFB69DF8)
            )
            Quadrante(
                title = "Column composable",
                desc = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun Quadrante(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    backgroundColor: Color = Color(0xffffffff)
) {
    Box(modifier) {
        Column(
            Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(desc, textAlign = TextAlign.Justify)
        }
    }
}