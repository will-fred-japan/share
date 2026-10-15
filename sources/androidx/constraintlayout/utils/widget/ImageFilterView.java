package androidx.constraintlayout.utils.widget;

import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6793f;

    public float getBrightness() {
        throw null;
    }

    public float getContrast() {
        throw null;
    }

    public float getCrossfade() {
        return this.f6791d;
    }

    public float getRound() {
        return this.f6793f;
    }

    public float getRoundPercent() {
        return this.f6792e;
    }

    public float getSaturation() {
        throw null;
    }

    public float getWarmth() {
        throw null;
    }

    public void setBrightness(float f6) {
        throw null;
    }

    public void setContrast(float f6) {
        throw null;
    }

    public void setCrossfade(float f6) {
        this.f6791d = f6;
    }

    public void setRound(float f6) {
        if (Float.isNaN(f6)) {
            this.f6793f = f6;
            float f9 = this.f6792e;
            this.f6792e = -1.0f;
            setRoundPercent(f9);
            return;
        }
        boolean z8 = this.f6793f != f6;
        this.f6793f = f6;
        if (f6 != 0.0f) {
            setClipToOutline(true);
            getWidth();
            getHeight();
            throw null;
        }
        setClipToOutline(false);
        if (z8) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f6) {
        boolean z8 = this.f6792e != f6;
        this.f6792e = f6;
        if (f6 != 0.0f) {
            setClipToOutline(true);
            Math.min(getWidth(), getHeight());
            throw null;
        }
        setClipToOutline(false);
        if (z8) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f6) {
        throw null;
    }

    public void setWarmth(float f6) {
        throw null;
    }

    private void setOverlay(boolean z8) {
    }
}
