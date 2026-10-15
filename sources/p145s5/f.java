package p145s5;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: CarouselOrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21267a;

    public f(int i9) {
        this.f21267a = i9;
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float b(RecyclerView.m mVar);

    public abstract RectF c(float f6, float f9, float f10, float f11);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract void j(View view, int i9, int i10);

    public abstract void k(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void l(View view, Rect rect, float f6, float f9);
}
