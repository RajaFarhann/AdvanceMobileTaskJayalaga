package com.jayalaga.advancemobiletask.presentation.screen.favorite

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.data.local.DummyData
import com.jayalaga.advancemobiletask.model.Schedule
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.screen.dummyscreen.DummyScreen
import com.jayalaga.advancemobiletask.presentation.screen.schedule.component.ScheduleColumn

@Composable
fun FavoriteScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    schedule: List<Schedule> = DummyData.scheduleList,
    scrollState: ScrollState = rememberScrollState(),

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
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Favorite",
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
private fun FavoriteScreenPreview(){
    FavoriteScreen(navController = rememberNavController())
}