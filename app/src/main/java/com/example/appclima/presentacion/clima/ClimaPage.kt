package com.example.appclima.presentacion.clima

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appclima.presentacion.clima.actual.ClimaView
import com.example.appclima.presentacion.clima.actual.ClimaViewModel
import com.example.appclima.presentacion.clima.pronostico.PronosticoView
import com.example.appclima.presentacion.clima.pronostico.PronosticoViewModel
import com.example.appclima.presentacion.clima.pronostico.PronosticoViewModelFactory
import com.example.appclima.repository.RepositorioApi
import com.example.appclima.router.Enrutador



@Composable
fun ClimaPage(
    modifier: Modifier,
    navHostController: NavHostController,
    lat: Float,
    lon: Float,
    nombre: String
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModel.ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            // repositorio = RepositorioMock()
            router = Enrutador(navHostController),
            lat = lat,
            lon = lon,
            nombre = nombre
        )
    )
    val pronosticoViewModel : PronosticoViewModel = viewModel(
        factory = PronosticoViewModelFactory(
            repositorio = RepositorioApi(),
            router = Enrutador(navHostController),
            nombre = nombre
        )
    )
    Column {
        ClimaView(
            state = viewModel.uiState,
            onAction = { intencion ->
                viewModel.ejecutar(intencion)
            }
        )
        PronosticoView(
            state = pronosticoViewModel.uiState,
            onAction = { intencion ->
                pronosticoViewModel.ejecutar(intencion)
            }
        )
    }
}

























