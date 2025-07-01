package com.example.premierleague.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Info



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
            CenterAlignedTopAppBar(
                title = {
                    when (currentDestination?.destination?.route) {
                        Screen.List.route -> {
                            ImageTopAppBar()
                        }

                        Screen.Detail.route -> {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        Icons.Default.ArrowBack,
                                        contentDescription = "Back",
                                        tint = MaterialTheme.colorScheme.primary)
                                }
                                Text(
                                    "Show Details",
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                    )
                            }
                        }


                        else -> "TV Show App"
                    }
                }

            )
        },
        bottomBar = {
            val route = currentDestination?.destination?.route

            val showBottomBar = route == Screen.List.route || route == Screen.Detail.route

            if (showBottomBar) {
                NavigationBar {
                    listOf(Screen.List, Screen.Detail).forEach { screen ->
                        val icon = when (screen) {
                            is Screen.List -> Icons.Default.List
                            is Screen.Detail -> Icons.Default.Info
                            else -> Icons.Default.Info
                        }

                        NavigationBarItem(
                            selected = route == screen.route,
                            onClick = {
                                if (route != screen.route) {
                                    navController.navigate(screen.route) {
                                        popUpTo(Screen.List.route) { inclusive = false }
                                        launchSingleTop = true
                                    }
                                }
                            },
                            icon = { Icon(icon, contentDescription = screen.label) },
                            label = { Text(screen.label) }
                        )
                    }
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
                HomeScreen(
                    onEnterClick = {
                        navController.navigate(Screen.List.route)
                    }
                )
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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.premier_league_app),
            contentDescription = "Top App Bar Image",
            modifier = Modifier
                .height(120.dp)
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

