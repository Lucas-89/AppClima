package com.example.appclima

import com.example.appclima.presentacion.ciudades.CiudadesEstado
import com.example.appclima.presentacion.ciudades.CiudadesIntencion
import com.example.appclima.presentacion.ciudades.CiudadesViewModel
import com.example.appclima.presentacion.ciudades.CiudadesViewModelFactory
import com.example.appclima.presentacion.clima.actual.ClimaEstado
import com.example.appclima.presentacion.clima.actual.ClimaIntencion
import com.example.appclima.presentacion.clima.actual.ClimaViewModel
import com.example.appclima.repository.RepositorioMock
import com.example.appclima.router.MockRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*
import org.junit.Before
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


    @Test
    fun ciudadesVM_buscar_ciudad1 ()= runTest(timeout = 3.seconds){
        val repositorio = RepositorioMock()
        val router = MockRouter()

        val factory = CiudadesViewModelFactory(repositorio,router)
        val viewModel = factory.create(CiudadesViewModel::class.java)

        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.ciudad1))

        launch(Dispatchers.Main){
            viewModel.ejecutar(intencion = CiudadesIntencion.BuscarCiudad("bah"))
            delay(1000.milliseconds)
            assertEquals(estadoEsperado,viewModel.uiState)
        }
    }
    @Test
    fun climaVM_buscar_clima1() = runTest(timeout = 5.seconds){
        val repositorio = RepositorioMock()
        val router = MockRouter()

        val factory = ClimaViewModel.ClimaViewModelFactory(repositorio, router, lon = 123.2f, lat = 43.12f, nombre = "Bahia Blanca")
        val viewModel = factory.create(ClimaViewModel::class.java)

        val estadoEsperado = ClimaEstado.Exitoso(
            ciudad = repositorio.clima1.name,
            temperatura = repositorio.clima1.main.temp,
            latitud = repositorio.clima1.coord.lat,
            longitud = repositorio.clima1.coord.lon
        )

        launch(Dispatchers.Main){
            viewModel.ejecutar(intencion = ClimaIntencion.ActualizarClima)
            delay(3500.milliseconds)
            assertEquals(estadoEsperado,viewModel.uiState)
        }

    }


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}