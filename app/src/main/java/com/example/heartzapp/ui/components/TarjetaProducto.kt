package com.example.heartzapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.heartzapp.data.model.Vinilo

@Composable
fun TarjetaVinilo(vinilo: Vinilo, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A004E)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Placeholder para la imagen del vinilo
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFF4A148C), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "💿",
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = vinilo.nombre,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = vinilo.artista,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFFB388FF)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$$${"%,.0f".format(vinilo.precio)}",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color(0xFF9C27B0),
                    fontWeight = FontWeight.Bold
                )
            )

            if (vinilo.stock > 0) {
                Text(
                    text = "Stock: ${vinilo.stock}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White.copy(alpha = 0.7f)
                    )
                )
            } else {
                Text(
                    text = "Agotado",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Red
                    )
                )
            }
        }
    }
}