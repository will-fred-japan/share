package a8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f5752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f5753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f5754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ d[] f5755e;

    static {
        d dVar = new d("SUCCESSFUL", 0);
        f5751a = dVar;
        d dVar2 = new d("REREGISTER", 1);
        f5752b = dVar2;
        d dVar3 = new d("CANCELLED", 2);
        f5753c = dVar3;
        d dVar4 = new d("ALREADY_SELECTED", 3);
        f5754d = dVar4;
        f5755e = new d[]{dVar, dVar2, dVar3, dVar4};
    }

    public d() {
        throw null;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f5755e.clone();
    }
}
