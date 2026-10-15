package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatCheckedTextViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0493e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatCheckedTextView f6598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f6599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f6600c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6601d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6602e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6603f;

    public C0493e(AppCompatCheckedTextView appCompatCheckedTextView) {
        this.f6598a = appCompatCheckedTextView;
    }

    public final void a() {
        AppCompatCheckedTextView appCompatCheckedTextView = this.f6598a;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f6601d || this.f6602e) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f6601d) {
                    drawableMutate.setTintList(this.f6599b);
                }
                if (this.f6602e) {
                    drawableMutate.setTintMode(this.f6600c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }
}
