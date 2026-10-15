package F3;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CommandResultUploader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f2035d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2036a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile File f2037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public L3.a f2038c;

    public static long a(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jA = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jA = (file2.isDirectory() ? a(file2) : file2.length()) + jA;
        }
        return jA;
    }

    public static a b(String str) {
        ConcurrentHashMap<String, a> concurrentHashMap = f2035d;
        a aVar = concurrentHashMap.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        concurrentHashMap.put(str, aVar2);
        return aVar2;
    }
}
