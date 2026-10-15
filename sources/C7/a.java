package C7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Intrinsics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a[] f1807b;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f1806a = aVar;
        f1807b = new a[]{aVar, new a("UNDECIDED", 1), new a("RESUMED", 2)};
    }

    public a() {
        throw null;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1807b.clone();
    }
}
