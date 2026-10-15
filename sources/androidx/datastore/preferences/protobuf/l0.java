package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: UninitializedMessageException.java */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public l0() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
