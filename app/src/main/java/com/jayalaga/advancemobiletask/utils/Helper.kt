package com.jayalaga.advancemobiletask.utils

import com.jayalaga.advancemobiletask.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Dummy.route,
        Screen.Schedule.route,
        Screen.Favorite.route
    )
}