package dev.ogabek.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv_language: TextView
    private lateinit var btn_open_language: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        tv_language = findViewById(R.id.tv_language)
        btn_open_language = findViewById(R.id.btn_open_language)
        btn_open_language.setOnClickListener(View.OnClickListener { callLanguageActivity() })
        tv_language.text = getString(R.string.language)
    }

    private fun callLanguageActivity() {
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent)
        finish()
    }
}