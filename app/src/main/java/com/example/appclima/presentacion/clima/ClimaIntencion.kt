package com.example.appclima.presentacion.clima

sealed class ClimaIntencion{
    object BorrarTodo: ClimaIntencion()
    object MostrarCABA: ClimaIntencion()
    object MostrarCordoba: ClimaIntencion()
    object MostrarError: ClimaIntencion()
}