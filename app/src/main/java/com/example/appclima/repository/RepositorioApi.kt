package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima

class RepositorioApi : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        TODO("Not yet implemented")
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerproostico(ciudad: Ciudad): List<Clima> {
        TODO("Not yet implemented")
    }

}