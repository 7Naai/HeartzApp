package com.example.heartzapp.ui.utils

object LoginValidator {
    fun validarUsuario(correo: String, contrasena: String): String? {
        return when {
            correo == "admin@heartzapp.cl" && contrasena == "1234" -> "admin"
            correo.isNotEmpty() && contrasena.isNotEmpty() -> "cliente"
            else -> null
        }
    }
}