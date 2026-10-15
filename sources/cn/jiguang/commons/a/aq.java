package cn.jiguang.commons.a;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
final class aq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f9676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9678d;

    private aq() {
    }

    public final synchronized void a(int i9, Object obj, long j, long j8) {
        this.f9675a = i9;
        this.f9676b = obj;
        this.f9677c = j;
        this.f9678d = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ap apVar = as.f9682a;
        try {
            m mVar = (m) apVar.f9673a.get(Integer.valueOf(this.f9675a));
            if (mVar != null) {
                mVar.a(null, this.f9677c, this.f9678d);
            } else {
                m mVar2 = new m(null, this.f9677c, this.f9678d);
                apVar.f9673a.put(Integer.valueOf(this.f9675a), mVar2);
                mVar = mVar2;
            }
            int i9 = this.f9675a;
            if (i9 != 1100 && i9 != 1110) {
                try {
                    try {
                        if (jq.a(jq.a(i9), String.valueOf(this.f9676b))) {
                            kq.a().a(String.valueOf(i9), mVar.c());
                            ee.a("CacheManager", "file saved:" + i9);
                        } else {
                            ee.d("CacheManager", "file save failed:" + i9);
                        }
                    } catch (Throwable th) {
                        ee.d("CacheManager", "fallback mem update err:" + this.f9675a + Constants.COLON_SEPARATOR + th.getMessage());
                        return;
                    }
                } catch (Throwable th2) {
                    ee.d("CacheManager", "file save err:" + i9 + Constants.COLON_SEPARATOR + th2.getMessage());
                }
            }
            kq.a().a(String.valueOf(this.f9675a), mVar.c());
        } catch (Throwable unused) {
            m mVar3 = (m) apVar.f9673a.get(Integer.valueOf(this.f9675a));
            if (mVar3 != null) {
                mVar3.a(null, this.f9677c, this.f9678d);
            } else {
                apVar.f9673a.put(Integer.valueOf(this.f9675a), new m(null, this.f9677c, this.f9678d));
            }
        }
    }

    public /* synthetic */ aq(byte b9) {
        this();
    }
}
