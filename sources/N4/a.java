package N4;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f3203c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f3204d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f3205a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f3206b;

    public a(Context context) {
        this.f3206b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.f3205a;
        reentrantLock.lock();
        try {
            return this.f3206b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
