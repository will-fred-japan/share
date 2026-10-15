package A0;

import O6.u;
import android.graphics.Typeface;
import android.view.View;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: ServiceWorkerWebSettingsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements P6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1371a;

    public /* synthetic */ h(int i9) {
        this.f1371a = i9;
    }

    public static String e(Object value, String message) {
        kotlin.jvm.internal.k.e(value, "value");
        kotlin.jvm.internal.k.e(message, "message");
        return message + " value: " + value;
    }

    @Override // P6.c
    public void a(Serializable serializable) {
        l().a(serializable);
    }

    @Override // P6.c
    public void c(String str, HashMap map) {
        l().c(str, map);
    }

    public abstract Object d();

    public abstract Object f(String str);

    public abstract Integer g();

    public abstract String h();

    public boolean i() {
        return Boolean.TRUE.equals(f("noResult"));
    }

    public abstract K7.a j();

    public abstract K7.l k();

    public abstract P6.c l();

    public abstract L5.n m();

    public u n() {
        return new u((String) f("sql"), (List) f("arguments"));
    }

    public void o(int i9) {
        if (i9 == -2) {
            k().invoke(Boolean.TRUE);
        } else if (i9 == -1) {
            k().invoke(Boolean.FALSE);
        } else {
            if (i9 != 1) {
                return;
            }
            j().invoke();
        }
    }

    public abstract boolean p();

    public abstract View q(int i9);

    public abstract void r(int i9);

    public abstract void s(Typeface typeface, boolean z8);

    public abstract boolean t();

    public String toString() {
        switch (this.f1371a) {
            case 5:
                return h() + " " + ((String) f("sql")) + " " + ((List) f("arguments"));
            default:
                return super.toString();
        }
    }

    public abstract h u(String str, K7.l lVar);

    public abstract void v(int i9, int i10, byte[] bArr);
}
