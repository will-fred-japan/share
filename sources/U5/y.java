package U5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PrefixMap.java */
/* JADX INFO: loaded from: classes.dex */
public final class y<P> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p012b6.a f4738b = p012b6.a.a(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4739a;

    /* JADX INFO: compiled from: PrefixMap.java */
    public class a implements Iterable<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f4741b;

        public a(List list, List list2) {
            this.f4740a = list;
            this.f4741b = list2;
        }

        @Override // java.lang.Iterable
        public final Iterator<P> iterator() {
            return new b(this.f4740a.iterator(), this.f4741b.iterator());
        }
    }

    /* JADX INFO: compiled from: PrefixMap.java */
    public static class b<P> implements Iterator<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<P> f4742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<P> f4743b;

        public b(Iterator it, Iterator it2) {
            this.f4742a = it;
            this.f4743b = it2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4742a.hasNext() || this.f4743b.hasNext();
        }

        @Override // java.util.Iterator
        public final P next() {
            Iterator<P> it = this.f4742a;
            return it.hasNext() ? it.next() : this.f4743b.next();
        }
    }

    public y(HashMap map) {
        this.f4739a = map;
    }

    public final Iterable<P> a(byte[] bArr) {
        List list;
        HashMap map = this.f4739a;
        List list2 = (List) map.get(f4738b);
        if (bArr.length >= 5) {
            list = (List) map.get(new p012b6.a(bArr, 5 > bArr.length ? bArr.length : 5));
        } else {
            list = null;
        }
        if (list2 == null && list == null) {
            return new ArrayList();
        }
        if (list2 == null) {
            return list;
        }
        return list == null ? list2 : new a(list, list2);
    }
}
