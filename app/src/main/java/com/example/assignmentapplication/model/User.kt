package com.example.assignmentapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId") var userId:Int,
    @ColumnInfo(name = "id") var id:Int,
    @ColumnInfo(name = "title") var title:String,
    @ColumnInfo(name = "completed") var completed: Boolean
)