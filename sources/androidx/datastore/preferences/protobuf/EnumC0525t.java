package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FieldType.java */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0525t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0525t f7324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0525t f7325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0525t[] f7326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0525t[] f7327e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7328a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0525t EF0;

    static {
        A a3 = A.DOUBLE;
        EnumC0525t enumC0525t = new EnumC0525t("DOUBLE", 0, 0, 1, a3);
        A a9 = A.FLOAT;
        EnumC0525t enumC0525t2 = new EnumC0525t("FLOAT", 1, 1, 1, a9);
        A a10 = A.LONG;
        EnumC0525t enumC0525t3 = new EnumC0525t("INT64", 2, 2, 1, a10);
        EnumC0525t enumC0525t4 = new EnumC0525t("UINT64", 3, 3, 1, a10);
        A a11 = A.INT;
        EnumC0525t enumC0525t5 = new EnumC0525t("INT32", 4, 4, 1, a11);
        EnumC0525t enumC0525t6 = new EnumC0525t("FIXED64", 5, 5, 1, a10);
        EnumC0525t enumC0525t7 = new EnumC0525t("FIXED32", 6, 6, 1, a11);
        A a12 = A.BOOLEAN;
        EnumC0525t enumC0525t8 = new EnumC0525t("BOOL", 7, 7, 1, a12);
        A a13 = A.STRING;
        EnumC0525t enumC0525t9 = new EnumC0525t("STRING", 8, 8, 1, a13);
        A a14 = A.MESSAGE;
        EnumC0525t enumC0525t10 = new EnumC0525t("MESSAGE", 9, 9, 1, a14);
        A a15 = A.BYTE_STRING;
        EnumC0525t enumC0525t11 = new EnumC0525t("BYTES", 10, 10, 1, a15);
        EnumC0525t enumC0525t12 = new EnumC0525t("UINT32", 11, 11, 1, a11);
        A a16 = A.ENUM;
        EnumC0525t enumC0525t13 = new EnumC0525t("ENUM", 12, 12, 1, a16);
        EnumC0525t enumC0525t14 = new EnumC0525t("SFIXED32", 13, 13, 1, a11);
        EnumC0525t enumC0525t15 = new EnumC0525t("SFIXED64", 14, 14, 1, a10);
        EnumC0525t enumC0525t16 = new EnumC0525t("SINT32", 15, 15, 1, a11);
        EnumC0525t enumC0525t17 = new EnumC0525t("SINT64", 16, 16, 1, a10);
        EnumC0525t enumC0525t18 = new EnumC0525t("GROUP", 17, 17, 1, a14);
        EnumC0525t enumC0525t19 = new EnumC0525t("DOUBLE_LIST", 18, 18, 2, a3);
        EnumC0525t enumC0525t20 = new EnumC0525t("FLOAT_LIST", 19, 19, 2, a9);
        EnumC0525t enumC0525t21 = new EnumC0525t("INT64_LIST", 20, 20, 2, a10);
        EnumC0525t enumC0525t22 = new EnumC0525t("UINT64_LIST", 21, 21, 2, a10);
        EnumC0525t enumC0525t23 = new EnumC0525t("INT32_LIST", 22, 22, 2, a11);
        EnumC0525t enumC0525t24 = new EnumC0525t("FIXED64_LIST", 23, 23, 2, a10);
        EnumC0525t enumC0525t25 = new EnumC0525t("FIXED32_LIST", 24, 24, 2, a11);
        EnumC0525t enumC0525t26 = new EnumC0525t("BOOL_LIST", 25, 25, 2, a12);
        EnumC0525t enumC0525t27 = new EnumC0525t("STRING_LIST", 26, 26, 2, a13);
        EnumC0525t enumC0525t28 = new EnumC0525t("MESSAGE_LIST", 27, 27, 2, a14);
        EnumC0525t enumC0525t29 = new EnumC0525t("BYTES_LIST", 28, 28, 2, a15);
        EnumC0525t enumC0525t30 = new EnumC0525t("UINT32_LIST", 29, 29, 2, a11);
        EnumC0525t enumC0525t31 = new EnumC0525t("ENUM_LIST", 30, 30, 2, a16);
        EnumC0525t enumC0525t32 = new EnumC0525t("SFIXED32_LIST", 31, 31, 2, a11);
        EnumC0525t enumC0525t33 = new EnumC0525t("SFIXED64_LIST", 32, 32, 2, a10);
        EnumC0525t enumC0525t34 = new EnumC0525t("SINT32_LIST", 33, 33, 2, a11);
        EnumC0525t enumC0525t35 = new EnumC0525t("SINT64_LIST", 34, 34, 2, a10);
        EnumC0525t enumC0525t36 = new EnumC0525t("DOUBLE_LIST_PACKED", 35, 35, 3, a3);
        f7324b = enumC0525t36;
        EnumC0525t enumC0525t37 = new EnumC0525t("FLOAT_LIST_PACKED", 36, 36, 3, a9);
        EnumC0525t enumC0525t38 = new EnumC0525t("INT64_LIST_PACKED", 37, 37, 3, a10);
        EnumC0525t enumC0525t39 = new EnumC0525t("UINT64_LIST_PACKED", 38, 38, 3, a10);
        EnumC0525t enumC0525t40 = new EnumC0525t("INT32_LIST_PACKED", 39, 39, 3, a11);
        EnumC0525t enumC0525t41 = new EnumC0525t("FIXED64_LIST_PACKED", 40, 40, 3, a10);
        EnumC0525t enumC0525t42 = new EnumC0525t("FIXED32_LIST_PACKED", 41, 41, 3, a11);
        EnumC0525t enumC0525t43 = new EnumC0525t("BOOL_LIST_PACKED", 42, 42, 3, a12);
        EnumC0525t enumC0525t44 = new EnumC0525t("UINT32_LIST_PACKED", 43, 43, 3, a11);
        EnumC0525t enumC0525t45 = new EnumC0525t("ENUM_LIST_PACKED", 44, 44, 3, a16);
        EnumC0525t enumC0525t46 = new EnumC0525t("SFIXED32_LIST_PACKED", 45, 45, 3, a11);
        EnumC0525t enumC0525t47 = new EnumC0525t("SFIXED64_LIST_PACKED", 46, 46, 3, a10);
        EnumC0525t enumC0525t48 = new EnumC0525t("SINT32_LIST_PACKED", 47, 47, 3, a11);
        EnumC0525t enumC0525t49 = new EnumC0525t("SINT64_LIST_PACKED", 48, 48, 3, a10);
        f7325c = enumC0525t49;
        f7327e = new EnumC0525t[]{enumC0525t, enumC0525t2, enumC0525t3, enumC0525t4, enumC0525t5, enumC0525t6, enumC0525t7, enumC0525t8, enumC0525t9, enumC0525t10, enumC0525t11, enumC0525t12, enumC0525t13, enumC0525t14, enumC0525t15, enumC0525t16, enumC0525t17, enumC0525t18, enumC0525t19, enumC0525t20, enumC0525t21, enumC0525t22, enumC0525t23, enumC0525t24, enumC0525t25, enumC0525t26, enumC0525t27, enumC0525t28, enumC0525t29, enumC0525t30, enumC0525t31, enumC0525t32, enumC0525t33, enumC0525t34, enumC0525t35, enumC0525t36, enumC0525t37, enumC0525t38, enumC0525t39, enumC0525t40, enumC0525t41, enumC0525t42, enumC0525t43, enumC0525t44, enumC0525t45, enumC0525t46, enumC0525t47, enumC0525t48, enumC0525t49, new EnumC0525t("GROUP_LIST", 49, 49, 2, a14), new EnumC0525t("MAP", 50, 50, 4, A.VOID)};
        EnumC0525t[] enumC0525tArrValues = values();
        f7326d = new EnumC0525t[enumC0525tArrValues.length];
        for (EnumC0525t enumC0525t50 : enumC0525tArrValues) {
            f7326d[enumC0525t50.f7328a] = enumC0525t50;
        }
    }

    public EnumC0525t(String str, int i9, int i10, int i11, A a3) {
        super(str, i9);
        this.f7328a = i10;
        int iB = C0524s.b(i11);
        if (iB == 1 || iB == 3) {
            a3.getClass();
        }
        if (i11 == 1) {
            a3.ordinal();
        }
    }

    public static EnumC0525t valueOf(String str) {
        return (EnumC0525t) Enum.valueOf(EnumC0525t.class, str);
    }

    public static EnumC0525t[] values() {
        return (EnumC0525t[]) f7327e.clone();
    }
}
