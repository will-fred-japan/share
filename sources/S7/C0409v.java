package S7;

import android.util.Log;
import android.view.View;
import java.util.Map;

/* JADX INFO: renamed from: S7.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0409v implements K7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4305a;

    public /* synthetic */ C0409v(int i9) {
        this.f4305a = i9;
    }

    @Override // K7.l
    public final Object invoke(Object obj) {
        switch (this.f4305a) {
            case 0:
                B7.h.a aVar = (B7.h.a) obj;
                if (aVar instanceof AbstractC0410w) {
                    return (AbstractC0410w) aVar;
                }
                return null;
            default:
                View view = (View) obj;
                kotlin.jvm.internal.k.e(view, "view");
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                Log.d("AdaptFloatWindow/Android", "dragEnd x=" + iArr[0] + " y=" + iArr[1]);
                Map mapD = y7.u.D(new p188x7.e("type", "dragEnd"), new p188x7.e("x", Double.valueOf((double) iArr[0])), new p188x7.e("y", Double.valueOf((double) iArr[1])));
                try {
                    m7.d.b.a aVar2 = W3.e.f5057b;
                    if (aVar2 != null) {
                        aVar2.success(mapD);
                    }
                    break;
                } catch (Exception e9) {
                    Log.w("AdaptFloatWindow/Android", "emitEvent failed: " + e9.getMessage());
                }
                return p188x7.k.f22364a;
        }
    }
}
