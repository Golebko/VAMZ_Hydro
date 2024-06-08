package com.example.vamzhydro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.ScrollAxisRange
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vamzhydro.screens.AddRecordScreen
import com.example.vamzhydro.screens.HomeScreen


@Composable
fun HydroNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.AddRecord.route
        ){
            AddRecordScreen(navController = navController)
        }
    }
}