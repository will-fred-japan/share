package com.pichillilorenzo.flutter_inappwebview_android.types;

import A.a;
import android.content.Context;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AndroidResource {
    private String defPackage;
    private String defType;
    private String name;

    public AndroidResource(String str, String str2, String str3) {
        this.name = str;
        this.defType = str2;
        this.defPackage = str3;
    }

    public static AndroidResource fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new AndroidResource((String) map.get(MTCommonConstants.Network.KEY_NAME), (String) map.get("defType"), (String) map.get("defPackage"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AndroidResource androidResource = (AndroidResource) obj;
            if (!this.name.equals(androidResource.name)) {
                return false;
            }
            String str = this.defType;
            if (str == null ? androidResource.defType != null : !str.equals(androidResource.defType)) {
                return false;
            }
            String str2 = this.defPackage;
            String str3 = androidResource.defPackage;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String getDefPackage() {
        return this.defPackage;
    }

    public String getDefType() {
        return this.defType;
    }

    public int getIdentifier(Context context) {
        return context.getResources().getIdentifier(this.name, this.defType, this.defPackage);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.defType;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.defPackage;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public void setDefPackage(String str) {
        this.defPackage = str;
    }

    public void setDefType(String str) {
        this.defType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(MTCommonConstants.Network.KEY_NAME, this.name);
        map.put("defType", this.defType);
        map.put("defPackage", this.defPackage);
        return map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AndroidResource{name='");
        sb.append(this.name);
        sb.append("', type='");
        sb.append(this.defType);
        sb.append("', defPackage='");
        return a.j(sb, this.defPackage, "'}");
    }
}
