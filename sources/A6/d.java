package A6;

import S7.C0409v;
import android.animation.Animator;
import android.view.View;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.widget.ParentFrameLayout;

/* JADX INFO: compiled from: FloatingWindowHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1502c;

    public /* synthetic */ d(Object obj, View view, int i9) {
        this.f1500a = i9;
        this.f1502c = obj;
        this.f1501b = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        C0409v c0409v;
        switch (this.f1500a) {
            case 0:
                break;
            default:
                FloatConfig floatConfig = ((h) this.f1502c).f1512b;
                floatConfig.setAnim(false);
                floatConfig.getCallbacks();
                C6.a floatCallbacks = floatConfig.getFloatCallbacks();
                if (floatCallbacks != null && (c0409v = floatCallbacks.a().f1805c) != null) {
                    c0409v.invoke(this.f1501b);
                }
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ParentFrameLayout parentFrameLayout;
        C0409v c0409v;
        switch (this.f1500a) {
            case 0:
                c cVar = (c) this.f1502c;
                cVar.f1490b.setAnim(false);
                if (!cVar.f1490b.getImmersionStatusBar()) {
                    cVar.c().flags = 40;
                }
                if (cVar.f1490b.getHasEditText() && (parentFrameLayout = cVar.f1493e) != null) {
                    cVar.g(parentFrameLayout);
                    break;
                }
                break;
            default:
                FloatConfig floatConfig = ((h) this.f1502c).f1512b;
                floatConfig.setAnim(false);
                floatConfig.getCallbacks();
                C6.a floatCallbacks = floatConfig.getFloatCallbacks();
                if (floatCallbacks != null && (c0409v = floatCallbacks.a().f1805c) != null) {
                    c0409v.invoke(this.f1501b);
                }
                break;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i9 = this.f1500a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f1500a) {
            case 0:
                this.f1501b.setVisibility(0);
                ((c) this.f1502c).f1490b.setAnim(true);
                break;
            default:
                ((h) this.f1502c).f1512b.setAnim(true);
                break;
        }
    }

    private final void a(Animator animator) {
    }

    private final void b(Animator animator) {
    }

    private final void c(Animator animator) {
    }
}
