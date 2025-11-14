package com.jaamcoding.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jaamcoding.myapplication.R

@Composable
fun HeaderTitle(
    city: String,
    date: String,
    hour: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Text(text = city, fontSize = 18.sp)
            Icon(
                painter = painterResource(R.drawable.outline_arrow_outward),
                contentDescription = "Icon row", modifier = Modifier.size(20.dp)
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = date, fontSize = 18.sp, textAlign = TextAlign.End)
                Text(text = hour, fontSize = 18.sp, textAlign = TextAlign.End)

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    HeaderTitle(city = "Jakarta", date = "Tuesday 27", hour = "08:41 AM")
}