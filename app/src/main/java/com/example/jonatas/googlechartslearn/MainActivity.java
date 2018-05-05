package com.example.jonatas.googlechartslearn;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private WebView wb;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         wb = findViewById(R.id.webCharts);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.addJavascriptInterface(this,"Android");
        wb.loadUrl("file:///android_asset/testepizza.html");
    }

    public void teste(View view){
        /*Log.d("Jonatas","kjkjhjk");
        String nomes[] = new String[]{"Jonatas","Teste","Manoel","Lucia"};
        final JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(0,"Jonatas");
            jsonArray.put(1,"Teste");
            jsonArray.put(2,"Manoel");
            jsonArray.put(3,"Lucia");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                wb.loadUrl("javascript:metodoWebView2();");
                //wb.loadUrl("javascript:drawChart();");
            }
        });

    }

    @JavascriptInterface
    public String metodoPonte(){
        String nomes[] = new String[]{"Jonatas","Teste","Manoel","Lucia"};
        final JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(0,"Jonatas");
            jsonArray.put(1,"Teste");
            jsonArray.put(2,"Manoel");
            jsonArray.put(3,"Lucia");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("TesteJ",jsonArray.toString());
        return jsonArray.toString();

    }
}
