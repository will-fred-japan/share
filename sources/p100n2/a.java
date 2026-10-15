package p100n2;

import Q4.X;
import android.app.Application;
import android.text.TextUtils;
import com.bytedance.services.apm.api.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p039f3.e;
import p056h5.C0598e;
import p061i1.h;

/* JADX INFO: compiled from: ApmLogSender.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f20567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20569d;

    /* JADX INFO: renamed from: n2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApmLogSender.java */
    public class C0234a extends f3.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20570a;

        public C0234a(String str) {
            this.f20570a = str;
        }
    }

    /* JADX INFO: compiled from: ApmLogSender.java */
    public class b {
        public b() {
        }
    }

    /* JADX INFO: compiled from: ApmLogSender.java */
    public class c extends p039f3.b {
        public c(Application application, C0234a c0234a, b bVar) {
            this.f18676b = c0234a;
            this.f18679e = bVar;
            String str = c0234a.f20570a;
            this.f18675a = str;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("type is empty.");
            }
            if (e.f18689e == null) {
                synchronized (e.class) {
                    try {
                        if (e.f18689e == null) {
                            e.f18689e = new e(application);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            e eVar = e.f18689e;
            this.f18677c = eVar;
            if (((AtomicBoolean) eVar.f18692c).get()) {
                return;
            }
            ((ConcurrentHashMap) eVar.f18690a).put(str, this);
        }

        /* JADX WARN: Code duplicated, block: B:89:0x011a A[ExcSplitCross -> B:50:0x011a, SYNTHETIC] */
        @Override // p039f3.b
        public final boolean a(String str, byte[] bArr) {
            JSONObject jSONObject;
            p083l2.c cVar = p100n2.b.f20574b;
            if (cVar != null) {
                cVar.getClass();
                if (h.f19230b && bArr != null) {
                    String str2 = new String(bArr);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            A1.b.g1("DATA_SEND_BEGIN", new JSONObject(str2));
                        } catch (JSONException e9) {
                            e9.printStackTrace();
                        }
                    }
                }
                X x8 = new X();
                if (bArr != null) {
                    try {
                        if (bArr.length != 0) {
                            try {
                                S1.a aVarA = new U2.a(str, bArr).a(cVar.f20038o);
                                HttpResponse httpResponseDoPost = h.f19235g.doPost((String) aVarA.f4102a, (byte[]) aVarA.f4104c, (HashMap) aVarA.f4103b);
                                if (httpResponseDoPost != null) {
                                    x8.f3794a = httpResponseDoPost.getStatusCode();
                                    if (httpResponseDoPost.getStatusCode() == 200) {
                                        JSONObject jSONObject2 = new JSONObject(new String(httpResponseDoPost.getResponseBytes()));
                                        try {
                                            String strOptString = jSONObject2.optString("data");
                                            if (!strOptString.isEmpty()) {
                                                jSONObject2 = new JSONObject(C0598e.g(strOptString.getBytes(), ""));
                                            }
                                            if (!A1.b.w0(jSONObject2)) {
                                                A1.b.w0(jSONObject2.optJSONObject("configs"));
                                            }
                                            x8.f3795b = jSONObject2;
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                        if (h.f19230b) {
                                            A1.b.Y(bArr, str, x8.f3794a);
                                            A1.b.s0("Send:\nurl:" + str + " \nresponse:" + x8.f3794a + " \ndata:" + new String(bArr));
                                        }
                                    } else if (h.f19230b) {
                                        A1.b.Y(bArr, str, x8.f3794a);
                                        A1.b.s0("Send:\nurl:" + str + " response:" + x8.f3794a);
                                    }
                                } else if (h.f19230b) {
                                    A1.b.Y(bArr, str, x8.f3794a);
                                    A1.b.s0("Send:\nurl:" + str + " response:" + x8.f3794a);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                int i9 = x8.f3794a;
                if (i9 > 0) {
                    a aVar = a.this;
                    aVar.f20568c = false;
                    if (i9 == 200 && (jSONObject = (JSONObject) x8.f3795b) != null) {
                        if ("success".equals(jSONObject.opt("message"))) {
                            a aVar2 = a.this;
                            aVar2.f20569d = 0;
                            aVar2.f20567b = 0L;
                            o1.c.b.f20680a.getClass();
                            List<String> list = p083l2.c.f20019D;
                            l2.c.b.f20050a.f20028d = true;
                            return true;
                        }
                        boolean z8 = ((JSONObject) x8.f3795b).optInt("is_crash", 0) == 1;
                        boolean zEquals = "drop data".equals(((JSONObject) x8.f3795b).opt("message"));
                        if (z8 || zEquals) {
                            a.a(a.this, true);
                            return false;
                        }
                        a.a(a.this, false);
                        return false;
                    }
                    if (500 <= i9 && i9 <= 600) {
                        a.a(aVar, false);
                        return false;
                    }
                } else {
                    a.this.f20568c = true;
                }
            }
            return false;
        }
    }

    public a(String str) {
        this.f20566a = new c(h.f19229a, new C0234a(str), new b());
    }

    public static void a(a aVar, boolean z8) {
        if (z8) {
            aVar.f20567b = 1800000L;
            aVar.f20569d = 3;
        } else {
            int i9 = aVar.f20569d;
            if (i9 == 0) {
                aVar.f20567b = 300000L;
                aVar.f20569d++;
            } else if (i9 == 1) {
                aVar.f20567b = com.heytap.mcssdk.constant.a.f14247h;
                aVar.f20569d++;
            } else if (i9 == 2) {
                aVar.f20567b = 1800000L;
                aVar.f20569d++;
            } else {
                aVar.f20567b = 1800000L;
                aVar.f20569d++;
            }
        }
        o1.c.b.f20680a.getClass();
        List<String> list = p083l2.c.f20019D;
        p083l2.c cVar = l2.c.b.f20050a;
        long j = aVar.f20567b;
        cVar.f20028d = false;
        cVar.f20032h = true;
        cVar.f20039p = System.currentTimeMillis();
        cVar.f20040q = j;
    }
}
