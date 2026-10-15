package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: ReportFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public class x extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7779b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u.b f7780a;

    /* JADX INFO: compiled from: ReportFragment.kt */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(Activity activity, AbstractC0544j.a event) {
            kotlin.jvm.internal.k.e(event, "event");
            if (activity instanceof p) {
                ((p) activity).getLifecycle().f(event);
            } else if (activity instanceof InterfaceC0548n) {
                AbstractC0544j lifecycle = ((InterfaceC0548n) activity).getLifecycle();
                if (lifecycle instanceof o) {
                    ((o) lifecycle).f(event);
                }
            }
        }

        public static void b(Activity activity) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.Companion.getClass();
                activity.registerActivityLifecycleCallbacks(new b());
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new x(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* JADX INFO: compiled from: ReportFragment.kt */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a();

        /* JADX INFO: compiled from: ReportFragment.kt */
        public static final class a {
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            kotlin.jvm.internal.k.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
            int i9 = x.f7779b;
            a.a(activity, AbstractC0544j.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.k.e(activity, "activity");
            kotlin.jvm.internal.k.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.k.e(activity, "activity");
        }
    }

    public final void a(AbstractC0544j.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            kotlin.jvm.internal.k.d(activity, "activity");
            a.a(activity, aVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(AbstractC0544j.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(AbstractC0544j.a.ON_DESTROY);
        this.f7780a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(AbstractC0544j.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        u.b bVar = this.f7780a;
        if (bVar != null) {
            u.this.a();
        }
        a(AbstractC0544j.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        u.b bVar = this.f7780a;
        if (bVar != null) {
            u uVar = u.this;
            int i9 = uVar.f7768a + 1;
            uVar.f7768a = i9;
            if (i9 == 1 && uVar.f7771d) {
                uVar.f7773f.f(AbstractC0544j.a.ON_START);
                uVar.f7771d = false;
            }
        }
        a(AbstractC0544j.a.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(AbstractC0544j.a.ON_STOP);
    }
}
