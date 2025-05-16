package com.example.premierleague.screens

import androidx.lifecycle.ViewModel
import com.example.premierleague.data.LocalTeamsDataProvider
import com.example.premierleague.model.PremierLeagueTeam
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PremierLeagueViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(
        PremierLeagueUiState(
        leagueList = LocalTeamsDataProvider.getTeamsData(),
        currentTeam = LocalTeamsDataProvider.getTeamsData().getOrElse(0) {
            LocalTeamsDataProvider.defaultTeam
        }
        )
    )

    val uiState: StateFlow<PremierLeagueUiState> = _uiState

    fun updateCurrentTeam(selectedTeam: PremierLeagueTeam) {
        _uiState.update {
            it.copy(currentTeam = selectedTeam)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

data class PremierLeagueUiState(
    val leagueList: List<PremierLeagueTeam> = emptyList(),
    val currentTeam: PremierLeagueTeam = LocalTeamsDataProvider.defaultTeam,
    val isShowingListPage: Boolean = true
)