package androidx.core.widget;

import T.C0416c;
import T.InterfaceC0432t;
import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: TextViewOnReceiveContentListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements InterfaceC0432t {
    @Override // T.InterfaceC0432t
    public final C0416c a(View view, C0416c c0416c) {
        CharSequence charSequenceCoerceToStyledText;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c0416c);
        }
        if (c0416c.f4405a.d() == 2) {
            return c0416c;
        }
        C0416c.e eVar = c0416c.f4405a;
        ClipData clipDataA = eVar.a();
        int iB = eVar.b();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z8 = false;
        for (int i9 = 0; i9 < clipDataA.getItemCount(); i9++) {
            ClipData.Item itemAt = clipDataA.getItemAt(i9);
            if ((iB & 1) != 0) {
                charSequenceCoerceToStyledText = itemAt.coerceToText(context);
                if (charSequenceCoerceToStyledText instanceof Spanned) {
                    charSequenceCoerceToStyledText = charSequenceCoerceToStyledText.toString();
                }
            } else {
                charSequenceCoerceToStyledText = itemAt.coerceToStyledText(context);
            }
            if (charSequenceCoerceToStyledText != null) {
                if (z8) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceCoerceToStyledText);
                } else {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, iMax2);
                    editable.replace(iMax, iMax2, charSequenceCoerceToStyledText);
                    z8 = true;
                }
            }
        }
        return null;
    }
}
