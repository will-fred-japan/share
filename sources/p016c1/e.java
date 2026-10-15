package p016c1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AsyncTaskType.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f8687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f8688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e[] f8689d;

    static {
        e eVar = new e("IO", 0);
        f8686a = eVar;
        e eVar2 = new e("TIME_SENSITIVE", 1);
        f8687b = eVar2;
        e eVar3 = new e("LIGHT_WEIGHT", 2);
        f8688c = eVar3;
        f8689d = new e[]{eVar, eVar2, eVar3};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f8689d.clone();
    }
}
