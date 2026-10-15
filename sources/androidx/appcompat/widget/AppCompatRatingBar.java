package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0499k f6340a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        F.a(getContext(), this);
        C0499k c0499k = new C0499k(this);
        this.f6340a = c0499k;
        c0499k.a(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        Bitmap bitmap = this.f6340a.f6626b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i9, 0), getMeasuredHeight());
        }
    }
}
