package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes2.dex */
public class fe extends fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f17412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f17413c;

    public fe(Context context, String str) {
        super(context, str);
        this.f17411a = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
    }

    @Override // com.xiaomi.push.fh, android.app.Notification.Builder
    /* JADX INFO: renamed from: a */
    public fh setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.fh
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a */
    public String mo383a() {
        return "notification_banner";
    }

    public fe b(Bitmap bitmap) {
        if (m386b() && bitmap != null) {
            this.f17413c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo376a() {
        if (!k.m648a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || k.a(a()) < 9) ? false : true;
    }

    @Override // com.xiaomi.push.fh
    /* JADX INFO: renamed from: a */
    public fe setLargeIcon(Bitmap bitmap) {
        if (m386b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f17412b = bitmap;
                return this;
            }
            com.xiaomi.channel.commonutils.logger.c.m9a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
        }
        return this;
    }

    @Override // com.xiaomi.push.ff
    /* JADX INFO: renamed from: a */
    public fe mo377a(String str) {
        if (m386b() && !TextUtils.isEmpty(str)) {
            try {
                this.f17411a = Color.parseColor(str);
                return this;
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.c.m9a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.fh, com.xiaomi.push.ff
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo375a() {
        if (m386b() && this.f17412b != null) {
            super.mo375a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "bg", "id", packageName);
            if (k.a(a()) >= 10) {
                m382a().setImageViewBitmap(iA, a(this.f17412b, 30.0f));
            } else {
                m382a().setImageViewBitmap(iA, this.f17412b);
            }
            int iA2 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (this.f17413c != null) {
                m382a().setImageViewBitmap(iA2, this.f17413c);
            } else {
                a(iA2);
            }
            int iA3 = a(resources, "title", "id", packageName);
            m382a().setTextViewText(iA3, ((fh) this).f420a);
            Map<String, String> map = ((fh) this).f423a;
            if (map != null && this.f17411a == 16777216) {
                mo377a(map.get("notification_image_text_color"));
            }
            RemoteViews remoteViewsM382a = m382a();
            int i9 = this.f17411a;
            remoteViewsM382a.setTextColor(iA3, (i9 == 16777216 || !m384a(i9)) ? -1 : -16777216);
            setCustomContentView(m382a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m385b();
    }
}
