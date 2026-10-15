package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ha implements he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<ha> f537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17574b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[] f539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17575c;

    public ha(String str, String str2, String[] strArr, String[] strArr2) {
        this.f537a = null;
        this.f17573a = str;
        this.f17574b = str2;
        this.f538a = strArr;
        this.f539b = strArr2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m460a() {
        return this.f17573a;
    }

    public String b() {
        return this.f17574b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f17575c) ? hm.b(this.f17575c) : this.f17575c;
    }

    @Override // com.xiaomi.push.he
    public String d() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f17573a);
        if (!TextUtils.isEmpty(this.f17574b)) {
            sb.append(" xmlns=\"");
            sb.append(this.f17574b);
            sb.append("\"");
        }
        String[] strArr = this.f538a;
        if (strArr != null && strArr.length > 0) {
            for (int i9 = 0; i9 < this.f538a.length; i9++) {
                if (!TextUtils.isEmpty(this.f539b[i9])) {
                    sb.append(" ");
                    sb.append(this.f538a[i9]);
                    sb.append("=\"");
                    sb.append(hm.a(this.f539b[i9]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f17575c)) {
            List<ha> list = this.f537a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<ha> it = this.f537a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</");
                sb.append(this.f17573a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.f17575c);
            sb.append("</");
            sb.append(this.f17573a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f17573a);
        bundle.putString("ext_ns", this.f17574b);
        bundle.putString("ext_text", this.f17575c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f538a;
        if (strArr != null && strArr.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.f538a;
                if (i9 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i9], this.f539b[i9]);
                i9++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<ha> list = this.f537a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f537a));
        }
        return bundle;
    }

    public ha(String str, String str2, String[] strArr, String[] strArr2, String str3, List<ha> list) {
        this.f17573a = str;
        this.f17574b = str2;
        this.f538a = strArr;
        this.f539b = strArr2;
        this.f17575c = str3;
        this.f537a = list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Parcelable m459a() {
        return a();
    }

    public static Parcelable[] a(ha[] haVarArr) {
        if (haVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[haVarArr.length];
        for (int i9 = 0; i9 < haVarArr.length; i9++) {
            parcelableArr[i9] = haVarArr[i9].m459a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<ha> list) {
        return a((ha[]) list.toArray(new ha[list.size()]));
    }

    public static ha a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> setKeySet = bundle2.keySet();
        String[] strArr = new String[setKeySet.size()];
        String[] strArr2 = new String[setKeySet.size()];
        int i9 = 0;
        for (String str : setKeySet) {
            strArr[i9] = str;
            strArr2[i9] = bundle2.getString(str);
            i9++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add(a((Bundle) parcelable));
            }
        } else {
            arrayList = null;
        }
        return new ha(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f538a == null) {
                return null;
            }
            int i9 = 0;
            while (true) {
                String[] strArr = this.f538a;
                if (i9 >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i9])) {
                    return this.f539b[i9];
                }
                i9++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(ha haVar) {
        if (this.f537a == null) {
            this.f537a = new ArrayList();
        }
        if (this.f537a.contains(haVar)) {
            return;
        }
        this.f537a.add(haVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m461a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f17575c = hm.a(str);
        } else {
            this.f17575c = str;
        }
    }
}
