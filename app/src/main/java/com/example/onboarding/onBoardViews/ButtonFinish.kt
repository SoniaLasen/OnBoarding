package com.example.onboarding.onBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onboarding.dataStore.StoreBoarding
import kotlinx.coroutines.launch

@Composable
fun ButtonFinish(currentPage: Int, navController: NavController){

    val scope = rememberCoroutineScope()

    val context= LocalContext.current //sacamos el contexto de esta vista
    val dataStore = StoreBoarding(context)//para usarlo aquí como parámetro

    Row (modifier = Modifier
        .padding(bottom = 20.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        if(currentPage == 2) OutlinedButton(onClick = {
            navController.navigate("Home"){popUpTo(0)}
            scope.launch { dataStore.saveBoarding(true) }
        }) {
            Text(text = "Comenzar", modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 40.dp),
                color = Color.Magenta
            )
        }
    }
}