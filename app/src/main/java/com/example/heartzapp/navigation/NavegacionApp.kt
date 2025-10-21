package com.example.heartzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heartzapp.ui.screens.PantallaInicio
import com.example.heartzapp.ui.screens.PantallaProductos
import com.example.heartzapp.ui.screens.perfil.PantallaPerfil
//import com.example.heartzapp.ui.screens.perfil.PantallaLogin
//import com.example.heartzapp.ui.screens.perfil.PantallaRegistro


@Composable
fun NavegacionApp() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") { PantallaInicio() }
        composable("productos") { PantallaProductos() }
        composable("perfil") { PantallaPerfil() }

        //composable("login") { PantallaLogin() }
        //composable("registro") { PantallaRegistro() }
    }
}

