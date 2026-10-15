package Z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TransparencyMode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f5621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f5622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ s[] f5623c;

    static {
        s sVar = new s("opaque", 0);
        f5621a = sVar;
        s sVar2 = new s("transparent", 1);
        f5622b = sVar2;
        f5623c = new s[]{sVar, sVar2};
    }

    public s() {
        throw null;
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f5623c.clone();
    }
}
