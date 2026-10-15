package com.pichillilorenzo.flutter_inappwebview_android.find_interaction;

import W5.e;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview_android.types.FindSession;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class FindInteractionController implements Disposable {
    static final String LOG_TAG = "FindInteractionController";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_find_interaction_";
    public FindSession activeFindSession;
    public FindInteractionChannelDelegate channelDelegate;
    public String searchText;
    public FindInteractionSettings settings;
    public InAppWebViewInterface webView;

    public FindInteractionController(InAppWebViewInterface inAppWebViewInterface, InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, Object obj, FindInteractionSettings findInteractionSettings) {
        this.webView = inAppWebViewInterface;
        this.settings = findInteractionSettings;
        this.channelDelegate = new FindInteractionChannelDelegate(this, new l(inAppWebViewFlutterPlugin.messenger, e.k(obj, METHOD_CHANNEL_NAME_PREFIX)));
    }

    public void clearMatches() {
        InAppWebViewInterface inAppWebViewInterface = this.webView;
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.clearMatches();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        FindInteractionChannelDelegate findInteractionChannelDelegate = this.channelDelegate;
        if (findInteractionChannelDelegate != null) {
            findInteractionChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        this.webView = null;
        this.activeFindSession = null;
        this.searchText = null;
    }

    public void findAll(String str) {
        if (str == null) {
            str = this.searchText;
        } else {
            this.searchText = str;
        }
        InAppWebViewInterface inAppWebViewInterface = this.webView;
        if (inAppWebViewInterface == null || str == null) {
            return;
        }
        inAppWebViewInterface.findAllAsync(str);
    }

    public void findNext(boolean z8) {
        InAppWebViewInterface inAppWebViewInterface = this.webView;
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.findNext(z8);
        }
    }

    public void prepare() {
    }
}
