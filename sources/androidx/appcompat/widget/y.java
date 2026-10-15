package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: ListPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public final class y implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f6705a;

    public y(z zVar) {
        this.f6705a = zVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i9, long j) {
        v vVar;
        if (i9 == -1 || (vVar = this.f6705a.f6710c) == null) {
            return;
        }
        vVar.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
