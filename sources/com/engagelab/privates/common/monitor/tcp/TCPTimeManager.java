package com.engagelab.privates.common.monitor.tcp;

import android.content.Context;
import android.os.SystemClock;
import com.engagelab.privates.common.cache.MTRemoteConfig;
import com.engagelab.privates.common.monitor.SdkMonitorReporter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TCPTimeManager {
    public static final int TYPE_CONNECT = 4;
    public static final int TYPE_DNS = 2;
    public static final int TYPE_GLOBAL_SIS = 1;
    public static final int TYPE_LOGIN = 6;
    public static final int TYPE_REGISTER = 5;
    public static final int TYPE_SIS = 3;
    private static final ConcurrentHashMap<Long, Long> startTimeMap = new ConcurrentHashMap<>();
    private static final AtomicLong idCounter = new AtomicLong(0);
    private static final Object initLock = new Object();
    private static volatile long initStartTime = 0;
    private static volatile long initNetworkTime = 0;
    private static volatile boolean initStarted = false;
    private static volatile boolean initCompleted = false;

    private static void addNetworkTimeToInit(long j) {
        synchronized (initLock) {
            try {
                if (initStarted && !initCompleted) {
                    initNetworkTime += j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void checkAndReport(Context context) {
        if (isReportEnabled(context) && TCPTimingCache.isReportIntervalElapsed(context)) {
            JSONObject jSONObjectBuildReportJson = TCPTimingCache.buildReportJson(context);
            if (jSONObjectBuildReportJson != null) {
                SdkMonitorReporter.reportTcpTiming(context, jSONObjectBuildReportJson);
            }
            TCPTimingCache.clearReportedData(context);
            TCPTimingCache.setLastReportTime(context, System.currentTimeMillis());
        }
    }

    public static void clearCache(Context context) {
        TCPTimingCache.clearAll(context);
    }

    private static long consumeTime(long j) {
        Long lRemove;
        if (j >= 0 && (lRemove = startTimeMap.remove(Long.valueOf(j))) != null) {
            return SystemClock.elapsedRealtime() - lRemove.longValue();
        }
        return -1L;
    }

    public static void endFail(Context context, int i9, long j, int i10) {
        String strPrefixOf;
        long jConsumeTime = consumeTime(j);
        if (jConsumeTime >= 0 && (strPrefixOf = prefixOf(i9)) != null) {
            TCPTimingCache.recordFailure(context, strPrefixOf, jConsumeTime, i10);
            addNetworkTimeToInit(jConsumeTime);
        }
    }

    public static void endInitFail(Context context, int i9) {
        synchronized (initLock) {
            try {
                if (initStarted && !initCompleted) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - initStartTime;
                    TCPTimingCache.recordInitFailure(context, jElapsedRealtime, Math.max(0L, jElapsedRealtime - initNetworkTime), i9);
                    initStarted = false;
                    initCompleted = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void endInitSucc(Context context) {
        synchronized (initLock) {
            try {
                if (initStarted && !initCompleted) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - initStartTime;
                    TCPTimingCache.recordInitSuccess(context, jElapsedRealtime, Math.max(0L, jElapsedRealtime - initNetworkTime));
                    initStarted = false;
                    initCompleted = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void endSucc(Context context, int i9, long j) {
        String strPrefixOf;
        long jConsumeTime = consumeTime(j);
        if (jConsumeTime >= 0 && (strPrefixOf = prefixOf(i9)) != null) {
            TCPTimingCache.recordSuccess(context, strPrefixOf, jConsumeTime);
            addNetworkTimeToInit(jConsumeTime);
        }
    }

    private static boolean isCollectEnabled(Context context) {
        return MTRemoteConfig.isInitTimeMonitorEnable(context) != MTRemoteConfig.InitTimeMonitorState.DISABLED;
    }

    private static boolean isReportEnabled(Context context) {
        return MTRemoteConfig.isInitTimeMonitorEnable(context) == MTRemoteConfig.InitTimeMonitorState.ENABLED;
    }

    private static String prefixOf(int i9) {
        switch (i9) {
            case 1:
                return TCPTimingCache.P_GLOBAL_SIS;
            case 2:
                return TCPTimingCache.P_DNS;
            case 3:
                return TCPTimingCache.P_SIS;
            case 4:
                return TCPTimingCache.P_CONNECT;
            case 5:
                return "register";
            case 6:
                return TCPTimingCache.P_LOGIN;
            default:
                return null;
        }
    }

    public static long start(Context context, int i9) {
        if (!isCollectEnabled(context)) {
            return -1L;
        }
        long jIncrementAndGet = idCounter.incrementAndGet();
        startTimeMap.put(Long.valueOf(jIncrementAndGet), Long.valueOf(SystemClock.elapsedRealtime()));
        return jIncrementAndGet;
    }

    public static void startInit(Context context) {
        if (isCollectEnabled(context)) {
            synchronized (initLock) {
                try {
                    if (!initCompleted && !initStarted) {
                        initStartTime = SystemClock.elapsedRealtime();
                        initNetworkTime = 0L;
                        initStarted = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
