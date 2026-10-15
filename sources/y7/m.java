package y7;

import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements Q7.e<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f22406a;

    public m(Iterable iterable) {
        this.f22406a = iterable;
    }

    @Override // Q7.e
    public final Iterator<Object> iterator() {
        return this.f22406a.iterator();
    }
}
