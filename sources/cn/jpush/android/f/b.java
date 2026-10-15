package cn.jpush.android.f;

import android.annotation.TargetApi;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11377b;

    public b(String str, long j) {
        this.f11376a = str;
        this.f11377b = j;
    }

    @TargetApi(19)
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f11377b == bVar.f11377b && Objects.equals(this.f11376a, bVar.f11376a)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public final int hashCode() {
        return Objects.hash(this.f11376a, Long.valueOf(this.f11377b));
    }
}
