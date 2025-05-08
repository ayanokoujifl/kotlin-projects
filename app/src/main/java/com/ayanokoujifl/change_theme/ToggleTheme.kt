package com.ayanokoujifl.change_theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToggleTheme(isDarkTheme: Boolean, onToggleTheme: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp).padding(top = 32.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = if (isDarkTheme) "Modo Escuro" else "Modo Claro",
            style = MaterialTheme.typography.bodyLarge
        )
        Switch(
            checked = isDarkTheme,
            onCheckedChange = { onToggleTheme(it) },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedThumbColor = MaterialTheme.colorScheme.background,
            )
        )
    }
}