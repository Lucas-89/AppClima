package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima
import com.example.appclima.repository.modelos.Clouds
import com.example.appclima.repository.modelos.Coord
import com.example.appclima.repository.modelos.ListForecast
import com.example.appclima.repository.modelos.Main
import com.example.appclima.repository.modelos.MainForecast
import com.example.appclima.repository.modelos.Weather
import com.example.appclima.repository.modelos.Wind


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

    val clima1 = Clima(
        name = "Bahia Blanca",
        coord = Coord(123.2, 43.12),
        weather = listOf(Weather(id = 800, main = "Clear", description = "clear sky", icon = "01d")),
        main = Main(temp = 10.37, pressure = 1012, humidity = 81),
        wind = Wind(speed = 1.5, deg = 350),
        clouds = Clouds(all = 1),
        base = "Base cuidad1"
    )
    val clima2 = Clima(
        name = "Chubut",
        coord = Coord(123.2, 4344.18),
        weather = listOf(Weather(id = 800, main = "Rain", description = "no clear sky", icon = "01n")),
        main = Main(temp = 20.37, pressure = 1012, humidity = 81),
        wind = Wind(speed = 23.6, deg = 30),
        clouds = Clouds(all = 1),
        base = "Base cuidad2"
    )
    val clima3 = Clima(
        name = "Rosario",
        coord = Coord(543.2, 454.1),
        weather = listOf(Weather(id = 800, main = "Clouds", description = "some rain", icon = "01d")),
        main = Main(temp = 280.37, pressure = 1012, humidity = 81),
        wind = Wind(speed = 300.5, deg = 110),
        clouds = Clouds(all = 1),
        base = "Base cuidad3"
    )

    val pronostico1 = ListForecast(
        dt = 2112,
        main = MainForecast (
            temp = 12.2,
            feels_like = 10.0,
            temp_min = 7.5,
            temp_max = 15.2,
            pressure=1024,
            sea_level= 12321,
            grnd_level= 323232,
            humidity= 90,
            temp_kf=323.15,
        )
    )
    val pronostico2 = ListForecast(
        dt = 787878,
        main = MainForecast (
            temp = 2.2,
            feels_like = 1.0,
            temp_min = 0.5,
            temp_max = 5.2,
            pressure=1024,
            sea_level= 12321,
            grnd_level= 323232,
            humidity= 90,
            temp_kf=323.15,
        )
    )
    val pronostico3 = ListForecast(
        dt = 963,
        main = MainForecast (
            temp = 32.2,
            feels_like = 40.0,
            temp_min = 32.5,
            temp_max = 45.2,
            pressure=1024,
            sea_level= 12321,
            grnd_level= 323232,
            humidity= 90,
            temp_kf=323.15,
        )
    )

    val ciudades = listOf(ciudad1, ciudad2, ciudad3)
    val climas = listOf(clima1, clima2, clima3)
    val pronosticos = listOf(pronostico1, pronostico2, pronostico3)

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        return ciudades.filter { it.name.contains(ciudad, ignoreCase = true) }
    }


    override suspend fun traerClima(lat: Float, lon: Float, name: String): Clima {
        TODO("Not yet implemented")
        return climas.first { it.name == name}
    }

    override suspend fun traerPronostico(lat: Float, lon: Float): List<ListForecast> {
        TODO("Not yet implemented")
        return pronosticos
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