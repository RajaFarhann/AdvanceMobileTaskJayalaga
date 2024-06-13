package com.jayalaga.advancemobiletask.data.local

import com.jayalaga.advancemobiletask.R
import com.jayalaga.advancemobiletask.model.OnBoardingItem

object OnBoardingData {

    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.raw.welcome,
            title = "Selamat Datang di Jayalaga App",
            description = "Tingkatkan Skill Android Development kamu, dengan belajar di platform yang seru."
        ),
        OnBoardingItem(
            resId = R.raw.android,
            title = "Aplikasi Reminder App",
            description = "Materi yang disajikan selalu up to date, mengikuti perkembangan teknologi."
        ),
        OnBoardingItem(
            resId = R.raw.developer,
            title = "Tugasnya udah deadline guys",
            description = "Dengan belajar secara konsisten. Kamu akan menjadi Developer yang hebat di masa depan"
        ),
    )
}