package com.ayanokoujifl.ktclickupeffect.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionOnScreen
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class FilterItem(val name: String, val colors: List<Color>)

val filters = listOf(
    FilterItem("My Work", listOf(Color(0xFFFF8C00), Color(0xFFFF0080))),
    FilterItem("Recent", listOf(Color(0xFF6A5ACD), Color(0xFF00FFFF))),
    FilterItem("Favorites", listOf(Color(0xFFFF4500), Color(0xFFFFD700))),
    FilterItem("Spaces", listOf(Color(0xFF32CD32), Color(0xFF008080))),
    FilterItem("Docs", listOf(Color(0xFFFF1493), Color(0xFF9400D3))),
    FilterItem("Dashboard", listOf(Color(0xFF1E90FF), Color(0xFF00FA9A)))
)

@Composable
fun FilterNav(modifier: Modifier = Modifier) {
    var selectedFilter by remember { mutableStateOf(filters[0]) }
    val centerX = remember { Animatable(0f) }
    val buttonPositions = remember { mutableStateMapOf<String, Float>() }

    LaunchedEffect(selectedFilter) {
        val targetPosition = buttonPositions[selectedFilter.name] ?: 0f
        centerX.animateTo(targetPosition)
    }
    Box(
        modifier = modifier
            .height(120.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxHeight(1f).fillMaxWidth()
        ) {
            drawRect(
                brush = Brush.radialGradient(
                    colors = listOf(selectedFilter.colors[0].copy(alpha = 0.5f), Color.Transparent),
                    center = Offset(centerX.value, 1f),
                    radius = size.width * 0.6f,
                ),
            )
        }
        LazyRow(
            modifier = Modifier.padding(top = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filters) { item ->
                Column(modifier = Modifier.fillMaxHeight()) {
                    FilterButton(item, isSelected = item == selectedFilter) { xPosition ->
                        selectedFilter = item
                        buttonPositions[item.name] = xPosition
                    }
                }
            }
        }
    }
}

@Composable
fun FilterButton(filter: FilterItem, isSelected: Boolean, onClick: (Float) -> Unit) {
    var buttonX by remember { mutableStateOf(0f) }

    Button(
        modifier = Modifier
            .padding(16.dp)
            .onGloballyPositioned { coordinates ->
                val positionX =
                    coordinates.positionOnScreen().x + coordinates.size.width.toFloat() / 2f
                println("Posição em X: $positionX")
                buttonX = positionX
            },
        onClick = { onClick(buttonX) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = filter.name,
            color = if (isSelected) filter.colors[0] else Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}