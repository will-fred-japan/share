package androidx.profileinstaller;

import java.io.File;

/* JADX INFO: compiled from: BenchmarkOperation.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z8 = true;
        for (File file2 : fileArrListFiles) {
            z8 = a(file2) && z8;
        }
        return z8;
    }
}
