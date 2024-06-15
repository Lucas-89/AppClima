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
    val viewModel : MainPageViewModel = viewModel()
    MainView(
        state = viewModel.uiState,
        onAction = {viewModel.ejecutar(it)}
    )
}

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    state :Estado,
    onAction: (Intencion) -> Unit
) {
//
//    var ciudad = remember {mutableStateOf<String>("Caba")}
//    var temperatura = remember {mutableStateOf<Int>(19)}
//    var descripcion = remember {mutableStateOf<String>("Nublado")}
//    var st = remember {mutableStateOf<Int>(12)}

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(state){
            is Estado.Error -> ErrorView(mensaje = "Este es el mensaje de ERROR")
            is Estado.Exitoso -> ClimaView(ciudad= state.ciudad, temperatura= state.temperatura, descripcion= state.descripcion, st= state.st, latitud= state.latitud, longitud= state.longitud)
            Estado.Vacio -> EmptyView()
        }
        
        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {onAction(Intencion.BorrarTodo)}) {
            Text(text = "Borrar todo")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(Intencion.MostrarCABA)}) {
            Text(text = "Temp CABA")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(Intencion.MostrarCordoba)}) {
            Text(text = "Temp Cordoba")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(Intencion.MostrarError)}) {
            Text(text = "Probar Error")
        }
    }

}

@Composable
fun ErrorView(mensaje: String){
    Text(text = mensaje)
}

@Composable
fun ClimaView(ciudad: String, temperatura: Int, descripcion: String, st: Int, latitud: Long, longitud: Long){
    Column{
        Text(text = ciudad, style = MaterialTheme.typography.bodySmall)
        Text(text = "${temperatura}°", style = MaterialTheme.typography.titleLarge)
        Text(text = descripcion)
        Text(text = "Sensacion Termica: ${st}°")
        Text(text = "Latitud: ${latitud}")
        Text(text = "Longitud: ${longitud}")
    }
}
@Composable
fun EmptyView(){
    Text(text = "Sin informacion, apreta un boton")
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppClimaTheme {
        MainView(state = Estado.Vacio, onAction = {} )
    }
}