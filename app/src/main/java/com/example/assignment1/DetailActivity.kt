package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val characterName = intent.getStringExtra("characterName")
        val characterAge = intent.getIntExtra("characterAge", 0)
        val characterRace = intent.getStringExtra("characterRace")
        val characterGender = intent.getStringExtra("characterGender")
        val characterRole = intent.getStringExtra("characterRole")
        val characterAttack = intent.getStringExtra("characterAttack")
        val characterRating = intent.getIntExtra("characterRating", 0)
        val characterContext = intent.getStringExtra("characterContext")
        val characterBackgroundResId = intent.getIntExtra("characterBackgroundResId", 0)

        setContent {
            DetailsView(
                characterName = characterName,
                characterAge = characterAge,
                characterRace = characterRace,
                characterGender = characterGender,
                characterRole = characterRole,
                characterAttack = characterAttack,
                characterRating = characterRating,
                characterContext = characterContext,
                characterBackgroundResId = characterBackgroundResId
            )
        }
    }
}

@Composable
fun DetailsView(
    characterName: String?,
    characterAge: Int,
    characterRace: String?,
    characterGender: String?,
    characterRole: String?,
    characterAttack: String?,
    characterRating: Int,
    characterContext: String?,
    characterBackgroundResId: Int
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = characterBackgroundResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(16.dp)
            ) {
                Column {
                    characterName?.let {
                        Text(text = "Name: $it", fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Text(text = "Age: $characterAge", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    characterRace?.let {
                        Text(text = "Race: $it", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    characterGender?.let {
                        Text(text = "Gender: $it", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    characterRole?.let {
                        Text(text = "Role: $it", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    characterAttack?.let {
                        Text(text = "Attack: $it", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Text(text = "Rating: $characterRating", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    characterContext?.let {
                        Text(text = "Context: $it", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                (context as? ComponentActivity)?.finish()
            }) {
                Text("Back")
            }
        }
    }
}