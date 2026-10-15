package p185x4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LocationAccuracyStatus.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f22316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f22317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h[] f22318c;

    static {
        h hVar = new h("reduced", 0);
        f22316a = hVar;
        h hVar2 = new h("precise", 1);
        f22317b = hVar2;
        f22318c = new h[]{hVar, hVar2};
    }

    public h() {
        throw null;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f22318c.clone();
    }
}
