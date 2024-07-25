package com.abhishek.openinapp.presentation.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.abhishek.openinapp.R
import com.abhishek.openinapp.ui.theme.BlueCustom

//@Preview(device = Devices.PIXEL_6)
@Composable
fun CustomBottomBar(navController: NavController) {

    var selectedButton by remember { mutableStateOf(0) }

    ConstraintLayout() {


        val( bar , fab) = createRefs()

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 16.dp, bottom = 16.dp)
            .constrainAs(bar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }

        ){


            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = { navController.navigate(Screen.Links.route)
                                    selectedButton = 0
                                  },
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Icon(painterResource(id = R.drawable.link),
                            contentDescription = "Links" ,
                            tint = if(selectedButton == 0) Color.Black else Color.Gray )
                    }
                    Text(text = "Links")
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {


                    IconButton(
                        onClick = {navController.navigate(Screen.Courses.route)
                            selectedButton = 1
                                  },
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Icon(painterResource(id = R.drawable.courses),
                            contentDescription = "" ,
                            tint = if(selectedButton == 1) Color.Black else Color.Gray )
                    }

                    Text(text = "Courses")
                }


                FloatingActionButton(onClick = { /*TODO*/ } ,
                    containerColor = BlueCustom,
                    modifier = Modifier
                        .size(0.dp)
                    ,
                    shape = CircleShape,
                ) {
                    Icon( Icons.Filled.Add,
                        contentDescription = "add"  ,
                        modifier =  Modifier.size(40.dp) ,
                        tint = Color.White)
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = { navController.navigate(Screen.Campaigns.route)
                            selectedButton = 2
                        },
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Icon(painterResource(id = R.drawable.campaigns),
                            contentDescription = "" ,
                            tint = if(selectedButton == 2) Color.Black else Color.Gray )
                    }

                    Text(text = "Campaigs")
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = {navController.navigate(Screen.Profile.route)
                            selectedButton = 3
                        },
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Icon(painterResource(id = R.drawable.profille),
                            contentDescription = "" ,
                            tint = if(selectedButton == 3) Color.Black else Color.Gray )
                    }

                    Text(text = "Profile")
                }

            }

        }

        Box(modifier = Modifier
            .background(Color.White , RoundedCornerShape(100))
            .size(92.dp)
            .constrainAs(fab) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 24.dp)
            }
        ){
            FloatingActionButton(onClick = { /*TODO*/ } ,
                containerColor = BlueCustom,
                modifier = Modifier
                    .size(84.dp)
                    .padding(4.dp)
                    .align(Alignment.Center),
                shape = CircleShape,
            ) {
                Icon( Icons.Filled.Add, contentDescription = "add"  , modifier =  Modifier.size(40.dp) , tint = Color.White)
            }

        }


    }



}














































