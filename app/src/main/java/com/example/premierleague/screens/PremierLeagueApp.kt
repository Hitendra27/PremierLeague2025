package com.example.premierleague.screens

import android.R.attr.text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class Screen(val route: String, val label: String) {
    object Home : Screen("home", "Home")
    object List : Screen("list", "Teams")
    object Detail : Screen("details", "Details")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PremierLeagueApp() {
    val viewModel: PremierLeagueViewModel = viewModel()

    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                    text = when (currentDestination?.destination?.route) {
                        Screen.Home.route -> "Welcome"
                        Screen.List.route -> "Premier League"
                        Screen.Detail.route -> "Show Details"
                        else -> "TV Show App"
                     }
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                listOf(Screen.Home, Screen.List).forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination?.destination?.route == screen.route,
                        onClick = { navController.navigate(screen.route) },
                        icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.List.route) {
                PremierLeagueListScreen(
                    viewModel = viewModel,
                    onTeamSelected = {
                        viewModel.updateCurrentTeam(it)
                        navController.navigate(Screen.Detail.route)
                    }
                ) { }
            }
            composable(Screen.Detail.route) {
                PremierLeagueDetailScreen(
                    selectedTeam =
                )
            }
        }
    }




}