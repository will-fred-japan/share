package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10051a;

    static {
        int[] iArr = new int[fl.values().length];
        f10051a = iArr;
        try {
            iArr[fl.LIGHT_TASK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10051a[fl.APP_COLLECTION.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f10051a[fl.NETWORK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f10051a[fl.DEVICE_INFO.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
