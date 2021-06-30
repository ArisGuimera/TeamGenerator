package com.teammaker.teamgenerator.ui.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.teammaker.teamgenerator.databinding.ActivityResultBinding
import com.teammaker.teamgenerator.domain.model.MatchTeam
import com.teammaker.teamgenerator.domain.model.UserModel
import com.teammaker.teamgenerator.ui.result.adapter.MatchResultAdapter

class ResultActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_LIST = "extra_list"
        fun create(context: Context, users: ArrayList<UserModel>): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putParcelableArrayListExtra(EXTRA_LIST, users)
            }
        }
    }

    private lateinit var binding: ActivityResultBinding
    private val resultViewModel: ResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultViewModel.onCreate((intent.getParcelableArrayListExtra(EXTRA_LIST) ?: arrayListOf()))
        initUI()
    }

    override fun onSupportNavigateUp(): Boolean {
        setResult(RESULT_CANCELED)
        finish()
        return true
    }

    private fun initUI() {
        initObservables()
        initListeners()
        initToolbar()
    }

    private fun initListeners() {
        binding.btnReset.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initObservables() {
        resultViewModel.matchTeamLiveData.observe(this, {
            if(it.isNotEmpty()){
                initRecyclerView(it)
            }else{
                //mostrar un error
            }
        })
    }

    private fun initRecyclerView(result:List<Pair<MatchTeam, MatchTeam>>) {
        binding.rvResult.setHasFixedSize(true)
        binding.rvResult.layoutManager = LinearLayoutManager(this)
        binding.rvResult.adapter = MatchResultAdapter(result)
    }
}