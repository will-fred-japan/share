package com.google.android.material.behavior;

import C5.c;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cn.ikaile.ruoshui.client.R;
import com.jieli.jl_bt_ota.constant.Command;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<a> f12899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f12902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimeInterpolator f12903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPropertyAnimator f12906h;

    public interface a {
        void a();
    }

    public HideBottomViewOnScrollBehavior() {
        this.f12899a = new LinkedHashSet<>();
        this.f12904f = 0;
        this.f12905g = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, V v5, int i9) {
        this.f12904f = v5.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v5.getLayoutParams()).bottomMargin;
        this.f12900b = c.c(v5.getContext(), R.attr.motionDurationLong2, Command.CMD_OTA_GET_DEVICE_UPDATE_FILE_INFO_OFFSET);
        this.f12901c = c.c(v5.getContext(), R.attr.motionDurationMedium4, 175);
        this.f12902d = c.d(v5.getContext(), R.attr.motionEasingEmphasizedInterpolator, p110o5.a.f20706d);
        this.f12903e = c.d(v5.getContext(), R.attr.motionEasingEmphasizedInterpolator, p110o5.a.f20705c);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
        LinkedHashSet<a> linkedHashSet = this.f12899a;
        if (i9 > 0) {
            if (this.f12905g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f12906h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f12905g = 1;
            Iterator<a> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f12906h = view.animate().translationY(this.f12904f).setInterpolator(this.f12903e).setDuration(this.f12901c).setListener(new p128q5.a(this));
            return;
        }
        if (i9 >= 0 || this.f12905g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f12906h;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f12905g = 2;
        Iterator<a> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.f12906h = view.animate().translationY(0).setInterpolator(this.f12902d).setDuration(this.f12900b).setListener(new p128q5.a(this));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i9, int i10) {
        return i9 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12899a = new LinkedHashSet<>();
        this.f12904f = 0;
        this.f12905g = 2;
    }
}
