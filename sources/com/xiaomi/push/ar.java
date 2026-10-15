package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
class ar implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f17047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ServiceConnection f125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f123a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f126a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f127a = new Object();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f17049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f17050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f17051d;

        private a() {
            this.f128a = null;
            this.f17049b = null;
            this.f17050c = null;
            this.f17051d = null;
        }
    }

    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public ar(Context context) {
        this.f124a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m102b() {
        ServiceConnection serviceConnection = this.f125a;
        if (serviceConnection != null) {
            try {
                this.f124a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f124a.getPackageManager().getPackageInfo(this.f124a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b9 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b9 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public boolean mo96a() {
        return f17047a;
    }

    @Override // com.xiaomi.push.al
    /* JADX INFO: renamed from: a */
    public String mo95a() {
        a("getOAID");
        if (this.f126a == null) {
            return null;
        }
        return this.f126a.f17049b;
    }

    private void a() {
        boolean zBindService;
        this.f125a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            zBindService = this.f124a.bindService(intent, this.f125a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f123a = zBindService ? 1 : 2;
    }

    private void a(String str) {
        if (this.f123a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f127a) {
            try {
                com.xiaomi.channel.commonutils.logger.c.m9a("oppo's " + str + " wait...");
                this.f127a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                } else {
                    longVersionCode = packageInfo.versionCode;
                }
                boolean z8 = (packageInfo.applicationInfo.flags & 1) != 0;
                f17047a = longVersionCode >= 1;
                if (z8) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ar.this.f126a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.ar.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = ar.this.f124a.getPackageName();
                        String strB = ar.this.b();
                        a aVar = new a();
                        aVar.f17049b = c.a(iBinder, packageName, strB, "OUID");
                        ar.this.f126a = aVar;
                        ar.this.m102b();
                        ar.this.f123a = 2;
                        synchronized (ar.this.f127a) {
                            try {
                                ar.this.f127a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ar.this.m102b();
                        ar.this.f123a = 2;
                        synchronized (ar.this.f127a) {
                            try {
                                ar.this.f127a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ar.this.m102b();
                        ar.this.f123a = 2;
                        synchronized (ar.this.f127a) {
                            try {
                                ar.this.f127a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
