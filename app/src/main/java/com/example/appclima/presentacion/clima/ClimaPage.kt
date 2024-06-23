package com.example.appclima.presentacion.clima

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appclima.repository.RepositorioApi
import com.example.appclima.router.Enrutador



@Composable
fun ClimaPage(
    modifier: Modifier,
    navHostController: NavHostController,
    lat: Float,
    lon: Float
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModel.ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            // repositorio = RepositorioMock()
            router = Enrutador(navHostController),
            lat = lat,
            lon = lon
        )
    )
    ClimaView(
        state = viewModel.uiState,
        onAction = { viewModel.ejecutar(it) }
    )
}

























