package androidx.appcompat.view.menu;

import T.AbstractC0415b;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import p056h5.C0598e;

/* JADX INFO: compiled from: MenuItemImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements M.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public AbstractC0415b f6152A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f6153B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f6159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f6160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f6161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f6162h;
    public char j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f6165l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f6167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f6168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f6169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f6170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f6171r;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6177y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f6178z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6163i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6164k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6166m = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f6172s = null;
    public PorterDuff.Mode t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6173u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6174v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6175w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6176x = 16;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f6154C = false;

    /* JADX INFO: compiled from: MenuItemImpl.java */
    public class a {
        public a() {
        }
    }

    public h(f fVar, int i9, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f6167n = fVar;
        this.f6155a = i10;
        this.f6156b = i9;
        this.f6157c = i11;
        this.f6158d = i12;
        this.f6159e = charSequence;
        this.f6177y = i13;
    }

    public static void c(StringBuilder sb, int i9, int i10, String str) {
        if ((i9 & i10) == i10) {
            sb.append(str);
        }
    }

    @Override // M.b
    public final AbstractC0415b a() {
        return this.f6152A;
    }

    @Override // M.b
    public final M.b b(AbstractC0415b abstractC0415b) {
        AbstractC0415b abstractC0415b2 = this.f6152A;
        if (abstractC0415b2 != null) {
            abstractC0415b2.f4404a = null;
        }
        this.f6178z = null;
        this.f6152A = abstractC0415b;
        this.f6167n.p(true);
        AbstractC0415b abstractC0415b3 = this.f6152A;
        if (abstractC0415b3 != null) {
            abstractC0415b3.h(new a());
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f6177y & 8) == 0) {
            return false;
        }
        if (this.f6178z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6153B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f6167n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f6175w && (this.f6173u || this.f6174v)) {
            drawable = drawable.mutate();
            if (this.f6173u) {
                drawable.setTintList(this.f6172s);
            }
            if (this.f6174v) {
                drawable.setTintMode(this.t);
            }
            this.f6175w = false;
        }
        return drawable;
    }

    public final boolean e() {
        AbstractC0415b abstractC0415b;
        if ((this.f6177y & 8) == 0) {
            return false;
        }
        if (this.f6178z == null && (abstractC0415b = this.f6152A) != null) {
            this.f6178z = abstractC0415b.d(this);
        }
        return this.f6178z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6153B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f6167n.f(this);
        }
        return false;
    }

    public final void f(boolean z8) {
        if (z8) {
            this.f6176x |= 32;
        } else {
            this.f6176x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f6178z;
        if (view != null) {
            return view;
        }
        AbstractC0415b abstractC0415b = this.f6152A;
        if (abstractC0415b == null) {
            return null;
        }
        View viewD = abstractC0415b.d(this);
        this.f6178z = viewD;
        return viewD;
    }

    @Override // M.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f6164k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // M.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f6170q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f6156b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f6165l;
        if (drawable != null) {
            return d(drawable);
        }
        int i9 = this.f6166m;
        if (i9 == 0) {
            return null;
        }
        Drawable drawableV = C0598e.v(this.f6167n.f6126a, i9);
        this.f6166m = 0;
        this.f6165l = drawableV;
        return d(drawableV);
    }

    @Override // M.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f6172s;
    }

    @Override // M.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f6161g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f6155a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // M.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f6163i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f6162h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f6157c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f6168o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f6159e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6160f;
        return charSequence != null ? charSequence : this.f6159e;
    }

    @Override // M.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f6171r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f6168o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f6154C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f6176x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f6176x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f6176x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        AbstractC0415b abstractC0415b = this.f6152A;
        if (abstractC0415b == null || !abstractC0415b.g()) {
            return (this.f6176x & 8) == 0;
        }
        return (this.f6176x & 8) == 0 && this.f6152A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i9;
        this.f6178z = view;
        this.f6152A = null;
        if (view != null && view.getId() == -1 && (i9 = this.f6155a) > 0) {
            view.setId(i9);
        }
        f fVar = this.f6167n;
        fVar.f6135k = true;
        fVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5) {
        if (this.j == c5) {
            return this;
        }
        this.j = Character.toLowerCase(c5);
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z8) {
        int i9 = this.f6176x;
        int i10 = (z8 ? 1 : 0) | (i9 & (-2));
        this.f6176x = i10;
        if (i9 != i10) {
            this.f6167n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z8) {
        int i9 = this.f6176x;
        if ((i9 & 4) == 0) {
            int i10 = (i9 & (-3)) | (z8 ? 2 : 0);
            this.f6176x = i10;
            if (i9 != i10) {
                this.f6167n.p(false);
            }
            return this;
        }
        f fVar = this.f6167n;
        fVar.getClass();
        ArrayList<h> arrayList = fVar.f6131f;
        int size = arrayList.size();
        fVar.w();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            if (hVar.f6156b == this.f6156b && (hVar.f6176x & 4) != 0 && hVar.isCheckable()) {
                boolean z9 = hVar == this;
                int i12 = hVar.f6176x;
                int i13 = (z9 ? 2 : 0) | (i12 & (-3));
                hVar.f6176x = i13;
                if (i12 != i13) {
                    hVar.f6167n.p(false);
                }
            }
        }
        fVar.v();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z8) {
        if (z8) {
            this.f6176x |= 16;
        } else {
            this.f6176x &= -17;
        }
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f6166m = 0;
        this.f6165l = drawable;
        this.f6175w = true;
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6172s = colorStateList;
        this.f6173u = true;
        this.f6175w = true;
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.t = mode;
        this.f6174v = true;
        this.f6175w = true;
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f6161g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5) {
        if (this.f6162h == c5) {
            return this;
        }
        this.f6162h = c5;
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f6153B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6169p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9) {
        this.f6162h = c5;
        this.j = Character.toLowerCase(c9);
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i9) {
        int i10 = i9 & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f6177y = i9;
        f fVar = this.f6167n;
        fVar.f6135k = true;
        fVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i9) {
        setShowAsAction(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f6159e = charSequence;
        this.f6167n.p(false);
        m mVar = this.f6168o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6160f = charSequence;
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z8) {
        int i9 = this.f6176x;
        int i10 = (z8 ? 0 : 8) | (i9 & (-9));
        this.f6176x = i10;
        if (i9 != i10) {
            f fVar = this.f6167n;
            fVar.f6133h = true;
            fVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f6159e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // M.b, android.view.MenuItem
    public final M.b setContentDescription(CharSequence charSequence) {
        this.f6170q = charSequence;
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final M.b setTooltipText(CharSequence charSequence) {
        this.f6171r = charSequence;
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c5, int i9) {
        if (this.j == c5 && this.f6164k == i9) {
            return this;
        }
        this.j = Character.toLowerCase(c5);
        this.f6164k = KeyEvent.normalizeMetaState(i9);
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c5, int i9) {
        if (this.f6162h == c5 && this.f6163i == i9) {
            return this;
        }
        this.f6162h = c5;
        this.f6163i = KeyEvent.normalizeMetaState(i9);
        this.f6167n.p(false);
        return this;
    }

    @Override // M.b, android.view.MenuItem
    public final MenuItem setShortcut(char c5, char c9, int i9, int i10) {
        this.f6162h = c5;
        this.f6163i = KeyEvent.normalizeMetaState(i9);
        this.j = Character.toLowerCase(c9);
        this.f6164k = KeyEvent.normalizeMetaState(i10);
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i9) {
        this.f6165l = null;
        this.f6166m = i9;
        this.f6175w = true;
        this.f6167n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i9) {
        setTitle(this.f6167n.f6126a.getString(i9));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i9) {
        int i10;
        Context context = this.f6167n.f6126a;
        View viewInflate = LayoutInflater.from(context).inflate(i9, (ViewGroup) new LinearLayout(context), false);
        this.f6178z = viewInflate;
        this.f6152A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i10 = this.f6155a) > 0) {
            viewInflate.setId(i10);
        }
        f fVar = this.f6167n;
        fVar.f6135k = true;
        fVar.p(true);
        return this;
    }
}
