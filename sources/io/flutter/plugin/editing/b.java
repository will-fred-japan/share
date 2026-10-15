package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import p088l7.w;

/* JADX INFO: compiled from: ListenableEditingState.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19518a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19519b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<InterfaceC0217b> f19520c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<InterfaceC0217b> f19521d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<e> f19522e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19526i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f19528l;

    /* JADX INFO: compiled from: ListenableEditingState.java */
    public class a extends BaseInputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19529a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, b bVar) {
            super(view, true);
            this.f19529a = bVar;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public final Editable getEditable() {
            return this.f19529a;
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugin.editing.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ListenableEditingState.java */
    public interface InterfaceC0217b {
        void a(boolean z8);
    }

    public b(w.d dVar, View view) {
        this.f19528l = new a(view, this);
        if (dVar != null) {
            f(dVar);
        }
    }

    public final void a(InterfaceC0217b interfaceC0217b) {
        if (this.f19519b > 0) {
            Log.e("ListenableEditingState", "adding a listener " + interfaceC0217b.toString() + " in a listener callback");
        }
        if (this.f19518a <= 0) {
            this.f19520c.add(interfaceC0217b);
        } else {
            Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.f19521d.add(interfaceC0217b);
        }
    }

    public final void b() {
        this.f19518a++;
        if (this.f19519b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f19518a != 1 || this.f19520c.isEmpty()) {
            return;
        }
        this.f19524g = toString();
        this.f19525h = Selection.getSelectionStart(this);
        this.f19526i = Selection.getSelectionEnd(this);
        this.j = BaseInputConnection.getComposingSpanStart(this);
        this.f19527k = BaseInputConnection.getComposingSpanEnd(this);
    }

    public final void c() {
        int i9 = this.f19518a;
        if (i9 == 0) {
            Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        ArrayList<InterfaceC0217b> arrayList = this.f19520c;
        ArrayList<InterfaceC0217b> arrayList2 = this.f19521d;
        if (i9 == 1) {
            for (InterfaceC0217b interfaceC0217b : arrayList2) {
                this.f19519b++;
                interfaceC0217b.a(true);
                this.f19519b--;
            }
            if (!arrayList.isEmpty()) {
                arrayList.size();
                d(!toString().equals(this.f19524g), (this.f19525h == Selection.getSelectionStart(this) && this.f19526i == Selection.getSelectionEnd(this)) ? false : true, (this.j == BaseInputConnection.getComposingSpanStart(this) && this.f19527k == BaseInputConnection.getComposingSpanEnd(this)) ? false : true);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2.clear();
        this.f19518a--;
    }

    public final void d(boolean z8, boolean z9, boolean z10) {
        if (z8 || z9 || z10) {
            for (InterfaceC0217b interfaceC0217b : this.f19520c) {
                this.f19519b++;
                interfaceC0217b.a(z8);
                this.f19519b--;
            }
        }
    }

    public final void e(InterfaceC0217b interfaceC0217b) {
        if (this.f19519b > 0) {
            Log.e("ListenableEditingState", "removing a listener " + interfaceC0217b.toString() + " in a listener callback");
        }
        this.f19520c.remove(interfaceC0217b);
        if (this.f19518a > 0) {
            this.f19521d.remove(interfaceC0217b);
        }
    }

    public final void f(w.d dVar) {
        int i9;
        b();
        replace(0, length(), (CharSequence) dVar.f20236a);
        int i10 = dVar.f20237b;
        if (i10 >= 0) {
            Selection.setSelection(this, i10, dVar.f20238c);
        } else {
            Selection.removeSelection(this);
        }
        int i11 = dVar.f20239d;
        if (i11 < 0 || i11 >= (i9 = dVar.f20240e)) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f19528l.setComposingRegion(i11, i9);
        }
        this.f19522e.clear();
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        super.setSpan(obj, i9, i10, i11);
        ArrayList<e> arrayList = this.f19522e;
        String string = toString();
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        e eVar = new e();
        eVar.f19540e = selectionStart;
        eVar.f19541f = selectionEnd;
        eVar.f19542g = composingSpanStart;
        eVar.f19543h = composingSpanEnd;
        eVar.f19536a = string;
        eVar.f19537b = "";
        eVar.f19538c = -1;
        eVar.f19539d = -1;
        arrayList.add(eVar);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final String toString() {
        String str = this.f19523f;
        if (str != null) {
            return str;
        }
        String string = super.toString();
        this.f19523f = string;
        return string;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i9, int i10, CharSequence charSequence, int i11, int i12) {
        if (this.f19519b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String string = toString();
        int i13 = i10 - i9;
        boolean z8 = i13 != i12 - i11;
        for (int i14 = 0; i14 < i13 && !z8; i14++) {
            z8 |= charAt(i9 + i14) != charSequence.charAt(i11 + i14);
        }
        if (z8) {
            this.f19523f = null;
        }
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        SpannableStringBuilder spannableStringBuilderReplace = super.replace(i9, i10, charSequence, i11, i12);
        ArrayList<e> arrayList = this.f19522e;
        int selectionStart2 = Selection.getSelectionStart(this);
        int selectionEnd2 = Selection.getSelectionEnd(this);
        int composingSpanStart2 = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd2 = BaseInputConnection.getComposingSpanEnd(this);
        e eVar = new e();
        eVar.f19540e = selectionStart2;
        eVar.f19541f = selectionEnd2;
        eVar.f19542g = composingSpanStart2;
        eVar.f19543h = composingSpanEnd2;
        String string2 = charSequence.toString();
        eVar.f19536a = string;
        eVar.f19537b = string2;
        eVar.f19538c = i9;
        eVar.f19539d = i10;
        arrayList.add(eVar);
        if (this.f19518a > 0) {
            return spannableStringBuilderReplace;
        }
        d(z8, (Selection.getSelectionStart(this) == selectionStart && Selection.getSelectionEnd(this) == selectionEnd) ? false : true, (BaseInputConnection.getComposingSpanStart(this) == composingSpanStart && BaseInputConnection.getComposingSpanEnd(this) == composingSpanEnd) ? false : true);
        return spannableStringBuilderReplace;
    }
}
