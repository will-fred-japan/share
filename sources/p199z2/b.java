package p199z2;

import C6.g;
import L5.f;
import L5.n;
import O7.h;
import P7.c;
import U5.q;
import Z3.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.datastore.preferences.protobuf.C0524s;
import androidx.lifecycle.InterfaceC0548n;
import cn.ikaile.ruoshui.client.MainActivity;
import cn.ikaile.ruoshui.client.R;
import com.alibaba.fastjson.asm.Opcodes;
import com.huawei.agconnect.exception.AGCServerException;
import com.starburst.sdk.utils.j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DiskEnvironmentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements C6.b, a, p008b1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f22471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f22472b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f22473c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static File f22474d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f22475e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f22476f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f22477g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f22478h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f22479i = null;
    public static long j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f22480k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f22481l = "https://";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char[] f22482m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class A(c cVar) {
        k.e(cVar, "<this>");
        Class<?> clsB = ((kotlin.jvm.internal.c) cVar).b();
        if (clsB.isPrimitive()) {
            String name = clsB.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsB;
    }

    public static final int B(int i9, int i10, int i11) {
        if (i11 > 0) {
            if (i9 < i10) {
                int i12 = i10 % i11;
                if (i12 < 0) {
                    i12 += i11;
                }
                int i13 = i9 % i11;
                if (i13 < 0) {
                    i13 += i11;
                }
                int i14 = (i12 - i13) % i11;
                if (i14 < 0) {
                    i14 += i11;
                }
                return i10 - i14;
            }
        } else {
            if (i11 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i9 > i10) {
                int i15 = -i11;
                int i16 = i9 % i15;
                if (i16 < 0) {
                    i16 += i15;
                }
                int i17 = i10 % i15;
                if (i17 < 0) {
                    i17 += i15;
                }
                int i18 = (i16 - i17) % i15;
                if (i18 < 0) {
                    i18 += i15;
                }
                return i18 + i10;
            }
        }
        return i10;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static final String C(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(k.h("getprop ", str)).getInputStream()), 1024);
            try {
                try {
                    String line = bufferedReader.readLine();
                    k.d(line, "input.readLine()");
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                        return line;
                    } catch (IOException e9) {
                        Log.e("RomUtils--->", "Exception while closing InputStream", e9);
                        return line;
                    }
                } catch (Exception e10) {
                    e = e10;
                    Log.e("RomUtils--->", k.h("Unable to read sysprop ", str), e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            Log.e("RomUtils--->", "Exception while closing InputStream", e11);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        Log.e("RomUtils--->", "Exception while closing InputStream", e12);
                    }
                }
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static boolean D(int i9) {
        return i9 >= 2;
    }

    public static final boolean E(char c5) {
        return Character.isWhitespace(c5) || Character.isSpaceChar(c5);
    }

    public static void F(Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(872415232);
            context.startActivity(intent);
            Log.i("PushLaunchHelper", "Push notification click launched MainActivity");
        } catch (Exception e9) {
            Log.e("PushLaunchHelper", "Failed to launch MainActivity from push notification", e9);
        }
    }

    public static long G(int i9, byte[] bArr) {
        return ((long) (((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16))) & 4294967295L;
    }

    public static Long H(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static final void I(Activity activity, g gVar) {
        k.e(activity, "activity");
        D6.b.f1937a = gVar;
        activity.getFragmentManager().beginTransaction().add(new D6.b(), activity.getLocalClassName()).commitAllowingStateLoss();
    }

    public static final void J(View view, InterfaceC0548n interfaceC0548n) {
        k.e(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, interfaceC0548n);
    }

    public static void K(byte[] bArr, long j8, int i9) {
        int i10 = 0;
        while (i10 < 4) {
            bArr[i9 + i10] = (byte) (255 & j8);
            i10++;
            j8 >>= 8;
        }
    }

    public static final boolean L(String str, K7.a aVar) {
        try {
            boolean zBooleanValue = ((Boolean) aVar.invoke()).booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static void M(Parcel parcel, int i9, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeBundle(bundle);
        V(parcel, iU);
    }

    public static void N(Parcel parcel, int i9, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeStrongBinder(iBinder);
        V(parcel, iU);
    }

    public static void O(Parcel parcel, int i9, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeIntArray(iArr);
        V(parcel, iU);
    }

    public static void P(Parcel parcel, int i9, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcelable.writeToParcel(parcel, i10);
        V(parcel, iU);
    }

    public static void Q(Parcel parcel, int i9, String str) {
        if (str == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeString(str);
        V(parcel, iU);
    }

    public static void R(Parcel parcel, int i9, List list) {
        if (list == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeStringList(list);
        V(parcel, iU);
    }

    public static void S(Parcel parcel, int i9, Parcelable[] parcelableArr, int i10) {
        if (parcelableArr == null) {
            return;
        }
        int iU = U(parcel, i9);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i10);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        V(parcel, iU);
    }

    public static void T(Parcel parcel, int i9, List list) {
        if (list == null) {
            return;
        }
        int iU = U(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            Parcelable parcelable = (Parcelable) list.get(i10);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        V(parcel, iU);
    }

    public static int U(Parcel parcel, int i9) {
        parcel.writeInt(i9 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void V(Parcel parcel, int i9) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i9 - 4);
        parcel.writeInt(iDataPosition - i9);
        parcel.setDataPosition(iDataPosition);
    }

    public static void W(Parcel parcel, int i9, int i10) {
        parcel.writeInt(i9 | (i10 << 16));
    }

    public static long d() {
        if (j == -1) {
            j = (N2.a.y1() << 16) | ((long) Process.myPid());
        }
        return j;
    }

    public static synchronized File e() {
        try {
            if (f22472b == null) {
                File file = new File(o(), "flush");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f22472b = file;
                if (A1.b.f1393A) {
                    p010b3.b.a(a.f22469a, "prepare FlushDirectory success. name=" + f22472b);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22472b;
    }

    public static String f(String[] strArr) {
        StringBuilder sb = new StringBuilder(AGCServerException.AUTHENTICATION_INVALID);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static JSONObject g(B2.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = aVar.f1717z;
            if (jSONObject2 != null) {
                jSONObject = A1.b.A0(jSONObject, jSONObject2);
            }
            if (!TextUtils.isEmpty(aVar.f1695b)) {
                jSONObject.put("device_id", aVar.f1695b);
            }
            JSONObject jSONObject3 = aVar.f1716y;
            if (jSONObject3 != null) {
                jSONObject = A1.b.A0(jSONObject, jSONObject3);
            }
            jSONObject.put("version_code", aVar.f1700g);
            jSONObject.put("version_name", aVar.f1701h);
            jSONObject.put("manifest_version_code", aVar.f1699f);
            jSONObject.put("update_version_code", aVar.f1697d);
            jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, aVar.f1698e);
            jSONObject.put("os", aVar.j);
            jSONObject.put("device_platform", aVar.f1703k);
            if (N2.a.f3199c0) {
                jSONObject.put("os_api", aVar.f1705m);
                jSONObject.put("os_version", aVar.f1704l);
            }
            if (N2.a.f3198b0) {
                jSONObject.put("device_model", aVar.f1706n);
            }
            jSONObject.put("device_brand", aVar.f1707o);
            jSONObject.put("device_manufacturer", aVar.f1708p);
            jSONObject.put("process_name", aVar.f1709q);
            jSONObject.put("sid", aVar.f1710r);
            jSONObject.put("rom_version", aVar.f1711s);
            jSONObject.put("package", aVar.t);
            jSONObject.put("monitor_version", aVar.f1712u);
            jSONObject.put("channel", aVar.f1696c);
            jSONObject.put("aid", aVar.f1694a);
            jSONObject.put("uid", aVar.f1713v);
            jSONObject.put("phone_startup_time", aVar.f1714w);
            jSONObject.put("release_build", aVar.f1702i);
            long j8 = aVar.f1691C;
            if (j8 != -1) {
                jSONObject.put("config_time", String.valueOf(j8));
            }
            if (!TextUtils.isEmpty(aVar.f1715x)) {
                jSONObject.put("verify_info", aVar.f1715x);
            }
            jSONObject.put("current_update_version_code", aVar.f1690B);
            long j9 = aVar.f1692D;
            if (j9 != -1) {
                jSONObject.put("ntp_time", j9);
            }
            long j10 = aVar.f1693E;
            if (j10 != -1) {
                jSONObject.put("ntp_offset", j10);
            }
            JSONObject jSONObject4 = aVar.f1689A;
            if (jSONObject4 != null) {
                jSONObject.put("filters", jSONObject4);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void i(String str, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i9 = 0; i9 < length; i9 += 2) {
            try {
                jSONObject.put(String.valueOf(objArr[i9]), String.valueOf(objArr[i9 + 1]));
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        }
        Log.i(str, f(new String[]{jSONObject.toString()}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    public static void j(String str, String... strArr) throws Throwable {
        ?? r8;
        Closeable closeable;
        Object obj;
        Exception e9;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream2, new CRC32());
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
                        try {
                            for (String str2 : strArr) {
                                File file2 = new File(str2);
                                if (!file2.exists()) {
                                    throw new RuntimeException(str2 + "不存在！");
                                }
                                k(zipOutputStream, file2, "");
                            }
                            h(zipOutputStream);
                            h(checkedOutputStream);
                            h(fileOutputStream2);
                        } catch (Exception e10) {
                            e9 = e10;
                            throw new RuntimeException(e9);
                        }
                    } catch (Exception e11) {
                        e = e11;
                        e9 = e;
                        throw new RuntimeException(e9);
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        obj = checkedOutputStream;
                        fileOutputStream = fileOutputStream2;
                        r8 = obj;
                        h(closeable);
                        h(r8);
                        h(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = file;
            }
        } catch (Exception e13) {
            e = e13;
        } catch (Throwable th4) {
            th = th4;
            r8 = 0;
            closeable = null;
            h(closeable);
            h(r8);
            h(fileOutputStream);
            throw th;
        }
    }

    public static void k(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        Closeable closeable;
        FileInputStream fileInputStream;
        if (file.isDirectory()) {
            StringBuilder sbB = p171w.a.b(str);
            sbB.append(file.getName());
            sbB.append(File.separator);
            String string = sbB.toString();
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    k(zipOutputStream, file2, string);
                }
                return;
            }
            return;
        }
        if (A1.b.f1427z) {
            A1.b.Z("压缩：" + str + file.getName());
        }
        if (!file.exists()) {
            return;
        }
        Closeable closeable2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i9 = bufferedInputStream.read(bArr, 0, 8192);
                            if (i9 == -1) {
                                h(bufferedInputStream);
                                h(fileInputStream);
                                return;
                            }
                            zipOutputStream.write(bArr, 0, i9);
                        }
                    } catch (Exception e9) {
                        e = e9;
                        closeable2 = bufferedInputStream;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = bufferedInputStream;
                        closeable = closeable2;
                        closeable2 = fileInputStream;
                        h(closeable);
                        h(closeable2);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            h(closeable);
            h(closeable2);
            throw th;
        }
    }

    public static void l(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        j.f(str, sb.toString());
    }

    public static synchronized File m() {
        try {
            if (f22473c == null) {
                File file = N2.a.C1() ? new File(o(), "persistent") : new File(o(), "child_process_persistent");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f22473c = file;
                if (A1.b.f1393A) {
                    p010b3.b.a(a.f22469a, "prepare PersistentDirectory success. name=" + f22473c);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22473c;
    }

    public static String n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        if (length > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i9 = length * 2;
        char[] cArr = new char[i9];
        int i10 = 0;
        for (byte b9 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f22482m;
            cArr[i10] = cArr2[(b9 & 255) >> 4];
            i10 += 2;
            cArr[i11] = cArr2[b9 & 15];
        }
        return new String(cArr, 0, i9);
    }

    public static synchronized File o() {
        try {
            if (f22474d == null) {
                File file = new File(A1.b.f1394B.getFilesDir(), "apm6");
                f22474d = file;
                if (!file.exists()) {
                    f22474d.mkdirs();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22474d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        if (R7.l.O(r0, "flyme", false) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean p(android.content.Context r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.k.e(r7, r0)
            java.lang.String r0 = "ro.build.display.id"
            java.lang.String r0 = C(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r1 == 0) goto L13
            goto L2f
        L13:
            kotlin.jvm.internal.k.b(r0)
            java.lang.String r1 = "flyme"
            r3 = 0
            boolean r4 = R7.l.O(r0, r1, r3)
            if (r4 != 0) goto L68
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.k.d(r0, r4)
            boolean r0 = R7.l.O(r0, r1, r3)
            if (r0 == 0) goto L2f
            goto L68
        L2f:
            java.lang.Class<android.provider.Settings> r0 = android.provider.Settings.class
            java.lang.String r1 = "canDrawOverlays"
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3}     // Catch: java.lang.Exception -> L54
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch: java.lang.Exception -> L54
            java.lang.String r1 = "clazz.getDeclaredMethod(…ys\", Context::class.java)"
            kotlin.jvm.internal.k.d(r0, r1)     // Catch: java.lang.Exception -> L54
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch: java.lang.Exception -> L54
            r1 = 0
            java.lang.Object r7 = r0.invoke(r1, r7)     // Catch: java.lang.Exception -> L54
            if (r7 == 0) goto L56
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L54
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> L54
            return r7
        L54:
            r7 = move-exception
            goto L5e
        L56:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L54
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r7.<init>(r0)     // Catch: java.lang.Exception -> L54
            throw r7     // Catch: java.lang.Exception -> L54
        L5e:
            java.lang.String r0 = "PermissionUtils--->"
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            android.util.Log.e(r0, r7)
            return r2
        L68:
            java.lang.String r0 = "appops"
            java.lang.Object r0 = r7.getSystemService(r0)
            android.app.AppOpsManager r0 = (android.app.AppOpsManager) r0
            java.lang.Class<android.app.AppOpsManager> r1 = android.app.AppOpsManager.class
            java.lang.String r4 = "checkOp"
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> La3
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5, r5, r6}     // Catch: java.lang.Exception -> La3
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> La3
            r4 = 24
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> La3
            int r5 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> La3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> La3
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Exception -> La3
            java.lang.Object[] r7 = new java.lang.Object[]{r4, r5, r7}     // Catch: java.lang.Exception -> La3
            java.lang.Object r7 = r1.invoke(r0, r7)     // Catch: java.lang.Exception -> La3
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Exception -> La3
            int r7 = r7.intValue()     // Catch: java.lang.Exception -> La3
            if (r7 != 0) goto Lad
            goto Lae
        La3:
            r7 = move-exception
            java.lang.String r0 = "MeizuUtils"
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            android.util.Log.e(r0, r7)
        Lad:
            r2 = r3
        Lae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p199z2.b.p(android.content.Context):boolean");
    }

    public static void q(int i9) {
        if (2 > i9 || i9 >= 37) {
            StringBuilder sbA = C0524s.a(i9, "radix ", " was not in valid range ");
            sbA.append(new h(2, 36, 1));
            throw new IllegalArgumentException(sbA.toString());
        }
    }

    public static final void r(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                p188x7.j.a(th, th2);
            }
        }
    }

    public static final void s(D6.b bVar) {
        try {
            Field declaredField = Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION");
            k.d(declaredField, "clazz.getDeclaredField(\"…NAGE_OVERLAY_PERMISSION\")");
            Intent intent = new Intent(declaredField.get(null).toString());
            intent.setData(Uri.parse(k.h("package:", bVar.getActivity().getPackageName())));
            bVar.startActivityForResult(intent, Opcodes.IFNONNULL);
        } catch (Exception e9) {
            String.valueOf(e9);
        }
    }

    public static int t(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static byte[] u(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jG = G(0, bArr) & 67108863;
        int i9 = 3;
        long jG2 = (G(3, bArr) >> 2) & 67108611;
        long jG3 = (G(6, bArr) >> 4) & 67092735;
        long jG4 = (G(9, bArr) >> 6) & 66076671;
        long jG5 = (G(12, bArr) >> 8) & 1048575;
        long j8 = jG2 * 5;
        long j9 = jG3 * 5;
        long j10 = jG4 * 5;
        long j11 = jG5 * 5;
        byte[] bArr3 = new byte[17];
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        int i10 = 0;
        while (i10 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i10);
            System.arraycopy(bArr2, i10, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jG6 = j16 + (G(0, bArr3) & 67108863);
            long jG7 = j12 + ((G(i9, bArr3) >> 2) & 67108863);
            long jG8 = j13 + ((G(6, bArr3) >> 4) & 67108863);
            long jG9 = j14 + ((G(9, bArr3) >> 6) & 67108863);
            long j17 = jG2;
            long jG10 = j15 + (((G(12, bArr3) >> 8) & 67108863) | ((long) (bArr3[16] << 24)));
            long j18 = (jG10 * j8) + (jG9 * j9) + (jG8 * j10) + (jG7 * j11) + (jG6 * jG);
            long j19 = (jG10 * j9) + (jG9 * j10) + (jG8 * j11) + (jG7 * jG) + (jG6 * j17);
            long j20 = (jG10 * j10) + (jG9 * j11) + (jG8 * jG) + (jG7 * j17) + (jG6 * jG3);
            long j21 = (jG10 * j11) + (jG9 * jG) + (jG8 * j17) + (jG7 * jG3) + (jG6 * jG4);
            long j22 = jG9 * j17;
            long j23 = jG10 * jG;
            long j24 = j19 + (j18 >> 26);
            long j25 = j20 + (j24 >> 26);
            long j26 = j21 + (j25 >> 26);
            long j27 = j23 + j22 + (jG8 * jG3) + (jG7 * jG4) + (jG6 * jG5) + (j26 >> 26);
            long j28 = j27 >> 26;
            j15 = j27 & 67108863;
            long j29 = (j28 * 5) + (j18 & 67108863);
            i10 += 16;
            j13 = j25 & 67108863;
            j14 = j26 & 67108863;
            j16 = j29 & 67108863;
            j12 = (j24 & 67108863) + (j29 >> 26);
            jG2 = j17;
            i9 = 3;
        }
        long j30 = j13 + (j12 >> 26);
        long j31 = j30 & 67108863;
        long j32 = j14 + (j30 >> 26);
        long j33 = j32 & 67108863;
        long j34 = j15 + (j32 >> 26);
        long j35 = j34 & 67108863;
        long j36 = ((j34 >> 26) * 5) + j16;
        long j37 = j36 >> 26;
        long j38 = j36 & 67108863;
        long j39 = (j12 & 67108863) + j37;
        long j40 = j38 + 5;
        long j41 = j40 & 67108863;
        long j42 = j39 + (j40 >> 26);
        long j43 = j31 + (j42 >> 26);
        long j44 = j33 + (j43 >> 26);
        long j45 = j44 & 67108863;
        long j46 = (j35 + (j44 >> 26)) - 67108864;
        long j47 = j46 >> 63;
        long j48 = j38 & j47;
        long j49 = j39 & j47;
        long j50 = j31 & j47;
        long j51 = j33 & j47;
        long j52 = j35 & j47;
        long j53 = ~j47;
        long j54 = j49 | (j42 & 67108863 & j53);
        long j55 = j50 | (j43 & 67108863 & j53);
        long j56 = j51 | (j45 & j53);
        long j57 = (j48 | (j41 & j53) | (j54 << 26)) & 4294967295L;
        long j58 = ((j54 >> 6) | (j55 << 20)) & 4294967295L;
        long j59 = ((j55 >> 12) | (j56 << 14)) & 4294967295L;
        long j60 = ((j56 >> 18) | ((j52 | (j46 & j53)) << 8)) & 4294967295L;
        long jG11 = G(16, bArr) + j57;
        long j61 = jG11 & 4294967295L;
        long jG12 = G(20, bArr) + j58 + (jG11 >> 32);
        long jG13 = G(24, bArr) + j59 + (jG12 >> 32);
        long jG14 = (G(28, bArr) + j60 + (jG13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        K(bArr4, j61, 0);
        K(bArr4, jG12 & 4294967295L, 4);
        K(bArr4, jG13 & 4294967295L, 8);
        K(bArr4, jG14, 12);
        return bArr4;
    }

    public static byte[] v(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            int iDigit = Character.digit(str.charAt(i10), 16);
            int iDigit2 = Character.digit(str.charAt(i10 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i9] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }

    public static boolean w(Method method, d dVar) {
        Class<?> clsB = dVar.b();
        k.c(clsB, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return method.getReturnType().equals(clsB);
    }

    public static String x(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            int i9 = b9 & 255;
            sb.append("0123456789abcdef".charAt(i9 / 16));
            sb.append("0123456789abcdef".charAt(i9 % 16));
        }
        return sb.toString();
    }

    public static final boolean y(char c5, char c9, boolean z8) {
        if (c5 == c9) {
            return true;
        }
        if (!z8) {
            return false;
        }
        char upperCase = Character.toUpperCase(c5);
        char upperCase2 = Character.toUpperCase(c9);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static f z(String str) {
        n nVar;
        q qVar = q.f4725b;
        synchronized (qVar) {
            if (!qVar.f4726a.containsKey(str)) {
                throw new GeneralSecurityException("Name " + str + " does not exist");
            }
            nVar = (n) qVar.f4726a.get(str);
        }
        return new f(nVar);
    }

    @Override // Z3.a
    public Z3.b a(String str, byte[] bArr, Map map) {
        return new Z3.b(200, O0.a.c(str, (HashMap) map, bArr).getBytes());
    }

    @Override // C6.b
    public int b(Context context) {
        Point point = new Point();
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        int i9 = point.x;
        int i10 = point.y;
        return i9 > i10 ? i10 : i10 - A1.b.b1(context);
    }

    @Override // Z3.a
    public Z3.b c(String str, Map map) {
        return null;
    }

    @Override // p008b1.b
    public void invokeHiddenApiRestrictions() {
    }
}
