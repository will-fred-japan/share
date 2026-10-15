package U0;

import android.os.Handler;

/* JADX INFO: compiled from: CacheHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U0.a f4605a;

    /* JADX INFO: compiled from: CacheHelper.java */
    public interface b<L> {
        String a();

        boolean a(L l8);

        boolean a(L l8, L l9);

        void b(L l8);

        String c(Object obj, String str, U0.a aVar);
    }

    public final Object a(String str, String str2, b bVar) {
        boolean z8;
        U0.a aVar = this.f4605a;
        String strA = bVar.a();
        boolean zA = bVar.a(str);
        boolean zA2 = bVar.a(strA);
        if (!zA && zA2) {
            str = strA;
        }
        if (aVar != null) {
            String strC = bVar.c(str, str2, aVar);
            if (!bVar.a(strC, strA)) {
                bVar.b(strC);
            }
            return strC;
        }
        if (zA || zA2) {
            str2 = str;
            z8 = false;
        } else {
            z8 = true;
        }
        if ((z8 && bVar.a(str2)) || (zA && !bVar.a(str2, strA))) {
            bVar.b(str2);
        }
        return str2;
    }

    public final void b(Handler handler) {
        U0.a aVar = this.f4605a;
        if (aVar != null) {
            aVar.b(handler);
        }
    }

    public abstract void c(String str, String str2);

    public abstract String d(String str);

    public final String e(String str, String str2) {
        return (String) a(str, str2, new a());
    }

    /* JADX INFO: compiled from: CacheHelper.java */
    public class a implements b<String> {
        public a() {
        }

        @Override // U0.d.b
        public final boolean a(String str) {
            return V0.o.g(str);
        }

        @Override // U0.d.b
        public final void b(String str) {
            d.this.c("clientudid", str);
        }

        @Override // U0.d.b
        public final String c(Object obj, String str, U0.a aVar) {
            String str2 = (String) obj;
            return aVar == null ? str2 : aVar.e(str2, str);
        }

        @Override // U0.d.b
        public final boolean a(String str, String str2) {
            return V0.o.f(str, str2);
        }

        @Override // U0.d.b
        public final String a() {
            return d.this.d("clientudid");
        }
    }
}
