package g8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PlayerMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d[] f18990b;

    static {
        d dVar = new d("MEDIA_PLAYER", 0);
        f18989a = dVar;
        f18990b = new d[]{dVar, new d("LOW_LATENCY", 1)};
    }

    public d() {
        throw null;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f18990b.clone();
    }
}
