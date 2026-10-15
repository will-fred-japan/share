package Z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RenderMode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f5610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f5611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ q[] f5612c;

    static {
        q qVar = new q("surface", 0);
        f5610a = qVar;
        q qVar2 = new q("texture", 1);
        f5611b = qVar2;
        f5612c = new q[]{qVar, qVar2, new q("image", 2)};
    }

    public q() {
        throw null;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f5612c.clone();
    }
}
