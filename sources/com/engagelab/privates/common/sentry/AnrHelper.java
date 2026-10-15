package com.engagelab.privates.common.sentry;

import android.content.Context;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.sentry.entity.ApplicationNotResponding;
import com.engagelab.privates.common.sentry.entity.Mechanism;

/* JADX INFO: loaded from: classes.dex */
public class AnrHelper {
    private static final String TAG = "AnrHelper";
    private static ANRWatchDog anrWatchDog;
    private static final Object watchDogLock = new Object();

    public static class a implements ANRWatchDog.ANRListener {
        @Override // com.engagelab.privates.common.sentry.ANRWatchDog.ANRListener
        public void onAppNotResponding(ApplicationNotResponding applicationNotResponding) {
            AnrHelper.reportANR(applicationNotResponding);
        }
    }

    private AnrHelper() {
    }

    public static void close() {
        synchronized (watchDogLock) {
            try {
                ANRWatchDog aNRWatchDog = anrWatchDog;
                if (aNRWatchDog != null) {
                    aNRWatchDog.interrupt();
                    anrWatchDog = null;
                    MTCommonLog.d(TAG, "AnrHelper removed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportANR(ApplicationNotResponding applicationNotResponding) {
        Mechanism mechanism = new Mechanism();
        mechanism.setType("ANR");
        SentryCrashHandler.getInstance().handleException(new ExceptionMechanismException(mechanism, applicationNotResponding, applicationNotResponding.getThread(), true));
    }

    public static void startWatchAnr(Context context) {
        synchronized (watchDogLock) {
            try {
                ANRWatchDog aNRWatchDog = anrWatchDog;
                if (aNRWatchDog != null) {
                    aNRWatchDog.interrupt();
                    anrWatchDog = null;
                    MTCommonLog.d(TAG, "AnrHelper restarting, old watchdog interrupted.");
                }
                ANRWatchDog aNRWatchDog2 = new ANRWatchDog(10000L, false, new a(), context);
                anrWatchDog = aNRWatchDog2;
                aNRWatchDog2.start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
