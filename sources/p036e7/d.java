package p036e7;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import com.engagelab.privates.common.constants.MTCommonConstants;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: FlutterLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f18632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p036e7.b f18634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlutterJNI f18635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExecutorService f18636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future<a> f18637g;

    /* JADX INFO: compiled from: FlutterLoader.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18639b;

        public a(String str, String str2) {
            this.f18638a = str;
            this.f18639b = str2;
        }
    }

    /* JADX INFO: compiled from: FlutterLoader.java */
    public static class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(new FlutterJNI(), Y6.b.a().f5269c);
        Y6.b.a().f5268b.getClass();
    }

    public static String c(Context context, String str) {
        if (!str.startsWith("--aot-shared-library-name=")) {
            throw new IllegalArgumentException("AOT shared library name flag was not specified correctly; please use --aot-shared-library-name=<path>.");
        }
        File file = new File(str.substring(26));
        try {
            String canonicalPath = file.getCanonicalPath();
            StringBuilder sbB = p171w.a.b(context.getApplicationContext().getFilesDir().getCanonicalPath());
            sbB.append(File.separator);
            boolean zStartsWith = canonicalPath.startsWith(sbB.toString());
            boolean zEndsWith = canonicalPath.endsWith(".so");
            if (zStartsWith && zEndsWith) {
                return "--aot-shared-library-name=".concat(canonicalPath);
            }
            Log.e("FlutterLoader", "External path " + canonicalPath + " rejected; not overriding aot-shared-library-name.");
            return null;
        } catch (IOException unused) {
            Log.e("FlutterLoader", "External path " + file.getPath() + " is not a valid path. Please ensure this shared AOT library exists.");
            return null;
        }
    }

    public final void a(Context context, String[] strArr) {
        if (this.f18631a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f18632b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            p170v7.a.b("FlutterLoader#ensureInitializationComplete");
            try {
                a aVar = this.f18637g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                arrayList.add("--icu-native-lib-path=" + this.f18634d.f18627d + File.separator + "libflutter.so");
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str.startsWith("--aot-shared-library-name=")) {
                            String strC = c(context, str);
                            if (strC != null) {
                                str = strC;
                                arrayList.add(str);
                            } else {
                                Log.w("FlutterLoader", "Skipping unsafe AOT shared library name flag: " + str + ". Please ensure that the library is vetted and placed in your application's internal storage.");
                            }
                        } else {
                            arrayList.add(str);
                        }
                    }
                }
                arrayList.add("--aot-shared-library-name=" + this.f18634d.f18624a);
                arrayList.add("--aot-shared-library-name=" + this.f18634d.f18627d + File.separator + this.f18634d.f18624a);
                StringBuilder sb = new StringBuilder();
                sb.append("--cache-dir-path=");
                sb.append(aVar.f18639b);
                arrayList.add(sb.toString());
                String str2 = this.f18634d.f18626c;
                arrayList.add("--domain-network-policy=" + this.f18634d.f18626c);
                this.f18632b.getClass();
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i9 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i9 == 0) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    i9 = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i9);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.containsKey("io.flutter.embedding.android.EnableImpeller")) {
                        if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller")) {
                            arrayList.add("--enable-impeller=true");
                        } else {
                            arrayList.add("--enable-impeller=false");
                        }
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                        arrayList.add("--enable-opengl-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                        arrayList.add("--enable-vulkan-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.DisableMergedPlatformUIThread", false)) {
                        throw new IllegalArgumentException("io.flutter.embedding.android.DisableMergedPlatformUIThread is no longer allowed.");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableFlutterGPU", false)) {
                        arrayList.add("--enable-flutter-gpu");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableSurfaceControl", false)) {
                        arrayList.add("--enable-surface-control");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=" + string);
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerLazyShaderInitialization")) {
                        arrayList.add("--impeller-lazy-shader-mode");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.ImpellerAntialiasLines")) {
                        arrayList.add("--impeller-antialias-lines");
                    }
                }
                arrayList.add("--leak-vm=" + (bundle == null ? true : bundle.getBoolean("io.flutter.embedding.android.LeakVM", true) ? "true" : "false"));
                this.f18635e.init(context, (String[]) arrayList.toArray(new String[0]), null, aVar.f18638a, aVar.f18639b, SystemClock.uptimeMillis() - this.f18633c, Build.VERSION.SDK_INT);
                this.f18631a = true;
                Trace.endSection();
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Exception e9) {
            Log.e("FlutterLoader", "Flutter initialization failed.", e9);
            throw new RuntimeException(e9);
        }
    }

    public final String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18634d.f18625b);
        return A.a.j(sb, File.separator, str);
    }

    public final void d(Context context) {
        b bVar = new b();
        if (this.f18632b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        p170v7.a.b("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f18632b = bVar;
            this.f18633c = SystemClock.uptimeMillis();
            this.f18634d = p036e7.a.a(applicationContext);
            e eVarA = e.a((DisplayManager) applicationContext.getSystemService("display"), this.f18635e);
            eVarA.f19825b.setAsyncWaitForVsyncDelegate(eVarA.f19827d);
            this.f18637g = this.f18636f.submit(new c(this, applicationContext));
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f18631a = false;
        this.f18635e = flutterJNI;
        this.f18636f = executorService;
    }
}
