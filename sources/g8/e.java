package g8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ReleaseMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f18992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ e[] f18993c;

    static {
        e eVar = new e("RELEASE", 0);
        f18991a = eVar;
        e eVar2 = new e("LOOP", 1);
        f18992b = eVar2;
        f18993c = new e[]{eVar, eVar2, new e("STOP", 2)};
    }

    public e() {
        throw null;
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f18993c.clone();
    }
}
