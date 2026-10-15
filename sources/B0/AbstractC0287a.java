package B0;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: renamed from: B0.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApiFeature.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0287a implements InterfaceC0307v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f1676c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1678b;

    /* JADX INFO: renamed from: B0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class C0003a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashSet f1679a = new HashSet(Arrays.asList(P.b.f1665a.a()));
    }

    /* JADX INFO: renamed from: B0.a$b */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class b extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: renamed from: B0.a$c */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class c extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: renamed from: B0.a$d */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class d extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return false;
        }
    }

    /* JADX INFO: renamed from: B0.a$e */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class e extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return true;
        }
    }

    /* JADX INFO: renamed from: B0.a$f */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class f extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* JADX INFO: renamed from: B0.a$g */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class g extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* JADX INFO: renamed from: B0.a$h */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class h extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: renamed from: B0.a$i */
    /* JADX INFO: compiled from: ApiFeature.java */
    public static class i extends AbstractC0287a {
        @Override // B0.AbstractC0287a
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public AbstractC0287a(String str, String str2) {
        this.f1677a = str;
        this.f1678b = str2;
        f1676c.add(this);
    }

    @Override // B0.InterfaceC0307v
    public final String a() {
        return this.f1677a;
    }

    public abstract boolean b();

    public boolean c() {
        HashSet hashSet = C0003a.f1679a;
        String str = this.f1678b;
        if (hashSet.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        return ("eng".equals(str2) || "userdebug".equals(str2)) && hashSet.contains(str.concat(":dev"));
    }

    @Override // B0.InterfaceC0307v
    public final boolean isSupported() {
        return b() || c();
    }
}
