package p134r3;

import com.apm.insight.CrashType;
import com.apm.insight.IOOMCallback;
import p126q3.b;
import p126q3.c;

/* JADX INFO: compiled from: MemoryWidgetOomCallBack.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements IOOMCallback {
    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(CrashType crashType, Throwable th, Thread thread, long j) {
        try {
            if (b.a().b()) {
                return;
            }
            c.e().a(j);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
