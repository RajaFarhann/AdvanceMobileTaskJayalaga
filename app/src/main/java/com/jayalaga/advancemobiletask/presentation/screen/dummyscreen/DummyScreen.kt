package com.jayalaga.advancemobiletask.presentation.screen.dummyscreen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.R
import com.jayalaga.advancemobiletask.presentation.JayalagaApp
import com.jayalaga.advancemobiletask.presentation.Schedule.ScheduleScreen

@Composable
fun DummyScreen(
    navController: NavController,
    scrollState: ScrollState = rememberScrollState(),
){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(scrollState)
        ){
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = R.drawable.closeup_watch),
                contentDescription = "Main Picture"
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "This is Dummy Screen for test",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                    Spacer(modifier = Modifier.height(10.dp))
//                    ScheduleScreen(navController)
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
private fun DummyScreenPreview(){
    DummyScreen(navController = rememberNavController())
}