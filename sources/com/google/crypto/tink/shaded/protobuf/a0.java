package com.google.crypto.tink.shaded.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ProtoSyntax.java */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f14037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f14038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f14039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a0[] f14040d;

    static {
        a0 a0Var = new a0("PROTO2", 0);
        f14037a = a0Var;
        a0 a0Var2 = new a0("PROTO3", 1);
        f14038b = a0Var2;
        a0 a0Var3 = new a0("EDITIONS", 2);
        f14039c = a0Var3;
        f14040d = new a0[]{a0Var, a0Var2, a0Var3};
    }

    public a0() {
        throw null;
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) f14040d.clone();
    }
}
