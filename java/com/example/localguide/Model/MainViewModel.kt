package com.example.localguide.Model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localguide.Data.countries
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    //first state whether the search is happening or not
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    fun setIsSearching(active: Boolean) {
        _isSearching.value = active
    }
    fun getIsSearching(): Boolean {
        return _isSearching.value
    }

    //second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    fun setSearchText(newText: String) {
        _searchText.value = newText
        _searchTextOut.value = newText
    }
    fun getSearchText(): String {
        return _searchText.value
    }

    private val _searchTextOut = MutableStateFlow("Find Your destination..")
    val searchTextOut = _searchTextOut.asStateFlow()


    fun onSearchTextChange(text: String) {
        _searchText.value = text
        _searchTextOut.value = text
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }


    //third state the list to be filtered
    private val _countriesList = MutableStateFlow(countries)
    val countriesList = searchText
        .combine(_countriesList) { text, countries ->//combine searchText with _contriesList
            if (text.isBlank()) { //return the entery list of countries if not is typed
                countries
            }
            countries.filter { country ->// filter and return a list of countries based on the text the user typed
                country.uppercase().contains(text.trim().uppercase())
            }
        }.stateIn(//basically convert the Flow returned from combine operator to StateFlow
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),//it will allow the StateFlow survive 5 seconds before it been canceled
            initialValue = _countriesList.value
        )




    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Log.d(ERROR_TAG, throwable.message.orEmpty())
            },
            block = block
        )

    companion object {
        const val ERROR_TAG = "APP ERROR"
    }
}


