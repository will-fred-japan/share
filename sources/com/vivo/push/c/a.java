package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.y;
import java.util.HashMap;

/* JADX INFO: compiled from: CoreConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f16552b = new HashMap<>();

    public a(Context context) {
        this.f16551a = context;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00cd A[Catch: Exception -> 0x00c9, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c9, blocks: (B:58:0x00c5, B:62:0x00cd), top: B:81:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00e1 A[Catch: Exception -> 0x00dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00dd, blocks: (B:68:0x00d9, B:72:0x00e1), top: B:76:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    private int h() throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClient;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        if (this.f16551a == null) {
            return JosStatusCodes.RNT_CODE_NO_JOS_INFO;
        }
        if (this.f16552b.size() > 0) {
            return 0;
        }
        Cursor cursorQuery = null;
        try {
            try {
                ContentResolver contentResolver = this.f16551a.getContentResolver();
                Uri uri = y.f16910a;
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, null, null);
                    } catch (Exception e9) {
                        e = e9;
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        w.a("CoreConfigManager", "provider exception", e);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e10) {
                                w.a("CoreConfigManager", "close err ", e10);
                                return 8005;
                            }
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            return 8005;
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                        return 8005;
                    } catch (Throwable th2) {
                        th = th2;
                        contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        th = th;
                        if (0 != 0) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e11) {
                                w.a("CoreConfigManager", "close err ", e11);
                                throw th;
                            }
                        }
                        if (contentProviderClient != null) {
                            throw th;
                        }
                        contentProviderClient.close();
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    try {
                        cursorQuery = this.f16551a.getContentResolver().query(uri, null, null, null, null);
                    } catch (Exception e12) {
                        e = e12;
                        w.a("CoreConfigManager", "provider exception", e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            return 8005;
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                        return 8005;
                    }
                }
                if (cursorQuery == null) {
                    w.a("CoreConfigManager", "cursor is null");
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e13) {
                            w.a("CoreConfigManager", "close err ", e13);
                            return 8008;
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient == 0) {
                        return 8008;
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                    return 8008;
                }
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(MTCommonConstants.Network.KEY_NAME));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    w.d("CoreConfigManager", "initConfig name:" + string + " value:" + string2);
                    if (!TextUtils.isEmpty(string)) {
                        this.f16552b.put(string, string2);
                    }
                }
                try {
                    cursorQuery.close();
                    if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                } catch (Exception e14) {
                    w.a("CoreConfigManager", "close err ", e14);
                }
                return 0;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            e = e15;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th4) {
            th = th4;
            contentProviderClient = null;
            if (0 != 0) {
                cursorQuery.close();
            }
            if (contentProviderClient != null) {
                throw th;
            }
            contentProviderClient.close();
            throw th;
        }
    }

    public final int a() throws Throwable {
        int iB = b(1);
        w.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(iB)));
        return iB;
    }

    public final int b() throws Throwable {
        int iB = b(4);
        w.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(iB)));
        return iB;
    }

    public final boolean c() throws Throwable {
        int iB = b(8);
        w.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean d() throws Throwable {
        int iB = b(16);
        w.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean e() throws Throwable {
        int iB = b(32);
        w.d("CoreConfigManager", "isSupportCreateNotifyChannel : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    public final boolean f() throws Throwable {
        int iB = b(128);
        w.d("CoreConfigManager", "isSupportAliasSubscribeCheck : ".concat(String.valueOf(iB)));
        return iB == 0;
    }

    @Override // com.vivo.push.util.p
    public final int g() throws Throwable {
        h();
        try {
            return Integer.parseInt(this.f16552b.get("imageMax"));
        } catch (Exception e9) {
            w.a("CoreConfigManager", "getExtensionMaxImageSize error", e9);
            return 49152;
        }
    }

    private int b(int i9) throws Throwable {
        int iH = h();
        if (iH != 0) {
            return iH;
        }
        HashMap<String, String> map = this.f16552b;
        if (map == null || map.size() == 0) {
            return 8006;
        }
        String str = this.f16552b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i9 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r10 != 4096) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r10) {
        /*
            r9 = this;
            int r0 = r9.b(r10)
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 2048(0x800, float:2.87E-42)
            r2 = 1024(0x400, float:1.435E-42)
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 512(0x200, float:7.175E-43)
            r5 = 256(0x100, float:3.59E-43)
            r6 = 0
            if (r10 == r5) goto L1d
            if (r10 == r4) goto L1d
            if (r10 == r3) goto L1d
            if (r10 == r2) goto L1d
            if (r10 != r0) goto L5b
        L1d:
            android.content.Context r7 = r9.f16551a
            java.lang.String r7 = com.vivo.push.util.ad.a(r7)
            java.lang.String r8 = "com.vivo.pushservice"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L5b
            android.content.Context r7 = r9.f16551a
            long r7 = com.vivo.push.util.ak.a(r7)
            if (r10 == r5) goto L54
            if (r10 == r4) goto L4c
            if (r10 == r2) goto L44
            if (r10 == r0) goto L3c
            if (r10 == r3) goto L4c
            goto L5b
        L3c:
            r2 = 4400(0x1130, double:2.174E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L43
            return r1
        L43:
            return r6
        L44:
            r2 = 4200(0x1068, double:2.075E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L4b
            return r1
        L4b:
            return r6
        L4c:
            r2 = 4100(0x1004, double:2.0257E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L53
            return r1
        L53:
            return r6
        L54:
            r2 = 3700(0xe74, double:1.828E-320)
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 < 0) goto L5b
            return r1
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.a(int):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0071 A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #1 {Exception -> 0x006c, blocks: (B:29:0x0068, B:33:0x0071), top: B:63:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x009f A[Catch: Exception -> 0x0092, TRY_ENTER, TryCatch #8 {Exception -> 0x0092, blocks: (B:40:0x0089, B:42:0x008e, B:48:0x009f, B:50:0x00a4), top: B:69:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4 A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #8 {Exception -> 0x0092, blocks: (B:40:0x0089, B:42:0x008e, B:48:0x009f, B:50:0x00a4), top: B:69:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00b7 A[Catch: Exception -> 0x00b2, TRY_LEAVE, TryCatch #7 {Exception -> 0x00b2, blocks: (B:55:0x00ae, B:59:0x00b7), top: B:67:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[SYNTHETIC] */
    public static String a(Context context, String str) throws Throwable {
        Throwable th;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Exception exc;
        Cursor cursorQuery;
        Cursor cursor = null;
        cursor = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                if (context == null) {
                    w.a("CoreConfigManager", "queryFromCoreSdk context is null");
                    return null;
                }
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = y.f16915f;
                contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        w.a("CoreConfigManager", "queryFromCoreSdk client is null");
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, "queryParameter = ?  ", new String[]{str}, null);
                    } catch (Exception e9) {
                        exc = e9;
                        cursorQuery = null;
                        try {
                            w.a("CoreConfigManager", "queryFromCoreSdk error ", exc);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return string;
                        } catch (Throwable th2) {
                            th = th2;
                            contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e10) {
                                    w.a("CoreConfigManager", "queryFromCoreSdk close error", e10);
                                    throw th;
                                }
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    try {
                        cursorQuery = context.getContentResolver().query(uri, null, "queryParameter = ?  ", new String[]{str}, null);
                    } catch (Exception e11) {
                        exc = e11;
                        contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                        w.a("CoreConfigManager", "queryFromCoreSdk error ", exc);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            throw th;
                        }
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    w.a("CoreConfigManager", "queryFromCoreSdk cursor is null");
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } catch (Exception e12) {
                            w.a("CoreConfigManager", "queryFromCoreSdk close error", e12);
                        }
                    } else if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return null;
                }
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("queryAppState")) : null;
                cursorQuery.close();
                if (contentProviderClientAcquireUnstableContentProviderClient != 0) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                return string;
            } catch (Exception e13) {
                w.a("CoreConfigManager", "queryFromCoreSdk close error", e13);
            }
        } catch (Exception e14) {
            exc = e14;
            contentProviderClientAcquireUnstableContentProviderClient = null;
            cursorQuery = null;
        } catch (Throwable th5) {
            th = th5;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
    }
}
