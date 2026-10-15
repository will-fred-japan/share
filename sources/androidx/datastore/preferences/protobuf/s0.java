package androidx.datastore.preferences.protobuf;

import java.io.Serializable;

/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes.dex */
public enum s0 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC0513g.f7223b),
    ENUM(null),
    MESSAGE(null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f7323a;

    s0(Serializable serializable) {
        this.f7323a = serializable;
    }
}
