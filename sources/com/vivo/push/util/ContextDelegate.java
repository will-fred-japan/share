package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext = null;
    private static volatile Method mCreateCredentialProtectedStorageContext = null;
    private static volatile Method mCreateDeviceProtectedStorageContext = null;
    private static boolean mDelegateEnable = false;
    private static volatile Boolean mIsFbeProject;
    private static volatile Boolean mIsFdeProject;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ContextDelegate f16819a = new ContextDelegate();
    }

    private static synchronized Context createCredentialProtectedStorageContext(Context context) {
        try {
            try {
                if (mCreateCredentialProtectedStorageContext == null) {
                    mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                return context;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
    }

    private static synchronized Context createDeviceProtectedStorageContext(Context context) {
        try {
            try {
                if (mCreateDeviceProtectedStorageContext == null) {
                    mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
                }
            } catch (Exception e9) {
                e9.printStackTrace();
                return context;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
    }

    public static Context getContext(Context context) {
        if ((!isFBEProject() && !isFDEProject()) || context == null) {
            return context;
        }
        Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    public static ContextDelegate getInstance() {
        return a.f16819a;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[Catch: all -> 0x0037, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0051, B:17:0x0057, B:12:0x003a), top: B:24:0x0003, inners: #0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x0055, please report this as an issue */
    public static synchronized boolean isFBEProject() {
        if (mIsFbeProject != null) {
            if (mIsFbeProject == null) {
                return false;
            }
            return mIsFbeProject.booleanValue();
        }
        try {
            mIsFbeProject = Boolean.valueOf("file".equals(o.a("ro.crypto.type", "unknow")));
            w.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
        } catch (Exception e9) {
            w.a(TAG, "mIsFbeProject = " + e9.getMessage());
        }
        if (mIsFbeProject == null) {
            return false;
        }
        return mIsFbeProject.booleanValue();
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[Catch: all -> 0x0037, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0051, B:17:0x0057, B:12:0x003a), top: B:24:0x0003, inners: #0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x0055, please report this as an issue */
    private static synchronized boolean isFDEProject() {
        if (mIsFdeProject != null) {
            if (mIsFdeProject == null) {
                return false;
            }
            return mIsFdeProject.booleanValue();
        }
        try {
            mIsFdeProject = Boolean.valueOf("block".equals(o.a("ro.crypto.type", "unknow")));
            w.b(TAG, "mIsFdeProject = " + mIsFdeProject.toString());
        } catch (Exception e9) {
            w.a(TAG, "mIsFdeProject = " + e9.getMessage());
        }
        if (mIsFdeProject == null) {
            return false;
        }
        return mIsFdeProject.booleanValue();
        throw th;
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        if (mDelegateEnable) {
            mContext = createDeviceProtectedStorageContext(context);
        } else {
            mContext = createCredentialProtectedStorageContext(context);
        }
    }

    public static void setEnable(boolean z8) {
        mDelegateEnable = z8;
        setAppContext();
    }
}
