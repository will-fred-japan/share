package I6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: AndroidAudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f2581a;

    public e(f.a aVar) {
        this.f2581a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f2581a.e("onScoAudioStateUpdated", Integer.valueOf(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1)), Integer.valueOf(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1)));
    }
}
