package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ProtoSyntax.java */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f7201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f7202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f7203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ b0[] f7204d;

    static {
        b0 b0Var = new b0("PROTO2", 0);
        f7201a = b0Var;
        b0 b0Var2 = new b0("PROTO3", 1);
        f7202b = b0Var2;
        b0 b0Var3 = new b0("EDITIONS", 2);
        f7203c = b0Var3;
        f7204d = new b0[]{b0Var, b0Var2, b0Var3};
    }

    public b0() {
        throw null;
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) f7204d.clone();
    }
}
