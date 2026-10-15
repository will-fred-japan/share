package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* JADX INFO: compiled from: SurfaceProducerPlatformViewRenderTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRegistry.SurfaceProducer f19663a;

    @Override // io.flutter.plugin.platform.h
    public final long a() {
        return this.f19663a.id();
    }

    @Override // io.flutter.plugin.platform.h
    public final void b(int i9, int i10) {
        this.f19663a.setSize(i9, i10);
    }

    @Override // io.flutter.plugin.platform.h
    public final int getHeight() {
        return this.f19663a.getHeight();
    }

    @Override // io.flutter.plugin.platform.h
    public final Surface getSurface() {
        return this.f19663a.getSurface();
    }

    @Override // io.flutter.plugin.platform.h
    public final int getWidth() {
        return this.f19663a.getWidth();
    }

    @Override // io.flutter.plugin.platform.h
    public final void release() {
        this.f19663a.release();
        this.f19663a = null;
    }

    @Override // io.flutter.plugin.platform.h
    public final void scheduleFrame() {
        this.f19663a.scheduleFrame();
    }
}
