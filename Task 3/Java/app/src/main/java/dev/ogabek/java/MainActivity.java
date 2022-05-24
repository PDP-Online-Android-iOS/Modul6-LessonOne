package dev.ogabek.java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
import br.com.simplepass.loadingbutton.customViews.OnAnimationEndListener;

public class MainActivity extends AppCompatActivity {

    CircularProgressButton btn_loading_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        btn_loading_1 = findViewById(R.id.btn_loading_1);

        btn_loading_1.setOnClickListener(view -> {
            @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> demoDownload = new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... strings) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "done";
                }

                @Override
                protected void onPostExecute(String s) {
                    if (s.equals("done")) {
                        Toast.makeText(getApplicationContext(), "Downloading done", Toast.LENGTH_SHORT).show();
                        btn_loading_1.doneLoadingAnimation(Color.parseColor("#333639"), BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_white_48dp));
                    }
                }
            };
            btn_loading_1.startAnimation();
            demoDownload.execute();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        btn_loading_1.dispose();
    }
}