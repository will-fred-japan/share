package p164v0;

import A0.h;
import T.G;
import T.L;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.FrameLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Cloneable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<n> f21801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<n> f21802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f[] f21803m;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f21812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f21813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Animator[] f21790y = new Animator[0];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f21791z = {2, 1, 3, 4};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final a f21788A = new a(15);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final ThreadLocal<p155u.a<Animator, b>> f21789B = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21792a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21793b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21794c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f21795d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Integer> f21796e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<View> f21797f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.apm.insight.a f21798g = new com.apm.insight.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.apm.insight.a f21799h = new com.apm.insight.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f21800i = null;
    public final int[] j = f21791z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<Animator> f21804n = new ArrayList<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Animator[] f21805o = f21790y;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21806p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21807q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f21808r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f21809s = null;
    public ArrayList<f> t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<Animator> f21810u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f21811v = f21788A;

    /* JADX INFO: compiled from: Transition.java */
    public class a extends h {
        public final Path w(float f6, float f9, float f10, float f11) {
            Path path = new Path();
            path.moveTo(f6, f9);
            path.lineTo(f10, f11);
            return path;
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f21814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f21816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WindowId f21817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public g f21818e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Animator f21819f;
    }

    /* JADX INFO: compiled from: Transition.java */
    public static abstract class c {
    }

    /* JADX INFO: compiled from: Transition.java */
    public static class d {
        public static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        public static void b(Animator animator, long j) {
            ((AnimatorSet) animator).setCurrentPlayTime(j);
        }
    }

    /* JADX INFO: compiled from: Transition.java */
    public class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f21820a;
    }

    /* JADX INFO: compiled from: Transition.java */
    public interface f {
        default void a(g gVar) {
            g(gVar);
        }

        void b();

        void c();

        default void d(g gVar) {
            e(gVar);
        }

        void e(g gVar);

        void f(g gVar);

        void g(g gVar);
    }

    /* JADX INFO: renamed from: v0.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Transition.java */
    public interface InterfaceC0272g {

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final W5.e f21821g0 = new W5.e(22);

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final W5.f f21822h0 = new W5.f(27);

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final defpackage.f f21823i0 = new defpackage.f(21);

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final W5.e f21824j0 = new W5.e(23);

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final W5.f f21825k0 = new W5.f(28);

        void e(f fVar, g gVar, boolean z8);
    }

    public static void b(com.apm.insight.a aVar, View view, n nVar) {
        ((p155u.a) aVar.f11837a).put(view, nVar);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) aVar.f11838b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            p155u.a aVar2 = (p155u.a) aVar.f11840d;
            if (aVar2.containsKey(transitionName)) {
                aVar2.put(transitionName, null);
            } else {
                aVar2.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                p155u.d dVar = (p155u.d) aVar.f11839c;
                if (dVar.f21647a) {
                    int i9 = dVar.f21650d;
                    long[] jArr = dVar.f21648b;
                    Object[] objArr = dVar.f21649c;
                    int i10 = 0;
                    for (int i11 = 0; i11 < i9; i11++) {
                        Object obj = objArr[i11];
                        if (obj != p155u.e.f21651a) {
                            if (i11 != i10) {
                                jArr[i10] = jArr[i11];
                                objArr[i10] = obj;
                                objArr[i11] = null;
                            }
                            i10++;
                        }
                    }
                    dVar.f21647a = false;
                    dVar.f21650d = i10;
                }
                if (p163v.a.b(dVar.f21648b, dVar.f21650d, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    dVar.d(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) dVar.b(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    dVar.d(itemIdAtPosition, null);
                }
            }
        }
    }

    public static p155u.a<Animator, b> o() {
        ThreadLocal<p155u.a<Animator, b>> threadLocal = f21789B;
        p155u.a<Animator, b> aVar = threadLocal.get();
        if (aVar != null) {
            return aVar;
        }
        p155u.a<Animator, b> aVar2 = new p155u.a<>();
        threadLocal.set(aVar2);
        return aVar2;
    }

    public void A(long j, long j8) {
        long j9 = this.f21812w;
        boolean z8 = j < j8;
        if ((j8 < 0 && j >= 0) || (j8 > j9 && j <= j9)) {
            this.f21808r = false;
            u(this, InterfaceC0272g.f21821g0, z8);
        }
        ArrayList<Animator> arrayList = this.f21804n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f21805o);
        this.f21805o = f21790y;
        for (int i9 = 0; i9 < size; i9++) {
            Animator animator = animatorArr[i9];
            animatorArr[i9] = null;
            d.b(animator, Math.min(Math.max(0L, j), d.a(animator)));
        }
        this.f21805o = animatorArr;
        if ((j <= j9 || j8 > j9) && (j >= 0 || j8 < 0)) {
            return;
        }
        if (j > j9) {
            this.f21808r = true;
        }
        u(this, InterfaceC0272g.f21822h0, z8);
    }

    public void B(long j) {
        this.f21794c = j;
    }

    public void D(TimeInterpolator timeInterpolator) {
        this.f21795d = timeInterpolator;
    }

    public void E(a aVar) {
        if (aVar == null) {
            this.f21811v = f21788A;
        } else {
            this.f21811v = aVar;
        }
    }

    public void H(long j) {
        this.f21793b = j;
    }

    public final void I() {
        if (this.f21806p == 0) {
            u(this, InterfaceC0272g.f21821g0, false);
            this.f21808r = false;
        }
        this.f21806p++;
    }

    public String J(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f21794c != -1) {
            sb.append("dur(");
            sb.append(this.f21794c);
            sb.append(") ");
        }
        if (this.f21793b != -1) {
            sb.append("dly(");
            sb.append(this.f21793b);
            sb.append(") ");
        }
        if (this.f21795d != null) {
            sb.append("interp(");
            sb.append(this.f21795d);
            sb.append(") ");
        }
        ArrayList<Integer> arrayList = this.f21796e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f21797f;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    if (i9 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i9));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i10));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(f fVar) {
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(fVar);
    }

    public abstract void c(n nVar);

    public void cancel() {
        ArrayList<Animator> arrayList = this.f21804n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f21805o);
        this.f21805o = f21790y;
        for (int i9 = size - 1; i9 >= 0; i9--) {
            Animator animator = animatorArr[i9];
            animatorArr[i9] = null;
            animator.cancel();
        }
        this.f21805o = animatorArr;
        u(this, InterfaceC0272g.f21823i0, false);
    }

    public final void d(View view, boolean z8) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            n nVar = new n(view);
            if (z8) {
                f(nVar);
            } else {
                c(nVar);
            }
            nVar.f21847c.add(this);
            e(nVar);
            if (z8) {
                b(this.f21798g, view, nVar);
            } else {
                b(this.f21799h, view, nVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                d(viewGroup.getChildAt(i9), z8);
            }
        }
    }

    public abstract void f(n nVar);

    public final void g(FrameLayout frameLayout, boolean z8) {
        h(z8);
        ArrayList<Integer> arrayList = this.f21796e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f21797f;
        if (size <= 0 && arrayList2.size() <= 0) {
            d(frameLayout, z8);
            return;
        }
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            View viewFindViewById = frameLayout.findViewById(arrayList.get(i9).intValue());
            if (viewFindViewById != null) {
                n nVar = new n(viewFindViewById);
                if (z8) {
                    f(nVar);
                } else {
                    c(nVar);
                }
                nVar.f21847c.add(this);
                e(nVar);
                if (z8) {
                    b(this.f21798g, viewFindViewById, nVar);
                } else {
                    b(this.f21799h, viewFindViewById, nVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = arrayList2.get(i10);
            n nVar2 = new n(view);
            if (z8) {
                f(nVar2);
            } else {
                c(nVar2);
            }
            nVar2.f21847c.add(this);
            e(nVar2);
            if (z8) {
                b(this.f21798g, view, nVar2);
            } else {
                b(this.f21799h, view, nVar2);
            }
        }
    }

    public final void h(boolean z8) {
        if (z8) {
            ((p155u.a) this.f21798g.f11837a).clear();
            ((SparseArray) this.f21798g.f11838b).clear();
            ((p155u.d) this.f21798g.f11839c).a();
        } else {
            ((p155u.a) this.f21799h.f11837a).clear();
            ((SparseArray) this.f21799h.f11838b).clear();
            ((p155u.d) this.f21799h.f11839c).a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.f21810u = new ArrayList<>();
            gVar.f21798g = new com.apm.insight.a();
            gVar.f21799h = new com.apm.insight.a();
            gVar.f21801k = null;
            gVar.f21802l = null;
            gVar.f21809s = this;
            gVar.t = null;
            return gVar;
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public Animator j(FrameLayout frameLayout, n nVar, n nVar2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(FrameLayout frameLayout, com.apm.insight.a aVar, com.apm.insight.a aVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i9;
        int i10;
        View view;
        n nVar;
        Animator animator;
        n nVar2;
        p155u.a<Animator, b> aVarO = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        n().getClass();
        int i11 = 0;
        while (i11 < size) {
            n nVar3 = (n) arrayList.get(i11);
            n nVar4 = (n) arrayList2.get(i11);
            if (nVar3 != null && !nVar3.f21847c.contains(this)) {
                nVar3 = null;
            }
            if (nVar4 != null && !nVar4.f21847c.contains(this)) {
                nVar4 = null;
            }
            if ((nVar3 != null || nVar4 != null) && (nVar3 == null || nVar4 == null || s(nVar3, nVar4))) {
                Animator animatorJ = j(frameLayout, nVar3, nVar4);
                if (animatorJ != null) {
                    String str = this.f21792a;
                    if (nVar4 != null) {
                        String[] strArrP = p();
                        view = nVar4.f21846b;
                        if (strArrP != null && strArrP.length > 0) {
                            nVar2 = new n(view);
                            n nVar5 = (n) ((p155u.a) aVar2.f11837a).get(view);
                            i9 = size;
                            if (nVar5 != null) {
                                int i12 = 0;
                                while (i12 < strArrP.length) {
                                    HashMap map = nVar2.f21845a;
                                    int i13 = i11;
                                    String str2 = strArrP[i12];
                                    map.put(str2, nVar5.f21845a.get(str2));
                                    i12++;
                                    i11 = i13;
                                }
                            }
                            i10 = i11;
                            int i14 = aVarO.f21660c;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    animator = animatorJ;
                                    break;
                                }
                                b bVar = aVarO.get(aVarO.f(i15));
                                if (bVar.f21816c != null && bVar.f21814a == view && bVar.f21815b.equals(str) && bVar.f21816c.equals(nVar2)) {
                                    animator = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i9 = size;
                            i10 = i11;
                            animator = animatorJ;
                            nVar2 = null;
                        }
                        animatorJ = animator;
                        nVar = nVar2;
                    } else {
                        i9 = size;
                        i10 = i11;
                        view = nVar3.f21846b;
                        nVar = null;
                    }
                    if (animatorJ != null) {
                        WindowId windowId = frameLayout.getWindowId();
                        b bVar2 = new b();
                        bVar2.f21814a = view;
                        bVar2.f21815b = str;
                        bVar2.f21816c = nVar;
                        bVar2.f21817d = windowId;
                        bVar2.f21818e = this;
                        bVar2.f21819f = animatorJ;
                        aVarO.put(animatorJ, bVar2);
                        this.f21810u.add(animatorJ);
                    }
                }
                i11 = i10 + 1;
                size = i9;
            }
            i9 = size;
            i10 = i11;
            i11 = i10 + 1;
            size = i9;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                b bVar3 = aVarO.get(this.f21810u.get(sparseIntArray.keyAt(i16)));
                bVar3.f21819f.setStartDelay(bVar3.f21819f.getStartDelay() + (((long) sparseIntArray.valueAt(i16)) - Long.MAX_VALUE));
            }
        }
    }

    public final void l() {
        int i9 = this.f21806p - 1;
        this.f21806p = i9;
        if (i9 == 0) {
            u(this, InterfaceC0272g.f21822h0, false);
            for (int i10 = 0; i10 < ((p155u.d) this.f21798g.f11839c).e(); i10++) {
                View view = (View) ((p155u.d) this.f21798g.f11839c).f(i10);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i11 = 0; i11 < ((p155u.d) this.f21799h.f11839c).e(); i11++) {
                View view2 = (View) ((p155u.d) this.f21799h.f11839c).f(i11);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f21808r = true;
        }
    }

    public final n m(View view, boolean z8) {
        l lVar = this.f21800i;
        if (lVar != null) {
            return lVar.m(view, z8);
        }
        ArrayList<n> arrayList = z8 ? this.f21801k : this.f21802l;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            }
            n nVar = arrayList.get(i9);
            if (nVar == null) {
                return null;
            }
            if (nVar.f21846b == view) {
                break;
            }
            i9++;
        }
        if (i9 >= 0) {
            return (z8 ? this.f21802l : this.f21801k).get(i9);
        }
        return null;
    }

    public final g n() {
        l lVar = this.f21800i;
        return lVar != null ? lVar.n() : this;
    }

    public String[] p() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n q(View view, boolean z8) {
        l lVar = this.f21800i;
        if (lVar != null) {
            return lVar.q(view, z8);
        }
        return (n) ((p155u.a) (z8 ? this.f21798g : this.f21799h).f11837a).get(view);
    }

    public boolean r() {
        return !this.f21804n.isEmpty();
    }

    public boolean s(n nVar, n nVar2) {
        if (nVar != null && nVar2 != null) {
            String[] strArrP = p();
            HashMap map = nVar.f21845a;
            HashMap map2 = nVar2.f21845a;
            if (strArrP != null) {
                for (String str : strArrP) {
                    Object obj = map.get(str);
                    Object obj2 = map2.get(str);
                    if ((obj == null && obj2 == null) ? false : (obj == null || obj2 == null) ? true : !obj.equals(obj2)) {
                        return true;
                    }
                }
            } else {
                for (String str2 : map.keySet()) {
                    Object obj3 = map.get(str2);
                    Object obj4 = map2.get(str2);
                    if ((obj3 == null && obj4 == null) ? false : (obj3 == null || obj4 == null) ? true : !obj3.equals(obj4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f21796e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f21797f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return J("");
    }

    public final void u(g gVar, InterfaceC0272g interfaceC0272g, boolean z8) {
        g gVar2 = this.f21809s;
        if (gVar2 != null) {
            gVar2.u(gVar, interfaceC0272g, z8);
        }
        ArrayList<f> arrayList = this.t;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.t.size();
        f[] fVarArr = this.f21803m;
        if (fVarArr == null) {
            fVarArr = new f[size];
        }
        this.f21803m = null;
        f[] fVarArr2 = (f[]) this.t.toArray(fVarArr);
        for (int i9 = 0; i9 < size; i9++) {
            interfaceC0272g.e(fVarArr2[i9], gVar, z8);
            fVarArr2[i9] = null;
        }
        this.f21803m = fVarArr2;
    }

    public void v(ViewGroup viewGroup) {
        if (this.f21808r) {
            return;
        }
        ArrayList<Animator> arrayList = this.f21804n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f21805o);
        this.f21805o = f21790y;
        for (int i9 = size - 1; i9 >= 0; i9--) {
            Animator animator = animatorArr[i9];
            animatorArr[i9] = null;
            animator.pause();
        }
        this.f21805o = animatorArr;
        u(this, InterfaceC0272g.f21824j0, false);
        this.f21807q = true;
    }

    public void w() {
        p155u.a<Animator, b> aVarO = o();
        this.f21812w = 0L;
        for (int i9 = 0; i9 < this.f21810u.size(); i9++) {
            Animator animator = this.f21810u.get(i9);
            b bVar = aVarO.get(animator);
            if (animator != null && bVar != null) {
                long j = this.f21794c;
                Animator animator2 = bVar.f21819f;
                if (j >= 0) {
                    animator2.setDuration(j);
                }
                long j8 = this.f21793b;
                if (j8 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j8);
                }
                TimeInterpolator timeInterpolator = this.f21795d;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.f21804n.add(animator);
                this.f21812w = Math.max(this.f21812w, d.a(animator));
            }
        }
        this.f21810u.clear();
    }

    public g x(f fVar) {
        g gVar;
        ArrayList<f> arrayList = this.t;
        if (arrayList != null) {
            if (!arrayList.remove(fVar) && (gVar = this.f21809s) != null) {
                gVar.x(fVar);
            }
            if (this.t.size() == 0) {
                this.t = null;
            }
        }
        return this;
    }

    public void y(FrameLayout frameLayout) {
        if (this.f21807q) {
            if (!this.f21808r) {
                ArrayList<Animator> arrayList = this.f21804n;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f21805o);
                this.f21805o = f21790y;
                for (int i9 = size - 1; i9 >= 0; i9--) {
                    Animator animator = animatorArr[i9];
                    animatorArr[i9] = null;
                    animator.resume();
                }
                this.f21805o = animatorArr;
                u(this, InterfaceC0272g.f21825k0, false);
            }
            this.f21807q = false;
        }
    }

    public void z() {
        I();
        p155u.a<Animator, b> aVarO = o();
        for (Animator animator : this.f21810u) {
            if (aVarO.containsKey(animator)) {
                I();
                if (animator != null) {
                    animator.addListener(new h(this, aVarO));
                    long j = this.f21794c;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j8 = this.f21793b;
                    if (j8 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j8);
                    }
                    TimeInterpolator timeInterpolator = this.f21795d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new i(this));
                    animator.start();
                }
            }
        }
        this.f21810u.clear();
        l();
    }

    public void F() {
    }

    public void C(c cVar) {
    }

    public void e(n nVar) {
    }
}
