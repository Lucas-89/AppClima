package com.example.appclima.presentacion.ciudades

import com.example.appclima.repository.modelos.Ciudad

sealed class CiudadesEstado {
    data object Vacio: CiudadesEstado()
    data object Cargando: CiudadesEstado()
    data class Resultado (val ciudades: List<Ciudad>): CiudadesEstado()
    data class Error(val mensajeError: String): CiudadesEstado()

}