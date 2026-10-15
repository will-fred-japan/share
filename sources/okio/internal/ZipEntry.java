package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okio.Path;

/* JADX INFO: compiled from: ZipEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ZipEntry {
    private final Path canonicalPath;
    private final List<Path> children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final boolean isDirectory;
    private final Long lastModifiedAtMillis;
    private final long offset;
    private final long size;

    public ZipEntry(Path canonicalPath, boolean z8, String comment, long j, long j8, long j9, int i9, Long l8, long j10) {
        k.e(canonicalPath, "canonicalPath");
        k.e(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = z8;
        this.comment = comment;
        this.crc = j;
        this.compressedSize = j8;
        this.size = j9;
        this.compressionMethod = i9;
        this.lastModifiedAtMillis = l8;
        this.offset = j10;
        this.children = new ArrayList();
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final List<Path> getChildren() {
        return this.children;
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public /* synthetic */ ZipEntry(Path path, boolean z8, String str, long j, long j8, long j9, int i9, Long l8, long j10, int i10, f fVar) {
        this(path, (i10 & 2) != 0 ? false : z8, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? -1L : j, (i10 & 16) != 0 ? -1L : j8, (i10 & 32) != 0 ? -1L : j9, (i10 & 64) != 0 ? -1 : i9, (i10 & 128) != 0 ? null : l8, (i10 & 256) != 0 ? -1L : j10);
    }
}
