package com.example.appclima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclima.ui.theme.AppClimaTheme


@Composable
fun MainPage(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "CABA", style = MaterialTheme.typography.bodySmall)
        Text(text = "19°", style = MaterialTheme.typography.titleLarge)
        Text(text = "Nublado")
        Text(text = "Sensacion Termica: 16°")
    }

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppClimaTheme {
        MainPage()
    }
}