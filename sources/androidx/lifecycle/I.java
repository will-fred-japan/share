package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f7708a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f7709b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f7710c = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e9) {
                throw new RuntimeException(e9);
            }
        }
    }

    public void b() {
    }
}
