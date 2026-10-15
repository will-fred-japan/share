package L4;

/* JADX INFO: compiled from: SystemLibraryLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }
}
