package f0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: EmojiTextWatcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f18663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f18664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18665c = true;

    /* JADX INFO: compiled from: EmojiTextWatcher.java */
    public static class a extends androidx.emoji2.text.c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f18666a;

        public a(EditText editText) {
            this.f18666a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.e
        public final void b() throws Throwable {
            g.a((EditText) this.f18666a.get(), 1);
        }
    }

    public g(EditText editText) {
        this.f18663a = editText;
    }

    public static void a(EditText editText, int i9) throws Throwable {
        int length;
        if (i9 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
            if (editableText == null) {
                length = 0;
            } else {
                cVarA.getClass();
                length = editableText.length();
            }
            cVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) throws Throwable {
        EditText editText = this.f18663a;
        if (editText.isInEditMode() || !this.f18665c || androidx.emoji2.text.c.f7369k == null || i10 > i11 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = androidx.emoji2.text.c.a().b();
        if (iB != 0) {
            if (iB == 1) {
                androidx.emoji2.text.c.a().e((Spannable) charSequence, i9, i11 + i9);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
        if (this.f18664b == null) {
            this.f18664b = new a(editText);
        }
        cVarA.f(this.f18664b);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
    }
}
