package com.lzf.easyfloat;

import F6.c;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: EasyFloatInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EasyFloatInitializer extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        k.e(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        k.b(context);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        k.e(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        k.e(uri, "uri");
        return 0;
    }
}
