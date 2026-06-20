package com.lasalle.peliculas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lasalle.peliculas.screens.DetailScreen
import com.lasalle.peliculas.screens.HomeScreen

// IA generated: Navigation with movieId argument to filter characters correctly
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            // IA generated: HomeScreen now sends the ID of the selected movie
            HomeScreen(onMovieClick = { movieId ->
                navController.navigate("detail/$movieId")
            })
        }
        composable(
            route = "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 1
            // IA generated: DetailScreen receives the movieId to filter its character list
            DetailScreen(
                movieId = movieId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
