package p159u4;

import com.apm.insight.f;
import java.util.LinkedList;
import p152t4.l;
import p152t4.o;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f21680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f21681d;

    public b(long j, String str, String str2, d dVar) {
        this.f21681d = dVar;
        this.f21678a = str;
        this.f21679b = str2;
        this.f21680c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a aVar;
        String str = this.f21678a;
        String str2 = this.f21679b;
        long j = this.f21680c;
        try {
            d dVar = this.f21681d;
            LinkedList<d.a> linkedList = dVar.f21693e;
            if (linkedList.size() >= dVar.f21705r) {
                aVar = linkedList.poll();
                if (aVar != null) {
                    linkedList.add(aVar);
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new d.a();
                aVar.f21708b = str2;
                aVar.f21709c = j;
                aVar.f21707a = str;
                linkedList.add(aVar);
            }
            aVar.f21708b = str2;
            aVar.f21707a = str;
            aVar.f21709c = j;
        } catch (Throwable unused) {
        }
        int i9 = f.f11868q;
        if (i9 <= 0 || i9 == 0) {
            return;
        }
        l.a().a(new o(j, str, str2));
    }
}
