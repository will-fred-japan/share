package T;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: renamed from: T.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ScrollFeedbackProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0436x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4458a;

    /* JADX INFO: renamed from: T.x$a */
    /* JADX INFO: compiled from: ScrollFeedbackProviderCompat.java */
    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f4459a;

        public a(NestedScrollView nestedScrollView) {
            this.f4459a = ScrollFeedbackProvider.createProvider(nestedScrollView);
        }

        @Override // T.C0436x.c
        public final void a(int i9, int i10, int i11, boolean z8) {
            this.f4459a.onScrollLimit(i9, i10, i11, z8);
        }

        @Override // T.C0436x.c
        public final void b(int i9, int i10, int i11, int i12) {
            this.f4459a.onScrollProgress(i9, i10, i11, i12);
        }
    }

    /* JADX INFO: renamed from: T.x$c */
    /* JADX INFO: compiled from: ScrollFeedbackProviderCompat.java */
    public interface c {
        void a(int i9, int i10, int i11, boolean z8);

        void b(int i9, int i10, int i11, int i12);
    }

    public C0436x(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f4458a = new a(nestedScrollView);
        } else {
            this.f4458a = new b();
        }
    }

    /* JADX INFO: renamed from: T.x$b */
    /* JADX INFO: compiled from: ScrollFeedbackProviderCompat.java */
    public static class b implements c {
        @Override // T.C0436x.c
        public final void a(int i9, int i10, int i11, boolean z8) {
        }

        @Override // T.C0436x.c
        public final void b(int i9, int i10, int i11, int i12) {
        }
    }
}
