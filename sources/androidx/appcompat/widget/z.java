package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p056h5.C0598e;

/* JADX INFO: compiled from: ListPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class z implements p097n.f {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Method f6706A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Method f6707B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f6709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f6710c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6714g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6716i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6717k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f6720n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f6721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AdapterView.OnItemClickListener f6722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f6723q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f6727v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Rect f6729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0498j f6731z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6711d = -2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6712e = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6715h = 1002;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6718l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f6719m = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f6724r = new g();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f6725s = new f();
    public final e t = new e();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f6726u = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f6728w = new Rect();

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public static class a {
        public static int a(PopupWindow popupWindow, View view, int i9, boolean z8) {
            return popupWindow.getMaxAvailableHeight(view, i9, z8);
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public static class b {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z8) {
            popupWindow.setIsClippedToScreen(z8);
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            v vVar = z.this.f6710c;
            if (vVar != null) {
                vVar.setListSelectionHidden(true);
                vVar.requestLayout();
            }
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            z zVar = z.this;
            if (zVar.f6731z.isShowing()) {
                zVar.d();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            z.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C0498j c0498j;
            int action = motionEvent.getAction();
            int x8 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            z zVar = z.this;
            if (action == 0 && (c0498j = zVar.f6731z) != null && c0498j.isShowing() && x8 >= 0 && x8 < zVar.f6731z.getWidth() && y8 >= 0 && y8 < zVar.f6731z.getHeight()) {
                zVar.f6727v.postDelayed(zVar.f6724r, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            zVar.f6727v.removeCallbacks(zVar.f6724r);
            return false;
        }
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z zVar = z.this;
            v vVar = zVar.f6710c;
            if (vVar == null || !vVar.isAttachedToWindow() || zVar.f6710c.getCount() <= zVar.f6710c.getChildCount() || zVar.f6710c.getChildCount() > zVar.f6719m) {
                return;
            }
            zVar.f6731z.setInputMethodMode(2);
            zVar.d();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f6706A = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f6707B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public z(Context context, AttributeSet attributeSet, int i9) {
        int resourceId;
        this.f6708a = context;
        this.f6727v = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p059i.a.f19187o, i9, 0);
        this.f6713f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f6714g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f6716i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0498j c0498j = new C0498j(context, attributeSet, i9, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, p059i.a.f19191s, i9, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            c0498j.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        c0498j.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : C0598e.v(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f6731z = c0498j;
        c0498j.setInputMethodMode(1);
    }

    @Override // p097n.f
    public final boolean b() {
        return this.f6731z.isShowing();
    }

    public final int c() {
        return this.f6713f;
    }

    @Override // p097n.f
    public final void d() {
        int i9;
        int iMakeMeasureSpec;
        int paddingBottom;
        v vVar;
        v vVar2 = this.f6710c;
        C0498j c0498j = this.f6731z;
        Context context = this.f6708a;
        if (vVar2 == null) {
            v vVarQ = q(context, !this.f6730y);
            this.f6710c = vVarQ;
            vVarQ.setAdapter(this.f6709b);
            this.f6710c.setOnItemClickListener(this.f6722p);
            this.f6710c.setFocusable(true);
            this.f6710c.setFocusableInTouchMode(true);
            this.f6710c.setOnItemSelectedListener(new y(this));
            this.f6710c.setOnScrollListener(this.t);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f6723q;
            if (onItemSelectedListener != null) {
                this.f6710c.setOnItemSelectedListener(onItemSelectedListener);
            }
            c0498j.setContentView(this.f6710c);
        }
        Drawable background = c0498j.getBackground();
        Rect rect = this.f6728w;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i9 = rect.bottom + i10;
            if (!this.f6716i) {
                this.f6714g = -i10;
            }
        } else {
            rect.setEmpty();
            i9 = 0;
        }
        int iA = a.a(c0498j, this.f6721o, this.f6714g, c0498j.getInputMethodMode() == 2);
        int i11 = this.f6711d;
        if (i11 == -1) {
            paddingBottom = iA + i9;
        } else {
            int i12 = this.f6712e;
            if (i12 != -2) {
                iMakeMeasureSpec = i12 != -1 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int iA2 = this.f6710c.a(iMakeMeasureSpec, iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f6710c.getPaddingBottom() + this.f6710c.getPaddingTop() + i9 : 0);
        }
        boolean z8 = this.f6731z.getInputMethodMode() == 2;
        c0498j.setWindowLayoutType(this.f6715h);
        if (c0498j.isShowing()) {
            if (this.f6721o.isAttachedToWindow()) {
                int width = this.f6712e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f6721o.getWidth();
                }
                if (i11 == -1) {
                    i11 = z8 ? paddingBottom : -1;
                    if (z8) {
                        c0498j.setWidth(this.f6712e == -1 ? -1 : 0);
                        c0498j.setHeight(0);
                    } else {
                        c0498j.setWidth(this.f6712e == -1 ? -1 : 0);
                        c0498j.setHeight(-1);
                    }
                } else if (i11 == -2) {
                    i11 = paddingBottom;
                }
                c0498j.setOutsideTouchable(true);
                View view = this.f6721o;
                int i13 = this.f6713f;
                int i14 = this.f6714g;
                if (width < 0) {
                    width = -1;
                }
                c0498j.update(view, i13, i14, width, i11 < 0 ? -1 : i11);
                return;
            }
            return;
        }
        int width2 = this.f6712e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f6721o.getWidth();
        }
        if (i11 == -1) {
            i11 = -1;
        } else if (i11 == -2) {
            i11 = paddingBottom;
        }
        c0498j.setWidth(width2);
        c0498j.setHeight(i11);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f6706A;
            if (method != null) {
                try {
                    method.invoke(c0498j, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b.b(c0498j, true);
        }
        c0498j.setOutsideTouchable(true);
        c0498j.setTouchInterceptor(this.f6725s);
        if (this.f6717k) {
            c0498j.setOverlapAnchor(this.j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f6707B;
            if (method2 != null) {
                try {
                    method2.invoke(c0498j, this.f6729x);
                } catch (Exception e9) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e9);
                }
            }
        } else {
            b.a(c0498j, this.f6729x);
        }
        c0498j.showAsDropDown(this.f6721o, this.f6713f, this.f6714g, this.f6718l);
        this.f6710c.setSelection(-1);
        if ((!this.f6730y || this.f6710c.isInTouchMode()) && (vVar = this.f6710c) != null) {
            vVar.setListSelectionHidden(true);
            vVar.requestLayout();
        }
        if (this.f6730y) {
            return;
        }
        this.f6727v.post(this.f6726u);
    }

    @Override // p097n.f
    public final void dismiss() {
        C0498j c0498j = this.f6731z;
        c0498j.dismiss();
        c0498j.setContentView(null);
        this.f6710c = null;
        this.f6727v.removeCallbacks(this.f6724r);
    }

    public final Drawable e() {
        return this.f6731z.getBackground();
    }

    @Override // p097n.f
    public final v g() {
        return this.f6710c;
    }

    public final void h(Drawable drawable) {
        this.f6731z.setBackgroundDrawable(drawable);
    }

    public final void i(int i9) {
        this.f6714g = i9;
        this.f6716i = true;
    }

    public final void k(int i9) {
        this.f6713f = i9;
    }

    public final int m() {
        if (this.f6716i) {
            return this.f6714g;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        d dVar = this.f6720n;
        if (dVar == null) {
            this.f6720n = new d();
        } else {
            ListAdapter listAdapter2 = this.f6709b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dVar);
            }
        }
        this.f6709b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f6720n);
        }
        v vVar = this.f6710c;
        if (vVar != null) {
            vVar.setAdapter(this.f6709b);
        }
    }

    public v q(Context context, boolean z8) {
        return new v(context, z8);
    }

    public final void r(int i9) {
        Drawable background = this.f6731z.getBackground();
        if (background == null) {
            this.f6712e = i9;
            return;
        }
        Rect rect = this.f6728w;
        background.getPadding(rect);
        this.f6712e = rect.left + rect.right + i9;
    }

    /* JADX INFO: compiled from: ListPopupWindow.java */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i9) {
            if (i9 == 1) {
                z zVar = z.this;
                if (zVar.f6731z.getInputMethodMode() == 2 || zVar.f6731z.getContentView() == null) {
                    return;
                }
                Handler handler = zVar.f6727v;
                g gVar = zVar.f6724r;
                handler.removeCallbacks(gVar);
                gVar.run();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i9, int i10, int i11) {
        }
    }
}
