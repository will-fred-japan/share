package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionBarBackgroundDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0490b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f6591a;

    public C0490b(ActionBarContainer actionBarContainer) {
        this.f6591a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f6591a;
        if (actionBarContainer.f6219h) {
            Drawable drawable = actionBarContainer.f6218g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f6216e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f6217f;
        if (drawable3 == null || !actionBarContainer.f6220i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f6591a;
        if (actionBarContainer.f6219h) {
            if (actionBarContainer.f6218g != null) {
                actionBarContainer.f6216e.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f6216e;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
