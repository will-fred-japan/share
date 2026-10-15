package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;

/* JADX INFO: compiled from: DecorToolbar.java */
/* JADX INFO: loaded from: classes.dex */
public interface t {
    boolean a();

    void b(androidx.appcompat.view.menu.f fVar, androidx.appcompat.view.menu.j.a aVar);

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(int i9);

    boolean j();

    void k(int i9);

    void l();

    int m();

    void n(int i9);

    T.L o(int i9, long j);

    void p();

    void q();

    void r(boolean z8);

    void setIcon(int i9);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
