package G;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class u extends w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2168h;
    public IconCompat j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IconCompat f2170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IconCompat f2171l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f2165e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f2166f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2167g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2169i = true;

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class a {
        public static void a(Notification.ProgressStyle progressStyle, int i9) {
            progressStyle.setProgress(i9);
        }

        public static void b(Notification.ProgressStyle progressStyle, Icon icon) {
            progressStyle.setProgressEndIcon(icon);
        }

        public static void c(Notification.ProgressStyle progressStyle, boolean z8) {
            progressStyle.setProgressIndeterminate(z8);
        }

        public static void d(Notification.ProgressStyle progressStyle, List<b> list) {
            for (b bVar : list) {
                progressStyle.addProgressPoint(new Notification.ProgressStyle.Point(bVar.f2172a).setColor(bVar.f2174c).setId(bVar.f2173b));
            }
        }

        public static void e(Notification.ProgressStyle progressStyle, List<c> list) {
            for (c cVar : list) {
                progressStyle.addProgressSegment(new Notification.ProgressStyle.Segment(cVar.f2175a).setColor(cVar.f2177c).setId(cVar.f2176b));
            }
        }

        public static void f(Notification.ProgressStyle progressStyle, Icon icon) {
            progressStyle.setProgressStartIcon(icon);
        }

        public static void g(Notification.ProgressStyle progressStyle, Icon icon) {
            progressStyle.setProgressTrackerIcon(icon);
        }

        public static void h(Notification.ProgressStyle progressStyle, boolean z8) {
            progressStyle.setStyledByProgress(z8);
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2174c;
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2177c;
    }

    public static IconCompat e(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        if (parcelable instanceof Icon) {
            return IconCompat.c((Icon) parcelable);
        }
        if (parcelable instanceof Bitmap) {
            return IconCompat.d((Bitmap) parcelable);
        }
        return null;
    }

    @Override // G.w
    public final void a(Bundle bundle) {
        super.a(bundle);
        if (Build.VERSION.SDK_INT < 36) {
            ArrayList arrayList = this.f2165e;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    c cVar = (c) arrayList.get(i9);
                    if (cVar.f2175a > 0) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("length", cVar.f2175a);
                        bundle2.putInt("id", cVar.f2176b);
                        bundle2.putInt("colorInt", cVar.f2177c);
                        arrayList2.add(bundle2);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressSegments", arrayList2);
            ArrayList arrayList3 = this.f2166f;
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                    b bVar = (b) arrayList3.get(i10);
                    if (bVar.f2172a >= 0) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("position", bVar.f2172a);
                        bundle3.putInt("id", bVar.f2173b);
                        bundle3.putInt("colorInt", bVar.f2174c);
                        arrayList4.add(bundle3);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressPoints", arrayList4);
            bundle.putInt("android.progress", this.f2167g);
            bundle.putBoolean("android.progressIndeterminate", this.f2168h);
            bundle.putInt("android.progressMax", f());
            bundle.putBoolean("android.styledByProgress", this.f2169i);
            n nVar = this.f2178a;
            Context context = nVar != null ? nVar.f2120a : null;
            if (context == null) {
                return;
            }
            IconCompat iconCompat = this.j;
            if (iconCompat != null) {
                bundle.putParcelable("android.progressTrackerIcon", iconCompat.h(context));
            } else {
                bundle.remove("android.progressTrackerIcon");
            }
            IconCompat iconCompat2 = this.f2170k;
            if (iconCompat2 != null) {
                bundle.putParcelable("android.progressStartIcon", iconCompat2.h(context));
            } else {
                bundle.remove("android.progressStartIcon");
            }
            IconCompat iconCompat3 = this.f2171l;
            if (iconCompat3 != null) {
                bundle.putParcelable("android.progressEndIcon", iconCompat3.h(context));
            } else {
                bundle.remove("android.progressEndIcon");
            }
        }
    }

    @Override // G.w
    public final void b(x xVar) {
        Notification.Builder builder = xVar.f2183b;
        if (Build.VERSION.SDK_INT < 36) {
            int iF = f();
            builder.setProgress(iF, Math.min(this.f2167g, iF), this.f2168h);
            return;
        }
        Notification.ProgressStyle progressStyleD = t.d();
        a.h(progressStyleD, this.f2169i);
        a.a(progressStyleD, this.f2167g);
        a.c(progressStyleD, this.f2168h);
        IconCompat iconCompat = this.f2170k;
        Context context = xVar.f2182a;
        a.f(progressStyleD, iconCompat != null ? iconCompat.h(context) : null);
        IconCompat iconCompat2 = this.f2171l;
        a.b(progressStyleD, iconCompat2 != null ? iconCompat2.h(context) : null);
        IconCompat iconCompat3 = this.j;
        a.g(progressStyleD, iconCompat3 != null ? iconCompat3.h(context) : null);
        a.d(progressStyleD, this.f2166f);
        a.e(progressStyleD, this.f2165e);
        builder.setStyle(progressStyleD);
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$ProgressStyle";
    }

    @Override // G.w
    public final void d(Bundle bundle) {
        super.d(bundle);
        ArrayList arrayListB = Build.VERSION.SDK_INT >= 34 ? P.b.a.b(bundle, "android.progressSegments") : bundle.getParcelableArrayList("android.progressSegments");
        ArrayList arrayList = new ArrayList();
        if (arrayListB != null && !arrayListB.isEmpty()) {
            for (int i9 = 0; i9 < arrayListB.size(); i9++) {
                Bundle bundle2 = (Bundle) arrayListB.get(i9);
                int i10 = bundle2.getInt("length");
                if (i10 > 0) {
                    int i11 = bundle2.getInt("id");
                    int i12 = bundle2.getInt("colorInt", 0);
                    c cVar = new c();
                    cVar.f2175a = i10;
                    cVar.f2176b = i11;
                    cVar.f2177c = i12;
                    arrayList.add(cVar);
                }
            }
        }
        this.f2165e = arrayList;
        this.f2167g = bundle.getInt("android.progress", 0);
        this.f2168h = bundle.getBoolean("android.progressIndeterminate", false);
        this.f2169i = bundle.getBoolean("android.styledByProgress", true);
        ArrayList arrayListB2 = Build.VERSION.SDK_INT >= 34 ? P.b.a.b(bundle, "android.progressPoints") : bundle.getParcelableArrayList("android.progressPoints");
        ArrayList arrayList2 = new ArrayList();
        if (arrayListB2 != null && !arrayListB2.isEmpty()) {
            for (int i13 = 0; i13 < arrayListB2.size(); i13++) {
                Bundle bundle3 = (Bundle) arrayListB2.get(i13);
                int i14 = bundle3.getInt("position");
                if (i14 >= 0) {
                    int i15 = bundle3.getInt("id");
                    int i16 = bundle3.getInt("colorInt", 0);
                    b bVar = new b();
                    bVar.f2172a = i14;
                    bVar.f2173b = i15;
                    bVar.f2174c = i16;
                    arrayList2.add(bVar);
                }
            }
        }
        this.f2166f = arrayList2;
        this.j = e((Parcelable) P.b.a(bundle, "android.progressTrackerIcon", Icon.class));
        this.f2170k = e((Parcelable) P.b.a(bundle, "android.progressStartIcon", Icon.class));
        this.f2171l = e((Parcelable) P.b.a(bundle, "android.progressEndIcon", Icon.class));
    }

    public final int f() {
        ArrayList arrayList = this.f2165e;
        if (arrayList == null || arrayList.isEmpty()) {
            return 100;
        }
        int i9 = 0;
        int iAddExact = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            int i11 = ((c) arrayList.get(i10)).f2175a;
            if (i11 > 0) {
                try {
                    iAddExact = Math.addExact(iAddExact, i11);
                    i9++;
                } catch (ArithmeticException unused) {
                    return 100;
                }
            }
        }
        if (i9 == 0) {
            return 100;
        }
        return iAddExact;
    }
}
