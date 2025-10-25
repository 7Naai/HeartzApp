package com.example.heartzapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.heartzapp.R

@Composable
fun AdminBar(navController: NavHostController) {
    val items = listOf(
        AdminNavItem("Dashboard", "admin_dashboard", R.drawable.dashboard_icon_opsz24),
        AdminNavItem("Usuarios", "admin_usuarios", R.drawable.groups_icon_opsz24),
        AdminNavItem("Productos", "admin_productos", R.drawable.inventory_icon_opsz24)
    )

    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = if (currentRoute == item.route) Color(0xFFB388FF) else Color.White,
                        modifier = androidx.compose.ui.Modifier.size(32.dp) // tamaño ajustable
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (currentRoute == item.route) Color(0xFFB388FF) else Color.White
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) navController.navigate(item.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

data class AdminNavItem(
    val title: String,
    val route: String,
    val icon: Int
)
