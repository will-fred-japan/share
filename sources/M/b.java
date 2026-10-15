package M;

import T.AbstractC0415b;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* JADX INFO: compiled from: SupportMenuItem.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends MenuItem {
    AbstractC0415b a();

    b b(AbstractC0415b abstractC0415b);

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c5, int i9);

    @Override // android.view.MenuItem
    b setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c5, int i9);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c5, char c9, int i9, int i10);

    @Override // android.view.MenuItem
    b setTooltipText(CharSequence charSequence);
}
