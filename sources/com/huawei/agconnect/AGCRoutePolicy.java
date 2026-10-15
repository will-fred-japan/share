package com.huawei.agconnect;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class AGCRoutePolicy {
    private final int route;
    public static final AGCRoutePolicy UNKNOWN = new AGCRoutePolicy(0);
    public static final AGCRoutePolicy CHINA = new AGCRoutePolicy(1);
    public static final AGCRoutePolicy GERMANY = new AGCRoutePolicy(2);
    public static final AGCRoutePolicy RUSSIA = new AGCRoutePolicy(3);
    public static final AGCRoutePolicy SINGAPORE = new AGCRoutePolicy(4);

    private AGCRoutePolicy(int i9) {
        this.route = i9;
    }

    private int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AGCRoutePolicy.class == obj.getClass() && this.route == ((AGCRoutePolicy) obj).route;
    }

    public String getRouteName() {
        int i9 = this.route;
        if (i9 == 1) {
            return "CN";
        }
        if (i9 == 2) {
            return "DE";
        }
        if (i9 != 3) {
            return i9 != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "SG";
        }
        return "RU";
    }

    public int hashCode() {
        return hash(Integer.valueOf(this.route));
    }
}
