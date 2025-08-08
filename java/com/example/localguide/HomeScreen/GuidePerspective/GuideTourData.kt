package com.example.localguide.HomeScreen.GuidePerspective

import android.net.Uri

data class GuideTourData(
    val tourName: String,
    val tourDescription: String,
    val tourPrice: String,
    val tourDate: String,
    val tourLocation: String,
    val tourCountry: String,
    val tourGuideName: String,
    val selectedImageUri: Uri? // Assuming you want to include the image URI
)
