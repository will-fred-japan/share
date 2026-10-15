package p097n;

import M.c;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import p155u.g;

/* JADX INFO: compiled from: BaseMenuWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g<M.b, MenuItem> f20530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g<c, SubMenu> f20531c;

    public b(Context context) {
        this.f20529a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof M.b)) {
            return menuItem;
        }
        M.b bVar = (M.b) menuItem;
        if (this.f20530b == null) {
            this.f20530b = new g<>();
        }
        MenuItem menuItem2 = this.f20530b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f20529a, bVar);
        this.f20530b.put(bVar, cVar);
        return cVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f20531c == null) {
            this.f20531c = new g<>();
        }
        SubMenu subMenu2 = this.f20531c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        g gVar = new g(this.f20529a, cVar);
        this.f20531c.put(cVar, gVar);
        return gVar;
    }
}
