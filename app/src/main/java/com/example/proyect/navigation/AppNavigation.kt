package com.example.proyect.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyect.data.repository.CourseRepository
import com.example.proyect.screens.*
import com.example.proyect.viewmodel.CourseFormViewModel
import com.example.proyect.viewmodel.CourseFormViewModelFactory
import com.example.proyect.viewmodel.CoursesViewModel

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
            val coursesViewModel: CoursesViewModel = viewModel() // Obtén el CoursesViewModel
            AddCourses(
                viewModel = coursesViewModel,  // Pasa el CoursesViewModel
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
            val repository = CourseRepository()  // Crear una instancia del repository
            val courseFormViewModel: CourseFormViewModel = viewModel(
                factory = CourseFormViewModelFactory(repository)  // Pasar el factory con el repository
            )

            EnterCoursesScreen(
                viewModel = courseFormViewModel,  // Pasar el ViewModel
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

        composable("home_screen") {
            MainPage(navController = navController)
        }

        composable("history_task_screen") {
            HistoryScreen(navController = navController)
        }

        composable("courses_screen") {
            CoursesScreen(navController = navController)
        }

        composable("calendar_screen") {
            CalendarScreen(navController = navController)
        }

        composable("task_details") {
            TaskDetailsScreen(
                onBackClick = { navController.popBackStack() }, // Regresar a la pantalla anterior
                onEditClick = { navController.navigate("edit_task_screen") } // Navegar a la pantalla de edición
            )
        }


        composable("edit_task_screen") {
            PreviewEditTaskScreen(
                onDoneClick = { navController.popBackStack() },  // Confirmar regresa a TaskDetailsScreen
                navController = navController  // Pasamos el navController aquí para navegar
            )
        }

        composable("courses_screen") {
            CoursesScreen(navController = navController)
        }

        composable("course_details_screen/{courseName}") { backStackEntry ->
            val courseName = backStackEntry.arguments?.getString("courseName") ?: "Desconocido"
            CourseDetailsScreen(courseName = courseName, navController = navController)
        }



    }
}