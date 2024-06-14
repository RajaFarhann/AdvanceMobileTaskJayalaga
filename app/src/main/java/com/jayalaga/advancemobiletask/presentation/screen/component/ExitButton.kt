package com.jayalaga.advancemobiletask.presentation.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExitButton(
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ){
        IconButton(onClick = onLogoutClick) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Logout, contentDescription = "LogoutButton")
        }
    }
}