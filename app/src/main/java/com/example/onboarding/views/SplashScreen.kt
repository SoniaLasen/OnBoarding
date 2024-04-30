package com.example.onboarding.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.onboarding.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavController){
    
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate("OnBoarding"){
            popUpTo(0)
        }

    }
    
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.output), contentDescription ="imagen genérica")
    }
}