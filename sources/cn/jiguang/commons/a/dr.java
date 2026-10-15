package cn.jiguang.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes.dex */
final class dr extends Handler {
    public dr(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 11) {
            ee.a("VivoIdManager", "message type valid");
            return;
        }
        try {
            String unused = dq.f9907h = dq.f9903d.a(message.getData().getInt("type"), message.getData().getString(HiAnalyticsConstant.HaKey.BI_KEY_APPID));
            synchronized (dq.f9904e) {
                dq.f9904e.notify();
            }
        } catch (Throwable th) {
            try {
                String unused2 = dq.f9907h = "";
                ee.d("VivoIdManager", "vv getIds, exception" + th.getMessage());
            } finally {
                synchronized (dq.f9904e) {
                    dq.f9904e.notify();
                }
            }
        }
    }
}
