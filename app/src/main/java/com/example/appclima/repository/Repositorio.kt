package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): List<Ciudad>
    suspend fun traerClima(ciudad: Ciudad): Clima
    suspend fun traerproostico(ciudad: Ciudad): List<Clima>

}