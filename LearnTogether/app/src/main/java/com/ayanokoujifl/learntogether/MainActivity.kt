package com.ayanokoujifl.learntogether

import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayanokoujifl.learntogether.R.*
import com.ayanokoujifl.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        HeaderImage(modifier = Modifier.width(IntrinsicSize.Max))
                        TextContent()
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    val image = painterResource(drawable.bg_compose_background)
    Image(painter = image, contentDescription = null, modifier)
}

@Composable
fun TextContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.first_paragraph),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = stringResource(R.string.second_paragraph),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        TextContent(modifier = Modifier)
    }
}