package p152t4;

import android.content.Context;
import com.apm.insight.entity.Header;
import com.apm.insight.f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21417b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21418a = f21417b;

    public static class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Header f21419c;

        @Override // p152t4.d
        public final Object b(String str) {
            if (this.f21419c == null) {
                Context context = f.f11853a;
                Header headerA = Header.a();
                Header.addRuntimeHeader(headerA.f11851a);
                Header.f(headerA);
                headerA.i();
                headerA.j();
                headerA.k();
                this.f21419c = headerA;
            }
            return this.f21419c.f11851a.opt(str);
        }
    }

    static {
        a aVar = new a();
        aVar.f21419c = null;
        f21417b = aVar;
    }

    public Object a(String str) {
        a aVar = this.f21418a;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    public Object b(String str) {
        a aVar = this.f21418a;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }
}
