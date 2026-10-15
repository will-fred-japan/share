package H5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AbsoluteCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2415a;

    public a(float f6) {
        this.f2415a = f6;
    }

    @Override // H5.d
    public final float a(RectF rectF) {
        return this.f2415a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f2415a == ((a) obj).f2415a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2415a)});
    }
}
