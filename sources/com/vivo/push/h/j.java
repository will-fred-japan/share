package com.vivo.push.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: OnChangePushStatusReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class j extends com.vivo.push.t {
    public j(com.vivo.push.w wVar) {
        super(wVar);
    }

    private static List<ResolveInfo> a(Context context) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = null;
        }
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            return listQueryBroadcastReceivers;
        }
        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
        } catch (Exception unused2) {
            return listQueryBroadcastReceivers;
        }
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        if (this.f16804a.getPackageName().equals(com.vivo.push.util.ad.a(this.f16804a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) wVar;
        int iE = jVar.e();
        int iF = jVar.f();
        com.vivo.push.util.w.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + iE + " ; receiverStatus is " + iF);
        if (iE == 2) {
            Context context = this.f16804a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, listQueryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "disableService push service.");
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has disabled");
                }
            } else {
                com.vivo.push.util.w.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            }
        } else if (iE == 1) {
            Context context2 = this.f16804a;
            Intent intent2 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent2.setPackage(context2.getPackageName());
            List<ResolveInfo> listQueryIntentServices2 = context2.getPackageManager().queryIntentServices(intent2, 576);
            if (listQueryIntentServices2 != null && listQueryIntentServices2.size() > 0) {
                PackageManager packageManager2 = context2.getPackageManager();
                ComponentName componentName2 = new ComponentName(context2, listQueryIntentServices2.get(0).serviceInfo.name);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 1) {
                    packageManager2.setComponentEnabledSetting(componentName2, 1, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "enableService push service.");
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has enabled");
                }
            } else {
                com.vivo.push.util.w.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            }
        } else if (iE == 0) {
            Context context3 = this.f16804a;
            Intent intent3 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent3.setPackage(context3.getPackageName());
            List<ResolveInfo> listQueryIntentServices3 = context3.getPackageManager().queryIntentServices(intent3, 576);
            if (listQueryIntentServices3 != null && listQueryIntentServices3.size() > 0) {
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, listQueryIntentServices3.get(0).serviceInfo.name);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 0) {
                    packageManager3.setComponentEnabledSetting(componentName3, 0, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                com.vivo.push.util.w.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (iF == 2) {
            Context context4 = this.f16804a;
            List<ResolveInfo> listA = a(context4);
            if (listA != null && listA.size() > 0) {
                String str = listA.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 2) {
                    packageManager4.setComponentEnabledSetting(componentName4, 2, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service disableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.w.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            return;
        }
        if (iF == 1) {
            Context context5 = this.f16804a;
            List<ResolveInfo> listA2 = a(context5);
            if (listA2 != null && listA2.size() > 0) {
                String str2 = listA2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager5 = context5.getPackageManager();
                ComponentName componentName5 = new ComponentName(context5, str2);
                if (packageManager5.getComponentEnabledSetting(componentName5) != 1) {
                    packageManager5.setComponentEnabledSetting(componentName5, 1, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.w.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (iF == 0) {
            Context context6 = this.f16804a;
            List<ResolveInfo> listA3 = a(context6);
            if (listA3 != null && listA3.size() > 0) {
                String str3 = listA3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager6 = context6.getPackageManager();
                ComponentName componentName6 = new ComponentName(context6, str3);
                if (packageManager6.getComponentEnabledSetting(componentName6) != 0) {
                    packageManager6.setComponentEnabledSetting(componentName6, 0, 1);
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    com.vivo.push.util.w.d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            com.vivo.push.util.w.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
