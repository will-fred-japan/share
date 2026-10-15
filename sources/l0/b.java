package l0;

import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0548n;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.s;
import java.io.PrintWriter;
import p155u.h;

/* JADX INFO: compiled from: LoaderManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends l0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0548n f20012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0223b f20013b;

    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class a<D> extends s<D> {
        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #0 : ");
            sb.append("null");
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: l0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManagerImpl.java */
    public static class C0223b extends I {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f20014e = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h<a> f20015d = new h<>();

        /* JADX INFO: renamed from: l0.b$b$a */
        /* JADX INFO: compiled from: LoaderManagerImpl.java */
        public static class a implements K.b {
            @Override // androidx.lifecycle.K.b
            public final <T extends I> T a(Class<T> cls) {
                return new C0223b();
            }
        }

        @Override // androidx.lifecycle.I
        public final void b() {
            h<a> hVar = this.f20015d;
            int i9 = hVar.f21663c;
            if (i9 > 0) {
                ((a) hVar.f21662b[0]).getClass();
                throw null;
            }
            Object[] objArr = hVar.f21662b;
            for (int i10 = 0; i10 < i9; i10++) {
                objArr[i10] = null;
            }
            hVar.f21663c = 0;
        }
    }

    public b(InterfaceC0548n interfaceC0548n, M m8) {
        this.f20012a = interfaceC0548n;
        K k7 = new K(m8, C0223b.f20014e);
        String canonicalName = C0223b.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20013b = (C0223b) k7.a(C0223b.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
    }

    @Deprecated
    public final void b(String str, PrintWriter printWriter) {
        h<a> hVar = this.f20013b.f20015d;
        if (hVar.f21663c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (hVar.f21663c <= 0) {
                return;
            }
            a aVar = (a) hVar.f21662b[0];
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(hVar.f21661a[0]);
            printWriter.print(": ");
            printWriter.println(aVar.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        InterfaceC0548n interfaceC0548n = this.f20012a;
        if (interfaceC0548n == null) {
            sb.append("null");
        } else {
            String simpleName = interfaceC0548n.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = interfaceC0548n.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(interfaceC0548n)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
