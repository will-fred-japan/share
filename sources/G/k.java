package G;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f2088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f2089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D[] f2090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public final int f2095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f2096i;
    public final PendingIntent j;

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IconCompat f2097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f2098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PendingIntent f2099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f2101e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ArrayList<D> f2102f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2103g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2104h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2105i;

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            this.f2100d = true;
            this.f2104h = true;
            this.f2097a = iconCompat;
            this.f2098b = n.b(charSequence);
            this.f2099c = pendingIntent;
            this.f2101e = bundle;
            this.f2102f = null;
            this.f2100d = true;
            this.f2103g = 0;
            this.f2104h = true;
            this.f2105i = false;
        }

        public final k a() {
            CharSequence[] charSequenceArr;
            if (this.f2105i && this.f2099c == null) {
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<D> arrayList3 = this.f2102f;
            if (arrayList3 != null) {
                for (D d9 : arrayList3) {
                    if (d9.f2061c || (!((charSequenceArr = d9.f2060b) == null || charSequenceArr.length == 0) || d9.f2063e.isEmpty())) {
                        arrayList2.add(d9);
                    } else {
                        arrayList.add(d9);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
            }
            return new k(this.f2097a, this.f2098b, this.f2099c, this.f2101e, arrayList2.isEmpty() ? null : (D[]) arrayList2.toArray(new D[arrayList2.size()]), this.f2100d, this.f2103g, this.f2104h, this.f2105i);
        }
    }

    public k(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, D[] dArr, boolean z8, int i9, boolean z9, boolean z10) {
        this.f2092e = true;
        this.f2089b = iconCompat;
        if (iconCompat != null) {
            int i10 = iconCompat.f7072a;
            if ((i10 == -1 ? IconCompat.a.c(iconCompat.f7073b) : i10) == 2) {
                this.f2095h = iconCompat.f();
            }
        }
        this.f2096i = n.b(charSequence);
        this.j = pendingIntent;
        this.f2088a = bundle == null ? new Bundle() : bundle;
        this.f2090c = dArr;
        this.f2091d = z8;
        this.f2093f = i9;
        this.f2092e = z9;
        this.f2094g = z10;
    }

    public final IconCompat a() {
        int i9;
        if (this.f2089b == null && (i9 = this.f2095h) != 0) {
            this.f2089b = IconCompat.e(null, "", i9);
        }
        return this.f2089b;
    }
}
