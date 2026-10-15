package androidx.core.widget;

import T.G;
import T.L;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.widget.v;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7113q = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0099a f7114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f7115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListView f7116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f7117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f7118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f7119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f7122i;
    public final float[] j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f7123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7127o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7128p;

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoScrollHelper.java */
    public static class C0099a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f7133e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f7134f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f7135g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7136h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7137i;

        public final float a(long j) {
            long j8 = this.f7133e;
            if (j < j8) {
                return 0.0f;
            }
            long j9 = this.f7135g;
            if (j9 < 0 || j < j9) {
                return a.b((j - j8) / this.f7129a, 0.0f, 1.0f) * 0.5f;
            }
            float f6 = this.f7136h;
            return (a.b((j - j9) / this.f7137i, 0.0f, 1.0f) * f6) + (1.0f - f6);
        }
    }

    /* JADX INFO: compiled from: AutoScrollHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            if (aVar.f7127o) {
                boolean z8 = aVar.f7125m;
                C0099a c0099a = aVar.f7114a;
                if (z8) {
                    aVar.f7125m = false;
                    long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    c0099a.f7133e = jCurrentAnimationTimeMillis;
                    c0099a.f7135g = -1L;
                    c0099a.f7134f = jCurrentAnimationTimeMillis;
                    c0099a.f7136h = 0.5f;
                }
                if ((c0099a.f7135g > 0 && AnimationUtils.currentAnimationTimeMillis() > c0099a.f7135g + ((long) c0099a.f7137i)) || !aVar.e()) {
                    aVar.f7127o = false;
                    return;
                }
                boolean z9 = aVar.f7126n;
                ListView listView = aVar.f7116c;
                if (z9) {
                    aVar.f7126n = false;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    listView.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (c0099a.f7134f == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                float fA = c0099a.a(jCurrentAnimationTimeMillis2);
                long j = jCurrentAnimationTimeMillis2 - c0099a.f7134f;
                c0099a.f7134f = jCurrentAnimationTimeMillis2;
                ((c) aVar).f7139r.scrollListBy((int) (j * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * c0099a.f7132d));
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                listView.postOnAnimation(this);
            }
        }
    }

    public a(ListView listView) {
        C0099a c0099a = new C0099a();
        c0099a.f7133e = Long.MIN_VALUE;
        c0099a.f7135g = -1L;
        c0099a.f7134f = 0L;
        this.f7114a = c0099a;
        this.f7115b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f7118e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f7119f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f7122i = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f7123k = fArr5;
        this.f7116c = listView;
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        float f9 = ((int) ((1575.0f * f6) + 0.5f)) / 1000.0f;
        fArr5[0] = f9;
        fArr5[1] = f9;
        float f10 = ((int) ((f6 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f10;
        fArr4[1] = f10;
        this.f7120g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f7121h = f7113q;
        c0099a.f7129a = 500;
        c0099a.f7130b = 500;
    }

    public static float b(float f6, float f9, float f10) {
        if (f6 > f10) {
            return f10;
        }
        return f6 < f9 ? f9 : f6;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float a(int i9, float f6, float f9, float f10) {
        float fB;
        float interpolation;
        float fB2 = b(this.f7118e[i9] * f9, 0.0f, this.f7119f[i9]);
        float fC = c(f9 - f6, fB2) - c(f6, fB2);
        AccelerateInterpolator accelerateInterpolator = this.f7115b;
        if (fC >= 0.0f) {
            if (fC > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fC);
            } else {
                fB = 0.0f;
            }
            if (fB == 0.0f) {
                return 0.0f;
            }
            float f11 = this.f7122i[i9];
            float f12 = this.j[i9];
            float f13 = this.f7123k[i9];
            float f14 = f11 * f10;
            return fB > 0.0f ? b(fB * f14, f12, f13) : -b((-fB) * f14, f12, f13);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fC);
        fB = b(interpolation, -1.0f, 1.0f);
        if (fB == 0.0f) {
            return 0.0f;
        }
        float f15 = this.f7122i[i9];
        float f16 = this.j[i9];
        float f17 = this.f7123k[i9];
        float f18 = f15 * f10;
        if (fB > 0.0f) {
        }
    }

    public final float c(float f6, float f9) {
        if (f9 != 0.0f) {
            int i9 = this.f7120g;
            if (i9 == 0 || i9 == 1) {
                if (f6 < f9) {
                    if (f6 >= 0.0f) {
                        return 1.0f - (f6 / f9);
                    }
                    if (this.f7127o && i9 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i9 == 2 && f6 < 0.0f) {
                return f6 / (-f9);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i9 = 0;
        if (this.f7125m) {
            this.f7127o = false;
            return;
        }
        C0099a c0099a = this.f7114a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i10 = (int) (jCurrentAnimationTimeMillis - c0099a.f7133e);
        int i11 = c0099a.f7130b;
        if (i10 > i11) {
            i9 = i11;
        } else if (i10 >= 0) {
            i9 = i10;
        }
        c0099a.f7137i = i9;
        c0099a.f7136h = c0099a.a(jCurrentAnimationTimeMillis);
        c0099a.f7135g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        v vVar;
        int count;
        C0099a c0099a = this.f7114a;
        float f6 = c0099a.f7132d;
        int iAbs = (int) (f6 / Math.abs(f6));
        Math.abs(c0099a.f7131c);
        if (iAbs != 0 && (count = (vVar = ((c) this).f7139r).getCount()) != 0) {
            int childCount = vVar.getChildCount();
            int firstVisiblePosition = vVar.getFirstVisiblePosition();
            int i9 = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && vVar.getChildAt(0).getTop() >= 0)) : !(i9 >= count && vVar.getChildAt(childCount - 1).getBottom() <= vVar.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f7128p
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.f7126n = r2
            r7.f7124l = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.f7116c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            androidx.core.widget.a$a r9 = r7.f7114a
            r9.f7131c = r0
            r9.f7132d = r8
            boolean r8 = r7.f7127o
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            androidx.core.widget.a$b r8 = r7.f7117d
            if (r8 != 0) goto L60
            androidx.core.widget.a$b r8 = new androidx.core.widget.a$b
            r8.<init>()
            r7.f7117d = r8
        L60:
            r7.f7127o = r2
            r7.f7125m = r2
            boolean r8 = r7.f7124l
            if (r8 != 0) goto L75
            int r8 = r7.f7121h
            if (r8 <= 0) goto L75
            androidx.core.widget.a$b r9 = r7.f7117d
            long r5 = (long) r8
            java.util.WeakHashMap<android.view.View, T.L> r8 = T.G.f4313a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            androidx.core.widget.a$b r8 = r7.f7117d
            r8.run()
        L7a:
            r7.f7124l = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
