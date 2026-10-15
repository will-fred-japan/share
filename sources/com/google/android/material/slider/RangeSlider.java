package com.google.android.material.slider;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RangeSlider extends BaseSlider<RangeSlider, Object, Object> {

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public float f13695M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f13696N;

    public static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13698b;

        public class a implements Parcelable.Creator<RangeSliderState> {
            @Override // android.os.Parcelable.Creator
            public final RangeSliderState createFromParcel(Parcel parcel) {
                return new RangeSliderState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final RangeSliderState[] newArray(int i9) {
                return new RangeSliderState[i9];
            }
        }

        public RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeFloat(this.f13697a);
            parcel.writeInt(this.f13698b);
        }

        public RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.f13697a = parcel.readFloat();
            this.f13698b = parcel.readInt();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float getMinSeparation() {
        return this.f13695M;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getThumbHeight() {
        return super.getThumbHeight();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getThumbTrackGapSize() {
        return super.getThumbTrackGapSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getThumbWidth() {
        return super.getThumbWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTickActiveRadius() {
        return super.getTickActiveRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTickInactiveRadius() {
        return super.getTickInactiveRadius();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackInsideCornerSize() {
        return super.getTrackInsideCornerSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackStopIndicatorSize() {
        return super.getTrackStopIndicatorSize();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public List<Float> getValues() {
        return super.getValues();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.f13695M = rangeSliderState.f13697a;
        int i9 = rangeSliderState.f13698b;
        this.f13696N = i9;
        setSeparationUnit(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        rangeSliderState.f13697a = this.f13695M;
        rangeSliderState.f13698b = this.f13696N;
        return rangeSliderState;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(int i9) {
        super.setCustomThumbDrawable(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(int... iArr) {
        super.setCustomThumbDrawablesForValues(iArr);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z8) {
        super.setEnabled(z8);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i9) {
        super.setFocusedThumbIndex(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(int i9) {
        super.setHaloRadius(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadiusResource(int i9) {
        super.setHaloRadiusResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int i9) {
        super.setLabelBehavior(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelFormatter(a aVar) {
        super.setLabelFormatter(aVar);
    }

    public void setMinSeparation(float f6) {
        this.f13695M = f6;
        this.f13696N = 0;
        setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f6) {
        this.f13695M = f6;
        this.f13696N = 1;
        setSeparationUnit(1);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f6) {
        super.setStepSize(f6);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f6) {
        super.setThumbElevation(f6);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevationResource(int i9) {
        super.setThumbElevationResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbHeight(int i9) {
        super.setThumbHeight(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbHeightResource(int i9) {
        super.setThumbHeightResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(int i9) {
        super.setThumbRadius(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadiusResource(int i9) {
        super.setThumbRadiusResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(int i9) {
        super.setThumbStrokeColorResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f6) {
        super.setThumbStrokeWidth(f6);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(int i9) {
        super.setThumbStrokeWidthResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTintList(ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTrackGapSize(int i9) {
        super.setThumbTrackGapSize(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbWidth(int i9) {
        super.setThumbWidth(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbWidthResource(int i9) {
        super.setThumbWidthResource(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveRadius(int i9) {
        super.setTickActiveRadius(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveRadius(int i9) {
        super.setTickInactiveRadius(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickTintList(ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickVisible(boolean z8) {
        super.setTickVisible(z8);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(int i9) {
        super.setTrackHeight(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInsideCornerSize(int i9) {
        super.setTrackInsideCornerSize(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackStopIndicatorSize(int i9) {
        super.setTrackStopIndicatorSize(i9);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackTintList(ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueFrom(float f6) {
        super.setValueFrom(f6);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueTo(float f6) {
        super.setValueTo(f6);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(Float... fArr) {
        super.setValues(fArr);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        super.setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(List<Float> list) {
        super.setValues(list);
    }
}
