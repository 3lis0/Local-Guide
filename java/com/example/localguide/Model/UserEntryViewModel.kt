package com.example.localguide.Model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.localguide.Data.DataRepository
import com.example.localguide.Data.Users

class UserEntryViewModel(private val dataRepository: DataRepository) : ViewModel(){
    /**
     * Holds current item ui state
     */
    var userUiState by mutableStateOf(UserUiState())
        private set

    /**
     * Updates the [userUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(
                userDetails = userDetails,
                isEntryValid = validateInput(userDetails)
            )
    }

    /**
     * Inserts an [User] in the Room database
     */
    suspend fun saveItem() {
        if (validateInput()) {
            dataRepository.insertUser(userUiState.userDetails.toUser())
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            email.isNotBlank()
            && password.isNotBlank()
            && name.isNotBlank()
            && language.isNotBlank()
            && age.isNotBlank()
            && gender.isNotBlank()
            && country.isNotBlank()
            && bio.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an User.
 */
data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val id: Int = 0,
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val language: String = "",
    val age: String = "",
    val gender: String = "",
    val country: String = "",
    val bio: String = "",
)

/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun UserDetails.toUser(): Users = Users(
    id = id,
    email = email,
    password = password,
    name = name,
    language = language,
    age = age,
    gender = gender,
    country = country,
    bio = bio
)
/*
fun Users.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}*/

/**
 * Extension function to convert [User] to [UserUiState]
 */
fun Users.toItemUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails =  this.toUserDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [User] to [UserDetails]
 */
fun Users.toUserDetails(): UserDetails = UserDetails(
    id = id,
    email = email,
    password = password,
    name = name,
    language = language,
    age = age,
    gender = gender,
    country = country,
    bio = bio
)