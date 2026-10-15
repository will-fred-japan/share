package Q7;

import R7.b.a;
import java.util.Iterator;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements Iterable<Object>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ R7.b f3886a;

    public l(R7.b bVar) {
        this.f3886a = bVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return this.f3886a.new a();
    }
}
