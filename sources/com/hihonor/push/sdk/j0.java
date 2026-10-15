package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.RequestHeader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0 f14504c = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f14505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<g0, a> f14506b = new ConcurrentHashMap(5, 0.75f, 1);

    public static class b implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i1<?> f14515a;

        public b(i1<?> i1Var) {
            this.f14515a = i1Var;
        }
    }

    public j0() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f14505a = new Handler(handlerThread.getLooper(), this);
    }

    public d1 a(i1 i1Var) {
        u0<TResult> u0Var = new u0<>();
        i1Var.f14497a = u0Var;
        Log.i("HonorApiManager", "sendRequest start");
        Handler handler = this.f14505a;
        handler.sendMessage(handler.obtainMessage(1, i1Var));
        return u0Var.f14558a;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0149  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        boolean zBindService;
        String str;
        int i9 = message.what;
        if (i9 != 1) {
            if (i9 != 2) {
                return false;
            }
            i1 i1Var = (i1) message.obj;
            g0 g0Var = i1Var.f14500d;
            if (g0Var == null || !this.f14506b.containsKey(g0Var) || (aVar = this.f14506b.get(g0Var)) == null) {
                return true;
            }
            synchronized (aVar) {
                try {
                    h.a(j0.this.f14505a);
                    aVar.f14508b.remove(i1Var);
                    if (aVar.f14507a.peek() == null || aVar.f14508b.peek() == null) {
                        synchronized (aVar) {
                            h.a(j0.this.f14505a);
                            ((m0) aVar.f14509c).a();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        i1<?> i1Var2 = (i1) message.obj;
        g0 g0Var2 = i1Var2.f14500d;
        a aVar2 = this.f14506b.get(g0Var2);
        if (aVar2 == null) {
            Log.i("HonorApiManager", "connect and send request, create new connection manager.");
            aVar2 = new a(g0Var2);
            this.f14506b.put(g0Var2, aVar2);
        }
        synchronized (aVar2) {
            try {
                h.a(j0.this.f14505a);
                k kVar = aVar2.f14511e;
                if (kVar != null && kVar.f14527a != 0) {
                    i1Var2.b(kVar.a(), null);
                } else if (((m0) aVar2.f14509c).f14531a.get() == 3) {
                    aVar2.f14508b.add(i1Var2);
                    aVar2.a(i1Var2);
                } else {
                    aVar2.f14507a.add(i1Var2);
                    synchronized (aVar2) {
                        try {
                            h.a(j0.this.f14505a);
                            if (((m0) aVar2.f14509c).f14531a.get() == 3) {
                                str = "client is connected";
                            } else if (((m0) aVar2.f14509c).f14531a.get() == 5) {
                                str = "client is isConnecting";
                            } else {
                                m0 m0Var = (m0) aVar2.f14509c;
                                m0Var.getClass();
                                Log.i("PushConnectionClient", " ==== PUSHSDK VERSION 100013305 ====");
                                if (m0Var.f14531a.compareAndSet(0, 5)) {
                                    a0 a0Var = a0.f14448c;
                                    Context contextA = a0Var.a();
                                    com.hihonor.push.sdk.a aVarB = h.b(contextA);
                                    int iA = h.a(contextA, aVarB);
                                    k kVar2 = k.SUCCESS;
                                    if (iA == 0) {
                                        Log.i("PushConnectionClient", "enter bindCoreService.");
                                        n0 n0Var = new n0(aVarB);
                                        m0Var.f14534d = n0Var;
                                        n0Var.f14539c = new l0(m0Var);
                                        try {
                                            if (TextUtils.isEmpty(aVarB.f14447b) && TextUtils.isEmpty(null)) {
                                                Log.e("AIDLSrvConnection", "bind core is null : " + n0Var.f14538b);
                                                n0Var.a(8002004);
                                            } else if (TextUtils.isEmpty(aVarB.f14446a)) {
                                                Log.e("AIDLSrvConnection", "bind core is null : " + n0Var.f14538b);
                                                n0Var.a(8002004);
                                            } else {
                                                Intent intent = new Intent();
                                                com.hihonor.push.sdk.a aVar3 = n0Var.f14538b;
                                                String str2 = aVar3.f14446a;
                                                String str3 = aVar3.f14447b;
                                                if (TextUtils.isEmpty(str3)) {
                                                    intent.setAction(null);
                                                    intent.setPackage(str2);
                                                } else {
                                                    intent.setComponent(new ComponentName(str2, str3));
                                                }
                                                Context contextA2 = a0Var.a();
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    Looper looperMyLooper = Looper.myLooper();
                                                    n0Var.a(looperMyLooper);
                                                    zBindService = contextA2.bindService(intent, 1, new s0(new Handler(looperMyLooper)), n0Var);
                                                } else {
                                                    n0Var.a(Looper.getMainLooper());
                                                    zBindService = contextA2.bindService(intent, n0Var, 1);
                                                }
                                                if (!zBindService) {
                                                    Log.e("AIDLSrvConnection", "bind core service fail");
                                                    n0Var.a();
                                                    n0Var.a(8002001);
                                                }
                                            }
                                        } catch (Exception e9) {
                                            Log.e("AIDLSrvConnection", "bindCoreService error: " + e9);
                                        }
                                    } else {
                                        m0Var.a(iA);
                                    }
                                }
                            }
                            Log.i("HonorApiManager", str);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return true;
    }

    public class a implements k0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<i1<?>> f14507a = new LinkedList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<i1<?>> f14508b = new LinkedList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k0 f14509c = new m0(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g0 f14510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public k f14511e;

        /* JADX INFO: renamed from: com.hihonor.push.sdk.j0$a$a, reason: collision with other inner class name */
        public class RunnableC0162a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f14513a;

            public RunnableC0162a(int i9) {
                this.f14513a = i9;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(k.f14525m.get(this.f14513a, k.ERROR_UNKNOWN));
            }
        }

        public a(g0 g0Var) {
            this.f14510d = g0Var;
        }

        public final synchronized void a() {
            try {
                Log.i("HonorApiManager", "onConnectedSuccess");
                h.a(j0.this.f14505a);
                for (i1<?> i1Var : this.f14507a) {
                    this.f14508b.add(i1Var);
                    a(i1Var);
                }
                this.f14507a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void a(k kVar) {
            try {
                Log.i("HonorApiManager", "onConnectionFailed");
                h.a(j0.this.f14505a);
                Iterator<i1<?>> it = this.f14507a.iterator();
                while (it.hasNext()) {
                    it.next().b(kVar.a(), null);
                }
                this.f14507a.clear();
                Iterator<i1<?>> it2 = this.f14508b.iterator();
                while (it2.hasNext()) {
                    it2.next().b(kVar.a(), null);
                }
                this.f14508b.clear();
                synchronized (this) {
                    h.a(j0.this.f14505a);
                    m0 m0Var = (m0) this.f14509c;
                    m0Var.getClass();
                    Log.i("PushConnectionClient", "enter disconnect");
                    m0Var.f14532b = null;
                    m0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
            if (this.f14511e == null) {
                this.f14511e = kVar;
                j0.this.f14506b.remove(this.f14510d);
            }
        }

        public void a(int i9) {
            if (Looper.myLooper() == j0.this.f14505a.getLooper()) {
                a(k.f14525m.get(i9, k.ERROR_UNKNOWN));
            } else {
                j0.this.f14505a.post(new RunnableC0162a(i9));
            }
        }

        public final synchronized void a(i1<?> i1Var) {
            g gVar;
            Type type;
            try {
                k0 k0Var = this.f14509c;
                b bVar = new b(i1Var);
                i1Var.getClass();
                Object objNewInstance = null;
                int i9 = 0;
                try {
                    Type genericSuperclass = i1Var.getClass().getGenericSuperclass();
                    Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                    if (cls != null && !cls.isPrimitive()) {
                        objNewInstance = cls.newInstance();
                    }
                } catch (Exception e9) {
                    m.a("In newResponseInstance, instancing exception." + e9.getMessage());
                }
                p0 p0Var = new p0(objNewInstance, bVar);
                Log.i("IpcTransport", "start transport parse. " + i1Var.f14498b);
                m0 m0Var = (m0) k0Var;
                synchronized (m0Var) {
                    gVar = m0Var.f14533c;
                }
                String str = i1Var.f14498b;
                RequestHeader requestHeader = i1Var.f14501e;
                e eVar = i1Var.f14499c;
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                h.a(requestHeader, bundle);
                h.a(eVar, bundle2);
                d dVar = new d(str, bundle, bundle2);
                try {
                    if (gVar != null) {
                        gVar.a(dVar, p0Var);
                        Log.i("IpcTransport", "end transport parse.");
                        k kVar = k.SUCCESS;
                    } else {
                        Log.i("IpcTransport", "transport invoke is null.");
                        k kVar2 = k.SUCCESS;
                        i9 = 8002002;
                    }
                } catch (Exception e10) {
                    Log.e("IpcTransport", "transport remote error. " + e10);
                }
                if (i9 != 0) {
                    a(i9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
