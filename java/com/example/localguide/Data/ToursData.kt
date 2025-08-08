package com.example.localguide.Data

import android.icu.text.SimpleDateFormat
import androidx.compose.runtime.mutableStateListOf
import com.example.localguide.R

data class ToursData(
    val name: String,
    val description: String,
    val price:String,
    val date: String,
    val location: String,
    val country: String,
    val guideName: String,
    val image: Int = R.drawable.default_tour_photo
)

fun formatDateForDisplay(dateString: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd") // Input format (assuming yyyy-MM-dd)
    val date = formatter.parse(dateString) // Parse the String to a Date object
    val monthFormatter = SimpleDateFormat("MMM") // Format for month (MMM for short month name)
    val dayFormatter = SimpleDateFormat("dd") // Format for day
    val month = monthFormatter.format(date) // Get formatted month (e.g., Apr)
    val day = dayFormatter.format(date) // Get formatted day (e.g., 20)
    return "$day $month" // Combine formatted day and month
}

val toursList = mutableStateListOf<ToursData>(
    ToursData(
        name = "Egyptian Pyramids",
        description = "Witness the wonders of the ancient world on this tour of the majestic Egyptian pyramids. Explore the Giza Plateau, learn about pharaohs and their tombs, and experience the rich history of Egypt.",
        price = "$200 - $300",
        date = "2024-10-25",
        country = "Egypt",
        location = "Giza",
        guideName = "Dr. Hassan Kamal",
        image = R.drawable.pyramids_of_giza
    ),
    ToursData(
        name = "Nile River Cruise",
        description = "Sail down the majestic Nile River on a luxurious cruise. Explore ancient temples, experience Egyptian culture, and enjoy stunning scenery.",
        price = "$500+ per person",
        date = "2024-12-20",
        country = "Egypt",
        location = "Aswan",
        guideName = "Omar Hassan",
        image = R.drawable._3
    ),
    ToursData(
        name = "Hot Air Balloon Ride",
        description = "Experience the wonders of Luxor from a unique perspective on a hot air balloon ride. See the Valley of the Kings, Hatshepsut Temple, and the Karnak Temple complex from above.",
        price = "$300 - $400 per person",
        date = "2025-01-15",
        country = "Egypt",
        location = "Luxor",
        guideName = "Ahmed Ibrahim",
        image = R.drawable.hotairballonluxor
    ),
    ToursData(
        name = "White Desert Safari",
        description = "Embark on an unforgettable adventure in the White Desert of Egypt. Explore otherworldly rock formations, camp under the stars, and experience the beauty of the desert.",
        price = "$600 - $800 per person",
        date = "2024-11-01",
        country = "Egypt",
        location = "White Desert",
        guideName = "Khalid Mohammed",
        image = R.drawable.k3a2439
    ),
    ToursData(
        name = "Siwa Oasis Exploration",
        description = "Discover the hidden gem of Siwa Oasis in the Egyptian desert. Explore ancient temples, lush palm groves, and experience the unique culture of the Berbers.",
        price = "$700 - $900 per person",
        date = "2025-03-05",
        country = "Egypt",
        location = "Siwa Oasis",
        guideName = "Fatima Mohamed",
        image = R.drawable.siwa_oasis
    ),
    ToursData(
        name = "Red Sea Diving Adventure",
        description = "Explore the underwater paradise of the Red Sea on this diving adventure. Discover vibrant coral reefs, diverse marine life, and experience the thrill of scuba diving.",
        price = "$800+ per person",
        date = "2024-07-01",
        country = "Egypt",
        location = "Red Sea",
        guideName = "Ahmed Hassan",
        image = R.drawable.red_sea_diving
    ),
    ToursData(
        name = "Egyptian Cooking Class and Food Tour",
        description = "Immerse yourself in Egyptian cuisine on this unique cooking class and food tour. Learn to prepare traditional dishes, explore local markets, and savor delicious Egyptian food.",
        price = "$250 - $300 per person",
        date = "2024-09-20",
        location = "Cairo",
        country = "Egypt",
        guideName = "Laila Ibrahim",
        image = R.drawable.egyptian_food
    ),
    ToursData(
        name = "Great Wall of China Hike",
        description = "Hike a portion of the Great Wall of China and experience this awe-inspiring landmark up close. Learn about its history and enjoy breathtaking views.",
        price = "$300 - $400 per person",
        date = "2025-03-12",
        location = "Beijing",
        country = "China",
        guideName = "Li Wei",
        image = R.drawable.the_great_wall_of_china
    ),
    ToursData(
        name = "Amazon Rainforest Adventure",
        description = "Embark on a thrilling adventure through the Amazon rainforest. Explore diverse wildlife, learn about the ecosystem, and experience the beauty of the jungle.",
        price = "$400 - $500 per person",
        date = "2024-11-15",
        location = "Brazil",
        country = "Brazil",
        guideName = "Ana Silva",
        image = R.drawable.atlantic_forest
    ),
    ToursData(
        name = "Iceland Northern Lights",
        description = "Witness the magical aurora borealis (Northern Lights) on this expedition to Iceland. Explore glaciers, waterfalls, and experience the unique Icelandic landscape.",
        price = "$1500+ per person",
        date = "2025-02-05",
        location = "Iceland",
        country = "Iceland",
        guideName = "Bjorn Olafsson",
        image = R.drawable.northern_lights
    )
)

