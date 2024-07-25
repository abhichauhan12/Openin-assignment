package com.abhishek.openinapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.rememberNavController
import com.abhishek.openinapp.presentation.bottombar.AppNavigation
import com.abhishek.openinapp.presentation.bottombar.CustomBottomBar
import com.abhishek.openinapp.presentation.dashboard.Dashboard

@Preview(device = Devices.PIXEL_6)
@Composable
fun Home(){

    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {

        ConstraintLayout() {

            val (customBar , views) = createRefs()

            Box (modifier = Modifier.constrainAs(views){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(customBar.top)
            }){
//                Dashboard()
                AppNavigation(navController)

            }

            Box (modifier = Modifier.constrainAs(customBar){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }){
                CustomBottomBar(navController)
            }


        }


    }

}