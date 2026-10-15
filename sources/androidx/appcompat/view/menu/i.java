package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f6181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6184e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j.a f6187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p097n.d f6188i;
    public a j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6185f = 8388611;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f6189k = new a();

    /* JADX INFO: compiled from: MenuPopupHelper.java */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            i.this.c();
        }
    }

    public i(int i9, Context context, View view, f fVar, boolean z8) {
        this.f6180a = context;
        this.f6181b = fVar;
        this.f6184e = view;
        this.f6182c = z8;
        this.f6183d = i9;
    }

    public final p097n.d a() {
        p097n.d lVar;
        if (this.f6188i == null) {
            Context context = this.f6180a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                lVar = new b(context, this.f6184e, this.f6183d, this.f6182c);
            } else {
                View view = this.f6184e;
                Context context2 = this.f6180a;
                boolean z8 = this.f6182c;
                lVar = new l(this.f6183d, context2, view, this.f6181b, z8);
            }
            lVar.l(this.f6181b);
            lVar.r(this.f6189k);
            lVar.n(this.f6184e);
            lVar.j(this.f6187h);
            lVar.o(this.f6186g);
            lVar.p(this.f6185f);
            this.f6188i = lVar;
        }
        return this.f6188i;
    }

    public final boolean b() {
        p097n.d dVar = this.f6188i;
        return dVar != null && dVar.b();
    }

    public void c() {
        this.f6188i = null;
        a aVar = this.j;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public final void d(int i9, int i10, boolean z8, boolean z9) {
        p097n.d dVarA = a();
        dVarA.s(z9);
        if (z8) {
            if ((Gravity.getAbsoluteGravity(this.f6185f, this.f6184e.getLayoutDirection()) & 7) == 5) {
                i9 -= this.f6184e.getWidth();
            }
            dVarA.q(i9);
            dVarA.t(i10);
            int i11 = (int) ((this.f6180a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            dVarA.f20542a = new Rect(i9 - i11, i10 - i11, i9 + i11, i10 + i11);
        }
        dVarA.d();
    }
}
