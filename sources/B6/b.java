package B6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SidePattern.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f1751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ b[] f1752c;

    static {
        b bVar = new b("DEFAULT", 0);
        f1750a = bVar;
        b bVar2 = new b("LEFT", 1);
        b bVar3 = new b("RIGHT", 2);
        b bVar4 = new b("TOP", 3);
        b bVar5 = new b("BOTTOM", 4);
        b bVar6 = new b("AUTO_HORIZONTAL", 5);
        b bVar7 = new b("AUTO_VERTICAL", 6);
        b bVar8 = new b("AUTO_SIDE", 7);
        b bVar9 = new b("RESULT_LEFT", 8);
        b bVar10 = new b("RESULT_RIGHT", 9);
        b bVar11 = new b("RESULT_TOP", 10);
        b bVar12 = new b("RESULT_BOTTOM", 11);
        b bVar13 = new b("RESULT_HORIZONTAL", 12);
        f1751b = bVar13;
        f1752c = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10, bVar11, bVar12, bVar13, new b("RESULT_VERTICAL", 13), new b("RESULT_SIDE", 14)};
    }

    public b() {
        throw null;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f1752c.clone();
    }
}
