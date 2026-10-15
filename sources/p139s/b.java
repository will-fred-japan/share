package p139s;

import W5.f;
import android.os.Bundle;

/* JADX INFO: compiled from: TrustedWebActivityDisplayMode.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: TrustedWebActivityDisplayMode.java */
    public static class a implements b {
        @Override // p139s.b
        public final Bundle a() {
            return f.j(0, "androidx.browser.trusted.displaymode.KEY_ID");
        }
    }

    /* JADX INFO: renamed from: s.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TrustedWebActivityDisplayMode.java */
    public static class C0253b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21170b;

        public C0253b(boolean z8, int i9) {
            this.f21169a = z8;
            this.f21170b = i9;
        }

        @Override // p139s.b
        public final Bundle a() {
            Bundle bundleJ = f.j(1, "androidx.browser.trusted.displaymode.KEY_ID");
            bundleJ.putBoolean("androidx.browser.trusted.displaymode.KEY_STICKY", this.f21169a);
            bundleJ.putInt("androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE", this.f21170b);
            return bundleJ;
        }
    }

    Bundle a();
}
