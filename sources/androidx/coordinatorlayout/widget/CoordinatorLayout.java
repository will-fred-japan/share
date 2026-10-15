package androidx.coordinatorlayout.widget;

import T.G;
import T.InterfaceC0429p;
import T.InterfaceC0430q;
import T.InterfaceC0431s;
import T.L;
import T.Q;
import T.r;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.customview.view.AbsSavedState;
import cn.ikaile.ruoshui.client.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0429p, InterfaceC0430q {
    public static final String t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Class<?>[] f7012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<c>>> f7013v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f7014w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final S.d f7015x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E.a f7017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f7020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f7021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f7024i;
    public View j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f7025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f7026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Q f7028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7029o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f7030p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f7031q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f7032r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final r f7033s;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SparseArray<Parcelable> f7034c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i9 = parcel.readInt();
            int[] iArr = new int[i9];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f7034c = new SparseArray<>(i9);
            for (int i10 = 0; i10 < i9; i10++) {
                this.f7034c.append(iArr[i10], parcelableArray[i10]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            SparseArray<Parcelable> sparseArray = this.f7034c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = this.f7034c.keyAt(i10);
                parcelableArr[i10] = this.f7034c.valueAt(i10);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i9);
        }
    }

    public class a implements InterfaceC0431s {
        public a() {
        }

        @Override // T.InterfaceC0431s
        public final Q b(View view, Q q8) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.f7028n, q8)) {
                coordinatorLayout.f7028n = q8;
                boolean z8 = q8.d() > 0;
                coordinatorLayout.f7029o = z8;
                coordinatorLayout.setWillNotDraw(!z8 && coordinatorLayout.getBackground() == null);
                Q.q qVar = q8.f4366a;
                if (!qVar.r()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = coordinatorLayout.getChildAt(i9);
                        WeakHashMap<View, L> weakHashMap = G.f4313a;
                        if (childAt.getFitsSystemWindows() && ((f) childAt.getLayoutParams()).f7037a != null && qVar.r()) {
                            break;
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return q8;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean a(View view) {
            return false;
        }

        public boolean b(View view, View view2) {
            return false;
        }

        public boolean d(CoordinatorLayout coordinatorLayout, V v5, View view) {
            return false;
        }

        public boolean g(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
            return false;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v5, int i9) {
            return false;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
            return false;
        }

        public boolean j(View view) {
            return false;
        }

        public void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
            iArr[0] = iArr[0] + i10;
            iArr[1] = iArr[1] + i11;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v5, Rect rect, boolean z8) {
            return false;
        }

        public Parcelable o(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean p(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i9, int i10) {
            return false;
        }

        public boolean r(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void f() {
        }

        public void c(f fVar) {
        }

        public void e(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void n(View view, Parcelable parcelable) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v5, View view, int i9) {
        }

        public void k(CoordinatorLayout coordinatorLayout, V v5, View view, int i9, int i10, int[] iArr, int i11) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7031q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.j(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.f7031q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.j(0);
            return true;
        }
    }

    public static class h implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            float z8 = view.getZ();
            float z9 = view2.getZ();
            if (z8 > z9) {
                return -1;
            }
            return z8 < z9 ? 1 : 0;
        }
    }

    static {
        Package r8 = CoordinatorLayout.class.getPackage();
        t = r8 != null ? r8.getName() : null;
        f7014w = new h();
        f7012u = new Class[]{Context.class, AttributeSet.class};
        f7013v = new ThreadLocal<>();
        f7015x = new S.d(12);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f7016a = new ArrayList();
        this.f7017b = new E.a(0);
        this.f7018c = new ArrayList();
        this.f7019d = new ArrayList();
        this.f7020e = new int[2];
        this.f7021f = new int[2];
        this.f7033s = new r();
        int[] iArr = D.a.f1808a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f7024i = intArray;
            float f6 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i9 = 0; i9 < length; i9++) {
                int[] iArr2 = this.f7024i;
                iArr2[i9] = (int) (iArr2[i9] * f6);
            }
        }
        this.f7030p = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        r();
        super.setOnHierarchyChangeListener(new e());
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect a() {
        Rect rect = (Rect) f7015x.d();
        return rect == null ? new Rect() : rect;
    }

    public static void f(int i9, Rect rect, Rect rect2, f fVar, int i10, int i11) {
        int iWidth;
        int iHeight;
        int i12 = fVar.f7039c;
        if (i12 == 0) {
            i12 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i9);
        int i13 = fVar.f7040d;
        if ((i13 & 7) == 0) {
            i13 |= 8388611;
        }
        if ((i13 & 112) == 0) {
            i13 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i13, i9);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        if (i16 != 1) {
            iWidth = i16 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i17 != 16) {
            iHeight = i17 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i14 == 1) {
            iWidth -= i10 / 2;
        } else if (i14 != 5) {
            iWidth -= i10;
        }
        if (i15 == 16) {
            iHeight -= i11 / 2;
        } else if (i15 != 80) {
            iHeight -= i11;
        }
        rect2.set(iWidth, iHeight, i10 + iWidth, i11 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f h(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f7038b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c cVar = fVar.f7037a;
                if (cVar != behavior) {
                    if (cVar != null) {
                        cVar.f();
                    }
                    fVar.f7037a = behavior;
                    fVar.f7038b = true;
                    if (behavior != null) {
                        behavior.c(fVar);
                    }
                }
                fVar.f7038b = true;
                return fVar;
            }
            d dVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                dVar = (d) superclass.getAnnotation(d.class);
                if (dVar != null) {
                    break;
                }
            }
            if (dVar != null) {
                try {
                    c cVarNewInstance = dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    c cVar2 = fVar.f7037a;
                    if (cVar2 != cVarNewInstance) {
                        if (cVar2 != null) {
                            cVar2.f();
                        }
                        fVar.f7037a = cVarNewInstance;
                        fVar.f7038b = true;
                        if (cVarNewInstance != null) {
                            cVarNewInstance.c(fVar);
                        }
                    }
                } catch (Exception e9) {
                    Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e9);
                }
            }
            fVar.f7038b = true;
        }
        return fVar;
    }

    public static void p(View view, int i9) {
        f fVar = (f) view.getLayoutParams();
        int i10 = fVar.f7045i;
        if (i10 != i9) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            view.offsetLeftAndRight(i9 - i10);
            fVar.f7045i = i9;
        }
    }

    public static void q(View view, int i9) {
        f fVar = (f) view.getLayoutParams();
        int i10 = fVar.j;
        if (i10 != i9) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            view.offsetTopAndBottom(i9 - i10);
            fVar.j = i9;
        }
    }

    public final void b(f fVar, Rect rect, int i9, int i10) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i9) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i9 + iMax, i10 + iMax2);
    }

    public final void c(View view, Rect rect, boolean z8) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z8) {
            e(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final ArrayList d(View view) {
        p155u.g gVar = (p155u.g) this.f7017b.f1948d;
        int i9 = gVar.f21660c;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < i9; i10++) {
            ArrayList arrayList2 = (ArrayList) gVar.i(i10);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(gVar.f(i10));
            }
        }
        ArrayList arrayList3 = this.f7019d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        c cVar = ((f) view.getLayoutParams()).f7037a;
        if (cVar != null) {
            cVar.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7030p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final void e(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = E.b.f1950a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = E.b.f1950a;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        E.b.a(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = E.b.f1951b;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int g(int i9) {
        int[] iArr = this.f7024i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i9);
            return 0;
        }
        if (i9 >= 0 && i9 < iArr.length) {
            return iArr[i9];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i9 + " out of range for " + this);
        return 0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        n();
        return Collections.unmodifiableList(this.f7016a);
    }

    public final Q getLastWindowInsets() {
        return this.f7028n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        r rVar = this.f7033s;
        return rVar.f4451b | rVar.f4450a;
    }

    public Drawable getStatusBarBackground() {
        return this.f7030p;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean i(View view, int i9, int i10) {
        S.d dVar = f7015x;
        Rect rectA = a();
        e(view, rectA);
        try {
            return rectA.contains(i9, i10);
        } finally {
            rectA.setEmpty();
            dVar.f(rectA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0271  */
    /* JADX WARN: Code duplicated, block: B:33:0x00df  */
    public final void j(int i9) {
        Rect rect;
        int i10;
        Rect rect2;
        int i11;
        ArrayList arrayList;
        int i12;
        boolean zD;
        boolean z8;
        boolean z9;
        int width;
        int i13;
        int i14;
        int i15;
        int height;
        int i16;
        int i17;
        int i18;
        Rect rect3;
        S.d dVar;
        c cVar;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList2 = this.f7016a;
        int size = arrayList2.size();
        Rect rectA = a();
        Rect rectA2 = a();
        Rect rectA3 = a();
        int i19 = 0;
        while (true) {
            S.d dVar2 = f7015x;
            if (i19 >= size) {
                Rect rect4 = rectA2;
                Rect rect5 = rectA3;
                rectA.setEmpty();
                dVar2.f(rectA);
                rect4.setEmpty();
                dVar2.f(rect4);
                rect5.setEmpty();
                dVar2.f(rect5);
                return;
            }
            View view = (View) arrayList2.get(i19);
            f fVar = (f) view.getLayoutParams();
            if (i9 != 0 || view.getVisibility() != 8) {
                int i20 = 0;
                while (i20 < i19) {
                    if (fVar.f7047l == ((View) arrayList2.get(i20))) {
                        f fVar2 = (f) view.getLayoutParams();
                        if (fVar2.f7046k != null) {
                            Rect rectA4 = a();
                            Rect rectA5 = a();
                            Rect rect6 = rectA3;
                            Rect rectA6 = a();
                            e(fVar2.f7046k, rectA4);
                            c(view, rectA5, false);
                            int measuredWidth = view.getMeasuredWidth();
                            S.d dVar3 = dVar2;
                            int measuredHeight = view.getMeasuredHeight();
                            dVar = dVar3;
                            f(layoutDirection, rectA4, rectA6, fVar2, measuredWidth, measuredHeight);
                            rect3 = rect6;
                            boolean z10 = (rectA6.left == rectA5.left && rectA6.top == rectA5.top) ? false : true;
                            b(fVar2, rectA6, measuredWidth, measuredHeight);
                            int i21 = rectA6.left - rectA5.left;
                            int i22 = rectA6.top - rectA5.top;
                            if (i21 != 0) {
                                WeakHashMap<View, L> weakHashMap2 = G.f4313a;
                                view.offsetLeftAndRight(i21);
                            }
                            if (i22 != 0) {
                                WeakHashMap<View, L> weakHashMap3 = G.f4313a;
                                view.offsetTopAndBottom(i22);
                            }
                            if (z10 && (cVar = fVar2.f7037a) != null) {
                                cVar.d(this, view, fVar2.f7046k);
                            }
                            rectA4.setEmpty();
                            dVar.f(rectA4);
                            rectA5.setEmpty();
                            dVar.f(rectA5);
                            rectA6.setEmpty();
                            dVar.f(rectA6);
                        } else {
                            rect3 = rectA3;
                            dVar = dVar2;
                        }
                    } else {
                        rect3 = rectA3;
                        dVar = dVar2;
                    }
                    dVar2 = dVar;
                    i20++;
                    rectA2 = rectA2;
                    i19 = i19;
                    arrayList2 = arrayList2;
                    size = size;
                    rectA3 = rect3;
                }
                ArrayList arrayList3 = arrayList2;
                rect = rectA2;
                Rect rect7 = rectA3;
                i10 = i19;
                S.d dVar4 = dVar2;
                int i23 = size;
                c(view, rect, true);
                if (fVar.f7043g != 0 && !rect.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar.f7043g, layoutDirection);
                    int i24 = absoluteGravity & 112;
                    if (i24 == 48) {
                        rectA.top = Math.max(rectA.top, rect.bottom);
                    } else if (i24 == 80) {
                        rectA.bottom = Math.max(rectA.bottom, getHeight() - rect.top);
                    }
                    int i25 = absoluteGravity & 7;
                    if (i25 == 3) {
                        rectA.left = Math.max(rectA.left, rect.right);
                    } else if (i25 == 5) {
                        rectA.right = Math.max(rectA.right, getWidth() - rect.left);
                    }
                }
                if (fVar.f7044h != 0 && view.getVisibility() == 0) {
                    WeakHashMap<View, L> weakHashMap4 = G.f4313a;
                    if (view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                        f fVar3 = (f) view.getLayoutParams();
                        c cVar2 = fVar3.f7037a;
                        Rect rectA7 = a();
                        Rect rectA8 = a();
                        rectA8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (cVar2 == null || !cVar2.a(view)) {
                            rectA7.set(rectA8);
                        } else if (!rectA8.contains(rectA7)) {
                            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA7.toShortString() + " | Bounds:" + rectA8.toShortString());
                        }
                        rectA8.setEmpty();
                        dVar4.f(rectA8);
                        if (rectA7.isEmpty()) {
                            rectA7.setEmpty();
                            dVar4.f(rectA7);
                        } else {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar3.f7044h, layoutDirection);
                            if ((absoluteGravity2 & 48) != 48 || (i17 = (rectA7.top - ((ViewGroup.MarginLayoutParams) fVar3).topMargin) - fVar3.j) >= (i18 = rectA.top)) {
                                z8 = false;
                            } else {
                                q(view, i18 - i17);
                                z8 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - rectA7.bottom) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin) + fVar3.j) < (i16 = rectA.bottom)) {
                                q(view, height - i16);
                                z8 = true;
                            }
                            if (!z8) {
                                q(view, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i14 = (rectA7.left - ((ViewGroup.MarginLayoutParams) fVar3).leftMargin) - fVar3.f7045i) >= (i15 = rectA.left)) {
                                z9 = false;
                            } else {
                                p(view, i15 - i14);
                                z9 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - rectA7.right) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin) + fVar3.f7045i) < (i13 = rectA.right)) {
                                p(view, width - i13);
                                z9 = true;
                            }
                            if (!z9) {
                                p(view, 0);
                            }
                            rectA7.setEmpty();
                            dVar4.f(rectA7);
                        }
                    }
                }
                if (i9 != 2) {
                    rect2 = rect7;
                    rect2.set(((f) view.getLayoutParams()).f7051p);
                    if (rect2.equals(rect)) {
                        arrayList = arrayList3;
                        i11 = i23;
                    } else {
                        ((f) view.getLayoutParams()).f7051p.set(rect);
                    }
                } else {
                    rect2 = rect7;
                }
                int i26 = i10 + 1;
                i11 = i23;
                while (true) {
                    arrayList = arrayList3;
                    if (i26 >= i11) {
                        break;
                    }
                    View view2 = (View) arrayList.get(i26);
                    f fVar4 = (f) view2.getLayoutParams();
                    c cVar3 = fVar4.f7037a;
                    if (cVar3 == null || !cVar3.b(view2, view)) {
                        i12 = 1;
                    } else if (i9 == 0 && fVar4.f7050o) {
                        fVar4.f7050o = false;
                        i12 = 1;
                    } else {
                        if (i9 != 2) {
                            zD = cVar3.d(this, view2, view);
                        } else {
                            cVar3.e(this, view);
                            zD = true;
                        }
                        i12 = 1;
                        if (i9 == 1) {
                            fVar4.f7050o = zD;
                        }
                    }
                    i26 += i12;
                    arrayList3 = arrayList;
                }
            } else {
                int i27 = size;
                arrayList = arrayList2;
                i11 = i27;
                rect = rectA2;
                rect2 = rectA3;
                i10 = i19;
            }
            i19 = i10 + 1;
            ArrayList arrayList4 = arrayList;
            size = i11;
            arrayList2 = arrayList4;
            rectA3 = rect2;
            rectA2 = rect;
        }
    }

    public final void k(View view, int i9) {
        int i10;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.f7046k;
        if (view2 == null && fVar.f7042f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        S.d dVar = f7015x;
        if (view2 != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            try {
                e(view2, rectA);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                f(i9, rectA, rectA2, fVar2, measuredWidth, measuredHeight);
                b(fVar2, rectA2, measuredWidth, measuredHeight);
                view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
                return;
            } finally {
                rectA.setEmpty();
                dVar.f(rectA);
                rectA2.setEmpty();
                dVar.f(rectA2);
            }
        }
        int i11 = fVar.f7041e;
        if (i11 < 0) {
            f fVar3 = (f) view.getLayoutParams();
            Rect rectA3 = a();
            rectA3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
            if (this.f7028n != null) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectA3.left = this.f7028n.b() + rectA3.left;
                    rectA3.top = this.f7028n.d() + rectA3.top;
                    rectA3.right -= this.f7028n.c();
                    rectA3.bottom -= this.f7028n.a();
                }
            }
            Rect rectA4 = a();
            int i12 = fVar3.f7039c;
            if ((i12 & 7) == 0) {
                i12 |= 8388611;
            }
            if ((i12 & 112) == 0) {
                i12 |= 48;
            }
            Gravity.apply(i12, view.getMeasuredWidth(), view.getMeasuredHeight(), rectA3, rectA4, i9);
            view.layout(rectA4.left, rectA4.top, rectA4.right, rectA4.bottom);
            rectA3.setEmpty();
            dVar.f(rectA3);
            rectA4.setEmpty();
            dVar.f(rectA4);
            return;
        }
        f fVar4 = (f) view.getLayoutParams();
        int i13 = fVar4.f7039c;
        if (i13 == 0) {
            i13 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i9);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i9 == 1) {
            i11 = width - i11;
        }
        int iG = g(i11) - measuredWidth2;
        if (i14 == 1) {
            iG += measuredWidth2 / 2;
        } else if (i14 == 5) {
            iG += measuredWidth2;
        }
        if (i15 != 16) {
            i10 = i15 != 80 ? 0 : measuredHeight2;
        } else {
            i10 = measuredHeight2 / 2;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(iG, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i10, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void l(int i9, int i10, int i11, View view) {
        measureChildWithMargins(view, i9, i10, i11, 0);
    }

    public final boolean m(MotionEvent motionEvent, int i9) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f7018c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        h hVar = f7014w;
        if (hVar != null) {
            Collections.sort(arrayList, hVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zG = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) arrayList.get(i11);
            c cVar = ((f) view.getLayoutParams()).f7037a;
            if (zG && actionMasked != 0) {
                if (cVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i9 == 0) {
                        cVar.g(this, view, motionEventObtain);
                    } else if (i9 == 1) {
                        cVar.r(this, view, motionEventObtain);
                    }
                }
            } else if (!zG && cVar != null) {
                if (i9 == 0) {
                    zG = cVar.g(this, view, motionEvent);
                } else if (i9 == 1) {
                    zG = cVar.r(this, view, motionEvent);
                }
                if (zG) {
                    this.j = view;
                }
            }
        }
        arrayList.clear();
        return zG;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x007e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084  */
    /* JADX WARN: Code duplicated, block: B:39:0x0091  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:40:0x0095
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.n():void");
    }

    public final void o(boolean z8) {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            c cVar = ((f) childAt.getLayoutParams()).f7037a;
            if (cVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z8) {
                    cVar.g(this, childAt, motionEventObtain);
                } else {
                    cVar.r(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            ((f) getChildAt(i10).getLayoutParams()).getClass();
        }
        this.j = null;
        this.f7022g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        o(false);
        if (this.f7027m) {
            if (this.f7026l == null) {
                this.f7026l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7026l);
        }
        if (this.f7028n == null) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.f7023h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o(false);
        if (this.f7027m && this.f7026l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7026l);
        }
        View view = this.f7025k;
        if (view != null) {
            onStopNestedScroll(view, 0);
        }
        this.f7023h = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7029o || this.f7030p == null) {
            return;
        }
        Q q8 = this.f7028n;
        int iD = q8 != null ? q8.d() : 0;
        if (iD > 0) {
            this.f7030p.setBounds(0, 0, getWidth(), iD);
            this.f7030p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            o(true);
        }
        boolean zM = m(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zM;
        }
        o(true);
        return zM;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        c cVar;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f7016a;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = (View) arrayList.get(i13);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f7037a) == null || !cVar.h(this, view, layoutDirection))) {
                k(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x012d  */
    /* JADX WARN: Code duplicated, block: B:72:0x015e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0168  */
    /* JADX WARN: Code duplicated, block: B:78:0x0189  */
    /* JADX WARN: Code duplicated, block: B:79:0x018c  */
    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        boolean z8;
        int i11;
        int i12;
        int i13;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        c cVar;
        int i14;
        View view;
        ArrayList arrayList;
        int i15;
        int i16;
        int i17;
        boolean z9;
        int i18;
        int i19;
        int i20;
        boolean zI;
        int iMax;
        CoordinatorLayout coordinatorLayout = this;
        coordinatorLayout.n();
        int childCount = coordinatorLayout.getChildCount();
        int i21 = 0;
        loop0: while (true) {
            if (i21 >= childCount) {
                z8 = false;
                break;
            }
            View childAt = coordinatorLayout.getChildAt(i21);
            p155u.g gVar = (p155u.g) coordinatorLayout.f7017b.f1948d;
            int i22 = gVar.f21660c;
            for (int i23 = 0; i23 < i22; i23++) {
                ArrayList arrayList2 = (ArrayList) gVar.i(i23);
                if (arrayList2 != null && arrayList2.contains(childAt)) {
                    z8 = true;
                    break loop0;
                }
            }
            i21++;
        }
        if (z8 != coordinatorLayout.f7027m) {
            if (z8) {
                if (coordinatorLayout.f7023h) {
                    if (coordinatorLayout.f7026l == null) {
                        coordinatorLayout.f7026l = coordinatorLayout.new g();
                    }
                    coordinatorLayout.getViewTreeObserver().addOnPreDrawListener(coordinatorLayout.f7026l);
                }
                coordinatorLayout.f7027m = true;
            } else {
                if (coordinatorLayout.f7023h && coordinatorLayout.f7026l != null) {
                    coordinatorLayout.getViewTreeObserver().removeOnPreDrawListener(coordinatorLayout.f7026l);
                }
                coordinatorLayout.f7027m = false;
            }
        }
        int paddingLeft = coordinatorLayout.getPaddingLeft();
        int paddingTop = coordinatorLayout.getPaddingTop();
        int paddingRight = coordinatorLayout.getPaddingRight();
        int paddingBottom = coordinatorLayout.getPaddingBottom();
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        int layoutDirection = coordinatorLayout.getLayoutDirection();
        boolean z10 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        int i24 = paddingLeft + paddingRight;
        int i25 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = coordinatorLayout.getSuggestedMinimumWidth();
        int suggestedMinimumHeight = coordinatorLayout.getSuggestedMinimumHeight();
        boolean z11 = coordinatorLayout.f7028n != null && coordinatorLayout.getFitsSystemWindows();
        ArrayList arrayList3 = coordinatorLayout.f7016a;
        int size3 = arrayList3.size();
        int i26 = 0;
        int iCombineMeasuredStates = 0;
        while (i26 < size3) {
            View view2 = (View) arrayList3.get(i26);
            int i27 = suggestedMinimumWidth;
            if (view2.getVisibility() == 8) {
                arrayList = arrayList3;
                i12 = size3;
                i18 = paddingLeft;
                i16 = paddingRight;
                suggestedMinimumWidth = i27;
                z9 = false;
                i20 = i26;
            } else {
                f fVar = (f) view2.getLayoutParams();
                int i28 = fVar.f7041e;
                if (i28 < 0 || mode == 0) {
                    i11 = suggestedMinimumHeight;
                } else {
                    int iG = coordinatorLayout.g(i28);
                    int i29 = fVar.f7039c;
                    if (i29 == 0) {
                        i29 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i29, layoutDirection) & 7;
                    i11 = suggestedMinimumHeight;
                    if ((absoluteGravity != 3 || z10) && !(absoluteGravity == 5 && z10)) {
                        if ((absoluteGravity == 5 && !z10) || (absoluteGravity == 3 && z10)) {
                            iMax = Math.max(0, iG - paddingLeft);
                        }
                        if (z11 || view2.getFitsSystemWindows()) {
                            iMakeMeasureSpec = i9;
                            iMakeMeasureSpec2 = i10;
                        } else {
                            int iC = coordinatorLayout.f7028n.c() + coordinatorLayout.f7028n.b();
                            int iA = coordinatorLayout.f7028n.a() + coordinatorLayout.f7028n.d();
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iC, mode);
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iA, mode2);
                        }
                        cVar = fVar.f7037a;
                        if (cVar != null) {
                            ArrayList arrayList4 = arrayList3;
                            int i30 = iMakeMeasureSpec;
                            arrayList = arrayList4;
                            z9 = false;
                            i16 = paddingRight;
                            i17 = i11;
                            i18 = paddingLeft;
                            i19 = i27;
                            i20 = i26;
                            int i31 = iMakeMeasureSpec2;
                            zI = cVar.i(this, view2, i30, i13, i31);
                            view = view2;
                            iMakeMeasureSpec = i30;
                            i15 = i13;
                            i14 = i31;
                            if (zI) {
                                coordinatorLayout = this;
                            }
                            int iMax2 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                            int iMax3 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                            suggestedMinimumWidth = iMax2;
                            suggestedMinimumHeight = iMax3;
                        } else {
                            int i32 = i13;
                            i14 = iMakeMeasureSpec2;
                            view = view2;
                            arrayList = arrayList3;
                            i15 = i32;
                            i16 = paddingRight;
                            i17 = i11;
                            z9 = false;
                            i18 = paddingLeft;
                            i19 = i27;
                            i20 = i26;
                        }
                        coordinatorLayout = this;
                        coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i15, i14, 0);
                        int iMax4 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int iMax5 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        suggestedMinimumWidth = iMax4;
                        suggestedMinimumHeight = iMax5;
                    } else {
                        iMax = Math.max(0, (size - paddingRight) - iG);
                    }
                    int i33 = size3;
                    i13 = iMax;
                    i12 = i33;
                    if (z11) {
                        iMakeMeasureSpec = i9;
                        iMakeMeasureSpec2 = i10;
                    } else {
                        iMakeMeasureSpec = i9;
                        iMakeMeasureSpec2 = i10;
                    }
                    cVar = fVar.f7037a;
                    if (cVar != null) {
                        ArrayList arrayList5 = arrayList3;
                        int i34 = iMakeMeasureSpec;
                        arrayList = arrayList5;
                        z9 = false;
                        i16 = paddingRight;
                        i17 = i11;
                        i18 = paddingLeft;
                        i19 = i27;
                        i20 = i26;
                        int i35 = iMakeMeasureSpec2;
                        zI = cVar.i(this, view2, i34, i13, i35);
                        view = view2;
                        iMakeMeasureSpec = i34;
                        i15 = i13;
                        i14 = i35;
                        if (zI) {
                            coordinatorLayout = this;
                        }
                        int iMax6 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                        int iMax7 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        suggestedMinimumWidth = iMax6;
                        suggestedMinimumHeight = iMax7;
                    } else {
                        int i36 = i13;
                        i14 = iMakeMeasureSpec2;
                        view = view2;
                        arrayList = arrayList3;
                        i15 = i36;
                        i16 = paddingRight;
                        i17 = i11;
                        z9 = false;
                        i18 = paddingLeft;
                        i19 = i27;
                        i20 = i26;
                    }
                    coordinatorLayout = this;
                    coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i15, i14, 0);
                    int iMax8 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                    int iMax9 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    suggestedMinimumWidth = iMax8;
                    suggestedMinimumHeight = iMax9;
                }
                i12 = size3;
                i13 = 0;
                if (z11) {
                    iMakeMeasureSpec = i9;
                    iMakeMeasureSpec2 = i10;
                } else {
                    iMakeMeasureSpec = i9;
                    iMakeMeasureSpec2 = i10;
                }
                cVar = fVar.f7037a;
                if (cVar != null) {
                    ArrayList arrayList6 = arrayList3;
                    int i37 = iMakeMeasureSpec;
                    arrayList = arrayList6;
                    z9 = false;
                    i16 = paddingRight;
                    i17 = i11;
                    i18 = paddingLeft;
                    i19 = i27;
                    i20 = i26;
                    int i38 = iMakeMeasureSpec2;
                    zI = cVar.i(this, view2, i37, i13, i38);
                    view = view2;
                    iMakeMeasureSpec = i37;
                    i15 = i13;
                    i14 = i38;
                    if (zI) {
                        coordinatorLayout = this;
                    }
                    int iMax10 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                    int iMax11 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    suggestedMinimumWidth = iMax10;
                    suggestedMinimumHeight = iMax11;
                } else {
                    int i39 = i13;
                    i14 = iMakeMeasureSpec2;
                    view = view2;
                    arrayList = arrayList3;
                    i15 = i39;
                    i16 = paddingRight;
                    i17 = i11;
                    z9 = false;
                    i18 = paddingLeft;
                    i19 = i27;
                    i20 = i26;
                }
                coordinatorLayout = this;
                coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i15, i14, 0);
                int iMax12 = Math.max(i19, view.getMeasuredWidth() + i24 + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
                int iMax13 = Math.max(i17, view.getMeasuredHeight() + i25 + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                suggestedMinimumWidth = iMax12;
                suggestedMinimumHeight = iMax13;
            }
            i26 = i20 + 1;
            arrayList3 = arrayList;
            size3 = i12;
            paddingLeft = i18;
            paddingRight = i16;
        }
        coordinatorLayout.setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i9, (-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(suggestedMinimumHeight, i10, iCombineMeasuredStates << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f6, float f9, boolean z8) {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0)) {
                    c cVar = fVar.f7037a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f6, float f9) {
        c cVar;
        int childCount = getChildCount();
        boolean zJ = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f7037a) != null) {
                    zJ |= cVar.j(view);
                }
            }
        }
        return zJ;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        onNestedPreScroll(view, i9, i10, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        onNestedScroll(view, i9, i10, i11, i12, 0);
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScrollAccepted(View view, View view2, int i9, int i10) {
        r rVar = this.f7033s;
        if (i10 == 1) {
            rVar.f4451b = i9;
        } else {
            rVar.f4450a = i9;
        }
        this.f7025k = view2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f7147a);
        SparseArray<Parcelable> sparseArray = savedState.f7034c;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            int id = childAt.getId();
            c cVar = h(childAt).f7037a;
            if (id != -1 && cVar != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVar.n(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableO;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).f7037a;
            if (id != -1 && cVar != null && (parcelableO = cVar.o(childAt)) != null) {
                sparseArray.append(id, parcelableO);
            }
        }
        savedState.f7034c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        return onStartNestedScroll(view, view2, i9, 0);
    }

    @Override // T.InterfaceC0429p
    public final void onStopNestedScroll(View view, int i9) {
        r rVar = this.f7033s;
        if (i9 == 1) {
            rVar.f4451b = 0;
        } else {
            rVar.f4450a = 0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i9)) {
                c cVar = fVar.f7037a;
                if (cVar != null) {
                    cVar.q(this, childAt, view, i9);
                }
                if (i9 == 0) {
                    fVar.f7048m = false;
                } else if (i9 == 1) {
                    fVar.f7049n = false;
                }
                fVar.f7050o = false;
            }
        }
        this.f7025k = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0035 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x004a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zM;
        boolean zR;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.j == null) {
            zM = m(motionEvent, 1);
            if (!zM) {
                zR = false;
            }
            motionEventObtain = null;
            if (this.j == null) {
                zR |= super.onTouchEvent(motionEvent);
            } else if (zM) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked == 1 && actionMasked != 3) {
                return zR;
            }
            o(false);
            return zR;
        }
        zM = false;
        c cVar = ((f) this.j.getLayoutParams()).f7037a;
        if (cVar != null) {
            zR = cVar.r(this, this.j, motionEvent);
        } else {
            zR = false;
        }
        motionEventObtain = null;
        if (this.j == null) {
            zR |= super.onTouchEvent(motionEvent);
        } else if (zM) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked == 1) {
        }
        o(false);
        return zR;
    }

    public final void r() {
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (!getFitsSystemWindows()) {
            G.d.c(this, null);
            return;
        }
        if (this.f7032r == null) {
            this.f7032r = new a();
        }
        G.d.c(this, this.f7032r);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        c cVar = ((f) view.getLayoutParams()).f7037a;
        if (cVar == null || !cVar.m(this, view, rect, z8)) {
            return super.requestChildRectangleOnScreen(view, rect, z8);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        super.requestDisallowInterceptTouchEvent(z8);
        if (!z8 || this.f7022g) {
            return;
        }
        o(false);
        this.f7022g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z8) {
        super.setFitsSystemWindows(z8);
        r();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7031q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f7030p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7030p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f7030p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f7030p;
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.f7030p.setVisible(getVisibility() == 0, false);
                this.f7030p.setCallback(this);
            }
            WeakHashMap<View, L> weakHashMap2 = G.f4313a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i9) {
        setStatusBarBackground(new ColorDrawable(i9));
    }

    public void setStatusBarBackgroundResource(int i9) {
        setStatusBarBackground(i9 != 0 ? getContext().getDrawable(i9) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        boolean z8 = i9 == 0;
        Drawable drawable = this.f7030p;
        if (drawable == null || drawable.isVisible() == z8) {
            return;
        }
        this.f7030p.setVisible(z8, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7030p;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    @Override // T.InterfaceC0429p
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr, int i11) {
        c cVar;
        int childCount = getChildCount();
        boolean z8 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i11) && (cVar = fVar.f7037a) != null) {
                    int[] iArr2 = this.f7020e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.k(this, childAt, view, i9, i10, iArr2, i11);
                    iMax = i9 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i10 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z8 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z8) {
            j(1);
        }
    }

    @Override // T.InterfaceC0429p
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i9, i10, i11, i12, 0, this.f7021f);
    }

    @Override // T.InterfaceC0429p
    public final boolean onStartNestedScroll(View view, View view2, int i9, int i10) {
        int childCount = getChildCount();
        boolean z8 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f7037a;
                if (cVar != null) {
                    boolean zP = cVar.p(this, childAt, view, view2, i9, i10);
                    z8 |= zP;
                    if (i10 == 0) {
                        fVar.f7048m = zP;
                    } else if (i10 == 1) {
                        fVar.f7049n = zP;
                    }
                } else if (i10 == 0) {
                    fVar.f7048m = false;
                } else if (i10 == 1) {
                    fVar.f7049n = false;
                }
            }
        }
        return z8;
    }

    @Override // T.InterfaceC0430q
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        int iMin = 0;
        int iMin2 = 0;
        boolean z8 = false;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i13) && (cVar = fVar.f7037a) != null) {
                    int[] iArr2 = this.f7020e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.l(this, childAt, i10, i11, i12, iArr2);
                    if (i11 > 0) {
                        iMin = Math.max(iMin, iArr2[0]);
                    } else {
                        iMin = Math.min(iMin, iArr2[0]);
                    }
                    if (i12 > 0) {
                        iMin2 = Math.max(iMin2, iArr2[1]);
                    } else {
                        iMin2 = Math.min(iMin2, iArr2[1]);
                    }
                    z8 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMin;
        iArr[1] = iArr[1] + iMin2;
        if (z8) {
            j(1);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f7037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7041e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7042f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7043g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7044h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7045i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f7046k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f7047l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7048m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7049n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7050o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Rect f7051p;

        public f() {
            super(-2, -2);
            this.f7038b = false;
            this.f7039c = 0;
            this.f7040d = 0;
            this.f7041e = -1;
            this.f7042f = -1;
            this.f7043g = 0;
            this.f7044h = 0;
            this.f7051p = new Rect();
        }

        public final boolean a(int i9) {
            if (i9 == 0) {
                return this.f7048m;
            }
            if (i9 != 1) {
                return false;
            }
            return this.f7049n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) {
            c cVarNewInstance;
            super(context, attributeSet);
            this.f7038b = false;
            this.f7039c = 0;
            this.f7040d = 0;
            this.f7041e = -1;
            this.f7042f = -1;
            this.f7043g = 0;
            this.f7044h = 0;
            this.f7051p = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D.a.f1809b);
            this.f7039c = typedArrayObtainStyledAttributes.getInteger(0, 0);
            this.f7042f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            this.f7040d = typedArrayObtainStyledAttributes.getInteger(2, 0);
            this.f7041e = typedArrayObtainStyledAttributes.getInteger(6, -1);
            this.f7043g = typedArrayObtainStyledAttributes.getInt(5, 0);
            this.f7044h = typedArrayObtainStyledAttributes.getInt(4, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
            this.f7038b = zHasValue;
            if (zHasValue) {
                String string = typedArrayObtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.t;
                if (TextUtils.isEmpty(string)) {
                    cVarNewInstance = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.t;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.f7013v;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f7012u);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVarNewInstance = constructor.newInstance(context, attributeSet);
                    } catch (Exception e9) {
                        throw new RuntimeException(W5.e.l("Could not inflate Behavior subclass ", string), e9);
                    }
                }
                this.f7037a = cVarNewInstance;
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f7037a;
            if (cVar != null) {
                cVar.c(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f7038b = false;
            this.f7039c = 0;
            this.f7040d = 0;
            this.f7041e = -1;
            this.f7042f = -1;
            this.f7043g = 0;
            this.f7044h = 0;
            this.f7051p = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7038b = false;
            this.f7039c = 0;
            this.f7040d = 0;
            this.f7041e = -1;
            this.f7042f = -1;
            this.f7043g = 0;
            this.f7044h = 0;
            this.f7051p = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7038b = false;
            this.f7039c = 0;
            this.f7040d = 0;
            this.f7041e = -1;
            this.f7042f = -1;
            this.f7043g = 0;
            this.f7044h = 0;
            this.f7051p = new Rect();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        onNestedScrollAccepted(view, view2, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }
}
