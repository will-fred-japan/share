package Z;

import java.io.File;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class J extends kotlin.jvm.internal.l implements K7.l<File, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final J f5306a = new J(1);

    @Override // K7.l
    public final T invoke(File file) {
        File it = file;
        kotlin.jvm.internal.k.e(it, "it");
        String absolutePath = it.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.k.d(absolutePath, "file.canonicalFile.absolutePath");
        return new e0(absolutePath);
    }
}
