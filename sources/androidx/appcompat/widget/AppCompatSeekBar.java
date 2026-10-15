package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSeekBar extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0501m f6341a;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        F.a(getContext(), this);
        C0501m c0501m = new C0501m(this);
        this.f6341a = c0501m;
        c0501m.a(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0501m c0501m = this.f6341a;
        Drawable drawable = c0501m.f6628e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        AppCompatSeekBar appCompatSeekBar = c0501m.f6627d;
        if (drawable.setState(appCompatSeekBar.getDrawableState())) {
            appCompatSeekBar.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6341a.f6628e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f6341a.d(canvas);
    }
}
