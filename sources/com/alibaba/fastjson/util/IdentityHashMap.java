package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class IdentityHashMap<K, V> {
    public static final int DEFAULT_SIZE = 8192;
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    public static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k7, V v5, int i9, Entry<K, V> entry) {
            this.key = k7;
            this.value = v5;
            this.next = entry;
            this.hashCode = i9;
        }
    }

    public IdentityHashMap() {
        this(8192);
    }

    public void clear() {
        Arrays.fill(this.buckets, (Object) null);
    }

    public Class findClass(String str) {
        int i9 = 0;
        while (true) {
            Entry<K, V>[] entryArr = this.buckets;
            if (i9 >= entryArr.length) {
                return null;
            }
            Entry<K, V> entry = entryArr[i9];
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k7 = entry.key;
                    if (k7 instanceof Class) {
                        Class cls = (Class) k7;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i9++;
        }
    }

    public final V get(K k7) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k7) & this.indexMask]; entry != null; entry = entry.next) {
            if (k7 == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(K k7, V v5) {
        int iIdentityHashCode = System.identityHashCode(k7);
        int i9 = this.indexMask & iIdentityHashCode;
        for (Entry<K, V> entry = this.buckets[i9]; entry != null; entry = entry.next) {
            if (k7 == entry.key) {
                entry.value = v5;
                return true;
            }
        }
        this.buckets[i9] = new Entry<>(k7, v5, iIdentityHashCode, this.buckets[i9]);
        return false;
    }

    public int size() {
        int i9 = 0;
        for (Entry<K, V> entry : this.buckets) {
            for (; entry != null; entry = entry.next) {
                i9++;
            }
        }
        return i9;
    }

    public IdentityHashMap(int i9) {
        this.indexMask = i9 - 1;
        this.buckets = new Entry[i9];
    }
}
