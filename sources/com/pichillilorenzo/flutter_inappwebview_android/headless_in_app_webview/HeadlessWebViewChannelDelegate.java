package com.pichillilorenzo.flutter_inappwebview_android.headless_in_app_webview;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.Size2D;
import java.util.HashMap;
import java.util.Map;
import p096m7.j;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class HeadlessWebViewChannelDelegate extends ChannelDelegateImpl {
    private HeadlessInAppWebView headlessWebView;

    public HeadlessWebViewChannelDelegate(HeadlessInAppWebView headlessInAppWebView, l lVar) {
        super(lVar);
        this.headlessWebView = headlessInAppWebView;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.headlessWebView = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, m7.l.c
    public void onMethodCall(j jVar, l.d dVar) {
        String str = jVar.f20496a;
        str.getClass();
        switch (str) {
            case "getSize":
                HeadlessInAppWebView headlessInAppWebView = this.headlessWebView;
                if (headlessInAppWebView == null) {
                    dVar.success(null);
                    break;
                } else {
                    Size2D size = headlessInAppWebView.getSize();
                    dVar.success(size != null ? size.toMap() : null);
                    break;
                }
                break;
            case "dispose":
                HeadlessInAppWebView headlessInAppWebView2 = this.headlessWebView;
                if (headlessInAppWebView2 == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    headlessInAppWebView2.dispose();
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "setSize":
                if (this.headlessWebView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    Size2D size2DFromMap = Size2D.fromMap((Map) jVar.a("size"));
                    if (size2DFromMap != null) {
                        this.headlessWebView.setSize(size2DFromMap);
                    }
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            default:
                dVar.notImplemented();
                break;
        }
    }

    public void onWebViewCreated() {
        l channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onWebViewCreated", new HashMap(), null);
    }
}
