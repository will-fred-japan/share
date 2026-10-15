package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.AbsSeekBar;

/* JADX INFO: renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0499k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f6624c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsSeekBar f6625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f6626b;

    public C0499k(AbsSeekBar absSeekBar) {
        this.f6625a = absSeekBar;
    }

    public void a(AttributeSet attributeSet, int i9) {
        AbsSeekBar absSeekBar = this.f6625a;
        K kE = K.e(absSeekBar.getContext(), attributeSet, f6624c, i9);
        Drawable drawableC = kE.c(0);
        if (drawableC != null) {
            if (drawableC instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableC;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i10 = 0; i10 < numberOfFrames; i10++) {
                    Drawable drawableB = b(animationDrawable.getFrame(i10), true);
                    drawableB.setLevel(10000);
                    animationDrawable2.addFrame(drawableB, animationDrawable.getDuration(i10));
                }
                animationDrawable2.setLevel(10000);
                drawableC = animationDrawable2;
            }
            absSeekBar.setIndeterminateDrawable(drawableC);
        }
        Drawable drawableC2 = kE.c(1);
        if (drawableC2 != null) {
            absSeekBar.setProgressDrawable(b(drawableC2, false));
        }
        kE.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable b(Drawable drawable, boolean z8) {
        if (drawable instanceof L.a) {
            L.a aVar = (L.a) drawable;
            Drawable drawableB = aVar.b();
            if (drawableB != null) {
                b(drawableB, z8);
                aVar.a();
                return drawable;
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i9 = 0; i9 < numberOfLayers; i9++) {
                    int id = layerDrawable.getId(i9);
                    drawableArr[i9] = b(layerDrawable.getDrawable(i9), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
                    layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
                    layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
                    layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
                    layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
                    layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
                    layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
                    layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
                    layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f6626b == null) {
                    this.f6626b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z8 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
