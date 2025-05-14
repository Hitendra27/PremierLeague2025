package com.example.premierleague.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PremierLeagueTeam(
    val id: Int,
    @StringRes val teamTitle: Int,
    @StringRes val teamStadium: Int,
    @StringRes val teamEstablished: Int,
    @StringRes val teamDetails: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val teamImageBanner: Int
)
