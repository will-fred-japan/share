package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;

/* JADX INFO: compiled from: SurfaceTexturePlatformViewRenderTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterRenderer.c f19664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f19665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f19666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19667d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19668e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19669f = false;

    /* JADX INFO: compiled from: SurfaceTexturePlatformViewRenderTarget.java */
    public class a implements TextureRegistry.b {
        public a() {
        }

        @Override // io.flutter.view.TextureRegistry.b
        public final void onTrimMemory(int i9) {
            if (i9 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            u.this.f19669f = true;
        }
    }

    public u(FlutterRenderer.c cVar) {
        a aVar = new a();
        this.f19664a = cVar;
        this.f19665b = cVar.f19467b.surfaceTexture();
        cVar.f19469d = aVar;
    }

    @Override // io.flutter.plugin.platform.h
    public final long a() {
        return this.f19664a.f19466a;
    }

    @Override // io.flutter.plugin.platform.h
    public final void b(int i9, int i10) {
        this.f19667d = i9;
        this.f19668e = i10;
        SurfaceTexture surfaceTexture = this.f19665b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i9, i10);
        }
    }

    @Override // io.flutter.plugin.platform.h
    public final int getHeight() {
        return this.f19668e;
    }

    @Override // io.flutter.plugin.platform.h
    public final Surface getSurface() {
        Surface surface = this.f19666c;
        if (surface == null || this.f19669f) {
            if (surface != null) {
                surface.release();
                this.f19666c = null;
            }
            this.f19666c = new Surface(this.f19665b);
            this.f19669f = false;
        }
        SurfaceTexture surfaceTexture = this.f19665b;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            return null;
        }
        return this.f19666c;
    }

    @Override // io.flutter.plugin.platform.h
    public final int getWidth() {
        return this.f19667d;
    }

    @Override // io.flutter.plugin.platform.h
    public final void release() {
        this.f19665b = null;
        Surface surface = this.f19666c;
        if (surface != null) {
            surface.release();
            this.f19666c = null;
        }
    }
}
