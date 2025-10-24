package com.example.heartzapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAdmin(
    onLogout: () -> Unit = {} // callback opcional para salir
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // Datos simulados (después vendrán de Room)
    val totalVentas = 128
    val totalGanado = 542000
    val stockTotal = 312

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxHeight()
            ) {
                // Botón de cerrar Drawer
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, end = 8.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    IconButton(onClick = { scope.launch { drawerState.close() } }) {
                        Icon(Icons.Filled.Close, contentDescription = "Cerrar menú")
                    }
                }

                // Título
                Text(
                    text = "Menú administrador",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp)
                )



                // Opciones
                DrawerItem("🏠 Resumen") { scope.launch { drawerState.close() } }
                DrawerItem("💿 Gestionar productos") { /*  */ }
                DrawerItem("👥 Gestionar usuarios") { /*  */ }

                Spacer(modifier = Modifier.weight(1f))

                // Botón rojo de salir
                Button(
                    onClick = onLogout,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Salir", color = MaterialTheme.colorScheme.onError)
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Panel de administración") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menú")
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Resumen general",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(20.dp))

                StatCard("Productos vendidos", "$totalVentas unidades")
                Spacer(modifier = Modifier.height(12.dp))
                StatCard("Total ganado", "$${totalGanado} CLP")
                Spacer(modifier = Modifier.height(12.dp))
                StatCard("Stock total disponible", "$stockTotal unidades")
            }
        }
    }
}

@Composable
fun DrawerItem(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun StatCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            Text(
                value,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaAdminPreview() {
    PantallaAdmin()
}
