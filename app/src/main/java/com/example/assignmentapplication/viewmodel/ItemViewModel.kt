package com.example.assignmentapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapplication.network.ApiService
import com.example.assignmentapplication.model.UserItem
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val userItemList = MutableLiveData<List<UserItem>>()
    var userItems: LiveData<List<UserItem>> = userItemList

    private val isLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = isLoading

    private val errorMessage = MutableLiveData<String?>()
    val error: LiveData<String?> = errorMessage

    fun fetchItems(apiService: ApiService) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                userItemList.value = apiService.getUserItems()
            } catch (e: Exception) {
                errorMessage.value = "Failed to load data: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}