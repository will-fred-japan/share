package io.flutter.plugin.platform;

import android.content.Context;

/* JADX INFO: compiled from: PlatformViewFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    private final p096m7.i<Object> createArgsCodec;

    public f(p096m7.i<Object> iVar) {
        this.createArgsCodec = iVar;
    }

    public abstract e create(Context context, int i9, Object obj);

    public final p096m7.i<Object> getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
