package I6;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: AndroidAudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f2579a;

    public c(f.a aVar) {
        this.f2579a = aVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        ArrayList arrayList = new ArrayList();
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            arrayList.add(f.b(audioDeviceInfo));
        }
        this.f2579a.e("onAudioDevicesAdded", arrayList);
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        ArrayList arrayList = new ArrayList();
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            arrayList.add(f.b(audioDeviceInfo));
        }
        this.f2579a.e("onAudioDevicesRemoved", arrayList);
    }
}
