package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: InvalidProtocolBufferException.java */
/* JADX INFO: loaded from: classes.dex */
public class C0531z extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7345a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.z$a */
    /* JADX INFO: compiled from: InvalidProtocolBufferException.java */
    public static class a extends C0531z {
        private static final long serialVersionUID = 3283890091615336259L;
    }

    public static C0531z a() {
        return new C0531z("Protocol message had invalid UTF-8.");
    }

    public static a b() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static C0531z c() {
        return new C0531z("CodedInputStream encountered a malformed varint.");
    }

    public static C0531z d() {
        return new C0531z("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C0531z e() {
        return new C0531z("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
