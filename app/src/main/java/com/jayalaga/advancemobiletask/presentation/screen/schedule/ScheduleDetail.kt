package com.jayalaga.advancemobiletask.presentation.screen.schedule


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.data.local.DummyData
import com.jayalaga.advancemobiletask.model.Schedule

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    scheduleId: Int?
) {
    val newScheduleList = DummyData.scheduleList.filter { schedule ->
        schedule.id == scheduleId
    }
    Column(
        modifier = modifier
    ) {
        DetailScheduleContent(newScheduleList = newScheduleList, navController = navController)
    }
}

@Composable
private fun DetailScheduleContent(
    newScheduleList: List<Schedule>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        Column (
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            androidx.compose.material3.Text(
                text = newScheduleList[0].title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            androidx.compose.material3.Text(
                text = "(${newScheduleList[0].time})",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material3.Text(
                text = "Role: ${newScheduleList[0].location}",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }

//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Start,
//        modifier = modifier.padding(16.dp)
//    ) {
//
//    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScheduleContentPreview() {
    DetailScheduleContent(newScheduleList = DummyData.scheduleList, navController = rememberNavController())
}