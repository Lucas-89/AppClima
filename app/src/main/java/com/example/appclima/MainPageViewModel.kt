package com.example.appclima

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainPageViewModel: ViewModel() {
    var ciudad =  mutableStateOf<String>("Caba")
    var temperatura =  mutableStateOf<Int>(19)
    var descripcion =  mutableStateOf<String>("Nublado")
    var st =  mutableStateOf<Int>(12)

    fun borrarTodo(){
        ciudad.value = ""
        temperatura.value = 0
        descripcion.value = ""
        st.value = 0
    }

    fun mostrarCABA(){
        ciudad.value = "CABA"
        temperatura.value = 10
        descripcion.value = "Sigue Nublado"
        st.value = 900
    }

    fun mostrarCordoba(){
        ciudad.value = "Cordoba"
        temperatura.value = 20
        descripcion.value = "Cuidad de Cordoba"
        st.value = 25
    }

}