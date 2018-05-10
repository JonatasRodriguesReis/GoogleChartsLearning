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

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.DataValor;

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
        /*final String t = "Jonatas Top";
        String nomes[] = new String[]{"Jonatas","5","Teste","3","Manoel","77","Lucia","48"};
        final JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0; i < nomes.length; i++) {
                jsonArray.put(i,nomes[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                wb.loadUrl("javascript:metodoWebView2('" + jsonArray.toString() +"');");
            }
        });*/


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://" + getResources().getString(R.string.ip) + ":85/webserviceCharts/data/getAll.php",null,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                try {
                    final JSONArray datas = response.getJSONArray("records");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            wb.loadUrl("javascript:metodoWebView2('" + datas.toString() +"');");
                        }
                    });
                }  catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        });


    }

    @JavascriptInterface
    public String metodoPonte(){
        String nomes[] = new String[]{"Jonatas","5","Teste","3","Manoel","77","Lucia","48"};
        final JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0; i < nomes.length; i++) {
                jsonArray.put(i,nomes[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray.toString();

    }
}
