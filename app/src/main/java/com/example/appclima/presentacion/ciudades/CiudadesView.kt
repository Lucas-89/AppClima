package com.example.appclima.presentacion.ciudades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var ciudadABuscar by remember { mutableStateOf("") }
        Text(
            modifier = modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 35.dp, bottom = 15.dp),
            text = "Buscador de climas"
        )
        Spacer(modifier = modifier.padding(15.dp))
        TextField(value = ciudadABuscar, onValueChange = {
            ciudadABuscar = it
        })
        Spacer(modifier = modifier.padding(15.dp))

        Button(onClick = { //aca deberia usar Intencion.Seleccionar
            if (ciudadABuscar.isNotEmpty()) {
                onAction(CiudadesIntencion.BuscarCiudad(ciudadABuscar)) // habra que cambiar esto y colocarle seleccionar? no
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
        Spacer(modifier = modifier.padding(15.dp))

        when (state) {
            is CiudadesEstado.Error -> Text(text = state.mensajeError)
            CiudadesEstado.Cargando -> {Text(text = "Cargando")}
            is CiudadesEstado.Resultado -> ListaDeCiudades(state.ciudades) {
                onAction(
                    CiudadesIntencion.SeleccionarCiudad(it)
                )
            }
            is CiudadesEstado.Vacio -> Text(text = "No hay resultados")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeCiudades(ciudades: List<Ciudad>, onSelect:(Ciudad)-> Unit){
    LazyColumn {
        items(items = ciudades){
            Card(onClick = { onSelect(it) }){
               Text(text = it.name)
            }
        }
    }
}