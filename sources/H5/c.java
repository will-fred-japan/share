package H5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: ClampedCornerSize.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2418a;

    public c(float f6) {
        this.f2418a = f6;
    }

    @Override // H5.d
    public final float a(RectF rectF) {
        return Math.min(this.f2418a, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f2418a == ((c) obj).f2418a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f2418a)});
    }
}
