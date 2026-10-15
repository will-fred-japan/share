package com.starburst.sdk.common.okhttp.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class Platform {
    private static final Platform PLATFORM = findPlatform();

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        @Override // com.starburst.sdk.common.okhttp.utils.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException unused) {
            return new Platform();
        }
    }

    public static Platform get() {
        Platform platform = PLATFORM;
        L.e(platform.getClass().toString());
        return platform;
    }

    public Executor defaultCallbackExecutor() {
        return Executors.newCachedThreadPool();
    }

    public void execute(Runnable runnable) {
        defaultCallbackExecutor().execute(runnable);
    }
}
