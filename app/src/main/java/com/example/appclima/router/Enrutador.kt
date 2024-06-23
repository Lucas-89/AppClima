package com.example.appclima.router

import android.annotation.SuppressLint
import androidx.navigation.NavHostController

class Enrutador(
    val navHostController: NavHostController
) : Router{
    @SuppressLint("DefaultLocale")
    override fun navegar(ruta: Ruta) {
       // navHostController.navigate(ruta.id)
        when(ruta){
            Ruta.Ciudades -> navHostController.navigate(ruta.id)

            is Ruta.Clima -> {
                val route = String.format(format="%s?lat=%f&lon=%f&nombre=%s",ruta.id,ruta.lat,ruta.lon,ruta.name)
                navHostController.navigate(route)
            }
        }
    }
}


























