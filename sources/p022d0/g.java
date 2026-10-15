package p022d0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: EmojiProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.c.d f18452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f18453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p022d0.c f18454c;

    /* JADX INFO: compiled from: EmojiProcessor.java */
    public static class a implements b<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f18455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.emoji2.text.c.d f18456b;

        public a(m mVar, androidx.emoji2.text.c.d dVar) {
            this.f18455a = mVar;
            this.f18456b = dVar;
        }

        @Override // d0.g.b
        public final boolean a(CharSequence charSequence, int i9, int i10, k kVar) {
            if ((kVar.f18481c & 4) > 0) {
                return true;
            }
            if (this.f18455a == null) {
                this.f18455a = new m(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f18456b.getClass();
            this.f18455a.setSpan(new l(kVar), i9, i10, 33);
            return true;
        }

        @Override // d0.g.b
        public final m getResult() {
            return this.f18455a;
        }
    }

    /* JADX INFO: compiled from: EmojiProcessor.java */
    public interface b<T> {
        boolean a(CharSequence charSequence, int i9, int i10, k kVar);

        T getResult();
    }

    /* JADX INFO: compiled from: EmojiProcessor.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18458a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i.a f18459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i.a f18460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i.a f18461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f18462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18463f;

        public d(i.a aVar) {
            this.f18459b = aVar;
            this.f18460c = aVar;
        }

        public final void a() {
            this.f18458a = 1;
            this.f18460c = this.f18459b;
            this.f18463f = 0;
        }

        public final boolean b() {
            p031e0.a aVarB = this.f18460c.f18473b.b();
            int iA = aVarB.a(6);
            return !(iA == 0 || aVarB.f18589b.get(iA + aVarB.f18588a) == 0) || this.f18462e == 65039;
        }
    }

    public g(i iVar, androidx.emoji2.text.c.d dVar, p022d0.c cVar, Set set) {
        this.f18452a = dVar;
        this.f18453b = iVar;
        this.f18454c = cVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            c(str, 0, str.length(), 1, true, new c(str));
        }
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z8) {
        h[] hVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (hVarArr = (h[]) editable.getSpans(selectionStart, selectionEnd, h.class)) != null && hVarArr.length > 0) {
                for (h hVar : hVarArr) {
                    int spanStart = editable.getSpanStart(hVar);
                    int spanEnd = editable.getSpanEnd(hVar);
                    if ((z8 && spanStart == selectionStart) || ((!z8 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i9, int i10, k kVar) {
        if ((kVar.f18481c & 3) == 0) {
            p022d0.c cVar = this.f18454c;
            p031e0.a aVarB = kVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                aVarB.f18589b.getShort(iA + aVarB.f18588a);
            }
            cVar.getClass();
            ThreadLocal<StringBuilder> threadLocal = p022d0.c.f18449b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (i9 < i10) {
                sb.append(charSequence.charAt(i9));
                i9++;
            }
            boolean zHasGlyph = cVar.f18450a.hasGlyph(sb.toString());
            int i11 = kVar.f18481c & 4;
            kVar.f18481c = zHasGlyph ? i11 | 2 : i11 | 1;
        }
        return (kVar.f18481c & 3) == 2;
    }

    public final <T> T c(CharSequence charSequence, int i9, int i10, int i11, boolean z8, b<T> bVar) {
        int i12;
        char c5;
        d dVar = new d(this.f18453b.f18470c);
        int iCodePointAt = Character.codePointAt(charSequence, i9);
        boolean zA = true;
        int i13 = 0;
        int iCharCount = i9;
        loop0: while (true) {
            i12 = iCharCount;
            while (true) {
                if (iCharCount < i10 && i13 < i11 && zA) {
                    SparseArray<i.a> sparseArray = dVar.f18460c.f18472a;
                    i.a aVar = sparseArray == null ? null : sparseArray.get(iCodePointAt);
                    if (dVar.f18458a == 2) {
                        if (aVar != null) {
                            dVar.f18460c = aVar;
                            dVar.f18463f++;
                        } else {
                            if (iCodePointAt == 65038) {
                                dVar.a();
                            } else if (iCodePointAt != 65039) {
                                i.a aVar2 = dVar.f18460c;
                                if (aVar2.f18473b != null) {
                                    if (dVar.f18463f != 1) {
                                        dVar.f18461d = aVar2;
                                        dVar.a();
                                    } else if (dVar.b()) {
                                        dVar.f18461d = dVar.f18460c;
                                        dVar.a();
                                    } else {
                                        dVar.a();
                                    }
                                    c5 = 3;
                                } else {
                                    dVar.a();
                                }
                            }
                            c5 = 1;
                        }
                        c5 = 2;
                    } else if (aVar == null) {
                        dVar.a();
                        c5 = 1;
                    } else {
                        dVar.f18458a = 2;
                        dVar.f18460c = aVar;
                        dVar.f18463f = 1;
                        c5 = 2;
                    }
                    dVar.f18462e = iCodePointAt;
                    if (c5 == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i12)) + i12;
                        if (iCharCount >= i10) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c5 == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i10) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c5 == 3) {
                        if (!z8 && b(charSequence, i12, iCharCount, dVar.f18461d.f18473b)) {
                            break;
                        }
                        zA = bVar.a(charSequence, i12, iCharCount, dVar.f18461d.f18473b);
                        i13++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (dVar.f18458a == 2 && dVar.f18460c.f18473b != null && ((dVar.f18463f > 1 || dVar.b()) && i13 < i11 && zA && (z8 || !b(charSequence, i12, iCharCount, dVar.f18460c.f18473b)))) {
            bVar.a(charSequence, i12, iCharCount, dVar.f18460c.f18473b);
        }
        return bVar.getResult();
    }

    /* JADX INFO: compiled from: EmojiProcessor.java */
    public static class c implements b<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18457a;

        public c(String str) {
            this.f18457a = str;
        }

        @Override // d0.g.b
        public final boolean a(CharSequence charSequence, int i9, int i10, k kVar) {
            if (!TextUtils.equals(charSequence.subSequence(i9, i10), this.f18457a)) {
                return true;
            }
            kVar.f18481c = (kVar.f18481c & 3) | 4;
            return false;
        }

        @Override // d0.g.b
        public final c getResult() {
            return this;
        }
    }
}
