package com.example.myapplication.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.components.navigation.example.DetailScreen
import com.example.myapplication.components.navigation.example.HomeScreen
import com.example.myapplication.components.navigation.example.LoginScreen

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(navigateBack = { navController.popBackStack() }, navigateToDetail = {
                navController.navigate(
                    Detail(it)
                )
            })
        }

        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(detail.id)
        }
    }
}