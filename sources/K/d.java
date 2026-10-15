package K;

import B0.C0300n;
import B0.C0301o;
import B0.C0302p;
import G.o;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p155u.f<String, Typeface> f2751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Paint f2752c;

    /* JADX INFO: compiled from: TypefaceCompat.java */
    public static class a extends A1.b {

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public J.g.c f2753L;
    }

    static {
        Trace.beginSection(p156u0.a.c("TypefaceCompat static init"));
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 31) {
            f2750a = new i();
        } else if (i9 >= 29) {
            f2750a = new h();
        } else if (i9 >= 28) {
            f2750a = new g();
        } else {
            f2750a = new f();
        }
        f2751b = new p155u.f<>(16);
        f2752c = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, J.e.a aVar, Resources resources, int i9, String str, int i10, int i11, J.g.c cVar, boolean z8) {
        Typeface typefaceA;
        Typeface typefaceBuild;
        FontFamily fontFamilyBuild;
        int i12 = 3;
        int i13 = 0;
        if (aVar instanceof J.e.d) {
            J.e.d dVar = (J.e.d) aVar;
            String str2 = dVar.f2620d;
            typefaceA = null;
            if (TextUtils.isEmpty(str2) || (typefaceBuild = c(str2)) == null) {
                ArrayList arrayList = dVar.f2617a;
                if (arrayList.size() != 1) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i14 = 0;
                        while (true) {
                            if (i14 >= arrayList.size()) {
                                int i15 = 0;
                                Typeface.CustomFallbackBuilder customFallbackBuilderH = null;
                                while (true) {
                                    if (i15 < arrayList.size()) {
                                        Q.f fVar = (Q.f) arrayList.get(i15);
                                        if (i15 == arrayList.size() - 1 && TextUtils.isEmpty(fVar.f3661f)) {
                                            customFallbackBuilderH.setSystemFallback(fVar.f3660e);
                                        } else {
                                            Font fontD = d(c(fVar.f3660e));
                                            if (fontD == null) {
                                                Log.w("TypefaceCompat", "Unable identify the primary font for " + fVar.f3660e + ". Falling back to provider font.");
                                            } else {
                                                String str3 = fVar.f3661f;
                                                if (TextUtils.isEmpty(str3)) {
                                                    fontFamilyBuild = C0301o.h(fontD).build();
                                                } else {
                                                    try {
                                                        C0300n.q();
                                                        C0301o.x();
                                                        fontFamilyBuild = C0301o.h(o.c(fontD).setFontVariationSettings(str3).build()).build();
                                                    } catch (IOException unused) {
                                                        Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                                    }
                                                }
                                                if (customFallbackBuilderH == null) {
                                                    customFallbackBuilderH = C0302p.h(fontFamilyBuild);
                                                } else {
                                                    customFallbackBuilderH.addCustomFallback(fontFamilyBuild);
                                                }
                                                i15++;
                                            }
                                        }
                                    }
                                    typefaceBuild = customFallbackBuilderH.build();
                                    break;
                                }
                            }
                            if (c(((Q.f) arrayList.get(i14)).f3660e) != null) {
                                i14++;
                            }
                            typefaceBuild = null;
                            break;
                        }
                    }
                    typefaceBuild = null;
                    break;
                }
                typefaceBuild = c(((Q.f) arrayList.get(0)).f3660e);
            }
            if (typefaceBuild != null) {
                if (cVar != null) {
                    new Handler(Looper.getMainLooper()).post(new G6.b(i12, cVar, typefaceBuild));
                }
                f2751b.b(b(resources, i9, str, i10, i11), typefaceBuild);
                return typefaceBuild;
            }
            boolean z9 = !z8 ? cVar != null : dVar.f2619c != 0;
            int i16 = z8 ? dVar.f2618b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            a aVar2 = new a();
            aVar2.f2753L = cVar;
            ArrayList arrayList2 = dVar.f2617a;
            P.c cVar2 = new P.c(handler, 1);
            Q.c cVar3 = new Q.c(aVar2, cVar2);
            if (!z9) {
                String strA = Q.k.a(i11, arrayList2);
                Typeface typefaceA2 = Q.k.f3673a.a(strA);
                if (typefaceA2 != null) {
                    cVar2.execute(new Q.a(i13, aVar2, typefaceA2));
                    typefaceA = typefaceA2;
                } else {
                    Q.h hVar = new Q.h(cVar3);
                    synchronized (Q.k.f3675c) {
                        try {
                            p155u.g<String, ArrayList<S.a<Q.k.a>>> gVar = Q.k.f3676d;
                            ArrayList<S.a<Q.k.a>> arrayList3 = gVar.get(strA);
                            if (arrayList3 != null) {
                                arrayList3.add(hVar);
                            } else {
                                ArrayList<S.a<Q.k.a>> arrayList4 = new ArrayList<>();
                                arrayList4.add(hVar);
                                gVar.put(strA, arrayList4);
                                Q.i iVar = new Q.i(strA, context, arrayList2, i11);
                                ThreadPoolExecutor threadPoolExecutor = Q.k.f3674b;
                                Q.j jVar = new Q.j(strA);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                Q.o oVar = new Q.o();
                                oVar.f3688a = iVar;
                                oVar.f3689b = jVar;
                                oVar.f3690c = handler2;
                                threadPoolExecutor.execute(oVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
                Q.f fVar2 = (Q.f) arrayList2.get(0);
                p155u.f<String, Typeface> fVar3 = Q.k.f3673a;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[]{fVar2}[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String strA2 = Q.k.a(i11, Collections.unmodifiableList(arrayList5));
                Typeface typefaceA3 = Q.k.f3673a.a(strA2);
                if (typefaceA3 != null) {
                    cVar2.execute(new Q.a(i13, aVar2, typefaceA3));
                    typefaceA = typefaceA3;
                } else if (i16 == -1) {
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = new Object[]{fVar2}[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    Q.k.a aVarB = Q.k.b(context, i11, Collections.unmodifiableList(arrayList6), strA2);
                    cVar3.a(aVarB);
                    typefaceA = aVarB.f3677a;
                } else {
                    try {
                        try {
                            try {
                                try {
                                    Q.k.a aVar3 = (Q.k.a) Q.k.f3674b.submit(new Q.g(strA2, context, fVar2, i11)).get(i16, TimeUnit.MILLISECONDS);
                                    cVar3.a(aVar3);
                                    typefaceA = aVar3.f3677a;
                                } catch (TimeoutException unused2) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e9) {
                                throw e9;
                            }
                        } catch (ExecutionException e10) {
                            throw new RuntimeException(e10);
                        }
                    } catch (InterruptedException unused3) {
                        cVar3.f3650b.execute(new Q.b(cVar3.f3649a, -3));
                    }
                }
            }
        } else {
            typefaceA = f2750a.a(context, (J.e.b) aVar, resources, i11);
            if (cVar != null) {
                if (typefaceA != null) {
                    new Handler(Looper.getMainLooper()).post(new G6.b(i12, cVar, typefaceA));
                } else {
                    cVar.a(-3);
                }
            }
        }
        if (typefaceA != null) {
            f2751b.b(b(resources, i9, str, i10, i11), typefaceA);
        }
        return typefaceA;
    }

    public static String b(Resources resources, int i9, String str, int i10, int i11) {
        return resources.getResourcePackageName(i9) + '-' + str + '-' + i10 + '-' + i9 + '-' + i11;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        if (f2752c == null) {
            f2752c = new Paint();
        }
        f2752c.setTextSize(10.0f);
        f2752c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f2752c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
