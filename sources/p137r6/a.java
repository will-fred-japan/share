package p137r6;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import y7.f;
import y7.n;

/* JADX INFO: compiled from: BluetoothReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f21161a;

    public a(b bVar) {
        this.f21161a = bVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
        k.e(addedDevices, "addedDevices");
        b bVar = this.f21161a;
        HashSet<AudioDeviceInfo> hashSet = bVar.f21166e;
        List listA = f.a(addedDevices);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo.isSource() && audioDeviceInfo.getType() != 18 && audioDeviceInfo.getType() != 25 && audioDeviceInfo.getType() != 28) {
                arrayList.add(obj);
            }
        }
        hashSet.addAll(arrayList);
        HashSet<AudioDeviceInfo> hashSet2 = bVar.f21166e;
        if (hashSet2 == null || !hashSet2.isEmpty()) {
            Iterator<T> it = hashSet2.iterator();
            while (it.hasNext()) {
                if (((AudioDeviceInfo) it.next()).getType() == 7) {
                    AudioManager audioManager = bVar.f21164c;
                    if (audioManager.isBluetoothScoAvailableOffCall() && !audioManager.isBluetoothScoOn()) {
                        audioManager.startBluetoothSco();
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
        k.e(removedDevices, "removedDevices");
        b bVar = this.f21161a;
        HashSet<AudioDeviceInfo> hashSet = bVar.f21166e;
        List listA = f.a(removedDevices);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo.isSource() && audioDeviceInfo.getType() != 18 && audioDeviceInfo.getType() != 25 && audioDeviceInfo.getType() != 28) {
                arrayList.add(obj);
            }
        }
        hashSet.removeAll(n.U(arrayList));
        HashSet<AudioDeviceInfo> hashSet2 = bVar.f21166e;
        if (hashSet2 == null || !hashSet2.isEmpty()) {
            Iterator<AudioDeviceInfo> it = hashSet2.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 7) {
                    return;
                }
            }
        }
        AudioManager audioManager = bVar.f21164c;
        if (audioManager.isBluetoothScoOn()) {
            audioManager.stopBluetoothSco();
        }
    }
}
