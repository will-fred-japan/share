package I6;

import android.media.AudioManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import p142s2.j;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2578b;

    public /* synthetic */ b(int i9, Object obj) {
        this.f2577a = i9;
        this.f2578b = obj;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i9) {
        p178w6.d dVar;
        switch (this.f2577a) {
            case 0:
                f.a aVar = (f.a) this.f2578b;
                if (i9 == -1) {
                    aVar.a();
                }
                aVar.e("onAudioFocusChanged", Integer.valueOf(i9));
                break;
            default:
                boolean zContains = j.x(-1, -2, -3).contains(Integer.valueOf(i9));
                p178w6.a aVar2 = (p178w6.a) this.f2578b;
                if (zContains) {
                    p178w6.d dVar2 = aVar2.f22122d;
                    if (dVar2 != null && dVar2.a()) {
                        dVar2.f22140c.set(true);
                        dVar2.f22141d.set(true);
                        break;
                    }
                } else if (i9 == 1) {
                    q6.e eVar = aVar2.f22124f;
                    k.b(eVar);
                    if (eVar.f21023q == q6.c.f21000c && (dVar = aVar2.f22122d) != null && dVar.f22144g != null) {
                        AtomicBoolean atomicBoolean = dVar.f22141d;
                        if (atomicBoolean.get()) {
                            dVar.f22140c.set(true);
                            atomicBoolean.set(false);
                            dVar.f22142e.release();
                            dVar.f22139b.f22119a.c(q6.f.RECORD);
                        }
                        break;
                    }
                }
                break;
        }
    }
}
