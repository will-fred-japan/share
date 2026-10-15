package com.starburst.sdk.business;

import com.google.gson.GsonBuilder;
import com.starburst.sdk.api.ITaskProcessStatusListener;
import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.common.okhttp.callback.Callback;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import com.starburst.sdk.core.auth.AliAgentImpl;
import com.starburst.sdk.core.auth.AuthInfoManager;
import com.starburst.sdk.core.auth.api.IAuthInfoGetCallback;
import com.starburst.sdk.core.model.FileTaskResult;
import com.starburst.sdk.core.network.NetworkConstants;
import com.starburst.sdk.resp.AuthInfoRes;
import com.starburst.sdk.utils.j;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class FileResultTaskPoller {
    private ITaskProcessStatusListener listener;
    private final String TAG = "FileResultTaskPoller";
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentHashMap<String, ScheduledFuture<?>> tasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> simpleQueryTasks = new ConcurrentHashMap<>();

    public static /* synthetic */ void addTask$default(FileResultTaskPoller fileResultTaskPoller, String str, boolean z8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z8 = false;
        }
        fileResultTaskPoller.addTask(str, z8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTask$lambda$0(FileResultTaskPoller this$0, String taskId) {
        k.e(this$0, "this$0");
        k.e(taskId, "$taskId");
        this$0.pollTaskStatus(taskId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResult(String str, FileTaskResult fileTaskResult) {
        int code = fileTaskResult.getCode();
        if (code == 200) {
            cancelTask(str);
            ITaskProcessStatusListener iTaskProcessStatusListener = this.listener;
            if (iTaskProcessStatusListener != null) {
                iTaskProcessStatusListener.onSuccess(str, fileTaskResult);
                return;
            }
            return;
        }
        if (code == 2000 || code == 2001) {
            ITaskProcessStatusListener iTaskProcessStatusListener2 = this.listener;
            if (iTaskProcessStatusListener2 != null) {
                iTaskProcessStatusListener2.onProcessing(str, fileTaskResult.getCode());
                return;
            }
            return;
        }
        cancelTask(str);
        ITaskProcessStatusListener iTaskProcessStatusListener3 = this.listener;
        if (iTaskProcessStatusListener3 != null) {
            iTaskProcessStatusListener3.onFailure(str, "Error code: " + fileTaskResult.getCode() + ", msg: " + fileTaskResult.getMsg());
        }
    }

    private final void pollTaskStatus(final String str) {
        AuthInfoManager.getAuthInfo(J6.c.f().g(), new IAuthInfoGetCallback() { // from class: com.starburst.sdk.business.FileResultTaskPoller.pollTaskStatus.1
            @Override // com.starburst.sdk.core.auth.api.IAuthInfoGetCallback
            public void onAuthInfoLoad(AuthInfoRes authInfoRes) throws JSONException {
                k.e(authInfoRes, "authInfoRes");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("taskId", str);
                RequestCall requestCallBuild = OkHttpUtils.postString().url(k.a(this.simpleQueryTasks.get(str), Boolean.TRUE) ? NetworkConstants.getAsrByFileQuerySimpleUrl() : NetworkConstants.getAsrByFileQueryUrl()).addHeader("appId", authInfoRes.getAppId()).addHeader("token", authInfoRes.getToken()).addHeader("productKey", authInfoRes.getProductKey()).addHeader("deviceName", authInfoRes.getDeviceName()).addHeader("timestamp", AliAgentImpl.sGetSignTimestamp).addHeader("sign", authInfoRes.getBusinessSign()).addHeader("signMethod", AuthInfoRes.DEFAULT_SIGN_METHOD).addPpeHeadersIfNeeded("file").content(jSONObject.toString()).mediaType(MediaType.Companion.parse("application/json; charset=utf-8")).build();
                final FileResultTaskPoller fileResultTaskPoller = this;
                final String str2 = str;
                requestCallBuild.execute(new Callback<Object>() { // from class: com.starburst.sdk.business.FileResultTaskPoller$pollTaskStatus$1$onAuthInfoLoad$1
                    @Override // com.starburst.sdk.common.okhttp.callback.Callback
                    public void onError(Call call, Exception exc, int i9) {
                        fileResultTaskPoller.cancelTask(str2);
                        ITaskProcessStatusListener iTaskProcessStatusListener = fileResultTaskPoller.listener;
                        if (iTaskProcessStatusListener != null) {
                            String str3 = str2;
                            StringBuilder sb = new StringBuilder("Error callback: ");
                            sb.append(exc != null ? exc.getMessage() : null);
                            iTaskProcessStatusListener.onFailure(str3, sb.toString());
                        }
                    }

                    @Override // com.starburst.sdk.common.okhttp.callback.Callback
                    public Object parseNetworkResponse(Response response, int i9) throws IOException {
                        String strString;
                        if (response != null) {
                            FileResultTaskPoller fileResultTaskPoller2 = fileResultTaskPoller;
                            String str3 = str2;
                            try {
                                j.f(fileResultTaskPoller2.TAG, "Response for taskId " + str3 + ": " + response);
                                if (!response.isSuccessful()) {
                                    ITaskProcessStatusListener iTaskProcessStatusListener = fileResultTaskPoller2.listener;
                                    if (iTaskProcessStatusListener != null) {
                                        iTaskProcessStatusListener.onFailure(str3, "HTTP error: " + response.code());
                                    }
                                    response.close();
                                    return null;
                                }
                                try {
                                    ResponseBody responseBodyBody = response.body();
                                    if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                                        strString = "";
                                    }
                                    FileTaskResult fileTaskResult = (FileTaskResult) new GsonBuilder().registerTypeAdapter(FileTaskResult.AudioPiece.class, new FileTaskResult.AudioPiece.Deserializer()).create().fromJson(strString, FileTaskResult.class);
                                    k.b(fileTaskResult);
                                    fileResultTaskPoller2.handleResult(str3, fileTaskResult);
                                    p188x7.k kVar = p188x7.k.f22364a;
                                } catch (Exception e9) {
                                    ITaskProcessStatusListener iTaskProcessStatusListener2 = fileResultTaskPoller2.listener;
                                    if (iTaskProcessStatusListener2 != null) {
                                        iTaskProcessStatusListener2.onFailure(str3, "Parse error: " + e9.getMessage());
                                        p188x7.k kVar2 = p188x7.k.f22364a;
                                    }
                                }
                                response.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    p199z2.b.r(response, th);
                                    throw th2;
                                }
                            }
                        }
                        return null;
                    }

                    @Override // com.starburst.sdk.common.okhttp.callback.Callback
                    public void onResponse(Object obj, int i9) {
                    }
                });
            }

            @Override // com.starburst.sdk.core.auth.api.IAuthInfoGetCallback
            public void onLoadFailed() {
                ITaskProcessStatusListener iTaskProcessStatusListener = this.listener;
                if (iTaskProcessStatusListener != null) {
                    iTaskProcessStatusListener.onFailure(str, "Error code: Auth info load failed");
                }
            }
        });
    }

    public final void addTask(String taskId, boolean z8) {
        k.e(taskId, "taskId");
        if (this.tasks.containsKey(taskId)) {
            return;
        }
        this.simpleQueryTasks.put(taskId, Boolean.valueOf(z8));
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.executor.scheduleWithFixedDelay(new A6.a(6, this, taskId), 0L, 5L, TimeUnit.SECONDS);
        ConcurrentHashMap<String, ScheduledFuture<?>> concurrentHashMap = this.tasks;
        k.b(scheduledFutureScheduleWithFixedDelay);
        concurrentHashMap.put(taskId, scheduledFutureScheduleWithFixedDelay);
    }

    public final void cancelTask(String taskId) {
        k.e(taskId, "taskId");
        ScheduledFuture<?> scheduledFuture = this.tasks.get(taskId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.tasks.remove(taskId);
        this.simpleQueryTasks.remove(taskId);
    }

    public final void removeAll() {
        Collection<ScheduledFuture<?>> collectionValues = this.tasks.values();
        k.d(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((ScheduledFuture) it.next()).cancel(true);
        }
        this.tasks.clear();
        this.simpleQueryTasks.clear();
    }

    public final void setListener(ITaskProcessStatusListener listener) {
        k.e(listener, "listener");
        this.listener = listener;
    }

    public final void shutdown() {
        this.executor.shutdownNow();
        this.tasks.clear();
    }
}
