package p095m6;

import android.bluetooth.BluetoothGatt;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.e f20443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f20444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f20445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f20446e;

    public /* synthetic */ h(g.e eVar, BluetoothGatt bluetoothGatt, int i9, int i10, int i11) {
        this.f20442a = i11;
        this.f20443b = eVar;
        this.f20444c = bluetoothGatt;
        this.f20445d = i9;
        this.f20446e = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20442a) {
            case 0:
                this.f20443b.onReadRemoteRssi(this.f20444c, this.f20445d, this.f20446e);
                break;
            default:
                this.f20443b.onMtuChanged(this.f20444c, this.f20445d, this.f20446e);
                break;
        }
    }
}
