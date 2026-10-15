package D6;

import C6.g;
import N6.C0338i;
import N6.C0344o;
import P6.d;
import Y.c;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.o;
import androidx.lifecycle.u;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.i;
import com.starburst.sdk.core.feed.FeedManager;
import com.starburst.sdk.core.keepalive.KeepAliveManager;
import com.starburst.sdk.core.voicechat.VoiceChatWs;
import com.starburst.sdk.core.widget.SegmentTextView;
import java.util.ArrayList;
import kotlin.jvm.internal.k;
import p142s2.j;
import p188x7.f;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1936b;

    public /* synthetic */ a(int i9, Object obj) {
        this.f1935a = i9;
        this.f1936b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Object objA;
        LinearLayout linearLayout;
        switch (this.f1935a) {
            case 0:
                g gVar = b.f1937a;
                Fragment fragment = (b) this.f1936b;
                Activity activity = fragment.getActivity();
                if (activity == null) {
                    return;
                }
                boolean zP = p199z2.b.p(activity);
                String msg = k.h("PermissionFragment onActivityResult: ", Boolean.valueOf(zP));
                k.e(msg, "msg");
                k.e(msg.toString(), "msg");
                g gVar2 = b.f1937a;
                if (gVar2 != null) {
                    gVar2.d(zP);
                }
                b.f1937a = null;
                fragment.getFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                return;
            case 1:
                SideSheetBehavior.b bVar = (SideSheetBehavior.b) this.f1936b;
                bVar.f13645b = false;
                SideSheetBehavior sideSheetBehavior = bVar.f13647d;
                c cVar = sideSheetBehavior.f13630i;
                if (cVar != null && cVar.g()) {
                    bVar.a(bVar.f13644a);
                    return;
                } else {
                    if (sideSheetBehavior.f13629h == 2) {
                        sideSheetBehavior.s(bVar.f13644a);
                        return;
                    }
                    return;
                }
            case 2:
                try {
                    C0344o.a aVar = ((C0344o) this.f1936b).f3365E;
                    if (aVar == null) {
                        k.i("routedSpeechTtsPlayer");
                        throw null;
                    }
                    aVar.g();
                    objA = p188x7.k.f22364a;
                    Throwable thA = f.a(objA);
                    if (thA != null) {
                        String message = "stopSpeechTtsNativePlayback failed: " + thA.getMessage();
                        k.e(message, "message");
                        if (j.f21198l) {
                            Log.w("StarburstBleAuthPlugin", message);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    objA = p188x7.g.a(th);
                }
                break;
            case 3:
                ((C0344o.a) this.f1936b).f();
                return;
            case 4:
                ((C0338i) this.f1936b).success(Boolean.FALSE);
                return;
            case 5:
                break;
            case 6:
                T3.f fVar = (T3.f) this.f1936b;
                LinearLayout linearLayout2 = fVar.f4498d;
                if (linearLayout2 != null) {
                    linearLayout2.setAlpha(0.0f);
                    fVar.f4498d.setVisibility(4);
                }
                WindowManager windowManager = fVar.f4497c;
                if (windowManager != null && (linearLayout = fVar.f4498d) != null) {
                    try {
                        windowManager.removeView(linearLayout);
                        break;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                fVar.f4498d = null;
                fVar.f4499e = null;
                fVar.f4501g = false;
                fVar.f4502h = false;
                return;
            case 7:
                W.a.C0065a c0065a = ((W.a) this.f1936b).f4985a;
                ViewParent parent = c0065a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(c0065a);
                    return;
                }
                return;
            case 8:
                Toolbar.f fVar2 = ((Toolbar) this.f1936b).f6535M;
                h hVar = fVar2 != null ? fVar2.f6573b : null;
                if (hVar != null) {
                    hVar.collapseActionView();
                    return;
                }
                return;
            case 9:
                androidx.fragment.app.Fragment fragment2 = (androidx.fragment.app.Fragment) this.f1936b;
                fragment2.O.f7684e.b(fragment2.f7463d);
                fragment2.f7463d = null;
                return;
            case 10:
                u this$0 = (u) this.f1936b;
                k.e(this$0, "this$0");
                int i9 = this$0.f7769b;
                o oVar = this$0.f7773f;
                if (i9 == 0) {
                    this$0.f7770c = true;
                    oVar.f(AbstractC0544j.a.ON_PAUSE);
                }
                if (this$0.f7768a == 0 && this$0.f7770c) {
                    oVar.f(AbstractC0544j.a.ON_STOP);
                    this$0.f7771d = true;
                    return;
                }
                return;
            case 11:
                EditText editText = (EditText) this.f1936b;
                editText.requestFocus();
                editText.post(new a(12, editText));
                return;
            case 12:
                View view = (View) this.f1936b;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 13:
                i iVar = (i) this.f1936b;
                boolean zIsPopupShowing = iVar.f13858h.isPopupShowing();
                iVar.t(zIsPopupShowing);
                iVar.f13862m = zIsPopupShowing;
                return;
            case 14:
                ((TextInputLayout) this.f1936b).f13795d.requestLayout();
                return;
            case 15:
                ((FeedManager) this.f1936b).lambda$deleteExpiredFilesInFeedCache$1();
                return;
            case 16:
                ((KeepAliveManager.KeepAliveService) this.f1936b).lambda$ensureHeartbeat$0();
                return;
            case 17:
                ((VoiceChatWs) this.f1936b).lambda$processNextMessage$0();
                return;
            case 18:
                ((SegmentTextView) this.f1936b).lambda$autoScroll$2();
                return;
            default:
                ((com.hihonor.push.sdk.c) this.f1936b).b();
                return;
        }
        while (true) {
            O6.g gVar3 = (O6.g) this.f1936b;
            ArrayList arrayList = gVar3.f3509f;
            if (arrayList.isEmpty() || gVar3.f3514l != null) {
                return;
            }
            ((d) arrayList.get(0)).f3642a.run();
            arrayList.remove(0);
        }
    }
}
