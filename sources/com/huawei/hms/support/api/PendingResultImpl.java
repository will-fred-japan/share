package com.huawei.hms.support.api;

import W5.e;
import W5.f;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f15507a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<ApiClient> f15509c;
    protected DatagramTransport transport = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private R f15508b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15510d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15511e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15512f = true;

    public class a implements DatagramTransport.a {
        public a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i9, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i9, iMessageEntity);
            PendingResultImpl.this.f15507a.countDown();
        }
    }

    public class b implements DatagramTransport.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15514a;

        public b(AtomicBoolean atomicBoolean) {
            this.f15514a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i9, IMessageEntity iMessageEntity) {
            if (!this.f15514a.get()) {
                PendingResultImpl.this.a(i9, iMessageEntity);
            }
            PendingResultImpl.this.f15507a.countDown();
        }
    }

    public class c implements DatagramTransport.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f15516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResultCallback f15517b;

        public c(d dVar, ResultCallback resultCallback) {
            this.f15516a = dVar;
            this.f15517b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i9, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.a(i9, iMessageEntity);
            this.f15516a.a(this.f15517b, PendingResultImpl.this.f15508b);
        }
    }

    public static class d<R extends Result> extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void a(ResultCallback<? super R> resultCallback, R r8) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r8)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(ResultCallback<? super R> resultCallback, R r8) {
            resultCallback.onResult(r8);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Pair pair = (Pair) message.obj;
            b((ResultCallback) pair.first, (Result) pair.second);
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (R) awaitOnAnyThread();
        }
        HMSLog.e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f15509c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f15508b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f15508b;
        }
        if (this.f15512f) {
            a(0, 1);
        }
        this.transport.send(apiClient, new a());
        try {
            this.f15507a.await();
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
            a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f15508b;
    }

    public boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    public Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    public R onError(int i9) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r8 = (R) type2.newInstance();
                this.f15508b = r8;
                r8.setStatus(new Status(i9));
            } catch (Exception e9) {
                f.l(e9, new StringBuilder("on Error:"), "PendingResultImpl");
                return null;
            }
        }
        return this.f15508b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f15512f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    private void a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i9) {
        HMSLog.i("PendingResultImpl", "init uri:" + str);
        this.f15510d = str;
        if (apiClient == null) {
            HMSLog.e("PendingResultImpl", "client is null");
            return;
        }
        this.f15509c = new WeakReference<>(apiClient);
        this.f15507a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i9));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e9) {
            HMSLog.e("PendingResultImpl", "gen transport error:" + e9.getMessage());
            throw new IllegalStateException(A.f.h(e9, new StringBuilder("Instancing transport exception, ")), e9);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        d dVar = new d(looper);
        WeakReference<ApiClient> weakReference = this.f15509c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client is invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            dVar.a(resultCallback, this.f15508b);
        } else {
            if (this.f15512f) {
                a(0, 1);
            }
            this.transport.post(apiClient, new c(dVar, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        StringBuilder sbH = defpackage.f.h(j, "await timeout:", " unit:");
        sbH.append(timeUnit.toString());
        HMSLog.i("PendingResultImpl", sbH.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (R) awaitOnAnyThread(j, timeUnit);
        }
        HMSLog.i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        a(apiClient, str, iMessageEntity, cls, 0);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i9) {
        a(apiClient, str, iMessageEntity, getResponseType(), i9);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i9, IMessageEntity iMessageEntity) {
        Status status;
        e.o(i9, "setResult:", "PendingResultImpl");
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i9 == 0) {
            this.f15508b = (R) onComplete(iMessageEntity);
        } else {
            this.f15508b = (R) onError(i9);
        }
        if (this.f15512f) {
            a(i9, 2);
        }
        R r8 = this.f15508b;
        if (r8 == null || (status = r8.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            HMSLog.e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
            HMSLog.e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            return;
        }
        if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
            return;
        }
        HMSLog.i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
        this.f15508b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        StringBuilder sbH = defpackage.f.h(j, "awaitOnAnyThread timeout:", " unit:");
        sbH.append(timeUnit.toString());
        HMSLog.i("PendingResultImpl", sbH.toString());
        WeakReference<ApiClient> weakReference = this.f15509c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f15508b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f15508b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f15512f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new b(atomicBoolean));
        try {
            if (!this.f15507a.await(j, timeUnit)) {
                atomicBoolean.set(true);
                a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f15508b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    private void a(int i9, int i10) {
        SubAppInfo subAppInfo;
        HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.f15509c.get();
        if (apiClient != null && this.f15510d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap map = new HashMap();
            map.put("package", apiClient.getPackageName());
            map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
            if (i10 == 1) {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
            } else {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                map.put("result", String.valueOf(i9));
                R r8 = this.f15508b;
                if (r8 != null && r8.getStatus() != null) {
                    map.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.f15508b.getStatus().getStatusCode()));
                }
            }
            map.put("version", "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            map.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, appId);
            if (TextUtils.isEmpty(this.f15511e)) {
                String id = TransactionIdCreater.getId(appId, this.f15510d);
                this.f15511e = id;
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id);
            } else {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f15511e);
                this.f15511e = null;
            }
            String[] strArrSplit = this.f15510d.split("\\.");
            if (strArrSplit.length >= 2) {
                map.put("service", strArrSplit[0]);
                map.put("apiName", strArrSplit[1]);
            }
            map.put("callTime", String.valueOf(System.currentTimeMillis()));
            map.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, map);
            return;
        }
        HMSLog.e("PendingResultImpl", "<biReportEvent> has some error.");
    }
}
