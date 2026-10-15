package I6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: AndroidAudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f2580a;

    public d(f.a aVar) {
        this.f2580a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f2580a.e("onBecomingNoisy", new Object[0]);
        }
    }
}
