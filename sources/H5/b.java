package H5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2417b;

    public b(float f6, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f2416a;
            f6 += ((b) dVar).f2417b;
        }
        this.f2416a = dVar;
        this.f2417b = f6;
    }

    @Override // H5.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f2416a.a(rectF) + this.f2417b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2416a.equals(bVar.f2416a) && this.f2417b == bVar.f2417b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2416a, Float.valueOf(this.f2417b)});
    }
}
