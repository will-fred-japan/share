package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
public interface TextureRegistry {

    @Keep
    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    @Keep
    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    @Keep
    public interface ImageTextureEntry {
        /* synthetic */ long id();

        void pushImage(Image image);

        /* synthetic */ void release();
    }

    @Keep
    public interface SurfaceProducer {

        public interface a {
        }

        Surface getForcedNewSurface();

        int getHeight();

        Surface getSurface();

        int getWidth();

        boolean handlesCropAndRotation();

        /* synthetic */ long id();

        /* synthetic */ void release();

        void scheduleFrame();

        void setCallback(a aVar);

        void setSize(int i9, int i10);
    }

    public interface a {
    }

    public interface b {
        void onTrimMemory(int i9);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f19702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f19703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ c[] f19704c;

        static {
            c cVar = new c("manual", 0);
            f19702a = cVar;
            c cVar2 = new c("resetInBackground", 1);
            f19703b = cVar2;
            f19704c = new c[]{cVar, cVar2};
        }

        public c() {
            throw null;
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f19704c.clone();
        }
    }

    @Keep
    public interface SurfaceTextureEntry {
        /* synthetic */ long id();

        /* synthetic */ void release();

        SurfaceTexture surfaceTexture();

        default void setOnFrameConsumedListener(a aVar) {
        }

        default void setOnTrimMemoryListener(b bVar) {
        }
    }
}
