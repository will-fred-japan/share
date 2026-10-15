package p097n;

import M.b;
import T.AbstractC0415b;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: ActionMenuItem.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f20514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f20515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f20516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f20517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char f20519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f20521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f20522i;
    public CharSequence j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f20523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f20524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f20525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20528p;

    @Override // M.b
    public final AbstractC0415b a() {
        return null;
    }

    @Override // M.b
    public final b b(AbstractC0415b abstractC0415b) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f20521h;
        if (drawable != null) {
            if (this.f20526n || this.f20527o) {
                this.f20521h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f20521h = drawableMutate;
                if (this.f20526n) {
                    drawableMutate.setTintList(this.f20524l);
                }
                if (this.f20527o) {
                    this.f20521h.setTintMode(this.f20525m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // M.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f20520g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f20519f;
    }

    @Override // M.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f20521h;
    }

    @Override // M.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f20524l;
    }

    @Override // M.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f20525m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f20516c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // M.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f20518e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f20517d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f20514a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f20515b;
        return charSequence != null ? charSequence : this.f20514a;
    }

    @Override // M.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f20523k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f20528p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f20528p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f20528p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f20528p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f20519f = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z8) {
        this.f20528p = (z8 ? 1 : 0) | (this.f20528p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z8) {
        this.f20528p = (z8 ? 2 : 0) | (this.f20528p & (-3));
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final b setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z8) {
        this.f20528p = (z8 ? 16 : 0) | (this.f20528p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f20521h = drawable;
        c();
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f20524l = colorStateList;
        this.f20526n = true;
        c();
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f20525m = mode;
        this.f20527o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f20516c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        this.f20517d = c5;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9) {
        this.f20517d = c5;
        this.f20519f = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f20514a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f20515b = charSequence;
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final b setTooltipText(CharSequence charSequence) {
        this.f20523k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z8) {
        this.f20528p = (this.f20528p & 8) | (z8 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i9) {
        throw new UnsupportedOperationException();
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i9) {
        this.f20519f = Character.toLowerCase(c5);
        this.f20520g = KeyEvent.normalizeMetaState(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i9) {
        this.f20517d = c5;
        this.f20518e = KeyEvent.normalizeMetaState(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i9) {
        this.f20514a = this.f20522i.getResources().getString(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f20523k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i9) {
        this.f20521h = this.f20522i.getDrawable(i9);
        c();
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9, int i9, int i10) {
        this.f20517d = c5;
        this.f20518e = KeyEvent.normalizeMetaState(i9);
        this.f20519f = Character.toLowerCase(c9);
        this.f20520g = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i9) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i9) {
        return this;
    }
}
