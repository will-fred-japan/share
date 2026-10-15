package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TOption f14886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f14887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractClientBuilder<?, TOption> f14888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SubAppInfo f14891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f14892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14893i;
    private int j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14894k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14895l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RequestManager f14897n;

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AnyClient f14902b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f14904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ResolveClientBean f14905e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<TaskApiCallbackWrapper> f14901a = new LinkedList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConnectionResult f14903c = null;

        public RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f14904d = huaweiApi;
            this.f14902b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f14902b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f14905e);
            this.f14905e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f14905e);
            this.f14905e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i9) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f14905e);
            this.f14905e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.a().getTaskApiCall().getTransactionId(), this);
            this.f14901a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f14904d).f14887c == null ? this.f14904d.getContext() : ((HuaweiApi) this.f14904d).f14887c).getPackageName();
            if (((HuaweiApi) this.f14904d).f14887c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f14904d;
                huaweiApi.b(((HuaweiApi) huaweiApi).f14887c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f14904d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f14904d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f14902b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f14904d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f14904d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f14902b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack callBackB = taskApiCallbackWrapper.b();
                    if (callBackB != null) {
                        callBackB.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f14901a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        private TaskApiCallbackWrapper b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private AtomicBoolean f14906a = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.a();
                        HMSLog.i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f14906a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f14904d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f14904d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f14902b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.f14901a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.f14901a.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.f14901a.clear();
            this.f14903c = null;
            this.f14902b.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ConnectionResult connectionResult) {
            this.f14903c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z8 = true;
            while (it.hasNext()) {
                TaskApiCallWrapper taskApiCallWrapperA = it.next().a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f14904d.getContext(), responseHeader, String.valueOf(this.f14904d.getKitSdkVersion()));
                if (this.f14903c.getResolution() != null && z8) {
                    responseHeader.setParcelable(this.f14903c.getResolution());
                    if (Util.isAvailableLibExist(this.f14904d.getContext()) && this.f14903c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z8 = false;
                }
                int errorCode = this.f14903c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                taskApiCallWrapperA.getTaskApiCall().onResponse(this.f14902b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f14901a.clear();
            this.f14903c = null;
            this.f14902b.disconnect();
        }

        public void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper taskApiCallbackWrapperB = b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f14904d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f14902b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f14904d).f14885a).getHmsVersionCode();
            if (hmsVersionCode < 40000000 && hmsVersionCode > 0 && this.f14902b.isConnected() && !((HuaweiApi) this.f14904d).f14896m && ((BaseHmsClient) this.f14902b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f14902b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f14902b.disconnect();
                }
            }
            if (this.f14902b.isConnected()) {
                HMSLog.i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.f14902b).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.f14902b).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(taskApiCallbackWrapperB);
                return;
            }
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(taskApiCallbackWrapperB);
            ConnectionResult connectionResult = this.f14903c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f14903c.getErrorCode());
                onConnectionFailed(this.f14903c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f14902b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), taskApiCallbackWrapperB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f14903c = null;
            this.f14901a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f14904d.getAppID(), str2) : str;
        }

        public synchronized void a(int i9, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f14902b.isConnected()) {
                HMSLog.d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f14902b.isConnecting()) {
                HMSLog.d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f14904d.getActivity() != null) {
                if (this.f14905e == null) {
                    this.f14905e = new ResolveClientBean(this.f14902b, i9);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f14905e)) {
                    HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f14905e);
            }
            this.f14902b.connect(i9);
        }

        public void a() {
            this.f14902b.disconnect();
        }

        private void a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper taskApiCallWrapperA = taskApiCallbackWrapper.a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
            taskApiCallWrapperA.getTaskApiCall().onResponse(this.f14902b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
        }

        private String a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f14904d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode == -1) {
                    return "get update result, but has other error codes";
                }
                if (errorCode == 3) {
                    return "HuaWei Mobile Service is disabled";
                }
                if (errorCode == 8) {
                    return "internal error";
                }
                if (errorCode == 10) {
                    return "application configuration error, please developer check configuration";
                }
                if (errorCode == 13) {
                    return "update cancelled";
                }
                if (errorCode != 21) {
                    switch (errorCode) {
                        case 25:
                            return "failed to get update result";
                        case 26:
                            return "update failed, because no activity incoming, can't pop update page";
                        case 27:
                            return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                        default:
                            return "unknown errorReason";
                    }
                }
                return "device is too old to be support";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 == -1) {
                return "get update result, but has other error codes";
            }
            if (errorCode2 != 8) {
                return errorCode2 != 10 ? "unknown errorReason" : "application configuration error, please developer check configuration";
            }
            return "internal error";
        }
    }

    public static class TaskApiCallbackWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TaskApiCallWrapper f14917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AnyClient.CallBack f14918b;

        public TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f14917a = taskApiCallWrapper;
            this.f14918b = callBack;
        }

        public TaskApiCallWrapper a() {
            return this.f14917a;
        }

        public AnyClient.CallBack b() {
            return this.f14918b;
        }
    }

    public static class a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f14919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskApiCallWrapper f14920b;

        public a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f14919a = huaweiApi;
            this.f14920b = taskApiCallWrapper;
        }

        private void a(RequestHandler requestHandler, Throwable th) {
            Throwable th2;
            AnyClient client;
            String string;
            ResponseHeader responseHeader;
            TaskCompletionSource taskCompletionSource;
            TaskApiCall taskApiCall = null;
            try {
                client = requestHandler.getClient();
                try {
                    responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, th.getMessage());
                    try {
                        string = new JSONObject().toString();
                        try {
                            taskCompletionSource = this.f14920b.getTaskCompletionSource();
                            try {
                                taskApiCall = this.f14920b.getTaskApiCall();
                            } catch (Throwable th3) {
                                th2 = th3;
                                HMSLog.e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            taskCompletionSource = null;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        string = null;
                        taskCompletionSource = null;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    string = null;
                    responseHeader = null;
                    taskCompletionSource = null;
                    HMSLog.e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                    if (client != null) {
                    }
                    HMSLog.e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
                }
            } catch (Throwable th7) {
                th2 = th7;
                client = null;
            }
            if (client != null || responseHeader == null || string == null || taskCompletionSource == null || taskApiCall == null) {
                HMSLog.e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
            } else {
                taskApiCall.onResponse(client, responseHeader, string, taskCompletionSource);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f14919a);
            try {
                requestHandler.a(this.f14920b);
            } catch (Throwable th) {
                HMSLog.e("HuaweiApi", "sendRequest has exception", th);
                a(requestHandler, th);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i9) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f14892h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i9, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f14894k = true;
        if (taskApiCall == null) {
            HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f14885a, taskApiCall.getUri(), TextUtils.isEmpty(this.f14891g.getSubAppID()) ? this.f14890f : this.f14891g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f14897n == null) {
            this.f14897n = RequestManager.getInstance();
        }
        return a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f14892h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.j;
    }

    public String getAppID() {
        return this.f14890f;
    }

    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f14888d.buildClient(this.f14885a, getClientSetting(), requestHandler, requestHandler);
    }

    public ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f14885a.getPackageName(), this.f14885a.getClass().getName(), getScopes(), this.f14889e, null, this.f14891g);
        if (!this.f14896m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f14885a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f14895l = hMSPackageNameForMultiService;
            HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f14895l);
        }
        clientSettings.setInnerHmsPkg(this.f14895l);
        clientSettings.setUseInnerHms(this.f14896m);
        WeakReference<Activity> weakReference = this.f14892h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f14885a;
    }

    public int getKitSdkVersion() {
        return this.f14893i;
    }

    public TOption getOption() {
        return this.f14886b;
    }

    public List<Scope> getScopes() {
        return Collections.EMPTY_LIST;
    }

    public String getSubAppID() {
        return this.f14891g.getSubAppID();
    }

    public void setApiLevel(int i9) {
        this.j = i9;
    }

    public void setHostContext(Context context) {
        this.f14887c = context;
    }

    public void setInnerHms() {
        this.f14895l = this.f14885a.getPackageName();
        this.f14896m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f14895l);
    }

    public void setKitSdkVersion(int i9) {
        this.f14893i = i9;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f14891g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f14889e)) {
            HMSLog.e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f14894k) {
            HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f14891g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        String appId = Util.getAppId(context);
        this.f14889e = appId;
        this.f14890f = appId;
    }

    private void a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i9, String str) {
        this.f14885a = context.getApplicationContext();
        this.f14886b = toption;
        this.f14888d = abstractClientBuilder;
        b(context);
        this.f14891g = new SubAppInfo("");
        this.f14893i = i9;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f14889e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.i("HuaweiApi", "subAppId is ".concat(str));
                this.f14891g = new SubAppInfo(str);
            }
        }
        a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i9, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f14892h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i9, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f14892h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i9) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i9, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e9) {
            HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e9.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i9, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i9, str);
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
