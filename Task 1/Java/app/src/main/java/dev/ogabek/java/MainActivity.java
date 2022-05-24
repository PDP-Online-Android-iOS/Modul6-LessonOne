package dev.ogabek.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_language;
    private Button btn_open_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        tv_language = findViewById(R.id.tv_language);
        btn_open_language = findViewById(R.id.btn_open_language);

        btn_open_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLanguageActivity();
            }
        });

        tv_language.setText(getString(R.string.language));

    }

    private void callLanguageActivity() {
        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent);
        finish();
    }
}