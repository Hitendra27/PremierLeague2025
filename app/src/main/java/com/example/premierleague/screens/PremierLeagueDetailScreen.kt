package com.example.premierleague.screens

import android.net.ipsec.ike.SaProposal
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.premierleague.R
import com.example.premierleague.model.PremierLeagueTeam
import kotlinx.coroutines.selects.select


@Composable
fun PremierLeagueDetailScreen(
    viewModel: PremierLeagueViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    val selectedTeam = uiState.selectedTeam

    val scrollState = rememberScrollState()

    if (selectedTeam == null) {
        Text(
            text = "No team selected",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        return
    }

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        Box {
            Image(
                painter = painterResource(selectedTeam.teamImageBanner),
                contentDescription = null,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
                   // .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f))
                    .padding(bottom = 28.dp, end = 10.dp)
            ) {
                Text(
                    text = stringResource(selectedTeam.teamTitle),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(selectedTeam.teamStadium),
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
        Text(
            text = stringResource(selectedTeam.teamDetails),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PremierLeagueDetailScreenPreview() {
    // Fake team data with resource placeholders (replace with actual IDs if needed)
    val fakeTeam = PremierLeagueTeam(
        id = 1,
        teamTitle = R.string.arsenal,
        teamStadium = R.string.arsenal_stadium,
        teamImageBanner = R.drawable.arsenal_banner,
        teamDetails = R.string.arsenal_details,
        teamEstablished = R.string.arsenal_established,
        imageResourceId = R.drawable.arsenal_logo

    )

    val previewViewModel = object : PremierLeagueViewModel() {
        init {
            _uiState.value = PremierLeagueUiState(
                selectedTeam = fakeTeam
            )
        }
    }

    PremierLeagueDetailScreen(viewModel = previewViewModel)
}
