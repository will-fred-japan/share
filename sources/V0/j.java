package V0;

import java.util.UUID;

/* JADX INFO: compiled from: RequestIdGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4818a = new a(0);

    /* JADX INFO: compiled from: RequestIdGenerator.java */
    public static class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            return UUID.randomUUID().toString();
        }
    }
}
