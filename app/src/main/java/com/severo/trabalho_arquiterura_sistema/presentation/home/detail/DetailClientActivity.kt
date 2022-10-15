package com.severo.trabalho_arquiterura_sistema.presentation.home.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityDetailClientBinding
import com.severo.trabalho_arquiterura_sistema.presentation.home.detail.adapter.DetailClientAdapter
import com.severo.trabalho_arquiterura_sistema.util.UiState
import com.severo.trabalho_arquiterura_sistema.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailClientBinding
    private val viewModel: DetailClientViewModel by viewModels()

    private val detailAdapter: DetailClientAdapter by lazy {
        DetailClientAdapter { valueClick ->
            if (valueClick) toast("Documento entregue para o paciente") else toast("Documento armazenada na clínica")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observer()
        initEventsAdapter()
    }
    
    private fun init() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initEventsAdapter() {
        postponeEnterTransition()
        with(binding.recyclerHistoric) {
            setHasFixedSize(true)
            adapter = detailAdapter
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
    }

    private fun observer() {
        viewModel.detailClient.observe(this) { state ->
            when (state) {
                is UiState.Loading -> {}
                is UiState.Failure -> {}
                is UiState.Success -> {
                    binding.textName.text = state.data.name
                    binding.textDate.text = state.data.date
                    binding.textHour.text = state.data.hour
                    detailAdapter.submitList(state.data.result)
                }
            }
        }
    }
}