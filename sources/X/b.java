package X;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.E;

/* JADX INFO: compiled from: CursorFilter.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5118a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        Cursor cursor = (Cursor) obj;
        ((E) this.f5118a).getClass();
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex("suggest_intent_query");
        String string = null;
        if (columnIndex != -1) {
            try {
                string = cursor.getString(columnIndex);
            } catch (Exception e9) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e9);
            }
        }
        string.getClass();
        return string;
    }

    @Override // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        E e9 = (E) this.f5118a;
        if (charSequence != null) {
            e9.getClass();
            charSequence.toString();
        }
        e9.getClass();
        throw null;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f5118a;
        Cursor cursor = aVar.f5115b;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((E) aVar).c((Cursor) obj);
    }
}
