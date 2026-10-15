package com.vivo.push.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OnDelTagsReceiveTask.java */
/* JADX INFO: loaded from: classes.dex */
final class l extends ag {
    public l(com.vivo.push.w wVar) {
        super(wVar);
    }

    @Override // com.vivo.push.t
    public final void a(com.vivo.push.w wVar) {
        com.vivo.push.b.v vVar = (com.vivo.push.b.v) wVar;
        ArrayList<String> arrayListE = vVar.e();
        List<String> listF = vVar.f();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int iJ = vVar.j();
        com.vivo.push.util.w.c("OnDelTagsTask", "doTask,删除成功的标签 = " + arrayListE + " 删除失败的= " + listF + " 错误码= " + iJ);
        String strI = vVar.i();
        if (arrayListE != null) {
            for (String str : arrayListE) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (listF != null) {
            for (String str2 : listF) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            com.vivo.push.util.w.c("OnDelTagsTask", "doTask1,删除成功的别名 = " + arrayList + " 删除失败的别名= " + arrayList3 + " 错误码= " + iJ);
            if (arrayList.size() > 0) {
                com.vivo.push.n.a();
                try {
                    if (arrayList.size() > 0) {
                        String strG = com.vivo.push.restructure.a.a().e().g();
                        JSONObject jSONObject = TextUtils.isEmpty(strG) ? new JSONObject() : new JSONObject(strG);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONObject.remove((String) it.next());
                        }
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            com.vivo.push.restructure.a.a().e().h();
                        } else {
                            com.vivo.push.restructure.a.a().e().d(string);
                        }
                    }
                } catch (JSONException e9) {
                    e9.printStackTrace();
                    com.vivo.push.restructure.a.a().e().h();
                }
            }
            com.vivo.push.n.a().a(vVar.i(), iJ);
            com.vivo.push.u.a(new m(this, iJ, arrayList, arrayList3, strI));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            com.vivo.push.util.w.c("OnDelTagsTask", "doTask1,删除成功的标签 = " + arrayList + " 删除失败的标签= " + arrayList3 + " 错误码= " + iJ);
            if (arrayList2.size() > 0) {
                com.vivo.push.n.a().a(arrayList2);
            }
            com.vivo.push.n.a().a(vVar.i(), iJ);
            com.vivo.push.u.a(new n(this, iJ, arrayList2, arrayList4, strI));
        }
    }
}
