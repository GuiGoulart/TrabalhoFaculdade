package com.severo.trabalho_arquiterura_sistema.presentation.home.receptionist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityHomeReceptionistBinding
import com.severo.trabalho_arquiterura_sistema.presentation.home.detail.DetailClientActivity
import com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.adapter.HomeReceptionistAdapter
import com.severo.trabalho_arquiterura_sistema.presentation.home.registerclient.RegisterClientActivity
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeReceptionistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeReceptionistBinding

    private val viewModel: HomeReceptionistViewModel by viewModels()

    private val clientAdapter: HomeReceptionistAdapter by lazy {
        HomeReceptionistAdapter {
            startActivity(Intent(this, DetailClientActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeReceptionistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        listener()
        initEventsAdapter()
        observer()
    }

    private fun initEventsAdapter() {
        postponeEnterTransition()
        with(binding.recyclerClient) {
            setHasFixedSize(true)
            adapter = clientAdapter
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
    }

    private fun observer() {
        viewModel.allClientResult.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {}
                is UiState.Failure -> {}
                is UiState.Success -> {
                    clientAdapter.submitList(state.data)
                }
            }
        }
    }

    private fun listener() {
        binding.buttonRegisterClient.setOnClickListener {
            startActivity(Intent(this, RegisterClientActivity::class.java))
        }
    }
}