package me.khrystal.find_new_slidestrip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import me.khrystal.pagerslidingtabstripdemo.R;

/**
 * @FileName: me.khrystal.find_new_slidestrip.FragmentScrollContent.java
 * @Fuction:
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-09 17:52
 * @UpdateUser:
 * @UpdateDate:
 */
public class FragmentScrollContent extends Fragment {

    public static Fragment getInstance(Bundle bundle) {
        FragmentScrollContent fragment = new FragmentScrollContent();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initView(view);
    }

    private void initView(View view) {
        MyWebView webView = (MyWebView) view.findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.supportMultipleWindows();
        webView.setVerticalScrollBarEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/index.html");
    }
}
