package com.starburst.sdk.utils;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16446a = 0;

    static {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
    }

    public static byte[] a(String str, String str2) {
        try {
            String string = new JSONStringer().object().key("sid").value(str).key("data").value(str2).key("ver").value(1L).endObject().toString();
            j.f("DataUtils", "target to bt data json ==> " + string);
            return string.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e9) {
            j.j("DataUtils", "Build Bluetooth payload failed", e9);
            return null;
        }
    }

    public static boolean b(byte[] bArr) {
        return bArr.length == 8 && new String(bArr, StandardCharsets.UTF_8).trim().toLowerCase().startsWith("finish");
    }
}
