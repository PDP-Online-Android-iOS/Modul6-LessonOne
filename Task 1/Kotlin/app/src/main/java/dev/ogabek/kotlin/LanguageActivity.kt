package dev.ogabek.kotlin

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class LanguageActivity : AppCompatActivity() {
    private lateinit var btn_uzbek: Button
    private lateinit var btn_china: Button
    private lateinit var btn_korean: Button
    private lateinit var btn_japan: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()
    }

    private fun initViews() {
        btn_uzbek = findViewById(R.id.btn_uzbek)
        btn_china = findViewById(R.id.btn_china)
        btn_korean = findViewById(R.id.btn_korea)
        btn_japan = findViewById(R.id.btn_japan)
        btn_uzbek.setOnClickListener(View.OnClickListener {
            updateLanguage("uz")
            callMainActivity()
        })
        btn_china.setOnClickListener(View.OnClickListener {
            updateLanguage("zh")
            callMainActivity()
        })
        btn_korean.setOnClickListener(View.OnClickListener {
            updateLanguage("ko")
            callMainActivity()
        })
        btn_japan.setOnClickListener(View.OnClickListener {
            updateLanguage("ja")
            callMainActivity()
        })
    }

    private fun callMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun updateLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = this.resources
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}