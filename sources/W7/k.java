package W7;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface k<T> extends V7.d<T> {

    /* JADX INFO: compiled from: ChannelFlow.kt */
    public static final class a {
        public static /* synthetic */ V7.d a(k kVar, T7.d dVar, int i9, U7.a aVar, int i10) {
            B7.h hVar = dVar;
            if ((i10 & 1) != 0) {
                hVar = B7.i.f1761a;
            }
            if ((i10 & 2) != 0) {
                i9 = -3;
            }
            if ((i10 & 4) != 0) {
                aVar = U7.a.f4747a;
            }
            return kVar.b(hVar, i9, aVar);
        }
    }

    V7.d<T> b(B7.h hVar, int i9, U7.a aVar);
}
