package W;

import R3.e;
import T.G;
import T.L;
import T.P;
import T.Q;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SystemBarStateMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0065a f4985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f4986b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public K.b f4987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public K.b f4988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4989e;

    /* JADX INFO: renamed from: W.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SystemBarStateMonitor.java */
    public class C0065a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4990a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0065a(Context context, ViewGroup viewGroup) {
            super(context);
            this.f4990a = viewGroup;
        }

        @Override // android.view.View
        public final void onConfigurationChanged(Configuration configuration) {
            Drawable background = this.f4990a.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            a aVar = a.this;
            if (aVar.f4989e != color) {
                aVar.f4989e = color;
                ArrayList<c> arrayList = aVar.f4986b;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).e();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SystemBarStateMonitor.java */
    public class b extends P.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<P, Integer> f4992b = new HashMap<>();

        public b() {
        }

        @Override // T.P.b
        public final void a(P p8) {
            if ((p8.f4335a.d() & 519) != 0) {
                this.f4992b.remove(p8);
                a aVar = a.this;
                for (int size = aVar.f4986b.size() - 1; size >= 0; size--) {
                    aVar.f4986b.get(size).a();
                }
            }
        }

        @Override // T.P.b
        public final void b(P p8) {
            if ((p8.f4335a.d() & 519) != 0) {
                a aVar = a.this;
                for (int size = aVar.f4986b.size() - 1; size >= 0; size--) {
                    aVar.f4986b.get(size).b();
                }
            }
        }

        @Override // T.P.b
        public final Q c(Q q8, List<P> list) {
            RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
            for (int size = list.size() - 1; size >= 0; size--) {
                P p8 = list.get(size);
                Integer num = this.f4992b.get(p8);
                if (num != null) {
                    int iIntValue = num.intValue();
                    float fA = p8.f4335a.a();
                    if ((iIntValue & 1) != 0) {
                        rectF.left = fA;
                    }
                    if ((iIntValue & 2) != 0) {
                        rectF.top = fA;
                    }
                    if ((iIntValue & 4) != 0) {
                        rectF.right = fA;
                    }
                    if ((iIntValue & 8) != 0) {
                        rectF.bottom = fA;
                    }
                }
            }
            a aVar = a.this;
            aVar.getClass();
            K.b.b(q8.f4366a.h(519), q8.f4366a.h(64));
            ArrayList<c> arrayList = aVar.f4986b;
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                arrayList.get(size2).c();
            }
            return q8;
        }

        @Override // T.P.b
        public final P.a d(P p8, P.a aVar) {
            if ((p8.f4335a.d() & 519) != 0) {
                K.b bVar = aVar.f4337b;
                int i9 = bVar.f2744a;
                K.b bVar2 = aVar.f4336a;
                int i10 = i9 != bVar2.f2744a ? 1 : 0;
                if (bVar.f2745b != bVar2.f2745b) {
                    i10 |= 2;
                }
                if (bVar.f2746c != bVar2.f2746c) {
                    i10 |= 4;
                }
                if (bVar.f2747d != bVar2.f2747d) {
                    i10 |= 8;
                }
                this.f4992b.put(p8, Integer.valueOf(i10));
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: SystemBarStateMonitor.java */
    public interface c {
        void a();

        void b();

        void c();

        void d(K.b bVar, K.b bVar2);

        void e();
    }

    public a(ViewGroup viewGroup) {
        View childAt;
        K.b bVar = K.b.f2743e;
        this.f4987c = bVar;
        this.f4988d = bVar;
        Drawable background = viewGroup.getBackground();
        this.f4989e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        C0065a c0065a = new C0065a(viewGroup.getContext(), viewGroup);
        this.f4985a = c0065a;
        c0065a.setVisibility(8);
        c0065a.setWillNotDraw(true);
        e eVar = new e(3, this);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        G.d.c(c0065a, eVar);
        G.o(c0065a, new b());
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                childAt = null;
                break;
            }
            childAt = viewGroup.getChildAt(childCount);
            if (childAt.isAttachedToWindow() != viewGroup.isAttachedToWindow()) {
                break;
            } else {
                childCount--;
            }
        }
        if (childAt == null) {
            viewGroup.addView(c0065a, 0);
        } else {
            childAt.addOnAttachStateChangeListener(new W.b(viewGroup, c0065a));
        }
    }
}
