package androidx.core.content;

import H.c;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7069a = new a();

    public class a extends c.a {
        public a() {
            attachInterface(this, c.f2343k);
        }
    }

    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f7069a;
    }
}
