package com.starburst.sdk.common.okhttp.request;

import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.common.okhttp.callback.Callback;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class RequestCall {
    private Call call;
    private long callTimeOut;
    private OkHttpClient clone;
    private long connTimeOut;
    private OkHttpRequest okHttpRequest;
    private long readTimeOut;
    private Request request;
    private long writeTimeOut;

    public RequestCall(OkHttpRequest okHttpRequest) {
        this.okHttpRequest = okHttpRequest;
    }

    private Request generateRequest(Callback callback) {
        return this.okHttpRequest.generateRequest(callback);
    }

    public Call buildCall(Callback callback) {
        OkHttpClient okHttpClientBuild;
        this.request = generateRequest(callback);
        long j = this.readTimeOut;
        if (j > 0 || this.writeTimeOut > 0 || this.connTimeOut > 0 || this.callTimeOut > 0) {
            if (j <= 0) {
                j = 10000;
            }
            this.readTimeOut = j;
            long j8 = this.writeTimeOut;
            if (j8 <= 0) {
                j8 = 10000;
            }
            this.writeTimeOut = j8;
            long j9 = this.connTimeOut;
            if (j9 <= 0) {
                j9 = 10000;
            }
            this.connTimeOut = j9;
            long j10 = this.callTimeOut;
            this.callTimeOut = j10 > 0 ? j10 : 10000L;
            OkHttpClient.Builder builderNewBuilder = OkHttpUtils.getInstance().getOkHttpClient().newBuilder();
            long j11 = this.readTimeOut;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            okHttpClientBuild = builderNewBuilder.readTimeout(j11, timeUnit).writeTimeout(this.writeTimeOut, timeUnit).connectTimeout(this.connTimeOut, timeUnit).callTimeout(this.callTimeOut, timeUnit).build();
            this.clone = okHttpClientBuild;
        } else {
            okHttpClientBuild = OkHttpUtils.getInstance().getOkHttpClient();
        }
        this.call = okHttpClientBuild.newCall(this.request);
        return this.call;
    }

    public RequestCall callTimeOut(long j) {
        this.callTimeOut = j;
        return this;
    }

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    public RequestCall connTimeOut(long j) {
        this.connTimeOut = j;
        return this;
    }

    public Response execute() {
        buildCall(null);
        return this.call.execute();
    }

    public Call getCall() {
        return this.call;
    }

    public OkHttpRequest getOkHttpRequest() {
        return this.okHttpRequest;
    }

    public Request getRequest() {
        return this.request;
    }

    public RequestCall readTimeOut(long j) {
        this.readTimeOut = j;
        return this;
    }

    public RequestCall writeTimeOut(long j) {
        this.writeTimeOut = j;
        return this;
    }

    public void execute(Callback callback) {
        buildCall(callback);
        if (callback != null) {
            callback.onBefore(this.request, getOkHttpRequest().getId());
        }
        OkHttpUtils.getInstance().execute(this, callback);
    }
}
