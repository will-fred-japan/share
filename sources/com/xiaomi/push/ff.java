package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class ff extends Notification.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17414a;

    public ff(Context context) {
        super(context);
        this.f17414a = context;
    }

    public ff a(Map<String, String> map) {
        return this;
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo375a();
        return super.build();
    }

    /* JADX INFO: renamed from: a */
    public void mo375a() {
    }

    public Context a() {
        return this.f17414a;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return h.a(str, str2, str3, this.f17414a);
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final String m378a(String str) {
        try {
            return a().getResources().getString(a(a().getResources(), str, "string", a().getPackageName()));
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.d("fail to get string. " + e9.getMessage());
            return "";
        }
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ff addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ff setCustomContentView(RemoteViews remoteViews) {
        super.setCustomContentView(remoteViews);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ff mo377a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bh.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
                return this;
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.d("fail to set color. " + e9);
            }
        }
        return this;
    }
}
