package U;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f4577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4578b = -1;

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4579e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4582h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f4583i;
        public static final a j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f4584k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f4585l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<? extends h.a> f4588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f4589d;

        /* JADX WARN: Code duplicated, block: B:62:0x0253  */
        static {
            boolean z8;
            new a(1);
            new a(2);
            new a(4);
            new a(8);
            f4579e = new a(16);
            new a(32);
            new a(64);
            new a(128);
            new a(256, h.b.class);
            new a(512, h.b.class);
            new a(1024, h.c.class);
            new a(OpusCodecConfig.APPLICATION_VOIP, h.c.class);
            f4580f = new a(4096);
            f4581g = new a(8192);
            new a(Http2.INITIAL_MAX_FRAME_SIZE);
            new a(32768);
            new a(65536);
            new a(131072, h.g.class);
            f4582h = new a(MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
            f4583i = new a(MiPushSdk.FLAG_SUPPORT_CALLKIT);
            j = new a(1048576);
            new a(2097152, h.C0059h.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, h.e.class);
            f4584k = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f4585l = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            int i9 = Build.VERSION.SDK_INT;
            new a(i9 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(i9 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(i9 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(i9 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, h.f.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, h.d.class);
            new a(i9 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(i9 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(i9 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(i9 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            new a(i9 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            new a(i9 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            new a(i9 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            new a(i9 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            new a(i9 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
            int i10 = P.a.f3597a;
            if (i9 >= 36) {
                z8 = (i9 < 36 ? i9 * 100000 : Build.VERSION.SDK_INT_FULL) >= 3600001;
            }
            new a(z8 ? C0058f.a() : null, R.id.ALT, null, null, null);
        }

        public a(int i9) {
            this(null, i9, null, null, null);
        }

        public final int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4586a).getId();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = ((a) obj).f4586a;
            Object obj3 = this.f4586a;
            if (obj3 == null) {
                return obj2 == null;
            }
            return obj3.equals(obj2);
        }

        public final int hashCode() {
            Object obj = this.f4586a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String strD = f.d(this.f4587b);
            if (strD.equals("ACTION_UNKNOWN")) {
                Object obj = this.f4586a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(strD);
            return sb.toString();
        }

        public a(int i9, Class cls) {
            this(null, i9, null, null, cls);
        }

        public a(Object obj, int i9, String str, h hVar, Class cls) {
            this.f4587b = i9;
            this.f4589d = hVar;
            if (obj == null) {
                this.f4586a = new AccessibilityNodeInfo.AccessibilityAction(i9, str);
            } else {
                this.f4586a = obj;
            }
            this.f4588c = cls;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class e {
        public static int a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getChecked();
        }

        public static int b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExpandedState();
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getSupplementalDescription();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isFieldRequired();
        }
    }

    /* JADX INFO: renamed from: U.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class C0058f {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_EXTENDED_SELECTION;
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeInfo.CollectionItemInfo f4590a;

        public g(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.f4590a = collectionItemInfo;
        }

        public static g a(int i9, int i10, int i11, int i12, boolean z8) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i9, i10, i11, i12, false, z8));
        }
    }

    public f(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4577a = accessibilityNodeInfo;
    }

    public static String d(int i9) {
        if (i9 == 1) {
            return "ACTION_FOCUS";
        }
        if (i9 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i9) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case OpusCodecConfig.APPLICATION_VOIP /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION /* 262144 */:
                return "ACTION_EXPAND";
            case MiPushSdk.FLAG_SUPPORT_CALLKIT /* 524288 */:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i9) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i9) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i9) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        switch (i9) {
                                            case R.id.accessibilityActionScrollInDirection:
                                                return "ACTION_SCROLL_IN_DIRECTION";
                                            case R.id.ALT:
                                                return "ACTION_SET_EXTENDED_SELECTION";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
        }
    }

    public final void a(int i9) {
        this.f4577a.addAction(i9);
    }

    public final void b(a aVar) {
        this.f4577a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f4586a);
    }

    public final ArrayList c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4577a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final boolean e(int i9) {
        Bundle extras = this.f4577a.getExtras();
        return extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i9) == i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f4577a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f4578b == fVar.f4578b;
    }

    @Deprecated
    public final void f(Rect rect) {
        this.f4577a.getBoundsInParent(rect);
    }

    public final CharSequence g() {
        boolean zIsEmpty = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4577a;
        if (zIsEmpty) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList arrayListC = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList arrayListC2 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList arrayListC3 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList arrayListC4 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i9 = 0; i9 < arrayListC.size(); i9++) {
            spannableString.setSpan(new U.a(((Integer) arrayListC4.get(i9)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListC.get(i9)).intValue(), ((Integer) arrayListC2.get(i9)).intValue(), ((Integer) arrayListC3.get(i9)).intValue());
        }
        return spannableString;
    }

    public final void h(g gVar) {
        this.f4577a.setCollectionItemInfo(gVar.f4590a);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4577a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void i(boolean z8) {
        this.f4577a.setScrollable(z8);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        f(rect);
        sb.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4577a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 34) {
            d.b(accessibilityNodeInfo, rect);
        } else {
            Rect rect2 = (Rect) accessibilityNodeInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; error: ");
        sb.append(accessibilityNodeInfo.getError());
        sb.append("; maxTextLength: ");
        sb.append(accessibilityNodeInfo.getMaxTextLength());
        sb.append("; stateDescription: ");
        sb.append(i9 >= 30 ? b.a(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY"));
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; supplementalDescription: ");
        sb.append(i9 >= 36 ? e.c(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY"));
        sb.append("; tooltipText: ");
        sb.append(i9 >= 28 ? accessibilityNodeInfo.getTooltipText() : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY"));
        sb.append("; viewIdResName: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(i9 >= 33 ? c.a(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        int iA = i9 >= 36 ? e.a(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", accessibilityNodeInfo.isChecked() ? 1 : 0);
        String str = "PARTIAL";
        sb.append(iA == 1 ? "TRUE" : iA == 2 ? "PARTIAL" : "FALSE");
        sb.append("; fieldRequired: ");
        sb.append(i9 >= 36 ? e.d(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY"));
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(accessibilityNodeInfo.isContextClickable());
        sb.append("; expandedState: ");
        int iB = i9 >= 36 ? e.b(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", 0);
        if (iB == 0) {
            str = "UNDEFINED";
        } else if (iB == 1) {
            str = "COLLAPSED";
        } else if (iB != 2) {
            str = iB != 3 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "FULL";
        }
        sb.append(str);
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; containerTitle: ");
        sb.append(i9 >= 34 ? d.c(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY"));
        sb.append("; granularScrollingSupported: ");
        sb.append(e(67108864));
        sb.append("; importantForAccessibility: ");
        sb.append(accessibilityNodeInfo.isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(accessibilityNodeInfo.isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(i9 >= 33 ? c.b(accessibilityNodeInfo) : e(8388608));
        sb.append("; accessibilityDataSensitive: ");
        sb.append(i9 >= 34 ? d.d(accessibilityNodeInfo) : e(64));
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10), 0, null, null, null));
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            a aVar = (a) arrayList.get(i11);
            String strD = d(aVar.a());
            if (strD.equals("ACTION_UNKNOWN")) {
                Object obj = aVar.f4586a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(strD);
            if (i11 != arrayList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
