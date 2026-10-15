package U;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: AccessibilityClickableSpanCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f4574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4575c;

    public a(int i9, f fVar, int i10) {
        this.f4573a = i9;
        this.f4574b = fVar;
        this.f4575c = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4573a);
        this.f4574b.f4577a.performAction(this.f4575c, bundle);
    }
}
