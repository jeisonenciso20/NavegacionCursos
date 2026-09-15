package com.jeison.navegacioncursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavegacion()
        }
    }
}

@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        // Pantalla de Inicio
        composable("inicio") {
            InicioScreen(
                onCursosClick = {
                    navController.navigate("cursos")
                }
            )
        }

        // Pantalla de Cursos
        composable("cursos") {
            CursosScreen(
                onCursoClick = {
                    navController.navigate("detalle")
                }
            )
        }

        // Pantalla Detalle
        composable("detalle") {
            DetalleCursoScreen(
                onActividadesClick = {
                    navController.navigate("actividades")
                }
            )
        }

        // Pantalla Actividades
        composable("actividades") {
            ActividadesScreen()
        }
    }
}


// ------------------------------------
// PANTALLA DE INICIO
// ------------------------------------

@Composable
fun InicioScreen(
    onCursosClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Bienvenido a mi aplicación")

        Button(
            onClick = onCursosClick
        ) {
            Text("Ver cursos")
        }
    }
}


// ------------------------------------
// PANTALLA DE CURSOS
// ------------------------------------

@Composable
fun CursosScreen(
    onCursoClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Cursos disponibles")

        Button(
            onClick = onCursoClick
        ) {
            Text("Ver curso")
        }
    }
}


// ------------------------------------
// PANTALLA DETALLE DEL CURSO
// ------------------------------------

@Composable
fun DetalleCursoScreen(
    onActividadesClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Detalle del curso")

        Text("Curso: Ingeniería de Software")

        Text("Duración: 5 años")

        Button(
            onClick = onActividadesClick
        ) {
            Text("Ver actividades")
        }
    }
}


// ------------------------------------
// PANTALLA ACTIVIDADES
// ------------------------------------

@Composable
fun ActividadesScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Actividades")

        Text("• Actividad 1")

        Text("• Actividad 2")

        Text("• Actividad 3")
    }
}