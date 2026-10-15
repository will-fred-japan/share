package androidx.fragment.app;

import androidx.lifecycle.AbstractC0544j;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransaction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f7657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7665i;
    public CharSequence j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<String> f7668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<String> f7669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7670o;

    /* JADX INFO: compiled from: FragmentTransaction.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f7672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7675e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7676f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7677g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbstractC0544j.b f7678h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AbstractC0544j.b f7679i;

        public a() {
        }

        public a(int i9, Fragment fragment) {
            this.f7671a = i9;
            this.f7672b = fragment;
            this.f7673c = false;
            AbstractC0544j.b bVar = AbstractC0544j.b.f7738e;
            this.f7678h = bVar;
            this.f7679i = bVar;
        }

        public a(int i9, Fragment fragment, int i10) {
            this.f7671a = i9;
            this.f7672b = fragment;
            this.f7673c = true;
            AbstractC0544j.b bVar = AbstractC0544j.b.f7738e;
            this.f7678h = bVar;
            this.f7679i = bVar;
        }
    }

    public final void b(a aVar) {
        this.f7657a.add(aVar);
        aVar.f7674d = this.f7658b;
        aVar.f7675e = this.f7659c;
        aVar.f7676f = this.f7660d;
        aVar.f7677g = this.f7661e;
    }
}
