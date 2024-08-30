package com.example.assignmentapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.assignmentapplication.viewmodel.ItemViewModel
import com.example.assignmentapplication.network.RetrofitInstance
import com.example.assignmentapplication.database.AppDatabase
import com.example.assignmentapplication.model.User
import com.example.assignmentapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "ASSINGMENT_APP"
    lateinit var viewModel: ItemViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize viewModel and bind to layout
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.viewModel = viewModel

        setupRecyclerView()


        observeViewModel()

        //Initialize room database
        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "sample-database")
                .build()
        //Load and Log existing data in  user database
        loadDataFromDatabase()

        //fetch Items from API
        viewModel.fetchItems(RetrofitInstance.api)
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(emptyList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        //Update recycler view and insert to database on data changes
        viewModel.userItems.observe(this) { items ->
            adapter.items = items
            adapter.notifyDataSetChanged()
            Log.d(TAG, "data size = ${items.size}")

            GlobalScope.launch(Dispatchers.IO) {
                // Insert each item into the database
                items.forEach { user ->
                    val user = User(
                        userId = user.userId,
                        id = user.id,
                        title = user.title,
                        completed = user.completed
                    )
                    database.userDao().insert(user)
                }
            }
        }

        //Show loading progressBar based on progress state
        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        //Display error message if any while fetching data
        viewModel.error.observe(this) { error ->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadDataFromDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            // Fetch all users from the database
            val users = database.userDao().getAllUsers()

            Log.d(TAG, "total user count : ${users.size}")
            // Log the fetched users
            users.forEach { user ->
                Log.d(TAG, "User: ${user}")
            }

        }
    }
}

