package T;

import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: renamed from: T.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DisplayCutoutCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0419f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f4426a;

    /* JADX INFO: renamed from: T.f$a */
    /* JADX INFO: compiled from: DisplayCutoutCompat.java */
    public static class a {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C0419f(DisplayCutout displayCutout) {
        this.f4426a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0419f.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f4426a, ((C0419f) obj).f4426a);
    }

    public final int hashCode() {
        return this.f4426a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f4426a + "}";
    }
}
