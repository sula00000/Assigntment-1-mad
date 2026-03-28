package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballListScreen()
        }
    }
}

@Composable
fun FootballListScreen() {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {

        Button(
            onClick = {
                (context as? ComponentActivity)?.finish()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text("Tilbage")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            items(FootballRepository.clubs) { club ->
                FootballClubItem(club) {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("name", club.name)
                        putExtra("city", club.city)
                        putExtra("stadium", club.stadium)
                        putExtra("founded", club.founded)
                        putExtra("championships", club.championships)
                        putExtra("description", club.description)
                        putExtra("imageResId", club.imageResId)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun FootballClubItem(club: FootballClub, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1B5E20))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = club.imageResId),
                contentDescription = club.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(90.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = club.name,
                    color = Color.White,
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "By: ${club.city}",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = "Stadion: ${club.stadium}",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    FootballListScreen()
}
