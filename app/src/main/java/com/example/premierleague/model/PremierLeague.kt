package com.example.premierleague.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PremierLeague(
    val id: Int,
    @StringRes val teamTitle: Int,
    @StringRes val teamSubtitle: Int,
    @StringRes val teamStartDate: Int,
    @StringRes val teamDetails: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val teamImageBanner: Int
)
