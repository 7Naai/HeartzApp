package com.example.heartzapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.heartzapp.data.model.Vinilo
import com.example.heartzapp.viewmodel.ViniloViewModel

@Composable
fun PantallaProductos(
    viniloViewModel: ViniloViewModel = viewModel(),
    onVerDetalle: (Vinilo) -> Unit,
    onAgregarCarrito: (Vinilo) -> Unit
) {
    val vinilos by viniloViewModel.vinilos.collectAsState()
    val generos by viniloViewModel.generos.collectAsState()
    val artistas by viniloViewModel.artistas.collectAsState()

    var filtroGenero by remember { mutableStateOf("todos") }
    var filtroArtista by remember { mutableStateOf("todos") }
    var ordenPrecio by remember { mutableStateOf("ninguno") }

    val vinilosFiltrados = remember(vinilos, filtroGenero, filtroArtista, ordenPrecio) {
        vinilos
            .filter { filtroGenero == "todos" || it.genero == filtroGenero }
            .filter { filtroArtista == "todos" || it.artista == filtroArtista }
            .let { list ->
                when (ordenPrecio) {
                    "asc" -> list.sortedBy { it.precio }
                    "desc" -> list.sortedByDescending { it.precio }
                    else -> list
                }
            }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Nuestros Vinilos", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            DropdownMenuFilter(
                label = "Género",
                options = listOf("todos") + generos,
                selectedOption = filtroGenero,
                onOptionSelected = { filtroGenero = it }
            )
            DropdownMenuFilter(
                label = "Artista",
                options = listOf("todos") + artistas,
                selectedOption = filtroArtista,
                onOptionSelected = { filtroArtista = it }
            )
            DropdownMenuFilter(
                label = "Precio",
                options = listOf("ninguno", "asc", "desc"),
                selectedOption = ordenPrecio,
                onOptionSelected = { ordenPrecio = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(vinilosFiltrados) { vinilo ->
                Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(4.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        if (vinilo.img != 0) {
                            Image(
                                painter = painterResource(id = vinilo.img),
                                contentDescription = vinilo.nombre,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clickable { onVerDetalle(vinilo) },
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(vinilo.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(vinilo.artista, style = MaterialTheme.typography.bodyMedium)
                            Text(vinilo.genero, style = MaterialTheme.typography.bodySmall)
                            Text("Formato: ${vinilo.formato}", style = MaterialTheme.typography.bodySmall)
                            Text("Precio: $${vinilo.precio}", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
                        }

                        Column {
                            Button(onClick = { onVerDetalle(vinilo) }) {
                                Text("Ver")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(onClick = { onAgregarCarrito(vinilo) }) {
                                Text("Añadir")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownMenuFilter(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text("$label: $selectedOption")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
