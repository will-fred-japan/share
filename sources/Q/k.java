package Q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FontRequestWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p155u.f<String, Typeface> f3673a = new p155u.f<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f3674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p155u.g<String, ArrayList<S.a<a>>> f3676d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f3674b = threadPoolExecutor;
        f3675c = new Object();
        f3676d = new p155u.g<>();
    }

    public static String a(int i9, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb.append(((f) list.get(i10)).f3662g);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(i9);
            if (i10 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static a b(Context context, int i9, List list, String str) {
        int i10;
        Typeface typefaceB;
        Trace.beginSection(p156u0.a.c("getFontSync"));
        p155u.f<String, Typeface> fVar = f3673a;
        try {
            Typeface typefaceA = fVar.a(str);
            if (typefaceA != null) {
                a aVar = new a(typefaceA);
                Trace.endSection();
                return aVar;
            }
            try {
                l lVarA = e.a(context, list);
                int i11 = lVarA.f3679a;
                List<m[]> list2 = lVarA.f3680b;
                if (i11 == 0) {
                    m[] mVarArr = list2.get(0);
                    if (mVarArr == null || mVarArr.length == 0) {
                        i10 = 1;
                    } else {
                        int length = mVarArr.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length) {
                                i10 = 0;
                                break;
                            }
                            int i13 = mVarArr[i12].f3686f;
                            if (i13 != 0) {
                                if (i13 >= 0) {
                                    i10 = i13;
                                    break;
                                }
                                i10 = -3;
                                break;
                            }
                            i12++;
                        }
                    }
                } else {
                    if (i11 != 1) {
                        i10 = -3;
                        break;
                    }
                    i10 = -2;
                }
                if (i10 != 0) {
                    a aVar2 = new a(i10);
                    Trace.endSection();
                    return aVar2;
                }
                if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                    m[] mVarArr2 = list2.get(0);
                    K.j jVar = K.d.f2750a;
                    Trace.beginSection(p156u0.a.c("TypefaceCompat.createFromFontInfo"));
                    try {
                        typefaceB = K.d.f2750a.b(context, mVarArr2, i9);
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    K.j jVar2 = K.d.f2750a;
                    Trace.beginSection(p156u0.a.c("TypefaceCompat.createFromFontInfoWithFallback"));
                    try {
                        typefaceB = K.d.f2750a.c(context, list2, i9);
                        Trace.endSection();
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                if (typefaceB == null) {
                    a aVar3 = new a(-3);
                    Trace.endSection();
                    return aVar3;
                }
                fVar.b(str, typefaceB);
                a aVar4 = new a(typefaceB);
                Trace.endSection();
                return aVar4;
            } catch (PackageManager.NameNotFoundException unused) {
                a aVar5 = new a(-1);
                Trace.endSection();
                return aVar5;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }

    /* JADX INFO: compiled from: FontRequestWorker.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f3677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3678b;

        public a(int i9) {
            this.f3677a = null;
            this.f3678b = i9;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f3677a = typeface;
            this.f3678b = 0;
        }
    }
}
