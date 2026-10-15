package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.f;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class FlutterImageView extends View implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageReader f19322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Image f19323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f19324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f19325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f19327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19328g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f19330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f19331c;

        static {
            a aVar = new a("background", 0);
            f19329a = aVar;
            a aVar2 = new a("overlay", 1);
            f19330b = aVar2;
            f19331c = new a[]{aVar, aVar2};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f19331c.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterImageView(Context context, int i9, int i10, a aVar) {
        super(context, null);
        ImageReader imageReaderE = e(i9, i10);
        this.f19326e = false;
        this.f19328g = false;
        this.f19322a = imageReaderE;
        this.f19327f = aVar;
        setAlpha(0.0f);
        this.f19326e = Z6.b.a(getContext());
    }

    @SuppressLint({"WrongConstant"})
    public static ImageReader e(int i9, int i10) {
        if (i9 <= 0) {
            Locale locale = Locale.US;
            Log.w("FlutterImageView", "ImageReader width must be greater than 0, but given width=" + i9 + ", set width=1");
            i9 = 1;
        }
        if (i10 <= 0) {
            Locale locale2 = Locale.US;
            Log.w("FlutterImageView", "ImageReader height must be greater than 0, but given height=" + i10 + ", set height=1");
            i10 = 1;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i9, i10, 1, 3, 768L) : ImageReader.newInstance(i9, i10, 1, 3);
    }

    @Override // io.flutter.embedding.engine.renderer.f
    public final void b() {
        if (this.f19328g) {
            setAlpha(0.0f);
            d();
            this.f19324c = null;
            Image image = this.f19323b;
            if (image != null) {
                image.close();
                this.f19323b = null;
            }
            invalidate();
            this.f19328g = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.f
    public final void c(FlutterRenderer flutterRenderer) {
        if (this.f19327f.ordinal() == 0) {
            Surface surface = this.f19322a.getSurface();
            flutterRenderer.f19450c = surface;
            flutterRenderer.f19448a.onSurfaceWindowChanged(surface);
        }
        setAlpha(1.0f);
        this.f19325d = flutterRenderer;
        this.f19328g = true;
    }

    public final boolean d() {
        if (!this.f19328g) {
            return false;
        }
        Image imageAcquireLatestImage = this.f19322a.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            Image image = this.f19323b;
            if (image != null) {
                image.close();
                this.f19323b = null;
            }
            this.f19323b = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void f(int i9, int i10) {
        if (this.f19325d == null) {
            return;
        }
        if (i9 == this.f19322a.getWidth() && i10 == this.f19322a.getHeight()) {
            return;
        }
        Image image = this.f19323b;
        if (image != null) {
            image.close();
            this.f19323b = null;
        }
        this.f19322a.close();
        this.f19322a = e(i9, i10);
    }

    @Override // io.flutter.embedding.engine.renderer.f
    public FlutterRenderer getAttachedRenderer() {
        return this.f19325d;
    }

    public ImageReader getImageReader() {
        return this.f19322a;
    }

    public Surface getSurface() {
        return this.f19322a.getSurface();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Image image = this.f19323b;
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
                this.f19324c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
                hardwareBuffer.close();
            } else {
                Image.Plane[] planes = image.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.f19323b.getHeight();
                    Bitmap bitmap = this.f19324c;
                    if (bitmap == null || bitmap.getWidth() != rowStride || this.f19324c.getHeight() != height) {
                        this.f19324c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.rewind();
                    this.f19324c.copyPixelsFromBuffer(buffer);
                }
            }
        }
        Bitmap bitmap2 = this.f19324c;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        if (!this.f19326e) {
            super.onMeasure(i9, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i9), mode == 0 ? 1 : 0), Math.max(View.MeasureSpec.getSize(i10), View.MeasureSpec.getMode(i10) == 0 ? 1 : 0));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        if (i9 == this.f19322a.getWidth() && i10 == this.f19322a.getHeight()) {
            return;
        }
        if (this.f19327f == a.f19329a && this.f19328g) {
            f(i9, i10);
            FlutterRenderer flutterRenderer = this.f19325d;
            Surface surface = this.f19322a.getSurface();
            flutterRenderer.f19450c = surface;
            flutterRenderer.f19448a.onSurfaceWindowChanged(surface);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.f
    public final void a() {
    }

    @Override // io.flutter.embedding.engine.renderer.f
    public final void pause() {
    }
}
