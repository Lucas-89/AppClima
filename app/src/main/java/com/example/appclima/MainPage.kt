package com.example.appclima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclima.ui.theme.AppClimaTheme


@Composable
fun MainPage(modifier: Modifier = Modifier) {

    var ciudad = remember {mutableStateOf<String>("Caba")}
    var temperatura = remember {mutableStateOf<Int>(19)}
    var descripcion = remember {mutableStateOf<String>("Nublado")}
    var st = remember {mutableStateOf<Int>(12)}

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = ciudad.value, style = MaterialTheme.typography.bodySmall)
        Text(text = "${temperatura.value}°", style = MaterialTheme.typography.titleLarge)
        Text(text = descripcion.value)
        Text(text = "Sensacion Termica: ${st.value}°")
    }

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppClimaTheme {
        MainPage()
    }
}