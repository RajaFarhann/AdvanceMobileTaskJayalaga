package com.jayalaga.advancemobiletask.presentation.screen.schedule

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.R
import com.jayalaga.advancemobiletask.data.local.DummyData
import com.jayalaga.advancemobiletask.model.Schedule
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.screen.schedule.component.ScheduleColumn

@Composable
fun ScheduleScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    schedule: List<Schedule> = DummyData.scheduleList
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "schedule"

    Box (
        modifier = Modifier
            .fillMaxSize()
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
                text = "Schedule",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Box (
                modifier = Modifier
                    .fillMaxSize()
            ){
                LazyColumn (
                    verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = modifier
                ){
                    items(schedule, key = {it.id}){
                        ScheduleColumn(schedule = it) {scheduleId->
                            navController.navigate(Screen.Detail.route + "/$scheduleId")
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ScheduleScreenPreview(){
    ScheduleScreen(navController = rememberNavController())
}