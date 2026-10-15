package B0;

import N6.C0344o;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.starburst.sdk.api.ITaskProcessStatusListener;
import com.starburst.sdk.core.auth.AuthApiImpl;
import com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback;
import com.starburst.sdk.core.auth.model.DeviceRegisterRespBean;
import com.starburst.sdk.core.model.FileTaskResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p056h5.C0598e;

/* JADX INFO: compiled from: WebViewProviderFactoryAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class T implements S, IDeviceRegisterCallback, ITaskProcessStatusListener, IUpgradeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1668b;

    public /* synthetic */ T(int i9) {
        this.f1667a = i9;
    }

    public static T b(Handler handler, Context context) {
        T t = new T(11);
        ArrayList arrayList = new ArrayList(3);
        t.f1668b = arrayList;
        if (p144s4.a.g(context)) {
            arrayList.add(new p118p4.c(handler, 15000L));
        }
        return t;
    }

    public static boolean j(int i9) {
        return (48 <= i9 && i9 <= 57) || i9 == 35 || i9 == 42;
    }

    @Override // B0.S
    public String[] a() {
        return ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getSupportedFeatures();
    }

    public C0598e c(int i9, int i10, long j) {
        p092m3.b bVar = (p092m3.b) this.f1668b;
        if (bVar != null) {
            return bVar.c(i9, i10, j);
        }
        return null;
    }

    @Override // B0.S
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) d8.a.a(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).createWebView(webView));
    }

    public void d() {
        switch (this.f1667a) {
            case 10:
                p092m3.b bVar = (p092m3.b) this.f1668b;
                if (bVar != null) {
                    bVar.d();
                }
                break;
            default:
                StringBuilder sb = new StringBuilder("[ScheduleTaskManager] execute, task size=");
                ArrayList<p118p4.a> arrayList = (ArrayList) this.f1668b;
                sb.append(arrayList.size());
                p142s2.j.d(sb.toString());
                for (p118p4.a aVar : arrayList) {
                    aVar.getClass();
                    aVar.f20789a.post(aVar);
                }
                break;
        }
    }

    public void e(int i9, String str, long j) {
        p092m3.b bVar = (p092m3.b) this.f1668b;
        if (bVar != null) {
            bVar.e(i9, str, j);
        }
    }

    public void f(int i9, p092m3.c cVar, int i10, p092m3.c cVar2, int i11, long j) {
        p092m3.b bVar = (p092m3.b) this.f1668b;
        if (bVar != null) {
            bVar.f(i9, cVar, i10, cVar2, i11, j);
        }
    }

    public void g(long j, byte[] bArr, int i9, int i10) {
        p092m3.b bVar = (p092m3.b) this.f1668b;
        if (bVar != null) {
            bVar.g(j, bArr, i9, i10);
        }
    }

    @Override // B0.S
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) d8.a.a(DropDataContentProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getDropDataProvider());
    }

    @Override // B0.S
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) d8.a.a(ProxyControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getProxyController());
    }

    @Override // B0.S
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) d8.a.a(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getStatics());
    }

    @Override // B0.S
    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) d8.a.a(TracingControllerBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getTracingController());
    }

    @Override // B0.S
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) d8.a.a(WebkitToCompatConverterBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f1668b).getWebkitToCompatConverter());
    }

    public void h(p092m3.c cVar, String str, int i9, long j) {
        p092m3.b bVar = (p092m3.b) this.f1668b;
        if (bVar != null) {
            bVar.h(cVar, str, i9, j);
        }
    }

    public boolean i() {
        HashMap map = (HashMap) this.f1668b;
        return (map == null || map.isEmpty() || TextUtils.isEmpty((CharSequence) map.get("process_name")) || TextUtils.isEmpty((CharSequence) map.get("crash_thread_name")) || TextUtils.isEmpty((CharSequence) map.get("pid")) || TextUtils.isEmpty((CharSequence) map.get("tid")) || TextUtils.isEmpty((CharSequence) map.get("start_time")) || TextUtils.isEmpty((CharSequence) map.get("crash_time")) || TextUtils.isEmpty((CharSequence) map.get("signal_line"))) ? false : true;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onCancelOTA() {
        p080k6.c cVar = (p080k6.c) this.f1668b;
        cVar.i("otaState", cVar.f19987g, y7.t.B(new p188x7.e("state", "cancel")));
    }

    @Override // com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback
    public void onDeviceRegisterFailed(String str) {
        com.starburst.sdk.utils.j.m(J6.b.f2695p, "auth.register cloud failed: msg=" + str);
        ((J6.b.f) this.f1668b).onFail(str);
    }

    @Override // com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback
    public void onDeviceRegisterSuccess(DeviceRegisterRespBean deviceRegisterRespBean) {
        String str = J6.b.f2695p;
        StringBuilder sb = new StringBuilder("auth.register cloud success: hasDeviceSecret=");
        sb.append((deviceRegisterRespBean == null || TextUtils.isEmpty(deviceRegisterRespBean.getDeviceSecret())) ? false : true);
        com.starburst.sdk.utils.j.m(str, sb.toString());
        com.starburst.sdk.utils.j.e("onRegisteredResult ==> " + deviceRegisterRespBean.toString());
        AuthApiImpl.deviceSecret = deviceRegisterRespBean.getDeviceSecret();
        ((J6.b.f) this.f1668b).onRegisterSuccess(deviceRegisterRespBean.getDeviceSecret());
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onError(BaseError baseError) {
        p080k6.c cVar = (p080k6.c) this.f1668b;
        String str = cVar.f19987g;
        Map mapB = y7.t.B(new p188x7.e("state", "error"));
        Map mapC = p080k6.c.c(cVar, baseError);
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapB);
        linkedHashMap.putAll(mapC);
        cVar.i("otaState", str, linkedHashMap);
        cVar.i("error", cVar.f19987g, p080k6.c.c(cVar, baseError));
    }

    @Override // com.starburst.sdk.api.ITaskProcessStatusListener
    public void onFailure(String taskId, String error) {
        kotlin.jvm.internal.k.e(taskId, "taskId");
        kotlin.jvm.internal.k.e(error, "error");
        C0344o.j((C0344o) this.f1668b, "fileTask.failure", 0, error, y7.t.B(new p188x7.e("taskId", taskId)), null, 18);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onNeedReconnect(String str, boolean z8) {
        p080k6.c cVar = (p080k6.c) this.f1668b;
        cVar.i("reconnectRequired", cVar.f19987g, y7.u.D(new p188x7.e("address", str), new p188x7.e("isNewWay", Boolean.valueOf(z8)), new p188x7.e("supportNewReconnectWay", Boolean.valueOf(cVar.f19990k))));
    }

    @Override // com.starburst.sdk.api.ITaskProcessStatusListener
    public void onProcessing(String taskId, int i9) {
        kotlin.jvm.internal.k.e(taskId, "taskId");
        C0344o.j((C0344o) this.f1668b, "fileTask.processing", i9, null, y7.t.B(new p188x7.e("taskId", taskId)), null, 20);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onProgress(int i9, float f6) {
        float fX = O7.k.X(f6, 0.0f, 100.0f) / 100.0f;
        p080k6.c cVar = (p080k6.c) this.f1668b;
        if (i9 == 0) {
            cVar.f19991l = true;
            fX /= 2.0f;
        } else if (cVar.f19991l) {
            fX = (fX / 2.0f) + 0.5f;
        }
        cVar.i("otaState", cVar.f19987g, y7.u.D(new p188x7.e("state", "progress"), new p188x7.e("upgradeType", Integer.valueOf(i9)), new p188x7.e("progress", Float.valueOf(fX))));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onStartOTA() {
        p080k6.c cVar = (p080k6.c) this.f1668b;
        cVar.f19991l = false;
        cVar.i("otaState", cVar.f19987g, y7.t.B(new p188x7.e("state", "start")));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onStopOTA() {
        p080k6.c cVar = (p080k6.c) this.f1668b;
        cVar.i("otaState", cVar.f19987g, y7.u.D(new p188x7.e("state", "success"), new p188x7.e("progress", 100)));
    }

    @Override // com.starburst.sdk.api.ITaskProcessStatusListener
    public void onSuccess(String taskId, FileTaskResult result) {
        kotlin.jvm.internal.k.e(taskId, "taskId");
        kotlin.jvm.internal.k.e(result, "result");
        p188x7.e eVar = new p188x7.e("taskId", taskId);
        C0344o c0344o = (C0344o) this.f1668b;
        p188x7.e eVar2 = new p188x7.e("code", Integer.valueOf(result.getCode()));
        p188x7.e eVar3 = new p188x7.e("message", result.getMsg());
        p188x7.e eVar4 = new p188x7.e("taskId", result.getTaskId());
        p188x7.e eVar5 = new p188x7.e("requestId", result.getRequestId());
        String str = "text";
        p188x7.e eVar6 = new p188x7.e("text", result.getText());
        p188x7.e eVar7 = new p188x7.e("summary", result.getSummary());
        List<FileTaskResult.AudioPiece> pieces = result.getPieces();
        ArrayList arrayList = new ArrayList(y7.i.E(pieces));
        Iterator it = pieces.iterator();
        while (it.hasNext()) {
            FileTaskResult.AudioPiece audioPiece = (FileTaskResult.AudioPiece) it.next();
            Iterator it2 = it;
            arrayList.add(y7.u.D(new p188x7.e(str, audioPiece.getText()), new p188x7.e("startTime", Long.valueOf(audioPiece.getStartTime())), new p188x7.e("endTime", Long.valueOf(audioPiece.getEndTime())), new p188x7.e("speaker", Integer.valueOf(audioPiece.getSpeaker()))));
            it = it2;
            str = str;
        }
        C0344o.j(c0344o, "fileTask.success", 0, null, y7.u.D(eVar, new p188x7.e("result", y7.u.D(eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, new p188x7.e("pieces", arrayList)))), null, 22);
    }

    public /* synthetic */ T(int i9, Object obj) {
        this.f1667a = i9;
        this.f1668b = obj;
    }

    public T() {
        this.f1667a = 6;
        this.f1668b = new AtomicInteger(0);
    }
}
