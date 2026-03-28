package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FootballListScreen(
                        onBack = { finish() },
                        onClubClick = { club ->
                            val intent = Intent(this, DetailActivity::class.java).apply {
                                putExtra("name", club.name)
                                putExtra("city", club.city)
                                putExtra("stadium", club.stadium)
                                putExtra("founded", club.founded)
                                putExtra("championships", club.championships)
                                putExtra("description", club.description)
                            }
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun FootballListScreen(
    onBack: () -> Unit,
    onClubClick: (FootballClub) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onBack) {
            Text("Tilbage")
        }

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(FootballRepository.clubs) { club ->
                Card(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .clickable { onClubClick(club) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(club.name)
                        Text("By: ${club.city}")
                        Text("Stadion: ${club.stadium}")
                    }
                }
            }
        }
    }
}
