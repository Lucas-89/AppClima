package com.example.appclima.presentacion.ciudades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appclima.repository.Repositorio

class CiudadesViewModel(
    val repositorio: Repositorio
): ViewModel(){

    var uiState by mutableStateOf<CiudadesEstado>(CiudadesEstado.Vacio)

    fun ejecutar(intencion: CiudadesIntencion){
        when(intencion){
            is CiudadesIntencion.BuscarCiudad -> buscarCiudades(nombreCiudad = intencion.nombreCiudad)
            is CiudadesIntencion.SeleccionarCiudad -> seleccionarCiudad(indiceCiudad = intencion.indiceCiudad) //deberia ser nombre
        }
    }

    private fun buscarCiudades(nombreCiudad : String){
        //val listaDeCiudades = repositorio.Resultado(nombreCiudad)
    }

    private fun seleccionarCiudad(indiceCiudad : Int){              //deberia ser nombre

    }
}



class CiudadesViewModelFactory(
    private val repositorio: Repositorio,
   // private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CiudadesViewModel::class.java)) {
            return CiudadesViewModel(repositorio,/*router*/) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}