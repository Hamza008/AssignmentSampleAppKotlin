package com.example.assignmentapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.assignmentapplication.network.RetrofitInstance
import com.example.assignmentapplication.viewmodel.ItemViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ItemViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    val dispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val courutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: ItemViewModel

    @Mock
    private lateinit var observerLoading: Observer<Boolean>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(dispatcher)

        // Initialize ViewModel
        viewModel = ItemViewModel()

        // Set observers on the LiveData
        viewModel.loading.observeForever(observerLoading)
    }

    @Test
    fun fetchItems_should_update_items_on_loading() = runTest() {

        val apiService = RetrofitInstance.api
        // `when`(apiService.getItems()).thenReturn(mockItems)

        viewModel.fetchItems(apiService)

        // Then
        verify(observerLoading).onChanged(true)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.loading.removeObserver(observerLoading)
    }
}