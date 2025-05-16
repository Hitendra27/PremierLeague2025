package com.example.premierleague.screens

import android.net.ipsec.ike.SaProposal
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocalConsumer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.premierleague.model.PremierLeagueTeam
import kotlinx.coroutines.selects.select


@Composable
fun PremierLeagueDetailScreen(
    selectedTeam: PremierLeagueTeam
) {

    val viewModel: PremierLeagueViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current

    Box(
        modifier = Modifier
            .padding(8.dp)
    ){
        Box{
            Box {
                Image(
                    painter = painterResource(selectedTeam.teamImageBanner),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
            Column(
                Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(selectedTeam.teamTitle),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(4.dp)
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = stringResource(selectedTeam.teamStadium),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Text(
            text = stringResource(selectedTeam.teamDetails),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}