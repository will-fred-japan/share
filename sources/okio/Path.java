package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import y7.i;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    /* JADX INFO: compiled from: Path.kt */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                z8 = false;
            }
            return companion.get(str, z8);
        }

        public final Path get(File file) {
            k.e(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                z8 = false;
            }
            return companion.get(file, z8);
        }

        public final Path get(String str) {
            k.e(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                z8 = false;
            }
            return companion.get(path, z8);
        }

        public final Path get(java.nio.file.Path path) {
            k.e(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        public final Path get(String str, boolean z8) {
            k.e(str, "<this>");
            return okio.internal.Path.commonToPath(str, z8);
        }

        public final Path get(File file, boolean z8) {
            k.e(file, "<this>");
            String string = file.toString();
            k.d(string, "toString()");
            return get(string, z8);
        }

        public final Path get(java.nio.file.Path path, boolean z8) {
            k.e(path, "<this>");
            return get(path.toString(), z8);
        }
    }

    static {
        String separator = File.separator;
        k.d(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(ByteString bytes) {
        k.e(bytes, "bytes");
        this.bytes = bytes;
    }

    public static final Path get(File file) {
        return Companion.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z8 = false;
        }
        return path.resolve(str, z8);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && k.a(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int iRootLength = okio.internal.Path.rootLength(this);
        if (iRootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, iRootLength));
    }

    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int iRootLength = okio.internal.Path.rootLength(this);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < getBytes$okio().size() && getBytes$okio().getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int size = getBytes$okio().size();
        int i9 = iRootLength;
        while (iRootLength < size) {
            if (getBytes$okio().getByte(iRootLength) == 47 || getBytes$okio().getByte(iRootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i9, iRootLength));
                i9 = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i9 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i9, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(i.E(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iRootLength = okio.internal.Path.rootLength(this);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < getBytes$okio().size() && getBytes$okio().getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int size = getBytes$okio().size();
        int i9 = iRootLength;
        while (iRootLength < size) {
            if (getBytes$okio().getByte(iRootLength) == 47 || getBytes$okio().getByte(iRootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i9, iRootLength));
                i9 = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i9 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i9, getBytes$okio().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return okio.internal.Path.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return okio.internal.Path.rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return okio.internal.Path.rootLength(this) == getBytes$okio().size();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), indexOfLastSlash + 1, 0, 2, null);
        }
        return (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    public final Path parent() {
        if (k.a(getBytes$okio(), okio.internal.Path.DOT) || k.a(getBytes$okio(), okio.internal.Path.SLASH) || k.a(getBytes$okio(), okio.internal.Path.BACKSLASH) || okio.internal.Path.lastSegmentIsDotDot(this)) {
            return null;
        }
        int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash == 2 && volumeLetter() != null) {
            if (getBytes$okio().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        }
        if (indexOfLastSlash == 1 && getBytes$okio().startsWith(okio.internal.Path.BACKSLASH)) {
            return null;
        }
        if (indexOfLastSlash != -1 || volumeLetter() == null) {
            if (indexOfLastSlash == -1) {
                return new Path(okio.internal.Path.DOT);
            }
            return indexOfLastSlash == 0 ? new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(getBytes$okio(), 0, indexOfLastSlash, 1, null));
        }
        if (getBytes$okio().size() == 2) {
            return null;
        }
        return new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
    }

    public final Path relativeTo(Path other) {
        k.e(other, "other");
        if (!k.a(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i9 = 0;
        while (i9 < iMin && k.a(segmentsBytes.get(i9), segmentsBytes2.get(i9))) {
            i9++;
        }
        if (i9 == iMin && getBytes$okio().size() == other.getBytes$okio().size()) {
            return Companion.get$default(Companion, ".", false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i9, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        Buffer buffer = new Buffer();
        ByteString slash = okio.internal.Path.getSlash(other);
        if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i10 = i9; i10 < size; i10++) {
            buffer.write(okio.internal.Path.DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i9 < size2) {
            buffer.write(segmentsBytes.get(i9));
            buffer.write(slash);
            i9++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    public final Path resolve(Path child) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, child, false);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        k.d(path, "get(toString())");
        return path;
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), okio.internal.Path.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c5 = (char) getBytes$okio().getByte(0);
        if (('a' > c5 || c5 >= '{') && ('A' > c5 || c5 >= '[')) {
            return null;
        }
        return Character.valueOf(c5);
    }

    public static final Path get(File file, boolean z8) {
        return Companion.get(file, z8);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z8 = false;
        }
        return path.resolve(byteString, z8);
    }

    @Override // java.lang.Comparable
    public int compareTo(Path other) {
        k.e(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public final Path resolve(Path child, boolean z8) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, child, z8);
    }

    public static final Path get(String str) {
        return Companion.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z8 = false;
        }
        return path.resolve(path2, z8);
    }

    public final Path resolve(String child) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), false);
    }

    public static final Path get(String str, boolean z8) {
        return Companion.get(str, z8);
    }

    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    public final Path resolve(ByteString child) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), false);
    }

    public static final Path get(java.nio.file.Path path, boolean z8) {
        return Companion.get(path, z8);
    }

    public final Path resolve(String child, boolean z8) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), z8);
    }

    public final Path resolve(ByteString child, boolean z8) {
        k.e(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), z8);
    }
}
