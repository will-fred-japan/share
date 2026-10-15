package D0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: VerificationMode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f1832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f1833b;

    /* JADX INFO: Fake field, exist only in values array */
    h EF0;

    static {
        h hVar = new h("STRICT", 0);
        h hVar2 = new h("LOG", 1);
        h hVar3 = new h("QUIET", 2);
        f1832a = hVar3;
        f1833b = new h[]{hVar, hVar2, hVar3};
    }

    public h() {
        throw null;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f1833b.clone();
    }
}
