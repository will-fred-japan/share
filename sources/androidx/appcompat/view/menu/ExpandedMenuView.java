package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.K;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, k, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f6052b = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f6053a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        K kE = K.e(context, attributeSet, f6052b, R.attr.listViewStyle);
        TypedArray typedArray = kE.f6420b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(kE.b(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(kE.b(1));
        }
        kE.f();
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(h hVar) {
        return this.f6053a.q(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public final void b(f fVar) {
        this.f6053a = fVar;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j) {
        a((h) getAdapter().getItem(i9));
    }
}
