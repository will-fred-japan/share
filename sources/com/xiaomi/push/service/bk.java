package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.hz;
import java.util.HashMap;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes2.dex */
public class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f18341a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final bk f18342a = new bk();
    }

    public interface b {
        void a(String str, int i9);
    }

    private bk() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static bk m783a() {
        return a.f18342a;
    }

    private void b(s.d[] dVarArr, int i9) {
        s.b bVar;
        if (dVarArr == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = null;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            s.d dVar = dVarArr[i11];
            if (dVar != null && (bVar = dVar.f1151a) != null) {
                String str2 = bVar.f1145a;
                if (!TextUtils.isEmpty(str2)) {
                    Integer num = (Integer) map.get(str2);
                    int iIntValue = num != null ? 1 + num.intValue() : 1;
                    map.put(str2, Integer.valueOf(iIntValue));
                    if (iIntValue > i10) {
                        str = str2;
                        i10 = iIntValue;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f18341a.a(str, i10);
    }

    public void a(b bVar) {
        this.f18341a = bVar;
    }

    private int a() {
        Context contextM835a = com.xiaomi.push.t.m835a();
        return contextM835a == null ? Http2.INITIAL_MAX_FRAME_SIZE : Math.max(aq.a(contextM835a).a(hz.TaskHeapSizeMax.a(), Http2.INITIAL_MAX_FRAME_SIZE), 8192);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private long m782a() {
        Context contextM835a = com.xiaomi.push.t.m835a();
        if (contextM835a == null) {
            return Long.MAX_VALUE;
        }
        return contextM835a.getSharedPreferences("mipush_extra", 0).getLong("last_limit_app_id_upload_time", 0L);
    }

    private void a(long j) {
        Context contextM835a = com.xiaomi.push.t.m835a();
        if (contextM835a == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = contextM835a.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putLong("last_limit_app_id_upload_time", j);
        editorEdit.apply();
    }

    public void a(s.d[] dVarArr, int i9) {
        if (this.f18341a == null || dVarArr == null || i9 <= 8192) {
            return;
        }
        try {
            if (i9 > a()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Math.abs(jCurrentTimeMillis - m782a()) > 86400000) {
                    b(dVarArr, i9);
                    a(jCurrentTimeMillis);
                }
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("check task count error: " + e9.getMessage());
        }
    }
}
