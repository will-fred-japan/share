package A6;

import N6.C0344o;
import Q4.Y;
import V7.j;
import Z.C0461m;
import android.app.AlertDialog;
import com.lzf.easyfloat.data.FloatConfig;
import com.starburst.sdk.api.ISplitRequestCallback;
import com.starburst.sdk.req.AsrSse;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import y7.q;
import y7.u;

/* JADX INFO: compiled from: FloatingWindowManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ISplitRequestCallback, V7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1504b;

    public e(Y y8, AlertDialog alertDialog) {
        this.f1504b = y8;
        this.f1503a = alertDialog;
    }

    public void a(boolean z8) {
        if (z8) {
            ConcurrentHashMap<String, c> concurrentHashMap = f.f1505a;
            ConcurrentHashMap<String, c> concurrentHashMap2 = f.f1505a;
            String floatTag = ((FloatConfig) this.f1503a).getFloatTag();
            k.b(floatTag);
            concurrentHashMap2.put(floatTag, (c) this.f1504b);
        }
    }

    @Override // V7.d
    public Object c(V7.e eVar, B7.e eVar2) {
        Object objC = ((V7.k) this.f1503a).c(new j(new v(), eVar, (C0461m.c) this.f1504b), eVar2);
        return objC == C7.a.f1806a ? objC : p188x7.k.f22364a;
    }

    @Override // com.starburst.sdk.api.ISplitRequestCallback
    public void onClose() {
        C0344o.j((C0344o) this.f1503a, ((String) this.f1504b).concat(".close"), 0, null, null, null, 30);
    }

    @Override // com.starburst.sdk.api.ISplitRequestCallback
    public void onError(int i9, String str) {
        String strConcat = ((String) this.f1504b).concat(".error");
        if (str == null) {
            str = "";
        }
        C0344o.j((C0344o) this.f1503a, strConcat, i9, str, null, null, 24);
    }

    @Override // com.starburst.sdk.api.ISplitRequestCallback
    public void onResult(AsrSse asrSse) {
        String strConcat = ((String) this.f1504b).concat(".result");
        ((C0344o) this.f1503a).getClass();
        C0344o.j((C0344o) this.f1503a, strConcat, 0, null, asrSse == null ? q.f22409a : u.D(new p188x7.e("code", Integer.valueOf(asrSse.getCode())), new p188x7.e("message", asrSse.getMsg()), new p188x7.e("failReason", asrSse.getFailReason()), new p188x7.e("requestId", asrSse.getRequestId()), new p188x7.e("llmResponse", asrSse.getLlmResponse()), new p188x7.e("complete", Boolean.valueOf(asrSse.isComplete())), new p188x7.e("contextId", asrSse.getContextId()), new p188x7.e("inputToken", Integer.valueOf(asrSse.getInputToken())), new p188x7.e("outputToken", Integer.valueOf(asrSse.getOutputToken()))), null, 22);
    }

    @Override // com.starburst.sdk.api.ISplitRequestCallback
    public void onError(String str) {
        String strConcat = ((String) this.f1504b).concat(".error");
        if (str == null) {
            str = "";
        }
        C0344o.j((C0344o) this.f1503a, strConcat, 0, str, null, null, 26);
    }

    public /* synthetic */ e(Object obj, Object obj2) {
        this.f1503a = obj;
        this.f1504b = obj2;
    }
}
