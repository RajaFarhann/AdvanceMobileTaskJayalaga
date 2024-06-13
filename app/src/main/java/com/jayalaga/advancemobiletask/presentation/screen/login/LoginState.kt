package com.jayalaga.advancemobiletask.presentation.screen.login

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)