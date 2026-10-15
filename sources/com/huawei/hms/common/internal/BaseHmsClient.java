package com.huawei.hms.common.internal;

import W5.e;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.datastore.preferences.protobuf.C0524s;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f14931i = new Object();
    private static final AtomicInteger j = new AtomicInteger(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f14932k = new AtomicInteger(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static BinderAdapter f14933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static BinderAdapter f14934m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClientSettings f14937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile IAIDLInvoke f14938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConnectionCallbacks f14939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OnConnectionFailedListener f14940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f14941g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HuaweiApi.RequestHandler f14942h;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i9);
    }

    public static final class ConnectionResultWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HuaweiApi.RequestHandler f14947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConnectionResult f14948b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f14947a = requestHandler;
            this.f14948b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f14948b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f14947a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f14935a = context;
        this.f14937c = clientSettings;
        if (clientSettings != null) {
            this.f14936b = clientSettings.getAppID();
        }
        this.f14940f = onConnectionFailedListener;
        this.f14939e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i9) {
                onBinderFailed(i9, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f14939e == null || (BaseHmsClient.this.f14939e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f14939e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f14939e == null || (BaseHmsClient.this.f14939e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f14939e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i9, Intent intent) {
                if (intent == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f14938d = null;
                    return;
                }
                Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                if (activeActivity == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f14935a, 11, intent, 67108864)));
                    BaseHmsClient.this.f14938d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                long time = new Timestamp(System.currentTimeMillis()).getTime();
                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                    public void binderCallBack(int i10) {
                        if (i10 != 0) {
                            BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                            BaseHmsClient.this.f14938d = null;
                        }
                    }
                });
                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                activeActivity.startActivity(intent);
            }
        };
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f14937c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f14934m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f14933l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void f() {
        if (this.f14937c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f14934m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f14933l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i9) {
        a(i9, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f14938d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f14938d != null) {
            onConnecting();
        } else {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            e();
        }
    }

    public final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f14939e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i9 = (this.f14937c.isUseInnerHms() ? f14932k : j).get();
        e.o(i9, "Enter disconnect, Connection Status: ", "BaseHmsClient");
        if (i9 == 3) {
            f();
            b(1);
        } else {
            if (i9 != 5) {
                return;
            }
            b();
            b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f14937c.isUseInnerHms() + ", mInnerBinderAdapter:" + f14934m + ", mOuterBinderAdapter:" + f14933l);
        return this.f14937c.isUseInnerHms() ? f14934m : f14933l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f14937c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f14936b;
    }

    public ClientSettings getClientSettings() {
        return this.f14937c;
    }

    public int getConnectionStatus() {
        return (this.f14937c.isUseInnerHms() ? f14932k : j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f14935a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f14937c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f14937c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f14938d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f14935a);
        return this.f14937c.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f14937c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f14937c.isUseInnerHms()) {
            return f14932k.get() == 3;
        }
        return j.get() == 3;
    }

    public boolean isConnecting() {
        return (this.f14937c.isUseInnerHms() ? f14932k : j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f14942h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f14938d = iAIDLInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return HMSPackageManager.getInstance(this.f14935a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    public void b(int i9) {
        if (this.f14937c.isUseInnerHms()) {
            f14932k.set(i9);
        } else {
            j.set(i9);
        }
    }

    public void connect(int i9, boolean z8) {
        a(i9, z8);
    }

    private void b() {
        synchronized (f14931i) {
            try {
                Handler handler = this.f14941g;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.f14941g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        String innerHmsPkg = this.f14937c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f14937c.isUseInnerHms()) {
            f14934m = InnerBinderAdapter.getInstance(this.f14935a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                b(5);
                f14934m.binder(d());
                return;
            }
        }
        f14933l = OuterBinderAdapter.getInstance(this.f14935a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            b(5);
            f14933l.binder(d());
        }
    }

    private void b(AvailableAdapter availableAdapter, int i9) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f14935a, i9, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i10) {
                    if (i10 == 0 && BaseHmsClient.this.c()) {
                        BaseHmsClient.this.a();
                    } else {
                        BaseHmsClient.this.a(i10);
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i9, boolean z8) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61300303 ======");
        int i10 = (this.f14937c.isUseInnerHms() ? f14932k : j).get();
        e.o(i10, "Enter connect, Connection Status: ", "BaseHmsClient");
        if (z8 || !(i10 == 3 || i10 == 5)) {
            if (getMinApkVersion() > i9) {
                i9 = getMinApkVersion();
            }
            StringBuilder sbA = C0524s.a(i9, "connect minVersion:", " packageName:");
            sbA.append(this.f14937c.getInnerHmsPkg());
            HMSLog.i("BaseHmsClient", sbA.toString());
            if (this.f14935a.getPackageName().equals(this.f14937c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
                return;
            }
            if (Util.isAvailableLibExist(this.f14935a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i9);
                int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f14935a);
                e.o(iIsHuaweiMobileServicesAvailable, "check available result: ", "BaseHmsClient");
                if (iIsHuaweiMobileServicesAvailable == 0) {
                    a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, iIsHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(iIsHuaweiMobileServicesAvailable)) {
                        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        a(availableAdapter, iIsHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + iIsHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(iIsHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int iIsHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f14935a, i9);
            e.o(iIsHuaweiMobileServicesAvailable2, "HuaweiApiAvailability check available result: ", "BaseHmsClient");
            if (iIsHuaweiMobileServicesAvailable2 == 0) {
                a();
            } else {
                a(iIsHuaweiMobileServicesAvailable2);
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i9) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i9 == 29) {
                i9 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f14935a, i9, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i10) {
                        BaseHmsClient.this.a(i10);
                    }
                });
            } else {
                a(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i9) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i9);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f14942h, new ConnectionResult(i9));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f14940f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f14942h;
        this.f14942h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f14940f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
