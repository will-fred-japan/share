package Y;

import T.C0414a;
import T.G;
import T.L;
import U.f;
import U.g;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p155u.h;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends C0414a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rect f5182n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0074a f5183o = new C0074a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f5184p = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f5189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Chip f5190i;
    public c j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f5185d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f5186e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f5187f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f5188g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5191k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5192l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5193m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: Y.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public class C0074a {
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public class b {
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    public class c extends g {
        public c() {
        }

        @Override // U.g
        public final f a(int i9) {
            return new f(AccessibilityNodeInfo.obtain(a.this.n(i9).f4577a));
        }

        @Override // U.g
        public final f b(int i9) {
            a aVar = a.this;
            int i10 = i9 == 2 ? aVar.f5191k : aVar.f5192l;
            if (i10 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i10);
        }

        @Override // U.g
        public final boolean c(int i9, int i10, Bundle bundle) {
            int i11;
            a aVar = a.this;
            Chip chip = aVar.f5190i;
            if (i9 == -1) {
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                return chip.performAccessibilityAction(i10, bundle);
            }
            if (i10 == 1) {
                return aVar.p(i9);
            }
            if (i10 == 2) {
                return aVar.j(i9);
            }
            boolean z8 = false;
            if (i10 == 64) {
                AccessibilityManager accessibilityManager = aVar.f5189h;
                if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i11 = aVar.f5191k) == i9) {
                    return false;
                }
                if (i11 != Integer.MIN_VALUE) {
                    aVar.f5191k = Integer.MIN_VALUE;
                    aVar.f5190i.invalidate();
                    aVar.q(i11, 65536);
                }
                aVar.f5191k = i9;
                chip.invalidate();
                aVar.q(i9, 32768);
                return true;
            }
            if (i10 == 128) {
                if (aVar.f5191k != i9) {
                    return false;
                }
                aVar.f5191k = Integer.MIN_VALUE;
                chip.invalidate();
                aVar.q(i9, 65536);
                return true;
            }
            Chip.b bVar = (Chip.b) aVar;
            if (i10 == 16) {
                Chip chip2 = Chip.this;
                if (i9 == 0) {
                    return chip2.performClick();
                }
                if (i9 == 1) {
                    chip2.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip2.f13164h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip2);
                        z8 = true;
                    }
                    if (chip2.f13174s) {
                        chip2.f13173r.q(1, 1);
                    }
                }
            }
            return z8;
        }
    }

    public a(Chip chip) {
        this.f5190i = chip;
        this.f5189h = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    @Override // T.C0414a
    public final g b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // T.C0414a
    public final void d(View view, f fVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f4401a;
        AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = Chip.this;
        com.google.android.material.chip.a aVar = chip.f13161e;
        accessibilityNodeInfo.setCheckable(aVar != null && aVar.f13213R);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        accessibilityNodeInfo.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    public final boolean j(int i9) {
        if (this.f5192l != i9) {
            return false;
        }
        this.f5192l = Integer.MIN_VALUE;
        Chip.b bVar = (Chip.b) this;
        if (i9 == 1) {
            Chip chip = Chip.this;
            chip.f13168m = false;
            chip.refreshDrawableState();
        }
        q(i9, 8);
        return true;
    }

    public final f k(int i9) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        f fVar = new f(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        accessibilityNodeInfoObtain.setClassName("android.view.View");
        Rect rect = f5182n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.f5190i;
        accessibilityNodeInfoObtain.setParent(chip);
        o(i9, fVar);
        if (fVar.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f5186e;
        fVar.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        fVar.f4578b = i9;
        accessibilityNodeInfoObtain.setSource(chip, i9);
        if (this.f5191k == i9) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            fVar.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            fVar.a(64);
        }
        boolean z8 = this.f5192l == i9;
        if (z8) {
            fVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            fVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z8);
        int[] iArr = this.f5188g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.f5185d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            fVar.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f5187f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (parent instanceof View) {
                        View view = (View) parent;
                        if (view.getAlpha() > 0.0f && view.getVisibility() == 0) {
                            parent = view.getParent();
                        }
                    }
                    if (parent != null) {
                        accessibilityNodeInfoObtain.setVisibleToUser(true);
                    }
                }
            }
        }
        return fVar;
    }

    public abstract void l(ArrayList arrayList);

    /* JADX WARN: Code duplicated, block: B:115:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x0109  */
    /* JADX WARN: Code duplicated, block: B:54:0x0112  */
    /* JADX WARN: Code duplicated, block: B:57:0x011f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0134  */
    /* JADX WARN: Code duplicated, block: B:68:0x0152  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ad  */
    public final boolean m(int i9, Rect rect) {
        int i10;
        int i11;
        Object obj;
        Object obj2;
        f fVar;
        int i12;
        Rect rect2;
        int i13;
        Rect rect3;
        int i14;
        f fVar2;
        int i15;
        int iD;
        int iE;
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        h hVar = new h();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            hVar.c(((Integer) arrayList.get(i16)).intValue(), k(((Integer) arrayList.get(i16)).intValue()));
        }
        int i17 = this.f5192l;
        int i18 = Integer.MIN_VALUE;
        f fVar3 = i17 == Integer.MIN_VALUE ? null : (f) hVar.b(i17);
        C0074a c0074a = f5183o;
        b bVar = f5184p;
        Chip chip = this.f5190i;
        if (i9 == 1 || i9 == 2) {
            i10 = 0;
            i11 = -1;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            boolean z8 = chip.getLayoutDirection() == 1;
            bVar.getClass();
            int i19 = hVar.f21663c;
            ArrayList arrayList2 = new ArrayList(i19);
            for (int i20 = 0; i20 < i19; i20++) {
                arrayList2.add((f) hVar.f21662b[i20]);
            }
            Collections.sort(arrayList2, new Y.b.a(z8, c0074a));
            if (i9 == 1) {
                int size = arrayList2.size();
                if (fVar3 != null) {
                    size = arrayList2.indexOf(fVar3);
                }
                int i21 = size - 1;
                if (i21 >= 0) {
                    obj = arrayList2.get(i21);
                    obj2 = obj;
                } else {
                    obj2 = null;
                }
            } else {
                if (i9 != 2) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int size2 = arrayList2.size();
                int iLastIndexOf = (fVar3 == null ? -1 : arrayList2.lastIndexOf(fVar3)) + 1;
                if (iLastIndexOf < size2) {
                    obj = arrayList2.get(iLastIndexOf);
                    obj2 = obj;
                } else {
                    obj2 = null;
                }
            }
            fVar = (f) obj2;
        } else {
            if (i9 != 17 && i9 != 33 && i9 != 66 && i9 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect4 = new Rect();
            int i22 = this.f5192l;
            if (i22 != Integer.MIN_VALUE) {
                n(i22).f(rect4);
            } else {
                if (rect != null) {
                    rect4.set(rect);
                } else {
                    int width = chip.getWidth();
                    int height = chip.getHeight();
                    if (i9 == 17) {
                        i11 = -1;
                        rect4.set(width, 0, width, height);
                    } else if (i9 == 33) {
                        i11 = -1;
                        rect4.set(0, height, width, height);
                    } else if (i9 == 66) {
                        rect4.set(-1, 0, -1, height);
                        i11 = -1;
                    } else {
                        if (i9 != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        rect4.set(0, -1, width, -1);
                        i11 = -1;
                    }
                }
                rect2 = new Rect(rect4);
                if (i9 != 17) {
                    i10 = 0;
                    rect2.offset(rect4.width() + 1, 0);
                } else if (i9 != 33) {
                    i10 = 0;
                    rect2.offset(0, rect4.height() + 1);
                } else if (i9 != 66) {
                    i10 = 0;
                    rect2.offset(-(rect4.width() + 1), 0);
                } else {
                    if (i9 == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i10 = 0;
                    rect2.offset(0, -(rect4.height() + 1));
                }
                bVar.getClass();
                i13 = hVar.f21663c;
                rect3 = new Rect();
                fVar = null;
                for (i14 = i10; i14 < i13; i14++) {
                    fVar2 = (f) hVar.f21662b[i14];
                    if (fVar2 == fVar3) {
                        c0074a.getClass();
                        fVar2.f(rect3);
                        if (Y.b.c(i9, rect4, rect3)) {
                            if (Y.b.c(i9, rect4, rect2) || Y.b.a(i9, rect4, rect3, rect2)) {
                                rect2.set(rect3);
                                fVar = fVar2;
                            } else if (Y.b.a(i9, rect4, rect2, rect3)) {
                                int iD2 = Y.b.d(i9, rect4, rect3);
                                int iE2 = Y.b.e(i9, rect4, rect3);
                                i15 = (iE2 * iE2) + (iD2 * 13 * iD2);
                                iD = Y.b.d(i9, rect4, rect2);
                                iE = Y.b.e(i9, rect4, rect2);
                                if (i15 < (iE * iE) + (iD * 13 * iD)) {
                                    rect2.set(rect3);
                                    fVar = fVar2;
                                }
                            }
                        }
                    }
                }
            }
            i11 = -1;
            rect2 = new Rect(rect4);
            if (i9 != 17) {
                i10 = 0;
                rect2.offset(rect4.width() + 1, 0);
            } else if (i9 != 33) {
                i10 = 0;
                rect2.offset(0, rect4.height() + 1);
            } else if (i9 != 66) {
                i10 = 0;
                rect2.offset(-(rect4.width() + 1), 0);
            } else {
                if (i9 == 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                i10 = 0;
                rect2.offset(0, -(rect4.height() + 1));
            }
            bVar.getClass();
            i13 = hVar.f21663c;
            rect3 = new Rect();
            fVar = null;
            while (i14 < i13) {
                fVar2 = (f) hVar.f21662b[i14];
                if (fVar2 == fVar3) {
                    c0074a.getClass();
                    fVar2.f(rect3);
                    if (Y.b.c(i9, rect4, rect3)) {
                        if (Y.b.c(i9, rect4, rect2)) {
                            rect2.set(rect3);
                            fVar = fVar2;
                        } else if (Y.b.a(i9, rect4, rect2, rect3)) {
                            int iD3 = Y.b.d(i9, rect4, rect3);
                            int iE3 = Y.b.e(i9, rect4, rect3);
                            i15 = (iE3 * iE3) + (iD3 * 13 * iD3);
                            iD = Y.b.d(i9, rect4, rect2);
                            iE = Y.b.e(i9, rect4, rect2);
                            if (i15 < (iE * iE) + (iD * 13 * iD)) {
                                rect2.set(rect3);
                                fVar = fVar2;
                            }
                        }
                    }
                }
            }
        }
        f fVar4 = fVar;
        if (fVar4 != null) {
            int i23 = hVar.f21663c;
            int i24 = i10;
            while (true) {
                if (i24 >= i23) {
                    i12 = i11;
                    break;
                }
                if (hVar.f21662b[i24] == fVar4) {
                    i12 = i24;
                    break;
                }
                i24++;
            }
            i18 = hVar.f21661a[i12];
        }
        return p(i18);
    }

    public final f n(int i9) {
        if (i9 != -1) {
            return k(i9);
        }
        Chip chip = this.f5190i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        f fVar = new f(accessibilityNodeInfoObtain);
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            fVar.f4577a.addChild(chip, ((Integer) arrayList.get(i10)).intValue());
        }
        return fVar;
    }

    public abstract void o(int i9, f fVar);

    public final boolean p(int i9) {
        int i10;
        Chip chip = this.f5190i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i10 = this.f5192l) == i9) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            j(i10);
        }
        if (i9 == Integer.MIN_VALUE) {
            return false;
        }
        this.f5192l = i9;
        Chip.b bVar = (Chip.b) this;
        if (i9 == 1) {
            Chip chip2 = Chip.this;
            chip2.f13168m = true;
            chip2.refreshDrawableState();
        }
        q(i9, 8);
        return true;
    }

    public final void q(int i9, int i10) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i9 == Integer.MIN_VALUE || !this.f5189h.isEnabled() || (parent = (view = this.f5190i).getParent()) == null) {
            return;
        }
        if (i9 != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i10);
            f fVarN = n(i9);
            accessibilityEventObtain.getText().add(fVarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = fVarN.f4577a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i9);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i10);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
