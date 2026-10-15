package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f6922d = {0, 4, 8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f6923e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, androidx.constraintlayout.widget.a> f6924a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6925b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f6926c = new HashMap<>();

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f6928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f6929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C0098b f6930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e f6931e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f6932f;

        public a() {
            d dVar = new d();
            dVar.f6996a = 0;
            dVar.f6997b = 0;
            dVar.f6998c = 1.0f;
            dVar.f6999d = Float.NaN;
            this.f6928b = dVar;
            c cVar = new c();
            cVar.f6992a = -1;
            cVar.f6993b = -1;
            cVar.f6994c = Float.NaN;
            cVar.f6995d = Float.NaN;
            this.f6929c = cVar;
            C0098b c0098b = new C0098b();
            c0098b.f6959a = false;
            c0098b.f6964d = -1;
            c0098b.f6966e = -1;
            c0098b.f6968f = -1.0f;
            c0098b.f6970g = -1;
            c0098b.f6972h = -1;
            c0098b.f6974i = -1;
            c0098b.j = -1;
            c0098b.f6976k = -1;
            c0098b.f6977l = -1;
            c0098b.f6978m = -1;
            c0098b.f6979n = -1;
            c0098b.f6980o = -1;
            c0098b.f6981p = -1;
            c0098b.f6982q = -1;
            c0098b.f6983r = -1;
            c0098b.f6984s = -1;
            c0098b.t = 0.5f;
            c0098b.f6985u = 0.5f;
            c0098b.f6986v = null;
            c0098b.f6987w = -1;
            c0098b.f6988x = 0;
            c0098b.f6989y = 0.0f;
            c0098b.f6990z = -1;
            c0098b.f6934A = -1;
            c0098b.f6935B = -1;
            c0098b.f6936C = -1;
            c0098b.f6937D = -1;
            c0098b.f6938E = -1;
            c0098b.f6939F = -1;
            c0098b.f6940G = -1;
            c0098b.f6941H = -1;
            c0098b.f6942I = -1;
            c0098b.f6943J = -1;
            c0098b.f6944K = -1;
            c0098b.f6945L = -1;
            c0098b.f6946M = -1;
            c0098b.f6947N = -1;
            c0098b.O = -1.0f;
            c0098b.f6948P = -1.0f;
            c0098b.f6949Q = 0;
            c0098b.f6950R = 0;
            c0098b.f6951S = 0;
            c0098b.f6952T = 0;
            c0098b.f6953U = -1;
            c0098b.f6954V = -1;
            c0098b.f6955W = -1;
            c0098b.f6956X = -1;
            c0098b.f6957Y = 1.0f;
            c0098b.f6958Z = 1.0f;
            c0098b.a0 = -1;
            c0098b.f6961b0 = 0;
            c0098b.f6963c0 = -1;
            c0098b.f6971g0 = false;
            c0098b.f6973h0 = false;
            c0098b.f6975i0 = true;
            this.f6930d = c0098b;
            e eVar = new e();
            eVar.f7001a = 0.0f;
            eVar.f7002b = 0.0f;
            eVar.f7003c = 0.0f;
            eVar.f7004d = 1.0f;
            eVar.f7005e = 1.0f;
            eVar.f7006f = Float.NaN;
            eVar.f7007g = Float.NaN;
            eVar.f7008h = 0.0f;
            eVar.f7009i = 0.0f;
            eVar.j = 0.0f;
            eVar.f7010k = false;
            eVar.f7011l = 0.0f;
            this.f6931e = eVar;
            this.f6932f = new HashMap<>();
        }

        public final void a(ConstraintLayout.a aVar) {
            C0098b c0098b = this.f6930d;
            aVar.f6852d = c0098b.f6970g;
            aVar.f6854e = c0098b.f6972h;
            aVar.f6856f = c0098b.f6974i;
            aVar.f6858g = c0098b.j;
            aVar.f6860h = c0098b.f6976k;
            aVar.f6862i = c0098b.f6977l;
            aVar.j = c0098b.f6978m;
            aVar.f6865k = c0098b.f6979n;
            aVar.f6867l = c0098b.f6980o;
            aVar.f6872p = c0098b.f6981p;
            aVar.f6873q = c0098b.f6982q;
            aVar.f6874r = c0098b.f6983r;
            aVar.f6875s = c0098b.f6984s;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = c0098b.f6936C;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = c0098b.f6937D;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = c0098b.f6938E;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = c0098b.f6939F;
            aVar.f6879x = c0098b.f6947N;
            aVar.f6880y = c0098b.f6946M;
            aVar.f6876u = c0098b.f6943J;
            aVar.f6878w = c0098b.f6945L;
            aVar.f6881z = c0098b.t;
            aVar.f6822A = c0098b.f6985u;
            aVar.f6869m = c0098b.f6987w;
            aVar.f6870n = c0098b.f6988x;
            aVar.f6871o = c0098b.f6989y;
            aVar.f6823B = c0098b.f6986v;
            aVar.f6836P = c0098b.f6990z;
            aVar.f6837Q = c0098b.f6934A;
            aVar.f6826E = c0098b.O;
            aVar.f6825D = c0098b.f6948P;
            aVar.f6828G = c0098b.f6950R;
            aVar.f6827F = c0098b.f6949Q;
            aVar.f6839S = c0098b.f6971g0;
            aVar.f6840T = c0098b.f6973h0;
            aVar.f6829H = c0098b.f6951S;
            aVar.f6830I = c0098b.f6952T;
            aVar.f6833L = c0098b.f6953U;
            aVar.f6834M = c0098b.f6954V;
            aVar.f6831J = c0098b.f6955W;
            aVar.f6832K = c0098b.f6956X;
            aVar.f6835N = c0098b.f6957Y;
            aVar.O = c0098b.f6958Z;
            aVar.f6838R = c0098b.f6935B;
            aVar.f6850c = c0098b.f6968f;
            aVar.f6847a = c0098b.f6964d;
            aVar.f6848b = c0098b.f6966e;
            ((ViewGroup.MarginLayoutParams) aVar).width = c0098b.f6960b;
            ((ViewGroup.MarginLayoutParams) aVar).height = c0098b.f6962c;
            String str = c0098b.f6969f0;
            if (str != null) {
                aVar.f6841U = str;
            }
            aVar.setMarginStart(c0098b.f6941H);
            aVar.setMarginEnd(c0098b.f6940G);
            aVar.a();
        }

        public final void b(int i9, ConstraintLayout.a aVar) {
            this.f6927a = i9;
            int i10 = aVar.f6852d;
            C0098b c0098b = this.f6930d;
            c0098b.f6970g = i10;
            c0098b.f6972h = aVar.f6854e;
            c0098b.f6974i = aVar.f6856f;
            c0098b.j = aVar.f6858g;
            c0098b.f6976k = aVar.f6860h;
            c0098b.f6977l = aVar.f6862i;
            c0098b.f6978m = aVar.j;
            c0098b.f6979n = aVar.f6865k;
            c0098b.f6980o = aVar.f6867l;
            c0098b.f6981p = aVar.f6872p;
            c0098b.f6982q = aVar.f6873q;
            c0098b.f6983r = aVar.f6874r;
            c0098b.f6984s = aVar.f6875s;
            c0098b.t = aVar.f6881z;
            c0098b.f6985u = aVar.f6822A;
            c0098b.f6986v = aVar.f6823B;
            c0098b.f6987w = aVar.f6869m;
            c0098b.f6988x = aVar.f6870n;
            c0098b.f6989y = aVar.f6871o;
            c0098b.f6990z = aVar.f6836P;
            c0098b.f6934A = aVar.f6837Q;
            c0098b.f6935B = aVar.f6838R;
            c0098b.f6968f = aVar.f6850c;
            c0098b.f6964d = aVar.f6847a;
            c0098b.f6966e = aVar.f6848b;
            c0098b.f6960b = ((ViewGroup.MarginLayoutParams) aVar).width;
            c0098b.f6962c = ((ViewGroup.MarginLayoutParams) aVar).height;
            c0098b.f6936C = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            c0098b.f6937D = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            c0098b.f6938E = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            c0098b.f6939F = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            c0098b.O = aVar.f6826E;
            c0098b.f6948P = aVar.f6825D;
            c0098b.f6950R = aVar.f6828G;
            c0098b.f6949Q = aVar.f6827F;
            c0098b.f6971g0 = aVar.f6839S;
            c0098b.f6973h0 = aVar.f6840T;
            c0098b.f6951S = aVar.f6829H;
            c0098b.f6952T = aVar.f6830I;
            c0098b.f6953U = aVar.f6833L;
            c0098b.f6954V = aVar.f6834M;
            c0098b.f6955W = aVar.f6831J;
            c0098b.f6956X = aVar.f6832K;
            c0098b.f6957Y = aVar.f6835N;
            c0098b.f6958Z = aVar.O;
            c0098b.f6969f0 = aVar.f6841U;
            c0098b.f6943J = aVar.f6876u;
            c0098b.f6945L = aVar.f6878w;
            c0098b.f6942I = aVar.t;
            c0098b.f6944K = aVar.f6877v;
            c0098b.f6947N = aVar.f6879x;
            c0098b.f6946M = aVar.f6880y;
            c0098b.f6940G = aVar.getMarginEnd();
            c0098b.f6941H = aVar.getMarginStart();
        }

        public final void c(int i9, Constraints.a aVar) {
            b(i9, aVar);
            this.f6928b.f6998c = aVar.f6891m0;
            float f6 = aVar.f6894p0;
            e eVar = this.f6931e;
            eVar.f7001a = f6;
            eVar.f7002b = aVar.f6895q0;
            eVar.f7003c = aVar.f6896r0;
            eVar.f7004d = aVar.f6897s0;
            eVar.f7005e = aVar.f6898t0;
            eVar.f7006f = aVar.f6899u0;
            eVar.f7007g = aVar.f6900v0;
            eVar.f7008h = aVar.f6901w0;
            eVar.f7009i = aVar.f6902x0;
            eVar.j = aVar.f6903y0;
            eVar.f7011l = aVar.f6893o0;
            eVar.f7010k = aVar.f6892n0;
        }

        public final Object clone() {
            a aVar = new a();
            C0098b c0098b = aVar.f6930d;
            c0098b.getClass();
            C0098b c0098b2 = this.f6930d;
            c0098b.f6959a = c0098b2.f6959a;
            c0098b.f6960b = c0098b2.f6960b;
            c0098b.f6962c = c0098b2.f6962c;
            c0098b.f6964d = c0098b2.f6964d;
            c0098b.f6966e = c0098b2.f6966e;
            c0098b.f6968f = c0098b2.f6968f;
            c0098b.f6970g = c0098b2.f6970g;
            c0098b.f6972h = c0098b2.f6972h;
            c0098b.f6974i = c0098b2.f6974i;
            c0098b.j = c0098b2.j;
            c0098b.f6976k = c0098b2.f6976k;
            c0098b.f6977l = c0098b2.f6977l;
            c0098b.f6978m = c0098b2.f6978m;
            c0098b.f6979n = c0098b2.f6979n;
            c0098b.f6980o = c0098b2.f6980o;
            c0098b.f6981p = c0098b2.f6981p;
            c0098b.f6982q = c0098b2.f6982q;
            c0098b.f6983r = c0098b2.f6983r;
            c0098b.f6984s = c0098b2.f6984s;
            c0098b.t = c0098b2.t;
            c0098b.f6985u = c0098b2.f6985u;
            c0098b.f6986v = c0098b2.f6986v;
            c0098b.f6987w = c0098b2.f6987w;
            c0098b.f6988x = c0098b2.f6988x;
            c0098b.f6989y = c0098b2.f6989y;
            c0098b.f6990z = c0098b2.f6990z;
            c0098b.f6934A = c0098b2.f6934A;
            c0098b.f6935B = c0098b2.f6935B;
            c0098b.f6936C = c0098b2.f6936C;
            c0098b.f6937D = c0098b2.f6937D;
            c0098b.f6938E = c0098b2.f6938E;
            c0098b.f6939F = c0098b2.f6939F;
            c0098b.f6940G = c0098b2.f6940G;
            c0098b.f6941H = c0098b2.f6941H;
            c0098b.f6942I = c0098b2.f6942I;
            c0098b.f6943J = c0098b2.f6943J;
            c0098b.f6944K = c0098b2.f6944K;
            c0098b.f6945L = c0098b2.f6945L;
            c0098b.f6946M = c0098b2.f6946M;
            c0098b.f6947N = c0098b2.f6947N;
            c0098b.O = c0098b2.O;
            c0098b.f6948P = c0098b2.f6948P;
            c0098b.f6949Q = c0098b2.f6949Q;
            c0098b.f6950R = c0098b2.f6950R;
            c0098b.f6951S = c0098b2.f6951S;
            c0098b.f6952T = c0098b2.f6952T;
            c0098b.f6953U = c0098b2.f6953U;
            c0098b.f6954V = c0098b2.f6954V;
            c0098b.f6955W = c0098b2.f6955W;
            c0098b.f6956X = c0098b2.f6956X;
            c0098b.f6957Y = c0098b2.f6957Y;
            c0098b.f6958Z = c0098b2.f6958Z;
            c0098b.a0 = c0098b2.a0;
            c0098b.f6961b0 = c0098b2.f6961b0;
            c0098b.f6963c0 = c0098b2.f6963c0;
            c0098b.f6969f0 = c0098b2.f6969f0;
            int[] iArr = c0098b2.f6965d0;
            if (iArr != null) {
                c0098b.f6965d0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                c0098b.f6965d0 = null;
            }
            c0098b.f6967e0 = c0098b2.f6967e0;
            c0098b.f6971g0 = c0098b2.f6971g0;
            c0098b.f6973h0 = c0098b2.f6973h0;
            c0098b.f6975i0 = c0098b2.f6975i0;
            c cVar = aVar.f6929c;
            cVar.getClass();
            c cVar2 = this.f6929c;
            cVar2.getClass();
            cVar.f6992a = cVar2.f6992a;
            cVar.f6993b = cVar2.f6993b;
            cVar.f6995d = cVar2.f6995d;
            cVar.f6994c = cVar2.f6994c;
            d dVar = aVar.f6928b;
            d dVar2 = this.f6928b;
            dVar.f6996a = dVar2.f6996a;
            dVar.f6998c = dVar2.f6998c;
            dVar.f6999d = dVar2.f6999d;
            dVar.f6997b = dVar2.f6997b;
            e eVar = aVar.f6931e;
            eVar.getClass();
            e eVar2 = this.f6931e;
            eVar2.getClass();
            eVar.f7001a = eVar2.f7001a;
            eVar.f7002b = eVar2.f7002b;
            eVar.f7003c = eVar2.f7003c;
            eVar.f7004d = eVar2.f7004d;
            eVar.f7005e = eVar2.f7005e;
            eVar.f7006f = eVar2.f7006f;
            eVar.f7007g = eVar2.f7007g;
            eVar.f7008h = eVar2.f7008h;
            eVar.f7009i = eVar2.f7009i;
            eVar.j = eVar2.j;
            eVar.f7010k = eVar2.f7010k;
            eVar.f7011l = eVar2.f7011l;
            aVar.f6927a = this.f6927a;
            return aVar;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class C0098b {

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final SparseIntArray f6933j0;

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f6934A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f6935B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f6936C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f6937D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public int f6938E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f6939F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f6940G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f6941H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f6942I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f6943J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f6944K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f6945L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f6946M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f6947N;
        public float O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public float f6948P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f6949Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f6950R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f6951S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public int f6952T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public int f6953U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public int f6954V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public int f6955W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public int f6956X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public float f6957Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public float f6958Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6959a;
        public int a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6960b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f6961b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6962c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f6963c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6964d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int[] f6965d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6966e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public String f6967e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f6968f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public String f6969f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6970g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f6971g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6972h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f6973h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6974i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f6975i0;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f6976k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f6977l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6978m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6979n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6980o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6981p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6982q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f6983r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f6984s;
        public float t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f6985u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f6986v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f6987w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f6988x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f6989y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f6990z;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6933j0 = sparseIntArray;
            sparseIntArray.append(39, 24);
            sparseIntArray.append(40, 25);
            sparseIntArray.append(42, 28);
            sparseIntArray.append(43, 29);
            sparseIntArray.append(48, 35);
            sparseIntArray.append(47, 34);
            sparseIntArray.append(21, 4);
            sparseIntArray.append(20, 3);
            sparseIntArray.append(18, 1);
            sparseIntArray.append(56, 6);
            sparseIntArray.append(57, 7);
            sparseIntArray.append(28, 17);
            sparseIntArray.append(29, 18);
            sparseIntArray.append(30, 19);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(44, 31);
            sparseIntArray.append(45, 32);
            sparseIntArray.append(27, 10);
            sparseIntArray.append(26, 9);
            sparseIntArray.append(60, 13);
            sparseIntArray.append(63, 16);
            sparseIntArray.append(61, 14);
            sparseIntArray.append(58, 11);
            sparseIntArray.append(62, 15);
            sparseIntArray.append(59, 12);
            sparseIntArray.append(51, 38);
            sparseIntArray.append(37, 37);
            sparseIntArray.append(36, 39);
            sparseIntArray.append(50, 40);
            sparseIntArray.append(35, 20);
            sparseIntArray.append(49, 36);
            sparseIntArray.append(25, 5);
            sparseIntArray.append(38, 76);
            sparseIntArray.append(46, 76);
            sparseIntArray.append(41, 76);
            sparseIntArray.append(19, 76);
            sparseIntArray.append(17, 76);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(22, 61);
            sparseIntArray.append(24, 62);
            sparseIntArray.append(23, 63);
            sparseIntArray.append(55, 69);
            sparseIntArray.append(34, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.d.f1781e);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                SparseIntArray sparseIntArray = f6933j0;
                int i10 = sparseIntArray.get(index);
                if (i10 == 80) {
                    this.f6971g0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f6971g0);
                } else if (i10 != 81) {
                    switch (i10) {
                        case 1:
                            this.f6980o = b.f(typedArrayObtainStyledAttributes, index, this.f6980o);
                            break;
                        case 2:
                            this.f6939F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6939F);
                            break;
                        case 3:
                            this.f6979n = b.f(typedArrayObtainStyledAttributes, index, this.f6979n);
                            break;
                        case 4:
                            this.f6978m = b.f(typedArrayObtainStyledAttributes, index, this.f6978m);
                            break;
                        case 5:
                            this.f6986v = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.f6990z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6990z);
                            break;
                        case 7:
                            this.f6934A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6934A);
                            break;
                        case 8:
                            this.f6940G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6940G);
                            break;
                        case 9:
                            this.f6984s = b.f(typedArrayObtainStyledAttributes, index, this.f6984s);
                            break;
                        case 10:
                            this.f6983r = b.f(typedArrayObtainStyledAttributes, index, this.f6983r);
                            break;
                        case 11:
                            this.f6945L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6945L);
                            break;
                        case 12:
                            this.f6946M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6946M);
                            break;
                        case 13:
                            this.f6942I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6942I);
                            break;
                        case 14:
                            this.f6944K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6944K);
                            break;
                        case 15:
                            this.f6947N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6947N);
                            break;
                        case 16:
                            this.f6943J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6943J);
                            break;
                        case 17:
                            this.f6964d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6964d);
                            break;
                        case 18:
                            this.f6966e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6966e);
                            break;
                        case 19:
                            this.f6968f = typedArrayObtainStyledAttributes.getFloat(index, this.f6968f);
                            break;
                        case 20:
                            this.t = typedArrayObtainStyledAttributes.getFloat(index, this.t);
                            break;
                        case 21:
                            this.f6962c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f6962c);
                            break;
                        case 22:
                            this.f6960b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f6960b);
                            break;
                        case 23:
                            this.f6936C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6936C);
                            break;
                        case 24:
                            this.f6970g = b.f(typedArrayObtainStyledAttributes, index, this.f6970g);
                            break;
                        case 25:
                            this.f6972h = b.f(typedArrayObtainStyledAttributes, index, this.f6972h);
                            break;
                        case 26:
                            this.f6935B = typedArrayObtainStyledAttributes.getInt(index, this.f6935B);
                            break;
                        case 27:
                            this.f6937D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6937D);
                            break;
                        case 28:
                            this.f6974i = b.f(typedArrayObtainStyledAttributes, index, this.f6974i);
                            break;
                        case 29:
                            this.j = b.f(typedArrayObtainStyledAttributes, index, this.j);
                            break;
                        case 30:
                            this.f6941H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6941H);
                            break;
                        case 31:
                            this.f6981p = b.f(typedArrayObtainStyledAttributes, index, this.f6981p);
                            break;
                        case 32:
                            this.f6982q = b.f(typedArrayObtainStyledAttributes, index, this.f6982q);
                            break;
                        case 33:
                            this.f6938E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6938E);
                            break;
                        case 34:
                            this.f6977l = b.f(typedArrayObtainStyledAttributes, index, this.f6977l);
                            break;
                        case 35:
                            this.f6976k = b.f(typedArrayObtainStyledAttributes, index, this.f6976k);
                            break;
                        case 36:
                            this.f6985u = typedArrayObtainStyledAttributes.getFloat(index, this.f6985u);
                            break;
                        case 37:
                            this.f6948P = typedArrayObtainStyledAttributes.getFloat(index, this.f6948P);
                            break;
                        case 38:
                            this.O = typedArrayObtainStyledAttributes.getFloat(index, this.O);
                            break;
                        case 39:
                            this.f6949Q = typedArrayObtainStyledAttributes.getInt(index, this.f6949Q);
                            break;
                        case 40:
                            this.f6950R = typedArrayObtainStyledAttributes.getInt(index, this.f6950R);
                            break;
                        default:
                            switch (i10) {
                                case 54:
                                    this.f6951S = typedArrayObtainStyledAttributes.getInt(index, this.f6951S);
                                    break;
                                case 55:
                                    this.f6952T = typedArrayObtainStyledAttributes.getInt(index, this.f6952T);
                                    break;
                                case 56:
                                    this.f6953U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6953U);
                                    break;
                                case 57:
                                    this.f6954V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6954V);
                                    break;
                                case 58:
                                    this.f6955W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6955W);
                                    break;
                                case 59:
                                    this.f6956X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6956X);
                                    break;
                                default:
                                    switch (i10) {
                                        case 61:
                                            this.f6987w = b.f(typedArrayObtainStyledAttributes, index, this.f6987w);
                                            break;
                                        case 62:
                                            this.f6988x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6988x);
                                            break;
                                        case 63:
                                            this.f6989y = typedArrayObtainStyledAttributes.getFloat(index, this.f6989y);
                                            break;
                                        default:
                                            switch (i10) {
                                                case 69:
                                                    this.f6957Y = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.f6958Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.a0 = typedArrayObtainStyledAttributes.getInt(index, this.a0);
                                                    break;
                                                case 73:
                                                    this.f6961b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6961b0);
                                                    break;
                                                case 74:
                                                    this.f6967e0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.f6975i0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f6975i0);
                                                    break;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                    break;
                                                case 77:
                                                    this.f6969f0 = typedArrayObtainStyledAttributes.getString(index);
                                                    break;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.f6973h0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f6973h0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final SparseIntArray f6991e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f6995d;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f6991e = sparseIntArray;
            sparseIntArray.append(2, 1);
            sparseIntArray.append(4, 2);
            sparseIntArray.append(5, 3);
            sparseIntArray.append(1, 4);
            sparseIntArray.append(0, 5);
            sparseIntArray.append(3, 6);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.d.f1782f);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                switch (f6991e.get(index)) {
                    case 1:
                        this.f6995d = typedArrayObtainStyledAttributes.getFloat(index, this.f6995d);
                        break;
                    case 2:
                        this.f6993b = typedArrayObtainStyledAttributes.getInt(index, this.f6993b);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            String str = p180x.a.f22262a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f6992a = b.f(typedArrayObtainStyledAttributes, index, this.f6992a);
                        break;
                    case 6:
                        this.f6994c = typedArrayObtainStyledAttributes.getFloat(index, this.f6994c);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f6999d;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.d.f1784h);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 1) {
                    this.f6998c = typedArrayObtainStyledAttributes.getFloat(index, this.f6998c);
                } else if (index == 0) {
                    int i10 = typedArrayObtainStyledAttributes.getInt(index, this.f6996a);
                    this.f6996a = i10;
                    this.f6996a = b.f6922d[i10];
                } else if (index == 4) {
                    this.f6997b = typedArrayObtainStyledAttributes.getInt(index, this.f6997b);
                } else if (index == 3) {
                    this.f6999d = typedArrayObtainStyledAttributes.getFloat(index, this.f6999d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final SparseIntArray f7000m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7009i;
        public float j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f7010k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f7011l;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7000m = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.d.j);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                switch (f7000m.get(index)) {
                    case 1:
                        this.f7001a = typedArrayObtainStyledAttributes.getFloat(index, this.f7001a);
                        break;
                    case 2:
                        this.f7002b = typedArrayObtainStyledAttributes.getFloat(index, this.f7002b);
                        break;
                    case 3:
                        this.f7003c = typedArrayObtainStyledAttributes.getFloat(index, this.f7003c);
                        break;
                    case 4:
                        this.f7004d = typedArrayObtainStyledAttributes.getFloat(index, this.f7004d);
                        break;
                    case 5:
                        this.f7005e = typedArrayObtainStyledAttributes.getFloat(index, this.f7005e);
                        break;
                    case 6:
                        this.f7006f = typedArrayObtainStyledAttributes.getDimension(index, this.f7006f);
                        break;
                    case 7:
                        this.f7007g = typedArrayObtainStyledAttributes.getDimension(index, this.f7007g);
                        break;
                    case 8:
                        this.f7008h = typedArrayObtainStyledAttributes.getDimension(index, this.f7008h);
                        break;
                    case 9:
                        this.f7009i = typedArrayObtainStyledAttributes.getDimension(index, this.f7009i);
                        break;
                    case 10:
                        this.j = typedArrayObtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 11:
                        this.f7010k = true;
                        this.f7011l = typedArrayObtainStyledAttributes.getDimension(index, this.f7011l);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6923e = sparseIntArray;
        sparseIntArray.append(77, 25);
        sparseIntArray.append(78, 26);
        sparseIntArray.append(80, 29);
        sparseIntArray.append(81, 30);
        sparseIntArray.append(87, 36);
        sparseIntArray.append(86, 35);
        sparseIntArray.append(59, 4);
        sparseIntArray.append(58, 3);
        sparseIntArray.append(56, 1);
        sparseIntArray.append(95, 6);
        sparseIntArray.append(96, 7);
        sparseIntArray.append(66, 17);
        sparseIntArray.append(67, 18);
        sparseIntArray.append(68, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(82, 32);
        sparseIntArray.append(83, 33);
        sparseIntArray.append(65, 10);
        sparseIntArray.append(64, 9);
        sparseIntArray.append(99, 13);
        sparseIntArray.append(102, 16);
        sparseIntArray.append(100, 14);
        sparseIntArray.append(97, 11);
        sparseIntArray.append(101, 15);
        sparseIntArray.append(98, 12);
        sparseIntArray.append(90, 40);
        sparseIntArray.append(75, 39);
        sparseIntArray.append(74, 41);
        sparseIntArray.append(89, 42);
        sparseIntArray.append(73, 20);
        sparseIntArray.append(88, 37);
        sparseIntArray.append(63, 5);
        sparseIntArray.append(76, 82);
        sparseIntArray.append(85, 82);
        sparseIntArray.append(79, 82);
        sparseIntArray.append(57, 82);
        sparseIntArray.append(55, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(91, 54);
        sparseIntArray.append(69, 55);
        sparseIntArray.append(92, 56);
        sparseIntArray.append(70, 57);
        sparseIntArray.append(93, 58);
        sparseIntArray.append(71, 59);
        sparseIntArray.append(60, 61);
        sparseIntArray.append(62, 62);
        sparseIntArray.append(61, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(107, 65);
        sparseIntArray.append(34, 66);
        sparseIntArray.append(108, 67);
        sparseIntArray.append(104, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(103, 68);
        sparseIntArray.append(94, 69);
        sparseIntArray.append(72, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(105, 76);
        sparseIntArray.append(84, 77);
        sparseIntArray.append(109, 78);
        sparseIntArray.append(54, 80);
        sparseIntArray.append(53, 81);
    }

    public static int[] c(Barrier barrier, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i9 = 0;
        int i10 = 0;
        while (i9 < strArrSplit.length) {
            String strTrim = strArrSplit[i9].trim();
            Integer num = null;
            try {
                iIntValue = C.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (strTrim != null) {
                    HashMap<String, Integer> map = constraintLayout.f6817m;
                    if (map != null && map.containsKey(strTrim)) {
                        num = constraintLayout.f6817m.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (num != null && (num instanceof Integer)) {
                    iIntValue = num.intValue();
                }
            }
            iArr[i10] = iIntValue;
            i9++;
            i10++;
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public static a d(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C.d.f1777a);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            d dVar = aVar.f6928b;
            c cVar = aVar.f6929c;
            e eVar = aVar.f6931e;
            C0098b c0098b = aVar.f6930d;
            if (index != 1 && 23 != index && 24 != index) {
                cVar.getClass();
                c0098b.getClass();
                eVar.getClass();
            }
            SparseIntArray sparseIntArray = f6923e;
            switch (sparseIntArray.get(index)) {
                case 1:
                    c0098b.f6980o = f(typedArrayObtainStyledAttributes, index, c0098b.f6980o);
                    break;
                case 2:
                    c0098b.f6939F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6939F);
                    break;
                case 3:
                    c0098b.f6979n = f(typedArrayObtainStyledAttributes, index, c0098b.f6979n);
                    break;
                case 4:
                    c0098b.f6978m = f(typedArrayObtainStyledAttributes, index, c0098b.f6978m);
                    break;
                case 5:
                    c0098b.f6986v = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    c0098b.f6990z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0098b.f6990z);
                    break;
                case 7:
                    c0098b.f6934A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0098b.f6934A);
                    break;
                case 8:
                    c0098b.f6940G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6940G);
                    break;
                case 9:
                    c0098b.f6984s = f(typedArrayObtainStyledAttributes, index, c0098b.f6984s);
                    break;
                case 10:
                    c0098b.f6983r = f(typedArrayObtainStyledAttributes, index, c0098b.f6983r);
                    break;
                case 11:
                    c0098b.f6945L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6945L);
                    break;
                case 12:
                    c0098b.f6946M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6946M);
                    break;
                case 13:
                    c0098b.f6942I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6942I);
                    break;
                case 14:
                    c0098b.f6944K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6944K);
                    break;
                case 15:
                    c0098b.f6947N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6947N);
                    break;
                case 16:
                    c0098b.f6943J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6943J);
                    break;
                case 17:
                    c0098b.f6964d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0098b.f6964d);
                    break;
                case 18:
                    c0098b.f6966e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c0098b.f6966e);
                    break;
                case 19:
                    c0098b.f6968f = typedArrayObtainStyledAttributes.getFloat(index, c0098b.f6968f);
                    break;
                case 20:
                    c0098b.t = typedArrayObtainStyledAttributes.getFloat(index, c0098b.t);
                    break;
                case 21:
                    c0098b.f6962c = typedArrayObtainStyledAttributes.getLayoutDimension(index, c0098b.f6962c);
                    break;
                case 22:
                    int i10 = typedArrayObtainStyledAttributes.getInt(index, dVar.f6996a);
                    dVar.f6996a = i10;
                    dVar.f6996a = f6922d[i10];
                    break;
                case 23:
                    c0098b.f6960b = typedArrayObtainStyledAttributes.getLayoutDimension(index, c0098b.f6960b);
                    break;
                case 24:
                    c0098b.f6936C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6936C);
                    break;
                case 25:
                    c0098b.f6970g = f(typedArrayObtainStyledAttributes, index, c0098b.f6970g);
                    break;
                case 26:
                    c0098b.f6972h = f(typedArrayObtainStyledAttributes, index, c0098b.f6972h);
                    break;
                case 27:
                    c0098b.f6935B = typedArrayObtainStyledAttributes.getInt(index, c0098b.f6935B);
                    break;
                case 28:
                    c0098b.f6937D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6937D);
                    break;
                case 29:
                    c0098b.f6974i = f(typedArrayObtainStyledAttributes, index, c0098b.f6974i);
                    break;
                case 30:
                    c0098b.j = f(typedArrayObtainStyledAttributes, index, c0098b.j);
                    break;
                case 31:
                    c0098b.f6941H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6941H);
                    break;
                case 32:
                    c0098b.f6981p = f(typedArrayObtainStyledAttributes, index, c0098b.f6981p);
                    break;
                case 33:
                    c0098b.f6982q = f(typedArrayObtainStyledAttributes, index, c0098b.f6982q);
                    break;
                case 34:
                    c0098b.f6938E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6938E);
                    break;
                case 35:
                    c0098b.f6977l = f(typedArrayObtainStyledAttributes, index, c0098b.f6977l);
                    break;
                case 36:
                    c0098b.f6976k = f(typedArrayObtainStyledAttributes, index, c0098b.f6976k);
                    break;
                case 37:
                    c0098b.f6985u = typedArrayObtainStyledAttributes.getFloat(index, c0098b.f6985u);
                    break;
                case 38:
                    aVar.f6927a = typedArrayObtainStyledAttributes.getResourceId(index, aVar.f6927a);
                    break;
                case 39:
                    c0098b.f6948P = typedArrayObtainStyledAttributes.getFloat(index, c0098b.f6948P);
                    break;
                case 40:
                    c0098b.O = typedArrayObtainStyledAttributes.getFloat(index, c0098b.O);
                    break;
                case 41:
                    c0098b.f6949Q = typedArrayObtainStyledAttributes.getInt(index, c0098b.f6949Q);
                    break;
                case 42:
                    c0098b.f6950R = typedArrayObtainStyledAttributes.getInt(index, c0098b.f6950R);
                    break;
                case 43:
                    dVar.f6998c = typedArrayObtainStyledAttributes.getFloat(index, dVar.f6998c);
                    break;
                case 44:
                    eVar.f7010k = true;
                    eVar.f7011l = typedArrayObtainStyledAttributes.getDimension(index, eVar.f7011l);
                    break;
                case 45:
                    eVar.f7002b = typedArrayObtainStyledAttributes.getFloat(index, eVar.f7002b);
                    break;
                case 46:
                    eVar.f7003c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f7003c);
                    break;
                case 47:
                    eVar.f7004d = typedArrayObtainStyledAttributes.getFloat(index, eVar.f7004d);
                    break;
                case 48:
                    eVar.f7005e = typedArrayObtainStyledAttributes.getFloat(index, eVar.f7005e);
                    break;
                case 49:
                    eVar.f7006f = typedArrayObtainStyledAttributes.getDimension(index, eVar.f7006f);
                    break;
                case 50:
                    eVar.f7007g = typedArrayObtainStyledAttributes.getDimension(index, eVar.f7007g);
                    break;
                case 51:
                    eVar.f7008h = typedArrayObtainStyledAttributes.getDimension(index, eVar.f7008h);
                    break;
                case 52:
                    eVar.f7009i = typedArrayObtainStyledAttributes.getDimension(index, eVar.f7009i);
                    break;
                case 53:
                    eVar.j = typedArrayObtainStyledAttributes.getDimension(index, eVar.j);
                    break;
                case 54:
                    c0098b.f6951S = typedArrayObtainStyledAttributes.getInt(index, c0098b.f6951S);
                    break;
                case 55:
                    c0098b.f6952T = typedArrayObtainStyledAttributes.getInt(index, c0098b.f6952T);
                    break;
                case 56:
                    c0098b.f6953U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6953U);
                    break;
                case 57:
                    c0098b.f6954V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6954V);
                    break;
                case 58:
                    c0098b.f6955W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6955W);
                    break;
                case 59:
                    c0098b.f6956X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6956X);
                    break;
                case 60:
                    eVar.f7001a = typedArrayObtainStyledAttributes.getFloat(index, eVar.f7001a);
                    break;
                case 61:
                    c0098b.f6987w = f(typedArrayObtainStyledAttributes, index, c0098b.f6987w);
                    break;
                case 62:
                    c0098b.f6988x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6988x);
                    break;
                case 63:
                    c0098b.f6989y = typedArrayObtainStyledAttributes.getFloat(index, c0098b.f6989y);
                    break;
                case 64:
                    cVar.f6992a = f(typedArrayObtainStyledAttributes, index, cVar.f6992a);
                    break;
                case 65:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        cVar.getClass();
                    } else {
                        String str = p180x.a.f22262a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        cVar.getClass();
                    }
                    break;
                case 66:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    cVar.getClass();
                    break;
                case 67:
                    cVar.f6995d = typedArrayObtainStyledAttributes.getFloat(index, cVar.f6995d);
                    break;
                case 68:
                    dVar.f6999d = typedArrayObtainStyledAttributes.getFloat(index, dVar.f6999d);
                    break;
                case 69:
                    c0098b.f6957Y = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    c0098b.f6958Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0098b.a0 = typedArrayObtainStyledAttributes.getInt(index, c0098b.a0);
                    break;
                case 73:
                    c0098b.f6961b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c0098b.f6961b0);
                    break;
                case 74:
                    c0098b.f6967e0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 75:
                    c0098b.f6975i0 = typedArrayObtainStyledAttributes.getBoolean(index, c0098b.f6975i0);
                    break;
                case 76:
                    cVar.f6993b = typedArrayObtainStyledAttributes.getInt(index, cVar.f6993b);
                    break;
                case 77:
                    c0098b.f6969f0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 78:
                    dVar.f6997b = typedArrayObtainStyledAttributes.getInt(index, dVar.f6997b);
                    break;
                case 79:
                    cVar.f6994c = typedArrayObtainStyledAttributes.getFloat(index, cVar.f6994c);
                    break;
                case 80:
                    c0098b.f6971g0 = typedArrayObtainStyledAttributes.getBoolean(index, c0098b.f6971g0);
                    break;
                case 81:
                    c0098b.f6973h0 = typedArrayObtainStyledAttributes.getBoolean(index, c0098b.f6973h0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public static int f(TypedArray typedArray, int i9, int i10) {
        int resourceId = typedArray.getResourceId(i9, i10);
        return resourceId == -1 ? typedArray.getInt(i9, -1) : resourceId;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        int i9;
        int i10;
        HashSet hashSet;
        HashSet hashSet2;
        String resourceEntryName;
        b bVar = this;
        int i11 = 1;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map = bVar.f6926c;
        HashSet<Integer> hashSet3 = new HashSet(map.keySet());
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = constraintLayout.getChildAt(i12);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = GrsBaseInfo.CountryCodeSource.UNKNOWN;
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (bVar.f6925b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet3.remove(Integer.valueOf(id));
                        a aVar = map.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f6930d.f6963c0 = i11;
                        }
                        int i13 = aVar.f6930d.f6963c0;
                        if (i13 != -1 && i13 == i11) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            C0098b c0098b = aVar.f6930d;
                            barrier.setType(c0098b.a0);
                            barrier.setMargin(c0098b.f6961b0);
                            barrier.setAllowsGoneWidget(c0098b.f6975i0);
                            int[] iArr = c0098b.f6965d0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c0098b.f6967e0;
                                if (str != null) {
                                    int[] iArrC = c(barrier, str);
                                    c0098b.f6965d0 = iArrC;
                                    barrier.setReferencedIds(iArrC);
                                }
                            }
                        }
                        ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                        aVar2.a();
                        aVar.a(aVar2);
                        HashMap<String, androidx.constraintlayout.widget.a> map2 = aVar.f6932f;
                        Class<?> cls = childAt.getClass();
                        for (String str2 : map2.keySet()) {
                            int i14 = i11;
                            androidx.constraintlayout.widget.a aVar3 = map2.get(str2);
                            String strL = W5.e.l("set", str2);
                            int i15 = childCount;
                            try {
                                int iOrdinal = aVar3.f6908a.ordinal();
                                Class cls2 = Integer.TYPE;
                                Class cls3 = Float.TYPE;
                                switch (iOrdinal) {
                                    case 0:
                                        hashSet2 = hashSet3;
                                        cls.getMethod(strL, cls2).invoke(childAt, Integer.valueOf(aVar3.f6909b));
                                        break;
                                    case 1:
                                        hashSet2 = hashSet3;
                                        cls.getMethod(strL, cls3).invoke(childAt, Float.valueOf(aVar3.f6910c));
                                        break;
                                    case 2:
                                        hashSet2 = hashSet3;
                                        cls.getMethod(strL, cls2).invoke(childAt, Integer.valueOf(aVar3.f6913f));
                                        break;
                                    case 3:
                                        Method method = cls.getMethod(strL, Drawable.class);
                                        hashSet2 = hashSet3;
                                        try {
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(aVar3.f6913f);
                                            method.invoke(childAt, colorDrawable);
                                        } catch (IllegalAccessException e9) {
                                            e = e9;
                                            StringBuilder sbI = f.i(" Custom Attribute \"", str2, "\" not found on ");
                                            sbI.append(cls.getName());
                                            Log.e("TransitionLayout", sbI.toString());
                                            e.printStackTrace();
                                        } catch (NoSuchMethodException e10) {
                                            e = e10;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + strL);
                                        } catch (InvocationTargetException e11) {
                                            e = e11;
                                            StringBuilder sbI2 = f.i(" Custom Attribute \"", str2, "\" not found on ");
                                            sbI2.append(cls.getName());
                                            Log.e("TransitionLayout", sbI2.toString());
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 4:
                                        cls.getMethod(strL, CharSequence.class).invoke(childAt, aVar3.f6911d);
                                        hashSet2 = hashSet3;
                                        break;
                                    case 5:
                                        cls.getMethod(strL, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar3.f6912e));
                                        hashSet2 = hashSet3;
                                        break;
                                    case 6:
                                        cls.getMethod(strL, cls3).invoke(childAt, Float.valueOf(aVar3.f6910c));
                                        hashSet2 = hashSet3;
                                        break;
                                    default:
                                        hashSet2 = hashSet3;
                                        break;
                                }
                            } catch (IllegalAccessException e12) {
                                e = e12;
                                hashSet2 = hashSet3;
                            } catch (NoSuchMethodException e13) {
                                e = e13;
                                hashSet2 = hashSet3;
                            } catch (InvocationTargetException e14) {
                                e = e14;
                                hashSet2 = hashSet3;
                            }
                            i11 = i14;
                            childCount = i15;
                            hashSet3 = hashSet2;
                        }
                        i9 = i11;
                        i10 = childCount;
                        hashSet = hashSet3;
                        childAt.setLayoutParams(aVar2);
                        d dVar = aVar.f6928b;
                        if (dVar.f6997b == 0) {
                            childAt.setVisibility(dVar.f6996a);
                        }
                        childAt.setAlpha(dVar.f6998c);
                        e eVar = aVar.f6931e;
                        childAt.setRotation(eVar.f7001a);
                        childAt.setRotationX(eVar.f7002b);
                        childAt.setRotationY(eVar.f7003c);
                        childAt.setScaleX(eVar.f7004d);
                        childAt.setScaleY(eVar.f7005e);
                        if (!Float.isNaN(eVar.f7006f)) {
                            childAt.setPivotX(eVar.f7006f);
                        }
                        if (!Float.isNaN(eVar.f7007g)) {
                            childAt.setPivotY(eVar.f7007g);
                        }
                        childAt.setTranslationX(eVar.f7008h);
                        childAt.setTranslationY(eVar.f7009i);
                        childAt.setTranslationZ(eVar.j);
                        if (eVar.f7010k) {
                            childAt.setElevation(eVar.f7011l);
                        }
                    } else {
                        i9 = i11;
                        i10 = childCount;
                        hashSet = hashSet3;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i12++;
                bVar = this;
                i11 = i9;
                childCount = i10;
                hashSet3 = hashSet;
            }
            i9 = i11;
            i10 = childCount;
            hashSet = hashSet3;
            i12++;
            bVar = this;
            i11 = i9;
            childCount = i10;
            hashSet3 = hashSet;
        }
        int i16 = i11;
        for (Integer num : hashSet3) {
            a aVar4 = map.get(num);
            C0098b c0098b2 = aVar4.f6930d;
            int i17 = c0098b2.f6963c0;
            int i18 = i16;
            if (i17 != -1 && i17 == i18) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = c0098b2.f6965d0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = c0098b2.f6967e0;
                    if (str3 != null) {
                        int[] iArrC2 = c(barrier2, str3);
                        c0098b2.f6965d0 = iArrC2;
                        barrier2.setReferencedIds(iArrC2);
                    }
                }
                barrier2.setType(c0098b2.a0);
                barrier2.setMargin(c0098b2.f6961b0);
                int i19 = ConstraintLayout.f6805r;
                ConstraintLayout.a aVar5 = new ConstraintLayout.a();
                barrier2.k();
                aVar4.a(aVar5);
                constraintLayout.addView(barrier2, aVar5);
            }
            if (c0098b2.f6959a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                int i20 = ConstraintLayout.f6805r;
                ConstraintLayout.a aVar6 = new ConstraintLayout.a();
                aVar4.a(aVar6);
                constraintLayout.addView(guideline, aVar6);
            }
            i16 = i18;
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i9;
        b bVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map = bVar.f6926c;
        map.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (bVar.f6925b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new a());
            }
            a aVar2 = map.get(Integer.valueOf(id));
            HashMap<String, androidx.constraintlayout.widget.a> map2 = bVar.f6924a;
            HashMap<String, androidx.constraintlayout.widget.a> map3 = new HashMap<>();
            Class<?> cls = childAt.getClass();
            for (String str : map2.keySet()) {
                androidx.constraintlayout.widget.a aVar3 = map2.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        map3.put(str, new androidx.constraintlayout.widget.a(aVar3, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        i9 = childCount;
                    } else {
                        i9 = childCount;
                        try {
                            map3.put(str, new androidx.constraintlayout.widget.a(aVar3, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                        } catch (IllegalAccessException e9) {
                            e = e9;
                            e.printStackTrace();
                        } catch (NoSuchMethodException e10) {
                            e = e10;
                            e.printStackTrace();
                        } catch (InvocationTargetException e11) {
                            e = e11;
                            e.printStackTrace();
                        }
                    }
                } catch (IllegalAccessException e12) {
                    e = e12;
                    i9 = childCount;
                } catch (NoSuchMethodException e13) {
                    e = e13;
                    i9 = childCount;
                } catch (InvocationTargetException e14) {
                    e = e14;
                    i9 = childCount;
                }
                childCount = i9;
            }
            int i11 = childCount;
            aVar2.f6932f = map3;
            aVar2.b(id, aVar);
            int visibility = childAt.getVisibility();
            d dVar = aVar2.f6928b;
            dVar.f6996a = visibility;
            dVar.f6998c = childAt.getAlpha();
            float rotation = childAt.getRotation();
            e eVar = aVar2.f6931e;
            eVar.f7001a = rotation;
            eVar.f7002b = childAt.getRotationX();
            eVar.f7003c = childAt.getRotationY();
            eVar.f7004d = childAt.getScaleX();
            eVar.f7005e = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                eVar.f7006f = pivotX;
                eVar.f7007g = pivotY;
            }
            eVar.f7008h = childAt.getTranslationX();
            eVar.f7009i = childAt.getTranslationY();
            eVar.j = childAt.getTranslationZ();
            if (eVar.f7010k) {
                eVar.f7011l = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                boolean z8 = barrier.f6796k.f1186o0;
                C0098b c0098b = aVar2.f6930d;
                c0098b.f6975i0 = z8;
                c0098b.f6965d0 = barrier.getReferencedIds();
                c0098b.a0 = barrier.getType();
                c0098b.f6961b0 = barrier.getMargin();
            }
            i10++;
            bVar = this;
            childCount = i11;
        }
    }

    public final void e(Context context, int i9) {
        XmlResourceParser xml = context.getResources().getXml(i9);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarD = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarD.f6930d.f6959a = true;
                    }
                    this.f6926c.put(Integer.valueOf(aVarD.f6927a), aVarD);
                }
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }
}
