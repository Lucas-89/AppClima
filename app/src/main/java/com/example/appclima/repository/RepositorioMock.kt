package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima

class RepositorioMock : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val ciudad1 = Ciudad(
            nombre = "Bahia Blanca",
            lat = 123.2,
            lon = 4324.123,
            country = "AR",
            state = "Argentina",
        )
        val ciudad2 = Ciudad(
            nombre = "Chubut",
            lat = 123.2,
            lon = 4344.1823,
            country = "AR",
            state = "Argentina",
        )
        val ciudad3 = Ciudad(
            nombre = "Rosasio",
            lat = 543.2,
            lon = 454.14,
            country = "AR",
            state = "Argentina",
        )
        return listOf(ciudad1, ciudad2, ciudad3)
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima {
        TODO("Not yet implemented")
        //aca deberia rellenar con una informacion de clima
    }

    override suspend fun traerproostico(ciudad: Ciudad): List<Clima> {
        TODO("Not yet implemented")
        //aca deberia rellenar con una informacion del pronostico extendido
    }

}