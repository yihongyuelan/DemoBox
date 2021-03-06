package com.seven.designbox.designpatterns.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.Timer;
import java.util.TimerTask;

public abstract class PatternsCommonFragment extends Fragment {

    private WebView mWebView;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        CookieSyncManager.createInstance(mContext);
        mWebView = initWebView(mContext);
        loadData(savedInstanceState, mWebView);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mWebView;
    }

    @Override
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
        CookieSyncManager.getInstance().stopSync();
        mWebView.stopLoading();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Fix Receiver not registered: android.widget.ZoomButtonsController issue
        if (mWebView != null) {
            mWebView.setVisibility(View.GONE);
            long timeout = ViewConfiguration.getZoomControlsTimeout();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    ((Activity)mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mWebView.destroy();
                        }
                    });
                }
            }, timeout);
        }
    }

    private WebView initWebView(Context context) {
        WebView webView = null;
        if (context != null) {
            webView = new WebView(context);
            final WebSettings s = webView.getSettings();
            s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            s.setUseWideViewPort(false);
            s.setAllowFileAccess(true);
            s.setBuiltInZoomControls(true);
            s.setLightTouchEnabled(true);
            s.setLoadsImagesAutomatically(true);
            s.setPluginState(WebSettings.PluginState.OFF);
            s.setSupportZoom(true);
            s.setSupportMultipleWindows(true);
            s.setJavaScriptEnabled(true);
            s.setUseWideViewPort(true);
            s.setLoadWithOverviewMode(true);
        }
        return webView;
    }

    public abstract void loadData(Bundle bundle, WebView webView);
}
