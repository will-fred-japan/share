package U5;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class B implements BaseCallbackHelper.ICallbackHandler, h6.g.a, w7.e.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4669b;

    public /* synthetic */ B(Object obj, Object obj2) {
        this.f4668a = obj;
        this.f4669b = obj2;
    }

    @Override // w7.e.n
    public void a(boolean z8) {
        w7.e.o oVar = (w7.e.o) this.f4668a;
        p179w7.e eVar = p179w7.e.this;
        p096m7.k kVar = (p096m7.k) this.f4669b;
        if (z8) {
            eVar.f22199z.submit(new p179w7.k(oVar, kVar, 0));
            return;
        }
        kVar.error("no_permissions", "querying Bluetooth audio devices requires " + p179w7.e.b(eVar) + " access permission", null);
    }

    public Object b(L5.i.a aVar) {
        return ((C) this.f4668a).a(aVar.a(), ((D) this.f4669b).b());
    }

    @Override // com.jieli.jl_bt_ota.tool.callback.BaseCallbackHelper.ICallbackHandler
    public void onHandle(Object obj) {
        ((OnBtAssistantCallback) obj).onDiscovery((BluetoothDevice) this.f4668a, (BleScanMessage) this.f4669b);
    }
}
