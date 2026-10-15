package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    private static final String TAG = "FailedBinderCallBack";
    private static FailedBinderCallBack instance;
    private static Map<Long, BinderCallBack> binderCallBackMap = new ConcurrentHashMap();
    private static final Object LOCK_OBJECT = new Object();

    public interface BinderCallBack {
        void binderCallBack(int i9);
    }

    private FailedBinderCallBack() {
    }

    private void agingCheck() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
        for (Long l8 : binderCallBackMap.keySet()) {
            if (time >= l8.longValue()) {
                binderCallBackMap.remove(l8);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        synchronized (LOCK_OBJECT) {
            try {
                if (instance == null) {
                    instance = new FailedBinderCallBack();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return instance;
    }

    private void putCallBackInMap(Long l8, BinderCallBack binderCallBack) {
        if (binderCallBackMap == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
        } else {
            agingCheck();
            binderCallBackMap.put(l8, binderCallBack);
        }
    }

    public BinderCallBack getCallBack(Long l8) {
        Map<Long, BinderCallBack> map = binderCallBackMap;
        if (map != null) {
            return map.remove(l8);
        }
        HMSLog.e(TAG, "binderCallBackMap is null");
        return null;
    }

    public void setCallBack(Long l8, BinderCallBack binderCallBack) {
        putCallBackInMap(l8, binderCallBack);
    }
}
