package com.example.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.onBoardViews.MainOnBoarding
import com.example.onboarding.views.HomeView

@Composable
fun NavManager (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "OnBoarding" ) {
        composable("OnBoarding"){ MainOnBoarding(navController) }
        composable("Home"){HomeView(navController)}
    }
}
