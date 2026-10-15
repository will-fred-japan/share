package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LifecycleRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o extends AbstractC0544j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p113p.a<InterfaceC0547m, a> f7742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC0544j.b f7743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<InterfaceC0548n> f7744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<AbstractC0544j.b> f7748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final V7.s f7749i;

    /* JADX INFO: compiled from: LifecycleRegistry.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC0544j.b f7750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0546l f7751b;

        public final void a(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
            AbstractC0544j.b bVarA = aVar.a();
            AbstractC0544j.b state1 = this.f7750a;
            kotlin.jvm.internal.k.e(state1, "state1");
            if (bVarA.compareTo(state1) < 0) {
                state1 = bVarA;
            }
            this.f7750a = state1;
            this.f7751b.d(interfaceC0548n, aVar);
            this.f7750a = bVarA;
        }
    }

    public o(InterfaceC0548n interfaceC0548n) {
        new AtomicReference();
        this.f7741a = true;
        this.f7742b = new p113p.a<>();
        AbstractC0544j.b bVar = AbstractC0544j.b.f7735b;
        this.f7743c = bVar;
        this.f7748h = new ArrayList<>();
        this.f7744d = new WeakReference<>(interfaceC0548n);
        this.f7749i = new V7.s(bVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.lifecycle.AbstractC0544j
    public final void a(InterfaceC0547m observer) {
        InterfaceC0546l wVar;
        a aVar;
        InterfaceC0548n interfaceC0548n;
        AbstractC0544j.a aVar2;
        ArrayList<AbstractC0544j.b> arrayList = this.f7748h;
        kotlin.jvm.internal.k.e(observer, "observer");
        e("addObserver");
        AbstractC0544j.b bVar = this.f7743c;
        AbstractC0544j.b bVar2 = AbstractC0544j.b.f7734a;
        if (bVar != bVar2) {
            bVar2 = AbstractC0544j.b.f7735b;
        }
        a aVar3 = new a();
        HashMap map = q.f7752a;
        boolean z8 = observer instanceof InterfaceC0546l;
        boolean z9 = observer instanceof DefaultLifecycleObserver;
        if (z8 && z9) {
            wVar = new C0538d((DefaultLifecycleObserver) observer, (InterfaceC0546l) observer);
        } else if (z9) {
            wVar = new C0538d((DefaultLifecycleObserver) observer, null);
        } else if (z8) {
            wVar = (InterfaceC0546l) observer;
        } else {
            Class<?> cls = observer.getClass();
            if (q.b(cls) == 2) {
                Object obj = q.f7753b.get(cls);
                kotlin.jvm.internal.k.b(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    wVar = new H(q.a((Constructor) list.get(0), observer));
                } else {
                    int size = list.size();
                    InterfaceC0540f[] interfaceC0540fArr = new InterfaceC0540f[size];
                    for (int i9 = 0; i9 < size; i9++) {
                        interfaceC0540fArr[i9] = q.a((Constructor) list.get(i9), observer);
                    }
                    wVar = new C0537c(interfaceC0540fArr);
                }
            } else {
                wVar = new w(observer);
            }
        }
        aVar3.f7751b = wVar;
        aVar3.f7750a = bVar2;
        p113p.a<InterfaceC0547m, a> aVar4 = this.f7742b;
        p.b.c<InterfaceC0547m, a> cVarF = aVar4.f(observer);
        if (cVarF != null) {
            aVar = cVarF.f20742b;
        } else {
            HashMap<K, p.b.c<K, V>> map2 = aVar4.f20736e;
            p.b.c<K, V> cVar = new p.b.c<>(observer, aVar3);
            aVar4.f20740d++;
            p.b.c<K, V> cVar2 = aVar4.f20738b;
            if (cVar2 == 0) {
                aVar4.f20737a = cVar;
                aVar4.f20738b = cVar;
            } else {
                cVar2.f20743c = cVar;
                cVar.f20744d = cVar2;
                aVar4.f20738b = cVar;
            }
            map2.put((K) observer, cVar);
            aVar = null;
        }
        if (aVar == null && (interfaceC0548n = this.f7744d.get()) != null) {
            boolean z10 = this.f7745e != 0 || this.f7746f;
            AbstractC0544j.b bVarD = d(observer);
            this.f7745e++;
            while (aVar3.f7750a.compareTo(bVarD) < 0 && this.f7742b.f20736e.containsKey(observer)) {
                arrayList.add(aVar3.f7750a);
                AbstractC0544j.a.C0108a c0108a = AbstractC0544j.a.Companion;
                AbstractC0544j.b state = aVar3.f7750a;
                c0108a.getClass();
                kotlin.jvm.internal.k.e(state, "state");
                int iOrdinal = state.ordinal();
                if (iOrdinal == 1) {
                    aVar2 = AbstractC0544j.a.ON_CREATE;
                } else if (iOrdinal != 2) {
                    aVar2 = iOrdinal != 3 ? null : AbstractC0544j.a.ON_RESUME;
                } else {
                    aVar2 = AbstractC0544j.a.ON_START;
                }
                if (aVar2 == null) {
                    throw new IllegalStateException("no event up from " + aVar3.f7750a);
                }
                aVar3.a(interfaceC0548n, aVar2);
                arrayList.remove(arrayList.size() - 1);
                bVarD = d(observer);
            }
            if (!z10) {
                i();
            }
            this.f7745e--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0544j
    public final AbstractC0544j.b b() {
        return this.f7743c;
    }

    @Override // androidx.lifecycle.AbstractC0544j
    public final void c(InterfaceC0547m observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        e("removeObserver");
        this.f7742b.g(observer);
    }

    public final AbstractC0544j.b d(InterfaceC0547m interfaceC0547m) {
        a aVar;
        HashMap<InterfaceC0547m, p.b.c<InterfaceC0547m, a>> map = this.f7742b.f20736e;
        p.b.c<InterfaceC0547m, a> cVar = map.containsKey(interfaceC0547m) ? map.get(interfaceC0547m).f20744d : null;
        AbstractC0544j.b bVar = (cVar == null || (aVar = cVar.f20742b) == null) ? null : aVar.f7750a;
        ArrayList<AbstractC0544j.b> arrayList = this.f7748h;
        AbstractC0544j.b bVar2 = arrayList.isEmpty() ? null : arrayList.get(arrayList.size() - 1);
        AbstractC0544j.b state1 = this.f7743c;
        kotlin.jvm.internal.k.e(state1, "state1");
        if (bVar == null || bVar.compareTo(state1) >= 0) {
            bVar = state1;
        }
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @SuppressLint({"RestrictedApi"})
    public final void e(String str) {
        if (this.f7741a) {
            o.a.w().f20621b.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(A.a.i("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(AbstractC0544j.a event) {
        kotlin.jvm.internal.k.e(event, "event");
        e("handleLifecycleEvent");
        g(event.a());
    }

    public final void g(AbstractC0544j.b bVar) {
        AbstractC0544j.b bVar2 = this.f7743c;
        if (bVar2 == bVar) {
            return;
        }
        AbstractC0544j.b bVar3 = AbstractC0544j.b.f7735b;
        AbstractC0544j.b bVar4 = AbstractC0544j.b.f7734a;
        if (bVar2 == bVar3 && bVar == bVar4) {
            throw new IllegalStateException(("no event down from " + this.f7743c + " in component " + this.f7744d.get()).toString());
        }
        this.f7743c = bVar;
        if (this.f7746f || this.f7745e != 0) {
            this.f7747g = true;
            return;
        }
        this.f7746f = true;
        i();
        this.f7746f = false;
        if (this.f7743c == bVar4) {
            this.f7742b = new p113p.a<>();
        }
    }

    public final void h(AbstractC0544j.b state) {
        kotlin.jvm.internal.k.e(state, "state");
        e("setCurrentState");
        g(state);
    }

    public final void i() {
        AbstractC0544j.a aVar;
        AbstractC0544j.a aVar2;
        InterfaceC0548n interfaceC0548n = this.f7744d.get();
        if (interfaceC0548n == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            p113p.a<InterfaceC0547m, a> aVar3 = this.f7742b;
            if (aVar3.f20740d != 0) {
                p.b.c<InterfaceC0547m, a> cVar = aVar3.f20737a;
                kotlin.jvm.internal.k.b(cVar);
                AbstractC0544j.b bVar = cVar.f20742b.f7750a;
                p.b.c<InterfaceC0547m, a> cVar2 = this.f7742b.f20738b;
                kotlin.jvm.internal.k.b(cVar2);
                AbstractC0544j.b bVar2 = cVar2.f20742b.f7750a;
                if (bVar == bVar2 && this.f7743c == bVar2) {
                    break;
                }
                this.f7747g = false;
                AbstractC0544j.b bVar3 = this.f7743c;
                p.b.c<InterfaceC0547m, a> cVar3 = this.f7742b.f20737a;
                kotlin.jvm.internal.k.b(cVar3);
                if (bVar3.compareTo(cVar3.f20742b.f7750a) < 0) {
                    p113p.a<InterfaceC0547m, a> aVar4 = this.f7742b;
                    p113p.b.C0242b c0242b = new p113p.b.C0242b(aVar4.f20738b, aVar4.f20737a);
                    aVar4.f20739c.put(c0242b, Boolean.FALSE);
                    while (c0242b.hasNext() && !this.f7747g) {
                        Map.Entry entry = (Map.Entry) c0242b.next();
                        kotlin.jvm.internal.k.d(entry, "next()");
                        InterfaceC0547m interfaceC0547m = (InterfaceC0547m) entry.getKey();
                        a aVar5 = (a) entry.getValue();
                        while (aVar5.f7750a.compareTo(this.f7743c) > 0 && !this.f7747g && this.f7742b.f20736e.containsKey(interfaceC0547m)) {
                            AbstractC0544j.a.C0108a c0108a = AbstractC0544j.a.Companion;
                            AbstractC0544j.b state = aVar5.f7750a;
                            c0108a.getClass();
                            kotlin.jvm.internal.k.e(state, "state");
                            int iOrdinal = state.ordinal();
                            if (iOrdinal == 2) {
                                aVar2 = AbstractC0544j.a.ON_DESTROY;
                            } else if (iOrdinal != 3) {
                                aVar2 = iOrdinal != 4 ? null : AbstractC0544j.a.ON_PAUSE;
                            } else {
                                aVar2 = AbstractC0544j.a.ON_STOP;
                            }
                            if (aVar2 == null) {
                                throw new IllegalStateException("no event down from " + aVar5.f7750a);
                            }
                            this.f7748h.add(aVar2.a());
                            aVar5.a(interfaceC0548n, aVar2);
                            ArrayList<AbstractC0544j.b> arrayList = this.f7748h;
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
                p.b.c<InterfaceC0547m, a> cVar4 = this.f7742b.f20738b;
                if (!this.f7747g && cVar4 != null && this.f7743c.compareTo(cVar4.f20742b.f7750a) > 0) {
                    p113p.a<InterfaceC0547m, a> aVar6 = this.f7742b;
                    aVar6.getClass();
                    p.b.d dVar = new p.b.d();
                    aVar6.f20739c.put(dVar, Boolean.FALSE);
                    while (dVar.hasNext() && !this.f7747g) {
                        Map.Entry entry2 = (Map.Entry) dVar.next();
                        InterfaceC0547m interfaceC0547m2 = (InterfaceC0547m) entry2.getKey();
                        a aVar7 = (a) entry2.getValue();
                        while (aVar7.f7750a.compareTo(this.f7743c) < 0 && !this.f7747g && this.f7742b.f20736e.containsKey(interfaceC0547m2)) {
                            this.f7748h.add(aVar7.f7750a);
                            AbstractC0544j.a.C0108a c0108a2 = AbstractC0544j.a.Companion;
                            AbstractC0544j.b state2 = aVar7.f7750a;
                            c0108a2.getClass();
                            kotlin.jvm.internal.k.e(state2, "state");
                            int iOrdinal2 = state2.ordinal();
                            if (iOrdinal2 == 1) {
                                aVar = AbstractC0544j.a.ON_CREATE;
                            } else if (iOrdinal2 != 2) {
                                aVar = iOrdinal2 != 3 ? null : AbstractC0544j.a.ON_RESUME;
                            } else {
                                aVar = AbstractC0544j.a.ON_START;
                            }
                            if (aVar == null) {
                                throw new IllegalStateException("no event up from " + aVar7.f7750a);
                            }
                            aVar7.a(interfaceC0548n, aVar);
                            ArrayList<AbstractC0544j.b> arrayList2 = this.f7748h;
                            arrayList2.remove(arrayList2.size() - 1);
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.f7747g = false;
        this.f7749i.setValue(this.f7743c);
    }
}
