package com.example.appclima.presentacion.clima

import com.example.appclima.repository.modelos.Clima2

sealed class ClimaEstado{
    data class Exitoso(
        val ciudad: String =  "",
        val temperatura: Double = 0.0 ,
        val descripcion : String ="",
        val st : Double = 0.0,
        val longitud :  Double=0.0,
        val latitud : Double =0.0,
        ): ClimaEstado()
    data class Error(
        val mensaje: String = ""
    ): ClimaEstado()
    data object Vacio : ClimaEstado()
    data object Cargando : ClimaEstado()
}