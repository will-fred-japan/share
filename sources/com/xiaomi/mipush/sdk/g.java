package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hz;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<d, a> f16975a = new HashMap<>();

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16976a;

        static {
            int[] iArr = new int[d.values().length];
            f16976a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16976a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16976a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16976a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16978b;

        public a(String str, String str2) {
            this.f16977a = str;
            this.f16978b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f16975a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return f16975a.get(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static hz m62a(d dVar) {
        return hz.AggregatePushSwitch;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static v m61a(d dVar) {
        int i9 = AnonymousClass1.f16976a[dVar.ordinal()];
        if (i9 == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i9 == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i9 == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i9 != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}
