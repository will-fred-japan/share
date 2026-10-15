package okio;

import W5.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import y7.l;

/* JADX INFO: compiled from: JvmSystemFileSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) throws IOException {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) throws IOException {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z8) throws IOException {
        k.e(file, "file");
        if (z8) {
            requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) throws IOException {
        k.e(source, "source");
        k.e(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws IOException {
        k.e(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            return Path.Companion.get$default(Path.Companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z8) throws IOException {
        k.e(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(dir);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.isDirectory()) {
            throw new IOException(e.n(dir, "failed to create directory: "));
        }
        if (z8) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) throws IOException {
        k.e(source, "source");
        k.e(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z8) throws IOException {
        k.e(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(e.n(path, "failed to delete "));
        }
        if (z8) {
            throw new FileNotFoundException(e.n(path, "no such file: "));
        }
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) throws IOException {
        k.e(dir, "dir");
        List<Path> list = list(dir, true);
        k.b(list);
        return list;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        k.e(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        k.e(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        k.e(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z8, boolean z9) throws IOException {
        k.e(file, "file");
        if (z8 && z9) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z8) {
            requireCreate(file);
        }
        if (z9) {
            requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z8) throws IOException {
        k.e(file, "file");
        if (z8) {
            requireCreate(file);
        }
        return Okio__JvmOkioKt.sink$default(file.toFile(), false, 1, null);
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        k.e(file, "file");
        return Okio.source(file.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z8) throws IOException {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z8) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(e.n(path, "failed to list "));
            }
            throw new FileNotFoundException(e.n(path, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String it : list) {
            k.d(it, "it");
            arrayList.add(path.resolve(it));
        }
        l.G(arrayList);
        return arrayList;
    }
}
