package p194y4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LocationPermission.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f22380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f22381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ a[] f22382e;

    static {
        a aVar = new a("denied", 0);
        f22378a = aVar;
        a aVar2 = new a("deniedForever", 1);
        f22379b = aVar2;
        a aVar3 = new a("whileInUse", 2);
        f22380c = aVar3;
        a aVar4 = new a("always", 3);
        f22381d = aVar4;
        f22382e = new a[]{aVar, aVar2, aVar3, aVar4};
    }

    public a() {
        throw null;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f22382e.clone();
    }
}
