package com.example.onboarding.onBoardViews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.onboarding.R
import com.example.onboarding.data.PageData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainOnBoarding(){
    val items = ArrayList<PageData>()//se pone () para indicar que el array está vacío

    items.add(
        PageData(
            R.raw.page1,
            "Title 1",
            "Estaba la mosca cantando debajo del agua"
        )
    )

    items.add(
        PageData(
            R.raw.page2,
            "Title 2",
            "Cuando la mosca se puso a cantar vino la araña y la hizo callar"
        )
    )

    items.add(
        PageData(
            R.raw.page3,
            "Title 3",
            "Cuando la araña se puso a cantar, vino la rana y la hizo callar"
        )
    )

    val pagerState = rememberPagerState (0, pageCount = { items.size }) //viene de HorizontalPager, crea y recuerda un PagerState

    
    OnBoardingPager(item = items, pagerState = pagerState, modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
    )
}