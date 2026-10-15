package q6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RecordConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f20991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f20992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f20993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f20994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f20996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f20997i;
    public static final /* synthetic */ b[] j;

    static {
        b bVar = new b("AacLc", 0);
        f20989a = bVar;
        b bVar2 = new b("AacEld", 1);
        f20990b = bVar2;
        b bVar3 = new b("AacHe", 2);
        f20991c = bVar3;
        b bVar4 = new b("AmrNb", 3);
        f20992d = bVar4;
        b bVar5 = new b("AmrWb", 4);
        f20993e = bVar5;
        b bVar6 = new b("Flac", 5);
        f20994f = bVar6;
        b bVar7 = new b("Pcm16bits", 6);
        f20995g = bVar7;
        b bVar8 = new b("Opus", 7);
        f20996h = bVar8;
        b bVar9 = new b("Wav", 8);
        f20997i = bVar9;
        j = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) j.clone();
    }
}
