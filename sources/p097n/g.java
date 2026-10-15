package p097n;

import M.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends e implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f20544e;

    public g(Context context, c cVar) {
        super(context, cVar);
        this.f20544e = cVar;
    }

    @Override // android.view.SubMenu
    public final void clearHeader() {
        this.f20544e.clearHeader();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return c(this.f20544e.getItem());
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i9) {
        this.f20544e.setHeaderIcon(i9);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i9) {
        this.f20544e.setHeaderTitle(i9);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        this.f20544e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i9) {
        this.f20544e.setIcon(i9);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.f20544e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f20544e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f20544e.setIcon(drawable);
        return this;
    }
}
