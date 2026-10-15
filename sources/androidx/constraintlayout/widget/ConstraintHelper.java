package androidx.constraintlayout.widget;

import A.g;
import A.k;
import C.c;
import C.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f6797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f6799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f6800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View[] f6803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<Integer, String> f6804h;

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6797a = new int[32];
        this.f6803g = null;
        this.f6804h = new HashMap<>();
        this.f6799c = context;
        g(attributeSet);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    public final void a(String str) {
        Context context;
        int identifier;
        HashMap<String, Integer> map;
        if (str == null || str.length() == 0 || (context = this.f6799c) == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (!isInEditMode() || constraintLayout == null) {
            identifier = 0;
        } else {
            Integer num = (strTrim == null || (map = constraintLayout.f6817m) == null || !map.containsKey(strTrim)) ? null : constraintLayout.f6817m.get(strTrim);
            if (num instanceof Integer) {
                identifier = num.intValue();
            } else {
                identifier = 0;
            }
        }
        if (identifier == 0 && constraintLayout != null) {
            identifier = e(constraintLayout, strTrim);
        }
        if (identifier == 0) {
            try {
                identifier = c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
        }
        if (identifier != 0) {
            this.f6804h.put(Integer.valueOf(identifier), strTrim);
            b(identifier);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
        }
    }

    public final void b(int i9) {
        if (i9 == getId()) {
            return;
        }
        int i10 = this.f6798b + 1;
        int[] iArr = this.f6797a;
        if (i10 > iArr.length) {
            this.f6797a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f6797a;
        int i11 = this.f6798b;
        iArr2[i11] = i9;
        this.f6798b = i11 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f6799c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = constraintLayout.getChildAt(i9);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.a) && strTrim.equals(((ConstraintLayout.a) layoutParams).f6841U)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i9 = 0; i9 < this.f6798b; i9++) {
            View viewB = constraintLayout.b(this.f6797a[i9]);
            if (viewB != null) {
                viewB.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewB.setTranslationZ(viewB.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.f6799c.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = constraintLayout.getChildAt(i9);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public final View[] f(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f6803g;
        if (viewArr == null || viewArr.length != this.f6798b) {
            this.f6803g = new View[this.f6798b];
        }
        for (int i9 = 0; i9 < this.f6798b; i9++) {
            this.f6803g[i9] = constraintLayout.b(this.f6797a[i9]);
        }
        return this.f6803g;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f1778b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 19) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f6801e = string;
                    setIds(string);
                } else if (index == 20) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f6802f = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f6797a, this.f6798b);
    }

    public final void k() {
        if (this.f6800d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f6868l0 = this.f6800d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f6801e;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f6802f;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f6801e = str;
        if (str == null) {
            return;
        }
        int i9 = 0;
        this.f6798b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i9);
            if (iIndexOf == -1) {
                a(str.substring(i9));
                return;
            } else {
                a(str.substring(i9, iIndexOf));
                i9 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f6802f = str;
        if (str == null) {
            return;
        }
        int i9 = 0;
        this.f6798b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i9);
            if (iIndexOf == -1) {
                c(str.substring(i9));
                return;
            } else {
                c(str.substring(i9, iIndexOf));
                i9 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f6801e = null;
        this.f6798b = 0;
        for (int i9 : iArr) {
            b(i9);
        }
    }

    @Override // android.view.View
    public final void setTag(int i9, Object obj) {
        super.setTag(i9, obj);
        if (obj == null && this.f6801e == null) {
            b(i9);
        }
    }

    public void i() {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    public void h(g gVar, boolean z8) {
    }
}
