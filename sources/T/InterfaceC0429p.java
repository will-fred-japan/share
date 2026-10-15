package T;

import android.view.View;

/* JADX INFO: renamed from: T.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: NestedScrollingParent2.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0429p {
    void onNestedPreScroll(View view, int i9, int i10, int[] iArr, int i11);

    void onNestedScroll(View view, int i9, int i10, int i11, int i12, int i13);

    void onNestedScrollAccepted(View view, View view2, int i9, int i10);

    boolean onStartNestedScroll(View view, View view2, int i9, int i10);

    void onStopNestedScroll(View view, int i9);
}
