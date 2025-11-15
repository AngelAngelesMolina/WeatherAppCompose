package com.jaamcoding.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TemperatureIndicator(
    modifier: Modifier = Modifier, temperature: String = "25",
    tempDescription: String = "Partly Cloud"
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "$temperature°C", fontSize = 60.sp, modifier = Modifier.weight(0.6f))
        Text(text = tempDescription, fontSize = 24.sp, modifier = Modifier.weight(0.4f), textAlign = TextAlign.End)
    }
}


@Preview(showBackground = true)
@Composable
fun TemperatureIndicatorPrev() {
    TemperatureIndicator()
}