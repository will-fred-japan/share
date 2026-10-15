package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class AgHmsUpdateState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f15590c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AgHmsUpdateState f15591d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HmsCheckedState f15592a = HmsCheckedState.UNCHECKED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15593b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f15591d == null) {
            synchronized (f15590c) {
                try {
                    if (f15591d == null) {
                        f15591d = new AgHmsUpdateState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15591d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f15592a;
    }

    public int getTargetVersionCode() {
        return this.f15593b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f15593b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() != HmsCheckedState.NEED_UPDATE) {
            return;
        }
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f15592a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i9) {
        this.f15593b = i9;
    }
}
