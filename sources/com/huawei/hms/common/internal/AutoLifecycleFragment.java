package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* JADX INFO: loaded from: classes.dex */
public class AutoLifecycleFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f14927a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14928b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HuaweiApiClient f14929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f14930b;

        public a(int i9, HuaweiApiClient huaweiApiClient) {
            this.f14929a = huaweiApiClient;
            this.f14930b = i9;
        }

        public void a() {
            this.f14929a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e9) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e9);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14928b = true;
        for (int i9 = 0; i9 < this.f14927a.size(); i9++) {
            this.f14927a.valueAt(i9).f14929a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14928b = false;
        for (int i9 = 0; i9 < this.f14927a.size(); i9++) {
            this.f14927a.valueAt(i9).f14929a.disconnect();
        }
    }

    public void startAutoMange(int i9, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f14927a.indexOfKey(i9) < 0, "Already managing a HuaweiApiClient with this clientId: " + i9);
        this.f14927a.put(i9, new a(i9, huaweiApiClient));
        if (this.f14928b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i9) {
        a aVar = this.f14927a.get(i9);
        this.f14927a.remove(i9);
        if (aVar != null) {
            aVar.a();
        }
    }
}
