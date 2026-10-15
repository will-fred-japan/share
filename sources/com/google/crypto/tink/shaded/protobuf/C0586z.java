package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: InvalidProtocolBufferException.java */
/* JADX INFO: loaded from: classes.dex */
public class C0586z extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14185a;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.z$a */
    /* JADX INFO: compiled from: InvalidProtocolBufferException.java */
    public static class a extends C0586z {
        private static final long serialVersionUID = 3283890091615336259L;
    }

    public static C0586z a() {
        return new C0586z("Protocol message contained an invalid tag (zero).");
    }

    public static C0586z b() {
        return new C0586z("Protocol message had invalid UTF-8.");
    }

    public static a c() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C0586z d() {
        return new C0586z("CodedInputStream encountered a malformed varint.");
    }

    public static C0586z e() {
        return new C0586z("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C0586z f() {
        return new C0586z("Failed to parse the message.");
    }

    public static C0586z g() {
        return new C0586z("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
