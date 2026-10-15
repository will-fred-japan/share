package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.widget.TextView;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GifTextView extends TextView {
    private void setCompoundDrawablesVisible(boolean z8) {
        for (Drawable drawable : getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setVisible(z8, false);
            }
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            if (drawable2 != null) {
                drawable2.setVisible(z8, false);
            }
        }
    }

    public final Drawable a(int i9) {
        if (i9 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i9);
        if (!isInEditMode() && g.f20870a.contains(resourceTypeName)) {
            try {
                return new d(resources, i9);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i9, getContext().getTheme());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        throw null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        setBackground(a(i9));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(i9), a(i10), a(i11), a(i12));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        setCompoundDrawablesWithIntrinsicBounds(a(i9), a(i10), a(i11), a(i12));
    }

    public void setFreezesAnimation(boolean z8) {
        throw null;
    }
}
