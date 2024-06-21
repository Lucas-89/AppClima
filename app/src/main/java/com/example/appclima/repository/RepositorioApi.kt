package com.example.appclima.repository

import com.example.appclima.repository.modelos.Ciudad
import com.example.appclima.repository.modelos.Clima
import com.example.appclima.repository.modelos.Clima2
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepositorioApi : Repositorio {

    val apiKey = "ec048cd34922389dfbf3835fc08a1d5c"
    val urlCiudad = "https://api.openweathermap.org/geo/1.0/direct?"

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val respuesta = cliente.get(urlCiudad){
            parameter("q", ciudad)
            parameter("limit", 5)
            parameter("appid", apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
           val ciudades = respuesta.body<List<Ciudad>>()
            return ciudades
        } else{
            throw Exception()
        }
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {

        val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/weather"){
            parameter("lat", -34.609)
            parameter("lon", -58.46)
            parameter("units", "metric")
            parameter("appid", apiKey)
        }
        if (respuesta.status == HttpStatusCode.OK){
            val clima = respuesta.body<Clima2>()
            return clima
        } else{
            throw Exception()
        }
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
        //para esto necesito saber que responde esa api
    }
}


































