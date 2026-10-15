package p131r0;

import W5.e;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0546l;
import androidx.lifecycle.InterfaceC0548n;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Recreator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21092a;

    /* JADX INFO: renamed from: r0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Recreator.kt */
    public static final class C0247a implements b.InterfaceC0248b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f21093a;

        public C0247a(b registry) {
            k.e(registry, "registry");
            this.f21093a = new LinkedHashSet();
            registry.c("androidx.savedstate.Restarter", this);
        }

        @Override // p131r0.b.InterfaceC0248b
        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f21093a));
            return bundle;
        }
    }

    public a(d dVar) {
        this.f21092a = dVar;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        if (aVar != AbstractC0544j.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0548n.getLifecycle().c(this);
        d dVar = this.f21092a;
        Bundle bundleA = dVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, a.class.getClassLoader()).asSubclass(b.a.class);
                k.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                        k.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                        ((b.a) objNewInstance).a(dVar);
                    } catch (Exception e9) {
                        throw new RuntimeException(e.l("Failed to instantiate ", str), e9);
                    }
                } catch (NoSuchMethodException e10) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
                }
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(A.a.i("Class ", str, " wasn't found"), e11);
            }
        }
    }
}
