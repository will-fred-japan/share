package cn.jiguang.ac;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashSet<g> f8873a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedHashSet<g> f8874b = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Boolean> f8875c = new ArrayList();

    public g a(int i9) {
        g gVarA;
        List<Boolean> list;
        Boolean bool;
        cn.jiguang.x.f.c("IpPool", "current ipv4List=" + this.f8873a + " ipv6List=" + this.f8874b);
        if (i9 == 0) {
            gVarA = a(false, false);
        } else if (i9 == 1) {
            gVarA = a(false, true);
        } else if (i9 != 2) {
            gVarA = i9 != 3 ? null : a(true, false);
        } else {
            gVarA = a(true, true);
        }
        cn.jiguang.x.f.c("IpPool", "get ipPort=" + gVarA);
        if (gVarA != null) {
            InetAddress inetAddress = gVarA.f8878c;
            if (inetAddress instanceof Inet4Address) {
                list = this.f8875c;
                bool = Boolean.FALSE;
            } else if (inetAddress instanceof Inet6Address) {
                list = this.f8875c;
                bool = Boolean.TRUE;
            }
            list.add(bool);
            return gVarA;
        }
        return gVarA;
    }

    private g a(boolean z8, boolean z9) {
        LinkedHashSet<g> linkedHashSet;
        LinkedHashSet<g> linkedHashSet2 = z8 ? this.f8874b : this.f8873a;
        if (z9) {
            linkedHashSet = null;
        } else {
            linkedHashSet = z8 ? this.f8873a : this.f8874b;
        }
        return (g) ((linkedHashSet == null || linkedHashSet.isEmpty() || !(linkedHashSet2 == null || linkedHashSet2.isEmpty() || a(z8))) ? a(linkedHashSet2) : a(linkedHashSet));
    }

    private static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public void a() {
        try {
            this.f8873a.clear();
            this.f8874b.clear();
        } catch (Throwable unused) {
        }
    }

    public boolean a(g gVar) {
        LinkedHashSet<g> linkedHashSet;
        if (gVar == null || !gVar.a()) {
            return false;
        }
        InetAddress inetAddress = gVar.f8878c;
        if (inetAddress instanceof Inet4Address) {
            linkedHashSet = this.f8873a;
        } else {
            if (!(inetAddress instanceof Inet6Address)) {
                return false;
            }
            linkedHashSet = this.f8874b;
        }
        return linkedHashSet.add(gVar);
    }

    private boolean a(boolean z8) {
        if (this.f8875c.size() < 2) {
            return false;
        }
        for (int size = this.f8875c.size() - 1; size >= this.f8875c.size() - 2; size--) {
            if (this.f8875c.get(size).booleanValue() != z8) {
                return false;
            }
        }
        return true;
    }
}
