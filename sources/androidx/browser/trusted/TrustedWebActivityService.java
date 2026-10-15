package androidx.browser.trusted;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Locale;
import p014c.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class TrustedWebActivityService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f6743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6744b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6745c = new a();

    public class a extends b.a {
        public a() {
            attachInterface(this, b.f8664s);
        }

        public final void y() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int i9 = trustedWebActivityService.f6744b;
            if (i9 != -1) {
                if (i9 != Binder.getCallingUid()) {
                    throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
                }
            } else {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                trustedWebActivityService.b();
                throw null;
            }
        }
    }

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public abstract p139s.a b();

    public final int c() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f6745c;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f6743a = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.f6744b = -1;
        return super.onUnbind(intent);
    }
}
