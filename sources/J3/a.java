package J3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p099n1.d;
import p133r2.b;

/* JADX INFO: compiled from: NetworkBroadcastReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: J3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NetworkBroadcastReceiver.java */
    public class RunnableC0024a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f2686a;

        public RunnableC0024a(Context context) {
            this.f2686a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.a(this.f2686a)) {
                E3.a.b().a();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b.f21107i.a(new RunnableC0024a(context));
    }
}
