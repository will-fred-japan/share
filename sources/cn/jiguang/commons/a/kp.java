package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.starburst.sdk.core.tts.EventType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class kp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f10371a = {90, 65, 111, 105, 56, 125, 81, 78, 126, 38, 68, EventType.ERROR, 94, 84, 112, 101, 115};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f10372b = {118, 85, 84, 75, 125, 120, 101, 89, 77, 124};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f10373c = {116, 72, 69, 122};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f10374d = {39, 101, 104, 67, 84, 124, 101, 57, 115, 89, 78, 54, 123, 126};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f10375e = {102, 124, 16, 76, 112, 123, 98, 49, 64, 65, 122, 99, 119, 118, 85};

    public static Process a(Object[] objArr) {
        try {
            Class<?> cls = Class.forName(jr.a(f10371a));
            Method declaredMethod = cls.getDeclaredMethod(jr.a(f10372b), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(jr.a(f10373c), String.class);
            declaredMethod2.setAccessible(true);
            return (Process) declaredMethod2.invoke(objInvoke, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<String> a() {
        List<String> listA = a(new String[]{jr.a(f10375e)}, 1);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < listA.size(); i9++) {
            String str = listA.get(i9);
            if (!TextUtils.isEmpty(str) && str.startsWith("package:")) {
                String strSubstring = str.substring(8);
                if (!TextUtils.isEmpty(strSubstring)) {
                    arrayList.add(strSubstring);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r2 != null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> a(java.lang.String[] r8, int r9) {
        /*
            java.lang.String r0 = "executeCommand "
            java.lang.String r1 = "ShellUtils"
            r2 = 0
            if (r9 == 0) goto Ld
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            goto Le
        Ld:
            r3 = r2
        Le:
            java.lang.Process r2 = a(r8)     // Catch: java.lang.Throwable -> L13
            goto L30
        L13:
            int r4 = r8.length     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r5 = 2
            int r4 = r4 + r5
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            byte[] r6 = cn.jiguang.commons.a.kp.f10374d     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r6 = cn.jiguang.commons.a.jr.a(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r7 = "-c"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r7 = 0
            java.lang.System.arraycopy(r6, r7, r4, r7, r5)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            int r6 = r8.length     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.System.arraycopy(r8, r7, r4, r5, r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.Process r2 = a(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L30:
            if (r9 == 0) goto L5f
            if (r2 == 0) goto L5f
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L42:
            java.lang.String r4 = r9.readLine()     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L4e
            r3.add(r4)     // Catch: java.lang.Throwable -> L4c
            goto L42
        L4c:
            r4 = move-exception
            goto L56
        L4e:
            r9.close()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            goto L5f
        L52:
            r9 = move-exception
            goto L69
        L54:
            r9 = move-exception
            goto L8d
        L56:
            r9.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r9 = move-exception
            r4.addSuppressed(r9)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5e:
            throw r4     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5f:
            if (r2 == 0) goto Laf
        L61:
            r2.exitValue()     // Catch: java.lang.IllegalThreadStateException -> L65
            goto Laf
        L65:
            r2.destroy()
            goto Laf
        L69:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = java.util.Arrays.toString(r8)     // Catch: java.lang.Throwable -> L8b
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = " throwable: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r9.getMessage()     // Catch: java.lang.Throwable -> L8b
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L8b
            cn.jiguang.commons.a.ee.d(r1, r8)     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto Laf
            goto L61
        L8b:
            r8 = move-exception
            goto Lb0
        L8d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = java.util.Arrays.toString(r8)     // Catch: java.lang.Throwable -> L8b
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = " exception: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r9.getMessage()     // Catch: java.lang.Throwable -> L8b
            r4.append(r8)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L8b
            cn.jiguang.commons.a.ee.d(r1, r8)     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto Laf
            goto L61
        Laf:
            return r3
        Lb0:
            if (r2 == 0) goto Lb9
            r2.exitValue()     // Catch: java.lang.IllegalThreadStateException -> Lb6
            goto Lb9
        Lb6:
            r2.destroy()
        Lb9:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.commons.a.kp.a(java.lang.String[], int):java.util.List");
    }
}
