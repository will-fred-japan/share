package c4;

import com.apm.insight.f;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f8770a = new AtomicBoolean(false);

    public static boolean a() {
        AtomicBoolean atomicBoolean = f8770a;
        synchronized (atomicBoolean) {
            try {
                if (atomicBoolean.get()) {
                    return false;
                }
                atomicBoolean.set(true);
                return b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        if (p152t4.a.a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1) {
            try {
                File file = new File(f.f11854b.getFilesDir(), "apminsight/crashCommand");
                file.mkdirs();
                new File(file, "0_" + System.currentTimeMillis()).createNewFile();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
