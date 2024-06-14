package com.jayalaga.advancemobiletask.navigation

sealed class Screen (val route: String){

    data object Splash: Screen ("splash")
    data object OnBoarding: Screen ("on_boarding")
    data object Home: Screen ("home")
    data object Dummy: Screen ("dummy")

    data object Login: Screen ("login")
    data object Schedule: Screen ("schedule")
    data object Detail: Screen ("detail")
    data object Favorite: Screen ("favorite")
    data object Profile: Screen ("profile")


}