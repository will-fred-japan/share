package G;

import android.os.Bundle;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f2178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f2179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f2180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2181d = false;

    public void a(Bundle bundle) {
        if (this.f2181d) {
            bundle.putCharSequence("android.summaryText", this.f2180c);
        }
        CharSequence charSequence = this.f2179b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String strC = c();
        if (strC != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
        }
    }

    public abstract void b(x xVar);

    public String c() {
        return null;
    }

    public void d(Bundle bundle) {
        if (bundle.containsKey("android.summaryText")) {
            this.f2180c = bundle.getCharSequence("android.summaryText");
            this.f2181d = true;
        }
        this.f2179b = bundle.getCharSequence("android.title.big");
    }
}
