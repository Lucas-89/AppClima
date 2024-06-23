package com.example.appclima.presentacion.ciudades

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appclima.presentacion.clima.ClimaView
import com.example.appclima.presentacion.clima.ClimaViewModel
import com.example.appclima.repository.RepositorioApi
import com.example.appclima.repository.RepositorioMock
import com.example.appclima.router.Enrutador
import com.example.appclima.router.Router

@Composable
fun CiudadesPage(
    modifier: Modifier,
    navHostController: NavHostController,
){
    val viewModel : CiudadesViewModel = viewModel(
        factory = CiudadesViewModelFactory(
            repositorio = RepositorioApi(),
            //repositorio = RepositorioMock(),
            router = Enrutador(navHostController)
        )
    )
    CiudadesView(
        state = viewModel.uiState,
        onAction = { viewModel.ejecutar(it) }
    )
}







































