package p017c2;

import android.content.IntentFilter;
import p061i1.h;

/* JADX INFO: compiled from: TemperatureDataManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f8758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntentFilter f8759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8763f;

    /* JADX INFO: compiled from: TemperatureDataManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f8764a;

        static {
            i iVar = new i();
            iVar.f8758a = new h(iVar);
            iVar.f8759b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            f8764a = iVar;
        }
    }

    public final synchronized void a() {
        if (this.f8760c) {
            return;
        }
        try {
            this.f8760c = true;
            h.f19229a.registerReceiver(this.f8758a, this.f8759b);
        } catch (Exception unused) {
        }
    }
}
