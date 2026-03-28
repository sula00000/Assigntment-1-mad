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
            CharacterListScreen()
        }
    }
}

@Composable
fun CharacterListScreen() {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.kame),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Button(
            onClick = {
                (context as? ComponentActivity)?.finish()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text("Back", color = Color.White)
        }

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            items(FootballRepository.clubs) { character ->
                CharacterItem(character) {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("characterName", character.name)
                        putExtra("characterAge", character.age)
                        putExtra("characterRace", character.race)
                        putExtra("characterGender", character.gender)
                        putExtra("characterRole", character.role)
                        putExtra("characterAttack", character.attack)
                        putExtra("characterRating", character.rating)
                        putExtra("characterContext", character.context)
                        putExtra("characterImageResId", character.imageResId)
                        putExtra("characterBackgroundResId", character.characterBackgroundResId)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: FootballClub, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2359b7))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = character.imageResId),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)

            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = character.name,
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Age: ${character.age}",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Race: ${character.race}",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    CharacterListScreen()
}