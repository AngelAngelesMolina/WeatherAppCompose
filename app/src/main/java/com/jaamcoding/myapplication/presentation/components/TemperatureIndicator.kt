package com.jaamcoding.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TemperatureIndicator(
    modifier: Modifier = Modifier,
    temperature: String = "25",
    tempDescription: String = "Partly Cloud"
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$temperature°C",
            fontSize = 60.sp,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = tempDescription,
            fontSize = 24.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.wrapContentWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TemperatureIndicatorPrev() {
    TemperatureIndicator()
}