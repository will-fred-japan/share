package G;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NotificationManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2188d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f2191g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f2193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2187c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashSet f2189e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f2190f = new Object();

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    public static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f2197d;

        public a(String str, int i9, String str2, Notification notification) {
            this.f2194a = str;
            this.f2195b = i9;
            this.f2196c = str2;
            this.f2197d = notification;
        }

        @Override // G.y.d
        public final void a(p021d.a aVar) {
            aVar.E(this.f2194a, this.f2195b, this.f2196c, this.f2197d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
            sb.append(this.f2194a);
            sb.append(", id:");
            sb.append(this.f2195b);
            sb.append(", tag:");
            return A.a.j(sb, this.f2196c, "]");
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f2198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f2199b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.f2198a = componentName;
            this.f2199b = iBinder;
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    public static class c implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f2201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap f2202c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HashSet f2203d = new HashSet();

        /* JADX INFO: compiled from: NotificationManagerCompat.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f2204a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public p021d.a f2206c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f2205b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final ArrayDeque<d> f2207d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f2208e = 0;

            public a(ComponentName componentName) {
                this.f2204a = componentName;
            }
        }

        public c(Context context) {
            this.f2200a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            handlerThread.start();
            this.f2201b = new Handler(handlerThread.getLooper(), this);
        }

        public final void a(a aVar) {
            boolean z8;
            ArrayDeque<d> arrayDeque;
            boolean zIsLoggable = Log.isLoggable("NotifManCompat", 3);
            ComponentName componentName = aVar.f2204a;
            if (zIsLoggable) {
                Log.d("NotifManCompat", "Processing component " + componentName + ", " + aVar.f2207d.size() + " queued tasks");
            }
            if (aVar.f2207d.isEmpty()) {
                return;
            }
            if (aVar.f2205b) {
                z8 = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.f2200a;
                boolean zBindService = context.bindService(component, this, 33);
                aVar.f2205b = zBindService;
                if (zBindService) {
                    aVar.f2208e = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z8 = aVar.f2205b;
            }
            if (!z8 || aVar.f2206c == null) {
                b(aVar);
                return;
            }
            while (true) {
                arrayDeque = aVar.f2207d;
                d dVarPeek = arrayDeque.peek();
                if (dVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + dVarPeek);
                    }
                    dVarPeek.a(aVar.f2206c);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + componentName);
                    }
                } catch (RemoteException e9) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e9);
                }
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            b(aVar);
        }

        public final void b(a aVar) {
            Handler handler = this.f2201b;
            ComponentName componentName = aVar.f2204a;
            if (handler.hasMessages(3, componentName)) {
                return;
            }
            int i9 = aVar.f2208e;
            int i10 = i9 + 1;
            aVar.f2208e = i10;
            if (i10 <= 6) {
                int i11 = (1 << i9) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i11 + " ms");
                }
                handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i11);
                return;
            }
            StringBuilder sb = new StringBuilder("Giving up on delivering ");
            ArrayDeque<d> arrayDeque = aVar.f2207d;
            sb.append(arrayDeque.size());
            sb.append(" tasks to ");
            sb.append(componentName);
            sb.append(" after ");
            sb.append(aVar.f2208e);
            sb.append(" retries");
            Log.w("NotifManCompat", sb.toString());
            arrayDeque.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            HashSet hashSet;
            int i9 = message.what;
            p021d.a aVar = null;
            if (i9 == 0) {
                d dVar = (d) message.obj;
                String string = Settings.Secure.getString(this.f2200a.getContentResolver(), "enabled_notification_listeners");
                synchronized (y.f2187c) {
                    if (string != null) {
                        try {
                            if (!string.equals(y.f2188d)) {
                                String[] strArrSplit = string.split(Constants.COLON_SEPARATOR, -1);
                                HashSet hashSet2 = new HashSet(strArrSplit.length);
                                for (String str : strArrSplit) {
                                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                                    if (componentNameUnflattenFromString != null) {
                                        hashSet2.add(componentNameUnflattenFromString.getPackageName());
                                    }
                                }
                                y.f2189e = hashSet2;
                                y.f2188d = string;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    hashSet = y.f2189e;
                }
                if (!hashSet.equals(this.f2203d)) {
                    this.f2203d = hashSet;
                    List<ResolveInfo> listQueryIntentServices = this.f2200a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet<ComponentName> hashSet3 = new HashSet();
                    for (ResolveInfo resolveInfo : listQueryIntentServices) {
                        if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                            } else {
                                hashSet3.add(componentName);
                            }
                        }
                    }
                    for (ComponentName componentName2 : hashSet3) {
                        if (!this.f2202c.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                            }
                            this.f2202c.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator it = this.f2202c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (!hashSet3.contains(entry.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                            }
                            a aVar2 = (a) entry.getValue();
                            if (aVar2.f2205b) {
                                this.f2200a.unbindService(this);
                                aVar2.f2205b = false;
                            }
                            aVar2.f2206c = null;
                            it.remove();
                        }
                    }
                }
                for (a aVar3 : this.f2202c.values()) {
                    aVar3.f2207d.add(dVar);
                    a(aVar3);
                }
            } else if (i9 == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.f2198a;
                IBinder iBinder = bVar.f2199b;
                a aVar4 = (a) this.f2202c.get(componentName3);
                if (aVar4 != null) {
                    int i10 = p021d.a.AbstractBinderC0191a.f18446a;
                    if (iBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(p021d.a.t);
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p021d.a)) {
                            p021d.a.AbstractBinderC0191a.C0192a c0192a = new p021d.a.AbstractBinderC0191a.C0192a();
                            c0192a.f18447a = iBinder;
                            aVar = c0192a;
                        } else {
                            aVar = (p021d.a) iInterfaceQueryLocalInterface;
                        }
                    }
                    aVar4.f2206c = aVar;
                    aVar4.f2208e = 0;
                    a(aVar4);
                    return true;
                }
            } else if (i9 == 2) {
                a aVar5 = (a) this.f2202c.get((ComponentName) message.obj);
                if (aVar5 != null) {
                    if (aVar5.f2205b) {
                        this.f2200a.unbindService(this);
                        aVar5.f2205b = false;
                    }
                    aVar5.f2206c = null;
                    return true;
                }
            } else {
                if (i9 != 3) {
                    return false;
                }
                a aVar6 = (a) this.f2202c.get((ComponentName) message.obj);
                if (aVar6 != null) {
                    a(aVar6);
                    return true;
                }
            }
            return true;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2201b.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2201b.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: NotificationManagerCompat.java */
    public interface d {
        void a(p021d.a aVar);
    }

    public y(Context context) {
        this.f2192a = context;
        this.f2193b = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    public final void a(int i9, String str) {
        this.f2193b.cancel(str, i9);
    }

    public final void b(String str, int i9, Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            this.f2193b.notify(str, i9, notification);
            return;
        }
        a aVar = new a(this.f2192a.getPackageName(), i9, str, notification);
        synchronized (f2190f) {
            try {
                if (f2191g == null) {
                    f2191g = new c(this.f2192a.getApplicationContext());
                }
                f2191g.f2201b.obtainMessage(0, aVar).sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2193b.cancel(str, i9);
    }
}
