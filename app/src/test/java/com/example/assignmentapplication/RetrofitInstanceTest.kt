package com.example.assignmentapplication

import com.example.assignmentapplication.network.RetrofitInstance
import org.junit.Assert.assertNotNull
import org.junit.Test

class RetrofitInstanceTest {
    @Test
    fun test_ApiService_Creation() {
        val apiService = RetrofitInstance.api
        assertNotNull(apiService)
    }
}