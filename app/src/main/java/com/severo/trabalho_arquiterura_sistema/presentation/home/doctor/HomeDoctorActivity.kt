package com.severo.trabalho_arquiterura_sistema.presentation.home.doctor

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityHomeDoctorBinding
import com.severo.trabalho_arquiterura_sistema.presentation.home.detail.DetailClientActivity
import com.severo.trabalho_arquiterura_sistema.presentation.home.doctor.adapter.HomeDoctorAdapter
import com.severo.trabalho_arquiterura_sistema.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeDoctorBinding
    private val viewModel: HomeDoctorViewModel by viewModels()

    private val patientAdapter: HomeDoctorAdapter by lazy {
        HomeDoctorAdapter {
            startActivity(Intent(this, DetailClientActivity::class.java))
        }
    }

    private val resultAdapter: HomeDoctorAdapter by lazy {
        HomeDoctorAdapter {
            startActivity(Intent(this, DetailClientActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEventsAdapter()
        observer()
    }

    private fun initEventsAdapter() {
        postponeEnterTransition()
        with(binding.recyclerPatient) {
            setHasFixedSize(true)
            adapter = patientAdapter
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
        with(binding.recyclerResult) {
            setHasFixedSize(true)
            adapter = resultAdapter
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
    }

    private fun observer() {
        viewModel.allPatient.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {}
                is UiState.Failure -> {}
                is UiState.Success -> {
                    patientAdapter.submitList(state.data)
                }
            }
        }

        viewModel.allClientResult.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {}
                is UiState.Failure -> {}
                is UiState.Success -> {
                    resultAdapter.submitList(state.data)
                }
            }
        }
    }
}