package io.flutter.plugin.platform;

import android.view.Surface;

/* JADX INFO: compiled from: PlatformViewRenderTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {
    long a();

    void b(int i9, int i10);

    int getHeight();

    Surface getSurface();

    int getWidth();

    void release();

    default void scheduleFrame() {
    }
}
