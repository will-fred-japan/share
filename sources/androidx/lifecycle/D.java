package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: SavedStateHandleSupport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class D implements p131r0.b.InterfaceC0248b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p131r0.b f7694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f7696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p188x7.h f7697d;

    /* JADX INFO: compiled from: SavedStateHandleSupport.kt */
    public static final class a extends kotlin.jvm.internal.l implements K7.a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f7698a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(N n8) {
            super(0);
            this.f7698a = n8;
        }

        @Override // K7.a
        public final E invoke() {
            return C.c(this.f7698a);
        }
    }

    public D(p131r0.b savedStateRegistry, N n8) {
        kotlin.jvm.internal.k.e(savedStateRegistry, "savedStateRegistry");
        this.f7694a = savedStateRegistry;
        this.f7697d = p011b4.h.E(new a(n8));
    }

    @Override // p131r0.b.InterfaceC0248b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7696c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((E) this.f7697d.getValue()).f7699d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((z) entry.getValue()).f7787e.a();
            if (!kotlin.jvm.internal.k.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f7695b = false;
        return bundle;
    }

    public final void b() {
        if (this.f7695b) {
            return;
        }
        Bundle bundleA = this.f7694a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7696c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.f7696c = bundle;
        this.f7695b = true;
    }
}
