package p097n;

import T.AbstractC0415b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p097n.b implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M.b f20532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f20533e;

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class a extends AbstractC0415b implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h.a f20534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ActionProvider f20535c;

        public a(ActionProvider actionProvider) {
            this.f20535c = actionProvider;
        }

        @Override // T.AbstractC0415b
        public final boolean a() {
            return this.f20535c.hasSubMenu();
        }

        @Override // T.AbstractC0415b
        public final boolean b() {
            return this.f20535c.isVisible();
        }

        @Override // T.AbstractC0415b
        public final View c() {
            return this.f20535c.onCreateActionView();
        }

        @Override // T.AbstractC0415b
        public final View d(h hVar) {
            return this.f20535c.onCreateActionView(hVar);
        }

        @Override // T.AbstractC0415b
        public final boolean e() {
            return this.f20535c.onPerformDefaultAction();
        }

        @Override // T.AbstractC0415b
        public final void f(m mVar) {
            this.f20535c.onPrepareSubMenu(c.this.d(mVar));
        }

        @Override // T.AbstractC0415b
        public final boolean g() {
            return this.f20535c.overridesItemVisibility();
        }

        @Override // T.AbstractC0415b
        public final void h(h.a aVar) {
            this.f20534b = aVar;
            this.f20535c.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public final void onActionProviderVisibilityChanged(boolean z8) {
            h.a aVar = this.f20534b;
            if (aVar != null) {
                f fVar = h.this.f6167n;
                fVar.f6133h = true;
                fVar.p(true);
            }
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public static class b extends FrameLayout implements p089m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f20537a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view) {
            super(view.getContext());
            this.f20537a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // p089m.b
        public final void c() {
            this.f20537a.onActionViewExpanded();
        }

        @Override // p089m.b
        public final void e() {
            this.f20537a.onActionViewCollapsed();
        }
    }

    /* JADX INFO: renamed from: n.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class MenuItemOnActionExpandListenerC0233c implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f20538a;

        public MenuItemOnActionExpandListenerC0233c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f20538a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f20538a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f20538a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    public class d implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f20540a;

        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f20540a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.f20540a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, M.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f20532d = bVar;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.f20532d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return this.f20532d.expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        AbstractC0415b abstractC0415bA = this.f20532d.a();
        if (abstractC0415bA instanceof a) {
            return ((a) abstractC0415bA).f20535c;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = this.f20532d.getActionView();
        return actionView instanceof b ? (View) ((b) actionView).f20537a : actionView;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f20532d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f20532d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f20532d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f20532d.getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f20532d.getIcon();
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f20532d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f20532d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f20532d.getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f20532d.getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f20532d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f20532d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f20532d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f20532d.getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return d(this.f20532d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f20532d.getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f20532d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f20532d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f20532d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f20532d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return this.f20532d.isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return this.f20532d.isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return this.f20532d.isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f20532d.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        a aVar = new a(actionProvider);
        if (actionProvider == null) {
            aVar = null;
        }
        this.f20532d.b(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f20532d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f20532d.setAlphabeticShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z8) {
        this.f20532d.setCheckable(z8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z8) {
        this.f20532d.setChecked(z8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f20532d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z8) {
        this.f20532d.setEnabled(z8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f20532d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20532d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20532d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f20532d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        this.f20532d.setNumericShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f20532d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0233c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f20532d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9) {
        this.f20532d.setShortcut(c5, c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i9) {
        this.f20532d.setShowAsAction(i9);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i9) {
        this.f20532d.setShowAsActionFlags(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f20532d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20532d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f20532d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z8) {
        return this.f20532d.setVisible(z8);
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i9) {
        this.f20532d.setAlphabeticShortcut(c5, i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i9) {
        this.f20532d.setIcon(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i9) {
        this.f20532d.setNumericShortcut(c5, i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9, int i9, int i10) {
        this.f20532d.setShortcut(c5, c9, i9, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i9) {
        this.f20532d.setTitle(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i9) {
        M.b bVar = this.f20532d;
        bVar.setActionView(i9);
        View actionView = bVar.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            bVar.setActionView(new b(actionView));
        }
        return this;
    }
}
