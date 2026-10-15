package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.ikaile.ruoshui.client.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int l(View view) {
        WeakHashMap<View, T.L> weakHashMap = T.G.f4313a;
        int minimumHeight = view.getMinimumHeight();
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return l(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int paddingLeft = getPaddingLeft();
        int i16 = i11 - i9;
        int paddingRight = i16 - getPaddingRight();
        int paddingRight2 = (i16 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i17 = gravity & 112;
        int i18 = gravity & 8388615;
        int paddingTop = i17 != 16 ? i17 != 80 ? getPaddingTop() : ((getPaddingTop() + i12) - i10) - measuredHeight : (((i12 - i10) - measuredHeight) / 2) + getPaddingTop();
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                int i20 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i20 < 0) {
                    i20 = i18;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i20, getLayoutDirection()) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i15 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i13 = paddingRight - measuredWidth;
                        i14 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    if (k(i19)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i21 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    childAt.layout(i15, i21, measuredWidth + i15, i21 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i21;
                } else {
                    i13 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i14 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i15 = i13 - i14;
                if (k(i19)) {
                    paddingTop += intrinsicHeight;
                }
                int i22 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                childAt.layout(i15, i22, measuredWidth + i15, i22 + measuredHeight2);
                paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin + i22;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i9, int i10) {
        int iCombineMeasuredStates;
        int iL;
        int measuredHeight;
        int measuredHeight2;
        AlertDialogLayout alertDialogLayout = this;
        int childCount = alertDialogLayout.getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = alertDialogLayout.getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        super.onMeasure(i9, i10);
                        return;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i9);
        int paddingBottom = alertDialogLayout.getPaddingBottom() + alertDialogLayout.getPaddingTop();
        if (view != null) {
            view.measure(i9, 0);
            paddingBottom += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i9, 0);
            iL = l(view2);
            measuredHeight = view2.getMeasuredHeight() - iL;
            paddingBottom += iL;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iL = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i9, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i12 = size - paddingBottom;
        if (view2 != null) {
            int i13 = paddingBottom - iL;
            int iMin = Math.min(i12, measuredHeight);
            if (iMin > 0) {
                i12 -= iMin;
                iL += iMin;
            }
            view2.measure(i9, View.MeasureSpec.makeMeasureSpec(iL, 1073741824));
            paddingBottom = i13 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i12 > 0) {
            view3.measure(i9, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i12, mode));
            paddingBottom = (paddingBottom - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = alertDialogLayout.getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        int i15 = i10;
        alertDialogLayout.setMeasuredDimension(View.resolveSizeAndState(alertDialogLayout.getPaddingRight() + alertDialogLayout.getPaddingLeft() + iMax, i9, iCombineMeasuredStates), View.resolveSizeAndState(paddingBottom, i15, 0));
        if (mode2 != 1073741824) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(alertDialogLayout.getMeasuredWidth(), 1073741824);
            int i16 = 0;
            while (i16 < childCount) {
                View childAt3 = alertDialogLayout.getChildAt(i16);
                if (childAt3.getVisibility() != 8) {
                    LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt3.getLayoutParams();
                    if (((LinearLayout.LayoutParams) aVar).width == -1) {
                        int i17 = ((LinearLayout.LayoutParams) aVar).height;
                        ((LinearLayout.LayoutParams) aVar).height = childAt3.getMeasuredHeight();
                        alertDialogLayout.measureChildWithMargins(childAt3, iMakeMeasureSpec, 0, i15, 0);
                        ((LinearLayout.LayoutParams) aVar).height = i17;
                    }
                }
                i16++;
                alertDialogLayout = this;
                i15 = i10;
            }
        }
    }
}
