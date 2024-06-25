package com.example.appclima.presentacion.clima.actual

sealed class ClimaEstado{
    data class Exitoso(
        val ciudad: String ,
        val temperatura: Double  ,
        val descripcion : String ="",
        val longitud :  Double,
        val latitud : Double ,
        ): ClimaEstado()
    data class Error(
        val mensaje: String = ""
    ): ClimaEstado()
    data object Vacio : ClimaEstado()
    data object Cargando : ClimaEstado()
}