package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.z;

/* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialAutoCompleteTextView f13931a;

    public o(MaterialAutoCompleteTextView materialAutoCompleteTextView) {
        this.f13931a = materialAutoCompleteTextView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i9, long j) {
        Object item;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.f13931a;
        if (i9 < 0) {
            z zVar = materialAutoCompleteTextView.f13747e;
            item = !zVar.f6731z.isShowing() ? null : zVar.f6710c.getSelectedItem();
        } else {
            item = materialAutoCompleteTextView.getAdapter().getItem(i9);
        }
        MaterialAutoCompleteTextView.a(materialAutoCompleteTextView, item);
        AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
        z zVar2 = materialAutoCompleteTextView.f13747e;
        if (onItemClickListener != null) {
            if (view == null || i9 < 0) {
                view = zVar2.f6731z.isShowing() ? zVar2.f6710c.getSelectedView() : null;
                i9 = !zVar2.f6731z.isShowing() ? -1 : zVar2.f6710c.getSelectedItemPosition();
                j = !zVar2.f6731z.isShowing() ? Long.MIN_VALUE : zVar2.f6710c.getSelectedItemId();
            }
            onItemClickListener.onItemClick(zVar2.f6710c, view, i9, j);
        }
        zVar2.dismiss();
    }
}
