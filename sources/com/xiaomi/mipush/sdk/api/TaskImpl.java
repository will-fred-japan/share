package com.xiaomi.mipush.sdk.api;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class TaskImpl<TResult> implements Task<TResult> {
    Handler handler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean isComplete = new AtomicBoolean(false);
    private final AtomicReference<TResult> result = new AtomicReference<>();
    private final AtomicReference<Exception> exception = new AtomicReference<>();
    private final CopyOnWriteArraySet<OnCompleteListener<? super TResult>> completeListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<OnSuccessListener<? super TResult>> successListeners = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<OnFailureListener> failureListeners = new CopyOnWriteArraySet<>();

    @Override // com.xiaomi.mipush.sdk.api.Task
    public Task<TResult> addOnCompleteListener(final OnCompleteListener<TResult> onCompleteListener) {
        if (onCompleteListener != null) {
            this.completeListeners.add(onCompleteListener);
        }
        if (this.isComplete.get()) {
            this.handler.post(new Runnable() { // from class: com.xiaomi.mipush.sdk.api.TaskImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    onCompleteListener.callComplete(TaskImpl.this);
                }
            });
        }
        return this;
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public Task<TResult> addOnFailureListener(final OnFailureListener onFailureListener) {
        if (onFailureListener != null) {
            this.failureListeners.add(onFailureListener);
        }
        if (this.isComplete.get() && !isSuccessful()) {
            this.handler.post(new Runnable() { // from class: com.xiaomi.mipush.sdk.api.TaskImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    onFailureListener.callFailure((Exception) TaskImpl.this.exception.get());
                }
            });
        }
        return this;
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public Task<TResult> addOnSuccessListener(final OnSuccessListener<? super TResult> onSuccessListener) {
        if (onSuccessListener != null) {
            this.successListeners.add(onSuccessListener);
        }
        if (this.isComplete.get() && isSuccessful()) {
            this.handler.post(new Runnable() { // from class: com.xiaomi.mipush.sdk.api.TaskImpl.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    onSuccessListener.callSuccess(TaskImpl.this.result.get());
                }
            });
        }
        return this;
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public Exception getException() {
        return this.exception.get();
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public TResult getResult() {
        return this.result.get();
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public boolean isComplete() {
        return this.isComplete.get();
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public boolean isSuccessful() {
        return this.isComplete.get() && this.exception.get() == null;
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public void setException(final Exception exc) {
        this.exception.set(exc);
        this.isComplete.set(true);
        this.handler.post(new Runnable() { // from class: com.xiaomi.mipush.sdk.api.TaskImpl.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = TaskImpl.this.completeListeners.iterator();
                while (it.hasNext()) {
                    ((OnCompleteListener) it.next()).callComplete(TaskImpl.this);
                }
                Iterator it2 = TaskImpl.this.failureListeners.iterator();
                while (it2.hasNext()) {
                    ((OnFailureListener) it2.next()).callFailure(exc);
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.api.Task
    public void setResult(final TResult tresult) {
        this.result.set(tresult);
        this.isComplete.set(true);
        this.handler.post(new Runnable() { // from class: com.xiaomi.mipush.sdk.api.TaskImpl.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = TaskImpl.this.completeListeners.iterator();
                while (it.hasNext()) {
                    ((OnCompleteListener) it.next()).callComplete(TaskImpl.this);
                }
                Iterator it2 = TaskImpl.this.successListeners.iterator();
                while (it2.hasNext()) {
                    ((OnSuccessListener) it2.next()).callSuccess(tresult);
                }
            }
        });
    }
}
