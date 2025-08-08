package com.example.localguide.Model

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonObject


data class RecommendationResponse(val recommendations: List<Int>)


@Composable
fun GetDataScreen() {
    var data by remember { mutableStateOf<List<Int>?>(null) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val url = "http://10.0.2.2:5000/recommendations?user_id=99654&country=egypt"//  Flask app's URL
        val requestQueue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
           Request.Method.GET, url,
            { response ->
                val dataObject = Gson().fromJson(response, JsonObject::class.java)
                data = dataObject.getAsJsonArray("recommendations").map { it.asInt }.toList()
            },
            { error ->
                Log.e("GetDataScreen", "Error fetching data: $error")
            }
        )
        requestQueue.add(stringRequest)
    }

    if (data != null) {
        val recommendations = data as? List<Int>  // Safe cast with null check
        if (recommendations != null) {
            Column {
                Text(text = "Recommendations:")
                recommendations.forEach { recommendation ->
                    Text(text = recommendation.toString())
                }
            }
        } else {
            // Handle case where data is not a List<Int> (e.g., show error message)
        }
    } else {
        Text(text = "Loading...")
    }
}

