package com.example.premierleague.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.premierleague.R
import com.example.premierleague.model.PremierLeagueTeam
import com.example.premierleague.ui.theme.PremierLeagueTheme

@Composable
fun PremierLeagueListScreen(
    viewModel: PremierLeagueViewModel,
    onTeamSelected: (PremierLeagueTeam) -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(state.teamList) {  team ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable{
                    onTeamSelected(team)
                },
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF7D99AA) // 🎨 your custom color here
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(128.dp)
            ) {
                Image(
                    painter = painterResource(team.imageResourceId),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(128.dp)
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color.White)
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(team.teamTitle),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFFFC493),
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = stringResource(team.teamStadium),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF262D2F),
                            maxLines = 1
                        )
                        Spacer(Modifier.padding(10.dp))
                        Text(
                            text = stringResource(team.teamEstablished),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF66F4FF)
                        )
                }
            }
        }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PremierLeagueListScreenPreview() {

    // Mock taam data (replace with actual resource IDs if available)
    val mockTeams = listOf(
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
            teamTitle = R.string.man_city,
            teamStadium = R.string.man_city_stadium,
            teamEstablished = R.string.man_city_established,
            teamDetails = R.string.man_city_details,
            imageResourceId = R.drawable.mancity_logo,
            teamImageBanner = R.drawable.man_city_banner
        )
    )

    // Mock viewModel implementation
    val previewViewModel = object : PremierLeagueViewModel() {
        init {
            _uiState.value = PremierLeagueUiState(teamList = mockTeams)
        }
    }


    PremierLeagueListScreen(
        viewModel = previewViewModel,
        onTeamSelected = {}

    )
}





