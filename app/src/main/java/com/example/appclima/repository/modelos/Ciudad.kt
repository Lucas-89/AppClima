package com.example.appclima.repository.modelos

import kotlinx.serialization.Serializable

@Serializable

data class Ciudad (
    val nombre: String,
    val lat: Double,
    val lon: Double,
    val state: String
)

