package com.example.kraken.webview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by kraken on 6/5/18.
 */

public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        mContext = c;
    }

    @JavascriptInterface
    public void finishActivity(){
        Log.d("webview", "KILLLL MEEEEE");
        Activity c = (Activity) mContext;
        c.finish();
    }

}
