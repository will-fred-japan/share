package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;

/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes.dex */
public enum A {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(AbstractC0569h.class, AbstractC0569h.f14069b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f13997a;

    A(Class cls, Serializable serializable) {
        this.f13997a = serializable;
    }
}
