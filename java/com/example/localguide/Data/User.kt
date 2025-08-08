package com.example.localguide.Data

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "language") val language: String,
    @ColumnInfo(name = "age") val age: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "bio") val bio: String,
)

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: Users)

    @Update
    suspend fun update(user: Users)

    @Query("SELECT * from users_table WHERE id = :id")
    fun getUsersById(id: Int): Flow<Users>

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): Flow<List<Users>>

    @Query("SELECT * FROM users_table WHERE name = :name")
    fun getAllUsersWithName(name: String): Array<Users>
}



