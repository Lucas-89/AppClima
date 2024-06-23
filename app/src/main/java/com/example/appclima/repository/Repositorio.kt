package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): Array<Ciudad>
    suspend fun traerClima(ciudad: Ciudad): Clima
    suspend fun traerPronostico(ciudad: Ciudad): List<Clima>

}