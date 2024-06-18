package com.example.appclima.presentacion.clima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appclima.ui.theme.AppClimaTheme


@Composable
fun ClimaView(
    modifier: Modifier = Modifier,
    state : ClimaEstado,
    onAction: (ClimaIntencion) -> Unit
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
            is ClimaEstado.Error -> ErrorView(mensaje = "Este es el mensaje de ERROR")
            is ClimaEstado.Exitoso -> ClimaView(
                ciudad = state.ciudad,
                temperatura = state.temperatura,
                descripcion = state.descripcion,
                st = state.st,
                latitud = state.latitud,
                longitud = state.longitud
            )
            ClimaEstado.Vacio -> EmptyView()
            ClimaEstado.Cargando -> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = {onAction(ClimaIntencion.BorrarTodo)}) {
            Text(text = "Borrar todo")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(ClimaIntencion.MostrarCABA)}) {
            Text(text = "Temp CABA")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(ClimaIntencion.MostrarCordoba)}) {
            Text(text = "Temp Cordoba")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {onAction(ClimaIntencion.MostrarError)}) {
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
fun ClimaPreviewVacio() {
    AppClimaTheme {
        ClimaView(state = ClimaEstado.Vacio, onAction = {} )
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPreviewError() {
    AppClimaTheme {
        ClimaView(state = ClimaEstado.Error("Esta roto"), onAction = {} )
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPreviewExitoso() {
    AppClimaTheme {
        ClimaView(state = ClimaEstado.Exitoso(
            ciudad = "Monte Chingolo",
            temperatura = 20,
            descripcion = "Ventoso",
            st = 19,
            latitud = 6952,
            longitud = 210
        ), onAction = {} )
    }
}