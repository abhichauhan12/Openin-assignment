package com.abhishek.openinapp.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.openinapp.R
import com.abhishek.openinapp.ui.theme.BlueCustom
import com.abhishek.openinapp.ui.theme.PurpleCustom
import com.abhishek.openinapp.ui.theme.RedCustom
import com.abhishek.openinapp.utils.shortenText


@Preview(device = Devices.PIXEL_6)
@Composable
fun ListItem1(){
    Column(modifier = Modifier
        .size(160.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .background(PurpleCustom.copy(alpha = (0.3f)), RoundedCornerShape(100))
                .padding(8.dp)
        ){
            Image(
                painterResource(id = R.drawable.cursor),
                contentDescription = "Setting Button" ,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "123" , fontSize = 24.sp , color = Color.Black, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Today's clicks" , fontSize = 16.sp , color = Color.DarkGray.copy(0.6f))
    }
}

@Preview(device = Devices.PIXEL_6)
@Composable
fun ListItem2(){
    Column(modifier = Modifier
        .size(160.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .background(BlueCustom.copy(alpha = (0.2f)), RoundedCornerShape(100))
                .padding(8.dp)
        ){
            Image(
                painterResource(id = R.drawable.location),
                contentDescription = "Setting Button" ,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = shortenText("Ahmedabad" , 6) , fontSize = 24.sp , color = Color.Black, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Top Location" , fontSize = 16.sp , color = Color.DarkGray.copy(0.6f))
    }
}
@Preview(device = Devices.PIXEL_6)
@Composable
fun ListItem3(){
    Column(modifier = Modifier
        .size(160.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .background(RedCustom.copy(alpha = (0.3f)), RoundedCornerShape(100))
                .padding(8.dp)
        ){
            Image(
                painterResource(id = R.drawable.globe),
                contentDescription = "Setting Button" ,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Instagram" , fontSize = 24.sp , color = Color.Black, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Top source" , fontSize = 16.sp , color = Color.DarkGray.copy(0.6f))
    }
}


