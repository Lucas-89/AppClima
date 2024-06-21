package com.example.appclima.presentacion.ciudades

sealed class CiudadesEstado {
    data object Vacio: CiudadesEstado()
    data object Cargando: CiudadesEstado()
    data class Resultado (val ciudades: List<String>): CiudadesEstado()
    data class Error(val mensajeError: String): CiudadesEstado()

}