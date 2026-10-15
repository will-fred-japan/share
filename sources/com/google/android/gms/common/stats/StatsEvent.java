package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int d();

    public abstract long e();

    public abstract String j();

    public final String toString() {
        return e() + "\t" + d() + "\t-1" + j();
    }
}
