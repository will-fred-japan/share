package p004a6;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import p004a6.h;

/* JADX INFO: compiled from: EngineFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<T_WRAPPER extends h<JcePrimitiveT>, JcePrimitiveT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g<h.a, Cipher> f5707b = new g<>(new h.a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g<h.e, Mac> f5708c = new g<>(new h.e());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<JcePrimitiveT> f5709a;

    /* JADX INFO: compiled from: EngineFactory.java */
    public static class a<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<JcePrimitiveT> f5710a;

        public a(h hVar) {
            this.f5710a = hVar;
        }

        @Override // a6.g.d
        public final JcePrimitiveT a(String str) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i9 = 0; i9 < 2; i9++) {
                Provider provider = Security.getProvider(strArr[i9]);
                if (provider != null) {
                    arrayList.add(provider);
                }
            }
            Iterator it = arrayList.iterator();
            Exception exc = null;
            while (true) {
                boolean zHasNext = it.hasNext();
                h<JcePrimitiveT> hVar = this.f5710a;
                if (!zHasNext) {
                    return hVar.a(str, null);
                }
                try {
                    return hVar.a(str, (Provider) it.next());
                } catch (Exception e9) {
                    if (exc == null) {
                        exc = e9;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineFactory.java */
    public static class b<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<JcePrimitiveT> f5711a;

        public b(h hVar) {
            this.f5711a = hVar;
        }

        @Override // a6.g.d
        public final JcePrimitiveT a(String str) {
            return this.f5711a.a(str, null);
        }
    }

    /* JADX INFO: compiled from: EngineFactory.java */
    public static class c<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<JcePrimitiveT> f5712a;

        public c(h hVar) {
            this.f5712a = hVar;
        }

        @Override // a6.g.d
        public final JcePrimitiveT a(String str) throws GeneralSecurityException {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
            ArrayList arrayList = new ArrayList();
            for (int i9 = 0; i9 < 3; i9++) {
                Provider provider = Security.getProvider(strArr[i9]);
                if (provider != null) {
                    arrayList.add(provider);
                }
            }
            Iterator it = arrayList.iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f5712a.a(str, (Provider) it.next());
                } catch (Exception e9) {
                    if (exc == null) {
                        exc = e9;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }
    }

    /* JADX INFO: compiled from: EngineFactory.java */
    public interface d<JcePrimitiveT> {
        JcePrimitiveT a(String str);
    }

    static {
        new g(new h.g());
        new g(new h.f());
        new g(new h.b());
        new g(new h.d());
        new g(new h.c());
    }

    public g(T_WRAPPER t_wrapper) {
        if (Q5.a.a()) {
            this.f5709a = new c(t_wrapper);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            this.f5709a = new a(t_wrapper);
        } else {
            this.f5709a = new b(t_wrapper);
        }
    }
}
