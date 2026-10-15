package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f18089a = new a();

    public static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return jg.a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return jg.a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return jg.a((Map) obj, (Map) obj2);
            }
            return obj instanceof byte[] ? jg.a((byte[]) obj, (byte[]) obj2) : jg.a((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b9, byte b10) {
        if (b9 < b10) {
            return -1;
        }
        return b10 < b9 ? 1 : 0;
    }

    public static int a(int i9, int i10) {
        if (i9 < i10) {
            return -1;
        }
        return i10 < i9 ? 1 : 0;
    }

    public static int a(long j, long j8) {
        if (j < j8) {
            return -1;
        }
        return j8 < j ? 1 : 0;
    }

    public static int a(short s8, short s9) {
        if (s8 < s9) {
            return -1;
        }
        return s9 < s8 ? 1 : 0;
    }

    public static int a(boolean z8, boolean z9) {
        return Boolean.valueOf(z8).compareTo(Boolean.valueOf(z9));
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int iA = a(bArr.length, bArr2.length);
        if (iA != 0) {
            return iA;
        }
        for (int i9 = 0; i9 < bArr.length; i9++) {
            int iA2 = a(bArr[i9], bArr2[i9]);
            if (iA2 != 0) {
                return iA2;
            }
        }
        return 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(List list, List list2) {
        int iA = a(list.size(), list2.size());
        if (iA != 0) {
            return iA;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            int iCompare = f18089a.compare(list.get(i9), list2.get(i9));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int iA = a(set.size(), set2.size());
        if (iA != 0) {
            return iA;
        }
        Comparator comparator = f18089a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompare = f18089a.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int iA = a(map.size(), map2.size());
        if (iA != 0) {
            return iA;
        }
        Comparator comparator = f18089a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = f18089a;
            int iCompare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (iCompare2 != 0) {
                return iCompare2;
            }
        }
        return 0;
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        int iLimit = byteBuffer.limit();
        int i9 = iLimit - iArrayOffset > 128 ? iArrayOffset + 128 : iLimit;
        for (int i10 = iArrayOffset; i10 < i9; i10++) {
            if (i10 > iArrayOffset) {
                sb.append(" ");
            }
            sb.append(a(bArrArray[i10]));
        }
        if (iLimit != i9) {
            sb.append("...");
        }
    }

    public static String a(byte b9) {
        return Integer.toHexString((b9 | 256) & 511).toUpperCase().substring(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m628a(ByteBuffer byteBuffer) {
        if (m627a(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m627a(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i9) {
        int iRemaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), bArr, i9, iRemaining);
        return iRemaining;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        return m627a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m628a(byteBuffer));
    }
}
