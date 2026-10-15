package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class x0 implements Callable<HonorPushDataMsg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f14567a;

    public x0(Intent intent) {
        this.f14567a = intent;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    public HonorPushDataMsg call() {
        byte[] byteArrayExtra;
        String string;
        String strOptString;
        int intExtra;
        Intent intent = this.f14567a;
        if (intent == null) {
            return null;
        }
        long longExtra = 0;
        try {
            longExtra = intent.getLongExtra("msg_id", 0L);
        } catch (Exception e9) {
            m.a("PassByMsgIntentParser", "parserMsgId", e9);
        }
        try {
            byteArrayExtra = this.f14567a.getByteArrayExtra("msg_content");
        } catch (Exception e10) {
            m.a("PassByMsgIntentParser", "parseMsgContent", e10);
            byteArrayExtra = null;
        }
        int i9 = 0;
        try {
            if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayExtra);
                InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[256];
                        while (true) {
                            int i10 = inflaterInputStream.read(bArr);
                            if (i10 <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i10);
                        }
                        string = byteArrayOutputStream.toString("UTF-8");
                        h.a(byteArrayInputStream);
                        h.a(inflaterInputStream);
                        h.a(byteArrayOutputStream);
                    } catch (Throwable th) {
                        h.a(byteArrayInputStream);
                        h.a(inflaterInputStream);
                        h.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e11) {
                    m.a("DeflateUtil", "unZipString", e11);
                    h.a(byteArrayInputStream);
                    h.a(inflaterInputStream);
                    h.a(byteArrayOutputStream);
                    string = null;
                }
                intExtra = this.f14567a.getIntExtra("msg_type", 0);
                if (intExtra != 1) {
                    i9 = 1;
                } else if (intExtra == 7) {
                    i9 = 2;
                }
                if (string != null) {
                    return null;
                }
                strOptString = new JSONObject(string).optString("data");
                if (!TextUtils.isEmpty(strOptString)) {
                    return null;
                }
                HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
                honorPushDataMsg.setMsgId(longExtra);
                honorPushDataMsg.setData(strOptString);
                honorPushDataMsg.setType(i9);
                return honorPushDataMsg;
            }
            Log.w("DeflateUtil", "un zip data is empty");
            intExtra = this.f14567a.getIntExtra("msg_type", 0);
            if (intExtra != 1) {
                i9 = 1;
            } else if (intExtra == 7) {
                i9 = 2;
            }
        } catch (Exception e12) {
            m.a("PassByMsgIntentParser", "parseMsgType", e12);
        }
        string = null;
        if (string != null) {
            return null;
        }
        strOptString = new JSONObject(string).optString("data");
        if (!TextUtils.isEmpty(strOptString)) {
            return null;
        }
        HonorPushDataMsg honorPushDataMsg2 = new HonorPushDataMsg();
        honorPushDataMsg2.setMsgId(longExtra);
        honorPushDataMsg2.setData(strOptString);
        honorPushDataMsg2.setType(i9);
        return honorPushDataMsg2;
    }
}
