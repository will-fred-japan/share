package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0542h {

    /* JADX INFO: renamed from: androidx.lifecycle.h$a */
    /* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
    public static final class a implements r0.b.a {
        @Override // r0.b.a
        public final void a(p131r0.d dVar) {
            if (!(dVar instanceof N)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            M viewModelStore = ((N) dVar).getViewModelStore();
            p131r0.b savedStateRegistry = dVar.getSavedStateRegistry();
            viewModelStore.getClass();
            LinkedHashMap linkedHashMap = viewModelStore.f7719a;
            for (String key : new HashSet(linkedHashMap.keySet())) {
                kotlin.jvm.internal.k.e(key, "key");
                I i9 = (I) linkedHashMap.get(key);
                kotlin.jvm.internal.k.b(i9);
                C0542h.a(i9, savedStateRegistry, dVar.getLifecycle());
            }
            if (new HashSet(linkedHashMap.keySet()).isEmpty()) {
                return;
            }
            savedStateRegistry.d();
        }
    }

    public static final void a(I i9, p131r0.b registry, AbstractC0544j lifecycle) {
        Object obj;
        kotlin.jvm.internal.k.e(registry, "registry");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        HashMap map = i9.f7708a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = i9.f7708a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        B b9 = (B) obj;
        if (b9 == null || b9.f7690c) {
            return;
        }
        b9.h(lifecycle, registry);
        AbstractC0544j.b bVarB = lifecycle.b();
        if (bVarB == AbstractC0544j.b.f7735b || bVarB.compareTo(AbstractC0544j.b.f7737d) >= 0) {
            registry.d();
        } else {
            lifecycle.a(new C0543i(lifecycle, registry));
        }
    }
}
