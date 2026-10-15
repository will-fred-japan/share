package cn.jpush.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    private int defaultRadius;
    private float height;
    private int leftBottomRadius;
    private int leftTopRadius;
    private int radius;
    private int rightBottomRadius;
    private int rightTopRadius;
    private float width;

    public RoundedImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i9 = this.defaultRadius;
        this.leftTopRadius = i9;
        this.rightTopRadius = i9;
        this.rightBottomRadius = i9;
        this.leftBottomRadius = i9;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iMax = Math.max(this.rightTopRadius, this.rightBottomRadius) + Math.max(this.leftTopRadius, this.leftBottomRadius);
        int iMax2 = Math.max(this.leftBottomRadius, this.rightBottomRadius) + Math.max(this.leftTopRadius, this.rightTopRadius);
        if (this.width >= iMax && this.height > iMax2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f6 = this.width;
            path.quadTo(f6, 0.0f, f6, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f9 = this.width;
            float f10 = this.height;
            path.quadTo(f9, f10, f9 - this.rightBottomRadius, f10);
            path.lineTo(this.leftBottomRadius, this.height);
            float f11 = this.height;
            path.quadTo(0.0f, f11, 0.0f, f11 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        this.width = getWidth();
        this.height = getHeight();
    }

    public void setRadius(int i9, int i10, int i11, int i12) {
        this.leftTopRadius = i9;
        this.rightTopRadius = i10;
        this.rightBottomRadius = i11;
        this.leftBottomRadius = i12;
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.defaultRadius = 45;
        init(context, attributeSet);
    }
}
