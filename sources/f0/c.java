package f0;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/* JADX INFO: compiled from: EmojiInputConnection.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f18650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18651b;

    /* JADX INFO: compiled from: EmojiInputConnection.java */
    public static class a {
        public static boolean a(c cVar, Editable editable, int i9, int i10, boolean z8) {
            int iMin;
            if (editable != null && i9 >= 0 && i10 >= 0) {
                int selectionStart = Selection.getSelectionStart(editable);
                int selectionEnd = Selection.getSelectionEnd(editable);
                if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                    if (z8) {
                        int iMax = Math.max(i9, 0);
                        int length = editable.length();
                        if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                            loop0: while (true) {
                                boolean z9 = false;
                                while (true) {
                                    if (iMax == 0) {
                                        break loop0;
                                    }
                                    selectionStart--;
                                    if (selectionStart < 0) {
                                        if (!z9) {
                                            selectionStart = 0;
                                            break loop0;
                                        }
                                        break loop0;
                                    }
                                    char cCharAt = editable.charAt(selectionStart);
                                    if (z9) {
                                        if (Character.isHighSurrogate(cCharAt)) {
                                            iMax--;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt)) {
                                        iMax--;
                                    } else if (!Character.isHighSurrogate(cCharAt)) {
                                        z9 = true;
                                    }
                                    selectionStart = -1;
                                    break loop0;
                                }
                            }
                        }
                        selectionStart = -1;
                        break loop0;
                        int iMax2 = Math.max(i10, 0);
                        iMin = editable.length();
                        if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                            loop2: while (true) {
                                boolean z10 = false;
                                while (true) {
                                    if (iMax2 != 0) {
                                        if (selectionEnd >= iMin) {
                                            if (!z10) {
                                                break loop2;
                                            }
                                            break loop2;
                                        }
                                        char cCharAt2 = editable.charAt(selectionEnd);
                                        if (z10) {
                                            if (Character.isLowSurrogate(cCharAt2)) {
                                                iMax2--;
                                                selectionEnd++;
                                            }
                                        } else if (!Character.isSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        } else if (!Character.isLowSurrogate(cCharAt2)) {
                                            selectionEnd++;
                                            z10 = true;
                                        }
                                        iMin = -1;
                                        break loop2;
                                    }
                                    iMin = selectionEnd;
                                    break loop2;
                                }
                            }
                        }
                        iMin = -1;
                        break loop2;
                        if (selectionStart != -1 && iMin != -1) {
                        }
                    } else {
                        selectionStart = Math.max(selectionStart - i9, 0);
                        iMin = Math.min(selectionEnd + i10, editable.length());
                    }
                    p022d0.h[] hVarArr = (p022d0.h[]) editable.getSpans(selectionStart, iMin, p022d0.h.class);
                    if (hVarArr != null && hVarArr.length > 0) {
                        for (p022d0.h hVar : hVarArr) {
                            int spanStart = editable.getSpanStart(hVar);
                            int spanEnd = editable.getSpanEnd(hVar);
                            selectionStart = Math.min(spanStart, selectionStart);
                            iMin = Math.max(spanEnd, iMin);
                        }
                        int iMax3 = Math.max(selectionStart, 0);
                        int iMin2 = Math.min(iMin, editable.length());
                        cVar.beginBatchEdit();
                        editable.delete(iMax3, iMin2);
                        cVar.endBatchEdit();
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public c(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        a aVar = new a();
        super(inputConnection, false);
        this.f18650a = editText;
        this.f18651b = aVar;
        if (androidx.emoji2.text.c.f7369k != null) {
            androidx.emoji2.text.c cVarA = androidx.emoji2.text.c.a();
            if (cVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.c.a aVar2 = cVarA.f7374e;
            aVar2.getClass();
            Bundle bundle = editorInfo.extras;
            p031e0.b bVar = aVar2.f7380c.f18468a;
            int iA = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? bVar.f18589b.getInt(iA + bVar.f18588a) : 0);
            Bundle bundle2 = editorInfo.extras;
            aVar2.f7381a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i9, int i10) {
        Editable editableText = this.f18650a.getEditableText();
        this.f18651b.getClass();
        return a.a(this, editableText, i9, i10, false) || super.deleteSurroundingText(i9, i10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i9, int i10) {
        Editable editableText = this.f18650a.getEditableText();
        this.f18651b.getClass();
        return a.a(this, editableText, i9, i10, true) || super.deleteSurroundingTextInCodePoints(i9, i10);
    }
}
