package com.abhishek.openinapp.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhishek.openinapp.R
import com.abhishek.openinapp.domian.model.Links
import com.abhishek.openinapp.presentation.DataViewModel
import com.abhishek.openinapp.ui.theme.BlueCustom
import com.abhishek.openinapp.ui.theme.GreyCustom
import com.abhishek.openinapp.ui.theme.LightBlueCustom
import com.abhishek.openinapp.ui.theme.LightGreyCustom
import com.abhishek.openinapp.utils.shortenText
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Preview(device = Devices.PIXEL_6)
@Composable
fun Dashboard() {
    val viewModel : DataViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.getData()
    }
    Box(modifier = Modifier
        .background(BlueCustom)
        .padding(top = 80.dp)){

        LazyColumn() {
            item {
                TopBar()
            }
            item {
                Analytics()
            }
            item {
                TopLinkRecentLink()
            }
        }

    }

}




@Preview(device = Devices.PIXEL_6)
@Composable
fun TopBar(){

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(124.dp)
        .background(BlueCustom)
        .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier.fillMaxWidth() ){
            Text(text = "Dashboard", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)


            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(40.dp)
                    .background(GreyCustom.copy(alpha = (0.3f)), RoundedCornerShape(8.dp))
            ){
                Image(painterResource(
                    id = R.drawable.setting),
                    contentDescription = "Setting Button" ,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(40.dp)
                        .padding(8.dp) )

            }
        }

    }
}

@Preview(device = Devices.PIXEL_6)
@Composable
fun Analytics(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(LightGreyCustom, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
        .padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ){
        Column {

            Text(text = "Good Morning" , fontSize = 24.sp , color = Color.DarkGray )

            Spacer(modifier = Modifier.height(4.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Ajay Manav ", fontSize = 32.sp)
                Image(painterResource(id = R.drawable.waving_image) , contentDescription ="waving hand" , modifier = Modifier.size(32.dp))
            }

            Box (modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(top = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
            ){
//                LineChartScreen()
                LineChartScreenWithOverview()
            }

            Spacer(modifier = Modifier.height(16.dp))

        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyListRow()

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(4.dp)
            .border(width = 2.dp, color = Color.LightGray, RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center
        ){
            Image(painterResource(id = R.drawable.upload), contentDescription = "", modifier = Modifier.size(38.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "View Analytics" , fontSize = 24.sp , fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(24.dp))

    }

}


@Composable
fun LazyListRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { ListItem1() }
        item { ListItem2() }
        item { ListItem3() }
    }
}



//@Preview(device = Devices.PIXEL_6)
@Composable
fun TopLinkRecentLink(){

    val viewModel : DataViewModel = hiltViewModel()
    val linkData = viewModel.apiData.collectAsState()
    Log.d("dataas", "$linkData")



    var selectedTab by remember { mutableStateOf(0) }

    Column(modifier = Modifier
        .background(LightGreyCustom)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGreyCustom)
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { selectedTab = 0},
                    colors =   ButtonDefaults.buttonColors(if (selectedTab == 0) Color(0xFF357AF7) else Color.Transparent),
                    shape = CircleShape,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = "Top Links", fontSize = 14.sp, color = if(selectedTab == 0) Color.White else Color.DarkGray)
                }

                Button(
                    onClick = { selectedTab = 1 },
                    colors =   ButtonDefaults.buttonColors(if (selectedTab == 1) Color(0xFF357AF7) else Color.Transparent),
                    shape = CircleShape,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = "Recents link", fontSize = 14.sp, color = if(selectedTab == 1) Color.White else Color.DarkGray)
                }

            }

            IconButton(
                onClick = { /* Handle search click */ },
                modifier = Modifier
                    .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                    .size(40.dp)
                    .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(8.dp)),
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search" , tint = Color.DarkGray)
            }

        }


        linkData.value.take(4).forEach { link ->
            LinksCardUI(link)
        }


    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(width = 1.dp, color = Color.Gray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        .padding(16.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(painterResource(id = R.drawable.link )  , contentDescription = "Link" , modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "View All Links", fontSize = 24.sp)
    }

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(Color.Green.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
        .border(width = 1.dp, color = Color.Green.copy(alpha = 0.7f), RoundedCornerShape(8.dp))
        .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(painterResource(id = R.drawable.whatsapp )  , contentDescription = "Link" , modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Talk to us", fontSize = 20.sp)
    }

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(color = BlueCustom.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
        .border(width = 1.dp, color = BlueCustom, RoundedCornerShape(8.dp))
        .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(painterResource(id = R.drawable.question )  , contentDescription = "quetion mark" , modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Frequently Asked Questions", fontSize = 20.sp)
    }
    }

    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(24.dp)
        .background(LightGreyCustom))

}

//@Preview(device = Devices.PIXEL_6)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LinksCardUI(item : Links){

    Column(modifier = Modifier
        .background(
            LightGreyCustom
        )
        .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .padding(16.dp)) {
            val (imageAmazon , name , date , clicks, clicksNumber ) = createRefs()

            Box(modifier = Modifier
                .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(8.dp))
                .padding(4.dp)
                .constrainAs(imageAmazon) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            ) {
                GlideImage(model = item.original_image, contentDescription = "image", modifier = Modifier.size(48.dp))
//                Image(painterResource(id = R.drawable.globe) , contentDescription = "Link Logo" , modifier = Modifier.size(48.dp))
            }

            Text(
                text = shortenText( item.titleName , 15),
                maxLines = 1,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(name) {
                    start.linkTo(imageAmazon.end , margin = 16.dp)
                    top.linkTo(parent.top)
                })

            Text(
                text = shortenText(item.times_ago ,20 ),
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(date) {
                    start.linkTo(imageAmazon.end , margin = 16.dp ,)
                    top.linkTo(name.bottom)
                })

            Text(
                text = shortenText(item.total_clicks.toString() , 20),
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(clicksNumber) {
                    end.linkTo(parent.end , margin = 16.dp)
                    top.linkTo(parent.top)
                })

            Text(
                text = "Clicks",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(clicks) {
                    end.linkTo(parent.end , margin = 16.dp)
                    top.linkTo(clicksNumber.bottom)
                })


        }

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = BlueCustom,
                RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
            )
            .background(LightBlueCustom, RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp))

            .padding(16.dp)
        ) {
            val (link ,copyIcon ) = createRefs()

            Text(
                text = shortenText(item.web_link , 20 ),
                fontSize = 20.sp,
                maxLines = 1,
                color = BlueCustom,
                modifier = Modifier.constrainAs(link) {
                    start.linkTo(parent.start , margin = 16.dp)
                    top.linkTo(parent.top)
                })


            IconButton(
                onClick = { /* Handle search click */ },
                modifier = Modifier
                    .size(28.dp)
                    .constrainAs(copyIcon) {
                        end.linkTo(parent.end, margin = 16.dp)
                    }
            ) {
                Icon(painterResource(id = R.drawable.copy), contentDescription = "Search" , tint = BlueCustom )
            }

        }

    }

}

















