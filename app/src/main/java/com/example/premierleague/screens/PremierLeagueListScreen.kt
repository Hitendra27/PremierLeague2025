package com.example.premierleague.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.premierleague.ui.theme.PremierLeagueTheme

@Composable
fun PremierLeagueListScreen() {

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable{},
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = "Arsenal",
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "Emirates",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview
@Composable
fun PremierLeagueListScreenPreview() {
    PremierLeagueTheme {
        PremierLeagueListScreen()
    }
}


//@Composable
//fun CountryListScreen(
//    viewModel: CountryViewModel, // Assuming CountryViewModel is correctly defined
//    onCountrySelected: () -> Unit
//) {
//    // Collecting the UI state from the ViewModel's uiState Flow
//    val state by viewModel.uiState.collectAsState()
//
//    LazyColumn(modifier = Modifier.padding(16.dp)) {
//        // Using items from androidx.compose.foundation.lazy
//        items(state.countryList) { country ->
//            // Using Material 3 Card
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//                    .clickable {
//                        // Action when the card is clicked
//                        viewModel.selectedCountry(country) // Call ViewModel to set selected country
//                        onCountrySelected() // Call the provided callback
//                    },
//                // Using CardDefaults.cardElevation() from Material 3
//                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Specify a default elevation value
//            ) {
//                // Content within the Card
//                Column(
//                    modifier = Modifier.padding(16.dp)
//                ) {
//                    // Using Material 3 Text and Typography
//                    Text(
//                        text = country.name,
//                        style = MaterialTheme.typography.displayMedium
//                    )
//                    // Using Material 3 Text and Typography
//                    Text(
//                        text = country.continent.name,
//                        style = MaterialTheme.typography.bodySmall
//                    )
//                }
//            }
//
//        }
//    }
//}
