package p025d3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AsyncTaskManagerType.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f18504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f18505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ c[] f18506d;

    static {
        c cVar = new c("IO", 0);
        f18503a = cVar;
        c cVar2 = new c("LIGHT_WEIGHT", 1);
        f18504b = cVar2;
        c cVar3 = new c("TIME_SENSITIVE", 2);
        c cVar4 = new c("CPU", 3);
        f18505c = cVar4;
        f18506d = new c[]{cVar, cVar2, cVar3, cVar4};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f18506d.clone();
    }
}
