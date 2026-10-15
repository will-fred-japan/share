package p137r6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: BluetoothReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntentFilter f21163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioManager f21164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<c> f21165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<AudioDeviceInfo> f21166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f21167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21168g;

    public b(Context context) {
        k.e(context, "context");
        this.f21162a = context;
        IntentFilter intentFilter = new IntentFilter();
        this.f21163b = intentFilter;
        Object systemService = context.getSystemService("audio");
        k.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f21164c = (AudioManager) systemService;
        this.f21165d = new HashSet<>();
        this.f21166e = new HashSet<>();
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        HashSet<c> hashSet = this.f21165d;
        if (intExtra == 0) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        } else {
            if (intExtra != 1) {
                return;
            }
            Iterator<c> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                it2.next().getClass();
            }
        }
    }
}
