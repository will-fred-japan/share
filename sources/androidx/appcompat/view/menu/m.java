package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends f implements SubMenu {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final f f6210A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final h f6211B;

    public m(Context context, f fVar, h hVar) {
        super(context);
        this.f6210A = fVar;
        this.f6211B = hVar;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean d(h hVar) {
        return this.f6210A.d(hVar);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean e(f fVar, MenuItem menuItem) {
        return super.e(fVar, menuItem) || this.f6210A.e(fVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean f(h hVar) {
        return this.f6210A.f(hVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f6211B;
    }

    @Override // androidx.appcompat.view.menu.f
    public final String j() {
        h hVar = this.f6211B;
        int i9 = hVar != null ? hVar.f6155a : 0;
        if (i9 == 0) {
            return null;
        }
        return W5.e.i(i9, "android:menu:actionviewstates:");
    }

    @Override // androidx.appcompat.view.menu.f
    public final f k() {
        return this.f6210A.k();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean m() {
        return this.f6210A.m();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean n() {
        return this.f6210A.n();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean o() {
        return this.f6210A.o();
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setGroupDividerEnabled(boolean z8) {
        this.f6210A.setGroupDividerEnabled(z8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f6211B.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setQwertyMode(boolean z8) {
        this.f6210A.setQwertyMode(z8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i9) {
        u(0, null, i9, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i9) {
        u(i9, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i9) {
        this.f6211B.setIcon(i9);
        return this;
    }
}
