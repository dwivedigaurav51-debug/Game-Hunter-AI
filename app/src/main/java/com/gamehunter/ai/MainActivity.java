package com.gamehunter.ai;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle state){super.onCreate(state);web=new WebView(this);web.getSettings().setJavaScriptEnabled(true);web.getSettings().setDomStorageEnabled(true);web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView view,WebResourceRequest request){Uri uri=request.getUrl();if("game-hunter-ai.hatchable.site".equals(uri.getHost())&&"https".equals(uri.getScheme()))return false;startActivity(new Intent(Intent.ACTION_VIEW,uri));return true;}});setContentView(web);web.loadUrl("https://game-hunter-ai.hatchable.site/");}
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
 @Override protected void onDestroy(){if(web!=null)web.destroy();super.onDestroy();}
}
