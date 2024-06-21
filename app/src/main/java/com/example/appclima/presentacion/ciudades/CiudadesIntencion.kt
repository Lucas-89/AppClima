package com.example.appclima.presentacion.ciudades

sealed class CiudadesIntencion {
    data class BuscarCiudad(val nombreCiudad: String) : CiudadesIntencion()
    data class SeleccionarCiudad(val indiceCiudad: Int) : CiudadesIntencion()  //aca deberia ser un string y recibir el nimbre de la ciudad
}