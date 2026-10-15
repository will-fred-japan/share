package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class jm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f18102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short f916a;

    public jm() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<TField name:'");
        sb.append(this.f915a);
        sb.append("' type:");
        sb.append((int) this.f18102a);
        sb.append(" field-id:");
        return A.f.i(sb, this.f916a, ">");
    }

    public jm(String str, byte b9, short s8) {
        this.f915a = str;
        this.f18102a = b9;
        this.f916a = s8;
    }
}
