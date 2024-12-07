package com.example.proyect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                navController = navController
            )
        }

        composable("schedule_screen") {
            ScheduleScreen(
                navController = navController,
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
            MainPage(navController = navController)  // Asegúrate de pasar el navController aquí
        }

        composable("add_courses_schedule") {
            CursosHoraYAulaScreen(
                onBackClick = { navController.popBackStack() },
                onDoneClick = { navController.popBackStack() }
            )
        }

        composable("enter_courses_screen") {
            EnterCoursesScreen(
                onBackClick = { navController.popBackStack() },
                onDoneClick = { navController.popBackStack() }
            )
        }

        composable("add_task") {
            AddTaskScreen(
                onDoneClick = {
                    navController.popBackStack()  // Regresa a la pantalla anterior después de añadir la tarea
                },
                navController = navController  // Usa el navController global aquí
            )
        }

    }
}
