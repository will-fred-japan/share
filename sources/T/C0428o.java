package T;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: T.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: NestedScrollingChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0428o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f4445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f4446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f4447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f4449e;

    public C0428o(ViewGroup viewGroup) {
        this.f4447c = viewGroup;
    }

    public final boolean a(float f6, float f9, boolean z8) {
        ViewParent viewParentE;
        if (this.f4448d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedFling(this.f4447c, f6, f9, z8);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e9);
            }
        }
        return false;
    }

    public final boolean b(float f6, float f9) {
        ViewParent viewParentE;
        if (this.f4448d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedPreFling(this.f4447c, f6, f9);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e9);
            }
        }
        return false;
    }

    public final boolean c(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        ViewParent viewParentE;
        int i12;
        int i13;
        if (!this.f4448d || (viewParentE = e(i11)) == null) {
            return false;
        }
        if (i9 == 0 && i10 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f4447c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i12 = iArr2[0];
            i13 = iArr2[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr == null) {
            if (this.f4449e == null) {
                this.f4449e = new int[2];
            }
            iArr = this.f4449e;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentE instanceof InterfaceC0429p) {
            ((InterfaceC0429p) viewParentE).onNestedPreScroll(viewGroup, i9, i10, iArr3, i11);
        } else if (i11 == 0) {
            try {
                viewParentE.onNestedPreScroll(viewGroup, i9, i10, iArr3);
            } catch (AbstractMethodError e9) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e9);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i12;
            iArr2[1] = iArr2[1] - i13;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i9, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        ViewParent viewParentE;
        int i14;
        int i15;
        int[] iArr3;
        if (this.f4448d && (viewParentE = e(i13)) != null) {
            if (i9 != 0 || i10 != 0 || i11 != 0 || i12 != 0) {
                ViewGroup viewGroup = this.f4447c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i14 = iArr[0];
                    i15 = iArr[1];
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                if (iArr2 == null) {
                    if (this.f4449e == null) {
                        this.f4449e = new int[2];
                    }
                    int[] iArr4 = this.f4449e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentE instanceof InterfaceC0430q) {
                    ((InterfaceC0430q) viewParentE).onNestedScroll(viewGroup, i9, i10, i11, i12, i13, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i11;
                    iArr3[1] = iArr3[1] + i12;
                    if (viewParentE instanceof InterfaceC0429p) {
                        ((InterfaceC0429p) viewParentE).onNestedScroll(viewGroup, i9, i10, i11, i12, i13);
                    } else if (i13 == 0) {
                        try {
                            viewParentE.onNestedScroll(viewGroup, i9, i10, i11, i12);
                        } catch (AbstractMethodError e9) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e9);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i14;
                    iArr[1] = iArr[1] - i15;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i9) {
        if (i9 == 0) {
            return this.f4445a;
        }
        if (i9 != 1) {
            return null;
        }
        return this.f4446b;
    }

    public final boolean f(int i9) {
        return e(i9) != null;
    }

    public final boolean g(int i9, int i10) {
        boolean zOnStartNestedScroll;
        if (!f(i10)) {
            if (this.f4448d) {
                View view = this.f4447c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z8 = parent instanceof InterfaceC0429p;
                    if (z8) {
                        zOnStartNestedScroll = ((InterfaceC0429p) parent).onStartNestedScroll(view2, view, i9, i10);
                    } else if (i10 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i9);
                        } catch (AbstractMethodError e9) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e9);
                            zOnStartNestedScroll = false;
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i10 == 0) {
                            this.f4445a = parent;
                        } else if (i10 == 1) {
                            this.f4446b = parent;
                        }
                        if (z8) {
                            ((InterfaceC0429p) parent).onNestedScrollAccepted(view2, view, i9, i10);
                        } else if (i10 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i9);
                            } catch (AbstractMethodError e10) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e10);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i9) {
        ViewParent viewParentE = e(i9);
        if (viewParentE != null) {
            boolean z8 = viewParentE instanceof InterfaceC0429p;
            ViewGroup viewGroup = this.f4447c;
            if (z8) {
                ((InterfaceC0429p) viewParentE).onStopNestedScroll(viewGroup, i9);
            } else if (i9 == 0) {
                try {
                    viewParentE.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e9) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e9);
                }
            }
            if (i9 == 0) {
                this.f4445a = null;
            } else {
                if (i9 != 1) {
                    return;
                }
                this.f4446b = null;
            }
        }
    }
}
