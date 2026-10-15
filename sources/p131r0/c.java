package p131r0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0544j;
import java.util.Map;
import p030e.f;
import p113p.b;

/* JADX INFO: compiled from: SavedStateRegistryController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21101b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21102c;

    public c(d dVar) {
        this.f21100a = dVar;
    }

    public final void a() {
        d dVar = this.f21100a;
        AbstractC0544j lifecycle = dVar.getLifecycle();
        if (lifecycle.b() != AbstractC0544j.b.f7735b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new a(dVar));
        b bVar = this.f21101b;
        bVar.getClass();
        if (bVar.f21095b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new f(1, bVar));
        bVar.f21095b = true;
        this.f21102c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f21102c) {
            a();
        }
        AbstractC0544j lifecycle = this.f21100a.getLifecycle();
        if (lifecycle.b().compareTo(AbstractC0544j.b.f7737d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
        }
        b bVar = this.f21101b;
        if (!bVar.f21095b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (bVar.f21097d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        bVar.f21096c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        bVar.f21097d = true;
    }

    public final void c(Bundle bundle) {
        b bVar = this.f21101b;
        bVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = bVar.f21096c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b<String, b.InterfaceC0248b> bVar2 = bVar.f21094a;
        bVar2.getClass();
        b.d dVar = new b.d();
        bVar2.f20739c.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((b.InterfaceC0248b) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
