package com.example.heartzapp.ui.screens.administrador

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.heartzapp.ui.screens.admin.screens.DashboardAdmin

@Composable
fun AdminNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "admin_dashboard",
        modifier = modifier
    ) {
        composable("admin_dashboard") { DashboardAdmin() }
        composable("admin_productos") { PantallaGestionProductos() }
        composable("admin_usuarios") { PantallaGestionUsuarios() }
    }
}
