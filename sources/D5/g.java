package D5;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: compiled from: IndeterminateDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<S> extends e {
    @Override // D5.e
    public final boolean b(boolean z8) {
        boolean zB = super.b(z8);
        if (isRunning()) {
            return zB;
        }
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            getBounds();
            throw null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        throw null;
    }
}
