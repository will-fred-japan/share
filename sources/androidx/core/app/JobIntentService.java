package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7054b;

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0033  */
        /* JADX WARN: Code duplicated, block: B:20:0x0048 A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, blocks: (B:18:0x0042, B:20:0x0048, B:23:0x0050), top: B:32:0x0042 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x0054 A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        public final Void doInBackground(Void[] voidArr) {
            b.a aVar;
            JobParameters jobParameters;
            while (true) {
                JobIntentService jobIntentService = JobIntentService.this;
                jobIntentService.f7053a.getClass();
                b bVar = jobIntentService.f7053a;
                synchronized (bVar.f7057b) {
                    try {
                        JobParameters jobParameters2 = bVar.f7058c;
                        if (jobParameters2 != null) {
                            JobWorkItem jobWorkItemDequeueWork = jobParameters2.dequeueWork();
                            if (jobWorkItemDequeueWork != null) {
                                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(bVar.f7056a.getClassLoader());
                                aVar = bVar.new a(jobWorkItemDequeueWork);
                            }
                            if (aVar != null) {
                                return null;
                            }
                            JobIntentService jobIntentService2 = JobIntentService.this;
                            aVar.f7059a.getIntent();
                            jobIntentService2.a();
                            synchronized (b.this.f7057b) {
                                try {
                                    jobParameters = b.this.f7058c;
                                    if (jobParameters != null) {
                                        jobParameters.completeWork(aVar.f7059a);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                aVar = null;
                if (aVar != null) {
                    return null;
                }
                JobIntentService jobIntentService3 = JobIntentService.this;
                aVar.f7059a.getIntent();
                jobIntentService3.a();
                synchronized (b.this.f7057b) {
                    jobParameters = b.this.f7058c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(aVar.f7059a);
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        public final void onCancelled(Void r8) {
            JobIntentService.this.getClass();
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Void r8) {
            JobIntentService.this.getClass();
        }
    }

    public static final class b extends JobServiceEngine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JobIntentService f7056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f7057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JobParameters f7058c;

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final JobWorkItem f7059a;

            public a(JobWorkItem jobWorkItem) {
                this.f7059a = jobWorkItem;
            }
        }

        public b(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f7057b = new Object();
            this.f7056a = jobIntentService;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.f7058c = jobParameters;
            JobIntentService jobIntentService = this.f7056a;
            if (jobIntentService.f7054b != null) {
                return true;
            }
            a aVar = jobIntentService.new a();
            jobIntentService.f7054b = aVar;
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            a aVar = this.f7056a.f7054b;
            if (aVar != null) {
                aVar.cancel(false);
            }
            synchronized (this.f7057b) {
                this.f7058c = null;
            }
            return true;
        }
    }

    static {
        new HashMap();
    }

    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        b bVar = this.f7053a;
        if (bVar != null) {
            return bVar.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f7053a = new b(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        return 2;
    }
}
