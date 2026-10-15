package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.ikaile.ruoshui.client.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class v extends BaseAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13381g = G.g(null).getMaximum(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13382h = (G.g(null).getMaximum(7) + G.g(null).getMaximum(5)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f13383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f13384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Collection<Long> f13385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0554b f13386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f13387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f13388f;

    public v(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f13383a = month;
        this.f13384b = dateSelector;
        this.f13387e = calendarConstraints;
        this.f13388f = dayViewDecorator;
        this.f13385c = dateSelector.x();
    }

    public final int b() {
        int firstDayOfWeek = this.f13387e.f13251e;
        Month month = this.f13383a;
        Calendar calendar = month.f13269a;
        int i9 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i10 = i9 - firstDayOfWeek;
        return i10 < 0 ? i10 + month.f13272d : i10;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i9) {
        if (i9 < b() || i9 > d()) {
            return null;
        }
        int iB = (i9 - b()) + 1;
        Calendar calendarC = G.c(this.f13383a.f13269a);
        calendarC.set(5, iB);
        return Long.valueOf(calendarC.getTimeInMillis());
    }

    public final int d() {
        return (b() + this.f13383a.f13273e) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(TextView textView, long j, int i9) {
        boolean z8;
        boolean z9;
        C0553a c0553a;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z10 = false;
        boolean z11 = G.f().getTimeInMillis() == j;
        DateSelector<?> dateSelector = this.f13384b;
        Iterator it = dateSelector.u().iterator();
        while (true) {
            if (!it.hasNext()) {
                z8 = false;
                break;
            }
            F f6 = ((S.b) it.next()).f4087a;
            if (f6 != 0 && ((Long) f6).longValue() == j) {
                z8 = true;
                break;
            }
        }
        Iterator it2 = dateSelector.u().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z9 = false;
                break;
            }
            S s8 = ((S.b) it2.next()).f4088b;
            if (s8 != 0 && ((Long) s8).longValue() == j) {
                z9 = true;
                break;
            }
        }
        Calendar calendarF = G.f();
        Calendar calendarG = G.g(null);
        calendarG.setTimeInMillis(j);
        String str = calendarF.get(1) == calendarG.get(1) ? G.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j)) : G.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j));
        if (z11) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z8) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z9) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        textView.setContentDescription(str);
        if (this.f13387e.f13249c.i(j)) {
            textView.setEnabled(true);
            Iterator it3 = dateSelector.x().iterator();
            while (it3.hasNext()) {
                if (G.a(j) == G.a(((Long) it3.next()).longValue())) {
                    z10 = true;
                    break;
                }
            }
            textView.setSelected(z10);
            if (z10) {
                c0553a = this.f13386d.f13289b;
            } else {
                c0553a = G.f().getTimeInMillis() == j ? this.f13386d.f13290c : this.f13386d.f13288a;
            }
        } else {
            textView.setEnabled(false);
            c0553a = this.f13386d.f13294g;
        }
        if (this.f13388f == null || i9 == -1) {
            c0553a.b(textView);
            return;
        }
        int i10 = this.f13383a.f13271c;
        c0553a.b(textView);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setContentDescription(str);
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j) {
        Month monthB = Month.b(j);
        Month month = this.f13383a;
        if (monthB.equals(month)) {
            Calendar calendarC = G.c(month.f13269a);
            calendarC.setTimeInMillis(j);
            int i9 = calendarC.get(5);
            e((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().b() + (i9 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j, i9);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f13382h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return i9 / this.f13383a.f13272d;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d  */
    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        int i10;
        Context context = viewGroup.getContext();
        if (this.f13386d == null) {
            this.f13386d = new C0554b(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i9 - b();
        if (iB >= 0) {
            Month month = this.f13383a;
            if (iB >= month.f13273e) {
                textView.setVisibility(8);
                textView.setEnabled(false);
                i10 = -1;
            } else {
                i10 = iB + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i10)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
            i10 = -1;
        }
        Long item = getItem(i9);
        if (item == null) {
            return textView;
        }
        e(textView, item.longValue(), i10);
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
