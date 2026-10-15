package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6906c;

    public View getContent() {
        return this.f6905b;
    }

    public int getEmptyVisibility() {
        return this.f6906c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (iHeight / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i9) {
        View viewFindViewById;
        if (this.f6904a == i9) {
            return;
        }
        View view = this.f6905b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f6905b.getLayoutParams()).a0 = false;
            this.f6905b = null;
        }
        this.f6904a = i9;
        if (i9 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i9)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i9) {
        this.f6906c = i9;
    }
}
