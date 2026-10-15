package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.starburst.sdk.core.tts.EventType;

/* JADX INFO: loaded from: classes2.dex */
public class dy {
    public static byte[] a(String str, byte[] bArr) {
        byte[] bArrM125a = bj.m125a(str);
        try {
            a(bArrM125a);
            return i.a(bArrM125a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] bArrM125a = bj.m125a(str);
        try {
            a(bArrM125a);
            return i.b(bArrM125a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = EventType.ERROR;
        }
    }

    public static boolean a(Context context, String str, long j) {
        return com.xiaomi.push.service.aq.a(context).a(hz.DCJobMutualSwitch.a(), false) && (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !af.a(context, str, j);
    }
}
