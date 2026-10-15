package E2;

import android.app.Application;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: DowngradeDataStorage.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1959a;

    public b(Application application) {
        if (this.f1959a == null) {
            synchronized (this) {
                try {
                    if (this.f1959a == null) {
                        this.f1959a = application.getSharedPreferences("monitor_downgrade", 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
