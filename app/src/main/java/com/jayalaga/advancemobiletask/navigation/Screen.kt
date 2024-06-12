package com.jayalaga.advancemobiletask.navigation

sealed class Screen (val route: String){

    data object Splash: Screen ("splash")
    data object OnBoarding: Screen ("on_boarding")
    data object Home: Screen ("home")
    data object Dummy: Screen ("dummy")


}