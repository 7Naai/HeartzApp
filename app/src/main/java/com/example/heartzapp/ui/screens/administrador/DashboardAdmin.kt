package com.example.heartzapp.ui.screens.admin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardAdmin() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("📊 Dashboard general")
    }
}

@Composable
fun GestionProductos() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("🛒 Gestión de Productos")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Aquí irá la lista y CRUD de productos.")
    }
}

@Composable
fun GestionUsuarios() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("👥 Gestión de Usuarios")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Aquí irá la lista y CRUD de usuarios.")
    }
}
