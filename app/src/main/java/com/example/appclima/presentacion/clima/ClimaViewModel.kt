package com.example.appclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appclima.repository.Clima

class ClimaViewModel: ViewModel() {
    //unico estado observable
    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)
//
//    var ciudad =  mutableStateOf<String>("--")
//    var temperatura =  mutableStateOf<Int>(0)
//    var descripcion =  mutableStateOf<String>("--")
//    var st =  mutableStateOf<Int>(0)
//    var longitud =  mutableStateOf<Long>(0)
//    var latitud = mutableStateOf<Long>(0)
//    var noHayDatos = mutableStateOf<Boolean>(true)

    private val climaCordoba = Clima(
        temperatura = 20,
        descripcion = "Ventoso",
        st = 25,
        ciudad = "Cordoba",
        latitud = 35126,
        longitud = 52414
    )

    private val climaCABA = Clima(
        temperatura = 15,
        descripcion = "Soleado",
        st = 12,
        ciudad = "CABA",
        latitud = 6852,
        longitud = 854741
    )

    fun ejecutar(intencion: ClimaIntencion) {
        when(intencion){
            ClimaIntencion.BorrarTodo -> borrarTodo()
            ClimaIntencion.MostrarCABA -> mostrarCABA()
            ClimaIntencion.MostrarCordoba -> mostrarCordoba()
            ClimaIntencion.MostrarError -> mostrarError()
        }
    }

    private fun borrarTodo(){
        uiState = ClimaEstado.Vacio
    }

    private fun mostrarCABA(){
        uiState= ClimaEstado.Exitoso (
            ciudad = climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.descripcion,
            st = climaCABA.st,
            latitud = climaCABA.latitud,
            longitud = climaCABA.longitud,
        )
    }

    private fun mostrarCordoba(){
        uiState= ClimaEstado.Exitoso (
            ciudad= climaCordoba.ciudad,
            temperatura = climaCordoba.temperatura,
            descripcion = climaCordoba.descripcion,
            st = climaCordoba.st,
            latitud = climaCordoba.latitud,
            longitud = climaCordoba.latitud,
        )
    }
    private fun mostrarError(){
        uiState= ClimaEstado.Error("Este es el mensaje de Error")
    }


}