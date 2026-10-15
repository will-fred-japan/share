package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f6578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f6579d;

    public interface a {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6576a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p059i.a.f19173A, 0, 0);
        this.f6577b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f6576a = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(0, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f6576a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f6579d;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f6576a, viewGroup, false);
        int i9 = this.f6577b;
        if (i9 != -1) {
            viewInflate.setId(i9);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f6578c = new WeakReference<>(viewInflate);
        return viewInflate;
    }

    public int getInflatedId() {
        return this.f6577b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f6579d;
    }

    public int getLayoutResource() {
        return this.f6576a;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i9) {
        this.f6577b = i9;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f6579d = layoutInflater;
    }

    public void setLayoutResource(int i9) {
        this.f6576a = i9;
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        WeakReference<View> weakReference = this.f6578c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i9);
            return;
        }
        super.setVisibility(i9);
        if (i9 == 0 || i9 == 4) {
            a();
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    public void setOnInflateListener(a aVar) {
    }
}
