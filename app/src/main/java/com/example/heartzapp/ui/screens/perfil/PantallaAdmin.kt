package com.example.heartzapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.heartzapp.ui.components.AdminBar
import com.example.heartzapp.ui.screens.administrador.AdminNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAdmin(navController: NavHostController, onLogout: () -> Unit = {}) {
    val adminNavController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Panel de Administración") }) },
        bottomBar = { AdminBar(navController = adminNavController) } // navegación interna
    ) { padding ->
        AdminNavHost(
            navController = adminNavController,
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        )
    }
}

