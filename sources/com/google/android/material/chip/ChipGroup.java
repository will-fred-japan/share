package com.google.android.material.chip;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13180f;

    public class a implements d {
    }

    public static class b extends ViewGroup.MarginLayoutParams {
    }

    @Deprecated
    public interface c {
    }

    public interface d {
    }

    private int getVisibleChipCount() {
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof Chip) && getChildAt(i10).getVisibility() == 0) {
                i9++;
            }
        }
        return i9;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean a() {
        return this.f13446c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        throw null;
    }

    public List<Integer> getCheckedChipIds() {
        throw null;
    }

    public int getChipSpacingHorizontal() {
        return this.f13179e;
    }

    public int getChipSpacingVertical() {
        return this.f13180f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f13446c) {
            getVisibleChipCount();
        }
        getRowCount();
        throw null;
    }

    public void setChipSpacing(int i9) {
        setChipSpacingHorizontal(i9);
        setChipSpacingVertical(i9);
    }

    public void setChipSpacingHorizontal(int i9) {
        if (this.f13179e != i9) {
            this.f13179e = i9;
            setItemSpacing(i9);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i9) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i9));
    }

    public void setChipSpacingResource(int i9) {
        setChipSpacing(getResources().getDimensionPixelOffset(i9));
    }

    public void setChipSpacingVertical(int i9) {
        if (this.f13180f != i9) {
            this.f13180f = i9;
            setLineSpacing(i9);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i9) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i9));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i9) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new a());
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        throw null;
    }

    public void setSelectionRequired(boolean z8) {
        throw null;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i9) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i9) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z8) {
        super.setSingleLine(z8);
    }

    public void setSingleSelection(boolean z8) {
        throw null;
    }

    public void setSingleLine(int i9) {
        setSingleLine(getResources().getBoolean(i9));
    }

    public void setSingleSelection(int i9) {
        setSingleSelection(getResources().getBoolean(i9));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public void setOnCheckedStateChangeListener(d dVar) {
    }
}
