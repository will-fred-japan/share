package p038f2;

import android.app.Activity;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: KeyedWeakReference.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends WeakReference<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Object> f18671d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Activity activity, String str, String str2, ReferenceQueue referenceQueue) {
        super(activity, referenceQueue);
        a(activity, "referent");
        a(referenceQueue, "referenceQueue");
        a(str, "key");
        this.f18668a = str;
        a(str2, MTCommonConstants.Network.KEY_NAME);
        this.f18669b = str2;
        this.f18670c = System.currentTimeMillis();
        this.f18671d = new WeakReference<>(new Object());
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str.concat(" must not be null"));
        }
    }
}
