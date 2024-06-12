package com.jayalaga.advancemobiletask.presentation.screen.dummyscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DummyScreen(
    navController: NavController
){
    Text(text = "This is Dummy Screen")
}