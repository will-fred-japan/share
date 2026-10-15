package H5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends o.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f2494d;

    public n(ArrayList arrayList, Matrix matrix) {
        this.f2493c = arrayList;
        this.f2494d = matrix;
    }

    @Override // H5.o.f
    public final void a(Matrix matrix, G5.a aVar, int i9, Canvas canvas) {
        Iterator it = this.f2493c.iterator();
        while (it.hasNext()) {
            ((o.f) it.next()).a(this.f2494d, aVar, i9, canvas);
        }
    }
}
