package com.example.democodedagger.userslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.democodedagger.MyApplication
import com.example.democodedagger.R
import com.example.democodedagger.adapter.UsersListAdapter
import com.example.democodedagger.databinding.ActivityUsersListBinding
import com.example.democodedagger.viewmodels.UsersListViewModel
import com.example.democodedagger.viewmodels.UsersListViewModelFactory
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    private val TAG = "UsersListActivity"
    private lateinit var binding: ActivityUsersListBinding
    lateinit var usersListViewModel: UsersListViewModel
    private val adapter = UsersListAdapter()

    @Inject
    lateinit var usersListViewModelFactory: UsersListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).appComponent.inject(this)

        usersListViewModel =
            ViewModelProvider(this, usersListViewModelFactory).get(UsersListViewModel::class.java)

        binding.recyclerview.adapter = adapter

        usersListViewModel.usersList.observe(this) {
            adapter.setUsersListDataItems(it)
        }

        usersListViewModel.getUsersListData()
    }
}