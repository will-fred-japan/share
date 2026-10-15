package P7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: KVisibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ m[] f3643a = {new m("PUBLIC", 0), new m("PROTECTED", 1), new m("INTERNAL", 2), new m("PRIVATE", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    m EF5;

    public m() {
        throw null;
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f3643a.clone();
    }
}
