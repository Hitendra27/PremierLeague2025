package com.example.premierleague.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.premierleague.R
import com.example.premierleague.model.PremierLeagueTeam

object LocalTeamsDataProvider {
    val defaultTeam = getTeamsData()[0]

    fun getTeamsData(): List<PremierLeagueTeam> {
        return listOf(
            PremierLeagueTeam(
                id = 1,
                teamTitle = R.string.arsenal,
                teamStadium = R.string.arsenal_stadium,
                teamEstablished = R.string.arsenal_established,
                teamDetails = R.string.arsenal_details,
                imageResourceId = R.drawable.arsenal_logo,
                teamImageBanner = R.drawable.arsenal_banner
            ),
            PremierLeagueTeam(
                id = 2,
                teamTitle = R.string.liverpool,
                teamStadium = R.string.liverpool_stadium,
                teamEstablished = R.string.liverpool_established,
                teamDetails = R.string.liverpool_details,
                imageResourceId = R.drawable.liverpool_logo,
                teamImageBanner = R.drawable.liverpool_banner
            ),
            PremierLeagueTeam(
                id = 3,
                teamTitle = R.string.man_city,
                teamStadium = R.string.man_city_stadium,
                teamEstablished = R.string.man_city_established,
                teamDetails = R.string.man_city_details,
                imageResourceId = R.drawable.mancity_logo,
                teamImageBanner = R.drawable.man_city_banner
            ),
            PremierLeagueTeam(
                id = 4,
                teamTitle = R.string.newcastle,
                teamStadium = R.string.newcastle_stadium,
                teamEstablished = R.string.newcastle_established,
                teamDetails = R.string.newcastle_details,
                imageResourceId = R.drawable.newcastle_logo,
                teamImageBanner = R.drawable.newcastle_banner
            ),
            PremierLeagueTeam(
                id = 5,
                teamTitle = R.string.chelsea,
                teamStadium = R.string.chelsea_stadium,
                teamEstablished = R.string.chelsea_established,
                teamDetails = R.string.chelsea_details,
                imageResourceId = R.drawable.chelsea_logo,
                teamImageBanner = R.drawable.chelsea_banner
            ),
            PremierLeagueTeam(
                id = 6,
                teamTitle = R.string.nottingham_forest,
                teamStadium = R.string.nottingham_forest_stadium,
                teamEstablished = R.string.nottingham_forest_established,
                teamDetails = R.string.nottingham_forest_details,
                imageResourceId = R.drawable.nottsforest_logo,
                teamImageBanner = R.drawable.notts_banner
            ),
            PremierLeagueTeam(
                id = 7,
                teamTitle = R.string.man_united,
                teamStadium = R.string.man_united_stadium,
                teamEstablished = R.string.man_united_established,
                teamDetails = R.string.man_united_details,
                imageResourceId = R.drawable.manu_logo,
                teamImageBanner = R.drawable.man_u_banner
            ),
            PremierLeagueTeam(
                id = 8,
                teamTitle = R.string.tottenham,
                teamStadium = R.string.tottenham_stadium,
                teamEstablished = R.string.tottenham_established,
                teamDetails = R.string.tottenham_details,
                imageResourceId = R.drawable.tottenham_logo,
                teamImageBanner = R.drawable.tottenham_banner
            ),
            PremierLeagueTeam(
                id = 9,
                teamTitle = R.string.brentford,
                teamStadium = R.string.brentford_stadium,
                teamEstablished = R.string.brentford_established,
                teamDetails = R.string.brentford_details,
                imageResourceId = R.drawable.brentford_logo,
                teamImageBanner = R.drawable.brentford_banner
            ),
            PremierLeagueTeam(
                id = 10,
                teamTitle = R.string.brighton,
                teamStadium = R.string.brighton_stadium,
                teamEstablished = R.string.brighton_established,
                teamDetails = R.string.brighton_details,
                imageResourceId = R.drawable.brighton_logo,
                teamImageBanner = R.drawable.brighton_banner
            ),
            PremierLeagueTeam(
                id = 11,
                teamTitle = R.string.aston_villa,
                teamStadium = R.string.aston_villa_stadium,
                teamEstablished = R.string.aston_villa_established,
                teamDetails = R.string.aston_villa_details,
                imageResourceId = R.drawable.astonvilla_logo,
                teamImageBanner = R.drawable.aston_villa_banner
            ),
            PremierLeagueTeam(
                id = 12,
                teamTitle = R.string.bournemouth,
                teamStadium = R.string.bournemouth_stadium,
                teamEstablished = R.string.bournemouth_established,
                teamDetails = R.string.bournemouth_details,
                imageResourceId = R.drawable.bournmouth_logo,
                teamImageBanner = R.drawable.bournmouth_banner
            ),
            PremierLeagueTeam(
                id = 13,
                teamTitle = R.string.crystal_palace,
                teamStadium = R.string.crystal_palace_stadium,
                teamEstablished = R.string.crystal_palace_established,
                teamDetails = R.string.crystal_palace_details,
                imageResourceId = R.drawable.crystalpalace_logo,
                teamImageBanner = R.drawable.crystal_palace_banner
            ),
            PremierLeagueTeam(
                id = 14,
                teamTitle = R.string.fulham,
                teamStadium = R.string.fulham_stadium,
                teamEstablished = R.string.fulham_established,
                teamDetails = R.string.fulham_details,
                imageResourceId = R.drawable.fulham_logo,
                teamImageBanner = R.drawable.fulham_banner
            ),
            PremierLeagueTeam(
                id = 15,
                teamTitle = R.string.west_ham,
                teamStadium = R.string.west_ham_stadium,
                teamEstablished = R.string.west_ham_established,
                teamDetails = R.string.west_ham_details,
                imageResourceId = R.drawable.westham_logo,
                teamImageBanner = R.drawable.west_ham_banner
            ),
            PremierLeagueTeam(
                id = 16,
                teamTitle = R.string.wolves,
                teamStadium = R.string.wolves_stadium,
                teamEstablished = R.string.wolves_established,
                teamDetails = R.string.wolves_details,
                imageResourceId = R.drawable.wolverhampton_logo,
                teamImageBanner = R.drawable.wolverhampton_banner
            ),
            PremierLeagueTeam(
                id = 17,
                teamTitle = R.string.everton,
                teamStadium = R.string.everton_stadium,
                teamEstablished = R.string.everton_established,
                teamDetails = R.string.everton_details,
                imageResourceId = R.drawable.everton_logo,
                teamImageBanner = R.drawable.everton_banner
            ),
            PremierLeagueTeam(
                id = 18,
                teamTitle = R.string.ipswich_town,
                teamStadium = R.string.ipswich_town_stadium,
                teamEstablished = R.string.ipswich_town_established,
                teamDetails = R.string.ipswich_town_details,
                imageResourceId = R.drawable.ipswich_logo,
                teamImageBanner = R.drawable.ipwich_town_banner
            ),
            PremierLeagueTeam(
                id = 19,
                teamTitle = R.string.leicester_city,
                teamStadium = R.string.leicester_city_stadium,
                teamEstablished = R.string.leicester_city_established,
                teamDetails = R.string.leicester_city_details,
                imageResourceId = R.drawable.leicester_logo,
                teamImageBanner = R.drawable.leicester_banner
            ),
            PremierLeagueTeam(
                id = 20,
                teamTitle = R.string.southampton,
                teamStadium = R.string.southampton_stadium,
                teamEstablished = R.string.southampton_established,
                teamDetails = R.string.southampton_details,
                imageResourceId = R.drawable.southamton_logo,
                teamImageBanner = R.drawable.southamton_banner
            ),
        )
    }
}

