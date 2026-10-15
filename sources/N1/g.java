package N1;

import android.content.Intent;
import android.util.Log;
import com.apm.insight.nativecrash.NativeImpl;
import com.bytedance.services.apm.api.HttpResponse;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p056h5.C0598e;

/* JADX INFO: compiled from: SlardarConfigFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3163a;

    public /* synthetic */ g(int i9) {
        this.f3163a = i9;
    }

    /* JADX INFO: Infinite loop detected, blocks: 40, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        File file;
        String[] list;
        switch (this.f3163a) {
            case 0:
                try {
                    Intent intent = new Intent(p061i1.h.f19229a != null ? "apmplus." + p061i1.h.f19229a.getApplicationContext().getPackageName() : "apmplus.");
                    intent.putExtra("PROCESS_NAME", A4.d.a());
                    p061i1.h.f19229a.sendBroadcast(intent);
                } catch (Exception unused) {
                    return;
                }
                break;
            case 1:
                try {
                    List<String> list2 = p101n3.a.f20575a;
                    if (list2 != null && list2.size() > 0) {
                        Iterator<String> it = p101n3.a.f20575a.iterator();
                        while (it.hasNext()) {
                            HttpResponse httpResponseDoGet = p061i1.h.f19235g.doGet(String.format(it.next(), Integer.valueOf(p061i1.h.d().optInt("aid", 0))), null);
                            if (httpResponseDoGet != null) {
                                boolean zOptBoolean = new JSONObject(new String(httpResponseDoGet.getResponseBytes())).optBoolean("should_upload");
                                C0598e.o("uploadCheck with api: shouldUpload " + zOptBoolean, new Object[0]);
                                if (zOptBoolean) {
                                    p143s3.b.d().f();
                                }
                                break;
                            }
                        }
                        break;
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
                break;
            case 2:
                Iterator<Y1.a> it2 = p009b2.a.a().f8496a.iterator();
                while (it2.hasNext()) {
                    it2.next().a();
                }
                break;
            case 3:
                try {
                    NativeImpl.B();
                    break;
                } catch (Throwable th) {
                    try {
                        com.apm.insight.b.a(th);
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                break;
            case 4:
                while (true) {
                    try {
                        p150t2.b bVar = (p150t2.b) p150t2.a.f21401b.take();
                        for (p150t2.c cVar : p150t2.a.f21400a) {
                            try {
                                if (bVar.a()) {
                                    cVar.a(bVar);
                                } else if (A1.b.f1393A) {
                                    String str = "monitorable invalid. ignored. " + bVar;
                                    if (p010b3.b.f8497a != null && A1.b.f1393A) {
                                        Log.w("APM-Monitor", str);
                                    }
                                }
                            } catch (Throwable th2) {
                                p010b3.b.b("APM-Monitor", "monitorableHandler " + cVar + " handle monitorable " + bVar + "failed.", th2);
                            }
                        }
                    } catch (Throwable th3) {
                        p010b3.b.b("APM", "Oh, Damn it!!!", th3);
                    }
                }
                break;
            default:
                if (p144s4.a.g(com.apm.insight.f.f11853a) && (list = (file = new File(C0598e.w(com.apm.insight.f.f11853a), "apminsight/ProcessTrack/")).list()) != null && list.length > 25) {
                    Arrays.sort(list);
                    for (int i9 = 0; i9 < list.length - 25; i9++) {
                        p144s4.d.p(new File(file, list[i9]));
                    }
                }
                break;
        }
    }

    public g(String str, String str2, JSONObject jSONObject) {
        this.f3163a = 2;
    }
}
