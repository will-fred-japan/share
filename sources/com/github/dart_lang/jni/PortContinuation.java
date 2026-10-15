package com.github.dart_lang.jni;

import B7.e;
import B7.h;
import S7.J;
import Z7.b;
import Z7.c;

/* JADX INFO: loaded from: classes.dex */
public class PortContinuation<T> implements e<T> {
    private final long port;

    static {
        System.loadLibrary("dartjni");
    }

    public PortContinuation(long j) {
        this.port = j;
    }

    private native void _resumeWith(long j, Object obj);

    @Override // B7.e
    public h getContext() {
        c cVar = J.f4233a;
        return b.f5649c;
    }

    @Override // B7.e
    public void resumeWith(Object obj) {
        _resumeWith(this.port, obj);
    }
}
