package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes.dex */
public final class B extends C {

    /* JADX INFO: compiled from: LazyField.java */
    public static class a<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, B> f13998a;

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f13998a.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            B value = this.f13998a.getValue();
            if (value == null) {
                return null;
            }
            return value.a(null);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (!(obj instanceof Q)) {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            B value = this.f13998a.getValue();
            Q q8 = value.f14000a;
            value.f14001b = null;
            value.f14000a = (Q) obj;
            return q8;
        }
    }

    /* JADX INFO: compiled from: LazyField.java */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f13999a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f13999a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry<K, Object> next = this.f13999a.next();
            if (!(next.getValue() instanceof B)) {
                return next;
            }
            a aVar = new a();
            aVar.f13998a = next;
            return aVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f13999a.remove();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C
    public final boolean equals(Object obj) {
        return a(null).equals(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C
    public final int hashCode() {
        return a(null).hashCode();
    }

    public final String toString() {
        return a(null).toString();
    }
}
