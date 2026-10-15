package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6748b;

    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public float getCardElevation() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getMaxCardElevation() {
        throw null;
    }

    public boolean getPreventCornerOverlap() {
        return this.f6748b;
    }

    public float getRadius() {
        throw null;
    }

    public boolean getUseCompatPadding() {
        return this.f6747a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCardElevation(float f6) {
        throw null;
    }

    public void setMaxCardElevation(float f6) {
        throw null;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i9) {
        super.setMinimumHeight(i9);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i9) {
        super.setMinimumWidth(i9);
    }

    public void setPreventCornerOverlap(boolean z8) {
        if (z8 == this.f6748b) {
            return;
        }
        this.f6748b = z8;
        throw null;
    }

    public void setRadius(float f6) {
        throw null;
    }

    public void setUseCompatPadding(boolean z8) {
        if (this.f6747a == z8) {
            return;
        }
        this.f6747a = z8;
        throw null;
    }

    public void setCardBackgroundColor(int i9) {
        ColorStateList.valueOf(i9);
        throw null;
    }

    @Override // android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i9, int i10, int i11, int i12) {
    }
}
