package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: LinearSmoothScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends RecyclerView.u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f8318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f8319l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f8321n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f8317i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8320m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8322o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8323p = 0;

    public o(Context context) {
        this.f8319l = context.getResources().getDisplayMetrics();
    }

    public static int e(int i9, int i10, int i11, int i12, int i13) {
        if (i13 == -1) {
            return i11 - i9;
        }
        if (i13 != 0) {
            if (i13 == 1) {
                return i12 - i10;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i14 = i11 - i9;
        if (i14 > 0) {
            return i14;
        }
        int i15 = i12 - i10;
        if (i15 < 0) {
            return i15;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    @Override // androidx.recyclerview.widget.RecyclerView.u
    public void c(View view, RecyclerView.u.a aVar) {
        int i9;
        PointF pointF = this.f8318k;
        int i10 = 0;
        if (pointF != null) {
            float f6 = pointF.x;
            if (f6 == 0.0f) {
                i9 = 0;
            } else {
                i9 = f6 > 0.0f ? 1 : -1;
            }
        } else {
            i9 = 0;
        }
        int iF = f(view, i9);
        PointF pointF2 = this.f8318k;
        if (pointF2 != null) {
            float f9 = pointF2.y;
            if (f9 != 0.0f) {
                i10 = f9 > 0.0f ? 1 : -1;
            }
        }
        int iG = g(view, i10);
        int iCeil = (int) Math.ceil(((double) i((int) Math.sqrt((iG * iG) + (iF * iF)))) / 0.3356d);
        if (iCeil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.j;
            aVar.f8101a = -iF;
            aVar.f8102b = -iG;
            aVar.f8103c = iCeil;
            aVar.f8105e = decelerateInterpolator;
            aVar.f8106f = true;
        }
    }

    public int f(View view, int i9) {
        RecyclerView.l lVar = this.f8095c;
        if (lVar == null || !lVar.d()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e((view.getLeft() - ((RecyclerView.m) view.getLayoutParams()).f8075b.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, view.getRight() + ((RecyclerView.m) view.getLayoutParams()).f8075b.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, lVar.E(), lVar.f8066n - lVar.F(), i9);
    }

    public int g(View view, int i9) {
        RecyclerView.l lVar = this.f8095c;
        if (lVar == null || !lVar.e()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e((view.getTop() - ((RecyclerView.m) view.getLayoutParams()).f8075b.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getBottom() + ((RecyclerView.m) view.getLayoutParams()).f8075b.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin, lVar.G(), lVar.f8067o - lVar.D(), i9);
    }

    public float h(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int i(int i9) {
        float fAbs = Math.abs(i9);
        if (!this.f8320m) {
            this.f8321n = h(this.f8319l);
            this.f8320m = true;
        }
        return (int) Math.ceil(fAbs * this.f8321n);
    }
}
