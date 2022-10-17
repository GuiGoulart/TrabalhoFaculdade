package com.severo.trabalho_arquiterura_sistema.presentation.home.receptionist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.databinding.ActivityHomeReceptionistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeReceptionistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeReceptionistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeReceptionistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}