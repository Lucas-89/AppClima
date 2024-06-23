package com.example.appclima.presentacion.clima

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appclima.presentacion.ciudades.CiudadesViewModel
import com.example.appclima.presentacion.ciudades.CiudadesViewModelFactory
import com.example.appclima.repository.RepositorioApi
import com.example.appclima.router.Enrutador
import com.example.appclima.router.Router


@Composable
fun ClimaPage(
    modifier: Modifier,
    navHostController: NavHostController
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            // repositorio = RepositorioMock()
            router = Enrutador(navHostController)
        )
    )
    ClimaView(
        state = viewModel.uiState,
        onAction = { viewModel.ejecutar(it) }
    )
}
