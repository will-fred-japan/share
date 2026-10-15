package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: UninitializedMessageException.java */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public j0() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
