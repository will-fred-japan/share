package com.heytap.msp.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.C0524s;
import com.heytap.mcssdk.utils.e;
import com.heytap.mcssdk.utils.i;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DataMessageReceivingService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14405a = "DataMessageReceivingService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14406b = "com.heytap.msp.push.action.RECEIVE_ENHANCED_DATA_MESSAGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f14407c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f14408d = new Object();

    private Intent a(Intent intent) {
        try {
            Intent intent2 = new Intent(f14406b);
            intent2.setPackage(getPackageName());
            ResolveInfo resolveInfoResolveService = getPackageManager().resolveService(intent2, 0);
            if (resolveInfoResolveService == null || !getPackageName().equals(resolveInfoResolveService.serviceInfo.packageName)) {
                e.e(f14405a, "No service found to handle action: com.heytap.msp.push.action.RECEIVE_ENHANCED_DATA_MESSAGE");
                return null;
            }
            ServiceInfo serviceInfo = resolveInfoResolveService.serviceInfo;
            intent2.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
            if (intent.getExtras() == null) {
                return intent2;
            }
            intent2.putExtras(intent.getExtras());
            return intent2;
        } catch (Exception e9) {
            e.e(f14405a, "Error creating processing intent: " + e9.getMessage());
            return null;
        }
    }

    private boolean b(Intent intent) {
        String str;
        if (intent == null) {
            str = "Intent is null";
        } else {
            if (!TextUtils.isEmpty(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14286c))) {
                e.b(f14405a, "Intent validation passed");
                return true;
            }
            str = "Message ID is empty in intent";
        }
        e.e(f14405a, str);
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(final Intent intent) {
        if (intent == null) {
            e.e(f14405a, "onBind: intent is null");
            return null;
        }
        final int iIncrementAndGet = f14407c.incrementAndGet();
        e.b(f14405a, "DataMessageReceivingService onBind called, message #" + iIncrementAndGet);
        try {
            if (b(intent)) {
                i.a(new Runnable() { // from class: com.heytap.msp.push.service.DataMessageReceivingService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataMessageReceivingService.this.a(intent, iIncrementAndGet);
                    }
                });
                return new Binder();
            }
            e.e(f14405a, "Intent validation failed for message #" + iIncrementAndGet);
            return null;
        } catch (Exception e9) {
            StringBuilder sbA = C0524s.a(iIncrementAndGet, "Error in onBind for message #", ": ");
            sbA.append(e9.getMessage());
            e.e(f14405a, sbA.toString());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        e.b(f14405a, "DataMessageReceivingService onDestroy called, Processed messages: " + f14407c.get());
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        e.b(f14405a, "DataMessageReceivingService onUnbind called");
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, int i9) {
        synchronized (this.f14408d) {
            try {
                e.b(f14405a, "Forwarding message #" + i9 + " to processing layer");
                Intent intentA = a(intent);
                if (intentA == null) {
                    e.e(f14405a, "Failed to create processing intent for message #" + i9);
                    return;
                }
                ComponentName componentNameStartService = startService(intentA);
                if (componentNameStartService != null) {
                    e.b(f14405a, "Successfully started processing service for message #" + i9 + ", component: " + componentNameStartService.getClassName());
                } else {
                    e.d(f14405a, "Failed to start processing service for message #" + i9);
                }
            } catch (Exception e9) {
                e.e(f14405a, "Error forwarding message #" + i9 + ": " + e9.getMessage());
            }
        }
    }
}
