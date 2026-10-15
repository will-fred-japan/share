package p185x4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ServiceStatus.java */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f22345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f22346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ q[] f22347c;

    static {
        q qVar = new q("disabled", 0);
        f22345a = qVar;
        q qVar2 = new q("enabled", 1);
        f22346b = qVar2;
        f22347c = new q[]{qVar, qVar2};
    }

    public q() {
        throw null;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f22347c.clone();
    }
}
