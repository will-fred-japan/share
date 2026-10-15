package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13468a;

    public final int getUserSetVisibility() {
        return this.f13468a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        this.f13468a = i9;
    }
}
