package okio.internal;

/* JADX INFO: compiled from: ZipFiles.kt */
/* JADX INFO: loaded from: classes2.dex */
final class EocdRecord {
    private final long centralDirectoryOffset;
    private final int commentByteCount;
    private final long entryCount;

    public EocdRecord(long j, long j8, int i9) {
        this.entryCount = j;
        this.centralDirectoryOffset = j8;
        this.commentByteCount = i9;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final int getCommentByteCount() {
        return this.commentByteCount;
    }

    public final long getEntryCount() {
        return this.entryCount;
    }
}
