package W3;

import K7.q;
import android.util.Log;
import p188x7.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements q {
    @Override // K7.q
    public final Object b(Object obj, Object obj2, Object obj3) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        e.f5058c = zBooleanValue;
        if (zBooleanValue) {
            Log.d("AdaptFloatWindow/Android", "float shown");
        } else {
            Log.w("AdaptFloatWindow/Android", "float create failed");
        }
        return k.f22364a;
    }
}
