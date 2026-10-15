package T3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.ikaile.ruoshui.client.MainActivity;
import com.starburst.sdk.core.feed.FeedManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p096m7.k;

/* JADX INFO: compiled from: ConnectionOverlayController.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MainActivity f4495a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowManager f4497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f4498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WindowManager.LayoutParams f4499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f4500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4502h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4496b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4503i = true;
    public c j = new c(null);

    /* JADX INFO: compiled from: ConnectionOverlayController.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f4507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f4508e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4509f;

        public a(String str, String str2, boolean z8, String str3, String str4, String str5) {
            this.f4504a = str;
            this.f4505b = str2;
            this.f4506c = z8;
            this.f4507d = str3;
            this.f4508e = str4;
            this.f4509f = str5;
        }

        public static String a(Object obj, String str) {
            if (obj != null) {
                String string = obj.toString();
                if (!string.equals("null")) {
                    return string;
                }
            }
            return str;
        }
    }

    /* JADX INFO: compiled from: ConnectionOverlayController.java */
    public static class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f4510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4513d;

        public b(MainActivity mainActivity, String str, int i9, int i10) {
            super(mainActivity);
            this.f4510a = new Paint(1);
            this.f4511b = str;
            this.f4512c = i9;
            this.f4513d = i10;
        }

        public final void a(Canvas canvas, float f6, float f9, boolean z8) {
            float f10 = 0.06f * f6;
            float f11 = 0.94f * f6;
            float fMin = Math.min(f6, f9) * 0.16f;
            RectF rectF = new RectF(f10, f9 * 0.16f, f11, 0.82f * f9);
            Paint paint = this.f4510a;
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
            if (z8) {
                return;
            }
            float f12 = 0.1f * f6;
            float f13 = 0.42f * f9;
            canvas.drawLine(f10 + f12, f13, f11 - f12, f13, paint);
            canvas.drawCircle(0.5f * f6, 0.62f * f9, Math.max(2.0f, 0.035f * f6), paint);
        }

        public final void b(Canvas canvas, float f6, float f9, boolean z8, boolean z9) {
            canvas.save();
            if (z9) {
                canvas.scale(-1.0f, 1.0f, f6 / 2.0f, f9 / 2.0f);
            }
            float f10 = f6 * 0.52f;
            float f11 = f9 * 0.08f;
            float f12 = 0.42f * f9;
            float f13 = (f6 * 0.42f) / 2.0f;
            RectF rectF = new RectF(f10 - f13, f11, f13 + f10, f11 + f12);
            Paint paint = this.f4510a;
            canvas.drawOval(rectF, paint);
            float f14 = f10 - (0.11f * f6);
            float f15 = (0.08f * f6) + f10;
            float f16 = 0.09f * f6;
            canvas.drawRoundRect(new RectF(f14, (f12 * 0.62f) + f11, f15, 0.9f * f9), f16, f16, paint);
            if (!z8) {
                float f17 = 0.52f * f9;
                canvas.drawLine((0.03f * f6) + f14, f17, f15 - (0.02f * f6), f17, paint);
            }
            canvas.restore();
        }

        @Override // android.view.View
        public final void onDraw(Canvas canvas) {
            b bVar;
            Canvas canvas2;
            super.onDraw(canvas);
            float width = getWidth();
            float height = getHeight();
            if (width <= 0.0f || height <= 0.0f) {
                return;
            }
            Paint paint = this.f4510a;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f4513d);
            String str = this.f4511b;
            if ("charge".equals(str)) {
                a(canvas, width, height, true);
                bVar = this;
                canvas2 = canvas;
            } else {
                bVar = this;
                canvas2 = canvas;
                bVar.b(canvas2, width, height, true, "right".equals(str));
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(Math.max(2.0f, Math.min(width, height) * 0.045f));
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.ROUND);
            int i9 = bVar.f4512c;
            paint.setColor(Color.argb(Math.max(0, Math.min(255, Math.round(Color.alpha(i9) * 0.82f))), Color.red(i9), Color.green(i9), Color.blue(i9)));
            if ("charge".equals(str)) {
                a(canvas2, width, height, false);
            } else {
                bVar.b(canvas2, width, height, false, "right".equals(str));
            }
        }
    }

    /* JADX INFO: compiled from: ConnectionOverlayController.java */
    public static class c {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public final int f4514A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public final int f4515B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public final float f4516C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public final float f4517D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f4524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4525h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f4526i;
        public final float j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f4527k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final float f4528l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final float f4529m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f4530n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f4531o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f4532p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final float f4533q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final float f4534r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final float f4535s;
        public final float t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final float f4536u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final float f4537v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final float f4538w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final float f4539x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final float f4540y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final float f4541z;

        /* JADX WARN: Code duplicated, block: B:12:0x012e  */
        /* JADX WARN: Code duplicated, block: B:23:0x0152  */
        public c(Map<String, Object> map) {
            int iIntValue;
            int iIntValue2;
            this.f4518a = a(map, "horizontalPadding", 32.0f);
            this.f4519b = a(map, "topPadding", 20.0f);
            this.f4520c = a(map, "bottomPadding", 14.0f);
            this.f4521d = a(map, "maxSheetWidth", 578.0f);
            this.f4522e = a(map, "foregroundScrimOpacity", 0.68f);
            this.f4523f = a(map, "cornerRadius", 30.0f);
            this.f4524g = a(map, "titleFontSize", 21.0f);
            this.f4525h = a(map, "stateFontSize", 14.0f);
            this.f4526i = a(map, "batteryValueFontSize", 18.0f);
            this.j = a(map, "batteryLabelFontSize", 13.0f);
            this.f4527k = a(map, "confirmFontSize", 16.0f);
            this.f4528l = a(map, "confirmHeight", 48.0f);
            this.f4529m = a(map, "confirmHorizontalInset", 32.0f);
            this.f4530n = a(map, "titleStateGap", 4.0f);
            this.f4531o = a(map, "stateBatteryGap", 20.0f);
            this.f4532p = a(map, "batteryConfirmGap", 30.0f);
            this.f4533q = a(map, "batteryIconHeight", 85.0f);
            this.f4534r = a(map, "earbudImageWidth", 63.0f);
            this.f4535s = a(map, "earbudImageHeight", 77.5f);
            this.t = a(map, "caseImageWidth", 116.0f);
            this.f4536u = a(map, "caseImageHeight", 82.5f);
            this.f4537v = a(map, "nativeImagePadding", 0.0f);
            this.f4538w = a(map, "placeholderBackgroundOpacity", 0.12f);
            this.f4539x = a(map, "batteryValueLabelGap", 4.0f);
            this.f4540y = Math.max(0.1f, Math.min(1.0f, a(map, "maxScreenHeightFactor", 0.432f)));
            this.f4541z = a(map, "confirmLift", 30.0f);
            if (map == null) {
                iIntValue = FeedManager.FILE_TYPE_INT_FEED_LOCAL_STATE_JSON;
            } else {
                Object obj = map.get("enterDurationMs");
                if (obj instanceof Number) {
                    iIntValue = ((Number) obj).intValue();
                } else if (obj == null) {
                    iIntValue = FeedManager.FILE_TYPE_INT_FEED_LOCAL_STATE_JSON;
                } else {
                    try {
                        iIntValue = Integer.parseInt(obj.toString());
                    } catch (NumberFormatException unused) {
                        iIntValue = FeedManager.FILE_TYPE_INT_FEED_LOCAL_STATE_JSON;
                    }
                }
            }
            this.f4514A = iIntValue;
            if (map == null) {
                iIntValue2 = 200;
            } else {
                Object obj2 = map.get("exitDurationMs");
                if (obj2 instanceof Number) {
                    iIntValue2 = ((Number) obj2).intValue();
                } else if (obj2 == null) {
                    iIntValue2 = 200;
                } else {
                    try {
                        iIntValue2 = Integer.parseInt(obj2.toString());
                    } catch (NumberFormatException unused2) {
                        iIntValue2 = 200;
                    }
                }
            }
            this.f4515B = iIntValue2;
            this.f4516C = a(map, "enterTranslation", 48.0f);
            this.f4517D = a(map, "exitTranslation", 16.0f);
        }

        public static float a(Map<String, Object> map, String str, float f6) {
            if (map != null) {
                Object obj = map.get(str);
                if (obj instanceof Number) {
                    return ((Number) obj).floatValue();
                }
                if (obj != null) {
                    try {
                        return Float.parseFloat(obj.toString());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return f6;
        }
    }

    /* JADX INFO: compiled from: ConnectionOverlayController.java */
    public static class d extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f4544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f4545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f4546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Path f4547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bitmap f4548g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public pl.droidsonroids.gif.d f4549h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final a f4550i;

        /* JADX INFO: compiled from: ConnectionOverlayController.java */
        public class a implements Drawable.Callback {
            public a() {
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public final void invalidateDrawable(Drawable drawable) {
                d.this.invalidate();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                d.this.postDelayed(runnable, Math.max(0L, j - SystemClock.uptimeMillis()));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                d.this.removeCallbacks(runnable);
            }
        }

        public d(MainActivity mainActivity, int i9, float f6) {
            super(mainActivity);
            this.f4544c = new Paint(1);
            this.f4545d = new Rect();
            this.f4546e = new RectF();
            this.f4547f = new Path();
            this.f4550i = new a();
            this.f4542a = i9;
            this.f4543b = f6;
            setWillNotDraw(false);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas canvas) {
            pl.droidsonroids.gif.d dVar;
            int i9;
            int i10;
            int iSave = canvas.save();
            Path path = this.f4547f;
            path.reset();
            float width = getWidth();
            float height = getHeight();
            float f6 = this.f4543b;
            path.addRoundRect(new RectF(0.0f, 0.0f, width, height), new float[]{f6, f6, f6, f6, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            canvas.clipPath(path);
            Paint paint = this.f4544c;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f4542a);
            canvas.drawRect(0.0f, 0.0f, width, height, paint);
            pl.droidsonroids.gif.d dVar2 = this.f4549h;
            if (dVar2 == null) {
                Bitmap bitmap = this.f4548g;
                if (bitmap != null && !bitmap.isRecycled()) {
                    int width2 = this.f4548g.getWidth();
                    int height2 = this.f4548g.getHeight();
                    if (width2 > 0 && height2 > 0 && width > 0.0f && height > 0.0f) {
                        float f9 = width2;
                        float f10 = height2;
                        float fMax = Math.max(width / f9, height / f10);
                        float f11 = f9 * fMax;
                        float f12 = f10 * fMax;
                        float f13 = (width - f11) / 2.0f;
                        float f14 = (height - f12) / 2.0f;
                        Rect rect = this.f4545d;
                        rect.set(0, 0, width2, height2);
                        RectF rectF = this.f4546e;
                        rectF.set(f13, f14, f11 + f13, f12 + f14);
                        paint.setFilterBitmap(true);
                        canvas.drawBitmap(this.f4548g, rect, rectF, paint);
                    }
                }
            } else if (dVar2 != null && !dVar2.a() && (i9 = (dVar = this.f4549h).f20858q) > 0 && (i10 = dVar.f20859r) > 0 && width > 0.0f && height > 0.0f) {
                float f15 = i9;
                float f16 = i10;
                float fMax2 = Math.max(width / f15, height / f16);
                float f17 = f15 * fMax2;
                float f18 = f16 * fMax2;
                int iRound = Math.round((width - f17) / 2.0f);
                int iRound2 = Math.round((height - f18) / 2.0f);
                this.f4549h.setBounds(iRound, iRound2, Math.round(iRound + f17), Math.round(iRound2 + f18));
                this.f4549h.draw(canvas);
            }
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            pl.droidsonroids.gif.d dVar = this.f4549h;
            if (dVar != null) {
                dVar.setCallback(null);
                if (!this.f4549h.a()) {
                    this.f4549h.stop();
                    this.f4549h.b();
                }
                this.f4549h = null;
            }
        }
    }

    public f(MainActivity mainActivity) {
        this.f4495a = mainActivity;
    }

    public static int a(int i9, float f6) {
        return Color.argb(Math.max(0, Math.min(255, Math.round(f6 * 255.0f))), Color.red(i9), Color.green(i9), Color.blue(i9));
    }

    public static a d(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (str.equals(aVar.f4507d)) {
                return aVar;
            }
        }
        return null;
    }

    public static boolean e(Object obj, boolean z8) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj != null) {
            String string = obj.toString();
            if ("true".equalsIgnoreCase(string)) {
                return true;
            }
            if ("false".equalsIgnoreCase(string)) {
                return false;
            }
        }
        return z8;
    }

    public static int f(int i9, Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj == null) {
            return i9;
        }
        try {
            return (int) Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return i9;
        }
    }

    public static Bitmap h(int i9, int i10, String str) {
        String strTrim = o(str, "").trim();
        if (!strTrim.isEmpty() && !strTrim.toLowerCase().endsWith(".svg")) {
            File file = new File(strTrim);
            if (file.exists() && file.isFile()) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    int i11 = 1;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(strTrim, options);
                    if (options.outWidth > 0 && options.outHeight > 0) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        int i12 = options.outWidth;
                        int i13 = options.outHeight;
                        int iMax = Math.max(i9 * 2, 1);
                        int iMax2 = Math.max(i10 * 2, 1);
                        while (true) {
                            if (i12 / i11 <= iMax && i13 / i11 <= iMax2) {
                                options2.inSampleSize = i11;
                                return BitmapFactory.decodeFile(strTrim, options2);
                            }
                            i11 *= 2;
                        }
                    }
                } catch (RuntimeException e9) {
                    Log.w("RoseLinkOverlay", "decode connection overlay image failed: ".concat(strTrim), e9);
                }
            }
        }
        return null;
    }

    public static pl.droidsonroids.gif.d k(String str) {
        if (str != null && str.trim().toLowerCase().endsWith(".gif")) {
            File file = new File(str.trim());
            if (file.exists() && file.isFile()) {
                try {
                    pl.droidsonroids.gif.d dVar = new pl.droidsonroids.gif.d(file);
                    dVar.c();
                    return dVar;
                } catch (IOException | RuntimeException e9) {
                    Log.w("RoseLinkOverlay", "decode connection overlay gif failed: ".concat(str), e9);
                }
            }
        }
        return null;
    }

    public static String m(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i9 = inputStream.read(bArr);
            if (i9 == -1) {
                return sb.toString();
            }
            sb.append(new String(bArr, 0, i9, StandardCharsets.UTF_8));
        }
    }

    public static String o(Object obj, String str) {
        if (obj != null) {
            String string = obj.toString();
            if (!string.equals("null")) {
                return string;
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00f6 A[EDGE_INSN: B:45:0x00f6->B:67:0x013b BREAK  A[LOOP:0: B:47:0x0108->B:66:0x0136]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0136 A[LOOP:0: B:47:0x0108->B:66:0x0136, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x0200  */
    /* JADX WARN: Code duplicated, block: B:74:0x0204  */
    /* JADX WARN: Code duplicated, block: B:75:0x020f  */
    /* JADX WARN: Code duplicated, block: B:77:0x0215  */
    /* JADX WARN: Code duplicated, block: B:78:0x0239  */
    /* JADX WARN: Code duplicated, block: B:80:0x023f  */
    /* JADX WARN: Code duplicated, block: B:81:0x025b  */
    /* JADX WARN: Code duplicated, block: B:98:0x013b A[EDGE_INSN: B:98:0x013b->B:67:0x013b BREAK  A[LOOP:0: B:47:0x0108->B:66:0x0136], SYNTHETIC] */
    public final LinearLayout b(a aVar, int i9, int i10, float f6) {
        WebView webView;
        pl.droidsonroids.gif.d dVarK;
        Bitmap bitmapH;
        String strM;
        int i11 = aVar.f4506c ? i10 : i9;
        MainActivity mainActivity = this.f4495a;
        LinearLayout linearLayout = new LinearLayout(mainActivity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        float f9 = f6 * 4.0f;
        linearLayout.setPadding(j(f9), 0, j(f9), 0);
        String str = aVar.f4507d;
        boolean zEquals = "charge".equals(str);
        c cVar = this.j;
        int iJ = j((zEquals ? cVar.t : cVar.f4534r) * f6);
        int iJ2 = j((zEquals ? this.j.f4536u : this.j.f4535s) * f6);
        int iJ3 = j(this.j.f4537v * f6) * 2;
        int iMax = Math.max(1, iJ - iJ3);
        int iMax2 = Math.max(1, iJ2 - iJ3);
        FrameLayout frameLayout = new FrameLayout(mainActivity);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        String str2 = aVar.f4508e;
        String strTrim = o(str2, "").trim();
        if (strTrim.isEmpty() || !strTrim.toLowerCase().endsWith(".svg")) {
            webView = null;
        } else {
            String str3 = aVar.f4509f;
            if (!"file".equals(str3)) {
                if (!"asset".equals(str3) && !"resource".equals(str3)) {
                    strM = null;
                    break;
                }
                String strTrim2 = strTrim.trim();
                String[] strArr = {strTrim2, W5.e.l("flutter_assets/", strTrim2)};
                int i12 = 0;
                while (true) {
                    if (i12 >= 2) {
                        strM = null;
                        break;
                    }
                    try {
                        InputStream inputStreamOpen = mainActivity.getAssets().open(strArr[i12]);
                        try {
                            strM = m(inputStreamOpen);
                            inputStreamOpen.close();
                            strArr = strArr;
                        } catch (Throwable th) {
                            try {
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            } catch (IOException unused) {
                                strM = null;
                                if (strM != null) {
                                    break;
                                    if (strM != null) {
                                        webView = null;
                                    } else {
                                        webView = null;
                                    }
                                    if (webView != null) {
                                        frameLayout.addView(webView, new FrameLayout.LayoutParams(iMax, iMax2, 17));
                                    } else {
                                        dVarK = k(str2);
                                        if (dVarK != null) {
                                            ImageView imageView = new ImageView(mainActivity);
                                            imageView.setImageDrawable(dVarK);
                                            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                            imageView.setAdjustViewBounds(false);
                                            imageView.addOnAttachStateChangeListener(new e(dVarK));
                                            frameLayout.addView(imageView, new FrameLayout.LayoutParams(iMax, iMax2, 17));
                                        } else {
                                            bitmapH = h(iMax, iMax2, str2);
                                            if (bitmapH != null) {
                                                ImageView imageView2 = new ImageView(mainActivity);
                                                imageView2.setImageBitmap(bitmapH);
                                                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                                imageView2.setAdjustViewBounds(false);
                                                frameLayout.addView(imageView2, new FrameLayout.LayoutParams(iMax, iMax2, 17));
                                            } else {
                                                frameLayout.addView(new b(mainActivity, str, i11, a(i11, this.j.f4538w)), new FrameLayout.LayoutParams(iJ, iJ2, 17));
                                            }
                                        }
                                    }
                                    linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, j(this.j.f4533q * f6)));
                                    TextView textViewP = p(aVar.f4505b, i11, this.j.f4526i * f6, true);
                                    textViewP.setGravity(17);
                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams.topMargin = j((this.j.f4539x + 4.0f) * f6);
                                    linearLayout.addView(textViewP, layoutParams);
                                    TextView textViewP2 = p(aVar.f4504a, i10, this.j.j * f6, false);
                                    textViewP2.setGravity(17);
                                    textViewP2.setSingleLine(true);
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams2.topMargin = j(this.j.f4539x * f6);
                                    linearLayout.addView(textViewP2, layoutParams2);
                                    return linearLayout;
                                }
                                i12++;
                                strArr = strArr;
                            }
                        }
                    } catch (IOException unused2) {
                    }
                    if (strM != null) {
                        break;
                    }
                    i12++;
                    strArr = strArr;
                }
            } else {
                File file = new File(strTrim);
                if (!file.exists() || !file.isFile()) {
                    strM = null;
                    break;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        strM = m(fileInputStream);
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        try {
                            fileInputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (IOException e9) {
                    Log.w("RoseLinkOverlay", "read connection overlay svg failed: ".concat(strTrim), e9);
                }
            }
            if (strM != null || strM.trim().isEmpty()) {
                webView = null;
            } else {
                String str4 = String.format("#%02X%02X%02X", Integer.valueOf(Color.red(i11)), Integer.valueOf(Color.green(i11)), Integer.valueOf(Color.blue(i11)));
                String str5 = "rgba(" + Color.red(i11) + ", " + Color.green(i11) + ", " + Color.blue(i11) + Constants.ACCEPT_TIME_SEPARATOR_SP;
                String strI = A.a.i("<!doctype html><html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/><style>html,body{margin:0;padding:0;width:100%;height:100%;overflow:hidden;background:transparent;}img{display:block;width:100%;height:100%;object-fit:contain;}</style></head><body><img src=\"data:image/svg+xml;base64,", Base64.encodeToString(strM.replace("#7f7f7f", str4).replace("#7F7F7F", str4).replace("rgba(127, 127, 127,", str5).replace("rgba(127,127,127,", str5).getBytes(StandardCharsets.UTF_8), 2), "\"/></body></html>");
                webView = new WebView(mainActivity);
                webView.setBackgroundColor(0);
                webView.setVerticalScrollBarEnabled(false);
                webView.setHorizontalScrollBarEnabled(false);
                webView.setFocusable(false);
                webView.setFocusableInTouchMode(false);
                webView.setClickable(false);
                webView.getSettings().setJavaScriptEnabled(false);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);
                webView.loadDataWithBaseURL(null, strI, "text/html", "UTF-8", null);
            }
        }
        if (webView != null) {
            frameLayout.addView(webView, new FrameLayout.LayoutParams(iMax, iMax2, 17));
        } else {
            dVarK = k(str2);
            if (dVarK != null) {
                ImageView imageView3 = new ImageView(mainActivity);
                imageView3.setImageDrawable(dVarK);
                imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView3.setAdjustViewBounds(false);
                imageView3.addOnAttachStateChangeListener(new e(dVarK));
                frameLayout.addView(imageView3, new FrameLayout.LayoutParams(iMax, iMax2, 17));
            } else {
                bitmapH = h(iMax, iMax2, str2);
                if (bitmapH != null) {
                    ImageView imageView4 = new ImageView(mainActivity);
                    imageView4.setImageBitmap(bitmapH);
                    imageView4.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView4.setAdjustViewBounds(false);
                    frameLayout.addView(imageView4, new FrameLayout.LayoutParams(iMax, iMax2, 17));
                } else {
                    frameLayout.addView(new b(mainActivity, str, i11, a(i11, this.j.f4538w)), new FrameLayout.LayoutParams(iJ, iJ2, 17));
                }
            }
        }
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, j(this.j.f4533q * f6)));
        TextView textViewP3 = p(aVar.f4505b, i11, this.j.f4526i * f6, true);
        textViewP3.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = j((this.j.f4539x + 4.0f) * f6);
        linearLayout.addView(textViewP3, layoutParams3);
        TextView textViewP4 = p(aVar.f4504a, i10, this.j.j * f6, false);
        textViewP4.setGravity(17);
        textViewP4.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = j(this.j.f4539x * f6);
        linearLayout.addView(textViewP4, layoutParams4);
        return linearLayout;
    }

    public final float c() {
        c cVar = this.j;
        float f6 = cVar.f4533q;
        float f9 = cVar.f4539x;
        float f10 = cVar.f4526i * 1.45f;
        return (cVar.j * 1.45f) + f10 + f6 + f9 + 4.0f + f9;
    }

    public final void g(boolean z8) {
        k kVar = this.f4500f;
        if (kVar == null) {
            return;
        }
        this.f4500f = null;
        kVar.success(Boolean.valueOf(z8));
    }

    public final void i(boolean z8) {
        if (this.f4502h) {
            return;
        }
        LinearLayout linearLayout = this.f4498d;
        if (linearLayout == null) {
            g(false);
            return;
        }
        this.f4502h = true;
        if (z8) {
            linearLayout.animate().cancel();
            this.f4498d.setLayerType(2, null);
            this.f4498d.animate().alpha(0.0f).translationY(j(this.j.f4517D)).setDuration(this.j.f4515B).setInterpolator(new AccelerateInterpolator()).withEndAction(new D6.a(6, this)).start();
        } else {
            n();
            this.f4499e = null;
            this.f4501g = false;
            this.f4502h = false;
            g(false);
        }
    }

    public final int j(float f6) {
        return (int) ((f6 * this.f4495a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int l() {
        return Math.max(1, Math.round(this.f4495a.getResources().getDisplayMetrics().heightPixels * this.j.f4540y));
    }

    public final void n() {
        LinearLayout linearLayout;
        WindowManager windowManager = this.f4497c;
        if (windowManager != null && (linearLayout = this.f4498d) != null) {
            try {
                windowManager.removeView(linearLayout);
            } catch (IllegalArgumentException unused) {
            }
        }
        LinearLayout linearLayout2 = this.f4498d;
        if (linearLayout2 != null) {
            linearLayout2.animate().cancel();
            this.f4498d = null;
        }
    }

    public final TextView p(String str, int i9, float f6, boolean z8) {
        TextView textView = new TextView(this.f4495a);
        textView.setText(str);
        textView.setTextColor(i9);
        textView.setTextSize(0, j(f6));
        textView.setIncludeFontPadding(true);
        if (z8) {
            textView.setTypeface(Typeface.DEFAULT, 1);
        }
        return textView;
    }
}
