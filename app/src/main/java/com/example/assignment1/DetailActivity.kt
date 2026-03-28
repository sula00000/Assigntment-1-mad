package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""
        val city = intent.getStringExtra("city") ?: ""
        val stadium = intent.getStringExtra("stadium") ?: ""
        val founded = intent.getIntExtra("founded", 0)
        val championships = intent.getIntExtra("championships", 0)
        val description = intent.getStringExtra("description") ?: ""

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FootballDetailScreen(
                        name = name,
                        city = city,
                        stadium = stadium,
                        founded = founded,
                        championships = championships,
                        description = description,
                        onBack = { finish() }
                    )
                }
            }
        }
    }
}

@Composable
fun FootballDetailScreen(
    name: String,
    city: String,
    stadium: String,
    founded: Int,
    championships: Int,
    description: String,
    onBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onBack) {
            Text("Tilbage")
        }

        Text("Klub: $name", modifier = Modifier.padding(top = 16.dp))
        Text("By: $city")
        Text("Stadion: $stadium")
        Text("Stiftet: $founded")
        Text("Mesterskaber: $championships")
        Text("Beskrivelse: $description", modifier = Modifier.padding(top = 8.dp))
    }
}
