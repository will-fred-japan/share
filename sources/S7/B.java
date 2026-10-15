package S7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CoroutineStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f4224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final B f4225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ B[] f4226c;

    static {
        B b9 = new B("DEFAULT", 0);
        f4224a = b9;
        B b10 = new B("LAZY", 1);
        B b11 = new B("ATOMIC", 2);
        f4225b = b11;
        f4226c = new B[]{b9, b10, b11, new B("UNDISPATCHED", 3)};
    }

    public B() {
        throw null;
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) f4226c.clone();
    }
}
