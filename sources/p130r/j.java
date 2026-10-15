package p130r;

import android.content.ComponentName;
import android.os.Bundle;
import p006b.d;

/* JADX INFO: compiled from: CustomTabsSession.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21085a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f21086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f21087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ComponentName f21088d;

    public j(d dVar, c cVar, ComponentName componentName) {
        this.f21086b = dVar;
        this.f21087c = cVar;
        this.f21088d = componentName;
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return bundle2;
    }
}
