package pl.droidsonroids.gif;

import android.net.Uri;
import android.os.Parcelable;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes2.dex */
public class GifImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20828a;

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.f20828a ? getDrawable() : null, this.f20828a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        if (g.b(this, false, i9)) {
            return;
        }
        super.setBackgroundResource(i9);
    }

    public void setFreezesAnimation(boolean z8) {
        this.f20828a = z8;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i9) {
        if (g.b(this, true, i9)) {
            return;
        }
        super.setImageResource(i9);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (g.a(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }
}
