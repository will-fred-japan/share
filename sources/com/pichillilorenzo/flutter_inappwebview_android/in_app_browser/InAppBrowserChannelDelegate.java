package com.pichillilorenzo.flutter_inappwebview_android.in_app_browser;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.InAppBrowserMenuItem;
import java.util.HashMap;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class InAppBrowserChannelDelegate extends ChannelDelegateImpl {
    public InAppBrowserChannelDelegate(l lVar) {
        super(lVar);
    }

    public void onBrowserCreated() {
        l channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onBrowserCreated", new HashMap(), null);
    }

    public void onExit() {
        l channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onExit", new HashMap(), null);
    }

    public void onMenuItemClicked(InAppBrowserMenuItem inAppBrowserMenuItem) {
        l channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("id", Integer.valueOf(inAppBrowserMenuItem.getId()));
        channel.a("onMenuItemClicked", map, null);
    }
}
