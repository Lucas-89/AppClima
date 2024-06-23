package com.example.appclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appclima.repository.Repositorio
import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.router.Router
import kotlinx.coroutines.launch

class ClimaViewModel(
    val repositorio: Repositorio,
    router : Router
): ViewModel() {

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

//    private val climaCordoba = Clima(  // ver como esta parseado esto
//        temperatura = 20,
//        descripcion = "Ventoso",
//        st = 25,
//        ciudad = "Cordoba",
//        lat = 35126,
//        lon = 52414
//    )
//
//    private val climaCABA = Clima(
//        temperatura = 15,
//        descripcion = "Soleado",
//        st = 12,
//        ciudad = "CABA",
//        latitud = 6852,
//        longitud = 854741
//    )

    fun ejecutar(intencion: ClimaIntencion) {
        when(intencion){
            ClimaIntencion.ActualizarClima -> traerClima()
        }
    }

    private fun traerClima(){

        uiState = ClimaEstado.Cargando
        viewModelScope.launch {
           val cordoba = Ciudad("Cordoba", lat = -21.41, lon = -64.18, state = "AR", country = "Argentina")
           try {
               val clima = repositorio.traerClima(cordoba)
               ClimaEstado.Exitoso(
                   ciudad = clima.name,
                   temperatura = 10.0,//clima.main.temp ,
                   descripcion = "asdf",//clima.weather.first().description,
                   st = 02.3,//clima.main.feelsLike,
                   longitud = 123.21,//clima.coord.lon,
                   latitud = 2525.36//clima.coord.lat
               )
           }catch (exception: Exception) {
               uiState = ClimaEstado.Error(exception.localizedMessage ?: "error desconocido")
           }
        }
    }

//        uiState= ClimaEstado.Exitoso (
////            ciudad= climaCordoba.ciudad,
////            temperatura = climaCordoba.temperatura,
////            descripcion = climaCordoba.descripcion,
////            st = climaCordoba.st,
////            latitud = climaCordoba.latitud,
////            longitud = climaCordoba.latitud,
//        )
    }
//    private fun mostrarError(){
//        uiState= ClimaEstado.Error("Este es el mensaje de Error")
//    }






class ClimaViewModelFactory(
    private val repositorio: Repositorio,
    private val router: Router
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClimaViewModel::class.java)) {
            return ClimaViewModel(repositorio,router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}








































