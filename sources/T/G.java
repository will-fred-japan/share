package T;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import cn.ikaile.ruoshui.client.R;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, L> f4313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f4314b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4315c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f4316d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final B f4317e = new B();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f4318f = new a();

    /* JADX INFO: compiled from: ViewCompat.java */
    public static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f4321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4323d;

        public b(int i9, Class<T> cls, int i10, int i11) {
            this.f4320a = i9;
            this.f4321b = cls;
            this.f4323d = i10;
            this.f4322c = i11;
        }

        public abstract T a(View view);

        public abstract void b(View view, T t);

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(View view, T t) {
            Object tag;
            C0414a c0414a;
            if (Build.VERSION.SDK_INT >= this.f4322c) {
                b(view, t);
                return;
            }
            if (Build.VERSION.SDK_INT >= this.f4322c) {
                tag = a(view);
            } else {
                tag = view.getTag(this.f4320a);
                if (!this.f4321b.isInstance(tag)) {
                    tag = null;
                }
            }
            if (d(tag, t)) {
                View.AccessibilityDelegate accessibilityDelegateD = G.d(view);
                if (accessibilityDelegateD == null) {
                    c0414a = null;
                } else {
                    c0414a = accessibilityDelegateD instanceof C0414a.C0052a ? ((C0414a.C0052a) accessibilityDelegateD).f4403a : new C0414a(accessibilityDelegateD);
                }
                if (c0414a == null) {
                    c0414a = new C0414a();
                }
                G.m(view, c0414a);
                view.setTag(this.f4320a, t);
                G.h(view, this.f4323d);
            }
        }

        public abstract boolean d(T t, T t6);
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class c {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            int i9 = J.f4331a;
            return view.dispatchApplyWindowInsets(windowInsets);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class d {

        /* JADX INFO: compiled from: ViewCompat.java */
        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Q f4324a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f4325b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0431s f4326c;

            public a(View view, InterfaceC0431s interfaceC0431s) {
                this.f4325b = view;
                this.f4326c = interfaceC0431s;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Q qG = Q.g(view, windowInsets);
                int i9 = Build.VERSION.SDK_INT;
                InterfaceC0431s interfaceC0431s = this.f4326c;
                if (i9 < 30) {
                    d.a(windowInsets, this.f4325b);
                    if (qG.equals(this.f4324a)) {
                        return interfaceC0431s.b(view, qG).f();
                    }
                }
                this.f4324a = qG;
                Q qB = interfaceC0431s.b(view, qG);
                if (i9 >= 30) {
                    return qB.f();
                }
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                view.requestApplyInsets();
                return qB.f();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static Q b(View view, Q q8, Rect rect) {
            WindowInsets windowInsetsF = q8.f();
            if (windowInsetsF != null) {
                return Q.g(view, view.computeSystemWindowInsets(windowInsetsF, rect));
            }
            rect.setEmpty();
            return q8;
        }

        public static void c(View view, InterfaceC0431s interfaceC0431s) {
            a aVar = interfaceC0431s != null ? new a(view, interfaceC0431s) : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, aVar);
            }
            if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (aVar != null) {
                view.setOnApplyWindowInsetsListener(aVar);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            }
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class e {
        public static Q a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            Q qG = Q.g(null, rootWindowInsets);
            Q.q qVar = qG.f4366a;
            qVar.w(qG);
            View rootView = view.getRootView();
            qVar.d(rootView);
            qVar.o(rootView);
            qVar.p();
            return qG;
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class f {
        public static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class g {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i9) {
            view.setImportantForAutofill(i9);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class h {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z8) {
            view.setAccessibilityHeading(z8);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z8) {
            view.setScreenReaderFocusable(z8);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class i {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i9, int i10) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i9, i10);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class j {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static final class k {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0416c b(View view, C0416c c0416c) {
            ContentInfo contentInfoC = c0416c.f4405a.c();
            Objects.requireNonNull(contentInfoC);
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoC);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoC ? c0416c : new C0416c(new C0416c.d(contentInfoPerformReceiveContent));
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public interface l {
        boolean a();
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f4327d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f4328a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f4329b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f4330c = null;

        public static boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((l) arrayList.get(size)).a()) {
                    return true;
                }
            }
            return false;
        }

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f4328a;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewA = a(viewGroup.getChildAt(childCount), keyEvent);
                    if (viewA != null) {
                        return viewA;
                    }
                }
            }
            if (b(view, keyEvent)) {
                return view;
            }
            return null;
        }
    }

    @Deprecated
    public static L a(View view) {
        if (f4313a == null) {
            f4313a = new WeakHashMap<>();
        }
        L l8 = f4313a.get(view);
        if (l8 != null) {
            return l8;
        }
        L l9 = new L(view);
        f4313a.put(view, l9);
        return l9;
    }

    public static void b(View view, Q q8) {
        WindowInsets windowInsetsF = q8.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsA = Build.VERSION.SDK_INT >= 30 ? j.a(view, windowInsetsF) : c.a(view, windowInsetsF);
            if (windowInsetsA.equals(windowInsetsF)) {
                return;
            }
            Q.g(view, windowInsetsA);
        }
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = m.f4327d;
        m mVar = (m) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (mVar == null) {
            mVar = new m();
            view.setTag(R.id.tag_unhandled_key_event_manager, mVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = mVar.f4328a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = m.f4327d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (mVar.f4328a == null) {
                            mVar.f4328a = new WeakHashMap<>();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList<WeakReference<View>> arrayList3 = m.f4327d;
                            View view2 = arrayList3.get(size).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                mVar.f4328a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    mVar.f4328a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewA = mVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (mVar.f4329b == null) {
                    mVar.f4329b = new SparseArray<>();
                }
                mVar.f4329b.put(keyCode, new WeakReference<>(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return i.a(view);
        }
        if (f4315c) {
            return null;
        }
        if (f4314b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4314b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4315c = true;
                return null;
            }
        }
        try {
            Object obj = f4314b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4315c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = h.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? k.a(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i9) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z8 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z8) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z8 ? 32 : OpusCodecConfig.APPLICATION_VOIP);
                accessibilityEventObtain.setContentChangeTypes(i9);
                if (z8) {
                    accessibilityEventObtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i9 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i9);
                        return;
                    } catch (AbstractMethodError e9) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e9);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i9);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(e(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0416c i(View view, C0416c c0416c) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0416c + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return k.b(view, c0416c);
        }
        InterfaceC0432t interfaceC0432t = (InterfaceC0432t) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC0433u interfaceC0433u = f4317e;
        if (interfaceC0432t == null) {
            if (view instanceof InterfaceC0433u) {
                interfaceC0433u = (InterfaceC0433u) view;
            }
            return interfaceC0433u.a(c0416c);
        }
        C0416c c0416cA = interfaceC0432t.a(view, c0416c);
        if (c0416cA == null) {
            return null;
        }
        if (view instanceof InterfaceC0433u) {
            interfaceC0433u = (InterfaceC0433u) view;
        }
        return interfaceC0433u.a(c0416cA);
    }

    public static void j(View view, int i9) {
        ArrayList arrayListF = f(view);
        for (int i10 = 0; i10 < arrayListF.size(); i10++) {
            if (((U.f.a) arrayListF.get(i10)).a() == i9) {
                arrayListF.remove(i10);
                return;
            }
        }
    }

    public static void k(View view, U.f.a aVar, U.h hVar) {
        C0414a c0414a;
        if (hVar == null) {
            j(view, aVar.a());
            h(view, 0);
            return;
        }
        U.f.a aVar2 = new U.f.a(null, aVar.f4587b, null, hVar, aVar.f4588c);
        View.AccessibilityDelegate accessibilityDelegateD = d(view);
        if (accessibilityDelegateD == null) {
            c0414a = null;
        } else {
            c0414a = accessibilityDelegateD instanceof C0414a.C0052a ? ((C0414a.C0052a) accessibilityDelegateD).f4403a : new C0414a(accessibilityDelegateD);
        }
        if (c0414a == null) {
            c0414a = new C0414a();
        }
        m(view, c0414a);
        j(view, aVar2.a());
        f(view).add(aVar2);
        h(view, 0);
    }

    public static void l(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i9) {
        if (Build.VERSION.SDK_INT >= 29) {
            i.b(view, context, iArr, attributeSet, typedArray, i9, 0);
        }
    }

    public static void m(View view, C0414a c0414a) {
        if (c0414a == null && (d(view) instanceof C0414a.C0052a)) {
            c0414a = new C0414a();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(c0414a == null ? null : c0414a.f4402b);
    }

    public static void n(View view, CharSequence charSequence) {
        new D(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view, charSequence);
        a aVar = f4318f;
        if (charSequence == null) {
            aVar.f4319a.remove(view);
            view.removeOnAttachStateChangeListener(aVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
        } else {
            aVar.f4319a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(aVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            }
        }
    }

    public static void o(View view, P.b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new P.d.a(bVar));
            return;
        }
        PathInterpolator pathInterpolator = P.c.f4339e;
        View.OnApplyWindowInsetsListener aVar = new P.c.a(view, bVar);
        view.setTag(R.id.tag_window_insets_animation_callback, aVar);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(aVar);
        }
    }

    /* JADX INFO: compiled from: ViewCompat.java */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f4319a = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f4319a.entrySet()) {
                    View key = entry.getKey();
                    boolean zBooleanValue = entry.getValue().booleanValue();
                    boolean z8 = key.isShown() && key.getWindowVisibility() == 0;
                    if (zBooleanValue != z8) {
                        G.h(key, z8 ? 16 : 32);
                        entry.setValue(Boolean.valueOf(z8));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
