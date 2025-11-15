package com.jaamcoding.myapplication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaamcoding.myapplication.R
import com.jaamcoding.myapplication.presentation.WeatherViewModel
import com.jaamcoding.myapplication.presentation.components.HeaderTitle
import com.jaamcoding.myapplication.presentation.components.TemperatureIndicator
import com.jaamcoding.myapplication.presentation.ui.theme.DarkBlue
import com.jaamcoding.myapplication.presentation.ui.theme.MyApplicationTheme

@Composable
fun WeatherScreen(modifier: Modifier, onRefreshClick : () -> Unit ={}) {
    val vm: WeatherViewModel = hiltViewModel()
    val state = vm.state  // o collectAsState()
    Box(modifier) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            HeaderTitle(city = state.weatherInfo?.name, date = "Tuesday 27", "08:41 AM")
            Icon(painter = painterResource(state.weatherInfo?.weatherType?.iconRes ?: R.drawable.ic_sunny), contentDescription = "Icon row",  tint = Color.Unspecified)
            TemperatureIndicator(modifier = Modifier.padding(24.dp), temperature = state.weatherInfo?.temperatureCelsius.toString(), tempDescription = state.weatherInfo?.weatherType?.weatherDesc ?: "")
            Button(onClick = {vm.loadWeatherInfo()}) {
                Text(text = "Refresh")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun WeatherScreenPreview() {
    MyApplicationTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue),
            containerColor = Color.Transparent
        ) { innerPadding ->
            WeatherScreen(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(8.dp)
            )
        }
    }
}