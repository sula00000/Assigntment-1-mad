package com.example.assignment1

object FootballRepository {
    val clubs = listOf(
        FootballClub(
            name = "FC København",
            city = "København",
            stadium = "Parken",
            founded = 1992,
            championships = 15,
            description = "FC København er en af de største klubber i dansk fodbold og har vundet mange mesterskaber.",
            imageResId = R.drawable.fck
        ),
        FootballClub(
            name = "Brøndby IF",
            city = "Brøndby",
            stadium = "Brøndby Stadion",
            founded = 1964,
            championships = 11,
            description = "Brøndby IF er en traditionsrig dansk klub med mange loyale fans og stor historie i dansk fodbold.",
            imageResId = R.drawable.brondby
        ),
        FootballClub(
            name = "AGF",
            city = "Aarhus",
            stadium = "Ceres Park",
            founded = 1880,
            championships = 5,
            description = "AGF er en af Danmarks ældste klubber og har en vigtig plads i dansk fodboldhistorie.",
            imageResId = R.drawable.agf
        )
    )
}
