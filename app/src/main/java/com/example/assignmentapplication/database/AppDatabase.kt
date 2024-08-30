package com.example.assignmentapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assignmentapplication.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}