package Z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FlutterActivityLaunchConfigs.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f5582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h[] f5583c;

    static {
        h hVar = new h("opaque", 0);
        f5581a = hVar;
        h hVar2 = new h("transparent", 1);
        f5582b = hVar2;
        f5583c = new h[]{hVar, hVar2};
    }

    public h() {
        throw null;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f5583c.clone();
    }
}
