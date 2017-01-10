package com.example.androidsp.appgplx.Btn_MeoGhiNho;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.androidsp.appgplx.R;

public class Btn_MeoGhiNho_Activity extends Activity {

    private WebView webView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_meoghinho);

        webView = (WebView) findViewById(R.id.wv_MeoGhiNho);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        imageView = (ImageView) findViewById(R.id.img_back);

        webView.loadUrl("file:///android_asset/filedata/tips.html");


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
