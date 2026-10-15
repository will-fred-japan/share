package T;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class E extends G.b<CharSequence> {
    @Override // T.G.b
    public final CharSequence a(View view) {
        return G.j.b(view);
    }

    @Override // T.G.b
    public final void b(View view, CharSequence charSequence) {
        G.j.c(view, charSequence);
    }

    @Override // T.G.b
    public final boolean d(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
