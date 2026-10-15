package com.google.android.material.datepicker;

import T.C0414a;
import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public final class j<S> extends z<S> {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f13314V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public DateSelector<S> f13315W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public CalendarConstraints f13316X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public DayViewDecorator f13317Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public Month f13318Z;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public d f13319l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public C0554b f13320m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public RecyclerView f13321n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public RecyclerView f13322o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public View f13323p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public View f13324q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public View f13325r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public View f13326s0;

    /* JADX INFO: compiled from: MaterialCalendar.java */
    public class a extends C0414a {
        @Override // T.C0414a
        public final void d(View view, U.f fVar) {
            View.AccessibilityDelegate accessibilityDelegate = this.f4401a;
            AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCollectionInfo(null);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    public class b extends E {

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public final /* synthetic */ int f13327E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i9, int i10) {
            super(i9);
            this.f13327E = i10;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void A0(RecyclerView.v vVar, int[] iArr) {
            int i9 = this.f13327E;
            j jVar = j.this;
            if (i9 == 0) {
                iArr[0] = jVar.f13322o0.getWidth();
                iArr[1] = jVar.f13322o0.getWidth();
            } else {
                iArr[0] = jVar.f13322o0.getHeight();
                iArr[1] = jVar.f13322o0.getHeight();
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    public class c {
        public c() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: MaterialCalendar.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f13331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ d[] f13332c;

        static {
            d dVar = new d("DAY", 0);
            f13330a = dVar;
            d dVar2 = new d("YEAR", 1);
            f13331b = dVar2;
            f13332c = new d[]{dVar, dVar2};
        }

        public d() {
            throw null;
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f13332c.clone();
        }
    }

    @Override // com.google.android.material.datepicker.z
    public final void B(r.c cVar) {
        this.f13397U.add(cVar);
    }

    public final void C(Month month) {
        x xVar = (x) this.f13322o0.getAdapter();
        int iD = xVar.f13391c.f13247a.d(month);
        int iD2 = iD - xVar.f13391c.f13247a.d(this.f13318Z);
        boolean z8 = Math.abs(iD2) > 3;
        boolean z9 = iD2 > 0;
        this.f13318Z = month;
        if (z8 && z9) {
            this.f13322o0.Z(iD - 3);
            this.f13322o0.post(new RunnableC0561i(this, iD));
        } else if (!z8) {
            this.f13322o0.post(new RunnableC0561i(this, iD));
        } else {
            this.f13322o0.Z(iD + 3);
            this.f13322o0.post(new RunnableC0561i(this, iD));
        }
    }

    public final void D(d dVar) {
        this.f13319l0 = dVar;
        if (dVar == d.f13331b) {
            this.f13321n0.getLayoutManager().n0(this.f13318Z.f13271c - ((I) this.f13321n0.getAdapter()).f13266c.f13316X.f13247a.f13271c);
            this.f13325r0.setVisibility(0);
            this.f13326s0.setVisibility(8);
            this.f13323p0.setVisibility(8);
            this.f13324q0.setVisibility(8);
            return;
        }
        if (dVar == d.f13330a) {
            this.f13325r0.setVisibility(8);
            this.f13326s0.setVisibility(0);
            this.f13323p0.setVisibility(0);
            this.f13324q0.setVisibility(0);
            C(this.f13318Z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void n(Bundle bundle) {
        super.n(bundle);
        if (bundle == null) {
            bundle = this.f7465f;
        }
        this.f13314V = bundle.getInt("THEME_RES_ID_KEY");
        this.f13315W = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f13316X = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f13317Y = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f13318Z = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View o(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i9;
        int i10;
        androidx.recyclerview.widget.u uVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(d(), this.f13314V);
        this.f13320m0 = new C0554b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.f13316X.f13247a;
        if (r.F(contextThemeWrapper, R.attr.windowFullscreen)) {
            i9 = cn.ikaile.ruoshui.client.R.layout.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i9 = cn.ikaile.ruoshui.client.R.layout.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i9, viewGroup, false);
        Resources resources = x().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_days_of_week_height);
        int i11 = v.f13381g;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_month_vertical_padding) * (i11 - 1)) + (resources.getDimensionPixelSize(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_day_height) * i11) + resources.getDimensionPixelOffset(cn.ikaile.ruoshui.client.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.mtrl_calendar_days_of_week);
        T.G.m(gridView, new a());
        int i12 = this.f13316X.f13251e;
        gridView.setAdapter((ListAdapter) (i12 > 0 ? new C0559g(i12) : new C0559g()));
        gridView.setNumColumns(month.f13272d);
        gridView.setEnabled(false);
        this.f13322o0 = (RecyclerView) viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.mtrl_calendar_months);
        this.f13322o0.setLayoutManager(new b(i10, i10));
        this.f13322o0.setTag("MONTHS_VIEW_GROUP_TAG");
        x xVar = new x(contextThemeWrapper, this.f13315W, this.f13316X, this.f13317Y, new c());
        this.f13322o0.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(cn.ikaile.ruoshui.client.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.mtrl_calendar_year_selector_frame);
        this.f13321n0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f13321n0.setLayoutManager(new GridLayoutManager(integer));
            this.f13321n0.setAdapter(new I(this));
            this.f13321n0.g(new l(this));
        }
        if (viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            T.G.m(materialButton, new m(0, this));
            View viewFindViewById = viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.month_navigation_previous);
            this.f13323p0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.month_navigation_next);
            this.f13324q0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f13325r0 = viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.mtrl_calendar_year_selector_frame);
            this.f13326s0 = viewInflate.findViewById(cn.ikaile.ruoshui.client.R.id.mtrl_calendar_day_selector_frame);
            D(d.f13330a);
            materialButton.setText(this.f13318Z.c());
            this.f13322o0.h(new n(this, xVar, materialButton));
            materialButton.setOnClickListener(new o(this));
            this.f13324q0.setOnClickListener(new p(this, xVar));
            this.f13323p0.setOnClickListener(new ViewOnClickListenerC0560h(this, xVar));
        }
        if (!r.F(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (uVar = new androidx.recyclerview.widget.u()).f7908a) != (recyclerView = this.f13322o0)) {
            androidx.recyclerview.widget.A.a aVar = uVar.f7909b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f8020p0;
                if (arrayList != null) {
                    arrayList.remove(aVar);
                }
                uVar.f7908a.setOnFlingListener(null);
            }
            uVar.f7908a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                uVar.f7908a.h(aVar);
                uVar.f7908a.setOnFlingListener(uVar);
                new Scroller(uVar.f7908a.getContext(), new DecelerateInterpolator());
                uVar.b();
            }
        }
        this.f13322o0.Z(xVar.f13391c.f13247a.d(this.f13318Z));
        T.G.m(this.f13322o0, new k());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void s(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f13314V);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f13315W);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f13316X);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f13317Y);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f13318Z);
    }
}
