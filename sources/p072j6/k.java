package p072j6;

import android.os.Bundle;
import com.jieli.jl_bt_ota.interfaces.bt.OnBleSendDataCallback;
import com.jieli.jl_bt_ota.model.ble.BleSendTask;
import com.jieli.jl_bt_ota.tool.ble.SendBleDataThread;
import p130r.l;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19905a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f19906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19908d;

    public /* synthetic */ k(OnBleSendDataCallback onBleSendDataCallback, BleSendTask bleSendTask, boolean z8) {
        this.f19907c = onBleSendDataCallback;
        this.f19908d = bleSendTask;
        this.f19906b = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19905a) {
            case 0:
                SendBleDataThread.a((OnBleSendDataCallback) this.f19907c, (BleSendTask) this.f19908d, this.f19906b);
                break;
            default:
                ((l) this.f19907c).onVerticalScrollEvent(this.f19906b, (Bundle) this.f19908d);
                break;
        }
    }

    public /* synthetic */ k(l lVar, boolean z8, Bundle bundle) {
        this.f19907c = lVar;
        this.f19906b = z8;
        this.f19908d = bundle;
    }
}
