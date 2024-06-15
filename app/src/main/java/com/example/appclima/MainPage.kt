package com.example.appclima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun MainPage(modifier: Modifier){
    MainView(viewModel = viewModel())
}

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    viewModel:MainPageViewModel
) {


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
        Text(text = viewModel.ciudad.value, style = MaterialTheme.typography.bodySmall)
        Text(text = "${viewModel.temperatura.value}°", style = MaterialTheme.typography.titleLarge)
        Text(text = viewModel.descripcion.value)
        Text(text = "Sensacion Termica: ${viewModel.st.value}°")

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {viewModel.borrarTodo()}) {
            Text(text = "Borrar todo")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {viewModel.mostrarCABA()}) {
            Text(text = "Temp CABA")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {viewModel.mostrarCordoba()}) {
            Text(text = "Temp Cordoba")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppClimaTheme {
        MainView(viewModel = viewModel())
    }
}