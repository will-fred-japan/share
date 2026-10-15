package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Build;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class GifInfoHandle {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f20830b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f20831a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (j.f20872a == null) {
                try {
                    j.f20872a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception e9) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e9);
                }
            }
            new E.a(1).c(j.f20872a, "pl_droidsonroids_gif");
        }
    }

    public GifInfoHandle(String str) {
        this.f20831a = openFile(str);
    }

    public static native int createTempNativeFileDescriptor();

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z8);

    private static native void free(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native int getWidth(long j);

    private static native boolean isOpaque(long j);

    public static native long openFile(String str);

    public static native long openNativeFileDescriptor(int i9, long j);

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToTime(long j, int i9, Bitmap bitmap);

    private static native void setLoopCount(long j, char c5);

    private static native void setSpeedFactor(long j, float f6);

    public final synchronized int a() {
        return getCurrentFrameIndex(this.f20831a);
    }

    public final synchronized int b() {
        return getCurrentLoop(this.f20831a);
    }

    public final synchronized int c() {
        return getCurrentPosition(this.f20831a);
    }

    public final synchronized int d() {
        return getDuration(this.f20831a);
    }

    public final synchronized int e() {
        return getHeight(this.f20831a);
    }

    public final synchronized int f() {
        return getLoopCount(this.f20831a);
    }

    public final void finalize() throws Throwable {
        try {
            n();
        } finally {
            super.finalize();
        }
    }

    public final synchronized int g() {
        return getNativeErrorCode(this.f20831a);
    }

    public final synchronized int h() {
        return getNumberOfFrames(this.f20831a);
    }

    public final synchronized long[] i() {
        return getSavedState(this.f20831a);
    }

    public final synchronized int j() {
        return getWidth(this.f20831a);
    }

    public final synchronized boolean k() {
        return isOpaque(this.f20831a);
    }

    public final synchronized boolean l() {
        return this.f20831a == 0;
    }

    public final synchronized void m() {
        postUnbindSurface(this.f20831a);
    }

    public final synchronized void n() {
        free(this.f20831a);
        this.f20831a = 0L;
    }

    public final synchronized long o(Bitmap bitmap) {
        return renderFrame(this.f20831a, bitmap);
    }

    public final synchronized boolean p() {
        return reset(this.f20831a);
    }

    public final synchronized long q() {
        return restoreRemainder(this.f20831a);
    }

    public final synchronized int r(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f20831a, jArr, bitmap);
    }

    public final synchronized void s() {
        saveRemainder(this.f20831a);
    }

    public final synchronized void t(Bitmap bitmap, int i9) {
        seekToTime(this.f20831a, i9, bitmap);
    }

    public final void u() {
        synchronized (this) {
            setLoopCount(this.f20831a, (char) 0);
        }
    }

    public final void v(float f6) {
        if (f6 <= 0.0f || Float.isNaN(f6)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f6 < 4.656613E-10f) {
            f6 = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f20831a, f6);
        }
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        int iCreateTempNativeFileDescriptor;
        try {
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
            long startOffset = assetFileDescriptor.getStartOffset();
            if (Build.VERSION.SDK_INT > 27) {
                try {
                    iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
                    Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Exception e9) {
                        throw new GifIOException(e.OPEN_FAILED.f20867b, e9.getMessage());
                    }
                }
            } else {
                iCreateTempNativeFileDescriptor = extractNativeFileDescriptor(fileDescriptor, false);
            }
            this.f20831a = openNativeFileDescriptor(iCreateTempNativeFileDescriptor, startOffset);
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }
}
