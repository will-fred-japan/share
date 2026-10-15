package com.huawei.hmf.tasks.a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class i<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f14685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TResult f14686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f14687e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14683a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ExecuteResult<TResult>> f14688f = new ArrayList();

    public class a implements OnSuccessListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuccessContinuation f14689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f14690b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* JADX INFO: renamed from: com.huawei.hmf.tasks.a.i$a$a, reason: collision with other inner class name */
        public class C0164a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {
            public C0164a() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    a.this.f14690b.a(task.getResult());
                } else if (((i) task).f14685c) {
                    a.this.f14690b.a();
                } else {
                    a.this.f14690b.a(task.getException());
                }
            }
        }

        public a(i iVar, SuccessContinuation successContinuation, i iVar2) {
            this.f14689a = successContinuation;
            this.f14690b = iVar2;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            try {
                Task taskThen = this.f14689a.then(tresult);
                if (taskThen == null) {
                    this.f14690b.a((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    ((i) taskThen).addOnCompleteListener(TaskExecutors.uiThread(), new C0164a());
                }
            } catch (Exception e9) {
                this.f14690b.a(e9);
            }
        }
    }

    public class b implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f14692a;

        public b(i iVar, i iVar2) {
            this.f14692a = iVar2;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.f14692a.a(exc);
        }
    }

    public class c implements OnCanceledListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f14693a;

        public c(i iVar, i iVar2) {
            this.f14693a = iVar2;
        }

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public void onCanceled() {
            this.f14693a.a();
        }
    }

    public class d implements OnCompleteListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f14694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f14695b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        public class a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {
            public a() {
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> task) {
                if (task.isSuccessful()) {
                    d.this.f14695b.a(task.getResult());
                } else if (((i) task).f14685c) {
                    d.this.f14695b.a();
                } else {
                    d.this.f14695b.a(task.getException());
                }
            }
        }

        public d(i iVar, Continuation continuation, i iVar2) {
            this.f14694a = continuation;
            this.f14695b = iVar2;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> task) {
            try {
                Task task2 = (Task) this.f14694a.then(task);
                if (task2 == null) {
                    this.f14695b.a((Exception) new NullPointerException("Continuation returned null"));
                } else {
                    ((i) task2).addOnCompleteListener(TaskExecutors.uiThread(), new a());
                }
            } catch (Exception e9) {
                this.f14695b.a(e9);
            }
        }
    }

    public class e implements OnCompleteListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f14697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f14698b;

        public e(i iVar, i iVar2, Continuation continuation) {
            this.f14697a = iVar2;
            this.f14698b = continuation;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> task) {
            if (((i) task).f14685c) {
                this.f14697a.a();
                return;
            }
            try {
                this.f14697a.a(this.f14698b.then(task));
            } catch (Exception e9) {
                this.f14697a.a(e9);
            }
        }
    }

    public Task<TResult> a(ExecuteResult<TResult> executeResult) {
        boolean zIsComplete;
        synchronized (this.f14683a) {
            try {
                zIsComplete = isComplete();
                if (!zIsComplete) {
                    this.f14688f.add(executeResult);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        com.huawei.hmf.tasks.a.b bVar = new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), onCanceledListener);
        g.a(activity, bVar);
        return a((ExecuteResult) bVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        com.huawei.hmf.tasks.a.d dVar = new com.huawei.hmf.tasks.a.d(TaskExecutors.uiThread(), onCompleteListener);
        g.a(activity, dVar);
        return a((ExecuteResult) dVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        f fVar = new f(TaskExecutors.uiThread(), onFailureListener);
        g.a(activity, fVar);
        return a((ExecuteResult) fVar);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<TResult> onSuccessListener) {
        h hVar = new h(TaskExecutors.uiThread(), onSuccessListener);
        g.a(activity, hVar);
        return a((ExecuteResult) hVar);
    }

    public final void b() {
        synchronized (this.f14683a) {
            Iterator<ExecuteResult<TResult>> it = this.f14688f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e9) {
                    throw e9;
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
            this.f14688f = null;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        i iVar = new i();
        addOnCompleteListener(executor, new e(this, iVar, continuation));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        i iVar = new i();
        addOnCompleteListener(executor, new d(this, continuation, iVar));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        Exception exc;
        synchronized (this.f14683a) {
            exc = this.f14687e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.f14683a) {
            try {
                if (this.f14687e != null) {
                    throw new RuntimeException(this.f14687e);
                }
                tresult = this.f14686d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) {
        TResult tresult;
        synchronized (this.f14683a) {
            if (cls != null) {
                try {
                    if (cls.isInstance(this.f14687e)) {
                        throw cls.cast(this.f14687e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f14687e != null) {
                throw new RuntimeException(this.f14687e);
            }
            tresult = this.f14686d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return this.f14685c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        boolean z8;
        synchronized (this.f14683a) {
            z8 = this.f14684b;
        }
        return z8;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        boolean z8;
        synchronized (this.f14683a) {
            try {
                z8 = this.f14684b && !this.f14685c && this.f14687e == null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executorUiThread = TaskExecutors.uiThread();
        i iVar = new i();
        addOnSuccessListener(executorUiThread, new a(this, successContinuation, iVar));
        addOnFailureListener(new b(this, iVar));
        a((ExecuteResult) new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), new c(this, iVar)));
        return iVar;
    }

    public final void a(Exception exc) {
        synchronized (this.f14683a) {
            try {
                if (!this.f14684b) {
                    this.f14684b = true;
                    this.f14687e = exc;
                    this.f14683a.notifyAll();
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return a((ExecuteResult) new com.huawei.hmf.tasks.a.b(executor, onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return a((ExecuteResult) new f(executor, onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        Executor executorUiThread = TaskExecutors.uiThread();
        i iVar = new i();
        addOnCompleteListener(executorUiThread, new e(this, iVar, continuation));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Executor executorUiThread = TaskExecutors.uiThread();
        i iVar = new i();
        addOnCompleteListener(executorUiThread, new d(this, continuation, iVar));
        return iVar;
    }

    public final void a(TResult tresult) {
        synchronized (this.f14683a) {
            try {
                if (!this.f14684b) {
                    this.f14684b = true;
                    this.f14686d = tresult;
                    this.f14683a.notifyAll();
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return a((ExecuteResult) new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return a((ExecuteResult) new com.huawei.hmf.tasks.a.d(executor, onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return a((ExecuteResult) new f(TaskExecutors.uiThread(), onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return a((ExecuteResult) new h(executor, onSuccessListener));
    }

    public final boolean a() {
        synchronized (this.f14683a) {
            try {
                if (this.f14684b) {
                    return false;
                }
                this.f14684b = true;
                this.f14685c = true;
                this.f14683a.notifyAll();
                b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        i iVar = new i();
        addOnSuccessListener(executor, new a(this, successContinuation, iVar));
        addOnFailureListener(new b(this, iVar));
        a((ExecuteResult) new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), new c(this, iVar)));
        return iVar;
    }
}
