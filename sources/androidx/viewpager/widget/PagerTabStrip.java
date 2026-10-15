package androidx.viewpager.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8407h;

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public final void a(float f6) {
        getHeight();
        throw null;
    }

    public boolean getDrawFullUnderline() {
        return this.f8404e;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), 0);
    }

    public int getTabIndicatorColor() {
        return this.f8403d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getHeight();
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f8405f) {
            return false;
        }
        float x8 = motionEvent.getX();
        float y8 = motionEvent.getY();
        if (action == 0) {
            this.f8406g = x8;
            this.f8407h = y8;
            this.f8405f = false;
            return true;
        }
        if (action == 1) {
            throw null;
        }
        if (action == 2) {
            float f6 = 0;
            if (Math.abs(x8 - this.f8406g) > f6 || Math.abs(y8 - this.f8407h) > f6) {
                this.f8405f = true;
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i9) {
        super.setBackgroundColor(i9);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
    }

    public void setDrawFullUnderline(boolean z8) {
        this.f8404e = z8;
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
        if (i12 < 0) {
            i12 = 0;
        }
        super.setPadding(i9, i10, i11, i12);
    }

    public void setTabIndicatorColor(int i9) {
        this.f8403d = i9;
        throw null;
    }

    public void setTabIndicatorColorResource(int i9) {
        setTabIndicatorColor(getContext().getColor(i9));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i9) {
        if (i9 < 0) {
            i9 = 0;
        }
        super.setTextSpacing(i9);
    }
}
