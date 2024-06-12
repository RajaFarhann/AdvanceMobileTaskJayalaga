package com.jayalaga.advancemobiletask.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.screen.dummyscreen.DummyScreen
import com.jayalaga.advancemobiletask.presentation.screen.onboarding.OnBoardingScreen
import com.jayalaga.advancemobiletask.presentation.screen.splash.SplashScreen

@Composable
fun JayalagaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold (
        modifier = modifier
    ){innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route){
                SplashScreen(navController = navController)
            }
            composable(Screen.OnBoarding.route){
                OnBoardingScreen(navController = navController)
            }
            composable(Screen.Dummy.route){
                DummyScreen(navController)
            }
        }
    }
}