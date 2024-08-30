package com.example.assignmentapplication.network

import com.example.assignmentapplication.model.UserItem
import retrofit2.http.GET

interface ApiService {
    @GET("/todos")
    suspend fun getUserItems() : List<UserItem>
}