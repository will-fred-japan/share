package androidx.preference.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class PreferenceImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7890b;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7889a = Integer.MAX_VALUE;
        this.f7890b = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f7886h, 0, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f7890b;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f7889a;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i9);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i9);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i9 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i10);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i10 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i9, i10);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i9) {
        this.f7890b = i9;
        super.setMaxHeight(i9);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i9) {
        this.f7889a = i9;
        super.setMaxWidth(i9);
    }
}
