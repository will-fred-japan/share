package p185x4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LocationAccuracy.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f22308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f22309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f22310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f22311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f22312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f22313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ f[] f22314g;

    static {
        f fVar = new f("lowest", 0);
        f22308a = fVar;
        f fVar2 = new f("low", 1);
        f22309b = fVar2;
        f fVar3 = new f("medium", 2);
        f22310c = fVar3;
        f fVar4 = new f("high", 3);
        f22311d = fVar4;
        f fVar5 = new f("best", 4);
        f22312e = fVar5;
        f fVar6 = new f("bestForNavigation", 5);
        f22313f = fVar6;
        f22314g = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6};
    }

    public f() {
        throw null;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f22314g.clone();
    }
}
