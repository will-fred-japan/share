package f0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: EmojiTextViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18658a;

    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f18659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f18660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18661c = true;

        public a(TextView textView) {
            this.f18659a = textView;
            this.f18660b = new d(textView);
        }

        @Override // f0.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f18661c) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i9 = 0; i9 < inputFilterArr.length; i9++) {
                    InputFilter inputFilter = inputFilterArr[i9];
                    if (inputFilter instanceof d) {
                        sparseArray.put(i9, inputFilter);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i10 = 0;
                for (int i11 = 0; i11 < length; i11++) {
                    if (sparseArray.indexOfKey(i11) < 0) {
                        inputFilterArr2[i10] = inputFilterArr[i11];
                        i10++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            int i12 = 0;
            while (true) {
                d dVar = this.f18660b;
                if (i12 >= length2) {
                    InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = dVar;
                    return inputFilterArr3;
                }
                if (inputFilterArr[i12] == dVar) {
                    return inputFilterArr;
                }
                i12++;
            }
        }

        @Override // f0.f.b
        public final boolean b() {
            return this.f18661c;
        }

        @Override // f0.f.b
        public final void c(boolean z8) {
            if (z8) {
                TextView textView = this.f18659a;
                textView.setTransformationMethod(e(textView.getTransformationMethod()));
            }
        }

        @Override // f0.f.b
        public final void d(boolean z8) {
            this.f18661c = z8;
            TextView textView = this.f18659a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
            textView.setFilters(a(textView.getFilters()));
        }

        @Override // f0.f.b
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f18661c) {
                return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
            }
            return transformationMethod instanceof h ? ((h) transformationMethod).f18667a : transformationMethod;
        }
    }

    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z8) {
            throw null;
        }

        public void d(boolean z8) {
            throw null;
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f18662a;

        public c(TextView textView) {
            this.f18662a = new a(textView);
        }

        @Override // f0.f.b
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            return !(androidx.emoji2.text.c.f7369k != null) ? inputFilterArr : this.f18662a.a(inputFilterArr);
        }

        @Override // f0.f.b
        public final boolean b() {
            return this.f18662a.f18661c;
        }

        @Override // f0.f.b
        public final void c(boolean z8) {
            if (androidx.emoji2.text.c.f7369k != null) {
                this.f18662a.c(z8);
            }
        }

        @Override // f0.f.b
        public final void d(boolean z8) {
            boolean z9 = androidx.emoji2.text.c.f7369k != null;
            a aVar = this.f18662a;
            if (z9) {
                aVar.d(z8);
            } else {
                aVar.f18661c = z8;
            }
        }

        @Override // f0.f.b
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            return !(androidx.emoji2.text.c.f7369k != null) ? transformationMethod : this.f18662a.e(transformationMethod);
        }
    }

    public f(TextView textView) {
        this.f18658a = new c(textView);
    }
}
