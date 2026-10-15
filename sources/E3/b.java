package E3;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import org.json.JSONObject;
import p056h5.C0597d;
import p061i1.h;
import p094m5.e;
import p094m5.k;
import p094m5.n;

/* JADX INFO: compiled from: CloudMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1980c;

    public /* synthetic */ b(int i9, Object obj, Object obj2) {
        this.f1978a = i9;
        this.f1980c = obj;
        this.f1979b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        E.a aVar = null;
        switch (this.f1978a) {
            case 0:
                String str = (String) this.f1979b;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        E.a aVar2 = new E.a(2);
                        JSONObject jSONObject = new JSONObject(str);
                        aVar2.f1949e = jSONObject.optString("command_id");
                        aVar2.f1948d = jSONObject.optString("type");
                        String strOptString = jSONObject.optString(com.heytap.mcssdk.constant.b.f14278D);
                        JSONObject jSONObject2 = new JSONObject();
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject2 = new JSONObject(strOptString);
                        }
                        aVar2.f1947c = strOptString;
                        aVar2.f1946b = jSONObject2;
                        aVar = aVar2;
                    } catch (Exception unused) {
                    }
                }
                a aVar3 = (a) this.f1980c;
                aVar3.getClass();
                if (h.f19230b) {
                    Log.d("ApmInsight", p199z2.b.f(new String[]{"handleCloudMessageInternal cloudMessage=" + aVar}));
                }
                if (aVar == null) {
                    return;
                }
                Iterator<O3.b> it = aVar3.f1974a.iterator();
                while (it.hasNext() && !it.next().a(aVar)) {
                }
                return;
            case 1:
                if (((n) this.f1979b).f20371d) {
                    n nVar = ((p094m5.h) this.f1980c).f20357a;
                    synchronized (nVar.f20368a) {
                        try {
                            if (!nVar.f20370c) {
                                nVar.f20370c = true;
                                nVar.f20371d = true;
                                nVar.f20369b.b(nVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                try {
                    ((p094m5.h) this.f1980c).getClass();
                    P4.a aVar4 = C0597d.f19058i;
                    ((p094m5.h) this.f1980c).f20357a.d(null);
                    return;
                } catch (e e9) {
                    if (e9.getCause() instanceof Exception) {
                        ((p094m5.h) this.f1980c).f20357a.c((Exception) e9.getCause());
                        return;
                    } else {
                        ((p094m5.h) this.f1980c).f20357a.c(e9);
                        return;
                    }
                } catch (Exception e10) {
                    ((p094m5.h) this.f1980c).f20357a.c(e10);
                    return;
                }
            default:
                synchronized (((k) this.f1980c).f20365b) {
                    ((k) this.f1980c).f20366c.onSuccess(((n) this.f1979b).a());
                    break;
                }
                return;
        }
    }
}
