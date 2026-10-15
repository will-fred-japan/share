package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class cv {

    public static class a extends cu {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cu
        public String a(Context context, String str, List<aw> list) {
            if (list == null) {
                return ax.a(context, new URL(str));
            }
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            for (aw awVar : list) {
                builderBuildUpon.appendQueryParameter(awVar.a(), awVar.b());
            }
            return ax.a(context, new URL(builderBuildUpon.toString()));
        }
    }

    public static String a(Context context, String str, List<aw> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Code duplicated, block: B:74:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(Context context, String str, List<aw> list, cu cuVar, boolean z8) {
        String str2;
        cp cpVarM172a;
        IOException iOException;
        String str3;
        String str4;
        if (!ax.m111a(context)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (z8) {
                cpVarM172a = ct.a().m172a(str);
                if (cpVarM172a != null) {
                    arrayList = cpVarM172a.a(str);
                }
            } else {
                cpVarM172a = null;
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
            String str5 = null;
            for (String str6 : arrayList) {
                ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    if (!cuVar.m182a(context, str6, (List<aw>) arrayList2)) {
                        return str5;
                    }
                    String strA = cuVar.a(context, str6, (List<aw>) arrayList2);
                    try {
                        if (!TextUtils.isEmpty(strA)) {
                            if (cpVarM172a != null) {
                                try {
                                    str2 = null;
                                    str4 = str6;
                                    cpVarM172a = cpVarM172a;
                                    cpVarM172a.a(str4, System.currentTimeMillis() - jCurrentTimeMillis, a(cuVar, str6, arrayList2, strA));
                                } catch (IOException e9) {
                                    e = e9;
                                    str2 = null;
                                }
                            }
                            return strA;
                        }
                        str4 = str6;
                        str2 = null;
                        if (cpVarM172a != null) {
                            try {
                                str3 = strA;
                                try {
                                    cpVarM172a.a(str4, System.currentTimeMillis() - jCurrentTimeMillis, a(cuVar, str4, arrayList2, strA), null);
                                } catch (IOException e10) {
                                    e = e10;
                                    str6 = str4;
                                    iOException = e;
                                    if (cpVarM172a != null) {
                                        try {
                                            cpVarM172a.a(str6, System.currentTimeMillis() - jCurrentTimeMillis, a(cuVar, str6, arrayList2, str3), iOException);
                                        } catch (MalformedURLException e11) {
                                            e = e11;
                                            e.printStackTrace();
                                            return str2;
                                        }
                                    }
                                    iOException.printStackTrace();
                                }
                            } catch (IOException e12) {
                                e = e12;
                                str6 = str4;
                                str3 = strA;
                            }
                        } else {
                            str3 = strA;
                        }
                        str5 = str3;
                        e = e12;
                        str6 = str4;
                        str3 = strA;
                    } catch (IOException e13) {
                        e = e13;
                        str3 = strA;
                        str2 = null;
                    }
                    iOException = e;
                } catch (IOException e14) {
                    str2 = null;
                    iOException = e14;
                    str3 = str5;
                }
                if (cpVarM172a != null) {
                    cpVarM172a.a(str6, System.currentTimeMillis() - jCurrentTimeMillis, a(cuVar, str6, arrayList2, str3), iOException);
                }
                iOException.printStackTrace();
                str5 = str3;
            }
            return str5;
        } catch (MalformedURLException e15) {
            e = e15;
            str2 = null;
        }
    }

    private static int a(cu cuVar, String str, List<aw> list, String str2) {
        if (cuVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cuVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    public static int a(List<aw> list) {
        int length = 0;
        for (aw awVar : list) {
            if (!TextUtils.isEmpty(awVar.a())) {
                length += awVar.a().length();
            }
            if (!TextUtils.isEmpty(awVar.b())) {
                length = awVar.b().length() + length;
            }
        }
        return length * 2;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    public static int a(int i9, int i10) {
        return (((i10 + 243) / 1448) * 132) + 1080 + i9 + i10;
    }

    public static int a(int i9, int i10, int i11) {
        return (((i10 + 200) / 1448) * 132) + MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED + i10 + i9 + i11;
    }
}
