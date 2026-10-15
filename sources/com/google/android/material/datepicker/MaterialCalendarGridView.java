package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f13267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13268b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f13267a = G.g(null);
        if (r.F(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(cn.ikaile.ruoshui.client.R.id.cancel_button);
            setNextFocusRightId(cn.ikaile.ruoshui.client.R.id.confirm_button);
        }
        this.f13268b = r.F(getContext(), cn.ikaile.ruoshui.client.R.attr.nestedScrollable);
        T.G.m(this, new q());
    }

    public final v a() {
        return (v) super.getAdapter();
    }

    public final View b(int i9) {
        return getChildAt(i9 - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (v) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((v) super.getAdapter()).notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iB;
        int width;
        int iB2;
        int width2;
        int i9;
        int width3;
        int right;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        v vVar = (v) super.getAdapter();
        DateSelector<?> dateSelector = vVar.f13384b;
        C0554b c0554b = vVar.f13386d;
        int iMax = Math.max(vVar.b(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(vVar.d(), materialCalendarGridView.getLastVisiblePosition());
        Long item = vVar.getItem(iMax);
        Long item2 = vVar.getItem(iMin);
        Iterator it = dateSelector.u().iterator();
        while (it.hasNext()) {
            S.b bVar = (S.b) it.next();
            F f6 = bVar.f4087a;
            if (f6 != 0) {
                S s8 = bVar.f4088b;
                if (s8 != 0) {
                    Long l8 = (Long) f6;
                    long jLongValue = l8.longValue();
                    Long l9 = (Long) s8;
                    long jLongValue2 = l9.longValue();
                    if (item == null || item2 == null || l8.longValue() > item2.longValue() || l9.longValue() < item.longValue()) {
                        materialCalendarGridView = this;
                        vVar = vVar;
                        it = it;
                    } else {
                        boolean zC = com.google.android.material.internal.l.c(materialCalendarGridView);
                        long jLongValue3 = item.longValue();
                        Calendar calendar = materialCalendarGridView.f13267a;
                        Month month = vVar.f13383a;
                        if (jLongValue < jLongValue3) {
                            if (iMax % month.f13272d == 0) {
                                right = 0;
                            } else {
                                right = !zC ? materialCalendarGridView.b(iMax - 1).getRight() : materialCalendarGridView.b(iMax - 1).getLeft();
                            }
                            width = right;
                            iB = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iB = vVar.b() + (calendar.get(5) - 1);
                            View viewB = materialCalendarGridView.b(iB);
                            width = (viewB.getWidth() / 2) + viewB.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            if ((iMin + 1) % month.f13272d == 0) {
                                width2 = materialCalendarGridView.getWidth();
                            } else {
                                width2 = !zC ? materialCalendarGridView.b(iMin).getRight() : materialCalendarGridView.b(iMin).getLeft();
                            }
                            iB2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iB2 = vVar.b() + (calendar.get(5) - 1);
                            View viewB2 = materialCalendarGridView.b(iB2);
                            width2 = (viewB2.getWidth() / 2) + viewB2.getLeft();
                        }
                        int itemId = (int) vVar.getItemId(iB);
                        int itemId2 = (int) vVar.getItemId(iB2);
                        while (itemId <= itemId2) {
                            int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                            v vVar2 = vVar;
                            int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                            View viewB3 = materialCalendarGridView.b(numColumns);
                            int top = viewB3.getTop() + c0554b.f13288a.f13282a.top;
                            Iterator it2 = it;
                            int bottom = viewB3.getBottom() - c0554b.f13288a.f13282a.bottom;
                            if (zC) {
                                int i10 = iB2 > numColumns2 ? 0 : width2;
                                int width4 = numColumns > iB ? getWidth() : width;
                                i9 = i10;
                                width3 = width4;
                            } else {
                                i9 = numColumns > iB ? 0 : width;
                                width3 = iB2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i9, top, width3, bottom, c0554b.f13295h);
                            itemId++;
                            materialCalendarGridView = this;
                            vVar = vVar2;
                            it = it2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        if (!z8) {
            super.onFocusChanged(false, i9, rect);
            return;
        }
        if (i9 == 33) {
            setSelection(((v) super.getAdapter()).d());
        } else if (i9 == 130) {
            setSelection(((v) super.getAdapter()).b());
        } else {
            super.onFocusChanged(true, i9, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        if (!super.onKeyDown(i9, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((v) super.getAdapter()).b()) {
            return true;
        }
        if (19 != i9) {
            return false;
        }
        setSelection(((v) super.getAdapter()).b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i9, int i10) {
        if (!this.f13268b) {
            super.onMeasure(i9, i10);
            return;
        }
        super.onMeasure(i9, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i9) {
        if (i9 < ((v) super.getAdapter()).b()) {
            super.setSelection(((v) super.getAdapter()).b());
        } else {
            super.setSelection(i9);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (v) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof v)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
