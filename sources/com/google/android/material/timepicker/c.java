package com.google.android.material.timepicker;

import G.RunnableC0310a;
import H5.h;
import H5.j;
import H5.l;
import T.G;
import T.L;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.ikaile.ruoshui.client.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RadialViewGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends ConstraintLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RunnableC0310a f13983s;
    public int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f13984u;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i9, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC0310a runnableC0310a = this.f13983s;
            handler.removeCallbacks(runnableC0310a);
            handler.post(runnableC0310a);
        }
    }

    public void i() {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.b(this);
        HashMap map = new HashMap();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i10 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i10 == null) {
                    i10 = 1;
                }
                if (!map.containsKey(i10)) {
                    map.put(i10, new ArrayList());
                }
                ((List) map.get(i10)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.t * 0.66f) : this.t;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                HashMap<Integer, androidx.constraintlayout.widget.b.a> map2 = bVar.f6926c;
                if (!map2.containsKey(Integer.valueOf(id))) {
                    map2.put(Integer.valueOf(id), new androidx.constraintlayout.widget.b.a());
                }
                androidx.constraintlayout.widget.b.C0098b c0098b = map2.get(Integer.valueOf(id)).f6930d;
                c0098b.f6987w = R.id.circle_center;
                c0098b.f6988x = iRound;
                c0098b.f6989y = size;
                size += 360.0f / list.size();
            }
        }
        bVar.a(this);
        setConstraintSet(null);
        requestLayout();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        i();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC0310a runnableC0310a = this.f13983s;
            handler.removeCallbacks(runnableC0310a);
            handler.post(runnableC0310a);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i9) {
        this.f13984u.k(ColorStateList.valueOf(i9));
    }

    public c(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        h hVar = new h();
        this.f13984u = hVar;
        j jVar = new j(0.5f);
        l.a aVarE = hVar.f2420a.f2442a.e();
        aVarE.f2474e = jVar;
        aVarE.f2475f = jVar;
        aVarE.f2476g = jVar;
        aVarE.f2477h = jVar;
        hVar.setShapeAppearanceModel(aVarE.a());
        this.f13984u.k(ColorStateList.valueOf(-1));
        h hVar2 = this.f13984u;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setBackground(hVar2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p103n5.a.f20610x, i9, 0);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f13983s = new RunnableC0310a(4, this);
        typedArrayObtainStyledAttributes.recycle();
    }
}
