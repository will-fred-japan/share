package f0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: EmojiInputFilter.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f18652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f18653b;

    /* JADX INFO: compiled from: EmojiInputFilter.java */
    public static class a extends androidx.emoji2.text.c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f18654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f18655b;

        public a(TextView textView, d dVar) {
            this.f18654a = new WeakReference(textView);
            this.f18655b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.c.e
        public final void b() throws Throwable {
            InputFilter[] filters;
            int length;
            TextView textView = (TextView) this.f18654a.get();
            InputFilter inputFilter = (InputFilter) this.f18655b.get();
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        CharSequence text = textView.getText();
                        androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
                        if (text == null) {
                            length = 0;
                        } else {
                            cVarA.getClass();
                            length = text.length();
                        }
                        CharSequence charSequenceE = cVarA.e(text, 0, length);
                        if (text == charSequenceE) {
                            return;
                        }
                        int selectionStart = Selection.getSelectionStart(charSequenceE);
                        int selectionEnd = Selection.getSelectionEnd(charSequenceE);
                        textView.setText(charSequenceE);
                        if (charSequenceE instanceof Spannable) {
                            Spannable spannable = (Spannable) charSequenceE;
                            if (selectionStart >= 0 && selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionStart, selectionEnd);
                                return;
                            } else if (selectionStart >= 0) {
                                Selection.setSelection(spannable, selectionStart);
                                return;
                            } else {
                                if (selectionEnd >= 0) {
                                    Selection.setSelection(spannable, selectionEnd);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public d(TextView textView) {
        this.f18652a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i9, int i10, Spanned spanned, int i11, int i12) {
        TextView textView = this.f18652a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = androidx.emoji2.text.c.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i12 == 0 && i11 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i9 != 0 || i10 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i9, i10);
                }
                return androidx.emoji2.text.c.a().e(charSequence, 0, charSequence.length());
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
        if (this.f18653b == null) {
            this.f18653b = new a(textView, this);
        }
        cVarA.f(this.f18653b);
        return charSequence;
    }
}
