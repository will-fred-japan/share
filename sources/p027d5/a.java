package p027d5;

import B0.AbstractC0287a;
import B0.F;
import B0.InterfaceC0307v;
import B0.O;
import B6.b;
import C6.c;
import K7.l;
import K7.p;
import S7.C0405q;
import S7.d0;
import W5.e;
import X7.r;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.apm.insight.CrashInfoCallback;
import com.apm.insight.CrashType;
import com.apm.insight.f;
import com.lzf.easyfloat.data.FloatConfig;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.clientreport.data.Config;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import p096m7.j;
import p127q4.g;
import p144s4.d;
import p152t4.h;
import p188x7.i;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class a implements p091m2.a, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f18516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f18517b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f18518c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f18519d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f18520e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f18521f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f18522g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f18523h = -1;

    public static final Object A(r rVar, r rVar2, p pVar) throws Throwable {
        Object c0405q;
        Object objV;
        try {
            B.b(2, pVar);
            c0405q = pVar.invoke(rVar2, rVar);
        } catch (Throwable th) {
            c0405q = new C0405q(th, false);
        }
        C7.a aVar = C7.a.f1806a;
        if (c0405q == aVar || (objV = rVar.V(c0405q)) == d0.f4271b) {
            return aVar;
        }
        if (objV instanceof C0405q) {
            throw ((C0405q) objV).f4300a;
        }
        return d0.b(objV);
    }

    public static final String B(String str) {
        k.e(str, "<this>");
        Pattern patternCompile = Pattern.compile("(.)(\\p{Upper})");
        k.d(patternCompile, "compile(...)");
        String strReplaceAll = patternCompile.matcher(str).replaceAll("$1_$2");
        k.d(strReplaceAll, "replaceAll(...)");
        Pattern patternCompile2 = Pattern.compile("(.) (.)");
        k.d(patternCompile2, "compile(...)");
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("$1_$2");
        k.d(strReplaceAll2, "replaceAll(...)");
        String upperCase = strReplaceAll2.toUpperCase(Locale.ROOT);
        k.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static void C(ByteArrayOutputStream byteArrayOutputStream, long j, int i9) throws IOException {
        byte[] bArr = new byte[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i10] = (byte) ((j >> (i10 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void D(ByteArrayOutputStream byteArrayOutputStream, int i9) throws IOException {
        C(byteArrayOutputStream, i9, 2);
    }

    public static String E(int i9) {
        if (i9 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i9 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i9 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }

    public static float e() {
        BigDecimal bigDecimal = new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        long jMaxMemory = f18523h;
        if (jMaxMemory == -1) {
            jMaxMemory = Runtime.getRuntime().maxMemory();
            f18523h = jMaxMemory;
        }
        return ((float) bigDecimal.divide(new BigDecimal(jMaxMemory), 4, 4).doubleValue()) * 100.0f;
    }

    public static StringBuilder f(String str) {
        return p171w.a.b(str);
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void h(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file.isDirectory()) {
                    h(file2);
                }
            }
        }
        file.delete();
    }

    public static void i(File file, CrashType crashType, String str) {
        try {
            if (p152t4.a.i()) {
                File file2 = crashType == CrashType.ANR ? null : new File(file, "external_files");
                if (file2 == null || !file2.exists()) {
                    file.mkdirs();
                    ArrayList arrayList = new ArrayList();
                    CopyOnWriteArrayList<CrashInfoCallback> copyOnWriteArrayList = p152t4.k.f21439f.f21412f;
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File[] fileArrCrashFileList = ((CrashInfoCallback) it.next()).crashFileList(crashType);
                        if (fileArrCrashFileList != null) {
                            long j = 0;
                            for (File file3 : fileArrCrashFileList) {
                                if (file3.exists() && !file3.isDirectory()) {
                                    if (crashType == CrashType.ANR) {
                                        long length = file3.length();
                                        if (length <= Config.DEFAULT_MAX_FILE_LENGTH) {
                                            long j8 = length + j;
                                            if (j8 <= 20971520) {
                                                arrayList.add(file3);
                                                j = j8;
                                            }
                                        }
                                    } else {
                                        d.h(file2, file3.getAbsolutePath() + "\n", true);
                                    }
                                }
                            }
                        }
                    }
                    if (crashType != CrashType.ANR || arrayList.isEmpty()) {
                        return;
                    }
                    g.h(f.f11859g.getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    for (CrashInfoCallback crashInfoCallback : copyOnWriteArrayList) {
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(File file, String str) {
        if (p152t4.a.i()) {
            File file2 = new File(file, "external_files");
            if (file2.exists()) {
                try {
                    JSONArray jSONArrayQ = d.q(file2.getAbsolutePath());
                    if (jSONArrayQ == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    long j = 0;
                    for (int i9 = 0; i9 < jSONArrayQ.length(); i9++) {
                        String strOptString = jSONArrayQ.optString(i9);
                        if (!TextUtils.isEmpty(strOptString)) {
                            File file3 = new File(strOptString);
                            if (file3.exists()) {
                                long length = file3.length() + j;
                                if (length <= 20971520) {
                                    arrayList.add(file3);
                                    j = length;
                                }
                            }
                        }
                    }
                    g.h(f.f11859g.getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    for (CrashInfoCallback crashInfoCallback : p152t4.k.f21439f.f21412f) {
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void k(String str, Throwable th) {
        if (f.f11853a == null) {
            return;
        }
        if (h.f21430c == -1) {
            h.f21430c = 5;
        }
        int i9 = h.f21431d;
        if (i9 < h.f21430c) {
            h.f21431d = i9 + 1;
            if (h.f21429b) {
                h.a().reportCustomErr(str, "INNER", th);
            }
        }
    }

    public static final g8.a l(j jVar) {
        Boolean bool = (Boolean) jVar.a("isSpeakerphoneOn");
        if (bool == null) {
            throw new IllegalStateException("isSpeakerphoneOn is required");
        }
        boolean zBooleanValue = bool.booleanValue();
        Boolean bool2 = (Boolean) jVar.a("stayAwake");
        if (bool2 == null) {
            throw new IllegalStateException("stayAwake is required");
        }
        boolean zBooleanValue2 = bool2.booleanValue();
        Integer num = (Integer) jVar.a("contentType");
        if (num == null) {
            throw new IllegalStateException("contentType is required");
        }
        int iIntValue = num.intValue();
        Integer num2 = (Integer) jVar.a("usageType");
        if (num2 == null) {
            throw new IllegalStateException("usageType is required");
        }
        int iIntValue2 = num2.intValue();
        Integer num3 = (Integer) jVar.a("audioFocus");
        if (num3 == null) {
            throw new IllegalStateException("audioFocus is required");
        }
        int iIntValue3 = num3.intValue();
        Integer num4 = (Integer) jVar.a("audioMode");
        if (num4 != null) {
            return new g8.a(iIntValue, iIntValue2, iIntValue3, num4.intValue(), zBooleanValue, zBooleanValue2);
        }
        throw new IllegalStateException("audioMode is required");
    }

    public static float m(float f6, float f9, float f10) {
        if (f6 < f9) {
            return f9;
        }
        return f6 > f10 ? f10 : f6;
    }

    public static int n(int i9, int i10, int i11) {
        if (i9 < i10) {
            return i10;
        }
        return i9 > i11 ? i11 : i9;
    }

    public static void o(BufferedReader bufferedReader) {
        if (bufferedReader == null) {
            return;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused) {
        }
    }

    public static final void p(l lVar, Exception exc) {
        lVar.invoke(new p188x7.f(p188x7.g.a(exc)));
    }

    public static byte[] q(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static int r(View view, WindowManager.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] != layoutParams.y) {
            return 0;
        }
        Context applicationContext = view.getContext().getApplicationContext();
        k.d(applicationContext, "view.context.applicationContext");
        Resources resources = applicationContext.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean s(String str) {
        AbstractC0287a.b bVar = O.f1639a;
        Set<InterfaceC0307v> setUnmodifiableSet = Collections.unmodifiableSet(AbstractC0287a.f1676c);
        HashSet hashSet = new HashSet();
        for (InterfaceC0307v interfaceC0307v : setUnmodifiableSet) {
            if (interfaceC0307v.a().equals(str)) {
                hashSet.add(interfaceC0307v);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException(e.l("Unknown feature ", str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0307v) it.next()).isSupported()) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(Context context, String str) {
        AbstractC0287a.b bVar = O.f1639a;
        Set<F> setUnmodifiableSet = Collections.unmodifiableSet(F.f1606c);
        HashSet hashSet = new HashSet();
        for (F f6 : setUnmodifiableSet) {
            if (f6.f1607a.equals(str)) {
                hashSet.add(f6);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException(e.l("Unknown feature ", str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((F) it.next()).a(context)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] u(InputStream inputStream, int i9) throws IOException {
        byte[] bArr = new byte[i9];
        int i10 = 0;
        while (i10 < i9) {
            int i11 = inputStream.read(bArr, i10, i9 - i10);
            if (i11 < 0) {
                throw new IllegalStateException(e.i(i9, "Not enough bytes to read: "));
            }
            i10 += i11;
        }
        return bArr;
    }

    public static byte[] v(FileInputStream fileInputStream, int i9, int i10) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i10];
            byte[] bArr2 = new byte[OpusCodecConfig.APPLICATION_VOIP];
            int i11 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i11 < i9) {
                int i12 = fileInputStream.read(bArr2);
                if (i12 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i9 + " bytes");
                }
                inflater.setInput(bArr2, 0, i12);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i10 - iInflate);
                    i11 += i12;
                } catch (DataFormatException e9) {
                    throw new IllegalStateException(e9.getMessage());
                }
            }
            if (i11 == i9) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i9 + " actual=" + i11);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static long w(InputStream inputStream, int i9) throws IOException {
        byte[] bArrU = u(inputStream, i9);
        long j = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            j += ((long) (bArrU[i10] & 255)) << (i10 * 8);
        }
        return j;
    }

    public static void z(String str, boolean z8) {
        FloatConfig floatConfig;
        A6.c cVar = A6.f.f1505a.get(str);
        boolean needShow$easyfloat_release = true;
        if (cVar != null && (floatConfig = cVar.f1490b) != null) {
            needShow$easyfloat_release = floatConfig.getNeedShow$easyfloat_release();
        }
        A6.c cVarB = A6.f.b(str);
        if (cVarB == null) {
            return;
        }
        cVarB.f(z8 ? 0 : 8, needShow$easyfloat_release);
        p188x7.k kVar = p188x7.k.f22364a;
    }

    @Override // p091m2.a
    public int a() {
        return 4;
    }

    @Override // p091m2.a
    public boolean b() {
        return false;
    }

    @Override // p091m2.a
    public int c() {
        return 15;
    }

    @Override // p091m2.a
    public long d() {
        return 600L;
    }

    public void x(boolean z8) {
        throw null;
    }

    public void y(boolean z8) {
        throw null;
    }

    @Override // p091m2.a
    public List a(String str) {
        return O1.a.f3456c;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0039. Please report as an issue. */
    @Override // C6.c
    public ValueAnimator a(final View view, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager, b sidePattern) {
        int i9;
        int i10;
        int right;
        int bottom;
        int i11;
        int iR;
        k.e(view, "view");
        k.e(sidePattern, "sidePattern");
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        int i12 = layoutParams.x;
        int right2 = rect.right - (view.getRight() + i12);
        int i13 = layoutParams.y;
        int bottom2 = rect.bottom - (view.getBottom() + i13);
        int iMin = Math.min(i12, right2);
        int iMin2 = Math.min(i13, bottom2);
        boolean z8 = false;
        switch (sidePattern.ordinal()) {
            case 0:
            case 5:
            case 12:
                i9 = layoutParams.x;
                if (i12 < right2) {
                    right = view.getRight();
                    i10 = -right;
                } else {
                    i10 = rect.right;
                }
                z8 = true;
                break;
            case 1:
            case 8:
                i9 = layoutParams.x;
                right = view.getRight();
                i10 = -right;
                z8 = true;
                break;
            case 2:
            case 9:
                i9 = layoutParams.x;
                i10 = rect.right;
                z8 = true;
                break;
            case 3:
            case 10:
                i9 = layoutParams.y;
                bottom = view.getBottom();
                i10 = -bottom;
                break;
            case 4:
            case 11:
                i9 = layoutParams.y;
                i11 = rect.bottom;
                iR = r(view, layoutParams);
                i10 = i11 + iR;
                break;
            case 6:
            case 13:
                i9 = layoutParams.y;
                if (i13 < bottom2) {
                    bottom = view.getBottom();
                    i10 = -bottom;
                } else {
                    i11 = rect.bottom;
                    iR = r(view, layoutParams);
                    i10 = i11 + iR;
                }
                break;
            case 7:
            default:
                if (iMin <= iMin2) {
                    i9 = layoutParams.x;
                    if (i12 < right2) {
                        right = view.getRight();
                        i10 = -right;
                    } else {
                        i10 = rect.right;
                    }
                    z8 = true;
                } else {
                    i9 = layoutParams.y;
                    if (i13 < bottom2) {
                        bottom = view.getBottom();
                        i10 = -bottom;
                    } else {
                        i11 = rect.bottom;
                        iR = r(view, layoutParams);
                        i10 = i11 + iR;
                    }
                }
                break;
        }
        Integer numValueOf = Integer.valueOf(i10);
        Integer numValueOf2 = Integer.valueOf(i9);
        final i iVar = new i(numValueOf, numValueOf2, Boolean.valueOf(z8));
        final ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(numValueOf.intValue(), numValueOf2.intValue());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: z6.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i iVar2 = iVar;
                WindowManager.LayoutParams layoutParams2 = layoutParams;
                WindowManager windowManager2 = windowManager;
                View view2 = view;
                k.e(view2, "$view");
                try {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    int iIntValue = ((Integer) animatedValue).intValue();
                    if (iVar2.f22362c.booleanValue()) {
                        layoutParams2.x = iIntValue;
                    } else {
                        layoutParams2.y = iIntValue;
                    }
                    windowManager2.updateViewLayout(view2, layoutParams2);
                } catch (Exception unused) {
                    valueAnimatorOfInt.cancel();
                }
            }
        });
        return valueAnimatorOfInt;
    }
}
