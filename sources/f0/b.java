package f0;

import android.text.Editable;
import p022d0.j;

/* JADX INFO: compiled from: EmojiEditableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18647a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f18648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f18649c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f18649c;
        return cls != null ? new j(cls, charSequence) : super.newEditable(charSequence);
    }
}
