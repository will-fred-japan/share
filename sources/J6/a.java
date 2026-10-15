package J6;

import D7.i;
import K7.p;
import Q4.InterfaceC0357m;
import U5.G;
import Z.InterfaceC0456h;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;
import com.starburst.sdk.api.IAuthInfoCallback;
import com.starburst.sdk.core.auth.api.IAuthInfoGetCallback;
import com.starburst.sdk.resp.AuthInfoRes;
import com.starburst.sdk.utils.j;
import io.flutter.plugin.platform.g;
import java.util.HashMap;
import p094m5.f;
import p154t7.s;
import p188x7.k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IAuthInfoCallback, InterfaceC0357m, InterfaceC0456h, g, V7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2691b;

    public /* synthetic */ a(int i9) {
        this.f2690a = i9;
    }

    public static a f(int i9) {
        return new a(5, p012b6.a.a(G.a(i9)));
    }

    @Override // Z.InterfaceC0456h
    public Object a(p pVar, i iVar) {
        return ((InterfaceC0456h) this.f2691b).a(new p015c0.b(pVar, null), iVar);
    }

    @Override // V7.d
    public Object c(V7.e eVar, B7.e eVar2) {
        Object objC = ((V7.d) this.f2691b).c(new s(eVar), eVar2);
        return objC == C7.a.f1806a ? objC : k.f22364a;
    }

    public void d() {
        synchronized (this) {
            ((p027d5.a) this.f2691b).getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Q4.InterfaceC0357m
    public void e(Object obj, Object obj2) {
        f fVar = (f) obj2;
        P4.a aVar = U4.c.f4664i;
        U4.a aVar2 = (U4.a) ((U4.d) obj).r();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar2.f18706b);
        int i9 = p041f5.c.f18707a;
        TelemetryData telemetryData = (TelemetryData) this.f2691b;
        if (telemetryData == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            telemetryData.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar2.f18705a.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            fVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // Z.InterfaceC0456h
    public V7.d getData() {
        return ((InterfaceC0456h) this.f2691b).getData();
    }

    @Override // com.starburst.sdk.api.IAuthInfoCallback
    public void onFailure(int i9, String str) {
        switch (this.f2690a) {
            case 0:
                j.x(b.f2695p, "refreshAuthInfoByPhoneIfAvailable failed, code=" + i9 + ", msg=" + str);
                b.b((b) this.f2691b);
                break;
            default:
                j.x(b.f2695p, "refreshAuthInfoByPhoneIfAvailable failed, code=" + i9 + ", msg=" + str);
                IAuthInfoGetCallback iAuthInfoGetCallback = (IAuthInfoGetCallback) this.f2691b;
                if (iAuthInfoGetCallback != null) {
                    iAuthInfoGetCallback.onLoadFailed();
                }
                break;
        }
    }

    @Override // com.starburst.sdk.api.IAuthInfoCallback
    public void onSuccess(AuthInfoRes authInfoRes) {
        switch (this.f2690a) {
            case 0:
                String str = b.f2695p;
                StringBuilder sb = new StringBuilder("refreshAuthInfoByPhoneIfAvailable success, expireTime=");
                sb.append(authInfoRes == null ? null : authInfoRes.getExpireTime());
                j.f(str, sb.toString());
                break;
            default:
                IAuthInfoGetCallback iAuthInfoGetCallback = (IAuthInfoGetCallback) this.f2691b;
                if (iAuthInfoGetCallback != null) {
                    iAuthInfoGetCallback.onAuthInfoLoad(authInfoRes);
                }
                break;
        }
    }

    public /* synthetic */ a(int i9, Object obj) {
        this.f2690a = i9;
        this.f2691b = obj;
    }

    public /* synthetic */ a(boolean z8) {
        this.f2690a = 12;
    }

    public a() {
        this.f2690a = 8;
        this.f2691b = new HashMap();
    }

    public a(p013b7.a aVar) {
        this.f2690a = 9;
        this.f2691b = new p096m7.b(aVar, "flutter/system", p096m7.f.f20494a, null);
    }
}
