package com.example.localguide.Data

import kotlinx.coroutines.flow.Flow

class OfflineDataRepository(private val userDao: UserDao) : DataRepository {
    override fun getAllUsersStream(): Flow<List<Users>> = userDao.getAllUsers()

    override fun getUserStream(id: Int): Flow<Users?> = userDao.getUsersById(id)

    override suspend fun insertUser(item: Users) = userDao.insert(item)


    override suspend fun updateUser(item: Users) = userDao.update(item)
}