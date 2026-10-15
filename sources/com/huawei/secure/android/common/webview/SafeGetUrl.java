package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class SafeGetUrl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15984c = "SafeGetUrl";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f15985d = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f15987b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f15988a;

        public a(CountDownLatch countDownLatch) {
            this.f15988a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f15987b.getUrl());
            this.f15988a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.f15987b == null) {
            return "";
        }
        if (b.a()) {
            return this.f15987b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e9) {
            Log.e(f15984c, "getUrlMethod: InterruptedException " + e9.getMessage(), e9);
        }
        return this.f15986a;
    }

    public WebView getWebView() {
        return this.f15987b;
    }

    public void setUrl(String str) {
        this.f15986a = str;
    }

    public void setWebView(WebView webView) {
        this.f15987b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f15987b = webView;
    }
}
