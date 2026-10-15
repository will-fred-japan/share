package com.google.android.material.transformation;

import T.G;
import T.L;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p202z5.a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    public ExpandableBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean b(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ((a) view2).a();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        a aVar;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        if (!view.isLaidOut()) {
            ArrayList arrayListD = coordinatorLayout.d(view);
            int size = arrayListD.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = (View) arrayListD.get(i10);
                if (b(view, view2)) {
                    aVar = (a) view2;
                    break;
                }
                i10++;
            }
            if (aVar != null) {
                aVar.a();
                throw null;
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
