package com.jaamcoding.myapplication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaamcoding.myapplication.R
import com.jaamcoding.myapplication.presentation.WeatherViewModel
import com.jaamcoding.myapplication.presentation.components.HeaderTitle
import com.jaamcoding.myapplication.presentation.components.TemperatureIndicator
import com.jaamcoding.myapplication.presentation.ui.theme.DarkBlue
import com.jaamcoding.myapplication.presentation.ui.theme.MyApplicationTheme

@Composable
fun WeatherScreen(modifier: Modifier, onRefreshClick: () -> Unit = {}) {
    val vm: WeatherViewModel = hiltViewModel()
    val state = vm.state  // o collectAsState()
    LaunchedEffect(true) {
        vm.loadWeatherInfo()
    }
    /*Box(modifier) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                HeaderTitle(city = state.weatherInfo?.name, date = "Tuesday 27", "08:41 AM")
                Icon(
                    painter = painterResource(
                        state.weatherInfo?.weatherType?.iconRes ?: R.drawable.ic_sunny
                    ), contentDescription = "Icon row", tint = Color.Unspecified
                )
                TemperatureIndicator(
                    modifier = Modifier.padding(24.dp),
                    temperature = state.weatherInfo?.temperatureCelsius.toString(),
                    tempDescription = state.weatherInfo?.weatherType?.weatherDesc ?: ""
                )
            }
    }*/
    Box(
        modifier = modifier
    ) {
        // 👉 LOADER CENTRADO COMO OVERLAY
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)), // opcional
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        // ERROR
        if (state.error != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)), // opcional
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    fontSize = 18.sp
                )
            }
        }
        // CONTENIDO
        if (!state.isLoading && state.weatherInfo != null) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderTitle(
                    city = state.weatherInfo.name,
                    date = "Tuesday 27",
                    hour = "08:41 AM"
                )

                Icon(
                    painter = painterResource(
                        state.weatherInfo.weatherType.iconRes
                    ),
                    contentDescription = "Icon row",
                    tint = Color.Unspecified
                )

                TemperatureIndicator(
                    modifier = Modifier.padding(24.dp),
                    temperature = state.weatherInfo.temperatureCelsius.toString(),
                    tempDescription = state.weatherInfo.weatherType.weatherDesc
                )
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