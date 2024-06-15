package com.example.appclima

sealed class Intencion{
    object BorrarTodo: Intencion()
    object MostrarCABA: Intencion()
    object MostrarCordoba: Intencion()
    object MostrarError: Intencion()
}