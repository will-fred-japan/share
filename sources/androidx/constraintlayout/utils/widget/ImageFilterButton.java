package androidx.constraintlayout.utils.widget;

import androidx.appcompat.widget.AppCompatImageButton;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6790f;

    public float getContrast() {
        throw null;
    }

    public float getCrossfade() {
        return this.f6788d;
    }

    public float getRound() {
        return this.f6790f;
    }

    public float getRoundPercent() {
        return this.f6789e;
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
        this.f6788d = f6;
    }

    public void setRound(float f6) {
        if (Float.isNaN(f6)) {
            this.f6790f = f6;
            float f9 = this.f6789e;
            this.f6789e = -1.0f;
            setRoundPercent(f9);
            return;
        }
        boolean z8 = this.f6790f != f6;
        this.f6790f = f6;
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
        boolean z8 = this.f6789e != f6;
        this.f6789e = f6;
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
