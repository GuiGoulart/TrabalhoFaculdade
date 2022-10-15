package com.severo.trabalho_arquiterura_sistema.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.severo.trabalho_arquiterura_sistema.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeReceptionistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_receptionist)
    }
}