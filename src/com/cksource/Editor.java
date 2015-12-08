package com.cksource;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.cknotes.R;

@SuppressLint("SetJavaScriptEnabled") public class Editor extends Activity {
	
	private WebView webView;
	private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.addJavascriptInterface(new CameraInterface(this), "Camera");        
        webView.loadUrl("file:///android_asset/editor.html");
    }
    
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
       if (resultCode == RESULT_OK) {
    	   webView.loadUrl("javascript:done('" + imagePath + "');");
       }
    }

	public void setImageName(String imagePath) {
		this.imagePath = imagePath;
		
	}
    
}
