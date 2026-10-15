package G;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f2112B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f2113C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public long f2114D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final boolean f2116F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Notification f2117G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f2118H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    @Deprecated
    public final ArrayList<String> f2119I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2120a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f2125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f2126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PendingIntent f2127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IconCompat f2128i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2129k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public w f2132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f2133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f2137s;
    public boolean t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2139v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2140w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f2141x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Bundle f2142y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<k> f2121b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<B> f2122c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<k> f2123d = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2130l = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2138u = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2143z = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f2111A = 0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f2115E = 0;

    public n(Context context, String str) {
        Notification notification = new Notification();
        this.f2117G = notification;
        this.f2120a = context;
        this.f2112B = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f2129k = 0;
        this.f2119I = new ArrayList<>();
        this.f2116F = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Bundle bundle;
        x xVar = new x(this);
        n nVar = xVar.f2184c;
        w wVar = nVar.f2132n;
        if (wVar != null) {
            wVar.b(xVar);
        }
        Notification notificationBuild = xVar.f2183b.build();
        if (wVar != null) {
            nVar.f2132n.getClass();
        }
        if (wVar != null && (bundle = notificationBuild.extras) != null) {
            wVar.a(bundle);
        }
        return notificationBuild;
    }

    public final void c(int i9, boolean z8) {
        Notification notification = this.f2117G;
        if (z8) {
            notification.flags = i9 | notification.flags;
        } else {
            notification.flags = (~i9) & notification.flags;
        }
    }

    public final void d(w wVar) {
        if (this.f2132n != wVar) {
            this.f2132n = wVar;
            if (wVar == null || wVar.f2178a == this) {
                return;
            }
            wVar.f2178a = this;
            d(wVar);
        }
    }
}
