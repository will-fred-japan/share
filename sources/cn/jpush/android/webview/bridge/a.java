package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.starburst.sdk.req.GuiControlRequest;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f11749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11750b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.f11749a = progressBar;
        this.f11750b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.f11750b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.f11750b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i9) {
        super.onProgressChanged(webView, i9);
        ProgressBar progressBar = this.f11749a;
        if (progressBar != null) {
            if (100 == i9) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.f11749a.setProgress(i9);
            }
        }
        if (this.f11750b == null || webView.getTitle() == null || webView.getTitle().equals(this.f11750b.getText())) {
            return;
        }
        String title = webView.getTitle();
        if (title.startsWith(GuiControlRequest.IMAGE_TYPE_HTTP) || title.startsWith("android-app://") || title.startsWith("file://")) {
            return;
        }
        this.f11750b.setText(webView.getTitle());
    }
}
