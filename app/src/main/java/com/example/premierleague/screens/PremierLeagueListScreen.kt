package com.example.premierleague.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.premierleague.ui.theme.PremierLeagueTheme

@Composable
fun PremierLeagueListScreen(
    viewModel: PremierLeagueViewModel,
    onTeamSelected: () -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(state.leagueList) {  team ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable{},
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(team.teamTitle),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = stringResource(team.teamStadium),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        }
    }
}

//@Preview
//@Composable
//fun PremierLeagueListScreenPreview() {
//    PremierLeagueTheme {
//        PremierLeagueListScreen(
//            viewModel = PremierLeagueViewModel(),
//            onTeamSelected = {}
//        )
//    }
//}

