package com.example.proyect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyect.screens.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome_screen"
    ) {
        composable("welcome_screen") {
            WelcomeScreen(
                onNavigate = {
                    navController.navigate("add_courses")
                }
            )
        }

        composable("add_courses") {
            AddCourses(
                onDoneClick = {
                    navController.navigate("schedule_screen")
                },
                navController = navController // Aquí pasamos el navController
            )
        }

        composable("schedule_screen") {
            ScheduleScreen(
                navController = navController, // Pasamos el NavController aquí también
                onBackClick = {
                    navController.popBackStack()
                },
                onDoneClick = {
                    navController.navigate("start_home_screen")
                }
            )
        }

        composable("start_home_screen") {
            StartHomeScreen(
                onNavigate = {
                    navController.navigate("home_screen")
                }
            )
        }

        composable("home_screen") {
            MainPage()
        }

        composable("add_courses_schedule") { // Pantalla de Añadir Cursos y Horarios
            CursosHoraYAulaScreen(
                onBackClick = { navController.popBackStack() },
                onDoneClick = { navController.popBackStack() }
            )
        }
    }
}
