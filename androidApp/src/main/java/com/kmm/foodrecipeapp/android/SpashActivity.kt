package com.kmm.foodrecipeapp.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope

class SpashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { true }
        lifecycleScope.launchWhenResumed {
            val intent = Intent(this@SpashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}