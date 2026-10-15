package pl.droidsonroids.gif;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class GifTextureView extends TextureView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20832c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f20833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f20834b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20835a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f20835a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20835a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20835a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20835a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20835a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20835a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20835a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20835a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType scaleType3 = ImageView.ScaleType.FIT_START;
        ImageView.ScaleType scaleType4 = ImageView.ScaleType.FIT_CENTER;
        ImageView.ScaleType scaleType5 = ImageView.ScaleType.FIT_END;
        ImageView.ScaleType scaleType6 = ImageView.ScaleType.CENTER;
        ImageView.ScaleType scaleType7 = ImageView.ScaleType.CENTER_CROP;
        ImageView.ScaleType scaleType8 = ImageView.ScaleType.CENTER_INSIDE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public final synchronized void b() {
        b bVar = this.f20834b;
        pl.droidsonroids.gif.b bVar2 = bVar.f20836a;
        synchronized (bVar2) {
            bVar2.f20841a = false;
        }
        setSuperSurfaceTextureListener(null);
        bVar.f20837b.m();
        bVar.interrupt();
        try {
            this.f20834b.join();
        } catch (InterruptedException e9) {
            e9.printStackTrace();
        }
        this.f20834b = new b(this);
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            Surface surface = new Surface(surfaceTexture);
            try {
                surface.unlockCanvasAndPost(surface.lockCanvas(null));
                surface.release();
            } catch (Throwable th) {
                surface.release();
                throw th;
            }
        }
    }

    public final void c(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float fJ = gifInfoHandle.j() / width;
        float fE = gifInfoHandle.e() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.j(), gifInfoHandle.e());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        switch (a.f20835a[this.f20833a.ordinal()]) {
            case 1:
                matrix.setScale(fJ, fE, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float fMin = 1.0f / Math.min(fJ, fE);
                matrix.setScale(fJ * fMin, fMin * fE, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float fMin2 = (((float) gifInfoHandle.j()) > width || ((float) gifInfoHandle.e()) > height) ? Math.min(1.0f / fJ, 1.0f / fE) : 1.0f;
                matrix.setScale(fJ * fMin2, fMin2 * fE, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(fJ, fE);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(fJ, fE);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(fJ, fE);
                break;
            case 7:
                return;
            case 8:
                matrix.set(null);
                matrix.preScale(fJ, fE);
                break;
        }
        super.setTransform(matrix);
    }

    public IOException getIOException() {
        b bVar = this.f20834b;
        IOException iOException = bVar.f20838c;
        if (iOException != null) {
            return iOException;
        }
        int iG = bVar.f20837b.g();
        int i9 = GifIOException.f20825c;
        if (iG == e.NO_ERROR.f20867b) {
            return null;
        }
        return new GifIOException(iG, null);
    }

    public ImageView.ScaleType getScaleType() {
        return this.f20833a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public final Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(null);
        return matrix;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        b bVar = this.f20834b;
        pl.droidsonroids.gif.b bVar2 = bVar.f20836a;
        synchronized (bVar2) {
            bVar2.f20841a = false;
        }
        setSuperSurfaceTextureListener(null);
        bVar.f20837b.m();
        bVar.interrupt();
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        long[] jArr = gifViewSavedState.f20840a[0];
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        this.f20834b.f20837b.i();
        super.onSaveInstanceState();
        throw null;
    }

    public void setFreezesAnimation(boolean z8) {
        throw null;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(h hVar) {
        b();
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z8) {
        if (z8 != isOpaque()) {
            super.setOpaque(z8);
            setInputSource(null);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.f20833a = scaleType;
        c(this.f20834b.f20837b);
    }

    public void setSpeed(float f6) {
        this.f20834b.f20837b.v(f6);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        throw null;
    }

    public static class b extends Thread implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pl.droidsonroids.gif.b f20836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final GifInfoHandle f20837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IOException f20838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<GifTextureView> f20839d;

        public b(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.f20836a = new pl.droidsonroids.gif.b();
            this.f20837b = new GifInfoHandle();
            this.f20839d = new WeakReference<>(gifTextureView);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
            GifTextureView gifTextureView = this.f20839d.get();
            if (gifTextureView != null) {
                GifInfoHandle gifInfoHandle = this.f20837b;
                int i11 = GifTextureView.f20832c;
                gifTextureView.c(gifInfoHandle);
            }
            pl.droidsonroids.gif.b bVar = this.f20836a;
            synchronized (bVar) {
                boolean z8 = bVar.f20841a;
                bVar.f20841a = true;
                if (!z8) {
                    bVar.notify();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            pl.droidsonroids.gif.b bVar = this.f20836a;
            synchronized (bVar) {
                bVar.f20841a = false;
            }
            this.f20837b.m();
            interrupt();
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f20839d.get() == null) {
                    return;
                }
                int i9 = GifTextureView.f20832c;
                throw null;
            } catch (IOException e9) {
                this.f20838c = e9;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
        }
    }
}
