package com.example.appclima.presentacion.ciudades

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appclima.repository.Repositorio
import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.router.Router
import com.example.appclima.router.Ruta
import kotlinx.coroutines.launch

class CiudadesViewModel(
    val repositorio: Repositorio,
    val router: Router
): ViewModel(){

    var uiState by mutableStateOf<CiudadesEstado>(CiudadesEstado.Vacio)

    fun ejecutar(intencion: CiudadesIntencion){
        when(intencion){
            is CiudadesIntencion.BuscarCiudad -> buscarCiudades(nombreCiudad = intencion.nombreCiudad)
            is CiudadesIntencion.SeleccionarCiudad -> seleccionarCiudad(ciudad = intencion.nombreCiudad) //deberia ser nombre
        }
    }

    private fun buscarCiudades(nombreCiudad : String){
        uiState = CiudadesEstado.Cargando
        viewModelScope.launch {
            try {
                val listaDeCiudades = repositorio.buscarCiudad(nombreCiudad)
                uiState = CiudadesEstado.Resultado(listaDeCiudades)
            } catch (exeption: Exception){
                uiState = CiudadesEstado.Error("Fallo la busqueda de la Ciudad")
            }
        }


    }

    private fun seleccionarCiudad(ciudad: Ciudad){              //deberia ser nombre
      //cuando llego aca, entiendo que tengo que llamar a
        // ClimaEstado.Resultado para que traiga el detalle
        // del clima de la ciudad
//        viewModelScope.launch {
//            val climaDeLaCiudad = repositorio.traerClima()
//        }
        "Seleccionaste la ciudad ${ciudad.nombre}"
        router.navegar(Ruta.Clima())
    }
}



class CiudadesViewModelFactory(
    private val repositorio: Repositorio,
    private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CiudadesViewModel::class.java)) {
            return CiudadesViewModel(repositorio,router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}




























