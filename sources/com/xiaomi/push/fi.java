package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class fi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Vector<Pair<String, Long>> f17420a = new Vector<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f427a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f17420a) {
            for (int i9 = 0; i9 < f17420a.size(); i9++) {
                try {
                    Pair<String, Long> pairElementAt = f17420a.elementAt(i9);
                    sb.append((String) pairElementAt.first);
                    sb.append(Constants.COLON_SEPARATOR);
                    sb.append(pairElementAt.second);
                    if (i9 < f17420a.size() - 1) {
                        sb.append(";");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            f17420a.clear();
        }
        return sb.toString();
    }
}
