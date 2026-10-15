package p164v0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.HashMap;

/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends p164v0.g {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final String[] f21771C = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final a f21772D = new a(PointF.class, "topLeft");

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final C0271b f21773E = new C0271b(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final c f21774F = new c(PointF.class, "bottomRight");

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final d f21775G = new d(PointF.class, "topLeft");

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final e f21776H = new e(PointF.class, "position");

    /* JADX INFO: compiled from: ChangeBounds.java */
    public class a extends Property<g, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(g gVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(g gVar, PointF pointF) {
            g gVar2 = gVar;
            PointF pointF2 = pointF;
            gVar2.getClass();
            gVar2.f21779a = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            gVar2.f21780b = iRound;
            int i9 = gVar2.f21784f + 1;
            gVar2.f21784f = i9;
            if (i9 == gVar2.f21785g) {
                p.a(gVar2.f21783e, gVar2.f21779a, iRound, gVar2.f21781c, gVar2.f21782d);
                gVar2.f21784f = 0;
                gVar2.f21785g = 0;
            }
        }
    }

    /* JADX INFO: renamed from: v0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChangeBounds.java */
    public class C0271b extends Property<g, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(g gVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(g gVar, PointF pointF) {
            g gVar2 = gVar;
            PointF pointF2 = pointF;
            gVar2.getClass();
            gVar2.f21781c = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            gVar2.f21782d = iRound;
            int i9 = gVar2.f21785g + 1;
            gVar2.f21785g = i9;
            if (gVar2.f21784f == i9) {
                p.a(gVar2.f21783e, gVar2.f21779a, gVar2.f21780b, gVar2.f21781c, iRound);
                gVar2.f21784f = 0;
                gVar2.f21785g = 0;
            }
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    public class c extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            p.a(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    public class d extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            p.a(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    public class e extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            p.a(view2, iRound, iRound2, view2.getWidth() + iRound, view2.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    public static class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21777a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f21778b;

        public f(ViewGroup viewGroup) {
            this.f21778b = viewGroup;
        }

        @Override // p164v0.j, v0.g.f
        public final void b() {
            o.a(this.f21778b, false);
        }

        @Override // p164v0.j, v0.g.f
        public final void c() {
            o.a(this.f21778b, true);
        }

        @Override // p164v0.j, v0.g.f
        public final void e(p164v0.g gVar) {
            if (!this.f21777a) {
                o.a(this.f21778b, false);
            }
            gVar.x(this);
        }

        @Override // p164v0.j, v0.g.f
        public final void f(p164v0.g gVar) {
            o.a(this.f21778b, false);
            this.f21777a = true;
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f21783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f21785g;

        public g(View view) {
            this.f21783e = view;
        }
    }

    public static void K(n nVar) {
        View view = nVar.f21846b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = nVar.f21845a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", nVar.f21846b.getParent());
    }

    @Override // p164v0.g
    public final void c(n nVar) {
        K(nVar);
    }

    @Override // p164v0.g
    public final void f(n nVar) {
        K(nVar);
    }

    @Override // p164v0.g
    public final Animator j(FrameLayout frameLayout, n nVar, n nVar2) {
        int i9;
        b bVar;
        Animator animatorA;
        if (nVar != null && nVar2 != null) {
            HashMap map = nVar.f21845a;
            HashMap map2 = nVar2.f21845a;
            ViewGroup viewGroup = (ViewGroup) map.get("android:changeBounds:parent");
            ViewGroup viewGroup2 = (ViewGroup) map2.get("android:changeBounds:parent");
            if (viewGroup != null && viewGroup2 != null) {
                Rect rect = (Rect) map.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                int i10 = rect.left;
                int i11 = rect2.left;
                int i12 = rect.top;
                int i13 = rect2.top;
                int i14 = rect.right;
                int i15 = rect2.right;
                int i16 = rect.bottom;
                int i17 = rect2.bottom;
                int i18 = i14 - i10;
                int i19 = i16 - i12;
                int i20 = i15 - i11;
                int i21 = i17 - i13;
                Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                if ((i18 == 0 || i19 == 0) && (i20 == 0 || i21 == 0)) {
                    i9 = 0;
                } else {
                    i9 = (i10 == i11 && i12 == i13) ? 0 : 1;
                    if (i14 != i15 || i16 != i17) {
                        i9++;
                    }
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    i9++;
                }
                if (i9 > 0) {
                    View view = nVar2.f21846b;
                    p.a(view, i10, i12, i14, i16);
                    if (i9 != 2) {
                        bVar = this;
                        animatorA = (i10 == i11 && i12 == i13) ? p164v0.e.a(view, f21774F, bVar.f21811v.w(i14, i16, i15, i17)) : p164v0.e.a(view, f21775G, bVar.f21811v.w(i10, i12, i11, i13));
                    } else if (i18 == i20 && i19 == i21) {
                        bVar = this;
                        animatorA = p164v0.e.a(view, f21776H, bVar.f21811v.w(i10, i12, i11, i13));
                    } else {
                        bVar = this;
                        g gVar = new g(view);
                        ObjectAnimator objectAnimatorA = p164v0.e.a(gVar, f21772D, bVar.f21811v.w(i10, i12, i11, i13));
                        ObjectAnimator objectAnimatorA2 = p164v0.e.a(gVar, f21773E, bVar.f21811v.w(i14, i16, i15, i17));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                        animatorSet.addListener(new p164v0.c(gVar));
                        animatorA = animatorSet;
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                        o.a(viewGroup3, true);
                        bVar.n().a(new f(viewGroup3));
                    }
                    return animatorA;
                }
            }
        }
        return null;
    }

    @Override // p164v0.g
    public final String[] p() {
        return f21771C;
    }
}
