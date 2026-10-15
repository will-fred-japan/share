package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: ActionBar.java */
    public interface b {
        void a();
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract void c(boolean z8);

    public abstract int d();

    public abstract Context e();

    public abstract void f();

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i();

    public abstract boolean k(int i9, KeyEvent keyEvent);

    public boolean l(KeyEvent keyEvent) {
        return false;
    }

    public boolean m() {
        return false;
    }

    public abstract void n(ColorDrawable colorDrawable);

    public abstract void o(boolean z8);

    public abstract void p(boolean z8);

    public abstract void q(boolean z8);

    public abstract void r(CharSequence charSequence);

    public abstract void s(CharSequence charSequence);

    public abstract void t();

    public p089m.a u(AppCompatDelegateImpl.d dVar) {
        return null;
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionBar.java */
    public static class C0092a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5943a;

        public C0092a(C0092a c0092a) {
            super((ViewGroup.MarginLayoutParams) c0092a);
            this.f5943a = 0;
            this.f5943a = c0092a.f5943a;
        }

        public C0092a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5943a = 0;
        }
    }

    public void j() {
    }
}
