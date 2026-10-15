package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.ikaile.ruoshui.client.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.material.datepicker.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0559g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f13307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13309c;

    public C0559g() {
        Calendar calendarG = G.g(null);
        this.f13307a = calendarG;
        this.f13308b = calendarG.getMaximum(7);
        this.f13309c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f13308b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i9) {
        int i10 = this.f13308b;
        if (i9 >= i10) {
            return null;
        }
        int i11 = i9 + this.f13309c;
        if (i11 > i10) {
            i11 -= i10;
        }
        return Integer.valueOf(i11);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i10 = i9 + this.f13309c;
        int i11 = this.f13308b;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f13307a;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public C0559g(int i9) {
        Calendar calendarG = G.g(null);
        this.f13307a = calendarG;
        this.f13308b = calendarG.getMaximum(7);
        this.f13309c = i9;
    }
}
