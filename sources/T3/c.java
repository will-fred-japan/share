package T3;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.r;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4491b;

    public /* synthetic */ c(int i9, Object obj) {
        this.f4490a = i9;
        this.f4491b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4490a) {
            case 0:
                ((f) this.f4491b).i(true);
                break;
            case 1:
                r rVar = (r) this.f4491b;
                rVar.f13362V0.setEnabled(rVar.D().v());
                rVar.f13360T0.toggle();
                rVar.f13351I0 = rVar.f13351I0 == 1 ? 0 : 1;
                rVar.H(rVar.f13360T0);
                rVar.G();
                break;
            default:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) this.f4491b;
                EditText editText = cVar.f13845i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    cVar.q();
                    break;
                }
                break;
        }
    }
}
