package com.example.heartzapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.heartzapp.ui.components.BottomBar
import com.example.heartzapp.ui.components.TarjetaVinilo
import com.example.heartzapp.viewmodel.ViniloViewModel
import androidx.compose.ui.text.style.TextAlign

@Composable
fun PantallaProductos(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: ViniloViewModel = viewModel(
        factory = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.getInstance(
            context.applicationContext as android.app.Application
        )
    )

    val vinilos by viewModel.vinilos.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0xFF7E57C2),
                        Color(0xFFF3E5F5)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                // Deja espacio para la barra de estado (hora, batería)
                .padding(WindowInsets.statusBars.asPaddingValues())
                // Evita que se oculte el contenido tras la BottomBar
                .padding(bottom = 56.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "Catálogo de Vinilos",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )
            }



            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            } else if (vinilos.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No hay vinilos disponibles",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(vinilos) { vinilo ->
                        TarjetaVinilo(
                            vinilo = vinilo,
                            onVerDetalle = { viniloSeleccionado ->
                                println("Ver detalle de: ${viniloSeleccionado.nombre}")
                            },
                            onAgregarCarrito = { viniloSeleccionado ->
                                println("Añadir al carrito: ${viniloSeleccionado.nombre}")
                            }
                        )
                    }
                }
            }
        }

        // BottomBar fija al fondo
        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            BottomBar(navController)
        }
    }
}
