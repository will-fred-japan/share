package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f13934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q f13935g;

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.material.textfield.q] */
    public r(j jVar, int i9) {
        super(jVar);
        this.f13933e = R.drawable.design_password_eye;
        this.f13935g = new View.OnClickListener() { // from class: com.google.android.material.textfield.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r rVar = this.f13932a;
                EditText editText = rVar.f13934f;
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                EditText editText2 = rVar.f13934f;
                if (editText2 == null || !(editText2.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    rVar.f13934f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    rVar.f13934f.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    rVar.f13934f.setSelection(selectionEnd);
                }
                rVar.q();
            }
        };
        if (i9 != 0) {
            this.f13933e = i9;
        }
    }

    @Override // com.google.android.material.textfield.k
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.k
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.k
    public final int d() {
        return this.f13933e;
    }

    @Override // com.google.android.material.textfield.k
    public final View.OnClickListener f() {
        return this.f13935g;
    }

    @Override // com.google.android.material.textfield.k
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.k
    public final boolean l() {
        EditText editText = this.f13934f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.k
    public final void m(EditText editText) {
        this.f13934f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.k
    public final void r() {
        EditText editText = this.f13934f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f13934f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.k
    public final void s() {
        EditText editText = this.f13934f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
