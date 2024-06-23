package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima

class RepositorioMock : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val ciudad1 = Ciudad(
            name = "Bahia Blanca",
            lat = 123.2f,
            lon = 4324.123f,
            state = "Argentina",
            country = "Argentina",
        )
        val ciudad2 = Ciudad(
            name = "Chubut",
            lat = 123.2f,
            lon = 4344.1823f,
            state = "Argentina",
            country = "Argentina",

        )
        val ciudad3 = Ciudad(
            name = "Rosasio",
            lat = 543.2f,
            lon = 454.14f,
            state = "Argentina",
            country = "Argentina",

        )
        return listOf(ciudad1, ciudad2, ciudad3)
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")
        //aca deberia rellenar con una informacion de clima
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<Clima> {
        TODO("Not yet implemented")
        //aca deberia rellenar con una informacion del pronostico extendido
    }

}