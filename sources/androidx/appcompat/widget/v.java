package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import cn.ikaile.ruoshui.client.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DropDownListView.java */
/* JADX INFO: loaded from: classes.dex */
public class v extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f6676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f6682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6684i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.core.widget.c f6685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f6686l;

    /* JADX INFO: compiled from: DropDownListView.java */
    public static class a {
        public static void a(View view, float f6, float f9) {
            view.drawableHotspotChanged(f6, f9);
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f6687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f6688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f6689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f6690d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f6687a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f6688b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f6689c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f6690d = true;
            } catch (NoSuchMethodException e9) {
                e9.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z8) {
            absListView.setSelectedChildViewEnabled(z8);
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    public static class d extends p074k.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6691b;

        @Override // p074k.a, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.f6691b) {
                super.draw(canvas);
            }
        }

        @Override // p074k.a, android.graphics.drawable.Drawable
        public final void setHotspot(float f6, float f9) {
            if (this.f6691b) {
                super.setHotspot(f6, f9);
            }
        }

        @Override // p074k.a, android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i9, int i10, int i11, int i12) {
            if (this.f6691b) {
                super.setHotspotBounds(i9, i10, i11, i12);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            if (this.f6691b) {
                return this.f19910a.setState(iArr);
            }
            return false;
        }

        @Override // p074k.a, android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z8, boolean z9) {
            if (this.f6691b) {
                return super.setVisible(z8, z9);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f6692a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                e9.printStackTrace();
            }
            f6692a = declaredField;
        }
    }

    /* JADX INFO: compiled from: DropDownListView.java */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            v vVar = v.this;
            vVar.f6686l = null;
            vVar.drawableStateChanged();
        }
    }

    public v(Context context, boolean z8) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f6676a = new Rect();
        this.f6677b = 0;
        this.f6678c = 0;
        this.f6679d = 0;
        this.f6680e = 0;
        this.f6684i = z8;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z8) {
        d dVar = this.f6682g;
        if (dVar != null) {
            dVar.f6691b = z8;
        }
    }

    public final int a(int i9, int i10) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i11 = 0;
        View view = null;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i13 = layoutParams.height;
            view.measure(i9, i13 > 0 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i12 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i10) {
                return i10;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0149  */
    /* JADX WARN: Code duplicated, block: B:81:0x015f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0164  */
    /* JADX WARN: Code duplicated, block: B:85:0x0168  */
    /* JADX WARN: Code duplicated, block: B:87:0x017a  */
    /* JADX WARN: Code duplicated, block: B:89:0x017e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0182  */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public final boolean b(MotionEvent motionEvent, int i9) {
        boolean z8;
        boolean zA;
        View childAt;
        View childAt2;
        androidx.core.widget.c cVar;
        int actionMasked = motionEvent.getActionMasked();
        boolean z9 = false;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                z8 = true;
            } else if (actionMasked != 3) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 || z9) {
                this.j = false;
                setPressed(false);
                drawableStateChanged();
                childAt2 = getChildAt(this.f6681f - getFirstVisiblePosition());
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
            }
            if (z8) {
                if (this.f6685k == null) {
                    this.f6685k = new androidx.core.widget.c(this);
                }
                androidx.core.widget.c cVar2 = this.f6685k;
                boolean z10 = cVar2.f7128p;
                cVar2.f7128p = true;
                cVar2.onTouch(this, motionEvent);
            } else {
                cVar = this.f6685k;
                if (cVar != null) {
                    if (cVar.f7128p) {
                        cVar.d();
                    }
                    cVar.f7128p = false;
                }
            }
            return z8;
        }
        z8 = false;
        int iFindPointerIndex = motionEvent.findPointerIndex(i9);
        if (iFindPointerIndex < 0) {
            z8 = false;
        } else {
            int x8 = (int) motionEvent.getX(iFindPointerIndex);
            int y8 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x8, y8);
            if (iPointToPosition == -1) {
                z9 = true;
            } else {
                View childAt3 = getChildAt(iPointToPosition - getFirstVisiblePosition());
                float f6 = x8;
                float f9 = y8;
                this.j = true;
                int i10 = Build.VERSION.SDK_INT;
                a.a(this, f6, f9);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i11 = this.f6681f;
                if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != childAt3 && childAt.isPressed()) {
                    childAt.setPressed(false);
                }
                this.f6681f = iPointToPosition;
                a.a(childAt3, f6 - childAt3.getLeft(), f9 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                boolean z11 = (selector == null || iPointToPosition == -1) ? false : true;
                if (z11) {
                    selector.setVisible(false, false);
                }
                int left = childAt3.getLeft();
                int top = childAt3.getTop();
                int right = childAt3.getRight();
                int bottom = childAt3.getBottom();
                Rect rect = this.f6676a;
                rect.set(left, top, right, bottom);
                rect.left -= this.f6677b;
                rect.top -= this.f6678c;
                rect.right += this.f6679d;
                rect.bottom += this.f6680e;
                if (i10 >= 33) {
                    zA = c.a(this);
                } else {
                    Field field = e.f6692a;
                    if (field != null) {
                        try {
                            zA = field.getBoolean(this);
                        } catch (IllegalAccessException e9) {
                            e9.printStackTrace();
                            zA = false;
                        }
                    } else {
                        zA = false;
                    }
                }
                if (childAt3.isEnabled() != zA) {
                    boolean z12 = !zA;
                    if (Build.VERSION.SDK_INT >= 33) {
                        c.b(this, z12);
                    } else {
                        Field field2 = e.f6692a;
                        if (field2 != null) {
                            try {
                                field2.set(this, Boolean.valueOf(z12));
                            } catch (IllegalAccessException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    if (iPointToPosition != -1) {
                        refreshDrawableState();
                    }
                }
                if (z11) {
                    float fExactCenterX = rect.exactCenterX();
                    float fExactCenterY = rect.exactCenterY();
                    selector.setVisible(getVisibility() == 0, false);
                    selector.setHotspot(fExactCenterX, fExactCenterY);
                }
                Drawable selector2 = getSelector();
                if (selector2 != null && iPointToPosition != -1) {
                    selector2.setHotspot(f6, f9);
                }
                setSelectorEnabled(false);
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, iPointToPosition, getItemIdAtPosition(iPointToPosition));
                }
                z8 = true;
                z9 = false;
            }
        }
        if (z8) {
            this.j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f6681f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        } else {
            this.j = false;
            setPressed(false);
            drawableStateChanged();
            childAt2 = getChildAt(this.f6681f - getFirstVisiblePosition());
            if (childAt2 != null) {
                childAt2.setPressed(false);
            }
        }
        if (z8) {
            if (this.f6685k == null) {
                this.f6685k = new androidx.core.widget.c(this);
            }
            androidx.core.widget.c cVar3 = this.f6685k;
            boolean z13 = cVar3.f7128p;
            cVar3.f7128p = true;
            cVar3.onTouch(this, motionEvent);
        } else {
            cVar = this.f6685k;
            if (cVar != null) {
                if (cVar.f7128p) {
                    cVar.d();
                }
                cVar.f7128p = false;
            }
        }
        return z8;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f6676a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f6686l != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable selector = getSelector();
        if (selector != null && this.j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f6684i || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f6684i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f6684i || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f6684i && this.f6683h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f6686l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i9 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f6686l == null) {
            f fVar = new f();
            this.f6686l = fVar;
            post(fVar);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return zOnHoverEvent;
        }
        int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i9 < 30 || !b.f6690d) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        b.f6687a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                        b.f6688b.invoke(this, Integer.valueOf(iPointToPosition));
                        b.f6689c.invoke(this, Integer.valueOf(iPointToPosition));
                    } catch (IllegalAccessException e9) {
                        e9.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.j && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f6681f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f6686l;
        if (fVar != null) {
            v vVar = v.this;
            vVar.f6686l = null;
            vVar.removeCallbacks(fVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z8) {
        this.f6683h = z8;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = null;
        if (drawable != null) {
            d dVar2 = new d();
            Drawable drawable2 = dVar2.f19910a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            dVar2.f19910a = drawable;
            drawable.setCallback(dVar2);
            dVar2.f6691b = true;
            dVar = dVar2;
        }
        this.f6682g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f6677b = rect.left;
        this.f6678c = rect.top;
        this.f6679d = rect.right;
        this.f6680e = rect.bottom;
    }
}
