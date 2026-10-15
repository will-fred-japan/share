package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatEmojiTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0496h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f6619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.f f6620b;

    public C0496h(TextView textView) {
        this.f6619a = textView;
        this.f6620b = new f0.f(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f6620b.f18658a.a(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i9) {
        TypedArray typedArrayObtainStyledAttributes = this.f6619a.getContext().obtainStyledAttributes(attributeSet, p059i.a.f19182i, i9, 0);
        try {
            boolean z8 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z8);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z8) {
        this.f6620b.f18658a.c(z8);
    }

    public final void d(boolean z8) {
        this.f6620b.f18658a.d(z8);
    }
}
