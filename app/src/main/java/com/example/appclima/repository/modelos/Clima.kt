package com.example.appclima.repository.modelos

import kotlinx.serialization.Serializable

@Serializable
data class Clima(
    val coord: Coord,
    val weather: List <Weather>,
    val base: String,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val name: String,
)
@Serializable
data class Coord(
    val lon: Double,
    val lat: Double,
)


@Serializable

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)
@Serializable

data class Main(
    val temp: Double,           // temperatura
    val feelsLike: Double ,      // sensacion termica
    val tempMin: Double ,
    val tempMax: Double ,
    val pressure: Long,
    val humidity: Long,
)
@Serializable

data class Wind (
    val speed: Double,
    val deg: Long,
    val gust: Double? = null,
)
@Serializable

data class Clouds(
    val all: Long,
)

