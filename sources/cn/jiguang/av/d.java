package cn.jiguang.av;

import cn.jiguang.w.h;
import cn.jiguang.w.i;
import cn.jiguang.x.f;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, ExecutorService> f9470a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f9471b;

    static {
        HashMap<String, String> map = new HashMap<>();
        f9471b = map;
        map.put("SDK_INIT", "ic");
        map.put("SDK_SERVICE_INIT", "mn");
        map.put("TCP_CONN_TASK", "tc");
        map.put("TCP_REPORT_TASK", "tr");
        map.put("UPLOAD_REPORT", "rp");
        map.put("ONCE_TASK", "oc");
        map.put("GET_ON_EVENT_TASK", "gt");
        map.put("SCHEDULE_TASK", "sc");
        map.put("MAJOR_TASK", "mj");
        map.put("NORMAL_TASK", MTCommonConstants.Network.RADIO_5G);
        map.put("FUTURE_TASK", "fr");
        map.put("DELAY_TASK", "dl");
        map.put("AIDL_TASK", "al");
        map.put("DYNAMIC_LOAD_TASK", "dlo");
        map.put("IPC_ACTION_TASK", "ca");
        map.put("MAIN_IPC_ACTION_TASK", "m_ca");
    }

    public static void a(String str) {
        try {
            a(c(str));
        } catch (Throwable th) {
            f.l("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static boolean b(String str) {
        try {
            ExecutorService executorServiceC = c(str);
            return (executorServiceC == null || executorServiceC.isShutdown() || executorServiceC.isTerminated()) ? false : true;
        } catch (Throwable th) {
            f.l("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00f8  */
    private static ExecutorService c(String str) {
        ExecutorService executorServiceNewScheduledThreadPool;
        ThreadPoolExecutor threadPoolExecutor;
        HashMap<String, String> map = f9471b;
        String str2 = str;
        if (map.get(str2) == null) {
            str2 = "NORMAL_TASK";
        }
        String str3 = map.get(str2);
        HashMap<String, ExecutorService> map2 = f9470a;
        ExecutorService executorService = map2.get(str2);
        if (executorService != null && !executorService.isShutdown()) {
            return executorService;
        }
        synchronized (d.class) {
            try {
                executorServiceNewScheduledThreadPool = map2.get(str2);
                if (executorServiceNewScheduledThreadPool == null || executorServiceNewScheduledThreadPool.isShutdown()) {
                    int i9 = 3;
                    switch (str2) {
                        case "SDK_INIT":
                        case "SDK_SERVICE_INIT":
                        case "TCP_CONN_TASK":
                        case "MAJOR_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new c(str3));
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "AIDL_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new c(str3));
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "DYNAMIC_LOAD_TASK":
                        case "IPC_ACTION_TASK":
                        case "MAIN_IPC_ACTION_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(str3));
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "UPLOAD_REPORT":
                        case "SCHEDULE_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(str3));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "ONCE_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(str3));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "TCP_REPORT_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(2, 2, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(str3));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "GET_ON_EVENT_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new c(str3));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "FUTURE_TASK":
                            threadPoolExecutor = new ThreadPoolExecutor(3, 3, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(5), new c(str3));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                        case "DELAY_TASK":
                            executorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new c(str3));
                            i9 = 1;
                            break;
                        case "NORMAL_TASK":
                        default:
                            threadPoolExecutor = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(2), new c(str3));
                            i9 = 1;
                            executorServiceNewScheduledThreadPool = threadPoolExecutor;
                            break;
                    }
                    ((ThreadPoolExecutor) executorServiceNewScheduledThreadPool).setRejectedExecutionHandler(new a(str3, i9));
                    map2.put(str2, executorServiceNewScheduledThreadPool);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceNewScheduledThreadPool;
    }

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 0L, true);
    }

    public static void a(String str, Runnable runnable, long j) {
        a(str, runnable, j, true);
    }

    public static void a(String str, final Runnable runnable, long j, final boolean z8) {
        try {
            Runnable runnable2 = new Runnable() { // from class: cn.jiguang.av.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!z8 || (!h.b() && !i.a())) {
                            runnable.run();
                        }
                    } catch (Throwable th) {
                        W5.f.m("execute run failed, e:", "SDKWorker_XExecutor", th);
                    }
                }
            };
            ExecutorService executorServiceC = c(str);
            if (executorServiceC != null) {
                if (j <= 0 || !(executorServiceC instanceof ScheduledExecutorService)) {
                    executorServiceC.execute(runnable2);
                } else {
                    ((ScheduledExecutorService) executorServiceC).schedule(runnable2, j, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Throwable th) {
            W5.f.m("execute failed, try again e:", "SDKWorker_XExecutor", th);
        }
    }

    public static void a(String str, Runnable runnable, boolean z8) {
        a(str, runnable, 0L, z8);
    }

    private static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            f.a("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            f.a("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            defpackage.f.l("shutDown e:", "SDKWorker_XExecutor", th);
        }
    }
}
