package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: compiled from: PlatformView.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {
    void dispose();

    View getView();

    @SuppressLint({"NewApi"})
    default void onFlutterViewDetached() {
    }

    @SuppressLint({"NewApi"})
    default void onInputConnectionLocked() {
    }

    @SuppressLint({"NewApi"})
    default void onInputConnectionUnlocked() {
    }

    @SuppressLint({"NewApi"})
    default void onFlutterViewAttached(View view) {
    }
}
