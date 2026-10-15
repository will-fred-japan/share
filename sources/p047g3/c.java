package p047g3;

import java.io.File;
import java.util.HashMap;
import p061i1.h;

/* JADX INFO: compiled from: WeedOutManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f18872a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f18873b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f18874c = new a();

    /* JADX INFO: compiled from: WeedOutManager.java */
    public class a implements b {
        @Override // g3.c.b
        public final int a() {
            return 5;
        }

        @Override // g3.c.b
        public final int b() {
            return 80;
        }
    }

    /* JADX INFO: compiled from: WeedOutManager.java */
    public interface b {
        int a();

        int b();
    }

    public static void a(String str) {
        try {
            File databasePath = h.f19229a.getDatabasePath(str.concat(".db"));
            if (databasePath.exists()) {
                databasePath.delete();
            }
        } catch (Exception unused) {
        }
    }
}
