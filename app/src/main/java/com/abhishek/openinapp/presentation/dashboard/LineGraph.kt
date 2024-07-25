package com.abhishek.openinapp.presentation.dashboard

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.abhishek.openinapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


@Preview(device = Devices.PIXEL_6)
@Composable
fun LineChartScreen() {
    val context = LocalContext.current
    
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(8.dp)
        ,
        factory = {
            LineChart(context).apply {
                // Customize chart appearance
                setBackgroundColor(Color.WHITE)
                description.isEnabled = false
                setDrawGridBackground(false)

                val xAxis: XAxis = this.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(true)
                xAxis.valueFormatter = IndexAxisValueFormatter(arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug"))


                val leftAxis: YAxis = this.axisLeft
                leftAxis.setDrawGridLines(true)

                this.axisRight.isEnabled = false

                // Create sample data
                val entries = listOf(
                    Entry(0f, 20f),
                    Entry(1f, 30f),
                    Entry(2f, 50f),
                    Entry(3f, 70f),
                    Entry(4f, 100f),
                    Entry(5f, 50f),
                    Entry(6f, 25f),
                    Entry(7f, 90f)
                )

                val dataSet = LineDataSet(entries, "").apply {
                    color = Color.BLUE
                    setDrawFilled(true)
                    fillDrawable = getGradientDrawable()
                    mode = LineDataSet.Mode.CUBIC_BEZIER
                    setDrawValues(false)
                }
                val lineData = LineData(dataSet)
                this.data = lineData

                this.invalidate() // Refresh the chart
            }
        }
    )
}

fun getGradientDrawable(): Drawable {
    val gradient = GradientDrawable(
        GradientDrawable.Orientation.TOP_BOTTOM,
        intArrayOf(Color.BLUE, Color.TRANSPARENT)
    )
    return gradient
}

@Preview(device = Devices.PIXEL_6)
@Composable
fun OverViewTime(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 0.dp)
    ) {

        Text(
            text = "Overview", fontSize = 14.sp, color = androidx.compose.ui.graphics.Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(4.dp)
                .border(1.dp, androidx.compose.ui.graphics.Color.Gray, RoundedCornerShape(8.dp))
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Text(text = "22 Aug - 23 Sept", fontSize = 12.sp, color = androidx.compose.ui.graphics.Color.Black)
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.clock), contentDescription = null, tint = androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview()
@Composable
fun LineChartScreenWithOverview () {
    Column {
        OverViewTime()
        LineChartScreen()
    }

}