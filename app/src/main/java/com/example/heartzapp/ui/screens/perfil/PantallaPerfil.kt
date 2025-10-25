package com.example.heartzapp.ui.screens.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.heartzapp.ui.components.BottomBar

@Composable
fun PantallaPerfil(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF7E57C2),
                        Color(0xFFF3E5F5)
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Perfil",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("register") },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Registrarse", color = Color.Black)
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 0.dp)
        ) {
            BottomBar(navController)
        }
    }
}
