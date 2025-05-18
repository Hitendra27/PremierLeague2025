package com.example.premierleague.screens

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.premierleague.R


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
                    when (currentDestination?.destination?.route) {
                        Screen.List.route -> {
                            ImageTopAppBar()
                        }

                        Screen.Detail.route -> {
                            Text("Show Details")
                        }

                        else -> "TV Show App"
                    }
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
                    onTeamSelected = { selectedTeam ->
                        viewModel.selectTeam(selectedTeam)
                        navController.navigate(Screen.Detail.route)
                    }
                )
            }
            composable(Screen.Detail.route) {
                PremierLeagueDetailScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun ImageTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.priemer_league_apptopbar),
            contentDescription = "Premier League Banner",
            contentScale = ContentScale.Fit, // Crop or FillBounds depending on image shape
            modifier = Modifier
                .size(64.dp)
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ImageTopAppBarPreview() {
    MaterialTheme {
        Box {
            ImageTopAppBar()
        }
    }
}

