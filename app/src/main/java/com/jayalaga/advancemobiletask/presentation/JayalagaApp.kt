package com.jayalaga.advancemobiletask.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jayalaga.advancemobiletask.R
import com.jayalaga.advancemobiletask.navigation.NavigationItem
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.screen.schedule.DetailScreen
import com.jayalaga.advancemobiletask.presentation.screen.schedule.ScheduleScreen
import com.jayalaga.advancemobiletask.presentation.screen.dummyscreen.DummyScreen
import com.jayalaga.advancemobiletask.presentation.screen.favorite.FavoriteScreen
import com.jayalaga.advancemobiletask.presentation.screen.login.LoginScreen
import com.jayalaga.advancemobiletask.presentation.screen.onboarding.OnBoardingScreen
import com.jayalaga.advancemobiletask.presentation.screen.profile.ProfileScreen
import com.jayalaga.advancemobiletask.presentation.screen.splash.SplashScreen
import com.jayalaga.advancemobiletask.utils.shouldShowBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JayalagaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold (
        topBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                TopAppBar(
                    title = { Text(text = "Jayalaga", fontWeight = FontWeight.Bold) },
                    )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                // BottomBar will be here
                BottomBar(navController)
            }
        },
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
            composable(Screen.Login.route){
                LoginScreen(navController)
            }
            composable(Screen.Dummy.route){
                DummyScreen(navController)
            }
            composable(Screen.Favorite.route){
                FavoriteScreen(navController)
            }
            composable(Screen.Profile.route){
                ProfileScreen(navController)
            }
            composable(Screen.Schedule.route){
                ScheduleScreen(navController)
            }
            composable(Screen.Detail.route + "/{schedule}",
                arguments = listOf(navArgument("schedule") {type = NavType.IntType})
            ){navBackStackEntry ->
                DetailScreen(
                    navController = navController,
                    scheduleId = navBackStackEntry.arguments?.getInt("schedule")
                )
            }
        }
    }
}

//Bottom Bar
@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavigationBar (
        modifier = modifier
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_schedule),
                icon = Icons.Default.Timer,
                screen = Screen.Schedule
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Star,
                screen = Screen.Favorite
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Person,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun JayalagaAppPreveiw(){
    JayalagaApp()
}