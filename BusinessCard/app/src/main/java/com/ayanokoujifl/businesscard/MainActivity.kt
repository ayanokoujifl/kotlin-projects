package com.ayanokoujifl.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayanokoujifl.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(color = Color(0xFFC8E5EF), modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.atomic)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(224.dp)
                .background(Color(0xFF94A3B8), shape = CircleShape)
                .padding(16.dp)
        )
        Text(
            text = "Luís Gustavo",
            fontSize = 32.sp,
            color = Color(0, 116, 124, 255),
            fontWeight = FontWeight.Bold,
        )
        Text(text = "Android Developer Atomic", fontSize = 20.sp)
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 72.dp)
    ) {
        Contact(Icons.Filled.Call, "+55 (38)9 9756-9902")
        Contact(Icons.Filled.Share, "@dev_atomic_journey")
        Contact(Icons.Filled.Email, "devatomicjourney@gmail.com")
    }
}

@Composable
fun Contact(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth(0.8f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF22C55E),
            modifier = Modifier.padding(end = 12.dp)
        )
        Text(
            text,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}