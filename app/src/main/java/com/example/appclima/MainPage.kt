package com.example.appclima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appclima.ui.theme.AppClimaTheme


@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val viewModel:MainPageViewModel = viewModel()

    var ciudad = remember {mutableStateOf<String>("Caba")}
    var temperatura = remember {mutableStateOf<Int>(19)}
    var descripcion = remember {mutableStateOf<String>("Nublado")}
    var st = remember {mutableStateOf<Int>(12)}

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = ciudad.value, style = MaterialTheme.typography.bodySmall)
        Text(text = "${temperatura.value}°", style = MaterialTheme.typography.titleLarge)
        Text(text = descripcion.value)
        Text(text = "Sensacion Termica: ${st.value}°")

        Button(
            onClick = {
                ciudad.value = ""
                temperatura.value = 0
                descripcion.value = ""
                st.value = 0
            }
        ) {
            Text(text = "Borrar todo")
        }

        Button(
            onClick = {
                ciudad.value = "CABA"
                temperatura.value = 10
                descripcion.value = "Sigue Nublado"
                st.value = 900
            }
        ) {
            Text(text = "Temp CABA")
        }

        Button(
            onClick = {
                ciudad.value = "Cordoba"
                temperatura.value = 20
                descripcion.value = "Cuidad de Cordoba"
                st.value = 25
            }
        ) {
            Text(text = "Temp Cordoba")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppClimaTheme {
        MainPage()
    }
}