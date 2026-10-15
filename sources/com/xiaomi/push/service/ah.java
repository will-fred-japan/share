package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.push.ff;
import com.xiaomi.push.iq;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public abstract long a(Context context, ff ffVar, Map<String, String> map);

    public abstract Intent a(Context context, iq iqVar, int i9, Bundle bundle);

    public abstract ff a(Context context, int i9, String str, Map<String, String> map);

    public abstract void a(iq iqVar, Map<String, String> map, int i9, Notification notification);

    public abstract void a(String str);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract boolean m728a(Context context, int i9, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i9, Notification notification);
}
