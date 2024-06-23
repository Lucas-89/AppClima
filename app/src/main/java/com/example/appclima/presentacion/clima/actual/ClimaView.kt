package com.example.appclima.presentacion.clima.actual

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.appclima.ui.theme.AppClimaTheme


@Composable
fun ClimaView(
    modifier: Modifier = Modifier,
    state : ClimaEstado,
    onAction: (ClimaIntencion) -> Unit
) {
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME){
        onAction(ClimaIntencion.ActualizarClima)
    }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(state){
            is ClimaEstado.Error -> ErrorView(mensaje = state.mensaje)
            is ClimaEstado.Exitoso -> ClimaView(
                ciudad = state.ciudad,
                temperatura = state.temperatura,
                descripcion = state.descripcion,
                st = state.st,
                latitud = state.latitud,
                longitud = state.longitud
            )
            ClimaEstado.Vacio -> LoadingView()
            ClimaEstado.Cargando -> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))

    }

}

@Composable
fun ErrorView(mensaje: String){
    Text(text = mensaje)
}

@Composable
fun LoadingView(){
    Text(text = "Buscando Ciudad")
}

@Composable
fun ClimaView(ciudad: String, temperatura: Double, descripcion: String, st: Double, latitud: Double, longitud: Double){
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
    Text(text = "Sin informacion")
}

////////////////////////////////////////////////////////////////
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
            temperatura = 20.0,
            descripcion = "Ventoso",
            st = 19.0,
            latitud = 6952.0,
            longitud = 210.0
        ), onAction = {} )
    }
}