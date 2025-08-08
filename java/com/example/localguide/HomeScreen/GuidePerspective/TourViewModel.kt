package com.example.localguide.HomeScreen.GuidePerspective

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TourViewModel : ViewModel() {
    var tourName by mutableStateOf("")
    var tourDescription by mutableStateOf("")
    var tourPrice by mutableStateOf("")
    var tourDate by mutableStateOf("")
    var tourLocation by mutableStateOf("")
    var tourCountry by mutableStateOf("")
    var tourGuideName by mutableStateOf("")
    var selectedImageUri by mutableStateOf<Uri?>(null)
    var guideToursList = mutableStateListOf<GuideTourData>()
    // Function to add a new TourData object to the list
    fun addTour(tourData: GuideTourData) {
        guideToursList.add(tourData)
    }
    fun removeTour(index: Int) {
        if (index in 0 until guideToursList.size) {
            guideToursList.removeAt(index)
        }
    }
}

