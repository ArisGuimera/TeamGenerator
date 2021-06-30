package com.teammaker.teamgenerator.ui.userlist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.teammaker.teamgenerator.core.ex.afterTextChanged
import com.teammaker.teamgenerator.core.ex.hideKeyboard
import com.teammaker.teamgenerator.databinding.ActivityMainBinding
import com.teammaker.teamgenerator.domain.model.UserModel
import com.teammaker.teamgenerator.ui.result.ResultActivity
import com.teammaker.teamgenerator.ui.userlist.adapter.UsersAdapter

class UserListActivity : AppCompatActivity() {

    companion object {
        private const val RESULT_CODE = 111
    }

    private lateinit var binding: ActivityMainBinding
    private val userListViewModel: UserListViewModel by viewModels()

    private var adapter: UsersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userListViewModel.onCreate()
        initUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RESULT_CODE && resultCode == RESULT_OK) {
            userListViewModel.clearUsers()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun initUI() {
        initSubscription()
        initToolbar()
        initRecyclerView()
        initListeners()
    }

    private fun initSubscription() {
        userListViewModel.usersLiveData.observe(this, {
            binding.btnGenerateTeam.isEnabled = it.isNotEmpty()
            adapter.userList = it
            adapter.notifyDataSetChanged()
        })
        userListViewModel.eventLiveData.observe(this, {
            if (it.isNotEmpty()) {
                startActivityForResult(ResultActivity.create(this, ArrayList(it)), RESULT_CODE)
            }
        })
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        binding.rvUsers.setHasFixedSize(true)
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter
    }

    private fun initListeners() {
        binding.btnAddUser.setOnClickListener {
            userListViewModel.onUserAdded(binding.etAddUser.text.toString())
            binding.etAddUser.text.clear()
            hideKeyboard()
        }
        binding.etAddUser.afterTextChanged {
            binding.btnAddUser.isEnabled = it.isNotEmpty()
        }
        binding.btnGenerateTeam.setOnClickListener { userListViewModel.onGenerateTeamCliked() }
    }

}