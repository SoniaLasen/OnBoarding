package com.example.onboarding.onBoardViews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onboarding.LoaderData
import com.example.onboarding.data.PageData



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(
    item: List<PageData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(modifier= modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            HorizontalPager(state = pagerState) {
                Column (modifier = Modifier
                    .padding(60.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LoaderData(modifier = Modifier
                        .size((200.dp))
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally),
                        image = item[it].image)//este it viene del HorizontalPager y se corresponde con el número de página actual

                Text(text = item[it].title,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold)
                
                Text(text = item[it].desc,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp)
            }}
            PagerIndicator(size = item.size, currentPage = pagerState.currentPage ) //item.size es el tamaño de la lista 
            // cuando le pongamos datos. En este caso coincide que el número de datos y el número de elementos de la lista
            // es el mismo, pero no hay que confundir. 
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(currentPage = pagerState.currentPage, navController)
        }
    }
}