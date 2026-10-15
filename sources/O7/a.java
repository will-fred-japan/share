package O7;

import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Iterable<Character>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f3578a = (char) p199z2.b.B(1, 0, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3579b = 1;

    @Override // java.lang.Iterable
    public final Iterator<Character> iterator() {
        return new b(this.f3578a, this.f3579b);
    }
}
