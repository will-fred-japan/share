package T;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import cn.ikaile.ruoshui.client.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: T.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C0414a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f4400c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f4401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0052a f4402b;

    /* JADX INFO: renamed from: T.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
    public static final class C0052a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0414a f4403a;

        public C0052a(C0414a c0414a) {
            this.f4403a = c0414a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4403a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            U.g gVarB = this.f4403a.b(view);
            if (gVarB != null) {
                return gVarB.f4591a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4403a.c(view, accessibilityEvent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            Object tag;
            Object tag2;
            U.f fVar = new U.f(accessibilityNodeInfo);
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            Object objB = null;
            if (Build.VERSION.SDK_INT >= 28) {
                tag = Boolean.valueOf(G.h.c(view));
            } else {
                tag = view.getTag(R.id.tag_screen_reader_focusable);
                if (!Boolean.class.isInstance(tag)) {
                    tag = null;
                }
            }
            Boolean bool = (Boolean) tag;
            boolean z8 = (bool == null || !bool.booleanValue()) ? 0 : 1;
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 28) {
                accessibilityNodeInfo.setScreenReaderFocusable(z8);
            } else {
                Bundle extras = accessibilityNodeInfo.getExtras();
                if (extras != null) {
                    extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", z8 | (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-2)));
                }
            }
            if (Build.VERSION.SDK_INT >= 28) {
                tag2 = Boolean.valueOf(G.h.b(view));
            } else {
                tag2 = view.getTag(R.id.tag_accessibility_heading);
                if (!Boolean.class.isInstance(tag2)) {
                    tag2 = null;
                }
            }
            Boolean bool2 = (Boolean) tag2;
            boolean z9 = bool2 != null && bool2.booleanValue();
            if (i9 >= 28) {
                accessibilityNodeInfo.setHeading(z9);
            } else {
                Bundle extras2 = accessibilityNodeInfo.getExtras();
                if (extras2 != null) {
                    extras2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (z9 ? 2 : 0) | (extras2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (-3)));
                }
            }
            CharSequence charSequenceE = G.e(view);
            if (i9 >= 28) {
                accessibilityNodeInfo.setPaneTitle(charSequenceE);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequenceE);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                objB = G.j.b(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_state_description);
                if (CharSequence.class.isInstance(tag3)) {
                    objB = tag3;
                }
            }
            CharSequence charSequence = (CharSequence) objB;
            if (i9 >= 30) {
                U.f.b.b(accessibilityNodeInfo, charSequence);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
            }
            this.f4403a.d(view, fVar);
            accessibilityNodeInfo.getText();
            List list = (List) view.getTag(R.id.tag_accessibility_actions);
            if (list == null) {
                list = Collections.EMPTY_LIST;
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                fVar.b((U.f.a) list.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4403a.e(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4403a.f(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View view, int i9, Bundle bundle) {
            return this.f4403a.g(view, i9, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View view, int i9) {
            this.f4403a.h(view, i9);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4403a.i(view, accessibilityEvent);
        }
    }

    public C0414a() {
        this(f4400c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f4401a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public U.g b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f4401a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new U.g(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4401a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, U.f fVar) {
        this.f4401a.onInitializeAccessibilityNodeInfo(view, fVar.f4577a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f4401a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f4401a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i9, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z8 = false;
        int i10 = 0;
        while (true) {
            if (i10 < list.size()) {
                U.f.a aVar = (U.f.a) list.get(i10);
                if (aVar.a() == i9) {
                    U.h hVar = aVar.f4589d;
                    if (hVar != null) {
                        Class<? extends U.h.a> cls = aVar.f4588c;
                        if (cls != null) {
                            try {
                                cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass();
                            } catch (Exception e9) {
                                Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e9);
                            }
                        }
                        zPerformAccessibilityAction = hVar.c(view);
                        break;
                    }
                } else {
                    i10++;
                }
            }
            zPerformAccessibilityAction = false;
            break;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f4401a.performAccessibilityAction(view, i9, bundle);
        }
        if (zPerformAccessibilityAction || i9 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i11 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i11)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i12 = 0; clickableSpanArr != null && i12 < clickableSpanArr.length; i12++) {
                if (clickableSpan.equals(clickableSpanArr[i12])) {
                    clickableSpan.onClick(view);
                    z8 = true;
                    break;
                }
            }
        }
        return z8;
    }

    public void h(View view, int i9) {
        this.f4401a.sendAccessibilityEvent(view, i9);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f4401a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0414a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f4401a = accessibilityDelegate;
        this.f4402b = new C0052a(this);
    }
}
