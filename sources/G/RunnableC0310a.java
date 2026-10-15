package G;

import N6.C0338i;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.starburst.sdk.core.feed.FeedManager;
import com.starburst.sdk.core.widget.SegmentTextView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: G.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0310a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2068b;

    public /* synthetic */ RunnableC0310a(int i9, Object obj) {
        this.f2067a = i9;
        this.f2068b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.app.Application] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [G.e$a] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        ?? r8;
        ?? r9;
        ?? r10;
        boolean z8 = true;
        Object obj2 = this.f2068b;
        switch (this.f2067a) {
            case 0:
                Activity activity = (Activity) obj2;
                if (activity.isFinishing()) {
                    return;
                }
                Application application = Build.VERSION.SDK_INT;
                if (application >= 28) {
                    Class<?> cls = C0314e.f2073a;
                    activity.recreate();
                    return;
                }
                Class<?> cls2 = C0314e.f2073a;
                C0314e.a aVar = 27;
                ?? r11 = 26;
                boolean z9 = application == 26 || application == 27;
                Method method = C0314e.f2078f;
                if ((!z9 || method != null) && (C0314e.f2077e != null || C0314e.f2076d != null)) {
                    try {
                        Object obj3 = C0314e.f2075c.get(activity);
                        if (obj3 != null && (obj = C0314e.f2074b.get(activity)) != null) {
                            application = activity.getApplication();
                            aVar = new C0314e.a(activity);
                            application.registerActivityLifecycleCallbacks(aVar);
                            r11 = C0314e.f2079g;
                            r11.post(new RunnableC0312c(aVar, obj3));
                            if (application != 26 && application != 27) {
                                z8 = false;
                            }
                            try {
                                if (z8) {
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        method.invoke(obj, obj3, null, null, 0, bool, null, null, bool, bool);
                                    } catch (Throwable th) {
                                        th = th;
                                        r10 = application;
                                        r9 = aVar;
                                        r8 = r11;
                                        r8.post(new RunnableC0313d(r10, r9));
                                        throw th;
                                    }
                                } else {
                                    activity.recreate();
                                }
                                r11.post(new RunnableC0313d(application, aVar));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r10 = application;
                                r9 = aVar;
                                r8 = r11;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                ((C0338i) obj2).success(Boolean.FALSE);
                return;
            case 2:
                T3.f fVar = (T3.f) obj2;
                LinearLayout linearLayout = fVar.f4498d;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.animate().cancel();
                fVar.f4498d.setLayerType(2, null);
                fVar.f4498d.animate().alpha(1.0f).translationY(0.0f).setDuration(fVar.j.f4514A).setInterpolator(new DecelerateInterpolator()).withEndAction(new T3.b(fVar, 1)).start();
                return;
            case 3:
                ((com.google.android.material.textfield.c) obj2).t(true);
                return;
            case 4:
                ((com.google.android.material.timepicker.c) obj2).i();
                return;
            case 5:
                ((IUpgradeCallback) obj2).onCancelOTA();
                return;
            case 6:
                ((FeedManager) obj2).lambda$saveLocalState$2();
                return;
            case 7:
                ((SegmentTextView) obj2).lambda$updateDisplay$0();
                return;
            case 8:
                ((p030e.h) obj2).invalidateMenu();
                return;
            case 9:
                e.h.e eVar = (e.h.e) obj2;
                Runnable runnable = eVar.f18559b;
                if (runnable != null) {
                    runnable.run();
                    eVar.f18559b = null;
                    return;
                }
                return;
            case 10:
                p030e.k.a((p030e.k) obj2);
                return;
            case 11:
                ((com.hihonor.push.sdk.c) obj2).a();
                return;
            case 12:
                ((FlutterRenderer.c) obj2).getClass();
                return;
            case 13:
                ((CarouselLayoutManager) obj2).U0();
                return;
            default:
                ((p096m7.k) obj2).success(null);
                return;
        }
    }
}
