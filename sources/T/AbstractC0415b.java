package T;

import android.util.Log;
import android.view.View;

/* JADX INFO: renamed from: T.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0415b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.appcompat.view.menu.h.a f4404a;

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(androidx.appcompat.view.menu.h hVar) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void h(androidx.appcompat.view.menu.h.a aVar) {
        if (this.f4404a != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f4404a = aVar;
    }

    public void f(androidx.appcompat.view.menu.m mVar) {
    }
}
