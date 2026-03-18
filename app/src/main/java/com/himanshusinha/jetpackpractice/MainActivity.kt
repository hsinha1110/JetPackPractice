package com.himanshusinha.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.himanshusinha.jetpackpractice.apps.First
import com.himanshusinha.jetpackpractice.apps.Second
import com.himanshusinha.jetpackpractice.apps.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Routes.first
            ) {
                composable(Routes.first) {
                    First(navController)
                }

                composable(
                    route = Routes.second,
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType }
                    )
                ) {
                    backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name")
                    Second(name ?: "No Name")
                }
            }
        }
    }
}