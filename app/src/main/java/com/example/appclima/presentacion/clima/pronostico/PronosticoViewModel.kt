package com.example.appclima.presentacion.clima.pronostico

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appclima.repository.Repositorio
import com.example.appclima.router.Router
import kotlinx.coroutines.launch
import com.example.appclima.repository.modelos.ListForecast


class PronosticoViewModel(
    val respositorio: Repositorio,
    val router: Router,
    val nombre: String,
    val lat: Float,
    val lon: Float
) : ViewModel() {

    var uiState by mutableStateOf<PronosticoEstado>(PronosticoEstado.Vacio)

    fun ejecutar(intencion: PronosticoIntencion){
        when(intencion){
            PronosticoIntencion.actualizarClima -> traerPronostico()
        }
    }

    fun traerPronostico() {
        uiState = PronosticoEstado.Cargando
        viewModelScope.launch {
            try{
                val forecast = respositorio.traerPronostico(lat, lon).take(5)
                uiState = PronosticoEstado.Exitoso(forecast)
            } catch (exception: Exception){
                uiState = PronosticoEstado.Error(exception.localizedMessage ?: "error desconocido")
            }
        }
    }

}

class PronosticoViewModelFactory(
    private val repositorio: Repositorio,
    private val router: Router,
    private val nombre: String,
    private val lat: Float,
    private val lon: Float
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PronosticoViewModel::class.java)) {
            return PronosticoViewModel(repositorio,router,nombre,lat,lon) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}