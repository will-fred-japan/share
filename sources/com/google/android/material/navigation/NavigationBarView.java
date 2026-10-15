package com.google.android.material.navigation;

import H5.l;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.customview.view.AbsSavedState;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f13604c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f13604c = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeBundle(this.f13604c);
        }
    }

    public interface a {
    }

    public interface b {
    }

    private MenuInflater getMenuInflater() {
        return null;
    }

    public int getActiveIndicatorLabelPadding() {
        throw null;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        throw null;
    }

    public int getItemActiveIndicatorHeight() {
        throw null;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        throw null;
    }

    public l getItemActiveIndicatorShapeAppearance() {
        throw null;
    }

    public int getItemActiveIndicatorWidth() {
        throw null;
    }

    public Drawable getItemBackground() {
        throw null;
    }

    @Deprecated
    public int getItemBackgroundResource() {
        throw null;
    }

    public int getItemIconSize() {
        throw null;
    }

    public ColorStateList getItemIconTintList() {
        throw null;
    }

    public int getItemPaddingBottom() {
        throw null;
    }

    public int getItemPaddingTop() {
        throw null;
    }

    public ColorStateList getItemRippleColor() {
        throw null;
    }

    public int getItemTextAppearanceActive() {
        throw null;
    }

    public int getItemTextAppearanceInactive() {
        throw null;
    }

    public ColorStateList getItemTextColor() {
        throw null;
    }

    public int getLabelVisibilityMode() {
        throw null;
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return null;
    }

    public k getMenuView() {
        return null;
    }

    public NavigationBarPresenter getPresenter() {
        return null;
    }

    public int getSelectedItemId() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.z(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            super.onRestoreInstanceState(((SavedState) parcelable).f7147a);
            throw null;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        new SavedState(super.onSaveInstanceState()).f13604c = new Bundle();
        throw null;
    }

    public void setActiveIndicatorLabelPadding(int i9) {
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        j.w(this, f6);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setItemActiveIndicatorEnabled(boolean z8) {
        throw null;
    }

    public void setItemActiveIndicatorHeight(int i9) {
        throw null;
    }

    public void setItemActiveIndicatorMarginHorizontal(int i9) {
        throw null;
    }

    public void setItemActiveIndicatorShapeAppearance(l lVar) {
        throw null;
    }

    public void setItemActiveIndicatorWidth(int i9) {
        throw null;
    }

    public void setItemBackground(Drawable drawable) {
        throw null;
    }

    public void setItemBackgroundResource(int i9) {
        throw null;
    }

    public void setItemIconSize(int i9) {
        throw null;
    }

    public void setItemIconSizeRes(int i9) {
        setItemIconSize(getResources().getDimensionPixelSize(i9));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        throw null;
    }

    public void setItemPaddingBottom(int i9) {
        throw null;
    }

    public void setItemPaddingTop(int i9) {
        throw null;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setItemTextAppearanceActive(int i9) {
        throw null;
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z8) {
        throw null;
    }

    public void setItemTextAppearanceInactive(int i9) {
        throw null;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setLabelVisibilityMode(int i9) {
        throw null;
    }

    public void setSelectedItemId(int i9) {
        throw null;
    }

    public void setOnItemReselectedListener(a aVar) {
    }

    public void setOnItemSelectedListener(b bVar) {
    }
}
