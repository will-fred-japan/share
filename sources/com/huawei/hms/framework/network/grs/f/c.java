package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(Context context, boolean z8) {
        this.f15049d = z8;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f15048c = true;
        }
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        this.f15046a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(MTCommonConstants.Network.KEY_NAME);
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f15046a.b(string);
            this.f15046a.a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e9) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int c(String str) {
        JSONObject jSONObject;
        this.f15047b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() == 0) {
                return 0;
            }
            this.f15047b.addAll(a(jSONObject));
            return 0;
        } catch (JSONException e9) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x010d A[Catch: JSONException -> 0x0072, TryCatch #0 {JSONException -> 0x0072, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0024, B:8:0x003a, B:10:0x0043, B:11:0x0056, B:13:0x005c, B:15:0x006d, B:23:0x0087, B:24:0x009d, B:26:0x00a3, B:28:0x00b7, B:30:0x00bd, B:32:0x00ce, B:18:0x0075, B:20:0x007b, B:21:0x0080, B:33:0x00e2, B:35:0x00ed, B:39:0x00fc, B:41:0x0106, B:43:0x010d, B:44:0x0114, B:36:0x00f2, B:38:0x00f8, B:40:0x0101), top: B:49:0x000c }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.huawei.hms.framework.network.grs.f.a
    public int g(String str) {
        JSONObject jSONObject;
        String string;
        String str2 = "countryGroup";
        String str3 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator<String> itKeys = jSONObject2.keys();
            while (true) {
                int i9 = 0;
                if (!itKeys.hasNext()) {
                    return 0;
                }
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.f15050e.contains(next)) {
                    this.f15050e.add(next);
                    if (this.f15049d) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        cVar.c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        while (i9 < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i9);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else if (jSONObject4.has(str2)) {
                                string = jSONObject4.getString(str2);
                            } else {
                                Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                string = "no-country";
                            }
                            dVar.a(string);
                            JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                            String str4 = str2;
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                            Iterator<String> itKeys2 = jSONObject5.keys();
                            while (itKeys2.hasNext()) {
                                itKeys2 = itKeys2;
                                String next2 = itKeys2.next();
                                String string2 = jSONObject5.getString(next2);
                                if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(string2)) {
                                    concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                    str3 = str3;
                                }
                            }
                            dVar.a(concurrentHashMap);
                            cVar.a(dVar.b(), dVar);
                            i9++;
                            str2 = str4;
                            str3 = str3;
                        }
                        String str5 = str2;
                        String str6 = str3;
                        List<com.huawei.hms.framework.network.grs.local.model.b> listA = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else {
                            if (jSONObject3.has("countryGroups")) {
                                jSONObject = jSONObject3.getJSONObject("countryGroups");
                            } else {
                                Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            }
                            cVar.a(listA);
                            if (this.f15046a == null) {
                                this.f15046a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f15046a.a(next, cVar);
                            str2 = str5;
                            str3 = str6;
                        }
                        listA = a((JSONArray) null, jSONObject);
                        cVar.a(listA);
                        if (this.f15046a == null) {
                            this.f15046a = new com.huawei.hms.framework.network.grs.local.model.a();
                        }
                        this.f15046a.a(next, cVar);
                        str2 = str5;
                        str3 = str6;
                    }
                }
            }
        } catch (JSONException e9) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return -1;
        }
    }

    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString(MTCommonConstants.Network.KEY_NAME));
                bVar.a(jSONObject2.getString(com.heytap.mcssdk.constant.b.f14292i));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        hashSet.add((String) jSONArray.get(i9));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e9) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e9.getMessage()));
            return new ArrayList();
        }
    }
}
