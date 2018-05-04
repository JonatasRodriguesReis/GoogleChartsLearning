package com.example.jonatas.googlechartslearn;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         wb = findViewById(R.id.webCharts);
        WebSettings ws = wb.getSettings();
        ws.setJavaScriptEnabled(true);

        wb.loadUrl("file:///android_asset/testepizza.html");
    }


}
