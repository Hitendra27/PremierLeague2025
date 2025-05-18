package com.example.premierleague.screens

import androidx.lifecycle.ViewModel
import com.example.premierleague.data.LocalTeamsDataProvider
import com.example.premierleague.model.PremierLeagueTeam
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class PremierLeagueViewModel : ViewModel() {

    internal val _uiState = MutableStateFlow(PremierLeagueUiState())
    val uiState: StateFlow<PremierLeagueUiState> = _uiState

    init {
        loadTeams()
    }

    private fun loadTeams() {
        _uiState.value = _uiState.value.copy(teamList = LocalTeamsDataProvider.getTeamsData() )
    }

    fun selectTeam(team: PremierLeagueTeam) {
        _uiState.value = _uiState.value.copy(selectedTeam = team)
    }
}

data class PremierLeagueUiState(
    val teamList: List<PremierLeagueTeam> = emptyList(),
    val selectedTeam: PremierLeagueTeam? = null
)