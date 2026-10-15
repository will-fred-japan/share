package cn.jiguang.commons.a;

import android.os.Bundle;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f9690a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9691b = 1;

    public static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f9690a = byteBufferWrap.getLong();
            byte[] bArr = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            ee.a("JCmdUtils", "parseBundle2Json content: ".concat(str));
            return new JSONObject(str);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("parseBundle2Json exception:"), "JCmdUtils");
            return null;
        }
    }
}
