package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import cn.ikaile.ruoshui.client.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6384c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6384c = -1;
        int[] iArr = p059i.a.f19183k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        T.G.l(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        this.f6382a = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f6382a);
        }
    }

    private void setStacked(boolean z8) {
        if (this.f6383b != z8) {
            if (!z8 || this.f6382a) {
                this.f6383b = z8;
                setOrientation(z8 ? 1 : 0);
                setGravity(z8 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z8 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int iMakeMeasureSpec;
        boolean z8;
        int i11;
        int size = View.MeasureSpec.getSize(i9);
        int paddingBottom = 0;
        if (this.f6382a) {
            if (size > this.f6384c && this.f6383b) {
                setStacked(false);
            }
            this.f6384c = size;
        }
        if (this.f6383b || View.MeasureSpec.getMode(i9) != 1073741824) {
            iMakeMeasureSpec = i9;
            z8 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z8 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i10);
        if (this.f6382a && !this.f6383b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z8 = true;
        }
        if (z8) {
            super.onMeasure(i9, i10);
        }
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            i11 = -1;
            if (i12 >= childCount) {
                i12 = -1;
                break;
            } else if (getChildAt(i12).getVisibility() == 0) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            View childAt = getChildAt(i12);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f6383b) {
                int childCount2 = getChildCount();
                for (int i13 = i12 + 1; i13 < childCount2; i13++) {
                    if (getChildAt(i13).getVisibility() == 0) {
                        i11 = i13;
                        break;
                    }
                }
                paddingBottom = i11 >= 0 ? getChildAt(i11).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                paddingBottom = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap<View, T.L> weakHashMap = T.G.f4313a;
        if (getMinimumHeight() != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i10 == 0) {
                super.onMeasure(i9, i10);
            }
        }
    }

    public void setAllowStacking(boolean z8) {
        if (this.f6382a != z8) {
            this.f6382a = z8;
            if (!z8 && this.f6383b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
