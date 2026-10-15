package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class fh extends ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Bitmap f418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RemoteViews f419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected CharSequence f420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Map<String, String> f423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17419b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected CharSequence f425b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f426b;

    public fh(Context context, String str) {
        this(context, 0, str);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m380c() {
        Map<String, String> map = this.f423a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f420a);
        super.setContentText(this.f425b);
    }

    private boolean e() {
        return m381d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> listC = com.xiaomi.push.service.an.a(a(), this.f421a).c();
        if (listC != null && !listC.isEmpty()) {
            for (StatusBarNotification statusBarNotification : listC) {
                if (statusBarNotification.getId() == this.f17418a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract String mo383a();

    public void a(int i9, Notification.Action action) {
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo376a();

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public fh setContentText(CharSequence charSequence) {
        this.f425b = charSequence;
        return this;
    }

    public abstract String b();

    public fh(Context context, int i9, String str) {
        super(context);
        this.f422a = new ArrayList<>();
        this.f17419b = 0;
        this.f421a = str;
        this.f17418a = i9;
        m379c();
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fh setContentTitle(CharSequence charSequence) {
        this.f420a = charSequence;
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m385b() {
        super.setContentTitle(this.f420a);
        super.setContentText(this.f425b);
        Bitmap bitmap = this.f418a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m381d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f421a)) ? false : true;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fh setLargeIcon(Bitmap bitmap) {
        this.f418a = bitmap;
        return this;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private void m379c() {
        int iA = a(a().getResources(), c(), "layout", a().getPackageName());
        if (iA != 0) {
            this.f419a = new RemoteViews(a().getPackageName(), iA);
            this.f424a = mo376a();
        } else {
            com.xiaomi.channel.commonutils.logger.c.m9a("create RemoteViews failed, no such layout resource was found");
        }
    }

    @Override // com.xiaomi.push.ff
    public ff a(Map<String, String> map) {
        this.f423a = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fh addAction(int i9, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i9, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public fh addAction(Notification.Action action) {
        if (action != null) {
            this.f422a.add(action);
        }
        int i9 = this.f17419b;
        this.f17419b = i9 + 1;
        a(i9, action);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final boolean m386b() {
        return this.f424a;
    }

    @Override // com.xiaomi.push.ff
    /* JADX INFO: renamed from: a */
    public void mo375a() {
        super.mo375a();
        Bundle bundle = new Bundle();
        if (m381d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f426b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f422a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f422a.size()];
            this.f422a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!m380c() && com.xiaomi.push.service.ao.m749a(a().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f420a);
            bundle.putCharSequence("mipush.customContent", this.f425b);
        } else {
            d();
        }
        addExtras(bundle);
    }

    private String c() {
        boolean zE = e();
        this.f426b = zE;
        return zE ? b() : mo383a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final RemoteViews m382a() {
        return this.f419a;
    }

    public void a(int i9) {
        Bitmap bitmapA = a();
        if (bitmapA != null) {
            m382a().setImageViewBitmap(i9, bitmapA);
            return;
        }
        int iB = h.b(a(), this.f421a);
        if (iB != 0) {
            m382a().setImageViewResource(i9, iB);
        }
    }

    private Bitmap a() {
        return com.xiaomi.push.service.ac.a(h.m447a(a(), this.f421a));
    }

    public int a(float f6) {
        return (int) ((f6 * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f6, f6, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m384a(int i9) {
        return (((double) Color.blue(i9)) * 0.114d) + ((((double) Color.green(i9)) * 0.587d) + (((double) Color.red(i9)) * 0.299d)) < 192.0d;
    }
}
