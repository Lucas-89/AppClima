package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima
import com.example.appclima.repository.modelos.ListForecast


class RepositorioMock : Repositorio {

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
        lon = 4344.183f,
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
    val ciudades = listOf(ciudad1, ciudad2, ciudad3)

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        return ciudades.filter { it.name.contains(ciudad, ignoreCase = true) }
    }

    override suspend fun traerClima(lat: Float, lon: Float, name: String): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<ListForecast> {
        TODO("Not yet implemented")
        //aca deberia rellenar con una informacion del pronostico extendido
    }

}

class RepositorioMockError  : Repositorio {

    override suspend fun buscarCiudad(ciudad : String): List<Ciudad> {
        throw Exception()
    }

    override suspend fun traerClima(lat: Float, lon: Float, name: String): Clima {
        throw Exception()
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<ListForecast> {
        throw Exception()
    }
}