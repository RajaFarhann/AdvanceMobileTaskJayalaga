package com.jayalaga.advancemobiletask.presentation.screen.schedule.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayalaga.advancemobiletask.model.Schedule
import com.jayalaga.advancemobiletask.ui.theme.AdvanceMobileTaskTheme

@Composable
fun ScheduleColumn(
    schedule: Schedule,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClicked(schedule.id) }
    ){
        Card (
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(16.dp),
        ){
            Column (
                modifier = Modifier.padding(start = 7.dp)
            ){
                Text(text = schedule.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = schedule.time)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = schedule.location)
            }
            Row (
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 230.dp,)
                    .align(Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Outlined.Info, contentDescription = "")
                Text(text = "More Information..", style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScheduleColumnPreveiw(){
    AdvanceMobileTaskTheme{
        ScheduleColumn(
            schedule = Schedule(
                1,
                "Developer Vestival IL",
                "15:00 WIB",
                "Batam, Indonesia"
            ), onItemClicked = {scheduleId ->
                println("Schedule: $scheduleId")
            }
        )
    }

}