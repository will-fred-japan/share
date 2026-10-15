package p152t4;

import java.io.File;
import java.util.Date;
import p056h5.C0598e;
import p144s4.d;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f21450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21452c;

    public o(long j, String str, String str2) {
        this.f21450a = j;
        this.f21451b = str;
        this.f21452c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            File fileE = n.e();
            if (fileE != null) {
                d.h(fileE, n.f21446b + " activityLifeCycle " + C0598e.h().format(new Date(this.f21450a)) + " : " + this.f21451b + ' ' + this.f21452c + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }
}
