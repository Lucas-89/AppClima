package com.example.appclima.presentacion.clima

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainPage(modifier: Modifier){
    val viewModel : ClimaViewModel = viewModel(factory = ClimaViewModel.factory)
    ClimaView(
        state = viewModel.uiState,
        onAction = { viewModel.ejecutar(it) }
    )
}
