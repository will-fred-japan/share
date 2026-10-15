package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hd {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DateFormat f543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f17594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f17595c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hh f546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<ha> f547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f548a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f17599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f17601i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f17593a = Locale.getDefault().getLanguage().toLowerCase();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f544b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f543a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        f17595c = hm.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f17594b = 0L;
    }

    public hd() {
        this.f17596d = f544b;
        this.f17597e = null;
        this.f17598f = null;
        this.f17599g = null;
        this.f17600h = null;
        this.f17601i = null;
        this.f547a = new CopyOnWriteArrayList();
        this.f548a = new HashMap();
        this.f546a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f17595c);
        long j = f17594b;
        f17594b = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    public static String q() {
        return f17593a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hh m464a() {
        return this.f546a;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo463a();

    public synchronized Collection<String> b() {
        if (this.f548a == null) {
            return Collections.EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(this.f548a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            hd hdVar = (hd) obj;
            hh hhVar = this.f546a;
            if (hhVar == null ? hdVar.f546a != null : !hhVar.equals(hdVar.f546a)) {
                return false;
            }
            String str = this.f17599g;
            if (str == null ? hdVar.f17599g != null : !str.equals(hdVar.f17599g)) {
                return false;
            }
            if (!this.f547a.equals(hdVar.f547a)) {
                return false;
            }
            String str2 = this.f17597e;
            if (str2 == null ? hdVar.f17597e != null : !str2.equals(hdVar.f17597e)) {
                return false;
            }
            String str3 = this.f17600h;
            if (str3 == null ? hdVar.f17600h != null : !str3.equals(hdVar.f17600h)) {
                return false;
            }
            Map<String, Object> map = this.f548a;
            if (map == null ? hdVar.f548a != null : !map.equals(hdVar.f548a)) {
                return false;
            }
            String str4 = this.f17598f;
            if (str4 == null ? hdVar.f17598f != null : !str4.equals(hdVar.f17598f)) {
                return false;
            }
            String str5 = this.f17596d;
            String str6 = hdVar.f17596d;
            if (str5 == null ? str6 == null : str5.equals(str6)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f17596d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f17597e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17598f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f17599g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f17600h;
        int iHashCode5 = (this.f548a.hashCode() + ((this.f547a.hashCode() + ((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31)) * 31)) * 31;
        hh hhVar = this.f546a;
        return iHashCode5 + (hhVar != null ? hhVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f17597e)) {
            return null;
        }
        if (this.f17597e == null) {
            this.f17597e = i();
        }
        return this.f17597e;
    }

    public void k(String str) {
        this.f17597e = str;
    }

    public void l(String str) {
        this.f17600h = str;
    }

    public void m(String str) {
        this.f17598f = str;
    }

    public void n(String str) {
        this.f17599g = str;
    }

    public void o(String str) {
        this.f17601i = str;
    }

    public String p() {
        return this.f17596d;
    }

    public void a(hh hhVar) {
        this.f546a = hhVar;
    }

    public String k() {
        return this.f17600h;
    }

    public String l() {
        return this.f17598f;
    }

    public String m() {
        return this.f17599g;
    }

    public String n() {
        return this.f17601i;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e9;
        try {
            sb = new StringBuilder();
            Iterator<ha> it = m466a().iterator();
            while (it.hasNext()) {
                sb.append(it.next().d());
            }
            Map<String, Object> map = this.f548a;
            if (map != null && !map.isEmpty()) {
                sb.append(bj.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
                for (String str : b()) {
                    Object objM465a = m465a(str);
                    sb.append("<property>");
                    sb.append("<name>");
                    sb.append(hm.a(str));
                    sb.append("</name>");
                    sb.append("<value type=\"");
                    if (objM465a instanceof Integer) {
                        sb.append("integer\">");
                        sb.append(objM465a);
                        sb.append("</value>");
                    } else if (objM465a instanceof Long) {
                        sb.append("long\">");
                        sb.append(objM465a);
                        sb.append("</value>");
                    } else if (objM465a instanceof Float) {
                        sb.append("float\">");
                        sb.append(objM465a);
                        sb.append("</value>");
                    } else if (objM465a instanceof Double) {
                        sb.append("double\">");
                        sb.append(objM465a);
                        sb.append("</value>");
                    } else if (objM465a instanceof Boolean) {
                        sb.append("boolean\">");
                        sb.append(objM465a);
                        sb.append("</value>");
                    } else if (objM465a instanceof String) {
                        sb.append("string\">");
                        sb.append(hm.a((String) objM465a));
                        sb.append("</value>");
                    } else {
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                try {
                                    try {
                                        objectOutputStream.writeObject(objM465a);
                                        sb.append("java-object\">");
                                        sb.append(hm.a(byteArrayOutputStream.toByteArray()));
                                        sb.append("</value>");
                                        try {
                                            objectOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                    } catch (Exception e10) {
                                        e9 = e10;
                                        e9.printStackTrace();
                                        if (objectOutputStream != null) {
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        sb.append("</property>");
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    objectOutputStream2 = objectOutputStream;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (byteArrayOutputStream == null) {
                                        throw th;
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (Exception unused4) {
                                        throw th;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                objectOutputStream = null;
                                e9 = e;
                                e9.printStackTrace();
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                sb.append("</property>");
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            byteArrayOutputStream = null;
                            objectOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    sb.append("</property>");
                }
                sb.append("</properties>");
            }
        } catch (Throwable th4) {
            throw th4;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<ha> m466a() {
        if (this.f547a == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(new ArrayList(this.f547a));
    }

    public ha a(String str) {
        return a(str, null);
    }

    public ha a(String str, String str2) {
        for (ha haVar : this.f547a) {
            if (str2 == null || str2.equals(haVar.b())) {
                if (str.equals(haVar.m460a())) {
                    return haVar;
                }
            }
        }
        return null;
    }

    public void a(ha haVar) {
        this.f547a.add(haVar);
    }

    public hd(Bundle bundle) {
        this.f17596d = f544b;
        this.f17597e = null;
        this.f17598f = null;
        this.f17599g = null;
        this.f17600h = null;
        this.f17601i = null;
        this.f547a = new CopyOnWriteArrayList();
        this.f548a = new HashMap();
        this.f546a = null;
        this.f17598f = bundle.getString("ext_to");
        this.f17599g = bundle.getString("ext_from");
        this.f17600h = bundle.getString("ext_chid");
        this.f17597e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f547a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                ha haVarA = ha.a((Bundle) parcelable);
                if (haVarA != null) {
                    this.f547a.add(haVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f546a = new hh(bundle2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Object m465a(String str) {
        Map<String, Object> map = this.f548a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f17596d)) {
            bundle.putString("ext_ns", this.f17596d);
        }
        if (!TextUtils.isEmpty(this.f17599g)) {
            bundle.putString("ext_from", this.f17599g);
        }
        if (!TextUtils.isEmpty(this.f17598f)) {
            bundle.putString("ext_to", this.f17598f);
        }
        if (!TextUtils.isEmpty(this.f17597e)) {
            bundle.putString("ext_pkt_id", this.f17597e);
        }
        if (!TextUtils.isEmpty(this.f17600h)) {
            bundle.putString("ext_chid", this.f17600h);
        }
        hh hhVar = this.f546a;
        if (hhVar != null) {
            bundle.putBundle("ext_ERROR", hhVar.a());
        }
        List<ha> list = this.f547a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<ha> it = this.f547a.iterator();
            int i9 = 0;
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i9] = bundleA;
                    i9++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
