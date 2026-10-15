package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0505q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f6652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f6653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6654c;

    public RunnableC0505q(TextView textView, Typeface typeface, int i9) {
        this.f6652a = textView;
        this.f6653b = typeface;
        this.f6654c = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6652a.setTypeface(this.f6653b, this.f6654c);
    }
}
