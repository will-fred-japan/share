package p039f3;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.u;
import androidx.fragment.app.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: LogQueue.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e f18689e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f18690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Serializable f18692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f18693d;

    public e(Application application) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f18692c = atomicBoolean;
        LinkedList linkedList = new LinkedList();
        this.f18693d = linkedList;
        Context applicationContext = application.getApplicationContext();
        this.f18690a = new ConcurrentHashMap();
        f fVar = new f(applicationContext, this, linkedList, atomicBoolean);
        this.f18691b = fVar;
        fVar.start();
    }

    public void a(Fragment fragment) {
        if (((ArrayList) this.f18690a).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.f18690a)) {
            ((ArrayList) this.f18690a).add(fragment);
        }
        fragment.f7469k = true;
    }

    public Fragment b(String str) {
        w wVar = (w) ((HashMap) this.f18691b).get(str);
        if (wVar != null) {
            return wVar.f7653c;
        }
        return null;
    }

    public Fragment c(String str) {
        for (w wVar : ((HashMap) this.f18691b).values()) {
            if (wVar != null) {
                Fragment fragmentC = wVar.f7653c;
                if (!str.equals(fragmentC.f7464e)) {
                    fragmentC = fragmentC.f7478u.f7518c.c(str);
                }
                if (fragmentC != null) {
                    return fragmentC;
                }
            }
        }
        return null;
    }

    public ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (w wVar : ((HashMap) this.f18691b).values()) {
            if (wVar != null) {
                arrayList.add(wVar);
            }
        }
        return arrayList;
    }

    public ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (w wVar : ((HashMap) this.f18691b).values()) {
            if (wVar != null) {
                arrayList.add(wVar.f7653c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List f() {
        ArrayList arrayList;
        if (((ArrayList) this.f18690a).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f18690a)) {
            arrayList = new ArrayList((ArrayList) this.f18690a);
        }
        return arrayList;
    }

    public void g(w wVar) {
        Fragment fragment = wVar.f7653c;
        String str = fragment.f7464e;
        HashMap map = (HashMap) this.f18691b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.f7464e, wVar);
        if (FragmentManager.J(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void h(w wVar) {
        Fragment fragment = wVar.f7653c;
        if (fragment.f7443B) {
            ((u) this.f18693d).f(fragment);
        }
        HashMap map = (HashMap) this.f18691b;
        if (map.get(fragment.f7464e) == wVar && ((w) map.put(fragment.f7464e, null)) != null && FragmentManager.J(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public Bundle i(Bundle bundle, String str) {
        HashMap map = (HashMap) this.f18692c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }

    public e() {
        this.f18690a = new ArrayList();
        this.f18691b = new HashMap();
        this.f18692c = new HashMap();
    }
}
