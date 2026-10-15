package cn.jiguang.commons.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f9915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f9916b = km.b("7vqR3nNqKoDAlUrx74tE1g==", f.f10031c);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f9917c = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ServiceConnection f9918d = new dv(this);

    public du(Context context) {
        this.f9915a = context;
    }

    public final String a() {
        try {
            String packageName = this.f9915a.getPackageName();
            Intent intent = new Intent();
            String str = this.f9916b;
            String str2 = f.f10031c;
            intent.setClassName(str, km.b("dYE0CPNDFJTaYbJHvdYTELPkLL9xmlHysh4O1rCwUiLYHLJ6VxirNHcrSo3Xn2UJ", str2));
            intent.setAction(km.b("AdKS/+o+CvOMDbvCnPWRYS8wCU0Ooy6tyMT0tXjLMUvWRKeDq6D985Ar35mAOPu+", str2));
            intent.putExtra(km.b("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM=", str2), packageName);
            try {
                intent.putExtra(km.b("iCmt493CpcicRY98bz8pUjI+wbDT5u8oLPJxFa2B2Zg=", str2), true);
                this.f9915a.startService(intent);
            } catch (Throwable th) {
                ee.d("MsaOpenIDHelper", "startMsaklServer error: " + th.getMessage());
            }
            Intent intent2 = new Intent();
            String str3 = this.f9916b;
            String str4 = f.f10031c;
            intent2.setClassName(str3, km.b("dYE0CPNDFJTaYbJHvdYTEBK/MhYfAvKlbba3ZFsuZ+on9OG47ABUmhfzcQhqhJOU", str4));
            intent2.setAction(km.b("AdKS/+o+CvOMDbvCnPWRYUnA2ZKRLZpCerAAd95VliYNvOuVTnj4/o7GUNhJXhWl", str4));
            intent2.putExtra(km.b("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM=", str4), packageName);
            if (this.f9915a.bindService(intent2, this.f9918d, 1)) {
                try {
                    try {
                        IBinder iBinderPoll = this.f9917c.poll(3L, TimeUnit.SECONDS);
                        if (iBinderPoll == null) {
                            try {
                                this.f9915a.unbindService(this.f9918d);
                            } catch (Throwable unused) {
                            }
                            return "";
                        }
                        dy dyVar = new dy(iBinderPoll);
                        String strA = dyVar.a();
                        dyVar.b();
                        try {
                            this.f9915a.unbindService(this.f9918d);
                        } catch (Throwable unused2) {
                        }
                        return strA;
                    } catch (Throwable unused3) {
                        this.f9915a.unbindService(this.f9918d);
                        return "";
                    }
                } catch (Throwable unused4) {
                }
            }
        } catch (Throwable th2) {
            defpackage.f.n(th2, new StringBuilder("get o failed: "), "MsaOpenIDHelper");
        }
        return "";
    }
}
