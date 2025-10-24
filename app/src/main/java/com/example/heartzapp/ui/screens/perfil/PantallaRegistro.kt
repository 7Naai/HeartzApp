package com.example.heartzapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartzapp.R

@Composable
fun PantallaRegistroCompleto(
    onRegisterSuccess: (usuario: Usuario) -> Unit = {},
    onBackToLogin: () -> Unit = {}
) {
    // Campos del formulario
    var rut by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf("Cliente") } // default
    var fechaNacimiento by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFD5B6F2), // morado claro
            Color(0xFFFFFFFF)  // blanco
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Crea tu cuenta",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF3B006A)
            )
            Text(
                text = "¡Bienvenido a Heartz!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF3B006A)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // RUT
            OutlinedTextField(
                value = rut,
                onValueChange = { rut = it },
                label = { Text("RUT") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre completo") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Correo
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.person_icon_login_opsz24),
                        contentDescription = "Icono usuario",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Contraseña
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.lock_icon_login_opsz24),
                        contentDescription = "Icono candado",
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    val icon = if (passwordVisible)
                        R.drawable.visibility_off_icon_login_opsz24
                    else
                        R.drawable.visibility_icon_login_opsz24
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = painterResource(id = icon),
                            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Confirmar contraseña
            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                label = { Text("Confirmar contraseña") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.lock_icon_login_opsz24),
                        contentDescription = "Icono candado",
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    val icon = if (confirmPasswordVisible)
                        R.drawable.visibility_off_icon_login_opsz24
                    else
                        R.drawable.visibility_icon_login_opsz24
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Image(
                            painter = painterResource(id = icon),
                            contentDescription = if (confirmPasswordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))




            Spacer(modifier = Modifier.height(12.dp))

            // Fecha de nacimiento
            OutlinedTextField(
                value = fechaNacimiento,
                onValueChange = { fechaNacimiento = it },
                label = { Text("Fecha de nacimiento (dd/mm/yyyy)") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Registrar
            Button(
                onClick = {
                    if (contrasena == confirmarContrasena) {
                        val usuario = Usuario(rut, nombre, correo, rol, fechaNacimiento)
                        onRegisterSuccess(usuario)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Registrarse")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Volver al login
            Text(
                text = "¿Ya tienes cuenta? Inicia sesión",
                color = Color(0xFF3B006A),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onBackToLogin() }
            )
        }
    }
}

// Clase de datos para el usuario
data class Usuario(
    val rut: String,
    val nombre: String,
    val correo: String,
    val rol: String,
    val fechaNacimiento: String
)

@Preview(showBackground = true)
@Composable
fun PantallaRegistroCompletoPreview() {
    PantallaRegistroCompleto()
}
