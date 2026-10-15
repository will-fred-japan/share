package p015c0;

import B0.N;
import W5.f;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import p188x7.e;
import y7.i;
import y7.n;
import y7.t;

/* JADX INFO: compiled from: Preferences.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N f8666b;

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Preferences.kt */
    public static final class C0115a extends l implements K7.l<Map.Entry<c.a<?>, Object>, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0115a f8667a = new C0115a(1);

        @Override // K7.l
        public final CharSequence invoke(Map.Entry<c.a<?>, Object> entry) {
            String strValueOf;
            Map.Entry<c.a<?>, Object> entry2 = entry;
            k.e(entry2, "entry");
            Object value = entry2.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                k.e(bArr, "<this>");
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "[");
                int i9 = 0;
                for (byte b9 : bArr) {
                    i9++;
                    if (i9 > 1) {
                        sb.append((CharSequence) ", ");
                    }
                    sb.append((CharSequence) String.valueOf((int) b9));
                }
                sb.append((CharSequence) "]");
                strValueOf = sb.toString();
            } else {
                strValueOf = String.valueOf(entry2.getValue());
            }
            return f.k(new StringBuilder("  "), entry2.getKey().f8671a, " = ", strValueOf);
        }
    }

    public a() {
        this(false, 3);
    }

    @Override // p015c0.c
    public final Map<c.a<?>, Object> a() {
        e eVar;
        Set<Map.Entry> setEntrySet = this.f8665a.entrySet();
        int iA = t.A(i.E(setEntrySet));
        if (iA < 16) {
            iA = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                k.d(bArrCopyOf, "copyOf(this, size)");
                eVar = new e(key, bArrCopyOf);
            } else {
                eVar = new e(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(eVar.f22353a, eVar.f22354b);
        }
        Map<c.a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        k.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p015c0.c
    public final <T> T b(c.a<T> key) {
        k.e(key, "key");
        T t = (T) this.f8665a.get(key);
        if (!(t instanceof byte[])) {
            return t;
        }
        byte[] bArr = (byte[]) t;
        T t6 = (T) Arrays.copyOf(bArr, bArr.length);
        k.d(t6, "copyOf(this, size)");
        return t6;
    }

    public final void c() {
        if (((AtomicBoolean) this.f8666b.f1624b).get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void d(c.a<?> key, Object obj) {
        k.e(key, "key");
        c();
        LinkedHashMap linkedHashMap = this.f8665a;
        if (obj == null) {
            c();
            linkedHashMap.remove(key);
            return;
        }
        if (obj instanceof Set) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(n.U((Set) obj));
            k.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(key, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(key, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            k.d(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(key, bArrCopyOf);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    public final boolean equals(Object obj) {
        boolean zA;
        if (obj instanceof a) {
            a aVar = (a) obj;
            LinkedHashMap linkedHashMap = aVar.f8665a;
            LinkedHashMap linkedHashMap2 = this.f8665a;
            if (linkedHashMap != linkedHashMap2) {
                if (linkedHashMap.size() == linkedHashMap2.size()) {
                    LinkedHashMap linkedHashMap3 = aVar.f8665a;
                    if (!linkedHashMap3.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap3.entrySet()) {
                            Object obj2 = linkedHashMap2.get(entry.getKey());
                            if (obj2 != null) {
                                Object value = entry.getValue();
                                if (!(value instanceof byte[])) {
                                    zA = k.a(value, obj2);
                                } else if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2)) {
                                    zA = true;
                                } else {
                                    zA = false;
                                }
                            } else {
                                zA = false;
                            }
                            if (!zA) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Iterator it = this.f8665a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return n.M(this.f8665a.entrySet(), ",\n", "{\n", "\n}", C0115a.f8667a, 24);
    }

    public /* synthetic */ a(boolean z8, int i9) {
        this(new LinkedHashMap(), (i9 & 2) != 0 ? true : z8);
    }

    public a(LinkedHashMap linkedHashMap, boolean z8) {
        this.f8665a = linkedHashMap;
        this.f8666b = new N(z8);
    }
}
