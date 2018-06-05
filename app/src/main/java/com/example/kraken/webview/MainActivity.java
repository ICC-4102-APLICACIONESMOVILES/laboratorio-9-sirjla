package com.example.kraken.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setWebChromeClient(new WebChromeClient(){
            public void onConsoleMessage(String message, int linenumber, String sourceId){
                Log.d("webview", message + " --- from line "
                        + linenumber + " of "
                        + sourceId
                );
            }
        });

        webview.addJavascriptInterface(new WebAppInterface(this), "Android");

        webview.loadUrl("http://demo.tutorialzine.com/2012/04/mobile-touch-gallery/");
    }

    @Override
    public void onBackPressed(){
        Log.d("webview", "Back pressed");
    }

}
