package A6;

import N6.C0332c;
import N6.C0338i;
import O6.i;
import O6.j;
import O6.k;
import android.content.Context;
import androidx.fragment.app.A;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.datepicker.AbstractC0556d;
import com.google.android.material.datepicker.G;
import com.google.android.material.textfield.TextInputLayout;
import com.starburst.sdk.business.FileResultTaskPoller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import y7.u;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1486c;

    public /* synthetic */ a(int i9, Object obj, Object obj2) {
        this.f1484a = i9;
        this.f1485b = obj;
        this.f1486c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a aVar;
        switch (this.f1484a) {
            case 0:
                ((e) this.f1485b).a(((c) this.f1486c).b());
                return;
            case 1:
                ((C0338i) this.f1485b).success(u.D(new p188x7.e("code", 200), new p188x7.e("message", "ok"), new p188x7.e("taskId", (String) this.f1486c)));
                return;
            case 2:
                ((C0338i) this.f1485b).success(((C0332c) this.f1486c).invoke());
                return;
            case 3:
                k kVar = (k) this.f1485b;
                i iVar = (i) this.f1486c;
                synchronized (kVar) {
                    try {
                        HashSet hashSet = new HashSet(kVar.f3529e);
                        kVar.f3530f.remove(iVar);
                        kVar.f3529e.add(iVar);
                        O6.h hVar = iVar.f3523f;
                        if (hVar == null || (aVar = hVar.f3516a) == null || !aVar.f3524a.k()) {
                            O6.h hVar2 = iVar.f3523f;
                            if ((hVar2 != null ? hVar2.a() : null) != null) {
                                HashMap map = kVar.f3531g;
                                O6.h hVar3 = iVar.f3523f;
                                map.remove(hVar3 != null ? hVar3.a() : null);
                            }
                        }
                        kVar.e(iVar);
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            kVar.e((i) it.next());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 4:
                A this$0 = (A) this.f1485b;
                kotlin.jvm.internal.k.e(this$0, "this$0");
                A.b bVar = (A.b) this.f1486c;
                this$0.f7399b.remove(bVar);
                this$0.f7400c.remove(bVar);
                return;
            case 5:
                AbstractC0556d abstractC0556d = (AbstractC0556d) this.f1485b;
                TextInputLayout textInputLayout = abstractC0556d.f13298a;
                Context context = textInputLayout.getContext();
                textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), ((String) this.f1486c).replace(' ', (char) 160)) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), abstractC0556d.f13300c.format(new Date(G.f().getTimeInMillis())).replace(' ', (char) 160)));
                abstractC0556d.a();
                return;
            case 6:
                FileResultTaskPoller.addTask$lambda$0((FileResultTaskPoller) this.f1485b, (String) this.f1486c);
                return;
            case 7:
                m7.d.b.a aVar2 = ((p080k6.c) this.f1485b).f19985e;
                if (aVar2 != null) {
                    aVar2.success((Map) this.f1486c);
                    return;
                }
                return;
            case 8:
                p161u6.b bVar2 = (p161u6.b) this.f1485b;
                if (bVar2.f21738o) {
                    return;
                }
                bVar2.f21733i.add((p161u6.b.C0270b) this.f1486c);
                if (bVar2.f21735l >= 0) {
                    bVar2.d();
                    return;
                }
                return;
            case 9:
                p179w7.e eVar = (p179w7.e) this.f1485b;
                Runnable runnable = (Runnable) this.f1486c;
                if (eVar.f22179d) {
                    runnable.run();
                    return;
                }
                return;
            case 10:
                Exception exc = (Exception) this.f1486c;
                ((p096m7.k) this.f1485b).error("write_error", exc.getMessage(), p179w7.e.f(exc));
                return;
            case 11:
                ((p096m7.k) this.f1485b).success((ArrayList) this.f1486c);
                return;
            default:
                m7.d.b.a aVar3 = ((p187x6.b) this.f1485b).f22350a;
                if (aVar3 != null) {
                    aVar3.success(Integer.valueOf(((q6.f) this.f1486c).f21029a));
                    return;
                }
                return;
        }
    }
}
