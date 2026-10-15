package cn.jiguang.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import cn.jiguang.android.IDataShare;
import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile a f10850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<String> f10851b = new ConcurrentLinkedQueue<>();

        private a() {
        }

        public static a a() {
            if (f10850a == null) {
                synchronized (a.class) {
                    try {
                        if (f10850a == null) {
                            f10850a = new a();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f10850a;
        }

        public boolean a(Bundle bundle) {
            if (bundle == null) {
                return false;
            }
            long jA = f.a(bundle);
            long jB = f.b(bundle);
            if (jA == -1 || jB == -1) {
                return false;
            }
            String str = jB + BundleUtil.UNDERLINE_TAG + jA;
            if (this.f10851b.contains(str)) {
                StringBuilder sbH = defpackage.f.h(jA, "Message ", " from run ");
                sbH.append(jB);
                sbH.append(" has been processed before");
                cn.jiguang.x.f.c("MessageProcessor", sbH.toString());
                return true;
            }
            synchronized (this) {
                try {
                    if (this.f10851b.size() >= 1000) {
                        this.f10851b.poll();
                    }
                    this.f10851b.offer(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static volatile b f10852b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<String, LinkedBlockingQueue<a>> f10853a = new ConcurrentHashMap<>();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Context f10854a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f10855b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f10856c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Bundle f10857d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f10858e;

            public a(Context context, String str, String str2, Bundle bundle, String str3) {
                this.f10854a = context;
                this.f10855b = str;
                this.f10856c = str2;
                this.f10857d = bundle;
                this.f10858e = str3;
            }

            public String a() {
                return this.f10855b;
            }

            public String b() {
                return this.f10856c;
            }

            public Bundle c() {
                return this.f10857d;
            }
        }

        private b() {
        }

        private a b(String str) {
            try {
                LinkedBlockingQueue<a> linkedBlockingQueue = this.f10853a.get(str);
                if (linkedBlockingQueue == null) {
                    return null;
                }
                return linkedBlockingQueue.poll();
            } catch (Exception e9) {
                cn.jiguang.x.f.i("MessageQueueManager", "从队列获取消息失败: " + e9.getMessage());
                return null;
            }
        }

        public synchronized Bundle a(Context context, Uri uri, String str) {
            if (context == null || str == null) {
                cn.jiguang.x.f.i("MessageQueueManager", "callMessage: context或toProcess为空");
                return null;
            }
            try {
                a aVarB = b(str);
                Bundle bundleCall = null;
                while (aVarB != null) {
                    try {
                        cn.jiguang.x.f.c("MessageQueueManager", "sendByProvider, uri=" + f.a(aVarB.c()) + Constants.ACCEPT_TIME_SEPARATOR_SP + uri + ", componentCls=" + aVarB.a() + ", action=" + aVarB.b());
                        bundleCall = context.getContentResolver().call(uri, aVarB.a(), aVarB.b(), aVarB.c());
                        aVarB = b(str);
                    } catch (Exception e9) {
                        cn.jiguang.x.f.i("MessageQueueManager", "发送消息失败: " + e9.getMessage());
                        a(aVarB, str);
                        throw e9;
                    }
                }
                return bundleCall;
            } catch (Exception e10) {
                cn.jiguang.x.f.l("MessageQueueManager", "callMessage发生异常: " + e10.getMessage());
                return null;
            }
        }

        public static b a() {
            if (f10852b == null) {
                synchronized (b.class) {
                    try {
                        if (f10852b == null) {
                            f10852b = new b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f10852b;
        }

        private LinkedBlockingQueue<a> a(String str) {
            LinkedBlockingQueue<a> linkedBlockingQueue;
            LinkedBlockingQueue<a> linkedBlockingQueue2 = this.f10853a.get(str);
            if (linkedBlockingQueue2 != null) {
                return linkedBlockingQueue2;
            }
            synchronized (this.f10853a) {
                try {
                    linkedBlockingQueue = this.f10853a.get(str);
                    if (linkedBlockingQueue == null) {
                        linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
                        this.f10853a.put(str, linkedBlockingQueue);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return linkedBlockingQueue;
        }

        public synchronized void a(IDataShare iDataShare, String str) {
            if (iDataShare == null || str == null) {
                cn.jiguang.x.f.i("MessageQueueManager", "sendMessage: aidl或toProcess为空");
                return;
            }
            a aVarB = b(str);
            while (aVarB != null) {
                try {
                    cn.jiguang.x.f.c("MessageQueueManager", "sendByAidl queue, " + f.a(aVarB.c()) + Constants.ACCEPT_TIME_SEPARATOR_SP + aVarB.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVarB.b());
                    iDataShare.onAction(aVarB.a(), aVarB.b(), aVarB.c());
                    aVarB = b(str);
                } catch (RemoteException e9) {
                    cn.jiguang.x.f.i("MessageQueueManager", "sendMessage RemoteException: " + e9.getMessage());
                    a(aVarB, str);
                    throw e9;
                }
            }
        }

        private void a(a aVar, String str) {
            try {
                LinkedBlockingQueue<a> linkedBlockingQueueA = a(str);
                if (linkedBlockingQueueA != null) {
                    LinkedBlockingQueue<a> linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
                    do {
                        linkedBlockingQueue.offer(aVar);
                        aVar = linkedBlockingQueueA.poll();
                    } while (aVar != null);
                    this.f10853a.put(str, linkedBlockingQueue);
                }
            } catch (Exception e9) {
                cn.jiguang.x.f.l("MessageQueueManager", "重新入队失败: " + e9.getMessage());
            }
        }

        public synchronized boolean a(Context context, String str, String str2, Bundle bundle, String str3) {
            try {
                cn.jiguang.x.f.c("MessageQueueManager", "开始添加消息到队列 - componentCls: " + str + ", action: " + str2 + ", toProcess: " + str3);
                if (!a(bundle, str3)) {
                    return false;
                }
                a aVar = new a(context, str, str2, cn.jiguang.aw.c.a(bundle), str3);
                LinkedBlockingQueue<a> linkedBlockingQueueA = a(str3);
                boolean zOffer = linkedBlockingQueueA.offer(aVar);
                if (!zOffer) {
                    cn.jiguang.x.f.i("MessageQueueManager", "消息添加到队列失败 - 队列可能已满:" + linkedBlockingQueueA.size());
                }
                return zOffer;
            } catch (Exception e9) {
                cn.jiguang.x.f.i("MessageQueueManager", "添加消息到队列失败: " + e9.getMessage());
                return false;
            }
        }

        public boolean a(Bundle bundle, String str) {
            if (bundle == null || str == null) {
                return false;
            }
            if (bundle.containsKey("jpush_JMessenger_message_id")) {
                return true;
            }
            cn.jiguang.x.f.i("MessageQueueManager", "消息缺少ID，不是要处理的信息，不添加到队列");
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile c f10859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicLong f10860b = new AtomicLong(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f10861c;

        private c(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("context cannot be null");
            }
            this.f10861c = b(context);
        }

        private long b(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.helper.jpush_messenger", 0);
            long j = sharedPreferences.getLong("run_id", 0L) + 1;
            long j8 = j <= 2147483647L ? j : 0L;
            sharedPreferences.edit().putLong("run_id", j8).commit();
            return j8;
        }

        public synchronized long a() {
            long jIncrementAndGet;
            jIncrementAndGet = this.f10860b.incrementAndGet();
            if (jIncrementAndGet >= 9223372036854774807L) {
                this.f10860b.set(100L);
                jIncrementAndGet = this.f10860b.incrementAndGet();
            }
            return jIncrementAndGet;
        }

        public Bundle a(Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putLong("jpush_JMessenger_message_id", a());
            bundle.putLong("jpush_JMessenger_run_id", this.f10861c);
            return bundle;
        }

        public static c a(Context context) {
            if (f10859a == null) {
                synchronized (c.class) {
                    try {
                        if (f10859a == null) {
                            f10859a = new c(context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f10859a;
        }
    }

    public static long a(Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("jpush_JMessenger_message_id", -1L);
    }

    public static long b(Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("jpush_JMessenger_run_id", -1L);
    }
}
