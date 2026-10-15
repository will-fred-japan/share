package com.bytedance.apm.doctor;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import p016c1.d;
import p016c1.e;
import p016c1.g;

/* JADX INFO: loaded from: classes.dex */
public final class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f12052a;

    public interface ApmListener {
        void onDataEvent(int i9, String str, JSONObject jSONObject);

        void onEvent(String str, String str2);
    }

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f12055c;

        public a(JSONObject jSONObject, String str, ArrayList arrayList) {
            this.f12053a = jSONObject;
            this.f12054b = str;
            this.f12055c = arrayList;
        }

        @Override // p016c1.g
        public final e b() {
            return e.f8688c;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = this.f12054b;
            JSONObject jSONObject = this.f12053a;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("DATA_DOCTOR");
                jSONObject2.put(str, System.currentTimeMillis());
                int iOptInt = jSONObject2.optInt("DATA_ID");
                Iterator it = this.f12055c.iterator();
                while (it.hasNext()) {
                    ((ApmListener) it.next()).onDataEvent(iOptInt, str, jSONObject);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoctorManager f12056a;

        static {
            DoctorManager doctorManager = new DoctorManager();
            doctorManager.f12052a = new ArrayList();
            f12056a = doctorManager;
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        ArrayList arrayList = this.f12052a;
        if (A1.b.v0(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        d dVar = d.a.f8685a;
        a aVar = new a(jSONObject, str, arrayList2);
        dVar.getClass();
        try {
            dVar.a(aVar).b(aVar);
        } catch (Throwable unused) {
        }
    }
}
