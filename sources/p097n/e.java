package p097n;

import M.a;
import M.b;
import M.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p155u.g;

/* JADX INFO: compiled from: MenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f20543d;

    public e(Context context, a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f20543d = aVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return c(this.f20543d.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i9, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f20543d.addIntentOptions(i9, i10, i11, componentName, intentArr, intent, i12, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i13 = 0; i13 < length; i13++) {
                menuItemArr[i13] = c(menuItemArr2[i13]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f20543d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        g<b, MenuItem> gVar = this.f20530b;
        if (gVar != null) {
            gVar.clear();
        }
        g<c, SubMenu> gVar2 = this.f20531c;
        if (gVar2 != null) {
            gVar2.clear();
        }
        this.f20543d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f20543d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i9) {
        return c(this.f20543d.findItem(i9));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i9) {
        return c(this.f20543d.getItem(i9));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f20543d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i9, KeyEvent keyEvent) {
        return this.f20543d.isShortcutKey(i9, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i9, int i10) {
        return this.f20543d.performIdentifierAction(i9, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i9, KeyEvent keyEvent, int i10) {
        return this.f20543d.performShortcut(i9, keyEvent, i10);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i9) {
        if (this.f20530b != null) {
            int i10 = 0;
            while (true) {
                g<b, MenuItem> gVar = this.f20530b;
                if (i10 >= gVar.f21660c) {
                    break;
                }
                if (gVar.f(i10).getGroupId() == i9) {
                    this.f20530b.g(i10);
                    i10--;
                }
                i10++;
            }
        }
        this.f20543d.removeGroup(i9);
    }

    @Override // android.view.Menu
    public final void removeItem(int i9) {
        if (this.f20530b != null) {
            int i10 = 0;
            while (true) {
                g<b, MenuItem> gVar = this.f20530b;
                if (i10 >= gVar.f21660c) {
                    break;
                }
                if (gVar.f(i10).getItemId() == i9) {
                    this.f20530b.g(i10);
                    break;
                }
                i10++;
            }
        }
        this.f20543d.removeItem(i9);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i9, boolean z8, boolean z9) {
        this.f20543d.setGroupCheckable(i9, z8, z9);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i9, boolean z8) {
        this.f20543d.setGroupEnabled(i9, z8);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i9, boolean z8) {
        this.f20543d.setGroupVisible(i9, z8);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z8) {
        this.f20543d.setQwertyMode(z8);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f20543d.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9) {
        return c(this.f20543d.add(i9));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9) {
        return d(this.f20543d.addSubMenu(i9));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, CharSequence charSequence) {
        return c(this.f20543d.add(i9, i10, i11, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, CharSequence charSequence) {
        return d(this.f20543d.addSubMenu(i9, i10, i11, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i9, int i10, int i11, int i12) {
        return c(this.f20543d.add(i9, i10, i11, i12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i9, int i10, int i11, int i12) {
        return d(this.f20543d.addSubMenu(i9, i10, i11, i12));
    }
}
