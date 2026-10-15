package q6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RecordConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f20999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f21000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c[] f21001d;

    static {
        c cVar = new c("NONE", 0);
        f20998a = cVar;
        c cVar2 = new c("PAUSE", 1);
        f20999b = cVar2;
        c cVar3 = new c("PAUSE_RESUME", 2);
        f21000c = cVar3;
        f21001d = new c[]{cVar, cVar2, cVar3};
    }

    public c() {
        throw null;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f21001d.clone();
    }
}
