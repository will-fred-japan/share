package V6;

import android.util.Log;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Map;
import p188x7.k;
import y7.t;
import y7.u;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements K7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4893a;

    @Override // K7.a
    public final Object invoke() {
        switch (this.f4893a) {
            case 0:
                return 33554432;
            case 1:
                W3.e.f5058c = false;
                Map<String, ? extends Object> map = W3.e.f5059d;
                Log.d("AdaptFloatWindow/Android", "float dismissed source=" + (map != null ? map.get("source") : null));
                W3.e.f5059d = null;
                if (map != null) {
                    Map mapD = u.D(new p188x7.e("type", "closed"), new p188x7.e(JThirdPlatFormInterface.KEY_EXTRA, map));
                    try {
                        m7.d.b.a aVar = W3.e.f5057b;
                        if (aVar != null) {
                            aVar.success(mapD);
                        }
                    } catch (Exception e9) {
                        Log.w("AdaptFloatWindow/Android", "emitEvent failed: " + e9.getMessage());
                    }
                    break;
                } else {
                    Map mapB = t.B(new p188x7.e("type", "closed"));
                    try {
                        m7.d.b.a aVar2 = W3.e.f5057b;
                        if (aVar2 != null) {
                            aVar2.success(mapB);
                        }
                    } catch (Exception e10) {
                        Log.w("AdaptFloatWindow/Android", "emitEvent failed: " + e10.getMessage());
                    }
                    break;
                }
                return k.f22364a;
            case 2:
                return new defpackage.e();
            default:
                return new p154t7.f();
        }
    }
}
