package com.google.android.material.datepicker;

import android.view.View;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f13341a;

    public o(j jVar) {
        this.f13341a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.f13341a;
        j.d dVar = jVar.f13319l0;
        j.d dVar2 = j.d.f13331b;
        j.d dVar3 = j.d.f13330a;
        if (dVar == dVar2) {
            jVar.D(dVar3);
        } else if (dVar == dVar3) {
            jVar.D(dVar2);
        }
    }
}
