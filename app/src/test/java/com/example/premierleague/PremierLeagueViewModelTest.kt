package com.example.premierleague

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.premierleague.data.LocalTeamsDataProvider
import com.example.premierleague.screens.PremierLeagueViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class PremierLeagueViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state contains team list`() = runTest {
        // Arrange
        val viewModel = PremierLeagueViewModel()

        // Act
        advanceUntilIdle()
        val uiState = viewModel.uiState.value

        // Assert
        assertTrue(uiState.teamList.isNotEmpty())
        assertNull(uiState.selectedTeam)
    }

    @Test
    fun `selectTeam updates selectedTeam in uiState`() = runTest {
        // Arrange
        val viewModel = PremierLeagueViewModel()
        advanceUntilIdle()
        val teamToSelect = LocalTeamsDataProvider.getTeamsData().first()

        // Act
        viewModel.selectTeam(teamToSelect)
        val uiState = viewModel.uiState.value

        // Assert
        assertEquals(teamToSelect, uiState.selectedTeam)
    }
}