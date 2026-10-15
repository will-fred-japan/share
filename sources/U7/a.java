package U7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BufferOverflow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f4750d;

    static {
        a aVar = new a("SUSPEND", 0);
        f4747a = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f4748b = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f4749c = aVar3;
        f4750d = new a[]{aVar, aVar2, aVar3};
    }

    public a() {
        throw null;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f4750d.clone();
    }
}
