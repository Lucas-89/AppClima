package com.example.appclima

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {
    var ciudad =  mutableStateOf<String>("--")
    var temperatura =  mutableStateOf<Int>(0)
    var descripcion =  mutableStateOf<String>("--")
    var st =  mutableStateOf<Int>(0)


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
    fun borrarTodo(){
        ciudad.value = ""
        temperatura.value = 0
        descripcion.value = ""
        st.value = 0
    }

    fun mostrarCABA(){
        ciudad.value = climaCABA.ciudad
        temperatura.value = climaCABA.temperatura
        descripcion.value = climaCABA.descripcion
        st.value = climaCABA.st
    }

    fun mostrarCordoba(){
        ciudad.value = climaCordoba.ciudad
        temperatura.value = climaCordoba.temperatura
        descripcion.value = climaCordoba.descripcion
        st.value = climaCordoba.st
    }

}