package com.jieli.jl_bt_ota.tool.callback;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCallbackHelper<T> {
    protected final ArrayList<T> callbacks = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f16235a = new Handler(Looper.getMainLooper());

    public static class CallbackRunnable<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<T> f16236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ICallbackHandler<T> f16237b;

        public CallbackRunnable(ArrayList<T> arrayList, ICallbackHandler<T> iCallbackHandler) {
            this.f16236a = arrayList;
            this.f16237b = iCallbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<T> arrayList = this.f16236a;
            if (arrayList == null || arrayList.isEmpty() || this.f16237b == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList(this.f16236a);
            int size = arrayList2.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList2.get(i9);
                i9++;
                this.f16237b.onHandle((T) obj);
            }
        }
    }

    public interface ICallbackHandler<T> {
        void onHandle(T t);
    }

    public boolean addCallback(T t) {
        if (t == null) {
            return false;
        }
        boolean zContains = this.callbacks.contains(t);
        return !zContains ? this.callbacks.add(t) : zContains;
    }

    public void callbackEvent(ICallbackHandler<T> iCallbackHandler) {
        if (iCallbackHandler == null) {
            return;
        }
        CallbackRunnable callbackRunnable = new CallbackRunnable(this.callbacks, iCallbackHandler);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            callbackRunnable.run();
        } else {
            this.f16235a.post(callbackRunnable);
        }
    }

    public void release() {
        this.callbacks.clear();
        this.f16235a.removeCallbacksAndMessages(null);
    }

    public boolean removeCallback(T t) {
        if (t == null || this.callbacks.isEmpty()) {
            return false;
        }
        return this.callbacks.remove(t);
    }
}
