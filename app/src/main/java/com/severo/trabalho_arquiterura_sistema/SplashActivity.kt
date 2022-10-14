package com.severo.trabalho_arquiterura_sistema

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.severo.trabalho_arquiterura_sistema.presentation.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        dalay()
    }

    private fun dalay() {
        lifecycleScope.launch {
            delay(2000L)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }
    }
}