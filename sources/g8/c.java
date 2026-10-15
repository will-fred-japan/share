package g8;

import cn.jpush.android.api.InAppSlotParams;
import java.util.HashMap;
import y7.u;

/* JADX INFO: compiled from: AudioplayersPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements m7.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.d f18987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.d.b.a f18988b;

    public c(p096m7.d dVar) {
        this.f18987a = dVar;
        dVar.a(this);
    }

    @Override // m7.d.c
    public final void a(Object obj, m7.d.b.a aVar) {
        this.f18988b = aVar;
    }

    @Override // m7.d.c
    public final void b() {
        this.f18988b = null;
    }

    public final void c(String str, HashMap map) {
        m7.d.b.a aVar = this.f18988b;
        if (aVar != null) {
            aVar.success(u.F(map, new p188x7.e(InAppSlotParams.SLOT_KEY.EVENT, str)));
        }
    }
}
