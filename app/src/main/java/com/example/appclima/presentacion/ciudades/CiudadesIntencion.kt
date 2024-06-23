package com.example.appclima.presentacion.ciudades

import com.example.appclima.repository.modelos.Ciudad

sealed class CiudadesIntencion {
    data class BuscarCiudad(val nombreCiudad: String) : CiudadesIntencion()
    data class SeleccionarCiudad(val nombreCiudad: Ciudad) : CiudadesIntencion()  //aca deberia ser un string y recibir el nimbre de la ciudad
}