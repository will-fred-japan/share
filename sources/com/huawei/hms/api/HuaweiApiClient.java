package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class HuaweiApiClient implements AidlApiClient {

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i9);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener);

    public void connect(int i9) {
        throw new UnsupportedOperationException();
    }

    public abstract void connect(Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity activity);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long j, TimeUnit timeUnit);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f14810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Scope> f14811b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<PermissionInfo> f14812c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<Api<?>, Api.ApiOptions> f14813d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private OnConnectionFailedListener f14814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ConnectionCallbacks f14815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f14816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Activity f14817h;

        public Builder(Context context) {
            Checker.checkNonNull(context, "context must not be null.");
            Context applicationContext = context.getApplicationContext();
            this.f14810a = applicationContext;
            this.f14816g = -1;
            ResourceLoaderUtil.setmContext(applicationContext);
            a(context);
        }

        private void a(Context context) {
            HMSBIInitializer.getInstance(context).initBI();
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.f14813d.put(api, null);
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                HiAnalyticsUtil.getInstance().onEvent(this.f14810a.getApplicationContext(), HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, HiAnalyticsConstant.REPORT_VAL_SEPARATOR + System.currentTimeMillis());
            }
            return this;
        }

        public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f14813d.put(api, null);
            this.f14811b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
            this.f14815f = connectionCallbacks;
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
            this.f14814e = onConnectionFailedListener;
            return this;
        }

        public Builder addScope(Scope scope) {
            Checker.checkNonNull(scope, "scope must not be null.");
            this.f14811b.add(scope);
            return this;
        }

        public Builder allowLifeCycleManagement(Activity activity, int i9, OnConnectionFailedListener onConnectionFailedListener) {
            if (i9 < 0) {
                throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
            }
            this.f14816g = i9;
            this.f14817h = (Activity) Preconditions.checkNotNull(activity, "activity must not be Null.");
            return this;
        }

        public HuaweiApiClient build() {
            addApi(new Api<>("Core.API"));
            HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.f14810a);
            huaweiApiClientImpl.setScopes(this.f14811b);
            huaweiApiClientImpl.setPermissionInfos(this.f14812c);
            huaweiApiClientImpl.setApiMap(this.f14813d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f14815f);
            huaweiApiClientImpl.setConnectionFailedListener(this.f14814e);
            huaweiApiClientImpl.setAutoLifecycleClientId(this.f14816g);
            if (this.f14816g >= 0) {
                a(huaweiApiClientImpl);
            }
            return huaweiApiClientImpl;
        }

        private void a(HuaweiApiClient huaweiApiClient) {
            AutoLifecycleFragment.getInstance(this.f14817h).startAutoMange(this.f14816g, huaweiApiClient);
        }

        public Builder allowLifeCycleManagement(Activity activity, OnConnectionFailedListener onConnectionFailedListener) {
            return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> api, O o2, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o2, "Null options are not permitted for this Api");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f14813d.put(api, o2);
            if (api.getOptions() != null) {
                this.f14811b.addAll(api.getOptions().getScopeList(o2));
                this.f14812c.addAll(api.getOptions().getPermissionInfoList(o2));
            }
            this.f14811b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o2) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o2, "Null options are not permitted for this Api");
            this.f14813d.put(api, o2);
            if (api.getOptions() != null) {
                this.f14811b.addAll(api.getOptions().getScopeList(o2));
                this.f14812c.addAll(api.getOptions().getPermissionInfoList(o2));
            }
            return this;
        }

        public Builder applyDefaultAccount() {
            return this;
        }

        public Builder setAccountName(String str) {
            return this;
        }

        public Builder setHandler(Handler handler) {
            return this;
        }

        public Builder setPopupsGravity(int i9) {
            return this;
        }

        public Builder setViewForPopups(View view) {
            return this;
        }
    }
}
