package com.sunasterisk.crane.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        this.intent = intent
    }
}
