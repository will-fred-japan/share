package p131r0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.C0542h;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: SavedStateRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f21096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p131r0.a.C0247a f21098e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p113p.b<String, InterfaceC0248b> f21094a = new p113p.b<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21099f = true;

    /* JADX INFO: compiled from: SavedStateRegistry.kt */
    public interface a {
        void a(d dVar);
    }

    /* JADX INFO: renamed from: r0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SavedStateRegistry.kt */
    public interface InterfaceC0248b {
        Bundle a();
    }

    public final Bundle a(String str) {
        if (!this.f21097d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f21096c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.f21096c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f21096c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f21096c = null;
        return bundle2;
    }

    public final InterfaceC0248b b() {
        String str;
        InterfaceC0248b interfaceC0248b;
        Iterator<Map.Entry<String, InterfaceC0248b>> it = this.f21094a.iterator();
        do {
            p.b.e eVar = (p.b.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            Map.Entry components = (Map.Entry) eVar.next();
            k.d(components, "components");
            str = (String) components.getKey();
            interfaceC0248b = (InterfaceC0248b) components.getValue();
        } while (!k.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC0248b;
    }

    public final void c(String str, InterfaceC0248b provider) {
        InterfaceC0248b interfaceC0248b;
        k.e(provider, "provider");
        p113p.b<String, InterfaceC0248b> bVar = this.f21094a;
        p.b.c<String, InterfaceC0248b> cVarF = bVar.f(str);
        if (cVarF != null) {
            interfaceC0248b = cVarF.f20742b;
        } else {
            p.b.c<K, V> cVar = new p.b.c<>(str, provider);
            bVar.f20740d++;
            p.b.c cVar2 = bVar.f20738b;
            if (cVar2 == null) {
                bVar.f20737a = cVar;
                bVar.f20738b = cVar;
            } else {
                cVar2.f20743c = cVar;
                cVar.f20744d = cVar2;
                bVar.f20738b = cVar;
            }
            interfaceC0248b = null;
        }
        if (interfaceC0248b != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (!this.f21099f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        p131r0.a.C0247a c0247a = this.f21098e;
        if (c0247a == null) {
            c0247a = new p131r0.a.C0247a(this);
        }
        this.f21098e = c0247a;
        try {
            C0542h.a.class.getDeclaredConstructor(new Class[0]);
            p131r0.a.C0247a c0247a2 = this.f21098e;
            if (c0247a2 != null) {
                c0247a2.f21093a.add(C0542h.a.class.getName());
            }
        } catch (NoSuchMethodException e9) {
            throw new IllegalArgumentException("Class " + C0542h.a.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e9);
        }
    }
}
