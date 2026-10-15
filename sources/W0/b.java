package W0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: BaseOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<SERVICE> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4997b = new a(this);

    /* JADX INFO: compiled from: BaseOaidImpl.java */
    public class a extends V0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f4998c;

        public a(b bVar) {
            super(1);
            this.f4998c = bVar;
        }

        @Override // V0.a
        public final Object a(Object[] objArr) {
            return Boolean.valueOf(A4.c.a((Context) objArr[0], this.f4998c.f4996a));
        }
    }

    public b(String str) {
        this.f4996a = str;
    }

    @Override // W0.l
    public l.a a(Context context) {
        String str = (String) new s(context, c(context), b()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        l.a aVar = new l.a();
        aVar.f5014a = str;
        return aVar;
    }

    public abstract s.b<SERVICE, String> b();

    @Override // W0.l
    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) this.f4997b.b(context)).booleanValue();
    }

    public abstract Intent c(Context context);
}
