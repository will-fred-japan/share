package io.flutter.plugin.platform;

import B0.C0304s;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* JADX INFO: compiled from: ImageReaderPlatformViewRenderTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRegistry.ImageTextureEntry f19591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageReader f19592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19593c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19594d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f19595e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f19596f = new a();

    /* JADX INFO: compiled from: ImageReaderPlatformViewRenderTarget.java */
    public class a implements ImageReader.OnImageAvailableListener {
        public a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public final void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireLatestImage;
            try {
                imageAcquireLatestImage = imageReader.acquireLatestImage();
            } catch (IllegalStateException e9) {
                Log.e("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e9);
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return;
            }
            b.this.f19591a.pushImage(imageAcquireLatestImage);
        }
    }

    public b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f19591a = imageTextureEntry;
    }

    @Override // io.flutter.plugin.platform.h
    public final long a() {
        return this.f19591a.id();
    }

    @Override // io.flutter.plugin.platform.h
    public final void b(int i9, int i10) {
        ImageReader imageReaderNewInstance;
        ImageReader imageReader = this.f19592b;
        if (imageReader != null && this.f19593c == i9 && this.f19594d == i10) {
            return;
        }
        if (imageReader != null) {
            this.f19591a.pushImage(null);
            this.f19592b.close();
            this.f19592b = null;
        }
        this.f19593c = i9;
        this.f19594d = i10;
        int i11 = Build.VERSION.SDK_INT;
        Handler handler = this.f19595e;
        a aVar = this.f19596f;
        if (i11 >= 33) {
            O6.b.i();
            ImageReader.Builder builderG = C0304s.g(this.f19593c, this.f19594d);
            builderG.setMaxImages(4);
            builderG.setImageFormat(34);
            builderG.setUsage(256L);
            imageReaderNewInstance = builderG.build();
            imageReaderNewInstance.setOnImageAvailableListener(aVar, handler);
        } else {
            if (i11 < 29) {
                throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
            }
            imageReaderNewInstance = ImageReader.newInstance(i9, i10, 34, 4, 256L);
            imageReaderNewInstance.setOnImageAvailableListener(aVar, handler);
        }
        this.f19592b = imageReaderNewInstance;
    }

    @Override // io.flutter.plugin.platform.h
    public final int getHeight() {
        return this.f19594d;
    }

    @Override // io.flutter.plugin.platform.h
    public final Surface getSurface() {
        return this.f19592b.getSurface();
    }

    @Override // io.flutter.plugin.platform.h
    public final int getWidth() {
        return this.f19593c;
    }

    @Override // io.flutter.plugin.platform.h
    public final void release() {
        if (this.f19592b != null) {
            this.f19591a.pushImage(null);
            this.f19592b.close();
            this.f19592b = null;
        }
        this.f19591a = null;
    }
}
