package com.example.appclima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {
    //unico estado observable
    var uiState by mutableStateOf<Estado>(Estado.Vacio)
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

    fun ejecutar(intencion: Intencion) {
        when(intencion){
            Intencion.BorrarTodo -> borrarTodo()
            Intencion.MostrarCABA -> mostrarCABA()
            Intencion.MostrarCordoba -> mostrarCordoba()
            Intencion.MostrarError -> mostrarError()
        }
    }

    private fun borrarTodo(){
        uiState = Estado.Vacio
    }

    private fun mostrarCABA(){
        uiState= Estado.Exitoso (
            ciudad = climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.descripcion,
            st = climaCABA.st,
            latitud = climaCABA.latitud,
            longitud = climaCABA.longitud,
        )
    }

    private fun mostrarCordoba(){
        uiState= Estado.Exitoso (
            ciudad= climaCordoba.ciudad,
            temperatura = climaCordoba.temperatura,
            descripcion = climaCordoba.descripcion,
            st = climaCordoba.st,
            latitud = climaCordoba.latitud,
            longitud = climaCordoba.latitud,
        )
    }
    private fun mostrarError(){
        uiState= Estado.Error("Este es el mensaje de Error")
    }


}