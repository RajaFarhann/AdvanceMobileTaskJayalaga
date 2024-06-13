package com.jayalaga.advancemobiletask.presentation.Schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.data.local.DummyData
import com.jayalaga.advancemobiletask.model.Schedule
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.Schedule.component.ScheduleColumn

@Composable
fun ScheduleScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    schedule: List<Schedule> = DummyData.scheduleList
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "schedule"

    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = modifier
        ){
            items(schedule, key = {it.id}){
                ScheduleColumn(schedule = it) {

                }
//            ScheduleColumn(schedule = it) {scheduleId ->
//                navController.navigate(Screen.Home.route + "/$scheduleId")
//            }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ScheduleScreenPreview(){
    ScheduleScreen(navController = rememberNavController())
}