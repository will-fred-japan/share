package H5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2458a;

    public j(float f6) {
        this.f2458a = f6;
    }

    @Override // H5.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f2458a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f2458a == ((j) obj).f2458a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2458a)});
    }
}
