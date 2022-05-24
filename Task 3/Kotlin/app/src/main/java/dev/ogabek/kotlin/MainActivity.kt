package dev.ogabek.kotlin

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.simplepass.loadingbutton.customViews.CircularProgressButton

class MainActivity : AppCompatActivity() {

    private lateinit var btn_loading_1: CircularProgressButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }
    private fun initViews() {
        btn_loading_1 = findViewById(R.id.btn_loading_1)
        btn_loading_1.setOnClickListener { view: View? ->
            @SuppressLint("StaticFieldLeak") val demoDownload: AsyncTask<String, String, String> =
                object : AsyncTask<String, String, String>() {
                    override fun doInBackground(vararg strings: String): String {
                        try {
                            Thread.sleep(3000)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                        return "done"
                    }

                    override fun onPostExecute(s: String) {
                        if (s == "done") {
                            Toast.makeText(
                                applicationContext,
                                "Downloading done",
                                Toast.LENGTH_SHORT
                            ).show()
                            btn_loading_1.doneLoadingAnimation(
                                Color.parseColor("#333639"),
                                BitmapFactory.decodeResource(
                                    resources,
                                    R.drawable.ic_done_white_48dp
                                )
                            )
                        }
                    }
                }
            btn_loading_1.startAnimation()
            demoDownload.execute()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        btn_loading_1.dispose()
    }
}