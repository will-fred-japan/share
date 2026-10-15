package W5;

import L5.n;
import U5.F;
import U5.v;
import Z5.A;
import Z5.w;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.datastore.preferences.protobuf.C0524s;
import cn.jiguang.commons.a.ee;
import cn.jpush.android.helper.Logger;
import com.alibaba.fastjson.parser.JSONScanner;
import com.google.android.material.textfield.TextInputLayout;
import com.google.crypto.tink.shaded.protobuf.C0576o;
import com.google.crypto.tink.shaded.protobuf.C0586z;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.huawei.hms.support.log.HMSLog;
import com.jieli.jl_bt_ota.interfaces.JieLiLibLoader;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.security.GeneralSecurityException;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements v.a, TextInputLayout.e, ObjectConstructor, JieLiLibLoader, p057h6.c, p164v0.g.InterfaceC0272g, p170v7.b.InterfaceC0274b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5065a;

    public /* synthetic */ f(int i9) {
        this.f5065a = i9;
    }

    public static int d(String str) throws NoSuchFieldException {
        String str2;
        for (int i9 : C0524s.c(2)) {
            if (i9 == 1) {
                str2 = "Brightness.light";
            } else {
                if (i9 != 2) {
                    throw null;
                }
                str2 = "Brightness.dark";
            }
            if (str2.equals(str)) {
                return i9;
            }
        }
        throw new NoSuchFieldException(e.l("No such Brightness: ", str));
    }

    public static int f(String str) throws NoSuchFieldException {
        String str2;
        for (int i9 : C0524s.c(3)) {
            if (i9 == 1) {
                str2 = "SystemSoundType.click";
            } else if (i9 == 2) {
                str2 = "SystemSoundType.tick";
            } else {
                if (i9 != 3) {
                    throw null;
                }
                str2 = "SystemSoundType.alert";
            }
            if (str2.equals(str)) {
                return i9;
            }
        }
        throw new NoSuchFieldException(e.l("No such SoundType: ", str));
    }

    public static /* synthetic */ int g(int i9) {
        switch (i9) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return OpusCodecConfig.APPLICATION_VOIP;
            case 13:
                return 4096;
            case 14:
                return 8192;
            case 15:
                return Http2.INITIAL_MAX_FRAME_SIZE;
            case 16:
                return 32768;
            case 17:
                return 65536;
            case 18:
                return 131072;
            case 19:
                return MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION;
            case 20:
                return MiPushSdk.FLAG_SUPPORT_CALLKIT;
            case 21:
                return 1048576;
            case 22:
                return 2097152;
            case 23:
                return 4194304;
            case 24:
                return 8388608;
            case 25:
                return Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            case 26:
                return 33554432;
            case 27:
                return 67108864;
            case 28:
                return 134217728;
            case 29:
                return 268435456;
            case 30:
                return 536870912;
            case 31:
                return 1073741824;
            case 32:
                return Integer.MIN_VALUE;
            default:
                throw null;
        }
    }

    public static char h(int i9, int i10, int i11, JSONScanner jSONScanner) {
        return jSONScanner.charAt(i9 + i10 + i11);
    }

    public static int i(int i9, int i10, int i11, int i12, int i13) {
        return Math.max(((i9 * i10) / i11) + i12, i13);
    }

    public static Bundle j(int i9, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i9);
        return bundle;
    }

    public static String k(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static void l(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        HMSLog.e(str, sb.toString());
    }

    public static void m(String str, String str2, Throwable th) {
        cn.jiguang.x.f.l(str2, str + th);
    }

    public static void n(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    public static void o(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        ee.e(str, sb.toString());
    }

    public static void p(Throwable th, StringBuilder sb, String str, Throwable th2) {
        sb.append(th.getMessage());
        ee.b(str, sb.toString(), th2);
    }

    public static void q(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        Logger.ww(str, sb.toString());
    }

    public static void r(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        Logger.w(str, sb.toString());
    }

    @Override // p170v7.b.InterfaceC0274b
    public boolean a(View view) {
        return view.hasFocus();
    }

    @Override // U5.v.a
    public n b(F f6) throws GeneralSecurityException {
        A a3 = f6.f4683b;
        if (!a3.J().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + a3.J());
        }
        try {
            w wVarL = w.L(a3.K(), C0576o.a());
            if (wVarL.J() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + wVarL.J());
            }
            V5.h.a aVarB = V5.h.b();
            aVarB.f4870a = Integer.valueOf(wVarL.H());
            aVarB.f4871b = Integer.valueOf(wVarL.I().I());
            aVarB.f4872c = (V5.h.b) g.f5067b.g(wVarL.I().H());
            aVarB.f4873d = (V5.h.c) g.f5066a.g(a3.I());
            return aVarB.a();
        } catch (C0586z e9) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e9);
        }
    }

    @Override // p057h6.c
    public p057h6.a c(Context context, p049g6.n nVar) {
        return new p057h6.f(context, nVar);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f5065a) {
            case 11:
                return ConstructorConstructor.lambda$newMapConstructor$14();
            case 12:
                return ConstructorConstructor.lambda$newMapConstructor$17();
            case 13:
                return ConstructorConstructor.lambda$newCollectionConstructor$10();
            default:
                return ConstructorConstructor.lambda$newCollectionConstructor$13();
        }
    }

    @Override // p164v0.g.InterfaceC0272g
    public void e(v0.g.f fVar, p164v0.g gVar, boolean z8) {
        switch (this.f5065a) {
            case 27:
                fVar.d(gVar);
                break;
            default:
                fVar.c();
                break;
        }
    }

    @Override // com.jieli.jl_bt_ota.interfaces.JieLiLibLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
