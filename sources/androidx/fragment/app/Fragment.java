package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0541g;
import androidx.lifecycle.InterfaceC0548n;
import androidx.lifecycle.J;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import cn.ikaile.ruoshui.client.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0548n, N, InterfaceC0541g, p131r0.d {

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Object f7441T = new Object();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f7442A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f7443B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f7445D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ViewGroup f7446E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public View f7447F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f7448G;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public d f7450I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f7451J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f7452K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public String f7453L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public AbstractC0544j.b f7454M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public androidx.lifecycle.o f7455N;
    public y O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final androidx.lifecycle.s<InterfaceC0548n> f7456P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public p131r0.c f7457Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final ArrayList<f> f7458R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final b f7459S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f7461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SparseArray<Parcelable> f7462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f7463d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f7465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f7466g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7468i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7472n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7473o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7474p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7475q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7476r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FragmentManager f7477s;
    public g.a t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Fragment f7479v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7480w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7481x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7482y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7483z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7460a = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7464e = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7467h = null;
    public Boolean j = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public t f7478u = new t();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final boolean f7444C = true;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f7449H = true;

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f7484a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f7484a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeBundle(this.f7484a);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Fragment fragment = Fragment.this;
            if (fragment.f7450I != null) {
                fragment.b().getClass();
            }
        }
    }

    public class b extends f {
        public b() {
        }

        @Override // androidx.fragment.app.Fragment.f
        public final void a() {
            Fragment fragment = Fragment.this;
            fragment.f7457Q.a();
            androidx.lifecycle.C.b(fragment);
            Bundle bundle = fragment.f7461b;
            fragment.f7457Q.b(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    public class c extends A0.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f7487b;

        public c(Fragment fragment) {
            super(9);
            this.f7487b = fragment;
        }

        @Override // A0.h
        public final View q(int i9) {
            Fragment fragment = this.f7487b;
            View view = fragment.f7447F;
            if (view != null) {
                return view.findViewById(i9);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a view");
        }

        @Override // A0.h
        public final boolean t() {
            return this.f7487b.f7447F != null;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7491d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7492e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7493f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f7494g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f7495h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Object f7496i;
        public float j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f7497k;
    }

    public static class e extends RuntimeException {
    }

    public static abstract class f {
        public abstract void a();
    }

    public Fragment() {
        new a();
        this.f7454M = AbstractC0544j.b.f7738e;
        this.f7456P = new androidx.lifecycle.s<>();
        new AtomicInteger();
        this.f7458R = new ArrayList<>();
        this.f7459S = new b();
        g();
    }

    public final void A(Bundle bundle) {
        FragmentManager fragmentManager = this.f7477s;
        if (fragmentManager != null && (fragmentManager.f7508G || fragmentManager.f7509H)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f7465f = bundle;
    }

    public A0.h a() {
        return new c(this);
    }

    public final d b() {
        if (this.f7450I == null) {
            d dVar = new d();
            Object obj = f7441T;
            dVar.f7494g = obj;
            dVar.f7495h = obj;
            dVar.f7496i = obj;
            dVar.j = 1.0f;
            dVar.f7497k = null;
            this.f7450I = dVar;
        }
        return this.f7450I;
    }

    public final FragmentManager c() {
        if (this.t != null) {
            return this.f7478u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Context d() {
        g.a aVar = this.t;
        if (aVar == null) {
            return null;
        }
        return aVar.f7630c;
    }

    public final int e() {
        AbstractC0544j.b bVar = this.f7454M;
        return (bVar == AbstractC0544j.b.f7735b || this.f7479v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f7479v.e());
    }

    public final FragmentManager f() {
        FragmentManager fragmentManager = this.f7477s;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final void g() {
        this.f7455N = new androidx.lifecycle.o(this);
        this.f7457Q = new p131r0.c(this);
        ArrayList<f> arrayList = this.f7458R;
        b bVar = this.f7459S;
        if (arrayList.contains(bVar)) {
            return;
        }
        if (this.f7460a >= 0) {
            bVar.a();
        } else {
            arrayList.add(bVar);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0541g
    public final p075k0.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = x().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.J(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + x().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        p075k0.b bVar = new p075k0.b(0);
        LinkedHashMap linkedHashMap = bVar.f19911a;
        if (application != null) {
            linkedHashMap.put(J.f7711a, application);
        }
        linkedHashMap.put(androidx.lifecycle.C.f7691a, this);
        linkedHashMap.put(androidx.lifecycle.C.f7692b, this);
        Bundle bundle = this.f7465f;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.C.f7693c, bundle);
        }
        return bVar;
    }

    @Override // androidx.lifecycle.InterfaceC0548n
    public final AbstractC0544j getLifecycle() {
        return this.f7455N;
    }

    @Override // p131r0.d
    public final p131r0.b getSavedStateRegistry() {
        return this.f7457Q.f21101b;
    }

    @Override // androidx.lifecycle.N
    public final M getViewModelStore() {
        if (this.f7477s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (e() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap<String, M> map = this.f7477s.f7515N.f7647f;
        M m8 = map.get(this.f7464e);
        if (m8 != null) {
            return m8;
        }
        M m9 = new M();
        map.put(this.f7464e, m9);
        return m9;
    }

    public final void h() {
        g();
        this.f7453L = this.f7464e;
        this.f7464e = UUID.randomUUID().toString();
        this.f7469k = false;
        this.f7470l = false;
        this.f7472n = false;
        this.f7473o = false;
        this.f7474p = false;
        this.f7476r = 0;
        this.f7477s = null;
        this.f7478u = new t();
        this.t = null;
        this.f7480w = 0;
        this.f7481x = 0;
        this.f7482y = null;
        this.f7483z = false;
        this.f7442A = false;
    }

    public final boolean i() {
        if (this.f7483z) {
            return true;
        }
        FragmentManager fragmentManager = this.f7477s;
        if (fragmentManager != null) {
            Fragment fragment = this.f7479v;
            fragmentManager.getClass();
            if (fragment == null ? false : fragment.i()) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        return this.f7476r > 0;
    }

    @Deprecated
    public void k() {
        this.f7445D = true;
    }

    @Deprecated
    public void l(int i9, int i10, Intent intent) {
        if (FragmentManager.J(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i9 + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public void m(g gVar) {
        this.f7445D = true;
        g.a aVar = this.t;
        if ((aVar == null ? null : aVar.f7629b) != null) {
            this.f7445D = true;
        }
    }

    public void n(Bundle bundle) {
        Bundle bundle2;
        this.f7445D = true;
        Bundle bundle3 = this.f7461b;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.f7478u.V(bundle2);
            t tVar = this.f7478u;
            tVar.f7508G = false;
            tVar.f7509H = false;
            tVar.f7515N.f7650i = false;
            tVar.u(1);
        }
        t tVar2 = this.f7478u;
        if (tVar2.f7534u >= 1) {
            return;
        }
        tVar2.f7508G = false;
        tVar2.f7509H = false;
        tVar2.f7515N.f7650i = false;
        tVar2.u(1);
    }

    public View o(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f7445D = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        g.a aVar = this.t;
        g gVar = aVar == null ? null : aVar.f7629b;
        if (gVar != null) {
            gVar.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f7445D = true;
    }

    public void p() {
        this.f7445D = true;
    }

    public void q() {
        this.f7445D = true;
    }

    public LayoutInflater r(Bundle bundle) {
        g.a aVar = this.t;
        if (aVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        g gVar = g.this;
        LayoutInflater layoutInflaterCloneInContext = gVar.getLayoutInflater().cloneInContext(gVar);
        layoutInflaterCloneInContext.setFactory2(this.f7478u.f7521f);
        return layoutInflaterCloneInContext;
    }

    public void t() {
        this.f7445D = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f7464e);
        if (this.f7480w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f7480w));
        }
        if (this.f7482y != null) {
            sb.append(" tag=");
            sb.append(this.f7482y);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        this.f7445D = true;
    }

    public void v(Bundle bundle) {
        this.f7445D = true;
    }

    public void w(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7478u.P();
        this.f7475q = true;
        this.O = new y(this, getViewModelStore(), new D6.a(9, this));
        View viewO = o(layoutInflater, viewGroup, bundle);
        this.f7447F = viewO;
        if (viewO == null) {
            if (this.O.f7683d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.O = null;
            return;
        }
        this.O.b();
        if (FragmentManager.J(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.f7447F + " for Fragment " + this);
        }
        p199z2.b.J(this.f7447F, this.O);
        View view = this.f7447F;
        y yVar = this.O;
        kotlin.jvm.internal.k.e(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, yVar);
        p011b4.h.G(this.f7447F, this.O);
        this.f7456P.d(this.O);
    }

    public final Context x() {
        Context contextD = d();
        if (contextD != null) {
            return contextD;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View y() {
        View view = this.f7447F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void z(int i9, int i10, int i11, int i12) {
        if (this.f7450I == null && i9 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        b().f7489b = i9;
        b().f7490c = i10;
        b().f7491d = i11;
        b().f7492e = i12;
    }

    public void s(Bundle bundle) {
    }
}
