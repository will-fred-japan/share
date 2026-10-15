package p164v0;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f21849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21850b;

    /* JADX INFO: compiled from: ViewUtils.java */
    public class a extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf(p.f21849a.a(view));
        }

        @Override // android.util.Property
        public final void set(View view, Float f6) {
            float fFloatValue = f6.floatValue();
            p.f21849a.b(view, fFloatValue);
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public class b extends Property<View, Rect> {
        @Override // android.util.Property
        public final Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public final void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f21849a = new u();
        } else {
            f21849a = new t();
        }
        f21850b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    public static void a(View view, int i9, int i10, int i11, int i12) {
        f21849a.f(view, i9, i10, i11, i12);
    }

    public static void b(View view, int i9) {
        f21849a.c(view, i9);
    }
}
