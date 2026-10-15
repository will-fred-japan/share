package com.google.crypto.tink.shaded.protobuf;

import androidx.datastore.preferences.protobuf.C0524s;

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
/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FieldType.java */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0580t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0580t f14161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0580t f14162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0580t[] f14163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0580t[] f14164e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14165a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0580t EF0;

    static {
        A a3 = A.DOUBLE;
        EnumC0580t enumC0580t = new EnumC0580t("DOUBLE", 0, 0, 1, a3);
        A a9 = A.FLOAT;
        EnumC0580t enumC0580t2 = new EnumC0580t("FLOAT", 1, 1, 1, a9);
        A a10 = A.LONG;
        EnumC0580t enumC0580t3 = new EnumC0580t("INT64", 2, 2, 1, a10);
        EnumC0580t enumC0580t4 = new EnumC0580t("UINT64", 3, 3, 1, a10);
        A a11 = A.INT;
        EnumC0580t enumC0580t5 = new EnumC0580t("INT32", 4, 4, 1, a11);
        EnumC0580t enumC0580t6 = new EnumC0580t("FIXED64", 5, 5, 1, a10);
        EnumC0580t enumC0580t7 = new EnumC0580t("FIXED32", 6, 6, 1, a11);
        A a12 = A.BOOLEAN;
        EnumC0580t enumC0580t8 = new EnumC0580t("BOOL", 7, 7, 1, a12);
        A a13 = A.STRING;
        EnumC0580t enumC0580t9 = new EnumC0580t("STRING", 8, 8, 1, a13);
        A a14 = A.MESSAGE;
        EnumC0580t enumC0580t10 = new EnumC0580t("MESSAGE", 9, 9, 1, a14);
        A a15 = A.BYTE_STRING;
        EnumC0580t enumC0580t11 = new EnumC0580t("BYTES", 10, 10, 1, a15);
        EnumC0580t enumC0580t12 = new EnumC0580t("UINT32", 11, 11, 1, a11);
        A a16 = A.ENUM;
        EnumC0580t enumC0580t13 = new EnumC0580t("ENUM", 12, 12, 1, a16);
        EnumC0580t enumC0580t14 = new EnumC0580t("SFIXED32", 13, 13, 1, a11);
        EnumC0580t enumC0580t15 = new EnumC0580t("SFIXED64", 14, 14, 1, a10);
        EnumC0580t enumC0580t16 = new EnumC0580t("SINT32", 15, 15, 1, a11);
        EnumC0580t enumC0580t17 = new EnumC0580t("SINT64", 16, 16, 1, a10);
        EnumC0580t enumC0580t18 = new EnumC0580t("GROUP", 17, 17, 1, a14);
        EnumC0580t enumC0580t19 = new EnumC0580t("DOUBLE_LIST", 18, 18, 2, a3);
        EnumC0580t enumC0580t20 = new EnumC0580t("FLOAT_LIST", 19, 19, 2, a9);
        EnumC0580t enumC0580t21 = new EnumC0580t("INT64_LIST", 20, 20, 2, a10);
        EnumC0580t enumC0580t22 = new EnumC0580t("UINT64_LIST", 21, 21, 2, a10);
        EnumC0580t enumC0580t23 = new EnumC0580t("INT32_LIST", 22, 22, 2, a11);
        EnumC0580t enumC0580t24 = new EnumC0580t("FIXED64_LIST", 23, 23, 2, a10);
        EnumC0580t enumC0580t25 = new EnumC0580t("FIXED32_LIST", 24, 24, 2, a11);
        EnumC0580t enumC0580t26 = new EnumC0580t("BOOL_LIST", 25, 25, 2, a12);
        EnumC0580t enumC0580t27 = new EnumC0580t("STRING_LIST", 26, 26, 2, a13);
        EnumC0580t enumC0580t28 = new EnumC0580t("MESSAGE_LIST", 27, 27, 2, a14);
        EnumC0580t enumC0580t29 = new EnumC0580t("BYTES_LIST", 28, 28, 2, a15);
        EnumC0580t enumC0580t30 = new EnumC0580t("UINT32_LIST", 29, 29, 2, a11);
        EnumC0580t enumC0580t31 = new EnumC0580t("ENUM_LIST", 30, 30, 2, a16);
        EnumC0580t enumC0580t32 = new EnumC0580t("SFIXED32_LIST", 31, 31, 2, a11);
        EnumC0580t enumC0580t33 = new EnumC0580t("SFIXED64_LIST", 32, 32, 2, a10);
        EnumC0580t enumC0580t34 = new EnumC0580t("SINT32_LIST", 33, 33, 2, a11);
        EnumC0580t enumC0580t35 = new EnumC0580t("SINT64_LIST", 34, 34, 2, a10);
        EnumC0580t enumC0580t36 = new EnumC0580t("DOUBLE_LIST_PACKED", 35, 35, 3, a3);
        f14161b = enumC0580t36;
        EnumC0580t enumC0580t37 = new EnumC0580t("FLOAT_LIST_PACKED", 36, 36, 3, a9);
        EnumC0580t enumC0580t38 = new EnumC0580t("INT64_LIST_PACKED", 37, 37, 3, a10);
        EnumC0580t enumC0580t39 = new EnumC0580t("UINT64_LIST_PACKED", 38, 38, 3, a10);
        EnumC0580t enumC0580t40 = new EnumC0580t("INT32_LIST_PACKED", 39, 39, 3, a11);
        EnumC0580t enumC0580t41 = new EnumC0580t("FIXED64_LIST_PACKED", 40, 40, 3, a10);
        EnumC0580t enumC0580t42 = new EnumC0580t("FIXED32_LIST_PACKED", 41, 41, 3, a11);
        EnumC0580t enumC0580t43 = new EnumC0580t("BOOL_LIST_PACKED", 42, 42, 3, a12);
        EnumC0580t enumC0580t44 = new EnumC0580t("UINT32_LIST_PACKED", 43, 43, 3, a11);
        EnumC0580t enumC0580t45 = new EnumC0580t("ENUM_LIST_PACKED", 44, 44, 3, a16);
        EnumC0580t enumC0580t46 = new EnumC0580t("SFIXED32_LIST_PACKED", 45, 45, 3, a11);
        EnumC0580t enumC0580t47 = new EnumC0580t("SFIXED64_LIST_PACKED", 46, 46, 3, a10);
        EnumC0580t enumC0580t48 = new EnumC0580t("SINT32_LIST_PACKED", 47, 47, 3, a11);
        EnumC0580t enumC0580t49 = new EnumC0580t("SINT64_LIST_PACKED", 48, 48, 3, a10);
        f14162c = enumC0580t49;
        f14164e = new EnumC0580t[]{enumC0580t, enumC0580t2, enumC0580t3, enumC0580t4, enumC0580t5, enumC0580t6, enumC0580t7, enumC0580t8, enumC0580t9, enumC0580t10, enumC0580t11, enumC0580t12, enumC0580t13, enumC0580t14, enumC0580t15, enumC0580t16, enumC0580t17, enumC0580t18, enumC0580t19, enumC0580t20, enumC0580t21, enumC0580t22, enumC0580t23, enumC0580t24, enumC0580t25, enumC0580t26, enumC0580t27, enumC0580t28, enumC0580t29, enumC0580t30, enumC0580t31, enumC0580t32, enumC0580t33, enumC0580t34, enumC0580t35, enumC0580t36, enumC0580t37, enumC0580t38, enumC0580t39, enumC0580t40, enumC0580t41, enumC0580t42, enumC0580t43, enumC0580t44, enumC0580t45, enumC0580t46, enumC0580t47, enumC0580t48, enumC0580t49, new EnumC0580t("GROUP_LIST", 49, 49, 2, a14), new EnumC0580t("MAP", 50, 50, 4, A.VOID)};
        EnumC0580t[] enumC0580tArrValues = values();
        f14163d = new EnumC0580t[enumC0580tArrValues.length];
        for (EnumC0580t enumC0580t50 : enumC0580tArrValues) {
            f14163d[enumC0580t50.f14165a] = enumC0580t50;
        }
    }

    public EnumC0580t(String str, int i9, int i10, int i11, A a3) {
        super(str, i9);
        this.f14165a = i10;
        int iB = C0524s.b(i11);
        if (iB == 1 || iB == 3) {
            a3.getClass();
        }
        if (i11 == 1) {
            a3.ordinal();
        }
    }

    public static EnumC0580t valueOf(String str) {
        return (EnumC0580t) Enum.valueOf(EnumC0580t.class, str);
    }

    public static EnumC0580t[] values() {
        return (EnumC0580t[]) f14164e.clone();
    }
}
