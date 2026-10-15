package com.huawei.hms.common.internal;

import W5.f;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f14967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f14968b;

        public final ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String strValueOf = String.valueOf(obj);
            this.f14967a.add(f.k(new StringBuilder(strValueOf.length() + str2.length() + 1), str2, ContainerUtils.KEY_VALUE_DELIMITER, strValueOf));
            return this;
        }

        public final String toString() {
            String simpleName = this.f14968b.getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(100);
            sb.append(simpleName);
            sb.append('{');
            int size = this.f14967a.size();
            for (int i9 = 0; i9 < size; i9++) {
                sb.append(this.f14967a.get(i9));
                if (i9 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(Object obj) {
            this.f14968b = Preconditions.checkNotNull(obj);
            this.f14967a = new ArrayList();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean isNull(Object... objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
