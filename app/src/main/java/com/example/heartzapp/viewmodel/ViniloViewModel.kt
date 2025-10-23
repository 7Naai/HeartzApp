package com.example.heartzapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heartzapp.data.model.Vinilo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViniloViewModel : ViewModel() {

    private val _vinilos = MutableStateFlow<List<Vinilo>>(emptyList())
    val vinilos: StateFlow<List<Vinilo>> = _vinilos

    private val _generos = MutableStateFlow<List<String>>(emptyList())
    val generos: StateFlow<List<String>> = _generos

    private val _artistas = MutableStateFlow<List<String>>(emptyList())
    val artistas: StateFlow<List<String>> = _artistas

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        viewModelScope.launch {
            val datosVinilos = listOf(
                Vinilo(
                    idVin = 1,
                    nombre = "Saturday Night Wrist",
                    artista = "Deftones",
                    genero = "Metal",
                    anno = 2006,
                    precio = 44900,
                    formato = "2LP",
                    colorVinilo = "Negro - Dorado",
                    stock = 10,
                    sello = "Maverick Records",
                    pais = "EE.UU.",
                    edicion = "Original",
                    duracion = "61:36",
                    descripcion = "El quinto álbum de Deftones mezcla metal alternativo con atmósferas etéreas, consolidando su sonido más experimental.",
                    img = "deftones_saturday_night_wrist_cover.jpg"
                ),
                Vinilo(
                    idVin = 2,
                    nombre = "Blonde",
                    artista = "Frank Ocean",
                    genero = "R&B",
                    anno = 2016,
                    precio = 49900,
                    formato = "2LP",
                    colorVinilo = "Beige",
                    stock = 8,
                    sello = "Boys Don’t Cry",
                    pais = "EE.UU.",
                    edicion = "Edición Limitada",
                    duracion = "60:08",
                    descripcion = "Obra maestra introspectiva de Frank Ocean, fusionando R&B, soul y electrónica con letras profundamente personales.",
                    img = "frank_ocean_blonde_cover.jpg"
                ),
                Vinilo(
                    idVin = 3,
                    nombre = "The Bends",
                    artista = "Radiohead",
                    genero = "Rock",
                    anno = 1995,
                    precio = 45900,
                    formato = "LP",
                    colorVinilo = "Negro - Blanco",
                    stock = 12,
                    sello = "Parlophone",
                    pais = "Reino Unido",
                    edicion = "Original",
                    duracion = "48:37",
                    descripcion = "El segundo álbum de Radiohead marca su transición hacia un sonido más emocional y alternativo con himnos inolvidables.",
                    img = "radiohead_the_bends_cover.jpg"
                ),
                Vinilo(
                    idVin = 4,
                    nombre = "Imaginal Disk",
                    artista = "Magdalena Bay",
                    genero = "Electropop",
                    anno = 2021,
                    precio = 38900,
                    formato = "LP",
                    colorVinilo = "Transparente",
                    stock = 7,
                    sello = "Labrador",
                    pais = "EE.UU.",
                    edicion = "Original",
                    duracion = "42:12",
                    descripcion = "Electropop brillante y nostálgico de Magdalena Bay con un sonido synthpop fresco y pegadizo.",
                    img = "magdalena_bay_imaginal_disk_cover.jpg"
                ),
                Vinilo(
                    idVin = 5,
                    nombre = "Thriller",
                    artista = "Michael Jackson",
                    genero = "Pop",
                    anno = 1982,
                    precio = 52900,
                    formato = "LP",
                    colorVinilo = "Negro",
                    stock = 15,
                    sello = "Epic",
                    pais = "EE.UU.",
                    edicion = "Original",
                    duracion = "42:19",
                    descripcion = "El icónico álbum de Michael Jackson que revolucionó el pop y estableció récords de ventas en todo el mundo.",
                    img = "michael_jackson_thriller_cover.jpg"
                )
            )

            _vinilos.value = datosVinilos
            _generos.value = datosVinilos.map { it.genero }.distinct()
            _artistas.value = datosVinilos.map { it.artista }.distinct()
        }
    }
}
