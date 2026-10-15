package p164v0;

import android.animation.TimeInterpolator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionSet.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends g {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f21838E;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public ArrayList<g> f21836C = new ArrayList<>();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f21837D = true;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f21839F = false;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f21840G = 0;

    /* JADX INFO: compiled from: TransitionSet.java */
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f21841a;

        public a(g gVar) {
            this.f21841a = gVar;
        }

        @Override // p164v0.j, v0.g.f
        public final void e(g gVar) {
            this.f21841a.z();
            gVar.x(this);
        }
    }

    /* JADX INFO: compiled from: TransitionSet.java */
    public class b extends j {
        public b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p164v0.j, v0.g.f
        public final void f(g gVar) {
            l lVar = l.this;
            lVar.f21836C.remove(gVar);
            if (lVar.r()) {
                return;
            }
            lVar.u(lVar, g.InterfaceC0272g.f21823i0, false);
            lVar.f21808r = true;
            lVar.u(lVar, g.InterfaceC0272g.f21822h0, false);
        }
    }

    /* JADX INFO: compiled from: TransitionSet.java */
    public static class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f21843a;

        @Override // p164v0.j, v0.g.f
        public final void e(g gVar) {
            l lVar = this.f21843a;
            int i9 = lVar.f21838E - 1;
            lVar.f21838E = i9;
            if (i9 == 0) {
                lVar.f21839F = false;
                lVar.l();
            }
            gVar.x(this);
        }

        @Override // p164v0.j, v0.g.f
        public final void g(g gVar) {
            l lVar = this.f21843a;
            if (lVar.f21839F) {
                return;
            }
            lVar.I();
            lVar.f21839F = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // p164v0.g
    public final void A(long j, long j8) {
        long j9;
        long j10 = this.f21812w;
        long j11 = 0;
        if (this.f21800i != null) {
            if (j < 0 && j8 < 0) {
                return;
            }
            if (j > j10 && j8 > j10) {
                return;
            }
        }
        boolean z8 = j < j8;
        if ((j >= 0 && j8 < 0) || (j <= j10 && j8 > j10)) {
            this.f21808r = false;
            u(this, g.InterfaceC0272g.f21821g0, z8);
        }
        if (!this.f21837D) {
            int size = 1;
            while (true) {
                if (size >= this.f21836C.size()) {
                    size = this.f21836C.size();
                    break;
                } else if (this.f21836C.get(size).f21813x > j8) {
                    break;
                } else {
                    size++;
                }
            }
            int i9 = size - 1;
            if (j >= j8) {
                while (true) {
                    if (i9 < this.f21836C.size()) {
                        g gVar = this.f21836C.get(i9);
                        long j12 = gVar.f21813x;
                        j9 = j11;
                        long j13 = j - j12;
                        if (j13 < j9) {
                            break;
                        }
                        gVar.A(j13, j8 - j12);
                        i9++;
                        j11 = j9;
                    }
                }
            } else {
                j9 = 0;
                while (i9 >= 0) {
                    g gVar2 = this.f21836C.get(i9);
                    long j14 = gVar2.f21813x;
                    long j15 = j - j14;
                    gVar2.A(j15, j8 - j14);
                    if (j15 >= 0) {
                        break;
                    } else {
                        i9--;
                    }
                }
            }
            if (this.f21800i != null) {
                if ((j > j10 || j8 > j10) && (j >= 0 || j8 < j9)) {
                    return;
                }
                if (j > j10) {
                    this.f21808r = true;
                }
                u(this, g.InterfaceC0272g.f21822h0, z8);
            }
        }
        for (int i10 = 0; i10 < this.f21836C.size(); i10++) {
            this.f21836C.get(i10).A(j, j8);
        }
        j9 = j11;
        if (this.f21800i != null) {
            if (j > j10) {
                return;
            } else {
                return;
            }
            if (j > j10) {
                this.f21808r = true;
            }
            u(this, g.InterfaceC0272g.f21822h0, z8);
        }
    }

    @Override // p164v0.g
    public final void B(long j) {
        ArrayList<g> arrayList;
        this.f21794c = j;
        if (j < 0 || (arrayList = this.f21836C) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).B(j);
        }
    }

    @Override // p164v0.g
    public final void C(g.c cVar) {
        this.f21840G |= 8;
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).C(cVar);
        }
    }

    @Override // p164v0.g
    public final void D(TimeInterpolator timeInterpolator) {
        this.f21840G |= 1;
        ArrayList<g> arrayList = this.f21836C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                this.f21836C.get(i9).D(timeInterpolator);
            }
        }
        this.f21795d = timeInterpolator;
    }

    @Override // p164v0.g
    public final void E(g.a aVar) {
        super.E(aVar);
        this.f21840G |= 4;
        if (this.f21836C != null) {
            for (int i9 = 0; i9 < this.f21836C.size(); i9++) {
                this.f21836C.get(i9).E(aVar);
            }
        }
    }

    @Override // p164v0.g
    public final void F() {
        this.f21840G |= 2;
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).F();
        }
    }

    @Override // p164v0.g
    public final void H(long j) {
        this.f21793b = j;
    }

    @Override // p164v0.g
    public final String J(String str) {
        String strJ = super.J(str);
        for (int i9 = 0; i9 < this.f21836C.size(); i9++) {
            StringBuilder sbC = p171w.a.c(strJ, "\n");
            sbC.append(this.f21836C.get(i9).J(str + "  "));
            strJ = sbC.toString();
        }
        return strJ;
    }

    public final void K(g gVar) {
        this.f21836C.add(gVar);
        gVar.f21800i = this;
        long j = this.f21794c;
        if (j >= 0) {
            gVar.B(j);
        }
        if ((this.f21840G & 1) != 0) {
            gVar.D(this.f21795d);
        }
        if ((this.f21840G & 2) != 0) {
            gVar.F();
        }
        if ((this.f21840G & 4) != 0) {
            gVar.E(this.f21811v);
        }
        if ((this.f21840G & 8) != 0) {
            gVar.C(null);
        }
    }

    @Override // p164v0.g
    public final void c(n nVar) {
        if (t(nVar.f21846b)) {
            for (g gVar : this.f21836C) {
                if (gVar.t(nVar.f21846b)) {
                    gVar.c(nVar);
                    nVar.f21847c.add(gVar);
                }
            }
        }
    }

    @Override // p164v0.g
    public final void cancel() {
        super.cancel();
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).cancel();
        }
    }

    @Override // p164v0.g
    public final void e(n nVar) {
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).e(nVar);
        }
    }

    @Override // p164v0.g
    public final void f(n nVar) {
        if (t(nVar.f21846b)) {
            for (g gVar : this.f21836C) {
                if (gVar.t(nVar.f21846b)) {
                    gVar.f(nVar);
                    nVar.f21847c.add(gVar);
                }
            }
        }
    }

    @Override // p164v0.g
    /* JADX INFO: renamed from: i */
    public final g clone() {
        l lVar = (l) super.clone();
        lVar.f21836C = new ArrayList<>();
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            g gVarClone = this.f21836C.get(i9).clone();
            lVar.f21836C.add(gVarClone);
            gVarClone.f21800i = lVar;
        }
        return lVar;
    }

    @Override // p164v0.g
    public final void k(FrameLayout frameLayout, com.apm.insight.a aVar, com.apm.insight.a aVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.f21793b;
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            g gVar = this.f21836C.get(i9);
            if (j > 0 && (this.f21837D || i9 == 0)) {
                long j8 = gVar.f21793b;
                if (j8 > 0) {
                    gVar.H(j8 + j);
                } else {
                    gVar.H(j);
                }
            }
            gVar.k(frameLayout, aVar, aVar2, arrayList, arrayList2);
        }
    }

    @Override // p164v0.g
    public final boolean r() {
        for (int i9 = 0; i9 < this.f21836C.size(); i9++) {
            if (this.f21836C.get(i9).r()) {
                return true;
            }
        }
        return false;
    }

    @Override // p164v0.g
    public final void v(ViewGroup viewGroup) {
        super.v(viewGroup);
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).v(viewGroup);
        }
    }

    @Override // p164v0.g
    public final void w() {
        this.f21812w = 0L;
        b bVar = new b();
        for (int i9 = 0; i9 < this.f21836C.size(); i9++) {
            g gVar = this.f21836C.get(i9);
            gVar.a(bVar);
            gVar.w();
            long j = gVar.f21812w;
            if (this.f21837D) {
                this.f21812w = Math.max(this.f21812w, j);
            } else {
                long j8 = this.f21812w;
                gVar.f21813x = j8;
                this.f21812w = j8 + j;
            }
        }
    }

    @Override // p164v0.g
    public final g x(g.f fVar) {
        super.x(fVar);
        return this;
    }

    @Override // p164v0.g
    public final void y(FrameLayout frameLayout) {
        super.y(frameLayout);
        int size = this.f21836C.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f21836C.get(i9).y(frameLayout);
        }
    }

    @Override // p164v0.g
    public final void z() {
        if (this.f21836C.isEmpty()) {
            I();
            l();
            return;
        }
        c cVar = new c();
        cVar.f21843a = this;
        Iterator<g> it = this.f21836C.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
        this.f21838E = this.f21836C.size();
        if (this.f21837D) {
            Iterator<g> it2 = this.f21836C.iterator();
            while (it2.hasNext()) {
                it2.next().z();
            }
            return;
        }
        for (int i9 = 1; i9 < this.f21836C.size(); i9++) {
            this.f21836C.get(i9 - 1).a(new a(this.f21836C.get(i9)));
        }
        g gVar = this.f21836C.get(0);
        if (gVar != null) {
            gVar.z();
        }
    }
}
