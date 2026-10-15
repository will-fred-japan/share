package f0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* JADX INFO: compiled from: EmojiTransformationMethod.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformationMethod f18667a;

    public h(TransformationMethod transformationMethod) {
        this.f18667a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f18667a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || androidx.emoji2.text.c.a().b() != 1) {
            return charSequence;
        }
        androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
        cVarA.getClass();
        return cVarA.e(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z8, int i9, Rect rect) {
        TransformationMethod transformationMethod = this.f18667a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z8, i9, rect);
        }
    }
}
