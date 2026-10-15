package androidx.appcompat.widget;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: SuggestionsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class E extends X.c implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6405i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6406k;

    /* JADX INFO: compiled from: SuggestionsAdapter.java */
    public static final class a {
    }

    public E() {
        throw null;
    }

    @Override // X.a
    public final void b(View view, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i9 = this.f6406k;
        int i10 = i9 != -1 ? cursor.getInt(i9) : 0;
        aVar.getClass();
        int i11 = this.f6401e;
        if (i11 != 2 && (i11 != 1 || (i10 & 1) == 0)) {
            throw null;
        }
        throw null;
    }

    @Override // X.a
    public final void c(Cursor cursor) {
        try {
            super.c(cursor);
            if (cursor != null) {
                this.f6402f = cursor.getColumnIndex("suggest_text_1");
                this.f6403g = cursor.getColumnIndex("suggest_text_2");
                this.f6404h = cursor.getColumnIndex("suggest_text_2_url");
                this.f6405i = cursor.getColumnIndex("suggest_icon_1");
                this.j = cursor.getColumnIndex("suggest_icon_2");
                this.f6406k = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e9) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e9);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable d(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L23
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L23
            java.lang.String r1 = "0"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L12
            goto L23
        L12:
            java.lang.Integer.parseInt(r3)     // Catch: android.content.res.Resources.NotFoundException -> L16 java.lang.NumberFormatException -> L22
            throw r0
        L16:
            java.lang.String r1 = "Icon resource not found: "
            java.lang.String r3 = r1.concat(r3)
            java.lang.String r1 = "SuggestionsAdapter"
            android.util.Log.w(r1, r3)
            return r0
        L22:
            throw r0
        L23:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.E.d(java.lang.String):android.graphics.drawable.Drawable");
    }

    @Override // X.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i9, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i9, view, viewGroup);
        } catch (RuntimeException e9) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e9);
            throw null;
        }
    }

    @Override // X.a, android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        try {
            super.getView(i9, view, viewGroup);
            return view;
        } catch (RuntimeException e9) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e9);
            throw null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f5115b;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f5115b;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getTag() instanceof CharSequence) {
            throw null;
        }
    }
}
