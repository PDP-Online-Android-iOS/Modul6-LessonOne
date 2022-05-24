package dev.ogabek.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    private Button btn_uzbek, btn_china, btn_korean, btn_japan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        initViews();

    }

    private void initViews() {
        btn_uzbek = findViewById(R.id.btn_uzbek);
        btn_china = findViewById(R.id.btn_china);
        btn_korean = findViewById(R.id.btn_korea);
        btn_japan = findViewById(R.id.btn_japan);

        btn_uzbek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLanguage("uz");
                callMainActivity();
            }
        });

        btn_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLanguage("zh");
                callMainActivity();
            }
        });

        btn_korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLanguage("ko");
                callMainActivity();
            }
        });

        btn_japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLanguage("ja");
                callMainActivity();
            }
        });



    }

    private void callMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    void updateLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = this.getResources();
        Configuration config = new Configuration(resources.getConfiguration());
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}