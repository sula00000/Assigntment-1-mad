package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""
        val city = intent.getStringExtra("city") ?: ""
        val stadium = intent.getStringExtra("stadium") ?: ""
        val founded = intent.getIntExtra("founded", 0)
        val championships = intent.getIntExtra("championships", 0)
        val description = intent.getStringExtra("description") ?: ""
        val imageResId = intent.getIntExtra("imageResId", 0)

        setContent {
            FootballDetailScreen(
                name = name,
                city = city,
                stadium = stadium,
                founded = founded,
                championships = championships,
                description = description,
                imageResId = imageResId
            )
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
    imageResId: Int
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                (context as? ComponentActivity)?.finish()
            },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Tilbage")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "By: $city", fontSize = 18.sp)
                Text(text = "Stadion: $stadium", fontSize = 18.sp)
                Text(text = "Stiftet: $founded", fontSize = 18.sp)
                Text(text = "Mesterskaber: $championships", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Beskrivelse:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = description,
                    fontSize = 18.sp
                )
            }
        }
    }
}
