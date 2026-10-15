package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LifecycleDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0545k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f7740a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.lifecycle.k$a */
    /* JADX INFO: compiled from: LifecycleDispatcher.kt */
    public static final class a extends C0539e {
        @Override // androidx.lifecycle.C0539e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            x.a.b(activity);
        }
    }
}
