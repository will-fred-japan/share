package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: compiled from: SettingsCache.java */
/* JADX INFO: loaded from: classes.dex */
final class af implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentResolver f16827a;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (!o.b()) {
            return false;
        }
        this.f16827a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.f16827a, str);
        } catch (Exception e9) {
            e9.printStackTrace();
            w.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
