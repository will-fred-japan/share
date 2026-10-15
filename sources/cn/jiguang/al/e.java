package cn.jiguang.al;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9257a = new e(new UUID(0, 0));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UUID f9258b;

    public e() {
        this(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e.class == obj.getClass() && this.f9258b.compareTo(((e) obj).f9258b) == 0;
    }

    public int hashCode() {
        return this.f9258b.hashCode();
    }

    public String toString() {
        return this.f9258b.toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public e(UUID uuid) {
        this.f9258b = uuid == null ? UUID.randomUUID() : uuid;
    }
}
