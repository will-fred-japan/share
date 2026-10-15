package B6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ShowPattern.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ a[] f1749e;

    static {
        a aVar = new a("CURRENT_ACTIVITY", 0);
        f1745a = aVar;
        a aVar2 = new a("FOREGROUND", 1);
        f1746b = aVar2;
        a aVar3 = new a("BACKGROUND", 2);
        f1747c = aVar3;
        a aVar4 = new a("ALL_TIME", 3);
        f1748d = aVar4;
        f1749e = new a[]{aVar, aVar2, aVar3, aVar4};
    }

    public a() {
        throw null;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1749e.clone();
    }
}
