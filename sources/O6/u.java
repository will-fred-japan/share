package O6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SqlCommand.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f3577b;

    public u(String str, List<Object> list) {
        this.f3576a = str;
        this.f3577b = list == null ? new ArrayList<>() : list;
    }

    public static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            bArr[i9] = (byte) ((Integer) list.get(i9)).intValue();
        }
        return bArr;
    }

    public final Object[] a() {
        ArrayList arrayList = new ArrayList();
        List<Object> list = this.f3577b;
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b(it.next()));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        String str = this.f3576a;
        if (str != null) {
            if (!str.equals(uVar.f3576a)) {
                return false;
            }
        } else if (uVar.f3576a != null) {
            return false;
        }
        List<Object> list = this.f3577b;
        if (list.size() != uVar.f3577b.size()) {
            return false;
        }
        for (int i9 = 0; i9 < list.size(); i9++) {
            boolean z8 = list.get(i9) instanceof byte[];
            List<Object> list2 = uVar.f3577b;
            if (z8 && (list2.get(i9) instanceof byte[])) {
                if (!Arrays.equals((byte[]) list.get(i9), (byte[]) list2.get(i9))) {
                    return false;
                }
            } else if (!list.get(i9).equals(list2.get(i9))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f3576a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3576a);
        List<Object> list = this.f3577b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + list;
        }
        sb.append(str);
        return sb.toString();
    }
}
