package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF12' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f7307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f7308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f7309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ r0[] f7310f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f7311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7312b;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF10;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF11;

    /* JADX INFO: Fake field, exist only in values array */
    r0 EF12;

    /* JADX INFO: compiled from: WireFormat.java */
    public final enum a extends r0 {
    }

    /* JADX INFO: compiled from: WireFormat.java */
    public final enum b extends r0 {
    }

    /* JADX INFO: compiled from: WireFormat.java */
    public final enum c extends r0 {
    }

    /* JADX INFO: compiled from: WireFormat.java */
    public final enum d extends r0 {
    }

    static {
        r0 r0Var = new r0("DOUBLE", 0, s0.DOUBLE, 1);
        r0 r0Var2 = new r0("FLOAT", 1, s0.FLOAT, 5);
        s0 s0Var = s0.LONG;
        r0 r0Var3 = new r0("INT64", 2, s0Var, 0);
        r0 r0Var4 = new r0("UINT64", 3, s0Var, 0);
        s0 s0Var2 = s0.INT;
        r0 r0Var5 = new r0("INT32", 4, s0Var2, 0);
        r0 r0Var6 = new r0("FIXED64", 5, s0Var, 1);
        r0 r0Var7 = new r0("FIXED32", 6, s0Var2, 5);
        r0 r0Var8 = new r0("BOOL", 7, s0.BOOLEAN, 0);
        a aVar = new a("STRING", 8, s0.STRING, 2);
        f7307c = aVar;
        s0 s0Var3 = s0.MESSAGE;
        b bVar = new b("GROUP", 9, s0Var3, 3);
        f7308d = bVar;
        c cVar = new c("MESSAGE", 10, s0Var3, 2);
        f7309e = cVar;
        f7310f = new r0[]{r0Var, r0Var2, r0Var3, r0Var4, r0Var5, r0Var6, r0Var7, r0Var8, aVar, bVar, cVar, new d("BYTES", 11, s0.BYTE_STRING, 2), new r0("UINT32", 12, s0Var2, 0), new r0("ENUM", 13, s0.ENUM, 0), new r0("SFIXED32", 14, s0Var2, 5), new r0("SFIXED64", 15, s0Var, 1), new r0("SINT32", 16, s0Var2, 0), new r0("SINT64", 17, s0Var, 0)};
    }

    public r0(String str, int i9, s0 s0Var, int i10) {
        super(str, i9);
        this.f7311a = s0Var;
        this.f7312b = i10;
    }

    public static r0 valueOf(String str) {
        return (r0) Enum.valueOf(r0.class, str);
    }

    public static r0[] values() {
        return (r0[]) f7310f.clone();
    }
}
