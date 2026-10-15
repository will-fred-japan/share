package X;

import W5.e;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: compiled from: CursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cursor f5115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f5117d;

    public abstract void b(View view, Cursor cursor);

    public void c(Cursor cursor) {
        Cursor cursor2 = this.f5115b;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            this.f5115b = cursor;
            if (cursor != null) {
                this.f5116c = cursor.getColumnIndexOrThrow("_id");
                this.f5114a = true;
                notifyDataSetChanged();
            } else {
                this.f5116c = -1;
                this.f5114a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f5114a || (cursor = this.f5115b) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i9, View view, ViewGroup viewGroup) {
        if (!this.f5114a) {
            return null;
        }
        this.f5115b.moveToPosition(i9);
        if (view == null) {
            throw null;
        }
        b(view, this.f5115b);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f5117d == null) {
            b bVar = new b();
            bVar.f5118a = this;
            this.f5117d = bVar;
        }
        return this.f5117d;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i9) {
        Cursor cursor;
        if (!this.f5114a || (cursor = this.f5115b) == null) {
            return null;
        }
        cursor.moveToPosition(i9);
        return this.f5115b;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        Cursor cursor;
        if (this.f5114a && (cursor = this.f5115b) != null && cursor.moveToPosition(i9)) {
            return this.f5115b.getLong(this.f5116c);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i9, View view, ViewGroup viewGroup) {
        if (!this.f5114a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f5115b.moveToPosition(i9)) {
            throw new IllegalStateException(e.i(i9, "couldn't move cursor to position "));
        }
        if (view == null) {
            throw null;
        }
        b(view, this.f5115b);
        return view;
    }
}
