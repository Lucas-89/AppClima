package com.example.appclima.presentacion.ciudades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appclima.presentacion.clima.ClimaEstado
import com.example.appclima.presentacion.clima.ClimaIntencion
import com.example.appclima.repository.modelos.Ciudad

@Composable
fun CiudadesView(
    modifier: Modifier = Modifier,
    state : CiudadesEstado,
    onAction: (CiudadesIntencion) -> Unit
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(top =40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var ciudadABuscar by remember { mutableStateOf("") }

        TextField(value = ciudadABuscar, onValueChange = {
            ciudadABuscar = it
        })

        Button(onClick = { //aca deberia usar Intencion.Seleccionar
            if (ciudadABuscar.isNotEmpty()) {
                onAction(CiudadesIntencion.BuscarCiudad(ciudadABuscar))
            } else {
                onAction(CiudadesIntencion.BuscarCiudad(""))
            }
        }
        ) {
            Text(
                modifier = modifier,
                text = "Buscar"
            )
        }
        when (state) {
            CiudadesEstado.Vacio -> EmptyView()
            CiudadesEstado.Cargando -> {Text(text = "Cargando")}
            is CiudadesEstado.Resultado -> ListaDeCiudades(state.ciudades, {onAction(CiudadesIntencion.SeleccionarCiudad(it))})
            is CiudadesEstado.Error -> {Text(text = state.mensajeError)}
        }
    }
}

@Composable
fun EmptyView(){Text(text = "Sin Resultados")}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeCiudades(ciudades: Array<Ciudad>, onSelect:(Ciudad)-> Unit){
    //TODO aca va el resultado de la buqueda, seria una lista de ciudades
    //aca falta la logica para que si la busqueda no da resultados lo muestre
    LazyColumn {
        items(items = ciudades){
            Card(onClick = { onSelect(it) }){
               Text(text = it.nombre)
            }
        }
    }
}