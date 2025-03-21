package com.ayanokoujifl.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayanokoujifl.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_msg),
                        from = stringResource(R.string.signature)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Text(
            text = message,
            fontSize = 64.sp,
            lineHeight = 64.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF5B1DA2)

        )
        Text(
            text = "By \n${from}",
            fontSize = 32.sp,
            color = Color(0xFF05CAFF),
            lineHeight = 32.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
                .background(Color.White).padding(12.dp)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = "background image",
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        Greeting(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_msg),
            from = stringResource(R.string.signature)
        )
    }
}