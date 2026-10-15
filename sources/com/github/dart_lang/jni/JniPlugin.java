package com.github.dart_lang.jni;

/* JADX INFO: loaded from: classes.dex */
public class JniPlugin implements p042f7.a {
    static {
        System.loadLibrary("dartjni");
        setClassLoader(JniPlugin.class.getClassLoader());
    }

    public static native void setClassLoader(ClassLoader classLoader);

    @Override // p042f7.a
    public void onAttachedToEngine(f7.a.b bVar) {
    }

    @Override // p042f7.a
    public void onDetachedFromEngine(f7.a.b bVar) {
    }
}
