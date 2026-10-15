package com.huawei.hms.common.data;

/* JADX INFO: loaded from: classes.dex */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i9, int i10);

    void onDataRangeInserted(int i9, int i10);

    void onDataRangeMoved(int i9, int i10, int i11);

    void onDataRangeRemoved(int i9, int i10);
}
