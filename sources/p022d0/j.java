package p022d0;

import A1.b;
import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SpannableBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f18474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f18475b;

    /* JADX INFO: compiled from: SpannableBuilder.java */
    public static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f18477b = new AtomicInteger(0);

        public a(Object obj) {
            this.f18476a = obj;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f18476a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            ((TextWatcher) this.f18476a).beforeTextChanged(charSequence, i9, i10, i11);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable spannable, Object obj, int i9, int i10) {
            if (this.f18477b.get() <= 0 || !(obj instanceof h)) {
                ((SpanWatcher) this.f18476a).onSpanAdded(spannable, obj, i9, i10);
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001c A[PHI: r11
  0x001c: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0011, B:12:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable spannable, Object obj, int i9, int i10, int i11, int i12) {
            int i13;
            int i14;
            if (this.f18477b.get() <= 0 || !(obj instanceof h)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    i13 = i9;
                    i14 = i11;
                } else {
                    if (i9 > i10) {
                        i9 = 0;
                    }
                    if (i11 > i12) {
                        i13 = i9;
                        i14 = 0;
                    } else {
                        i13 = i9;
                        i14 = i11;
                    }
                }
                ((SpanWatcher) this.f18476a).onSpanChanged(spannable, obj, i13, i10, i14, i12);
            }
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable spannable, Object obj, int i9, int i10) {
            if (this.f18477b.get() <= 0 || !(obj instanceof h)) {
                ((SpanWatcher) this.f18476a).onSpanRemoved(spannable, obj, i9, i10);
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            ((TextWatcher) this.f18476a).onTextChanged(charSequence, i9, i10, i11);
        }
    }

    public j(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.f18475b = new ArrayList();
        b.K0(cls, "watcherClass cannot be null");
        this.f18474a = cls;
    }

    public final void a() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f18475b;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i9)).f18477b.incrementAndGet();
            i9++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f18475b;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i9)).onTextChanged(this, 0, length(), length());
            i9++;
        }
    }

    public final a c(Object obj) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f18475b;
            if (i9 >= arrayList.size()) {
                return null;
            }
            a aVar = (a) arrayList.get(i9);
            if (aVar.f18476a == obj) {
                return aVar;
            }
            i9++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f18474a == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable delete(int i9, int i10) {
        super.delete(i9, i10);
        return this;
    }

    public final void e() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f18475b;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i9)).f18477b.decrementAndGet();
            i9++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        a aVarC;
        if (d(obj) && (aVarC = c(obj)) != null) {
            obj = aVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        a aVarC;
        if (d(obj) && (aVarC = c(obj)) != null) {
            obj = aVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        a aVarC;
        if (d(obj) && (aVarC = c(obj)) != null) {
            obj = aVarC;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public final <T> T[] getSpans(int i9, int i10, Class<T> cls) {
        if (this.f18474a != cls) {
            return (T[]) super.getSpans(i9, i10, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i9, i10, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            tArr[i11] = aVarArr[i11].f18476a;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int i9, CharSequence charSequence) {
        super.insert(i9, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i9, int i10, Class cls) {
        if (cls == null || this.f18474a == cls) {
            cls = a.class;
        }
        return super.nextSpanTransition(i9, i10, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        a aVarC;
        if (d(obj)) {
            aVarC = c(obj);
            if (aVarC != null) {
                obj = aVarC;
            }
        } else {
            aVarC = null;
        }
        super.removeSpan(obj);
        if (aVarC != null) {
            this.f18475b.remove(aVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int i9, int i10, CharSequence charSequence) {
        replace(i9, i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        if (d(obj)) {
            a aVar = new a(obj);
            this.f18475b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i9, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public final CharSequence subSequence(int i9, int i10) {
        return new j(this.f18474a, this, i9, i10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder delete(int i9, int i10) {
        super.delete(i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int i9, CharSequence charSequence) {
        super.insert(i9, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int i9, int i10, CharSequence charSequence, int i11, int i12) {
        replace(i9, i10, charSequence, i11, i12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int i9, CharSequence charSequence, int i10, int i11) {
        super.insert(i9, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int i9, int i10, CharSequence charSequence) {
        a();
        super.replace(i9, i10, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int i9, CharSequence charSequence, int i10, int i11) {
        super.insert(i9, charSequence, i10, i11);
        return this;
    }

    public j(Class cls, j jVar, int i9, int i10) {
        super(jVar, i9, i10);
        this.f18475b = new ArrayList();
        b.K0(cls, "watcherClass cannot be null");
        this.f18474a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int i9, int i10, CharSequence charSequence, int i11, int i12) {
        a();
        super.replace(i9, i10, charSequence, i11, i12);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i9) {
        super.append(charSequence, obj, i9);
        return this;
    }
}
