package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.annotation.SuppressLint;
import android.view.View;
import io.flutter.plugin.platform.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformWebView extends e {
    @Override // io.flutter.plugin.platform.e
    /* synthetic */ void dispose();

    @Override // io.flutter.plugin.platform.e
    /* synthetic */ View getView();

    void makeInitialLoad(HashMap<String, Object> map);

    @Override // io.flutter.plugin.platform.e
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onFlutterViewDetached() {
    }

    @Override // io.flutter.plugin.platform.e
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onInputConnectionLocked() {
    }

    @Override // io.flutter.plugin.platform.e
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onInputConnectionUnlocked() {
    }

    @Override // io.flutter.plugin.platform.e
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onFlutterViewAttached(View view) {
    }
}
