package com.example.appclima.presentacion.ciudades

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appclima.presentacion.clima.ClimaView
import com.example.appclima.presentacion.clima.ClimaViewModel
import com.example.appclima.repository.RepositorioApi

@Composable
fun CiudadesPage(modifier: Modifier){
    val viewModel : CiudadesViewModel = viewModel(
        factory = CiudadesViewModelFactory(
            repositorio = RepositorioApi()

        )
    )
    CiudadesView(
        state = viewModel.uiState,
        onAction = { viewModel.ejecutar(it) }
    )
}







































