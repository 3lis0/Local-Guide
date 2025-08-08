package com.example.localguide.Data

import kotlinx.coroutines.flow.Flow

interface DataRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllUsersStream(): Flow<List<Users>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getUserStream(id: Int): Flow<Users?>

    /**
     * Insert item in the data source
     */
    suspend fun insertUser(user: Users)


    /**
     * Update item in the data source
     */
    suspend fun updateUser(user: Users)
}