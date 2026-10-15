package N1;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: SlardarConfigFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3162a;

    public f(h hVar) {
        this.f3162a = hVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("PROCESS_NAME");
                Application application = p061i1.h.f19229a;
                String strA = A4.d.a();
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(strA) || stringExtra.equals(strA)) {
                    return;
                }
                this.f3162a.g();
            } catch (Exception unused) {
            }
        }
    }
}
