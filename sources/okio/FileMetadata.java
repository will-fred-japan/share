package okio;

import P7.c;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import p142s2.j;
import y7.n;
import y7.q;
import y7.u;

/* JADX INFO: compiled from: FileMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<c<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z8, boolean z9, Path path, Long l8, Long l9, Long l10, Long l11, Map map, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            z8 = fileMetadata.isRegularFile;
        }
        if ((i9 & 2) != 0) {
            z9 = fileMetadata.isDirectory;
        }
        if ((i9 & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((i9 & 8) != 0) {
            l8 = fileMetadata.size;
        }
        if ((i9 & 16) != 0) {
            l9 = fileMetadata.createdAtMillis;
        }
        if ((i9 & 32) != 0) {
            l10 = fileMetadata.lastModifiedAtMillis;
        }
        if ((i9 & 64) != 0) {
            l11 = fileMetadata.lastAccessedAtMillis;
        }
        if ((i9 & 128) != 0) {
            map = fileMetadata.extras;
        }
        Long l12 = l11;
        Map map2 = map;
        Long l13 = l9;
        Long l14 = l10;
        return fileMetadata.copy(z8, z9, path, l8, l13, l14, l12, map2);
    }

    public final FileMetadata copy(boolean z8, boolean z9, Path path, Long l8, Long l9, Long l10, Long l11, Map<c<?>, ? extends Object> extras) {
        k.e(extras, "extras");
        return new FileMetadata(z8, z9, path, l8, l9, l10, l11, extras);
    }

    public final <T> T extra(c<? extends T> type) {
        k.e(type, "type");
        T t = (T) this.extras.get(type);
        if (t == null) {
            return null;
        }
        j.o(type, t);
        return t;
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<c<?>, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return n.M(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public FileMetadata(boolean z8, boolean z9, Path path, Long l8, Long l9, Long l10, Long l11, Map<c<?>, ? extends Object> extras) {
        k.e(extras, "extras");
        this.isRegularFile = z8;
        this.isDirectory = z9;
        this.symlinkTarget = path;
        this.size = l8;
        this.createdAtMillis = l9;
        this.lastModifiedAtMillis = l10;
        this.lastAccessedAtMillis = l11;
        this.extras = u.I(extras);
    }

    public /* synthetic */ FileMetadata(boolean z8, boolean z9, Path path, Long l8, Long l9, Long l10, Long l11, Map map, int i9, f fVar) {
        this((i9 & 1) != 0 ? false : z8, (i9 & 2) != 0 ? false : z9, (i9 & 4) != 0 ? null : path, (i9 & 8) != 0 ? null : l8, (i9 & 16) != 0 ? null : l9, (i9 & 32) != 0 ? null : l10, (i9 & 64) != 0 ? null : l11, (i9 & 128) != 0 ? q.f22409a : map);
    }
}
