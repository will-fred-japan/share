package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f6697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f6699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f6702i = new int[2];

    /* JADX INFO: compiled from: ForwardingListener.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = x.this.f6697d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: ForwardingListener.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            x xVar = x.this;
            xVar.a();
            View view = xVar.f6697d;
            if (view.isEnabled() && !view.isLongClickable() && xVar.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                xVar.f6700g = true;
            }
        }
    }

    public x(View view) {
        this.f6697d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f6694a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f6695b = tapTimeout;
        this.f6696c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        b bVar = this.f6699f;
        View view = this.f6697d;
        if (bVar != null) {
            view.removeCallbacks(bVar);
        }
        a aVar = this.f6698e;
        if (aVar != null) {
            view.removeCallbacks(aVar);
        }
    }

    public abstract p097n.f b();

    public abstract boolean c();

    public boolean d() {
        p097n.f fVarB = b();
        if (fVarB == null || !fVarB.b()) {
            return true;
        }
        fVarB.dismiss();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z8;
        v vVarG;
        boolean z9 = this.f6700g;
        View view2 = this.f6697d;
        if (z9) {
            p097n.f fVarB = b();
            if (fVarB != null && fVarB.b() && (vVarG = fVarB.g()) != null && vVarG.isShown()) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.f6702i;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                vVarG.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zB = vVarG.b(motionEventObtainNoHistory, this.f6701h);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z10 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zB && z10) {
                    z8 = true;
                } else if (d()) {
                    z8 = false;
                } else {
                    z8 = true;
                }
            } else if (d()) {
                z8 = true;
            } else {
                z8 = false;
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.f6701h = motionEvent.getPointerId(0);
                    if (this.f6698e == null) {
                        this.f6698e = new a();
                    }
                    view2.postDelayed(this.f6698e, this.f6695b);
                    if (this.f6699f == null) {
                        this.f6699f = new b();
                    }
                    view2.postDelayed(this.f6699f, this.f6696c);
                } else if (actionMasked2 == 1) {
                    a();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f6701h);
                    if (iFindPointerIndex >= 0) {
                        float x8 = motionEvent.getX(iFindPointerIndex);
                        float y8 = motionEvent.getY(iFindPointerIndex);
                        float f6 = this.f6694a;
                        float f9 = -f6;
                        if (x8 < f9 || y8 < f9 || x8 >= (view2.getRight() - view2.getLeft()) + f6 || y8 >= (view2.getBottom() - view2.getTop()) + f6) {
                            a();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            if (c()) {
                                z8 = true;
                            }
                        }
                    }
                } else if (actionMasked2 == 3) {
                    a();
                }
                z8 = false;
            } else {
                z8 = false;
            }
            if (z8) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f6700g = z8;
        return z8 || z9;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f6700g = false;
        this.f6701h = -1;
        a aVar = this.f6698e;
        if (aVar != null) {
            this.f6697d.removeCallbacks(aVar);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
