package B0;

import Q4.InterfaceC0357m;
import T.InterfaceC0431s;
import Z.C0451c;
import Z.f0;
import Z.i0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.ActionBarContextView;
import cn.ikaile.ruoshui.client.R;
import com.google.android.gms.location.LocationSettingsRequest;
import com.starburst.sdk.api.IAuthInfoCallback;
import com.starburst.sdk.resp.AuthInfoRes;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p056h5.BinderC0602i;

/* JADX INFO: compiled from: WebSettingsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class N implements IAuthInfoCallback, C6.g, InterfaceC0431s, p045g1.b, InterfaceC0357m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static N f1622c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1624b;

    public /* synthetic */ N(int i9, Object obj) {
        this.f1623a = i9;
        this.f1624b = obj;
    }

    @Override // p045g1.b
    public void a(JSONObject jSONObject) {
        p045g1.b bVar = (p045g1.b) this.f1624b;
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }

    @Override // T.InterfaceC0431s
    public T.Q b(View view, T.Q q8) {
        int i9;
        boolean z8;
        T.Q qB;
        T.Q.h bVar;
        boolean z9;
        int iD = q8.d();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.f1624b;
        appCompatDelegateImpl.getClass();
        int iD2 = q8.d();
        ActionBarContextView actionBarContextView = appCompatDelegateImpl.f5900v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i9 = 0;
            z8 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.f5900v.getLayoutParams();
            boolean z10 = true;
            if (appCompatDelegateImpl.f5900v.isShown()) {
                if (appCompatDelegateImpl.f5890o0 == null) {
                    appCompatDelegateImpl.f5890o0 = new Rect();
                    appCompatDelegateImpl.f5892p0 = new Rect();
                }
                Rect rect = appCompatDelegateImpl.f5890o0;
                Rect rect2 = appCompatDelegateImpl.f5892p0;
                rect.set(q8.b(), q8.d(), q8.c(), q8.a());
                ViewGroup viewGroup = appCompatDelegateImpl.f5858B;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z11 = androidx.appcompat.widget.Q.f6464a;
                    androidx.appcompat.widget.Q.a.a(viewGroup, rect, rect2);
                } else {
                    if (!androidx.appcompat.widget.Q.f6464a) {
                        androidx.appcompat.widget.Q.f6464a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            androidx.appcompat.widget.Q.f6465b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                androidx.appcompat.widget.Q.f6465b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = androidx.appcompat.widget.Q.f6465b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e9) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e9);
                        }
                    }
                }
                int i10 = rect.top;
                int i11 = rect.left;
                int i12 = rect.right;
                ViewGroup viewGroup2 = appCompatDelegateImpl.f5858B;
                WeakHashMap<View, T.L> weakHashMap = T.G.f4313a;
                T.Q qA = T.G.e.a(viewGroup2);
                int iB = qA == null ? 0 : qA.b();
                int iC = qA == null ? 0 : qA.c();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z9 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z9 = true;
                }
                Context context = appCompatDelegateImpl.f5882k;
                if (i10 <= 0 || appCompatDelegateImpl.f5860D != null) {
                    View view2 = appCompatDelegateImpl.f5860D;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            appCompatDelegateImpl.f5860D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    appCompatDelegateImpl.f5860D = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    appCompatDelegateImpl.f5858B.addView(appCompatDelegateImpl.f5860D, -1, layoutParams);
                }
                View view4 = appCompatDelegateImpl.f5860D;
                z10 = view4 != null;
                if (z10 && view4.getVisibility() != 0) {
                    View view5 = appCompatDelegateImpl.f5860D;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!appCompatDelegateImpl.f5865I && z10) {
                    iD2 = 0;
                }
                z8 = z10;
                z10 = z9;
                i9 = 0;
            } else {
                i9 = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z8 = false;
                } else {
                    z8 = false;
                    z10 = false;
                }
            }
            if (z10) {
                appCompatDelegateImpl.f5900v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = appCompatDelegateImpl.f5860D;
        if (view6 != null) {
            view6.setVisibility(z8 ? i9 : 8);
        }
        if (iD != iD2) {
            int iB2 = q8.b();
            int iC2 = q8.c();
            int iA = q8.a();
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 36) {
                bVar = new T.Q.g(q8);
            } else if (i15 >= 35) {
                bVar = new T.Q.f(q8);
            } else if (i15 >= 34) {
                bVar = new T.Q.e(q8);
            } else if (i15 >= 31) {
                bVar = new T.Q.d(q8);
            } else if (i15 >= 30) {
                bVar = new T.Q.c(q8);
            } else {
                bVar = i15 >= 29 ? new T.Q.b(q8) : new T.Q.a(q8);
            }
            bVar.h(K.b.c(iB2, iD2, iC2, iA));
            qB = bVar.b();
        } else {
            qB = q8;
        }
        WeakHashMap<View, T.L> weakHashMap2 = T.G.f4313a;
        WindowInsets windowInsetsF = qB.f();
        if (windowInsetsF == null) {
            return qB;
        }
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsF);
        return !windowInsetsOnApplyWindowInsets.equals(windowInsetsF) ? T.Q.g(view, windowInsetsOnApplyWindowInsets) : qB;
    }

    public f0 c() {
        return (f0) ((V7.s) this.f1624b).getValue();
    }

    @Override // C6.g
    public void d(boolean z8) {
        Log.d("AdaptFloatWindow/Android", "overlay permission result=" + z8);
        ((R6.d) this.f1624b).invoke(Boolean.valueOf(z8));
    }

    @Override // Q4.InterfaceC0357m
    public /* synthetic */ void e(Object obj, Object obj2) {
        ((p056h5.N) ((p056h5.r) obj).r()).x((LocationSettingsRequest) this.f1624b, new BinderC0602i((p094m5.f) obj2));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    public void f(f0 newState) {
        V7.s sVar;
        Object value;
        Object obj;
        kotlin.jvm.internal.k.e(newState, "newState");
        do {
            sVar = (V7.s) this.f1624b;
            value = sVar.getValue();
            f0 f0Var = (f0) value;
            if (f0Var instanceof Z.V ? true : kotlin.jvm.internal.k.a(f0Var, i0.f5397b)) {
                obj = f0Var;
                obj = newState;
            } else if (f0Var instanceof C0451c) {
                if (newState.f5381a > f0Var.f5381a) {
                    obj = f0Var;
                    obj = newState;
                }
            } else if (!(f0Var instanceof Z.Q)) {
                obj = f0Var;
                throw new L4.b();
            }
            obj = f0Var;
            obj = f0Var;
            N n8 = W7.m.f5097a;
            if (value == null) {
                value = n8;
            }
            if (obj == null) {
                obj = n8;
            }
        } while (!sVar.d(value, obj));
    }

    @Override // com.starburst.sdk.api.IAuthInfoCallback
    public void onFailure(int i9, String str) {
        com.starburst.sdk.utils.j.x(J6.b.f2695p, "refreshPhoneAuthTokenInBackground failed, code=" + i9 + ", msg=" + str);
        J6.b.b((J6.b) this.f1624b);
    }

    @Override // com.starburst.sdk.api.IAuthInfoCallback
    public void onSuccess(AuthInfoRes authInfoRes) {
        String str = J6.b.f2695p;
        StringBuilder sb = new StringBuilder("refreshPhoneAuthTokenInBackground success, expireTime=");
        sb.append(authInfoRes == null ? null : authInfoRes.getExpireTime());
        com.starburst.sdk.utils.j.f(str, sb.toString());
    }

    public String toString() {
        switch (this.f1623a) {
            case 7:
                return "<" + ((String) this.f1624b) + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ N(int i9, boolean z8) {
        this.f1623a = i9;
    }

    public N(int i9) {
        this.f1623a = i9;
        switch (i9) {
            case 8:
                this.f1624b = new V7.s(i0.f5397b);
                break;
            case 9:
                this.f1624b = new HashMap();
                break;
            default:
                this.f1624b = new ArrayList();
                break;
        }
    }

    public N(boolean z8) {
        this.f1623a = 11;
        this.f1624b = new AtomicBoolean(z8);
    }

    public N(L5.m mVar, int i9) {
        this.f1623a = 6;
        this.f1624b = mVar;
    }
}
