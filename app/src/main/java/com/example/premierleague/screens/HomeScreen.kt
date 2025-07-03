package com.example.premierleague.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.premierleague.R
import com.example.premierleague.ui.theme.PremierLeagueTheme

@Composable
fun HomeScreen(
    onEnterClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Welcome to Premier League App",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFF66C4FF),
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = { onEnterClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC067)
            )
        ) {
            Text(
                text = "Enter",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PremierLeagueTheme {
        HomeScreen(
            onEnterClick = {}
        )
    }
}