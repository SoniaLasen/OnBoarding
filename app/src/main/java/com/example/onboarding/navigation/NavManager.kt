package com.example.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.dataStore.StoreBoarding
import com.example.onboarding.onBoardViews.MainOnBoarding
import com.example.onboarding.views.HomeView
import com.example.onboarding.views.SplashScreen

@Composable
fun NavManager (){

    val context= LocalContext.current //sacamos el contexto de esta vista
    val dataStore = StoreBoarding(context)//para usarlo aquí como parámetro

    val store = dataStore.getBoarding.collectAsState(initial = false) //coger el dato inicial y según el valor ir a una página u otra


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (store.value) "Home" else "Splash" ) {
        composable("OnBoarding"){ MainOnBoarding(navController) }
        composable("Home"){HomeView()}
        composable("Splash"){ SplashScreen(navController) }

    }
}
